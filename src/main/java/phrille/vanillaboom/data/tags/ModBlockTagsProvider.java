package phrille.vanillaboom.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.util.Utils;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VanillaBoom.MOD_ID, existingFileHelper);
        Utils.registerCandleCakes();
    }

    @Override
    protected void addTags() {
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
