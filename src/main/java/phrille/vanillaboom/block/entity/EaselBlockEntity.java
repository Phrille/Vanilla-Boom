/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.inventory.EaselMenu;

public class EaselBlockEntity extends BaseContainerBlockEntity {
    public static final int DYE_SLOT_START = 0;
    public static final int DYE_SLOT_END = 6;
    public static final int CANVAS_SLOT = 7;
    public static final int INPUT_SIZE = 8;
    public static final int RESULT_SLOT = 8;

    private NonNullList<ItemStack> items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
    private final ContainerData containerData = new ContainerData() {
        @Override
        public int get(int slotIndex) {
            return slotIndex == 0 ? EaselBlockEntity.this.selectedIndex : -1;
        }

        @Override
        public void set(int slotIndex, int value) {
            if (slotIndex == 0) {
                EaselBlockEntity.this.selectedIndex = value;
            }
        }

        @Override
        public int getCount() {
            return 1;
        }
    };
    private int selectedIndex = -1;

    public EaselBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EASEL.get(), pos, state);
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemList) {
        items = itemList;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    public int getContainerSize() {
        return INPUT_SIZE;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, items, provider);
        containerData.set(0, tag.contains("SelectedIndex") ? tag.getInt("SelectedIndex") : -1);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        ContainerHelper.saveAllItems(tag, items, provider);
        tag.putInt("SelectedIndex", containerData.get(0));
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new EaselMenu(id, inventory, this, containerData, ContainerLevelAccess.create(inventory.player.level(), getBlockPos()));
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable(VanillaBoom.MOD_ID + ".container.easel");
    }
}
