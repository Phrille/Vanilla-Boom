/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.NbtOps;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.crop.ITrellisCrop;
import phrille.vanillaboom.block.crop.ShearedTallFlowerBlock;
import phrille.vanillaboom.block.crop.TrellisBlock;

public class Utils {
    public static void spawnParticles(SimpleParticleType particle, Level level, BlockPos pos) {
        if (!level.getBlockState(pos).isSolidRender(level, pos)) {
            for (int l = 0; l < 8; ++l) {
                level.addParticle(particle, (double) pos.getX() + Math.random(), (double) pos.getY() + Math.random(), (double) pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static void fillAndAwardStat(ItemStack heldStack, Player player, ItemStack newStack) {
        player.awardStat(Stats.ITEM_USED.get(heldStack.getItem()));
        ItemUtils.createFilledResult(heldStack, player, newStack);
    }

    public static void preventCreativeDropFromBottomPart(Level level, BlockPos pos, BlockState state, Player player, EnumProperty<DoubleBlockHalf> halfProperty) {
        DoubleBlockHalf half = state.getValue(halfProperty);
        if (half == DoubleBlockHalf.UPPER) {
            BlockPos below = pos.below();
            BlockState belowState = level.getBlockState(below);
            if (belowState.is(state.getBlock()) && belowState.getValue(halfProperty) == DoubleBlockHalf.LOWER) {
                BlockState fluidState = belowState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(below, fluidState, 35);
                level.levelEvent(player, 2001, below, Block.getId(belowState));
            }
        }
    }

    public static void setDoubleBlock(Level level, BlockState state, BlockPos pos, EnumProperty<DoubleBlockHalf> halfProperty) {
        if (!level.isClientSide) {
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 20);
            level.setBlock(pos, state.setValue(halfProperty, DoubleBlockHalf.LOWER), 2);
            level.setBlock(pos.above(), state.setValue(halfProperty, DoubleBlockHalf.UPPER), 2);
        }
    }

    public static BlockState copyState(BlockState from, BlockState to) {
        for (Property<?> property : from.getProperties()) {
            to = copyState(from, to, property);
        }
        return to;
    }

    public static <T extends Comparable<T>> BlockState copyState(BlockState from, BlockState to, Property<T> property) {
        return to.setValue(property, from.getValue(property));
    }

    public static ItemStack stackFromHolder(HolderLookup.Provider registries, Holder<PaintingVariant> holder) {
        CustomData data = CustomData.EMPTY
                .update(registries.createSerializationContext(NbtOps.INSTANCE), Painting.VARIANT_MAP_CODEC, holder)
                .getOrThrow()
                .update(compoundTag -> compoundTag.putString("id", holder.getRegisteredName()));
        ItemStack painting = new ItemStack(Items.PAINTING);
        painting.set(DataComponents.ENTITY_DATA, data);
        return painting;
    }

    public static void registerFlowerPots() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VanillaBoom.resLoc("rose"), ModBlocks.POTTED_ROSE);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VanillaBoom.resLoc("peony"), ModBlocks.POTTED_PEONY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VanillaBoom.resLoc("lilac"), ModBlocks.POTTED_LILAC);
    }

    public static void registerShearedTallFlowers() {
        ShearedTallFlowerBlock.registerShearedTallFlowerBlock((TallFlowerBlock) Blocks.ROSE_BUSH, (ShearedTallFlowerBlock) ModBlocks.SHEARED_ROSE_BUSH.get());
        ShearedTallFlowerBlock.registerShearedTallFlowerBlock((TallFlowerBlock) Blocks.PEONY, (ShearedTallFlowerBlock) ModBlocks.SHEARED_PEONY.get());
        ShearedTallFlowerBlock.registerShearedTallFlowerBlock((TallFlowerBlock) Blocks.LILAC, (ShearedTallFlowerBlock) ModBlocks.SHEARED_LILAC.get());
    }

    public static void registerTrellisCrops() {
        ((TrellisBlock) ModBlocks.TRELLIS.get()).registerTrellisCrop((ITrellisCrop) ModBlocks.TOMATO.get());
        ((TrellisBlock) ModBlocks.TRELLIS.get()).registerTrellisCrop((ITrellisCrop) ModBlocks.CHILI.get());
    }
}
