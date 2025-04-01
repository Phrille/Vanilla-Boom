/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void gather(HolderLookup.Provider registries) {
        builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.PINE_CONE, new Compostable(0.35F), false)
                .add(ModItems.TOMATO, new Compostable(0.6F), false)
                .add(ModItems.TOMATO_SEEDS, new Compostable(0.3F), false)
                .add(ModItems.CHILI, new Compostable(0.5F), false)
                .add(ModItems.CHILI_SEEDS, new Compostable(0.3F), false)
                .add(ModItems.RICE_GRAINS, new Compostable(0.3F), false)
                .add(ModItems.ROSE, new Compostable(0.5F), false)
                .add(ModItems.PEONY, new Compostable(0.5F), false)
                .add(ModItems.LILAC, new Compostable(0.5F), false)
                .add(ModItems.SHEARED_ROSE_BUSH, new Compostable(0.6F), false)
                .add(ModItems.SHEARED_PEONY, new Compostable(0.6F), false)
                .add(ModItems.SHEARED_LILAC, new Compostable(0.6F), false)
                .add(ModItems.WITHERED_VINE, new Compostable(0.5F), false)
                .add(ModItems.CHOCOLATE_CAKE, new Compostable(1.0F), false)
                .add(ModItems.BERRY_CAKE, new Compostable(1.0F), false)
                .add(ModItems.CARROT_CAKE, new Compostable(1.0F), false)
                .add(ModItems.APPLE_PIE, new Compostable(1.0F), false)
                .add(ModItems.BERRY_PIE, new Compostable(1.0F), false)
                .add(ModItems.MONSTER_PIE, new Compostable(1.0F), false);

        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(Items.BLAZE_POWDER.builtInRegistryHolder(), new FurnaceFuel(16000), false)
                .add(ModItems.CHARCOAL_BLOCK, new FurnaceFuel(16000), false)
                .add(ModItems.BLAZE_POWDER_BLOCK, new FurnaceFuel(10800), false)
                .add(ModItems.WITHER_BONE_BLOCK, new FurnaceFuel(3600), false)
                .add(ModItems.WITHER_BONE, new FurnaceFuel(1200), false)
                .add(ModItems.WITHER_BONE_MEAL, new FurnaceFuel(400), false)
                .add(ModItems.PINE_CONE, new FurnaceFuel(150), false)
                .add(ModItems.EASEL, new FurnaceFuel(300), false)
                .add(ModTags.Items.OVERWORLD_BOOKSHELVES, new FurnaceFuel(300), false)
                .add(ModTags.Items.OVERWORLD_LADDERS, new FurnaceFuel(300), false)
                .add(ModTags.Items.OVERWORLD_WOODEN_FENCES, new FurnaceFuel(300), false)
                .add(ModTags.Items.OVERWORLD_WOODEN_FENCE_GATES, new FurnaceFuel(300), false)
                .add(ModTags.Items.OVERWORLD_WOODEN_SLABS, new FurnaceFuel(300), false)
                .add(ModTags.Items.OVERWORLD_WOODEN_SLABS, new FurnaceFuel(300), false);
    }
}
