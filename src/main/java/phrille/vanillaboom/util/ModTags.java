/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import phrille.vanillaboom.VanillaBoom;

public class ModTags {
    /**
     * Class that encapsulates all tags that belong in the forge
     * data directory which is not created by forge itself.
     */
    public static class ForgeTags {
        public static class Blocks {
            public static final TagKey<Block> BOOKSHELVES = forgeTag("bookshelves");
            public static final TagKey<Block> CAKES = forgeTag("cakes");
            public static final TagKey<Block> LADDERS = forgeTag("ladders");
            public static final TagKey<Block> FENCE_GATES_NETHER_BRICK = forgeTag("fence_gates/nether_brick");
            public static final TagKey<Block> STORAGE_BLOCKS_CHARCOAL = forgeTag("storage_blocks/charcoal");
            public static final TagKey<Block> STORAGE_BLOCKS_SUGAR = forgeTag("storage_blocks/sugar");
            public static final TagKey<Block> STORAGE_BLOCKS_SUGAR_CANE = forgeTag("storage_blocks/sugar_cane");
            public static final TagKey<Block> STORAGE_BLOCKS_GUNPOWDER = forgeTag("storage_blocks/gunpowder");
            public static final TagKey<Block> STORAGE_BLOCKS_BLAZE_POWDER = forgeTag("storage_blocks/blaze_powder");
            public static final TagKey<Block> STORAGE_BLOCKS_MAGMA_CREAM = forgeTag("storage_blocks/magma_cream");
            public static final TagKey<Block> STORAGE_BLOCKS_PRISMARINE_CRYSTAL = forgeTag("storage_blocks/prismarine_crystal");
            public static final TagKey<Block> STORAGE_BLOCKS_WITHER_BONE = forgeTag("storage_blocks/wither_bone");
            public static final TagKey<Block> STORAGE_BLOCKS_WHITE_DYE = forgeTag("storage_blocks/white_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_ORANGE_DYE = forgeTag("storage_blocks/orange_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_MAGENTA_DYE = forgeTag("storage_blocks/magenta_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_LIGHT_BLUE_DYE = forgeTag("storage_blocks/light_blue_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_YELLOW_DYE = forgeTag("storage_blocks/yellow_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_LIME_DYE = forgeTag("storage_blocks/lime_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_PINK_DYE = forgeTag("storage_blocks/pink_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_GRAY_DYE = forgeTag("storage_blocks/gray_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_LIGHT_GRAY_DYE = forgeTag("storage_blocks/light_gray_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_CYAN_DYE = forgeTag("storage_blocks/cyan_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_PURPLE_DYE = forgeTag("storage_blocks/purple_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_BLUE_DYE = forgeTag("storage_blocks/blue_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_BROWN_DYE = forgeTag("storage_blocks/brown_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_GREEN_DYE = forgeTag("storage_blocks/green_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_RED_DYE = forgeTag("storage_blocks/red_dye");
            public static final TagKey<Block> STORAGE_BLOCKS_BLACK_DYE = forgeTag("storage_blocks/black_dye");

            private static TagKey<Block> forgeTag(String name) {
                return BlockTags.create(new ResourceLocation("forge", name));
            }
        }

        public static class Items {
            public static final TagKey<Item> CAKES = forgeTag("cakes");
            public static final TagKey<Item> LADDERS = forgeTag("ladders");
            public static final TagKey<Item> FENCE_GATES_NETHER_BRICK = forgeTag("fence_gates/nether_brick");
            public static final TagKey<Item> STORAGE_BLOCKS_CHARCOAL = forgeTag("storage_blocks/charcoal");
            public static final TagKey<Item> STORAGE_BLOCKS_SUGAR = forgeTag("storage_blocks/sugar");
            public static final TagKey<Item> STORAGE_BLOCKS_SUGAR_CANE = forgeTag("storage_blocks/sugar_cane");
            public static final TagKey<Item> STORAGE_BLOCKS_GUNPOWDER = forgeTag("storage_blocks/gunpowder");
            public static final TagKey<Item> STORAGE_BLOCKS_BLAZE_POWDER = forgeTag("storage_blocks/blaze_powder");
            public static final TagKey<Item> STORAGE_BLOCKS_MAGMA_CREAM = forgeTag("storage_blocks/magma_cream");
            public static final TagKey<Item> STORAGE_BLOCKS_PRISMARINE_CRYSTAL = forgeTag("storage_blocks/prismarine_crystal");
            public static final TagKey<Item> STORAGE_BLOCKS_WITHER_BONE = forgeTag("storage_blocks/wither_bone");
            public static final TagKey<Item> STORAGE_BLOCKS_WHITE_DYE = forgeTag("storage_blocks/white_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_ORANGE_DYE = forgeTag("storage_blocks/orange_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_MAGENTA_DYE = forgeTag("storage_blocks/magenta_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_LIGHT_BLUE_DYE = forgeTag("storage_blocks/light_blue_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_YELLOW_DYE = forgeTag("storage_blocks/yellow_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_LIME_DYE = forgeTag("storage_blocks/lime_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_PINK_DYE = forgeTag("storage_blocks/pink_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_GRAY_DYE = forgeTag("storage_blocks/gray_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_LIGHT_GRAY_DYE = forgeTag("storage_blocks/light_gray_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_CYAN_DYE = forgeTag("storage_blocks/cyan_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_PURPLE_DYE = forgeTag("storage_blocks/purple_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_BLUE_DYE = forgeTag("storage_blocks/blue_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_BROWN_DYE = forgeTag("storage_blocks/brown_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_GREEN_DYE = forgeTag("storage_blocks/green_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_RED_DYE = forgeTag("storage_blocks/red_dye");
            public static final TagKey<Item> STORAGE_BLOCKS_BLACK_DYE = forgeTag("storage_blocks/black_dye");

            public static final TagKey<Item> CROPS_TOMATO = forgeTag("crops/tomato");
            public static final TagKey<Item> CROPS_CHILI = forgeTag("crops/chili");
            public static final TagKey<Item> CROPS_RICE = forgeTag("crops/rice");
            public static final TagKey<Item> SEEDS_TOMATO = forgeTag("seeds/tomato");
            public static final TagKey<Item> SEEDS_CHILI = forgeTag("seeds/chili");
            public static final TagKey<Item> SEEDS_RICE = forgeTag("seeds/rice");
            public static final TagKey<Item> INGOTS_MAGMA_BRICK = forgeTag("ingots/magma_brick");
            public static final TagKey<Item> WITHER_BONES = forgeTag("wither_bones");
            public static final TagKey<Item> WITHER_BONE_MEALS = forgeTag("wither_bone_meals");
            public static final TagKey<Item> RAW_FISHES = forgeTag("raw_fishes");
            public static final TagKey<Item> COOKED_FISHES = forgeTag("cooked_fishes");
            public static final TagKey<Item> RAW_MEATS = forgeTag("raw_meats");
            public static final TagKey<Item> COOKED_MEATS = forgeTag("cooked_meats");
            public static final TagKey<Item> CANVAS = forgeTag("canvas");
            public static final TagKey<Item> MILK = forgeTag("milk");
            public static final TagKey<Item> RICE = forgeTag("rice");

            private static TagKey<Item> forgeTag(String name) {
                return ItemTags.create(new ResourceLocation("forge", name));
            }
        }
    }

    /**
     * Class that encapsulates all tags unique to the mod that
     * is not relevant to be placed in the forge directory.
     */
    public static class VanillaBoomTags {
        public static class Blocks {
            public static final TagKey<Block> BRICKS = modTag("bricks");
            public static final TagKey<Block> POLISHED = modTag("polished");
            public static final TagKey<Block> PILLARS = modTag("pillars");
            public static final TagKey<Block> BOOKSHELVES = modTag("bookshelves");
            public static final TagKey<Block> DYE_BLOCKS = modTag("dye_blocks");
            public static final TagKey<Block> LADDERS = modTag("ladders");
            public static final TagKey<Block> STAIRS = modTag("stairs");
            public static final TagKey<Block> SLABS = modTag("slabs");
            public static final TagKey<Block> WALLS = modTag("walls");
            public static final TagKey<Block> FENCES = modTag("fences");
            public static final TagKey<Block> FENCE_GATES = modTag("fence_gates");
            public static final TagKey<Block> WOODEN_STAIRS = modTag("wooden_stairs");
            public static final TagKey<Block> WOODEN_SLABS = modTag("wooden_slabs");
            public static final TagKey<Block> WOODEN_FENCES = modTag("wooden_fences");
            public static final TagKey<Block> WOODEN_FENCE_GATES = modTag("wooden_fence_gates");

            private static TagKey<Block> modTag(String name) {
                return BlockTags.create(VanillaBoom.resLoc(name));
            }
        }

        public static class Items {
            public static final TagKey<Item> BRICKS = modTag("bricks");
            public static final TagKey<Item> POLISHED = modTag("polished");
            public static final TagKey<Item> PILLARS = modTag("pillars");
            public static final TagKey<Item> BOOKSHELVES = modTag("bookshelves");
            public static final TagKey<Item> DYE_BLOCKS = modTag("dye_blocks");
            public static final TagKey<Item> LADDERS = modTag("ladders");
            public static final TagKey<Item> STAIRS = modTag("stairs");
            public static final TagKey<Item> SLABS = modTag("slabs");
            public static final TagKey<Item> WALLS = modTag("walls");
            public static final TagKey<Item> FENCES = modTag("fences");
            public static final TagKey<Item> FENCE_GATES = modTag("fence_gates");
            public static final TagKey<Item> WOODEN_STAIRS = modTag("wooden_stairs");
            public static final TagKey<Item> WOODEN_SLABS = modTag("wooden_slabs");
            public static final TagKey<Item> WOODEN_FENCES = modTag("wooden_fences");
            public static final TagKey<Item> WOODEN_FENCE_GATES = modTag("wooden_fence_gates");

            public static final TagKey<Item> RAW_FISHES = modTag("raw_fishes");
            public static final TagKey<Item> COOKED_FISHES = modTag("cooked_fishes");
            public static final TagKey<Item> POTATO_SOUP_INGREDIENTS = modTag("potato_soup_ingredients");

            private static TagKey<Item> modTag(String name) {
                return ItemTags.create(VanillaBoom.resLoc(name));
            }
        }

        public static class Entities {
            public static final TagKey<EntityType<?>> PRISMARINE_EXTRA_HURT = modTag("prismarine_arrow_hurts_extra_types");

            @SuppressWarnings("SameParameterValue")
            private static TagKey<EntityType<?>> modTag(String name) {
                return TagKey.create(Registries.ENTITY_TYPE, VanillaBoom.resLoc(name));
            }
        }
    }
}
