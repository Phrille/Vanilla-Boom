package phrille.vanillaboom.inventory;

import com.google.common.collect.Lists;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.inventory.recipe.ModRecipes;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;
import phrille.vanillaboom.util.ModTags;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class EaselMenu extends AbstractContainerMenu {
    public static final int DYE_SLOT_START = 0;
    public static final int DYE_SLOT_END = 6;
    public static final int CANVAS_SLOT = 7;
    public static final int RESULT_SLOT = 8;

    private final ContainerLevelAccess access;
    private final Level level;
    private long lastSoundTime;

    /* Input */
    private Runnable slotUpdateListener = () -> {
    };
    private final List<Slot> dyeSlots = Lists.newArrayList();
    private final List<ItemStack> dyeStacks = Lists.newArrayList();
    private final Slot canvasSlot;
    private ItemStack canvasStack = ItemStack.EMPTY;
    private final Container inputContainer = new SimpleContainer(CANVAS_SLOT + 1) {
        public void setChanged() {
            super.setChanged();
            EaselMenu.this.slotsChanged(this);
            EaselMenu.this.slotUpdateListener.run();
        }
    };

    /* Result */
    private final Slot resultSlot;
    private final ResultContainer resultContainer = new ResultContainer();

    /* Recipe list */
    private List<PaintingRecipe> recipes = Lists.newArrayList();
    private final DataSlot selectedPaintingIndex = DataSlot.standalone();

    public EaselMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public EaselMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
        super(ModMenuTypes.EASEL_MENU.get(), containerId);
        this.access = access;
        level = inventory.player.getLevel();

        for (int i = DYE_SLOT_START; i < DYE_SLOT_END + 1; i++) {
            dyeSlots.add(i, addSlot(new Slot(inputContainer, i, 8 + (i % 2) * 18, 16 + (i / 2) * 18) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return stack.is(Tags.Items.DYES);
                }
            }));
            dyeStacks.add(i, ItemStack.EMPTY);
        }

        canvasSlot = addSlot(new Slot(inputContainer, CANVAS_SLOT, 26, 70) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModTags.ForgeTags.Items.CANVAS);
            }
        });

        resultSlot = addSlot(new Slot(resultContainer, RESULT_SLOT - inputContainer.getContainerSize(), 147, 42) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level, player, stack.getCount());
                PaintingRecipe recipe = Objects.requireNonNull((PaintingRecipe) EaselMenu.this.resultContainer.getRecipeUsed());

                for (Ingredient ingredient : recipe.getIngredients()) {
                    boolean success = false;
                    for (int i = 0; i < EaselMenu.this.inputContainer.getContainerSize(); i++) {
                        ItemStack ingredientStack = EaselMenu.this.inputContainer.getItem(i);
                        if (ingredient.test(ingredientStack)) {
                            ingredientStack.shrink(1);
                            success = true;
                            break;
                        }
                    }
                    if (!success) {
                        throw new IllegalStateException("Missing expected ingredient in EaselMenu inputContainer!");
                    }
                }

                EaselMenu.this.resultContainer.awardUsedRecipes(player);
                if (!EaselMenu.this.canvasSlot.hasItem()) {
                    EaselMenu.this.selectedPaintingIndex.set(-1);
                } else {
                    EaselMenu.this.setupRecipeList(EaselMenu.this.inputContainer);
                    EaselMenu.this.setupResultSlot();
                }

                access.execute((level, pos) -> {
                    long l = level.getGameTime();
                    if (EaselMenu.this.lastSoundTime != l) {
                        level.playSound(null, pos, SoundEvents.UI_LOOM_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        EaselMenu.this.lastSoundTime = l;
                    }
                });
                super.onTake(player, stack);
            }
        });

        for (int invRow = 0; invRow < 3; ++invRow) {
            for (int invCol = 0; invCol < 9; ++invCol) {
                this.addSlot(new Slot(inventory, invCol + invRow * 9 + 9, 8 + invCol * 18, 102 + invRow * 18));
            }
        }

        for (int hotBar = 0; hotBar < 9; ++hotBar) {
            this.addSlot(new Slot(inventory, hotBar, 8 + hotBar * 18, 160));
        }

        addDataSlot(selectedPaintingIndex);
        selectedPaintingIndex.set(-1);
    }

    @Override
    public boolean clickMenuButton(Player player, int index) {
        if (isValidPaintingIndex(index)) {
            selectedPaintingIndex.set(index);
            setupResultSlot();
        }

        return true;
    }

    @Override
    public void slotsChanged(Container container) {
        ItemStack canvas = canvasSlot.getItem();

        if (!canvas.is(canvasStack.getItem())) {
            canvasStack = canvas.copy();

            if (canvas.isEmpty()) {
                recipes.clear();
                resultSlot.set(ItemStack.EMPTY);
                selectedPaintingIndex.set(-1);
            } else {
                setupRecipeList(container);
            }
        } else if (dyeStacksChanged()) {
            setupRecipeList(container);
        }
    }

    private void setupRecipeList(Container container) {
        recipes.clear();
        recipes = level.getRecipeManager().getRecipesFor(ModRecipes.PAINTING.get(), container, level);
        // Badness? Hacky way to ensure same hashCode for recipes on server and client.
        recipes.sort(Comparator.comparing(PaintingRecipe::recipeId));

        if (recipes.isEmpty()) {
            resultSlot.set(ItemStack.EMPTY);
            selectedPaintingIndex.set(-1);
        }
    }

    private void setupResultSlot() {
        if (!recipes.isEmpty() && isValidPaintingIndex(selectedPaintingIndex.get())) {
            PaintingRecipe recipe = recipes.get(selectedPaintingIndex.get());
            ItemStack result = recipe.assemble(inputContainer, level.registryAccess());
            if (result.isItemEnabled(level.enabledFeatures())) {
                resultContainer.setRecipeUsed(recipe);
                resultSlot.set(result);
            } else {
                resultSlot.set(ItemStack.EMPTY);
            }
        } else {
            resultSlot.set(ItemStack.EMPTY);
        }

        broadcastChanges();
    }

    @Override
    // TODO: quick move logic
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, ModBlocks.EASEL.get());
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        resultContainer.removeItemNoUpdate(1);
        access.execute((remover, container) -> clearContainer(player, inputContainer));
    }

    public List<PaintingRecipe> getRecipes() {
        return recipes;
    }

    public List<PaintingRecipe> getAllRecipes() {
        return level.getRecipeManager().getAllRecipesFor(ModRecipes.PAINTING.get());
    }

    public boolean isValidPaintingIndex(int index) {
        return index >= 0 && index < recipes.size();
    }

    public void registerUpdateListener(Runnable updateListener) {
        slotUpdateListener = updateListener;
    }

    public List<Slot> getDyeSlots() {
        return dyeSlots;
    }

    public Slot getCanvasSlot() {
        return canvasSlot;
    }

    private boolean dyeStacksChanged() {
        List<ItemStack> changedStacks = dyeSlots.stream().map(Slot::getItem).toList();
        boolean flag = false;
        for (int i = DYE_SLOT_START; i < DYE_SLOT_END + 1; i++) {
            ItemStack stack = changedStacks.get(i);
            if (!stack.is(dyeStacks.get(i).getItem())) {
                flag = true;
                break;
            } else if (dyeStacks.get(i).getCount() != stack.getCount()) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int i = DYE_SLOT_START; i < DYE_SLOT_END + 1; i++) {
                dyeStacks.set(i, changedStacks.get(i).copy());
            }
        }

        return flag;
    }
}
