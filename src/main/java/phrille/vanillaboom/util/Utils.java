/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.block.ModCandleCakeBlock;
import phrille.vanillaboom.block.crop.ITrellisCrop;
import phrille.vanillaboom.block.crop.ShearedTallFlowerBlock;
import phrille.vanillaboom.block.crop.TrellisBlock;
import phrille.vanillaboom.item.ModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class Utils {
    public static final List<Block> CANDLES = List.of(Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE);

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

    public static ResourceLocation resLocFromPaintingVariant(ResourceKey<PaintingVariant> variant) {
        PaintingVariant paintingVariant = BuiltInRegistries.PAINTING_VARIANT.getHolder(variant).orElseThrow().value();
        return Objects.requireNonNull(BuiltInRegistries.PAINTING_VARIANT.getKey(paintingVariant));
    }

    @Nullable
    public static PaintingVariant paintingVariantFromStack(ItemStack stack) {
        ResourceLocation resLoc = resLocFromStack(stack);
        if (resLoc != null) {
            return BuiltInRegistries.PAINTING_VARIANT.get(resLoc);
        }

        return null;
    }

    public static ItemStack stackFromPaintingVariant(ResourceKey<PaintingVariant> variant) {
        return stackFromPaintingVariant(resLocFromPaintingVariant(variant));
    }

    @Nullable
    public static ResourceLocation resLocFromStack(ItemStack stack) {
        if (stack.getTag() != null && stack.getTag().contains("EntityTag")) {

            CompoundTag entityTag = stack.getTag().getCompound("EntityTag");
            String variant = entityTag.getString("variant");
            return new ResourceLocation(variant);
        }

        return null;
    }

    public static ItemStack stackFromPaintingVariant(ResourceLocation resLoc) {
        ItemStack result = new ItemStack(Items.PAINTING);
        CompoundTag entityTag = new CompoundTag();
        entityTag.putString("variant", resLoc.toString());
        result.getOrCreateTag().put("EntityTag", entityTag);
        return result;
    }

    public static void addCompostMaterials() {
        ComposterBlock.COMPOSTABLES.put(ModItems.PINE_CONE.get(), 0.35F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO.get(), 0.6F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.CHILI.get(), 0.6F);
        ComposterBlock.COMPOSTABLES.put(ModItems.CHILI_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.ROSE.get(), 0.6F);
    }

    public static void registerBurnTimes() {
        FuelHandler.registerBurnTime(Items.BLAZE_POWDER, 1200);
        FuelHandler.registerBurnTime(ModBlocks.CHARCOAL_BLOCK.get(), 16000);
        FuelHandler.registerBurnTime(ModBlocks.BLAZE_POWDER_BLOCK.get(), 10800);
        FuelHandler.registerBurnTime(ModBlocks.WITHER_BONE_BLOCK.get(), 10800);
        FuelHandler.registerBurnTime(ModItems.WITHER_BONE.get(), 1200);
        FuelHandler.registerBurnTime(ModItems.WITHER_BONE_MEAL.get(), 400);
        FuelHandler.registerBurnTime(ModItems.PINE_CONE.get(), 100);
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

    public static void registerCandleCakes() {
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.WHITE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.ORANGE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.MAGENTA_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.YELLOW_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIME_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PINK_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GRAY_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CYAN_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PURPLE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLUE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BROWN_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GREEN_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.RED_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLACK_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.WHITE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.ORANGE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.MAGENTA_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_BLUE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.YELLOW_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIME_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PINK_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GRAY_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_GRAY_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CYAN_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PURPLE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLUE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BROWN_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GREEN_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.RED_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLACK_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.WHITE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.ORANGE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.MAGENTA_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_BLUE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.YELLOW_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIME_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PINK_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GRAY_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_GRAY_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CYAN_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PURPLE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLUE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BROWN_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GREEN_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.RED_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLACK_CANDLE_CARROT_CAKE.get());
    }
}
