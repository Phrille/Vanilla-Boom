package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

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
    }
}
