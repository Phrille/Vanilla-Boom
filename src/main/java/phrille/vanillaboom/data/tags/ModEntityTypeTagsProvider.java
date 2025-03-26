/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.util.ModTags;

import java.util.concurrent.CompletableFuture;

// TODO: aquatic tag, can_breathe_under_water, not_scary_for_pufferfish USE VB FISH TAG

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Minecraft Tags
        tag(EntityTypeTags.ARROWS).add(ModEntities.PRISMARINE_ARROW.get());
        tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS)
                .add(ModEntities.TUNA.get())
                .add(ModEntities.PERCH.get())
                .add(ModEntities.PIKE.get())
                .add(ModEntities.EEL.get());

        // Mod Tags
        tag(ModTags.Entities.FISHES)
                .add(ModEntities.TUNA.get())
                .add(ModEntities.PERCH.get())
                .add(ModEntities.PIKE.get())
                .add(ModEntities.EEL.get());
        tag(ModTags.Entities.PRISMARINE_EXTRA_HURT)
                .add(EntityType.BLAZE)
                .add(EntityType.STRIDER)
                .add(EntityType.MAGMA_CUBE);
    }
}
