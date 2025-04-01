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
import phrille.vanillaboom.entity.ModEntityTypes;
import phrille.vanillaboom.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper fileHelper) {
        super(output, registries, VanillaBoom.MOD_ID, fileHelper);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags(HolderLookup.Provider registries) {
        // Mod Tags
        tag(ModTags.Entities.FISHES)
                .add(ModEntityTypes.TUNA.get())
                .add(ModEntityTypes.PERCH.get())
                .add(ModEntityTypes.PIKE.get())
                .add(ModEntityTypes.EEL.get());
        tag(ModTags.Entities.PRISMARINE_EXTRA_HURT)
                .add(EntityType.BLAZE)
                .add(EntityType.STRIDER)
                .add(EntityType.MAGMA_CUBE);

        // Minecraft Tags
        tag(EntityTypeTags.AQUATIC)
                .addTags(ModTags.Entities.FISHES);
        tag(EntityTypeTags.ARROWS)
                .add(ModEntityTypes.PRISMARINE_ARROW.get());
        tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS)
                .addTags(ModTags.Entities.FISHES);
        tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER)
                .addTags(ModTags.Entities.FISHES);
        tag(EntityTypeTags.NOT_SCARY_FOR_PUFFERFISH)
                .addTags(ModTags.Entities.FISHES);
    }
}
