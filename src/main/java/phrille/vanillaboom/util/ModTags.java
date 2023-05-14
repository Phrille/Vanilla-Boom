package phrille.vanillaboom.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    //Forge Blocks
    public static Tags.IOptionalNamedTag<Block> LADDERS = forgeBlockTag("ladders");
    public static Tags.IOptionalNamedTag<Block> CAKES = forgeBlockTag("cakes");
    public static Tags.IOptionalNamedTag<Block> FENCE_GATES_NETHER_BRICK = forgeBlockTag("fence_gates/nether_brick");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_CHARCOAL = forgeBlockTag("storage_blocks/charcoal");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_SUGAR = forgeBlockTag("storage_blocks/sugar");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_SUGAR_CANE = forgeBlockTag("storage_blocks/sugar_cane");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_GUNPOWDER = forgeBlockTag("storage_blocks/gunpowder");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BLAZE_POWDER = forgeBlockTag("storage_blocks/blaze_powder");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_MAGMA_CREAM = forgeBlockTag("storage_blocks/magma_cream");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_PRISMARINE_CRYSTAL = forgeBlockTag("storage_blocks/prismarine_crystal");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_WITHER_BONE = forgeBlockTag("storage_blocks/wither_bone");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_WHITE_DYE = forgeBlockTag("storage_blocks/white_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_ORANGE_DYE = forgeBlockTag("storage_blocks/orange_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_MAGENTA_DYE = forgeBlockTag("storage_blocks/magenta_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_LIGHT_BLUE_DYE = forgeBlockTag("storage_blocks/light_blue_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_YELLOW_DYE = forgeBlockTag("storage_blocks/yellow_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_LIME_DYE = forgeBlockTag("storage_blocks/lime_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_PINK_DYE = forgeBlockTag("storage_blocks/pink_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_GRAY_DYE = forgeBlockTag("storage_blocks/gray_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_LIGHT_GRAY_DYE = forgeBlockTag("storage_blocks/light_gray_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_CYAN_DYE = forgeBlockTag("storage_blocks/cyan_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_PURPLE_DYE = forgeBlockTag("storage_blocks/purple_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BLUE_DYE = forgeBlockTag("storage_blocks/blue_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BROWN_DYE = forgeBlockTag("storage_blocks/brown_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_GREEN_DYE = forgeBlockTag("storage_blocks/green_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_RED_DYE = forgeBlockTag("storage_blocks/red_dye");
    public static Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_BLACK_DYE = forgeBlockTag("storage_blocks/black_dye");

    //Forge Items
    public static Tags.IOptionalNamedTag<Item> RAW_FISHES = forgeItemTag("raw_fishes");
    public static Tags.IOptionalNamedTag<Item> COOKED_FISHES = forgeItemTag("cooked_fishes");
    public static Tags.IOptionalNamedTag<Item> RAW_MEATS = forgeItemTag("raw_meats");
    public static Tags.IOptionalNamedTag<Item> COOKED_MEATS = forgeItemTag("cooked_meats");
    public static Tags.IOptionalNamedTag<Item> NETHER_BONE_MEAL = forgeItemTag("nether_bone_meal");
    public static Tags.IOptionalNamedTag<Item> CANVAS = forgeItemTag("canvas");
    public static Tags.IOptionalNamedTag<Item> MILK = forgeItemTag("milk");

    private static Tags.IOptionalNamedTag<Block> forgeBlockTag(String name) {
        return BlockTags.createOptional(new ResourceLocation("forge", name));
    }

    private static Tags.IOptionalNamedTag<Item> forgeItemTag(String name) {
        return ItemTags.createOptional(new ResourceLocation("forge", name));
    }
}
