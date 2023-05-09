package phrille.vanillaboom.data;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.*;
import phrille.vanillaboom.util.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, VanillaBoom.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Bricks
        simpleBlock(ModBlocks2.COBBLESTONE_BRICKS.get());
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
        cropBlock(ModBlocks.TOMATO_PLANT);
        cropBlock(ModBlocks.RICE_PLANT, RicePlantBlock.AGE);

        //Cakes
        cakeBlock(ModBlocks.CHOCOLATE_CAKE);
        cakeBlock(ModBlocks.CARROT_CAKE);
        cakeBlock(ModBlocks.BERRY_CAKE);

        //Stairs
        stairsBlock(ModBlocks2.COBBLESTONE_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS);
        stairsBlock(ModBlocks.MAGMA_BRICK_STAIRS);
        stairsBlock(ModBlocks.OBSIDIAN_BRICK_STAIRS);
        stairsBlock(ModBlocks.SNOW_BRICK_STAIRS);
        stairsBlock(ModBlocks.TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.RED_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS);
        stairsBlock(ModBlocks.PERIDOTITE_STAIRS);
        stairsBlock(ModBlocks.HYDRO_ROCK_STAIRS);
        stairsBlock(ModBlocks.INFERNAL_ROCK_STAIRS);
        stairsBlock(ModBlocks.POLISHED_PERIDOTITE_STAIRS);
        stairsBlock(ModBlocks.POLISHED_PRISMARINE_STAIRS);
        stairsBlock(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS);
        stairsBlock(ModBlocks.POLISHED_END_STONE_STAIRS);
        stairsBlock(ModBlocks.POLISHED_NETHERRACK_STAIRS);
        stairsBlock(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS);
        stairsBlock(ModBlocks.CHISELED_RED_NETHER_BRICK_STAIRS);
        stairsBlock(ModBlocks.CHISELED_PURPUR_BLOCK_STAIRS);
        stairsBlock(ModBlocks.CHISELED_OBSIDIAN_STAIRS);

        
        //Vanilla Stairs
        stairsBlock(ModBlocks.CRACKED_STONE_BRICK_STAIRS);
        stairsBlock(ModBlocks.CHISELED_STONE_BRICK_STAIRS);
        stairsBlock(ModBlocks.CHISELED_SANDSTONE_STAIRS, extend(blockTexture(Blocks.SANDSTONE), "_top"));
        stairsBlock(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS, extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        stairsBlock(ModBlocks.IRON_BLOCK_STAIRS);
        stairsBlock(ModBlocks.GOLD_BLOCK_STAIRS);
        stairsBlock(ModBlocks.OBSIDIAN_STAIRS);
        stairsBlock(ModBlocks.BEDROCK_STAIRS);
        stairsBlock(ModBlocks.NETHERRACK_STAIRS);
        stairsBlock(ModBlocks.CRACKED_NETHER_BRICK_STAIRS);
        stairsBlock(ModBlocks.CHISELED_NETHER_BRICK_STAIRS);
        stairsBlock(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
        stairsBlock(ModBlocks.CHISELED_POLISHED_BLACKSTONE_STAIRS);
        stairsBlock(ModBlocks.END_STONE_STAIRS);
        stairsBlock(ModBlocks.CHISELED_QUARTZ_BLOCK_STAIRS);
        stairsBlock(ModBlocks.QUARTZ_BRICK_STAIRS);
        stairsBlock(ModBlocks.TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.WHITE_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.ORANGE_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.MAGENTA_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.YELLOW_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.LIME_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.PINK_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.GRAY_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.CYAN_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.PURPLE_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.BLUE_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.BROWN_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.GREEN_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.RED_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.BLACK_TERRACOTTA_STAIRS);
        stairsBlock(ModBlocks.WHITE_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.ORANGE_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.MAGENTA_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.YELLOW_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.LIME_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.PINK_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.GRAY_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.CYAN_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.PURPLE_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.BLUE_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.BROWN_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.GREEN_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.RED_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.BLACK_CONCRETE_STAIRS);
        stairsBlock(ModBlocks.OAK_WOOD_STAIRS);
        stairsBlock(ModBlocks.SPRUCE_WOOD_STAIRS);
        stairsBlock(ModBlocks.BIRCH_WOOD_STAIRS);
        stairsBlock(ModBlocks.JUNGLE_WOOD_STAIRS);
        stairsBlock(ModBlocks.ACACIA_WOOD_STAIRS);
        stairsBlock(ModBlocks.DARK_OAK_WOOD_STAIRS);
        stairsBlock(ModBlocks.CRIMSON_HYPHAE_STAIRS);
        stairsBlock(ModBlocks.WARPED_HYPHAE_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_OAK_WOOD_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_STAIRS);
        stairsBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_STAIRS);
        stairsBlock(ModBlocks.CUT_SANDSTONE_STAIRS, extend(blockTexture(Blocks.SANDSTONE), "_top"));
        stairsBlock(ModBlocks.CUT_RED_SANDSTONE_STAIRS, extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        stairsBlock(ModBlocks.SMOOTH_STONE_STAIRS);

        //Slabs
        slabBlock(ModBlocks2.COBBLESTONE_BRICK_SLAB.get());
        slabBlock(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB);
        slabBlock(ModBlocks.MAGMA_BRICK_SLAB);
        slabBlock(ModBlocks.OBSIDIAN_BRICK_SLAB);
        slabBlock(ModBlocks.SNOW_BRICK_SLAB);
        slabBlock(ModBlocks.TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.LIME_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.PINK_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.RED_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB);
        slabBlock(ModBlocks.PERIDOTITE_SLAB);
        slabBlock(ModBlocks.HYDRO_ROCK_SLAB);
        slabBlock(ModBlocks.INFERNAL_ROCK_SLAB);
        slabBlock(ModBlocks.POLISHED_PERIDOTITE_SLAB);
        slabBlock(ModBlocks.POLISHED_PRISMARINE_SLAB);
        slabBlock(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB);
        slabBlock(ModBlocks.POLISHED_END_STONE_SLAB);
        slabBlock(ModBlocks.POLISHED_NETHERRACK_SLAB);
        slabBlock(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB);
        slabBlock(ModBlocks.CHISELED_RED_NETHER_BRICK_SLAB);
        slabBlock(ModBlocks.CHISELED_PURPUR_BLOCK_SLAB);
        slabBlock(ModBlocks.CHISELED_OBSIDIAN_SLAB);

        //Vanilla Slabs
        slabBlock(ModBlocks.CRACKED_STONE_BRICK_SLAB);
        slabBlock(ModBlocks.CHISELED_STONE_BRICK_SLAB);
        slabBlock(ModBlocks.CHISELED_SANDSTONE_SLAB, extend(blockTexture(Blocks.SANDSTONE), "_top"));
        slabBlock(ModBlocks.CHISELED_RED_SANDSTONE_SLAB, extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        slabBlock(ModBlocks.IRON_BLOCK_SLAB);
        slabBlock(ModBlocks.GOLD_BLOCK_SLAB);
        slabBlock(ModBlocks.OBSIDIAN_SLAB);
        slabBlock(ModBlocks.BEDROCK_SLAB);
        slabBlock(ModBlocks.NETHERRACK_SLAB);
        slabBlock(ModBlocks.CRACKED_NETHER_BRICK_SLAB);
        slabBlock(ModBlocks.CHISELED_NETHER_BRICK_SLAB);
        slabBlock(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
        slabBlock(ModBlocks.CHISELED_POLISHED_BLACKSTONE_SLAB);
        slabBlock(ModBlocks.END_STONE_SLAB);
        slabBlock(ModBlocks.CHISELED_QUARTZ_BLOCK_SLAB);
        slabBlock(ModBlocks.QUARTZ_BRICK_SLAB);
        slabBlock(ModBlocks.TERRACOTTA_SLAB);
        slabBlock(ModBlocks.WHITE_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.ORANGE_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.MAGENTA_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.YELLOW_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.LIME_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.PINK_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.GRAY_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.CYAN_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.PURPLE_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.BLUE_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.BROWN_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.GREEN_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.RED_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.BLACK_TERRACOTTA_SLAB);
        slabBlock(ModBlocks.WHITE_CONCRETE_SLAB);
        slabBlock(ModBlocks.ORANGE_CONCRETE_SLAB);
        slabBlock(ModBlocks.MAGENTA_CONCRETE_SLAB);
        slabBlock(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        slabBlock(ModBlocks.YELLOW_CONCRETE_SLAB);
        slabBlock(ModBlocks.LIME_CONCRETE_SLAB);
        slabBlock(ModBlocks.PINK_CONCRETE_SLAB);
        slabBlock(ModBlocks.GRAY_CONCRETE_SLAB);
        slabBlock(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        slabBlock(ModBlocks.CYAN_CONCRETE_SLAB);
        slabBlock(ModBlocks.PURPLE_CONCRETE_SLAB);
        slabBlock(ModBlocks.BLUE_CONCRETE_SLAB);
        slabBlock(ModBlocks.BROWN_CONCRETE_SLAB);
        slabBlock(ModBlocks.GREEN_CONCRETE_SLAB);
        slabBlock(ModBlocks.RED_CONCRETE_SLAB);
        slabBlock(ModBlocks.BLACK_CONCRETE_SLAB);
        slabBlock(ModBlocks.OAK_WOOD_SLAB);
        slabBlock(ModBlocks.SPRUCE_WOOD_SLAB);
        slabBlock(ModBlocks.BIRCH_WOOD_SLAB);
        slabBlock(ModBlocks.JUNGLE_WOOD_SLAB);
        slabBlock(ModBlocks.ACACIA_WOOD_SLAB);
        slabBlock(ModBlocks.DARK_OAK_WOOD_SLAB);
        slabBlock(ModBlocks.CRIMSON_HYPHAE_SLAB);
        slabBlock(ModBlocks.WARPED_HYPHAE_SLAB);
        slabBlock(ModBlocks.STRIPPED_OAK_WOOD_SLAB);
        slabBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB);
        slabBlock(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB);
        slabBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB);
        slabBlock(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB);
        slabBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB);
        slabBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_SLAB);
        slabBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_SLAB);

        //VanillaBoom Walls
        wallBlock(ModBlocks2.COBBLESTONE_BRICK_WALL.get());
        wallBlock(ModBlocks.MOSSY_COBBLESTONE_BRICK_WALL);
        wallBlock(ModBlocks.MAGMA_BRICK_WALL);
        wallBlock(ModBlocks.OBSIDIAN_BRICK_WALL);
        wallBlock(ModBlocks.SNOW_BRICK_WALL);
        wallBlock(ModBlocks.TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.WHITE_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.LIME_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.PINK_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.GRAY_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.CYAN_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.BLUE_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.BROWN_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.GREEN_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.RED_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.BLACK_TERRACOTTA_BRICK_WALL);
        wallBlock(ModBlocks.PERIDOTITE_WALL);
        wallBlock(ModBlocks.HYDRO_ROCK_WALL);
        wallBlock(ModBlocks.INFERNAL_ROCK_WALL);
        wallBlock(ModBlocks.POLISHED_PERIDOTITE_WALL);
        wallBlock(ModBlocks.POLISHED_PRISMARINE_WALL);
        wallBlock(ModBlocks.POLISHED_DARK_PRISMARINE_WALL);
        wallBlock(ModBlocks.POLISHED_END_STONE_WALL);
        wallBlock(ModBlocks.POLISHED_NETHERRACK_WALL);
        wallBlock(ModBlocks.CHISELED_PURPUR_BLOCK_WALL);
        wallBlock(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL);
        wallBlock(ModBlocks.CHISELED_RED_NETHER_BRICK_WALL);
        wallBlock(ModBlocks.CHISELED_OBSIDIAN_WALL);

        //Vanilla Walls
        wallBlock(ModBlocks.CRACKED_STONE_BRICK_WALL);
        wallBlock(ModBlocks.CHISELED_STONE_BRICK_WALL);
        wallBlock(ModBlocks.CHISELED_SANDSTONE_WALL);
        wallBlock(ModBlocks.CHISELED_RED_SANDSTONE_WALL);
        wallBlock(ModBlocks.IRON_BLOCK_WALL);
        wallBlock(ModBlocks.GOLD_BLOCK_WALL);
        wallBlock(ModBlocks.OBSIDIAN_WALL);
        wallBlock(ModBlocks.BEDROCK_WALL);
        wallBlock(ModBlocks.NETHERRACK_WALL);
        wallBlock(ModBlocks.CRACKED_NETHER_BRICK_WALL);
        wallBlock(ModBlocks.CHISELED_NETHER_BRICK_WALL);
        wallBlock(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);
        wallBlock(ModBlocks.CHISELED_POLISHED_BLACKSTONE_WALL);
        wallBlock(ModBlocks.END_STONE_WALL);
        wallBlock(ModBlocks.CHISELED_QUARTZ_BLOCK_WALL);
        wallBlock(ModBlocks.QUARTZ_BRICK_WALL);
        wallBlock(ModBlocks.TERRACOTTA_WALL);
        wallBlock(ModBlocks.WHITE_TERRACOTTA_WALL);
        wallBlock(ModBlocks.ORANGE_TERRACOTTA_WALL);
        wallBlock(ModBlocks.MAGENTA_TERRACOTTA_WALL);
        wallBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL);
        wallBlock(ModBlocks.YELLOW_TERRACOTTA_WALL);
        wallBlock(ModBlocks.LIME_TERRACOTTA_WALL);
        wallBlock(ModBlocks.PINK_TERRACOTTA_WALL);
        wallBlock(ModBlocks.GRAY_TERRACOTTA_WALL);
        wallBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL);
        wallBlock(ModBlocks.CYAN_TERRACOTTA_WALL);
        wallBlock(ModBlocks.PURPLE_TERRACOTTA_WALL);
        wallBlock(ModBlocks.BLUE_TERRACOTTA_WALL);
        wallBlock(ModBlocks.BROWN_TERRACOTTA_WALL);
        wallBlock(ModBlocks.GREEN_TERRACOTTA_WALL);
        wallBlock(ModBlocks.RED_TERRACOTTA_WALL);
        wallBlock(ModBlocks.BLACK_TERRACOTTA_WALL);
        wallBlock(ModBlocks.WHITE_CONCRETE_WALL);
        wallBlock(ModBlocks.ORANGE_CONCRETE_WALL);
        wallBlock(ModBlocks.MAGENTA_CONCRETE_WALL);
        wallBlock(ModBlocks.LIGHT_BLUE_CONCRETE_WALL);
        wallBlock(ModBlocks.YELLOW_CONCRETE_WALL);
        wallBlock(ModBlocks.LIME_CONCRETE_WALL);
        wallBlock(ModBlocks.PINK_CONCRETE_WALL);
        wallBlock(ModBlocks.GRAY_CONCRETE_WALL);
        wallBlock(ModBlocks.LIGHT_GRAY_CONCRETE_WALL);
        wallBlock(ModBlocks.CYAN_CONCRETE_WALL);
        wallBlock(ModBlocks.PURPLE_CONCRETE_WALL);
        wallBlock(ModBlocks.BLUE_CONCRETE_WALL);
        wallBlock(ModBlocks.BROWN_CONCRETE_WALL);
        wallBlock(ModBlocks.GREEN_CONCRETE_WALL);
        wallBlock(ModBlocks.RED_CONCRETE_WALL);
        wallBlock(ModBlocks.BLACK_CONCRETE_WALL);
        wallBlock(ModBlocks.CUT_SANDSTONE_WALL);
        wallBlock(ModBlocks.CUT_RED_SANDSTONE_WALL);
        wallBlock(ModBlocks.SMOOTH_STONE_WALL);
        wallBlock(ModBlocks.STONE_WALL);
        wallBlock(ModBlocks.POLISHED_GRANITE_WALL);
        wallBlock(ModBlocks.POLISHED_DIORITE_WALL);
        wallBlock(ModBlocks.POLISHED_ANDESITE_WALL);
        wallBlock(ModBlocks.SMOOTH_SANDSTONE_WALL);
        wallBlock(ModBlocks.SMOOTH_RED_SANDSTONE_WALL);
        wallBlock(ModBlocks.PURPUR_BLOCK_WALL);
        wallBlock(ModBlocks.QUARTZ_BLOCK_WALL);
        wallBlock(ModBlocks.SMOOTH_QUARTZ_WALL);
        wallBlock(ModBlocks.PRISMARINE_BRICK_WALL);
        wallBlock(ModBlocks.DARK_PRISMARINE_WALL);

        //Vanilla Fences
        fenceBlock(ModBlocks.OAK_WOOD_FENCE, Blocks.OAK_WOOD);
        fenceBlock(ModBlocks.SPRUCE_WOOD_FENCE, Blocks.SPRUCE_WOOD);
        fenceBlock(ModBlocks.BIRCH_WOOD_FENCE, Blocks.BIRCH_WOOD);
        fenceBlock(ModBlocks.JUNGLE_WOOD_FENCE, Blocks.JUNGLE_WOOD);
        fenceBlock(ModBlocks.ACACIA_WOOD_FENCE, Blocks.ACACIA_WOOD);
        fenceBlock(ModBlocks.DARK_OAK_WOOD_FENCE, Blocks.DARK_OAK_WOOD);
        fenceBlock(ModBlocks.CRIMSON_HYPHAE_FENCE, Blocks.CRIMSON_HYPHAE);
        fenceBlock(ModBlocks.WARPED_HYPHAE_FENCE, Blocks.WARPED_HYPHAE);
        fenceBlock(ModBlocks.STRIPPED_OAK_WOOD_FENCE, Blocks.STRIPPED_OAK_WOOD);
        fenceBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE, Blocks.STRIPPED_SPRUCE_WOOD);
        fenceBlock(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE, Blocks.STRIPPED_BIRCH_WOOD);
        fenceBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE, Blocks.STRIPPED_JUNGLE_WOOD);
        fenceBlock(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE, Blocks.STRIPPED_ACACIA_WOOD);
        fenceBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE, Blocks.STRIPPED_DARK_OAK_WOOD);
        fenceBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE, Blocks.STRIPPED_CRIMSON_HYPHAE);
        fenceBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE, Blocks.STRIPPED_WARPED_HYPHAE);
        fenceBlock(ModBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);
        fenceGateBlock(ModBlocks.OAK_WOOD_FENCE_GATE, Blocks.OAK_WOOD);
        fenceGateBlock(ModBlocks.SPRUCE_WOOD_FENCE_GATE, Blocks.SPRUCE_WOOD);
        fenceGateBlock(ModBlocks.BIRCH_WOOD_FENCE_GATE, Blocks.BIRCH_WOOD);
        fenceGateBlock(ModBlocks.JUNGLE_WOOD_FENCE_GATE, Blocks.JUNGLE_WOOD);
        fenceGateBlock(ModBlocks.ACACIA_WOOD_FENCE_GATE, Blocks.ACACIA_WOOD);
        fenceGateBlock(ModBlocks.DARK_OAK_WOOD_FENCE_GATE, Blocks.DARK_OAK_WOOD);
        fenceGateBlock(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE, Blocks.CRIMSON_HYPHAE);
        fenceGateBlock(ModBlocks.WARPED_HYPHAE_FENCE_GATE, Blocks.WARPED_HYPHAE);
        fenceGateBlock(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE, Blocks.STRIPPED_OAK_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE, Blocks.STRIPPED_SPRUCE_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE, Blocks.STRIPPED_BIRCH_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE, Blocks.STRIPPED_JUNGLE_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE, Blocks.STRIPPED_ACACIA_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE, Blocks.STRIPPED_DARK_OAK_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE, Blocks.STRIPPED_CRIMSON_HYPHAE);
        fenceGateBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE, Blocks.STRIPPED_WARPED_HYPHAE);
        fenceGateBlock(ModBlocks.NETHER_BRICK_FENCE_GATE, Blocks.NETHER_BRICKS);
        fenceGateBlock(ModBlocks.RED_NETHER_BRICK_FENCE_GATE, Blocks.RED_NETHER_BRICKS);
    }

    public void pillarBlock(Block block) {
        axisBlock((RotatedPillarBlock) block, extend(blockTexture(block), "_side"), extend(blockTexture(block), "_top"));
    }

    public void sideBottomTopBlock(Block block) {
        simpleBlock(block, models().cubeBottomTop(name(block), extend(blockTexture(block), "_side"), extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top")));
    }

    public void bookshelfBlock(Block bookshelf, Block plank) {
        simpleBlock(bookshelf, models().cubeColumn(name(bookshelf), blockTexture(bookshelf), blockTexture(plank)));
    }

    public void stairsBlock(Block block) {
        ModStairBlock stair = (ModStairBlock) block;
        stairsBlock(stair, variantTexture(stair.getParent()));
    }

    public void stairsBlock(Block block, ResourceLocation end) {
        ModStairBlock stair = (ModStairBlock) block;
        stairsBlock(stair, variantTexture(stair.getParent()), end, end);
    }

    public void slabBlock(Block block) {
        ModSlabBlock slab = (ModSlabBlock) block;
        slabBlock(slab, blockTexture(slab.getParent()), variantTexture(slab.getParent()));
    }

    public void slabBlock(Block block, ResourceLocation end) {
        ModSlabBlock slab = (ModSlabBlock) block;
        slabBlock(slab, blockTexture(slab.getParent()), variantTexture(slab.getParent()), end, end);
    }

    public void wallBlock(Block block) {
        ModWallBlock wall = (ModWallBlock) block;
        wallBlock(wall, variantTexture(wall.getParent()));
        models().withExistingParent(name(wall) + "_inventory", ModelProvider.BLOCK_FOLDER + "/wall_inventory").texture("wall", variantTexture(wall.getParent()));
    }

    public void fenceBlock(Block fence, Block parent){
        fenceBlock((FenceBlock) fence, variantTexture(parent));
        models().withExistingParent(name(fence) + "_inventory", ModelProvider.BLOCK_FOLDER + "/fence_inventory").texture("texture", variantTexture(parent));
    }

    public void fenceGateBlock(Block fenceGate, Block parent){
        fenceGateBlock((FenceGateBlock) fenceGate, variantTexture(parent));
    }

    public void glassPaneBlock(Block pane) {
        paneBlock((IronBarsBlock) pane, shrink(blockTexture(pane), "_pane"), extend(blockTexture(pane), "_top"));
    }

    public void barsBlock(Block bars) {
        paneBlock((IronBarsBlock) bars, blockTexture(bars), blockTexture(bars));
    }

    public void flowerBlock(Block flower, Block pot) {
        simpleBlock(flower, models().cross(name(flower), blockTexture(flower)));
        simpleBlock(pot, models().withExistingParent(name(pot), ModelProvider.BLOCK_FOLDER + "/flower_pot_cross").texture("plant", blockTexture(flower)));
    }

    public void ladderBlock(Block ladder) {
        ladderBlock((LadderBlock) ladder, models().withExistingParent(name(ladder), ModelProvider.BLOCK_FOLDER + "/ladder").texture("texture", blockTexture(ladder)));
    }

    protected void ladderBlock(LadderBlock ladder, ModelFile model) {
        getVariantBuilder(ladder).forAllStatesExcept(state -> {
            Direction dir = state.getValue(LadderBlock.FACING);

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) dir.getOpposite().toYRot())
                    .build();
        }, LadderBlock.WATERLOGGED);
    }

    public void cropBlock(Block crop) {
        cropBlock(crop, CropBlock.AGE);
    }

    public void cropBlock(Block crop, IntegerProperty ageProperty) {
        List<ModelFile> files = ageProperty.getAllValues()
                .map(age -> models().withExistingParent(name(crop) + "_stage" + age.value(), ModelProvider.BLOCK_FOLDER + "/crop").texture("crop", extend(blockTexture(crop), "_stage" + age.value())))
                .collect(Collectors.toList());
        cropBlock((CropBlock) crop, files, ageProperty);
    }

    protected void cropBlock(CropBlock crop, List<ModelFile> files, IntegerProperty ageProperty) {
        getVariantBuilder(crop).forAllStates(state -> {
            int age = state.getValue(ageProperty);

            return ConfiguredModel.builder()
                    .modelFile(files.get(age))
                    .build();
        });
    }

    public void rainDetectorBlock(Block rainDetector) {
        ModelFile defaultModel = rainDetectorModel(name(rainDetector), extend(blockTexture(rainDetector), "_top"));
        ModelFile invertedModel = rainDetectorModel(name(rainDetector) + "_inverted", extend(blockTexture(rainDetector), "_inverted_top"));

        rainDetectorBlock((RainDetectorBlock) rainDetector, defaultModel, invertedModel);
    }

    protected void rainDetectorBlock(RainDetectorBlock rainDetector, ModelFile defaultModel, ModelFile invertedModel) {
        getVariantBuilder(rainDetector).forAllStatesExcept(state -> {
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

    public void cakeBlock(Block cake) {
        List<ModelFile> files = CakeBlock.BITES.getAllValues()
                .map(bites -> cakeModel(cake, bites.value()))
                .collect(Collectors.toList());

        cakeBlock((CakeBlock) cake, files);

        for (Block candle : Utils.CANDLES) {
            Block candleCake = ModCakeBlock.CANDLE_CAKES.get(cake).get(candle);
            candleCakeBlock(cake, candleCake, candle);
        }
    }

    protected void cakeBlock(CakeBlock cake, List<ModelFile> files) {
        getVariantBuilder(cake).forAllStates(state -> {
            int bites = state.getValue(CakeBlock.BITES);

            return ConfiguredModel.builder()
                    .modelFile(files.get(bites))
                    .build();
        });
    }

    protected BlockModelBuilder cakeModel(Block cake, int bites) {
        BlockModelBuilder builder = models().withExistingParent(getCakeName(name(cake), bites), ModelProvider.BLOCK_FOLDER + getCakeName("/cake", bites))
                .texture("side", extend(blockTexture(cake), "_side"))
                .texture("top", extend(blockTexture(cake), "_top"))
                .texture("bottom", extend(blockTexture(cake), "_bottom"));

        return bites == 0 ? builder : builder.texture("inner", extend(blockTexture(cake), "_inner"));
    }

    public void candleCakeBlock(Block cake, Block candleCake, Block candle) {
        ModelFile defaultModel = candleCakeModel(cake, name(candleCake), blockTexture(candle));
        ModelFile litModel = candleCakeModel(cake, name(candleCake) + "_lit", extend(blockTexture(candle), "_lit"));

        candleCakeBlock((CandleCakeBlock) candleCake, defaultModel, litModel);
    }

    protected void candleCakeBlock(CandleCakeBlock candleCake, ModelFile defaultModel, ModelFile litModel) {
        getVariantBuilder(candleCake).forAllStates(state -> {
            boolean lit = state.getValue(CandleCakeBlock.LIT);

            return ConfiguredModel.builder()
                    .modelFile(lit ? litModel : defaultModel)
                    .build();
        });
    }

    protected BlockModelBuilder candleCakeModel(Block cake, String name, ResourceLocation candle) {
        return models().withExistingParent(name, ModelProvider.BLOCK_FOLDER + "/template_cake_with_candle")
                .texture("candle", candle)
                .texture("side", extend(blockTexture(cake), "_side"))
                .texture("top", extend(blockTexture(cake), "_top"))
                .texture("bottom", extend(blockTexture(cake), "_bottom"))
                .texture("particle", extend(blockTexture(cake), "_side"));
    }

    protected ResourceLocation extend(ResourceLocation rl, String extend) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + extend);
    }

    protected ResourceLocation shrink(ResourceLocation rl, String shrink) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath().replace(shrink, ""));
    }

    protected ResourceLocation variantTexture(Block block) {
        ResourceLocation name = block.getRegistryName();

        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath()
                .replace("_wood", "_log")
                .replace("_hyphae", "_stem")
                .replace("smooth_sandstone", "sandstone_top")
                .replace("smooth_red_sandstone", "red_sandstone_top")
                .replace("quartz_block", "quartz_block_side")
                .replace("chiseled_quartz_block_side", "chiseled_quartz_block")
                .replace("smooth_quartz", "quartz_block_bottom"));

    }

    protected String name(Block block) {
        return block.getRegistryName().getPath();
    }

    protected String getCakeName(String name, int bites) {
        return name + (bites == 0 ? "" : "_slice" + bites);
    }
}
