package phrille.vanillaboom.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommonTags {
    public static class Blocks {
        public static final TagKey<Block> FENCE_GATES_NETHER_BRICK = blockTag("fence_gates/nether_brick");
        public static final TagKey<Block> LADDERS = blockTag("ladders");
        public static final TagKey<Block> STORAGE_BLOCKS_BLACK_DYE = blockTag("storage_blocks/black_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_BLAZE_POWDER = blockTag("storage_blocks/blaze_powder");
        public static final TagKey<Block> STORAGE_BLOCKS_BLUE_DYE = blockTag("storage_blocks/blue_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_BROWN_DYE = blockTag("storage_blocks/brown_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_CHARCOAL = blockTag("storage_blocks/charcoal");
        public static final TagKey<Block> STORAGE_BLOCKS_CYAN_DYE = blockTag("storage_blocks/cyan_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_GRAY_DYE = blockTag("storage_blocks/gray_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_GREEN_DYE = blockTag("storage_blocks/green_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_GUNPOWDER = blockTag("storage_blocks/gunpowder");
        public static final TagKey<Block> STORAGE_BLOCKS_LIGHT_BLUE_DYE = blockTag("storage_blocks/light_blue_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_LIGHT_GRAY_DYE = blockTag("storage_blocks/light_gray_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_LIME_DYE = blockTag("storage_blocks/lime_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_MAGENTA_DYE = blockTag("storage_blocks/magenta_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_MAGMA_CREAM = blockTag("storage_blocks/magma_cream");
        public static final TagKey<Block> STORAGE_BLOCKS_ORANGE_DYE = blockTag("storage_blocks/orange_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_PINK_DYE = blockTag("storage_blocks/pink_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_PRISMARINE_CRYSTAL = blockTag("storage_blocks/prismarine_crystal");
        public static final TagKey<Block> STORAGE_BLOCKS_PURPLE_DYE = blockTag("storage_blocks/purple_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_RED_DYE = blockTag("storage_blocks/red_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_SUGAR = blockTag("storage_blocks/sugar");
        public static final TagKey<Block> STORAGE_BLOCKS_SUGAR_CANE = blockTag("storage_blocks/sugar_cane");
        public static final TagKey<Block> STORAGE_BLOCKS_WHITE_DYE = blockTag("storage_blocks/white_dye");
        public static final TagKey<Block> STORAGE_BLOCKS_WITHER_BONE_MEAL = blockTag("storage_blocks/wither_bone_meal");
        public static final TagKey<Block> STORAGE_BLOCKS_YELLOW_DYE = blockTag("storage_blocks/yellow_dye");

        private static TagKey<Block> blockTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CANVASES = itemTag("canvases");
        public static final TagKey<Item> CROPS_CHILI = itemTag("crops/chili");
        public static final TagKey<Item> CROPS_RICE = itemTag("crops/rice");
        public static final TagKey<Item> CROPS_TOMATO = itemTag("crops/tomato");
        public static final TagKey<Item> FENCE_GATES_NETHER_BRICK = itemTag("fence_gates/nether_brick");
        public static final TagKey<Item> FOODS_PIES = itemTag("foods/pies");
        public static final TagKey<Item> FOODS_RICES = itemTag("foods/rices");
        public static final TagKey<Item> INGOTS_MAGMA_BRICK = itemTag("ingots/magma_brick");
        public static final TagKey<Item> LADDERS = itemTag("ladders");
        public static final TagKey<Item> SEEDS_CHILI = itemTag("seeds/chili");
        public static final TagKey<Item> SEEDS_RICE = itemTag("seeds/rice");
        public static final TagKey<Item> SEEDS_TOMATO = itemTag("seeds/tomato");
        public static final TagKey<Item> STORAGE_BLOCKS_BLACK_DYE = itemTag("storage_blocks/black_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_BLAZE_POWDER = itemTag("storage_blocks/blaze_powder");
        public static final TagKey<Item> STORAGE_BLOCKS_BLUE_DYE = itemTag("storage_blocks/blue_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_BROWN_DYE = itemTag("storage_blocks/brown_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_CHARCOAL = itemTag("storage_blocks/charcoal");
        public static final TagKey<Item> STORAGE_BLOCKS_CYAN_DYE = itemTag("storage_blocks/cyan_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_GRAY_DYE = itemTag("storage_blocks/gray_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_GREEN_DYE = itemTag("storage_blocks/green_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_GUNPOWDER = itemTag("storage_blocks/gunpowder");
        public static final TagKey<Item> STORAGE_BLOCKS_LIGHT_BLUE_DYE = itemTag("storage_blocks/light_blue_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_LIGHT_GRAY_DYE = itemTag("storage_blocks/light_gray_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_LIME_DYE = itemTag("storage_blocks/lime_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_MAGENTA_DYE = itemTag("storage_blocks/magenta_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_MAGMA_CREAM = itemTag("storage_blocks/magma_cream");
        public static final TagKey<Item> STORAGE_BLOCKS_ORANGE_DYE = itemTag("storage_blocks/orange_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_PINK_DYE = itemTag("storage_blocks/pink_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_PRISMARINE_CRYSTAL = itemTag("storage_blocks/prismarine_crystal");
        public static final TagKey<Item> STORAGE_BLOCKS_PURPLE_DYE = itemTag("storage_blocks/purple_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_RED_DYE = itemTag("storage_blocks/red_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_SUGAR = itemTag("storage_blocks/sugar");
        public static final TagKey<Item> STORAGE_BLOCKS_SUGAR_CANE = itemTag("storage_blocks/sugar_cane");
        public static final TagKey<Item> STORAGE_BLOCKS_WHITE_DYE = itemTag("storage_blocks/white_dye");
        public static final TagKey<Item> STORAGE_BLOCKS_WITHER_BONE_MEAL = itemTag("storage_blocks/wither_bone_meal");
        public static final TagKey<Item> STORAGE_BLOCKS_YELLOW_DYE = itemTag("storage_blocks/yellow_dye");
        public static final TagKey<Item> WITHER_BONES = itemTag("wither_bones");
        public static final TagKey<Item> WITHER_BONE_MEALS = itemTag("wither_bone_meals");

        private static TagKey<Item> itemTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
