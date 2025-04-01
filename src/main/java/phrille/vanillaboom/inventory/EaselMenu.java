/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.network.PacketDistributor;
import phrille.vanillaboom.block.entity.EaselBlockEntity;
import phrille.vanillaboom.crafting.EaselRecipeInput;
import phrille.vanillaboom.crafting.ModRecipes;
import phrille.vanillaboom.crafting.PaintingRecipe;
import phrille.vanillaboom.network.EaselRecipePacket;
import phrille.vanillaboom.util.CommonTags;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class EaselMenu extends AbstractContainerMenu implements ContainerListener {
    private final Player player;
    private final ContainerLevelAccess access;
    private long lastSoundTime;

    private final Container container;
    private final ContainerData containerData;
    private final ResultContainer resultContainer = new ResultContainer();

    private final List<Slot> dyeSlots = Lists.newArrayList();
    private Slot canvasSlot;
    private Slot resultSlot;

    private ImmutableList<RecipeHolder<PaintingRecipe>> recipeList;
    @Nullable
    private RecipeHolder<PaintingRecipe> currentRecipe;

    public EaselMenu(int containerId, Inventory inventory) {
        super(ModMenuTypes.EASEL_MENU.get(), containerId);
        player = inventory.player;
        access = ContainerLevelAccess.NULL;
        container = new SimpleContainer(8);
        containerData = new SimpleContainerData(1);
        generateAllRecipes();
        addSlots(inventory);
    }

    public EaselMenu(int containerId, Inventory inventory, Container easelContainer, ContainerData easelData, ContainerLevelAccess levelAccess) {
        super(ModMenuTypes.EASEL_MENU.get(), containerId);
        player = inventory.player;
        access = levelAccess;
        container = easelContainer;
        containerData = easelData;
        generateAllRecipes();
        container.startOpen(player);
        addSlots(inventory);
        addSlotListener(this);
    }

    protected void addSlots(Inventory inventory) {
        for (int i = EaselBlockEntity.DYE_SLOT_START; i < EaselBlockEntity.DYE_SLOT_END + 1; i++) {
            dyeSlots.add(i, addSlot(new EaselSlot(container, i, 8 + (i % 2) * 18, 16 + (i / 2) * 18, this)));
        }

        canvasSlot = addSlot(new EaselSlot(container, EaselBlockEntity.CANVAS_SLOT, 26, 70, this));

        resultSlot = addSlot(new Slot(resultContainer, 0, 147, 43) {
            @Override
            public boolean mayPlace(ItemStack pStack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());

                if (player instanceof ServerPlayer) {
                    List<ItemStack> itemsUsed = Lists.newArrayList();

                    RecipeHolder<PaintingRecipe> recipe = Objects.requireNonNull(currentRecipe, "Missing currentRecipe in EaselMenu");
                    for (Ingredient ingredient : recipe.value().getIngredients()) {
                        boolean success = false;
                        for (int i = 0; i < EaselMenu.this.container.getContainerSize(); i++) {
                            ItemStack ingredientStack = EaselMenu.this.container.getItem(i);
                            if (ingredient.test(ingredientStack)) {
                                ingredientStack.shrink(1);
                                itemsUsed.add(ingredientStack);
                                success = true;
                                break;
                            }
                        }
                        if (!success) {
                            throw new IllegalStateException("Missing expected ingredient in EaselMenu inputContainer");
                        }
                    }
                    EaselMenu.this.resultContainer.awardUsedRecipes(player, itemsUsed);
                    EaselMenu.this.broadcastChanges();
                }
                access.execute((level, pos) -> {
                    long gameTime = level.getGameTime();
                    if (EaselMenu.this.lastSoundTime != gameTime) {
                        level.playSound(null, pos, SoundEvents.UI_LOOM_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        EaselMenu.this.lastSoundTime = gameTime;
                    }
                });
                super.onTake(player, stack);
            }
        });

        for (int invRow = 0; invRow < 3; ++invRow) {
            for (int invCol = 0; invCol < 9; ++invCol) {
                addSlot(new Slot(inventory, invCol + invRow * 9 + 9, 8 + invCol * 18, 102 + invRow * 18));
            }
        }

        for (int hotBar = 0; hotBar < 9; ++hotBar) {
            addSlot(new Slot(inventory, hotBar, 8 + hotBar * 18, 160));
        }

        addDataSlots(containerData);
    }

    @Override
    public void slotChanged(AbstractContainerMenu pContainerToSend, int pDataSlotIndex, ItemStack pStack) {
        refreshRecipes();
    }

    @Override
    public boolean clickMenuButton(Player player, int index) {
        if (isValidIndex(index)) {
            containerData.set(0, index);
            setupResultSlot();
            return true;
        }
        return false;
    }

    public void refreshRecipes() {
        if (player instanceof ServerPlayer serverPlayer) {
            Level level = serverPlayer.level();
            List<RecipeHolder<PaintingRecipe>> availableRecipes = level.getRecipeManager()
                    .getRecipesFor(ModRecipes.PAINTING.get(), inputView(), level);

            if (checkIndexStillValid(availableRecipes)) {
                setupResultSlot();
            }

            PacketDistributor.sendToPlayer(serverPlayer, new EaselRecipePacket((short) containerId, availableRecipes));
        }
    }

    private void setupResultSlot() {
        Level level = player.level();
        RecipeHolder<PaintingRecipe> recipe = recipeList.get(getSelectedIndex());
        ItemStack result = recipe.value().assemble(inputView(), level.registryAccess());

        if (result.isItemEnabled(level.enabledFeatures())) {
            currentRecipe = recipe;
            resultContainer.setRecipeUsed(recipe);
            resultSlot.set(result);
        } else {
            resultSlot.set(ItemStack.EMPTY);
        }

        broadcastChanges();
    }

    private boolean checkIndexStillValid(List<RecipeHolder<PaintingRecipe>> availableRecipes) {
        if (isValidIndex(getSelectedIndex())) {
            RecipeHolder<PaintingRecipe> activeRecipe = recipeList.get(getSelectedIndex());
            if (availableRecipes.contains(activeRecipe)) {
                return true;
            }
        }

        currentRecipe = null;
        resultSlot.set(ItemStack.EMPTY);
        containerData.set(0, -1);
        broadcastChanges();
        return false;
    }

    private EaselRecipeInput inputView() {
        ItemStack canvas = container.getItem(EaselBlockEntity.CANVAS_SLOT);
        List<ItemStack> dyes = Lists.newArrayList();
        for (int i = EaselBlockEntity.DYE_SLOT_START; i < EaselBlockEntity.DYE_SLOT_END; i++) {
            dyes.add(container.getItem(i));
        }
        return new EaselRecipeInput(canvas, dyes);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = slots.get(index);
        if (!slot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack stackInSlot = slot.getItem();
        Item item = stackInSlot.getItem();
        ItemStack copy = stackInSlot.copy();

        if (index == EaselBlockEntity.RESULT_SLOT) {
            item.onCraftedBy(stackInSlot, player.level(), player);
            if (!moveItemStackTo(stackInSlot, EaselBlockEntity.RESULT_SLOT + 1, slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            slot.onQuickCraft(stackInSlot, copy);
        } else if (index >= EaselBlockEntity.DYE_SLOT_START && index <= EaselBlockEntity.CANVAS_SLOT) {
            if (!moveItemStackTo(stackInSlot, EaselBlockEntity.RESULT_SLOT + 1, slots.size(), true)) {
                return ItemStack.EMPTY;
            }
        } else if (index > EaselBlockEntity.RESULT_SLOT) {
            if (stackInSlot.is(Tags.Items.DYES)) {
                if (!moveItemStackTo(stackInSlot, EaselBlockEntity.DYE_SLOT_START, EaselBlockEntity.DYE_SLOT_END + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (stackInSlot.is(CommonTags.Items.CANVASES)) {
                if (!moveItemStackTo(stackInSlot, EaselBlockEntity.CANVAS_SLOT, EaselBlockEntity.CANVAS_SLOT + 1, false)) {
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
        return container.stillValid(player);
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        resultContainer.removeItemNoUpdate(1);
    }

    @Override
    public void dataChanged(AbstractContainerMenu pContainerMenu, int pDataSlotIndex, int pValue) {
        // No-op implementation
    }

    private void generateAllRecipes() {
        recipeList = ImmutableList.copyOf(player.level().getRecipeManager().getAllRecipesFor(ModRecipes.PAINTING.get())
                .stream()
                .sorted(PaintingRecipe.RECIPE_COMPARATOR)
                .toList());
    }

    public ImmutableList<RecipeHolder<PaintingRecipe>> getRecipeList() {
        return recipeList;
    }

    public List<Slot> getDyeSlots() {
        return dyeSlots;
    }

    public Slot getCanvasSlot() {
        return canvasSlot;
    }

    public int getSelectedIndex() {
        return containerData.get(0);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < recipeList.size();
    }
}
