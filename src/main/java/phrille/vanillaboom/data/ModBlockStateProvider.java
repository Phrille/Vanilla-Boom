package phrille.vanillaboom.data;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.RainDetectorBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, VanillaBoom.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Bricks
        simpleBlock(ModBlocks.COBBLESTONE_BRICKS);
        simpleBlock(ModBlocks.MOSSY_COBBLESTONE_BRICKS);
        simpleBlock(ModBlocks.MAGMA_BRICKS);
        simpleBlock(ModBlocks.OBSIDIAN_BRICKS);
        simpleBlock(ModBlocks.SNOW_BRICKS);
        simpleBlock(ModBlocks.TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.WHITE_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.ORANGE_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.YELLOW_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.LIME_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.PINK_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.GRAY_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.CYAN_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.PURPLE_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.BLUE_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.BROWN_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.GREEN_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.RED_TERRACOTTA_BRICKS);
        simpleBlock(ModBlocks.BLACK_TERRACOTTA_BRICKS);

        //Rocks
        simpleBlock(ModBlocks.PERIDOTITE);
        simpleBlock(ModBlocks.HYDRO_ROCK);
        simpleBlock(ModBlocks.INFERNAL_ROCK);

        //Sand and Gravel
        simpleBlock(ModBlocks.BONE_SAND);
        simpleBlock(ModBlocks.WITHER_BONE_SAND);
        simpleBlock(ModBlocks.FINE_GRAVEL);
        simpleBlock(ModBlocks.GRAVEL_STONE);
        simpleBlock(ModBlocks.FINE_GRAVEL_STONE);
        simpleBlock(ModBlocks.GRAVEL_BRICKS);

        //Polished
        simpleBlock(ModBlocks.POLISHED_PERIDOTITE);
        simpleBlock(ModBlocks.POLISHED_PRISMARINE);
        simpleBlock(ModBlocks.POLISHED_DARK_PRISMARINE);
        simpleBlock(ModBlocks.POLISHED_END_STONE);
        simpleBlock(ModBlocks.POLISHED_NETHERRACK);

        //Chiseled and cracked
        simpleBlock(ModBlocks.CRACKED_RED_NETHER_BRICKS);
        simpleBlock(ModBlocks.CHISELED_RED_NETHER_BRICKS);
        simpleBlock(ModBlocks.CHISELED_PURPUR_BLOCK);
        simpleBlock(ModBlocks.CHISELED_OBSIDIAN);

        //Pillars
        pillarBlock(ModBlocks.GRANITE_PILLAR);
        pillarBlock(ModBlocks.DIORITE_PILLAR);
        pillarBlock(ModBlocks.ANDESITE_PILLAR);
        pillarBlock(ModBlocks.PERIDOTITE_PILLAR);
        pillarBlock(ModBlocks.PRISMARINE_PILLAR);
        pillarBlock(ModBlocks.DARK_PRISMARINE_PILLAR);
        pillarBlock(ModBlocks.END_STONE_PILLAR);
        pillarBlock(ModBlocks.NETHERRACK_PILLAR);
        pillarBlock(ModBlocks.RED_NETHER_PILLAR);
        pillarBlock(ModBlocks.OBSIDIAN_PILLAR);

        //Wood Variations
        bookshelfBlock(ModBlocks.SPRUCE_BOOKSHELF, Blocks.SPRUCE_PLANKS);
        bookshelfBlock(ModBlocks.BIRCH_BOOKSHELF, Blocks.BIRCH_PLANKS);
        bookshelfBlock(ModBlocks.JUNGLE_BOOKSHELF, Blocks.JUNGLE_PLANKS);
        bookshelfBlock(ModBlocks.ACACIA_BOOKSHELF, Blocks.ACACIA_PLANKS);
        bookshelfBlock(ModBlocks.DARK_OAK_BOOKSHELF, Blocks.DARK_OAK_PLANKS);
        bookshelfBlock(ModBlocks.CRIMSON_BOOKSHELF, Blocks.CRIMSON_PLANKS);
        bookshelfBlock(ModBlocks.WARPED_BOOKSHELF, Blocks.WARPED_PLANKS);
        ladderBlock(ModBlocks.SPRUCE_LADDER);
        ladderBlock(ModBlocks.BIRCH_LADDER);
        ladderBlock(ModBlocks.JUNGLE_LADDER);
        ladderBlock(ModBlocks.ACACIA_LADDER);
        ladderBlock(ModBlocks.DARK_OAK_LADDER);
        ladderBlock(ModBlocks.CRIMSON_LADDER);
        ladderBlock(ModBlocks.WARPED_LADDER);

        //Storage Blocks
        simpleBlock(ModBlocks.CHARCOAL_BLOCK);
        simpleBlock(ModBlocks.SUGAR_BLOCK);
        pillarBlock(ModBlocks.SUGAR_CANE_BLOCK);
        pillarBlock(ModBlocks.BAMBOO_BLOCK);
        simpleBlock(ModBlocks.GUNPOWDER_BLOCK);
        simpleBlock(ModBlocks.BLAZE_POWDER_BLOCK);
        sideBottomTopBlock(ModBlocks.MAGMA_CREAM_BLOCK);
        simpleBlock(ModBlocks.PRISMARINE_CRYSTAL_BLOCK);
        pillarBlock(ModBlocks.WITHER_BONE_BLOCK);
        simpleBlock(ModBlocks.WHITE_DYE_BLOCK);
        simpleBlock(ModBlocks.ORANGE_DYE_BLOCK);
        simpleBlock(ModBlocks.MAGENTA_DYE_BLOCK);
        simpleBlock(ModBlocks.LIGHT_BLUE_DYE_BLOCK);
        simpleBlock(ModBlocks.YELLOW_DYE_BLOCK);
        simpleBlock(ModBlocks.LIME_DYE_BLOCK);
        simpleBlock(ModBlocks.PINK_DYE_BLOCK);
        simpleBlock(ModBlocks.GRAY_DYE_BLOCK);
        simpleBlock(ModBlocks.LIGHT_GRAY_DYE_BLOCK);
        simpleBlock(ModBlocks.CYAN_DYE_BLOCK);
        simpleBlock(ModBlocks.PURPLE_DYE_BLOCK);
        simpleBlock(ModBlocks.BLUE_DYE_BLOCK);
        simpleBlock(ModBlocks.BROWN_DYE_BLOCK);
        simpleBlock(ModBlocks.GREEN_DYE_BLOCK);
        simpleBlock(ModBlocks.RED_DYE_BLOCK);
        simpleBlock(ModBlocks.BLACK_DYE_BLOCK);

        //Glass
        simpleBlock(ModBlocks.SOUL_GLASS);
        simpleBlock(ModBlocks.WHITE_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.ORANGE_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.MAGENTA_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.YELLOW_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.LIME_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.PINK_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.GRAY_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.CYAN_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.PURPLE_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.BLUE_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.BROWN_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.GREEN_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.RED_STAINED_SOUL_GLASS);
        simpleBlock(ModBlocks.BLACK_STAINED_SOUL_GLASS);

        glassPaneBlock(ModBlocks.SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.RED_STAINED_SOUL_GLASS_PANE);
        glassPaneBlock(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE);

        //Misc
        rainDetectorBlock(ModBlocks.RAIN_DETECTOR);
        barsBlock(ModBlocks.GOLD_BARS);
        flowerBlock(ModBlocks.ROSE, ModBlocks.POTTED_ROSE);
    }

    public void pillarBlock(Block block) {
        axisBlock((RotatedPillarBlock) block, extend(blockTexture(block), "_side"), extend(blockTexture(block), "_top"));
    }

    public void sideBottomTopBlock(Block block) {
        simpleBlock(block, models().cubeBottomTop(name(block), extend(blockTexture(block), "_side"), extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top")));
    }

    public void bookshelfBlock(Block block, Block plank) {
        simpleBlock(block, models().cubeColumn(name(block), blockTexture(block), blockTexture(plank)));
    }

    public void glassPaneBlock(Block block) {
        paneBlock((IronBarsBlock) block, shrink(blockTexture(block), "_pane"), extend(blockTexture(block), "_top"));
    }

    public void barsBlock(Block block) {
        paneBlock((IronBarsBlock) block, blockTexture(block), blockTexture(block));
    }

    public void flowerBlock(Block flower, Block pot) {
        simpleBlock(flower, models().cross(name(flower), blockTexture(flower)));
        simpleBlock(pot, models().withExistingParent(name(pot), ModelProvider.BLOCK_FOLDER + "/flower_pot_cross").texture("plant", blockTexture(flower)));
    }

    public void ladderBlock(Block block) {
        ladderBlock((LadderBlock) block, models().withExistingParent(name(block), modParent("ladder")).texture("texture", blockTexture(block)));
    }

    protected void ladderBlock(LadderBlock block, ModelFile model){
        getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction dir = state.getValue(LadderBlock.FACING);

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) dir.getOpposite().toYRot())
                    .build();
        }, LadderBlock.WATERLOGGED);
    }

    public void rainDetectorBlock(Block block) {
        ModelFile defaultModel = rainDetectorModel(name(block), extend(blockTexture(block), "_top"));
        ModelFile invertedModel = rainDetectorModel(name(block) + "_inverted", extend(blockTexture(block), "_inverted_top"));

        rainDetectorBlock((RainDetectorBlock) block, defaultModel, invertedModel);
    }

    protected void rainDetectorBlock(RainDetectorBlock block, ModelFile defaultModel, ModelFile invertedModel) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            boolean inverted = state.getValue(RainDetectorBlock.INVERTED);

            return ConfiguredModel.builder()
                    .modelFile(inverted ? invertedModel : defaultModel)
                    .build();
        }, RainDetectorBlock.POWER);
    }

    protected BlockModelBuilder rainDetectorModel(String name, ResourceLocation top) {
        return models().withExistingParent(name, ModelProvider.BLOCK_FOLDER + "/template_daylight_detector")
                .texture("side", extend(blockTexture(Blocks.DAYLIGHT_DETECTOR), "_side"))
                .texture("top", top);
    }

    protected String name(Block block) {
        return block.getRegistryName().getPath();
    }

    protected ResourceLocation modParent(String name){
        return modLoc(ModelProvider.BLOCK_FOLDER + "/parent/" + name);
    }

    protected ResourceLocation extend(ResourceLocation rl, String extend) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + extend);
    }

    protected ResourceLocation shrink(ResourceLocation rl, String shrink) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath().replace(shrink, ""));
    }
}
