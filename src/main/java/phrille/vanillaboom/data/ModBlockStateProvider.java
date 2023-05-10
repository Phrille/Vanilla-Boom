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

import java.util.List;
import java.util.stream.Collectors;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, VanillaBoom.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Bricks
        simpleBlock(ModBlocks.COBBLESTONE_BRICKS.get());
        simpleBlock(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        simpleBlock(ModBlocks.MAGMA_BRICKS.get());
        simpleBlock(ModBlocks.OBSIDIAN_BRICKS.get());
        simpleBlock(ModBlocks.SNOW_BRICKS.get());
        simpleBlock(ModBlocks.TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.WHITE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.LIME_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.PINK_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.GRAY_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.CYAN_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.BLUE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.BROWN_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.GREEN_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.RED_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.BLACK_TERRACOTTA_BRICKS.get());

        //Rocks
        simpleBlock(ModBlocks.PERIDOTITE.get());
        simpleBlock(ModBlocks.HYDRO_ROCK.get());
        simpleBlock(ModBlocks.INFERNAL_ROCK.get());

        //Sand and Gravel
        simpleBlock(ModBlocks.BONE_SAND.get());
        simpleBlock(ModBlocks.WITHER_BONE_SAND.get());

        //Polished
        simpleBlock(ModBlocks.POLISHED_PERIDOTITE.get());
        simpleBlock(ModBlocks.POLISHED_PRISMARINE.get());
        simpleBlock(ModBlocks.POLISHED_DARK_PRISMARINE.get());
        simpleBlock(ModBlocks.POLISHED_END_STONE.get());
        simpleBlock(ModBlocks.POLISHED_NETHERRACK.get());

        //Chiseled and cracked
        simpleBlock(ModBlocks.CRACKED_RED_NETHER_BRICKS.get());
        simpleBlock(ModBlocks.CHISELED_RED_NETHER_BRICKS.get());
        simpleBlock(ModBlocks.CHISELED_PURPUR_BLOCK.get());
        simpleBlock(ModBlocks.CHISELED_OBSIDIAN.get());

        //Pillars
        pillarBlock(ModBlocks.GRANITE_PILLAR.get());
        pillarBlock(ModBlocks.DIORITE_PILLAR.get());
        pillarBlock(ModBlocks.ANDESITE_PILLAR.get());
        pillarBlock(ModBlocks.PERIDOTITE_PILLAR.get());
        pillarBlock(ModBlocks.PRISMARINE_PILLAR.get());
        pillarBlock(ModBlocks.DARK_PRISMARINE_PILLAR.get());
        pillarBlock(ModBlocks.END_STONE_PILLAR.get());
        pillarBlock(ModBlocks.NETHERRACK_PILLAR.get());
        pillarBlock(ModBlocks.RED_NETHER_PILLAR.get());
        pillarBlock(ModBlocks.OBSIDIAN_PILLAR.get());

        //Wood Variations
        bookshelfBlock(ModBlocks.SPRUCE_BOOKSHELF.get(), Blocks.SPRUCE_PLANKS);
        bookshelfBlock(ModBlocks.BIRCH_BOOKSHELF.get(), Blocks.BIRCH_PLANKS);
        bookshelfBlock(ModBlocks.JUNGLE_BOOKSHELF.get(), Blocks.JUNGLE_PLANKS);
        bookshelfBlock(ModBlocks.ACACIA_BOOKSHELF.get(), Blocks.ACACIA_PLANKS);
        bookshelfBlock(ModBlocks.DARK_OAK_BOOKSHELF.get(), Blocks.DARK_OAK_PLANKS);
        bookshelfBlock(ModBlocks.CRIMSON_BOOKSHELF.get(), Blocks.CRIMSON_PLANKS);
        bookshelfBlock(ModBlocks.WARPED_BOOKSHELF.get(), Blocks.WARPED_PLANKS);
        ladderBlock(ModBlocks.SPRUCE_LADDER.get());
        ladderBlock(ModBlocks.BIRCH_LADDER.get());
        ladderBlock(ModBlocks.JUNGLE_LADDER.get());
        ladderBlock(ModBlocks.ACACIA_LADDER.get());
        ladderBlock(ModBlocks.DARK_OAK_LADDER.get());
        ladderBlock(ModBlocks.CRIMSON_LADDER.get());
        ladderBlock(ModBlocks.WARPED_LADDER.get());

        //Storage Blocks
        simpleBlock(ModBlocks.CHARCOAL_BLOCK.get());
        simpleBlock(ModBlocks.SUGAR_BLOCK.get());
        pillarBlock(ModBlocks.SUGAR_CANE_BLOCK.get());
        pillarBlock(ModBlocks.BAMBOO_BLOCK.get());
        simpleBlock(ModBlocks.GUNPOWDER_BLOCK.get());
        simpleBlock(ModBlocks.BLAZE_POWDER_BLOCK.get());
        sideBottomTopBlock(ModBlocks.MAGMA_CREAM_BLOCK.get());
        simpleBlock(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        pillarBlock(ModBlocks.WITHER_BONE_BLOCK.get());
        simpleBlock(ModBlocks.WHITE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.ORANGE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.MAGENTA_DYE_BLOCK.get());
        simpleBlock(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.YELLOW_DYE_BLOCK.get());
        simpleBlock(ModBlocks.LIME_DYE_BLOCK.get());
        simpleBlock(ModBlocks.PINK_DYE_BLOCK.get());
        simpleBlock(ModBlocks.GRAY_DYE_BLOCK.get());
        simpleBlock(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get());
        simpleBlock(ModBlocks.CYAN_DYE_BLOCK.get());
        simpleBlock(ModBlocks.PURPLE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.BLUE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.BROWN_DYE_BLOCK.get());
        simpleBlock(ModBlocks.GREEN_DYE_BLOCK.get());
        simpleBlock(ModBlocks.RED_DYE_BLOCK.get());
        simpleBlock(ModBlocks.BLACK_DYE_BLOCK.get());

        //Glass
        simpleBlock(ModBlocks.SOUL_GLASS.get());
        simpleBlock(ModBlocks.WHITE_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.LIME_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.PINK_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.GRAY_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.CYAN_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.BLUE_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.BROWN_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.GREEN_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.RED_STAINED_SOUL_GLASS.get());
        simpleBlock(ModBlocks.BLACK_STAINED_SOUL_GLASS.get());

        glassPaneBlock(ModBlocks.SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get());

        //Misc
        rainDetectorBlock(ModBlocks.RAIN_DETECTOR.get());
        barsBlock(ModBlocks.GOLD_BARS.get());
        flowerBlock(ModBlocks.ROSE.get(), ModBlocks.POTTED_ROSE.get());
        cropBlock(ModBlocks.TOMATO_PLANT.get());
        cropBlock(ModBlocks.RICE_PLANT.get(), RicePlantBlock.AGE);

        //Cakes
        cakeBlock(ModBlocks.CHOCOLATE_CAKE.get());
        cakeBlock(ModBlocks.CARROT_CAKE.get());
        cakeBlock(ModBlocks.BERRY_CAKE.get());

        //Stairs
        stairsBlock(ModBlocks.COBBLESTONE_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.MAGMA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.OBSIDIAN_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.SNOW_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.PERIDOTITE_STAIRS.get());
        stairsBlock(ModBlocks.HYDRO_ROCK_STAIRS.get());
        stairsBlock(ModBlocks.INFERNAL_ROCK_STAIRS.get());
        stairsBlock(ModBlocks.POLISHED_PERIDOTITE_STAIRS.get());
        stairsBlock(ModBlocks.POLISHED_PRISMARINE_STAIRS.get());
        stairsBlock(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS.get());
        stairsBlock(ModBlocks.POLISHED_END_STONE_STAIRS.get());
        stairsBlock(ModBlocks.POLISHED_NETHERRACK_STAIRS.get());
        stairsBlock(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_RED_NETHER_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_PURPUR_BLOCK_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_OBSIDIAN_STAIRS.get());


        //Vanilla Stairs
        stairsBlock(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_STONE_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.SANDSTONE), "_top"));
        stairsBlock(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        stairsBlock(ModBlocks.IRON_BLOCK_STAIRS.get());
        stairsBlock(ModBlocks.GOLD_BLOCK_STAIRS.get());
        stairsBlock(ModBlocks.OBSIDIAN_STAIRS.get());
        stairsBlock(ModBlocks.BEDROCK_STAIRS.get());
        stairsBlock(ModBlocks.NETHERRACK_STAIRS.get());
        stairsBlock(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_NETHER_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_POLISHED_BLACKSTONE_STAIRS.get());
        stairsBlock(ModBlocks.END_STONE_STAIRS.get());
        stairsBlock(ModBlocks.CHISELED_QUARTZ_BLOCK_STAIRS.get());
        stairsBlock(ModBlocks.QUARTZ_BRICK_STAIRS.get());
        stairsBlock(ModBlocks.TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.WHITE_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.LIME_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.PINK_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.GRAY_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.CYAN_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.BLUE_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.BROWN_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.GREEN_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.RED_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.BLACK_TERRACOTTA_STAIRS.get());
        stairsBlock(ModBlocks.WHITE_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.ORANGE_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.YELLOW_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.LIME_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.PINK_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.GRAY_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.CYAN_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.PURPLE_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.BLUE_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.BROWN_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.GREEN_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.RED_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.BLACK_CONCRETE_STAIRS.get());
        stairsBlock(ModBlocks.OAK_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.SPRUCE_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.BIRCH_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.JUNGLE_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.ACACIA_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.CRIMSON_HYPHAE_STAIRS.get());
        stairsBlock(ModBlocks.WARPED_HYPHAE_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_STAIRS.get());
        stairsBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_STAIRS.get());
        stairsBlock(ModBlocks.CUT_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.SANDSTONE), "_top"));
        stairsBlock(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        stairsBlock(ModBlocks.SMOOTH_STONE_STAIRS.get());

        //Slabs
        slabBlock(ModBlocks.COBBLESTONE_BRICK_SLAB.get());
        slabBlock(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get());
        slabBlock(ModBlocks.MAGMA_BRICK_SLAB.get());
        slabBlock(ModBlocks.OBSIDIAN_BRICK_SLAB.get());
        slabBlock(ModBlocks.SNOW_BRICK_SLAB.get());
        slabBlock(ModBlocks.TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get());
        slabBlock(ModBlocks.PERIDOTITE_SLAB.get());
        slabBlock(ModBlocks.HYDRO_ROCK_SLAB.get());
        slabBlock(ModBlocks.INFERNAL_ROCK_SLAB.get());
        slabBlock(ModBlocks.POLISHED_PERIDOTITE_SLAB.get());
        slabBlock(ModBlocks.POLISHED_PRISMARINE_SLAB.get());
        slabBlock(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB.get());
        slabBlock(ModBlocks.POLISHED_END_STONE_SLAB.get());
        slabBlock(ModBlocks.POLISHED_NETHERRACK_SLAB.get());
        slabBlock(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get());
        slabBlock(ModBlocks.CHISELED_RED_NETHER_BRICK_SLAB.get());
        slabBlock(ModBlocks.CHISELED_PURPUR_BLOCK_SLAB.get());
        slabBlock(ModBlocks.CHISELED_OBSIDIAN_SLAB.get());

        //Vanilla Slabs
        slabBlock(ModBlocks.CRACKED_STONE_BRICK_SLAB.get());
        slabBlock(ModBlocks.CHISELED_STONE_BRICK_SLAB.get());
        slabBlock(ModBlocks.CHISELED_SANDSTONE_SLAB.get(), extend(blockTexture(Blocks.SANDSTONE), "_top"));
        slabBlock(ModBlocks.CHISELED_RED_SANDSTONE_SLAB.get(), extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        slabBlock(ModBlocks.IRON_BLOCK_SLAB.get());
        slabBlock(ModBlocks.GOLD_BLOCK_SLAB.get());
        slabBlock(ModBlocks.OBSIDIAN_SLAB.get());
        slabBlock(ModBlocks.BEDROCK_SLAB.get());
        slabBlock(ModBlocks.NETHERRACK_SLAB.get());
        slabBlock(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get());
        slabBlock(ModBlocks.CHISELED_NETHER_BRICK_SLAB.get());
        slabBlock(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get());
        slabBlock(ModBlocks.CHISELED_POLISHED_BLACKSTONE_SLAB.get());
        slabBlock(ModBlocks.END_STONE_SLAB.get());
        slabBlock(ModBlocks.CHISELED_QUARTZ_BLOCK_SLAB.get());
        slabBlock(ModBlocks.QUARTZ_BRICK_SLAB.get());
        slabBlock(ModBlocks.TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.WHITE_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.ORANGE_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.YELLOW_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.LIME_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.PINK_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.GRAY_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.CYAN_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.PURPLE_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.BLUE_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.BROWN_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.GREEN_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.RED_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.BLACK_TERRACOTTA_SLAB.get());
        slabBlock(ModBlocks.WHITE_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.ORANGE_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.MAGENTA_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.YELLOW_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.LIME_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.PINK_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.GRAY_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.CYAN_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.PURPLE_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.BLUE_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.BROWN_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.GREEN_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.RED_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.BLACK_CONCRETE_SLAB.get());
        slabBlock(ModBlocks.OAK_WOOD_SLAB.get());
        slabBlock(ModBlocks.SPRUCE_WOOD_SLAB.get());
        slabBlock(ModBlocks.BIRCH_WOOD_SLAB.get());
        slabBlock(ModBlocks.JUNGLE_WOOD_SLAB.get());
        slabBlock(ModBlocks.ACACIA_WOOD_SLAB.get());
        slabBlock(ModBlocks.DARK_OAK_WOOD_SLAB.get());
        slabBlock(ModBlocks.CRIMSON_HYPHAE_SLAB.get());
        slabBlock(ModBlocks.WARPED_HYPHAE_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_SLAB.get());
        slabBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_SLAB.get());

        //VanillaBoom Walls
        wallBlock(ModBlocks.COBBLESTONE_BRICK_WALL.get());
        wallBlock(ModBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get());
        wallBlock(ModBlocks.MAGMA_BRICK_WALL.get());
        wallBlock(ModBlocks.OBSIDIAN_BRICK_WALL.get());
        wallBlock(ModBlocks.SNOW_BRICK_WALL.get());
        wallBlock(ModBlocks.TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.RED_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get());
        wallBlock(ModBlocks.PERIDOTITE_WALL.get());
        wallBlock(ModBlocks.HYDRO_ROCK_WALL.get());
        wallBlock(ModBlocks.INFERNAL_ROCK_WALL.get());
        wallBlock(ModBlocks.POLISHED_PERIDOTITE_WALL.get());
        wallBlock(ModBlocks.POLISHED_PRISMARINE_WALL.get());
        wallBlock(ModBlocks.POLISHED_DARK_PRISMARINE_WALL.get());
        wallBlock(ModBlocks.POLISHED_END_STONE_WALL.get());
        wallBlock(ModBlocks.POLISHED_NETHERRACK_WALL.get());
        wallBlock(ModBlocks.CHISELED_PURPUR_BLOCK_WALL.get());
        wallBlock(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get());
        wallBlock(ModBlocks.CHISELED_RED_NETHER_BRICK_WALL.get());
        wallBlock(ModBlocks.CHISELED_OBSIDIAN_WALL.get());

        //Vanilla Walls
        wallBlock(ModBlocks.CRACKED_STONE_BRICK_WALL.get());
        wallBlock(ModBlocks.CHISELED_STONE_BRICK_WALL.get());
        wallBlock(ModBlocks.CHISELED_SANDSTONE_WALL.get());
        wallBlock(ModBlocks.CHISELED_RED_SANDSTONE_WALL.get());
        wallBlock(ModBlocks.IRON_BLOCK_WALL.get());
        wallBlock(ModBlocks.GOLD_BLOCK_WALL.get());
        wallBlock(ModBlocks.OBSIDIAN_WALL.get());
        wallBlock(ModBlocks.BEDROCK_WALL.get());
        wallBlock(ModBlocks.NETHERRACK_WALL.get());
        wallBlock(ModBlocks.CRACKED_NETHER_BRICK_WALL.get());
        wallBlock(ModBlocks.CHISELED_NETHER_BRICK_WALL.get());
        wallBlock(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get());
        wallBlock(ModBlocks.CHISELED_POLISHED_BLACKSTONE_WALL.get());
        wallBlock(ModBlocks.END_STONE_WALL.get());
        wallBlock(ModBlocks.CHISELED_QUARTZ_BLOCK_WALL.get());
        wallBlock(ModBlocks.QUARTZ_BRICK_WALL.get());
        wallBlock(ModBlocks.TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.WHITE_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.ORANGE_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.MAGENTA_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.YELLOW_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.LIME_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.PINK_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.GRAY_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.CYAN_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.PURPLE_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.BLUE_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.BROWN_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.GREEN_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.RED_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.BLACK_TERRACOTTA_WALL.get());
        wallBlock(ModBlocks.WHITE_CONCRETE_WALL.get());
        wallBlock(ModBlocks.ORANGE_CONCRETE_WALL.get());
        wallBlock(ModBlocks.MAGENTA_CONCRETE_WALL.get());
        wallBlock(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
        wallBlock(ModBlocks.YELLOW_CONCRETE_WALL.get());
        wallBlock(ModBlocks.LIME_CONCRETE_WALL.get());
        wallBlock(ModBlocks.PINK_CONCRETE_WALL.get());
        wallBlock(ModBlocks.GRAY_CONCRETE_WALL.get());
        wallBlock(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
        wallBlock(ModBlocks.CYAN_CONCRETE_WALL.get());
        wallBlock(ModBlocks.PURPLE_CONCRETE_WALL.get());
        wallBlock(ModBlocks.BLUE_CONCRETE_WALL.get());
        wallBlock(ModBlocks.BROWN_CONCRETE_WALL.get());
        wallBlock(ModBlocks.GREEN_CONCRETE_WALL.get());
        wallBlock(ModBlocks.RED_CONCRETE_WALL.get());
        wallBlock(ModBlocks.BLACK_CONCRETE_WALL.get());
        wallBlock(ModBlocks.CUT_SANDSTONE_WALL.get());
        wallBlock(ModBlocks.CUT_RED_SANDSTONE_WALL.get());
        wallBlock(ModBlocks.SMOOTH_STONE_WALL.get());
        wallBlock(ModBlocks.STONE_WALL.get());
        wallBlock(ModBlocks.POLISHED_GRANITE_WALL.get());
        wallBlock(ModBlocks.POLISHED_DIORITE_WALL.get());
        wallBlock(ModBlocks.POLISHED_ANDESITE_WALL.get());
        wallBlock(ModBlocks.SMOOTH_SANDSTONE_WALL.get());
        wallBlock(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get());
        wallBlock(ModBlocks.PURPUR_BLOCK_WALL.get());
        wallBlock(ModBlocks.QUARTZ_BLOCK_WALL.get());
        wallBlock(ModBlocks.SMOOTH_QUARTZ_WALL.get());
        wallBlock(ModBlocks.PRISMARINE_BRICK_WALL.get());
        wallBlock(ModBlocks.DARK_PRISMARINE_WALL.get());

        //Vanilla Fences
        fenceBlock(ModBlocks.OAK_WOOD_FENCE.get(), Blocks.OAK_WOOD);
        fenceBlock(ModBlocks.SPRUCE_WOOD_FENCE.get(), Blocks.SPRUCE_WOOD);
        fenceBlock(ModBlocks.BIRCH_WOOD_FENCE.get(), Blocks.BIRCH_WOOD);
        fenceBlock(ModBlocks.JUNGLE_WOOD_FENCE.get(), Blocks.JUNGLE_WOOD);
        fenceBlock(ModBlocks.ACACIA_WOOD_FENCE.get(), Blocks.ACACIA_WOOD);
        fenceBlock(ModBlocks.DARK_OAK_WOOD_FENCE.get(), Blocks.DARK_OAK_WOOD);
        fenceBlock(ModBlocks.CRIMSON_HYPHAE_FENCE.get(), Blocks.CRIMSON_HYPHAE);
        fenceBlock(ModBlocks.WARPED_HYPHAE_FENCE.get(), Blocks.WARPED_HYPHAE);
        fenceBlock(ModBlocks.STRIPPED_OAK_WOOD_FENCE.get(), Blocks.STRIPPED_OAK_WOOD);
        fenceBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE.get(), Blocks.STRIPPED_SPRUCE_WOOD);
        fenceBlock(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE.get(), Blocks.STRIPPED_BIRCH_WOOD);
        fenceBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE.get(), Blocks.STRIPPED_JUNGLE_WOOD);
        fenceBlock(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE.get(), Blocks.STRIPPED_ACACIA_WOOD);
        fenceBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE.get(), Blocks.STRIPPED_DARK_OAK_WOOD);
        fenceBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE.get(), Blocks.STRIPPED_CRIMSON_HYPHAE);
        fenceBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE.get(), Blocks.STRIPPED_WARPED_HYPHAE);
        fenceBlock(ModBlocks.RED_NETHER_BRICK_FENCE.get(), Blocks.RED_NETHER_BRICKS);
        fenceGateBlock(ModBlocks.OAK_WOOD_FENCE_GATE.get(), Blocks.OAK_WOOD);
        fenceGateBlock(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get(), Blocks.SPRUCE_WOOD);
        fenceGateBlock(ModBlocks.BIRCH_WOOD_FENCE_GATE.get(), Blocks.BIRCH_WOOD);
        fenceGateBlock(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get(), Blocks.JUNGLE_WOOD);
        fenceGateBlock(ModBlocks.ACACIA_WOOD_FENCE_GATE.get(), Blocks.ACACIA_WOOD);
        fenceGateBlock(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get(), Blocks.DARK_OAK_WOOD);
        fenceGateBlock(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get(), Blocks.CRIMSON_HYPHAE);
        fenceGateBlock(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get(), Blocks.WARPED_HYPHAE);
        fenceGateBlock(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_OAK_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_SPRUCE_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_BIRCH_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_JUNGLE_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_ACACIA_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_DARK_OAK_WOOD);
        fenceGateBlock(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE.get(), Blocks.STRIPPED_CRIMSON_HYPHAE);
        fenceGateBlock(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE.get(), Blocks.STRIPPED_WARPED_HYPHAE);
        fenceGateBlock(ModBlocks.NETHER_BRICK_FENCE_GATE.get(), Blocks.NETHER_BRICKS);
        fenceGateBlock(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get(), Blocks.RED_NETHER_BRICKS);
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

    public void fenceBlock(Block fence, Block parent) {
        fenceBlock((FenceBlock) fence, variantTexture(parent));
        models().withExistingParent(name(fence) + "_inventory", ModelProvider.BLOCK_FOLDER + "/fence_inventory").texture("texture", variantTexture(parent));
    }

    public void fenceGateBlock(Block fenceGate, Block parent) {
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

    private static final Block[] CANDLES = {Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE};

    public void cakeBlock(Block cake) {
        List<ModelFile> files = CakeBlock.BITES.getAllValues()
                .map(bites -> cakeModel(cake, bites.value()))
                .collect(Collectors.toList());

        cakeBlock((CakeBlock) cake, files);

        for (Block candle : CANDLES) {
            Block candleCake = ((ModCakeBlock) cake).byCandle(candle);
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

        return bites == 0 ? builder : builder.texture("inside", extend(blockTexture(cake), "_inner"));
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
