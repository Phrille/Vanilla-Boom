package phrille.vanillaboom.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import phrille.vanillaboom.VanillaBoom;

public class ModTags {

    /**
     * Class that encapsulates all tags that belong in the forge
     * data directory which is not created by forge itself.
     */
    public static class ForgeTags {
        public static class Blocks {
            public static final Tags.IOptionalNamedTag<Block> BOOKSHELVES = forgeTag("bookshelves");
            public static final Tags.IOptionalNamedTag<Block> CAKES = forgeTag("cakes");
            public static final Tags.IOptionalNamedTag<Block> LADDERS = forgeTag("ladders");
            public static final Tags.IOptionalNamedTag<Block> FENCE_GATES_NETHER_BRICK = forgeTag("fence_gates/nether_brick");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_CHARCOAL = forgeTag("storage_blocks/charcoal");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_SUGAR = forgeTag("storage_blocks/sugar");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_SUGAR_CANE = forgeTag("storage_blocks/sugar_cane");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_GUNPOWDER = forgeTag("storage_blocks/gunpowder");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BLAZE_POWDER = forgeTag("storage_blocks/blaze_powder");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_MAGMA_CREAM = forgeTag("storage_blocks/magma_cream");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_PRISMARINE_CRYSTAL = forgeTag("storage_blocks/prismarine_crystal");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_WITHER_BONE = forgeTag("storage_blocks/wither_bone");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_WHITE_DYE = forgeTag("storage_blocks/white_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_ORANGE_DYE = forgeTag("storage_blocks/orange_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_MAGENTA_DYE = forgeTag("storage_blocks/magenta_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_LIGHT_BLUE_DYE = forgeTag("storage_blocks/light_blue_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_YELLOW_DYE = forgeTag("storage_blocks/yellow_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_LIME_DYE = forgeTag("storage_blocks/lime_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_PINK_DYE = forgeTag("storage_blocks/pink_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_GRAY_DYE = forgeTag("storage_blocks/gray_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_LIGHT_GRAY_DYE = forgeTag("storage_blocks/light_gray_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_CYAN_DYE = forgeTag("storage_blocks/cyan_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_PURPLE_DYE = forgeTag("storage_blocks/purple_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BLUE_DYE = forgeTag("storage_blocks/blue_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BROWN_DYE = forgeTag("storage_blocks/brown_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_GREEN_DYE = forgeTag("storage_blocks/green_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_RED_DYE = forgeTag("storage_blocks/red_dye");
            public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BLACK_DYE = forgeTag("storage_blocks/black_dye");

            private static Tags.IOptionalNamedTag<Block> forgeTag(String name) {
                return BlockTags.createOptional(new ResourceLocation("forge", name));
            }
        }

        public static class Items {
            public static final Tags.IOptionalNamedTag<Item> CAKES = forgeTag("cakes");
            public static final Tags.IOptionalNamedTag<Item> LADDERS = forgeTag("ladders");
            public static final Tags.IOptionalNamedTag<Item> FENCE_GATES_NETHER_BRICK = forgeTag("fence_gates/nether_brick");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_CHARCOAL = forgeTag("storage_blocks/charcoal");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_SUGAR = forgeTag("storage_blocks/sugar");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_SUGAR_CANE = forgeTag("storage_blocks/sugar_cane");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_GUNPOWDER = forgeTag("storage_blocks/gunpowder");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_BLAZE_POWDER = forgeTag("storage_blocks/blaze_powder");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_MAGMA_CREAM = forgeTag("storage_blocks/magma_cream");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_PRISMARINE_CRYSTAL = forgeTag("storage_blocks/prismarine_crystal");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_WITHER_BONE = forgeTag("storage_blocks/wither_bone");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_WHITE_DYE = forgeTag("storage_blocks/white_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_ORANGE_DYE = forgeTag("storage_blocks/orange_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_MAGENTA_DYE = forgeTag("storage_blocks/magenta_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_LIGHT_BLUE_DYE = forgeTag("storage_blocks/light_blue_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_YELLOW_DYE = forgeTag("storage_blocks/yellow_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_LIME_DYE = forgeTag("storage_blocks/lime_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_PINK_DYE = forgeTag("storage_blocks/pink_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_GRAY_DYE = forgeTag("storage_blocks/gray_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_LIGHT_GRAY_DYE = forgeTag("storage_blocks/light_gray_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_CYAN_DYE = forgeTag("storage_blocks/cyan_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_PURPLE_DYE = forgeTag("storage_blocks/purple_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_BLUE_DYE = forgeTag("storage_blocks/blue_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_BROWN_DYE = forgeTag("storage_blocks/brown_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_GREEN_DYE = forgeTag("storage_blocks/green_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_RED_DYE = forgeTag("storage_blocks/red_dye");
            public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_BLACK_DYE = forgeTag("storage_blocks/black_dye");

            public static final Tags.IOptionalNamedTag<Item> CROPS_TOMATO = forgeTag("crops/tomato");
            public static final Tags.IOptionalNamedTag<Item> CROPS_RICE = forgeTag("crops/rice");
            public static final Tags.IOptionalNamedTag<Item> SEEDS_TOMATO = forgeTag("seeds/tomato");
            public static final Tags.IOptionalNamedTag<Item> SEEDS_RICE = forgeTag("seeds/rice");
            public static final Tags.IOptionalNamedTag<Item> INGOTS_MAGMA_BRICK = forgeTag("ingots/magma_brick");
            public static final Tags.IOptionalNamedTag<Item> WITHER_BONES = forgeTag("wither_bones");
            public static final Tags.IOptionalNamedTag<Item> WITHER_BONE_MEALS = forgeTag("wither_bone_meals");
            public static final Tags.IOptionalNamedTag<Item> RAW_FISHES = forgeTag("raw_fishes");
            public static final Tags.IOptionalNamedTag<Item> COOKED_FISHES = forgeTag("cooked_fishes");
            public static final Tags.IOptionalNamedTag<Item> RAW_MEATS = forgeTag("raw_meats");
            public static final Tags.IOptionalNamedTag<Item> COOKED_MEATS = forgeTag("cooked_meats");
            public static final Tags.IOptionalNamedTag<Item> CANVAS = forgeTag("canvas");
            public static final Tags.IOptionalNamedTag<Item> MILK = forgeTag("milk");

            private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
                return ItemTags.createOptional(new ResourceLocation("forge", name));
            }
        }
    }

    /**
     * Class that encapsulates all tags unique to the mod that
     * is not relevant to be placed in the forge directory.
     */
    public static class VanillaBoomTags {
        public static class Blocks {
            public static final Tags.IOptionalNamedTag<Block> BRICKS = modTag("bricks");
            public static final Tags.IOptionalNamedTag<Block> POLISHED = modTag("polished");
            public static final Tags.IOptionalNamedTag<Block> PILLARS = modTag("pillars");
            public static final Tags.IOptionalNamedTag<Block> BOOKSHELVES = modTag("bookshelves");
            public static final Tags.IOptionalNamedTag<Block> DYE_BLOCKS = modTag("dye_blocks");
            public static final Tags.IOptionalNamedTag<Block> LADDERS = modTag("ladders");
            public static final Tags.IOptionalNamedTag<Block> STAIRS = modTag("stairs");
            public static final Tags.IOptionalNamedTag<Block> SLABS = modTag("slabs");
            public static final Tags.IOptionalNamedTag<Block> WALLS = modTag("walls");
            public static final Tags.IOptionalNamedTag<Block> FENCES = modTag("fences");
            public static final Tags.IOptionalNamedTag<Block> FENCE_GATES = modTag("fence_gates");
            public static final Tags.IOptionalNamedTag<Block> WOODEN_STAIRS = modTag("wooden_stairs");
            public static final Tags.IOptionalNamedTag<Block> WOODEN_SLABS = modTag("wooden_slabs");
            public static final Tags.IOptionalNamedTag<Block> WOODEN_FENCES = modTag("wooden_fences");
            public static final Tags.IOptionalNamedTag<Block> WOODEN_FENCE_GATES = modTag("wooden_fence_gates");

            private static Tags.IOptionalNamedTag<Block> modTag(String name) {
                return BlockTags.createOptional(new ResourceLocation(VanillaBoom.MOD_ID, name));
            }
        }

        public static class Items {
            public static final Tags.IOptionalNamedTag<Item> BRICKS = modTag("bricks");
            public static final Tags.IOptionalNamedTag<Item> POLISHED = modTag("polished");
            public static final Tags.IOptionalNamedTag<Item> PILLARS = modTag("pillars");
            public static final Tags.IOptionalNamedTag<Item> BOOKSHELVES = modTag("bookshelves");
            public static final Tags.IOptionalNamedTag<Item> DYE_BLOCKS = modTag("dye_blocks");
            public static final Tags.IOptionalNamedTag<Item> LADDERS = modTag("ladders");
            public static final Tags.IOptionalNamedTag<Item> STAIRS = modTag("stairs");
            public static final Tags.IOptionalNamedTag<Item> SLABS = modTag("slabs");
            public static final Tags.IOptionalNamedTag<Item> WALLS = modTag("walls");
            public static final Tags.IOptionalNamedTag<Item> FENCES = modTag("fences");
            public static final Tags.IOptionalNamedTag<Item> FENCE_GATES = modTag("fence_gates");
            public static final Tags.IOptionalNamedTag<Item> WOODEN_STAIRS = modTag("wooden_stairs");
            public static final Tags.IOptionalNamedTag<Item> WOODEN_SLABS = modTag("wooden_slabs");
            public static final Tags.IOptionalNamedTag<Item> WOODEN_FENCES = modTag("wooden_fences");
            public static final Tags.IOptionalNamedTag<Item> WOODEN_FENCE_GATES = modTag("wooden_fence_gates");

            public static final Tags.IOptionalNamedTag<Item> RAW_FISHES = modTag("raw_fishes");
            public static final Tags.IOptionalNamedTag<Item> COOKED_FISHES = modTag("cooked_fishes");

            private static Tags.IOptionalNamedTag<Item> modTag(String name) {
                return ItemTags.createOptional(new ResourceLocation(VanillaBoom.MOD_ID, name));
            }
        }
    }
}