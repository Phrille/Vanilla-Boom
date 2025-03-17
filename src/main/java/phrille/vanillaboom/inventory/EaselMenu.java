package phrille.vanillaboom.inventory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.inventory.recipe.ModRecipes;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;
import phrille.vanillaboom.network.EaselRecipePacket;
import phrille.vanillaboom.util.ModTags;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
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
    private final Player player;
    private final Level level;
    private long lastSoundTime;

    /* Input */
    private Runnable slotUpdateListener = () -> {
    };
    private final List<Slot> dyeSlots = Lists.newArrayList();
    private final Slot canvasSlot;
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
    private final ImmutableList<PaintingRecipe> recipes;
    private List<PaintingRecipe> availableRecipes = Lists.newArrayList();
    @Nullable
    private PaintingRecipe currentRecipe;
    private final DataSlot selectedPaintingIndex = DataSlot.standalone();

    public EaselMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public EaselMenu(int containerId, Inventory inventory, ContainerLevelAccess levelAccess) {
        super(ModMenuTypes.EASEL_MENU.get(), containerId);
        access = levelAccess;
        player = inventory.player;
        level = player.getLevel();

        // Dye slots
        for (int i = DYE_SLOT_START; i < DYE_SLOT_END + 1; i++) {
            dyeSlots.add(i, addSlot(new Slot(inputContainer, i, 8 + (i % 2) * 18, 16 + (i / 2) * 18)));
        }

        // Canvas slot
        canvasSlot = addSlot(new Slot(inputContainer, CANVAS_SLOT, 26, 70));

        // Result slot
        resultSlot = addSlot(new Slot(resultContainer, RESULT_SLOT - inputContainer.getContainerSize(), 147, 43) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level, player, stack.getCount());
                EaselMenu.this.resultContainer.awardUsedRecipes(player);

                // Remove items used in the recipe
                PaintingRecipe recipe = Objects.requireNonNull(EaselMenu.this.currentRecipe, "No currentRecipe set in the EaselMenu resultContainer!");
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

                // Check if a new recipe can be matched
                if (recipe.matches(EaselMenu.this.inputContainer, player.level)) {
                    EaselMenu.this.setupResultSlot();
                } else {
                    EaselMenu.this.currentRecipe = null;
                    EaselMenu.this.inputContainer.setChanged();
                    EaselMenu.this.broadcastChanges();
                }

                // Play sound
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

        // Inventory slots
        for (int invRow = 0; invRow < 3; ++invRow) {
            for (int invCol = 0; invCol < 9; ++invCol) {
                this.addSlot(new Slot(inventory, invCol + invRow * 9 + 9, 8 + invCol * 18, 102 + invRow * 18));
            }
        }

        // Hotbar slots
        for (int hotBar = 0; hotBar < 9; ++hotBar) {
            this.addSlot(new Slot(inventory, hotBar, 8 + hotBar * 18, 160));
        }

        // Recipe list. Note: storing the sorted list guarantees parity between client and server
        // which allows correct indexing of buttons in the EaselScreen class.
        recipes = ImmutableList.copyOf(level.getRecipeManager().getAllRecipesFor(ModRecipes.PAINTING.get())
                .stream()
                .sorted(PaintingRecipe.RECIPE_COMPARATOR)
                .toList());
        addDataSlot(selectedPaintingIndex);
    }

    @Override
    public boolean clickMenuButton(Player player, int index) {
        if (index >= 0 && index < recipes.size()) {
            PaintingRecipe clicked = recipes.get(index);
            if (availableRecipes.contains(clicked)) {
                selectedPaintingIndex.set(availableRecipes.indexOf(clicked));
                setupResultSlot();
            }
        }

        return true;
    }

    @Override
    public void slotsChanged(Container container) {
        if (currentRecipe != null) {
            if (!currentRecipe.matches(container, level)) {
                setupRecipeList(container);
            }
        } else {
            setupRecipeList(container);
        }
    }

    private void setupRecipeList(Container container) {
        currentRecipe = null;
        availableRecipes.clear();
        availableRecipes = level.getRecipeManager().getRecipesFor(ModRecipes.PAINTING.get(), container, level);
        selectedPaintingIndex.set(-1);
        resultSlot.set(ItemStack.EMPTY);
        EaselRecipePacket.send(player, availableRecipes);
    }

    private void setupResultSlot() {
        if (!availableRecipes.isEmpty() && isValidPaintingIndex(selectedPaintingIndex.get())) {
            PaintingRecipe recipe = availableRecipes.get(selectedPaintingIndex.get());
            ItemStack result = recipe.assemble(inputContainer, level.registryAccess());
            if (result.isItemEnabled(level.enabledFeatures())) {
                currentRecipe = recipe;
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
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack stackInSlot = slot.getItem();
        Item item = stackInSlot.getItem();
        ItemStack copy = stackInSlot.copy();

        if (index == RESULT_SLOT) {
            item.onCraftedBy(stackInSlot, player.level, player);
            if (!moveItemStackTo(stackInSlot, RESULT_SLOT + 1, slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            slot.onQuickCraft(stackInSlot, copy);
        } else if (index >= DYE_SLOT_START && index <= CANVAS_SLOT) {
            if (!moveItemStackTo(stackInSlot, RESULT_SLOT + 1, slots.size(), true)) {
                return ItemStack.EMPTY;
            }
        } else if (index > RESULT_SLOT) {
            if (stackInSlot.is(Tags.Items.DYES)) {
                if (!moveItemStackTo(stackInSlot, DYE_SLOT_START, DYE_SLOT_END + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (stackInSlot.is(ModTags.ForgeTags.Items.CANVAS)) {
                if (!moveItemStackTo(stackInSlot, CANVAS_SLOT, CANVAS_SLOT + 1, false)) {
                    return ItemStack.EMPTY;
                }
            }
        }

        if (stackInSlot.isEmpty()) {
            slot.setByPlayer(ItemStack.EMPTY);
        }

        slot.setChanged();
        if (stackInSlot.getCount() == copy.getCount()) {
            return ItemStack.EMPTY;
        }

        slot.onTake(player, stackInSlot);
        broadcastChanges();
        return copy;
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

    public boolean isValidPaintingIndex(int index) {
        return index >= 0 && index < availableRecipes.size();
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
}
