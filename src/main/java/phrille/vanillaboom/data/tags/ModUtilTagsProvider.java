/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariants;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.util.ModDamageTypes;

import java.util.concurrent.CompletableFuture;

public class ModUtilTagsProvider {
    public static class ModDamageTypeTagsProvider extends DamageTypeTagsProvider {
        public ModDamageTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper fileHelper) {
            super(output, registries, VanillaBoom.MOD_ID, fileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            tag(DamageTypeTags.BYPASSES_ARMOR)
                    .add(ModDamageTypes.CHILI);
            tag(DamageTypeTags.IS_FIRE)
                    .add(ModDamageTypes.CHILI);
        }
    }

    public static class ModPaintingVariantTagsProvider extends PaintingVariantTagsProvider {
        public ModPaintingVariantTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper fileHelper) {
            super(output, registries, VanillaBoom.MOD_ID, fileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            tag(PaintingVariantTags.PLACEABLE)
                    .add(PaintingVariants.EARTH)
                    .add(PaintingVariants.WIND)
                    .add(PaintingVariants.EARTH)
                    .add(PaintingVariants.WATER);
        }
    }

}
