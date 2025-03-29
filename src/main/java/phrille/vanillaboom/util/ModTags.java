/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import phrille.vanillaboom.VanillaBoom;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> BRICKS = blockTag("bricks");
        public static final TagKey<Block> POLISHED = blockTag("polished");
        public static final TagKey<Block> PILLARS = blockTag("pillars");
        public static final TagKey<Block> DYE_BLOCKS = blockTag("dye_blocks");
        public static final TagKey<Block> NETHER_BOOKSHELVES = blockTag("nether_bookshelves");
        public static final TagKey<Block> NETHER_BRICK_FENCES = blockTag("nether_brick_fences");
        public static final TagKey<Block> NETHER_BRICK_FENCE_GATES = blockTag("nether_brick_fence_gates");
        public static final TagKey<Block> NETHER_LADDERS = blockTag("nether_ladders");
        public static final TagKey<Block> NETHER_WOODEN_FENCES = blockTag("nether_wooden_fences");
        public static final TagKey<Block> NETHER_WOODEN_FENCE_GATES = blockTag("nether_wooden_fence_gates");
        public static final TagKey<Block> NETHER_WOODEN_SLABS = blockTag("nether_wooden_slabs");
        public static final TagKey<Block> NETHER_WOODEN_STAIRS = blockTag("nether_wooden_stairs");
        public static final TagKey<Block> OVERWORLD_BOOKSHELVES = blockTag("overworld_bookshelves");
        public static final TagKey<Block> OVERWORLD_LADDERS = blockTag("overworld_ladders");
        public static final TagKey<Block> OVERWORLD_WOODEN_FENCES = blockTag("overworld_wooden_fences");
        public static final TagKey<Block> OVERWORLD_WOODEN_FENCE_GATES = blockTag("overworld_wooden_fence_gates");
        public static final TagKey<Block> OVERWORLD_WOODEN_SLABS = blockTag("overworld_wooden_slabs");
        public static final TagKey<Block> OVERWORLD_WOODEN_STAIRS = blockTag("overworld_wooden_stairs");
        public static final TagKey<Block> STAIRS = blockTag("stairs");
        public static final TagKey<Block> SLABS = blockTag("slabs");
        public static final TagKey<Block> WALLS = blockTag("walls");

        private static TagKey<Block> blockTag(String name) {
            return BlockTags.create(VanillaBoom.resLoc(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BRICKS = itemTag("bricks");
        public static final TagKey<Item> POLISHED = itemTag("polished");
        public static final TagKey<Item> PILLARS = itemTag("pillars");
        public static final TagKey<Item> DYE_BLOCKS = itemTag("dye_blocks");
        public static final TagKey<Item> NETHER_BOOKSHELVES = itemTag("nether_bookshelves");
        public static final TagKey<Item> NETHER_BRICK_FENCES = itemTag("nether_brick_fences");
        public static final TagKey<Item> NETHER_BRICK_FENCE_GATES = itemTag("nether_brick_fence_gates");
        public static final TagKey<Item> NETHER_LADDERS = itemTag("nether_ladders");
        public static final TagKey<Item> NETHER_WOODEN_FENCES = itemTag("nether_wooden_fences");
        public static final TagKey<Item> NETHER_WOODEN_FENCE_GATES = itemTag("nether_wooden_fence_gates");
        public static final TagKey<Item> NETHER_WOODEN_SLABS = itemTag("nether_wooden_slabs");
        public static final TagKey<Item> NETHER_WOODEN_STAIRS = itemTag("nether_wooden_stairs");
        public static final TagKey<Item> OVERWORLD_BOOKSHELVES = itemTag("overworld_bookshelves");
        public static final TagKey<Item> OVERWORLD_LADDERS = itemTag("overworld_ladders");
        public static final TagKey<Item> OVERWORLD_WOODEN_FENCES = itemTag("overworld_wooden_fences");
        public static final TagKey<Item> OVERWORLD_WOODEN_FENCE_GATES = itemTag("overworld_wooden_fence_gates");
        public static final TagKey<Item> OVERWORLD_WOODEN_SLABS = itemTag("overworld_wooden_slabs");
        public static final TagKey<Item> OVERWORLD_WOODEN_STAIRS = itemTag("overworld_wooden_stairs");
        public static final TagKey<Item> STAIRS = itemTag("stairs");
        public static final TagKey<Item> SLABS = itemTag("slabs");
        public static final TagKey<Item> WALLS = itemTag("walls");

        public static final TagKey<Item> RAW_FISHES = itemTag("raw_fishes");
        public static final TagKey<Item> COOKED_FISHES = itemTag("cooked_fishes");
        public static final TagKey<Item> POTATO_SOUP_INGREDIENTS = itemTag("potato_soup_ingredients");

        private static TagKey<Item> itemTag(String name) {
            return ItemTags.create(VanillaBoom.resLoc(name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> FISHES = entityTag("fish_types");
        public static final TagKey<EntityType<?>> PRISMARINE_EXTRA_HURT = entityTag("prismarine_arrow_hurts_extra_types");

        private static TagKey<EntityType<?>> entityTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, VanillaBoom.resLoc(name));
        }
    }
}
