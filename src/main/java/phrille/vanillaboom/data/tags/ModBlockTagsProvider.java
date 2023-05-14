package phrille.vanillaboom.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.util.ModTags;
import phrille.vanillaboom.util.Utils;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VanillaBoom.MOD_ID, existingFileHelper);
        Utils.registerCandleCakes();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags() {
        //Forge
        tag(ModTags.FENCE_GATES_NETHER_BRICK)
                .add(ModBlocks.NETHER_BRICK_FENCE_GATE.get())
                .add(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get());
        tag(Tags.Blocks.FENCE_GATES_WOODEN)
                .add(ModBlocks.OAK_WOOD_FENCE_GATE.get())
                .add(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get())
                .add(ModBlocks.BIRCH_WOOD_FENCE_GATE.get())
                .add(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get())
                .add(ModBlocks.ACACIA_WOOD_FENCE_GATE.get())
                .add(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get())
                .add(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get())
                .add(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE.get())
                .add(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE.get());
        tag(Tags.Blocks.FENCES_NETHER_BRICK).add(ModBlocks.RED_NETHER_BRICK_FENCE.get());
        tag(Tags.Blocks.FENCES_WOODEN)
                .add(ModBlocks.OAK_WOOD_FENCE.get())
                .add(ModBlocks.SPRUCE_WOOD_FENCE.get())
                .add(ModBlocks.BIRCH_WOOD_FENCE.get())
                .add(ModBlocks.JUNGLE_WOOD_FENCE.get())
                .add(ModBlocks.ACACIA_WOOD_FENCE.get())
                .add(ModBlocks.DARK_OAK_WOOD_FENCE.get())
                .add(ModBlocks.CRIMSON_HYPHAE_FENCE.get())
                .add(ModBlocks.WARPED_HYPHAE_FENCE.get())
                .add(ModBlocks.STRIPPED_OAK_WOOD_FENCE.get())
                .add(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE.get())
                .add(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE.get())
                .add(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE.get())
                .add(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE.get())
                .add(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE.get())
                .add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE.get())
                .add(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE.get())
                .add(ModBlocks.RED_NETHER_BRICK_FENCE.get());
        tag(ModTags.STORAGE_BLOCKS_CHARCOAL).add(ModBlocks.CHARCOAL_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_SUGAR).add(ModBlocks.SUGAR_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_SUGAR_CANE).add(ModBlocks.SUGAR_CANE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_GUNPOWDER).add(ModBlocks.GUNPOWDER_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_BLAZE_POWDER).add(ModBlocks.BLAZE_POWDER_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_MAGMA_CREAM).add(ModBlocks.MAGMA_CREAM_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_PRISMARINE_CRYSTAL).add(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_WITHER_BONE).add(ModBlocks.WITHER_BONE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_WHITE_DYE).add(ModBlocks.WHITE_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_ORANGE_DYE).add(ModBlocks.ORANGE_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_MAGENTA_DYE).add(ModBlocks.MAGENTA_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_LIGHT_BLUE_DYE).add(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_YELLOW_DYE).add(ModBlocks.YELLOW_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_LIME_DYE).add(ModBlocks.LIME_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_PINK_DYE).add(ModBlocks.PINK_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_GRAY_DYE).add(ModBlocks.GRAY_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_LIGHT_GRAY_DYE).add(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_CYAN_DYE).add(ModBlocks.CYAN_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_PURPLE_DYE).add(ModBlocks.PURPLE_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_BLUE_DYE).add(ModBlocks.BLUE_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_BROWN_DYE).add(ModBlocks.BROWN_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_GREEN_DYE).add(ModBlocks.GREEN_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_RED_DYE).add(ModBlocks.RED_DYE_BLOCK.get());
        tag(ModTags.STORAGE_BLOCKS_BLACK_DYE).add(ModBlocks.BLACK_DYE_BLOCK.get());
        tag(ModTags.CAKES)
                .add(Blocks.CAKE)
                .add(ModBlocks.CHOCOLATE_CAKE.get())
                .add(ModBlocks.BERRY_CAKE.get())
                .add(ModBlocks.CARROT_CAKE.get());
        tag(Tags.Blocks.FENCE_GATES).addTags(ModTags.FENCE_GATES_NETHER_BRICK);
        tag(ModTags.LADDERS)
                .add(ModBlocks.SPRUCE_LADDER.get())
                .add(ModBlocks.BIRCH_LADDER.get())
                .add(ModBlocks.JUNGLE_LADDER.get())
                .add(ModBlocks.ACACIA_LADDER.get())
                .add(ModBlocks.DARK_OAK_LADDER.get())
                .add(ModBlocks.CRIMSON_LADDER.get())
                .add(ModBlocks.WARPED_LADDER.get());
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTags(ModTags.STORAGE_BLOCKS_CHARCOAL)
                .addTags(ModTags.STORAGE_BLOCKS_SUGAR)
                .addTags(ModTags.STORAGE_BLOCKS_SUGAR_CANE)
                .addTags(ModTags.STORAGE_BLOCKS_GUNPOWDER)
                .addTags(ModTags.STORAGE_BLOCKS_BLAZE_POWDER)
                .addTags(ModTags.STORAGE_BLOCKS_MAGMA_CREAM)
                .addTags(ModTags.STORAGE_BLOCKS_PRISMARINE_CRYSTAL)
                .addTags(ModTags.STORAGE_BLOCKS_WITHER_BONE)
                .addTags(ModTags.STORAGE_BLOCKS_WHITE_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_ORANGE_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_MAGENTA_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_LIGHT_BLUE_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_YELLOW_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_LIME_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_PINK_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_GRAY_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_LIGHT_GRAY_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_CYAN_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_PURPLE_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_BLUE_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_BROWN_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_GREEN_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_RED_DYE)
                .addTags(ModTags.STORAGE_BLOCKS_BLACK_DYE);

        //Vanilla
        tag(BlockTags.BASE_STONE_OVERWORLD).add(ModBlocks.PERIDOTITE.get());
        Utils.CANDLES.forEach(candle -> tag(BlockTags.CANDLE_CAKES).add(((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).byCandle((CandleBlock) candle)));
        Utils.CANDLES.forEach(candle -> tag(BlockTags.CANDLE_CAKES).add(((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).byCandle((CandleBlock) candle)));
        Utils.CANDLES.forEach(candle -> tag(BlockTags.CANDLE_CAKES).add(((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).byCandle((CandleBlock) candle)));
        tag(BlockTags.CLIMBABLE)
                .add(ModBlocks.SPRUCE_LADDER.get())
                .add(ModBlocks.BIRCH_LADDER.get())
                .add(ModBlocks.JUNGLE_LADDER.get())
                .add(ModBlocks.ACACIA_LADDER.get())
                .add(ModBlocks.DARK_OAK_LADDER.get())
                .add(ModBlocks.CRIMSON_LADDER.get())
                .add(ModBlocks.WARPED_LADDER.get());

    }
}
