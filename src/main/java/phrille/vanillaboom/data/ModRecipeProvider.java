package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModSlabBlock;
import phrille.vanillaboom.block.ModStairBlock;
import phrille.vanillaboom.block.ModWallBlock;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipe) {
        bricks(finishedRecipe, ModBlocks.COBBLESTONE_BRICKS.get(), Blocks.COBBLESTONE);
        bricks(finishedRecipe, ModBlocks.MOSSY_COBBLESTONE_BRICKS.get(), Blocks.MOSSY_COBBLESTONE);
        mossyCobblestoneBricksShapeless(finishedRecipe, Blocks.MOSS_BLOCK);
        mossyCobblestoneBricksShapeless(finishedRecipe, Blocks.VINE);
        twoByTwoShaped(finishedRecipe, ModBlocks.MAGMA_BRICKS.get(), ModItems.MAGMA_BRICK.get());
        bricks(finishedRecipe, ModBlocks.OBSIDIAN_BRICKS.get(), Blocks.OBSIDIAN);
        bricks(finishedRecipe, ModBlocks.SNOW_BRICKS.get(), Blocks.SNOW_BLOCK);
        bricks(finishedRecipe, ModBlocks.TERRACOTTA_BRICKS.get(), Blocks.TERRACOTTA);
        terracottaBricks(finishedRecipe, ModBlocks.WHITE_TERRACOTTA_BRICKS.get(), Blocks.WHITE_TERRACOTTA, Tags.Items.DYES_WHITE);
        terracottaBricks(finishedRecipe, ModBlocks.ORANGE_TERRACOTTA_BRICKS.get(), Blocks.ORANGE_TERRACOTTA, Tags.Items.DYES_ORANGE);
        terracottaBricks(finishedRecipe, ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get(), Blocks.MAGENTA_TERRACOTTA, Tags.Items.DYES_MAGENTA);
        terracottaBricks(finishedRecipe, ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_BLUE_TERRACOTTA, Tags.Items.DYES_LIGHT_BLUE);
        terracottaBricks(finishedRecipe, ModBlocks.YELLOW_TERRACOTTA_BRICKS.get(), Blocks.YELLOW_TERRACOTTA, Tags.Items.DYES_YELLOW);
        terracottaBricks(finishedRecipe, ModBlocks.LIME_TERRACOTTA_BRICKS.get(), Blocks.LIME_TERRACOTTA, Tags.Items.DYES_LIME);
        terracottaBricks(finishedRecipe, ModBlocks.PINK_TERRACOTTA_BRICKS.get(), Blocks.PINK_TERRACOTTA, Tags.Items.DYES_PINK);
        terracottaBricks(finishedRecipe, ModBlocks.GRAY_TERRACOTTA_BRICKS.get(), Blocks.GRAY_TERRACOTTA, Tags.Items.DYES_GRAY);
        terracottaBricks(finishedRecipe, ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_GRAY_TERRACOTTA, Tags.Items.DYES_LIGHT_GRAY);
        terracottaBricks(finishedRecipe, ModBlocks.CYAN_TERRACOTTA_BRICKS.get(), Blocks.CYAN_TERRACOTTA, Tags.Items.DYES_CYAN);
        terracottaBricks(finishedRecipe, ModBlocks.PURPLE_TERRACOTTA_BRICKS.get(), Blocks.PURPLE_TERRACOTTA, Tags.Items.DYES_PURPLE);
        terracottaBricks(finishedRecipe, ModBlocks.BLUE_TERRACOTTA_BRICKS.get(), Blocks.BLUE_TERRACOTTA, Tags.Items.DYES_BLUE);
        terracottaBricks(finishedRecipe, ModBlocks.BROWN_TERRACOTTA_BRICKS.get(), Blocks.BROWN_TERRACOTTA, Tags.Items.DYES_BROWN);
        terracottaBricks(finishedRecipe, ModBlocks.GREEN_TERRACOTTA_BRICKS.get(), Blocks.GREEN_TERRACOTTA, Tags.Items.DYES_GREEN);
        terracottaBricks(finishedRecipe, ModBlocks.RED_TERRACOTTA_BRICKS.get(), Blocks.RED_TERRACOTTA, Tags.Items.DYES_RED);
        terracottaBricks(finishedRecipe, ModBlocks.BLACK_TERRACOTTA_BRICKS.get(), Blocks.BLACK_TERRACOTTA, Tags.Items.DYES_BLACK);
        twoByTwoShaped(finishedRecipe, ModBlocks.BONE_SAND.get(), Items.BONE_MEAL);
        twoByTwoShaped(finishedRecipe, ModBlocks.WITHER_BONE_SAND.get(), ModItems.WITHER_BONE_MEAL.get());
        ShapelessRecipeBuilder.shapeless(ModBlocks.PERIDOTITE.get(), 2)
                .requires(Blocks.DIORITE)
                .requires(Blocks.PRISMARINE)
                .unlockedBy(getHasName(Blocks.DIORITE), has(Blocks.DIORITE))
                .unlockedBy(getHasName(Blocks.PRISMARINE), has(Blocks.PRISMARINE))
                .save(finishedRecipe);
        polishedBlock(finishedRecipe, ModBlocks.POLISHED_PERIDOTITE.get(), ModBlocks.PERIDOTITE.get());
        polishedBlock(finishedRecipe, ModBlocks.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE, List.of(Blocks.PRISMARINE_BRICKS));
        polishedBlock(finishedRecipe, ModBlocks.POLISHED_DARK_PRISMARINE.get(), Blocks.DARK_PRISMARINE);
        polishedBlock(finishedRecipe, ModBlocks.POLISHED_END_STONE.get(), Blocks.END_STONE_BRICKS, List.of(Blocks.END_STONE));
        polishedBlock(finishedRecipe, ModBlocks.POLISHED_NETHERRACK.get(), Blocks.NETHERRACK);
        smelting(finishedRecipe, ModBlocks.CRACKED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICKS, 0.1F);
        chiseledBlock(finishedRecipe, ModBlocks.CHISELED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICK_SLAB, List.of(Blocks.RED_NETHER_BRICKS));
        chiseledBlock(finishedRecipe, ModBlocks.CHISELED_PURPUR_BLOCK.get(), Blocks.PURPUR_SLAB, List.of(Blocks.PURPUR_BLOCK));
        chiseledBlock(finishedRecipe, ModBlocks.CHISELED_OBSIDIAN.get(), ModBlocks.OBSIDIAN_SLAB.get(), List.of(Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_BRICKS.get()));
        pillarBlock(finishedRecipe, ModBlocks.GRANITE_PILLAR.get(), Blocks.POLISHED_GRANITE, List.of(Blocks.GRANITE));
        pillarBlock(finishedRecipe, ModBlocks.DIORITE_PILLAR.get(), Blocks.POLISHED_DIORITE, List.of(Blocks.DIORITE));
        pillarBlock(finishedRecipe, ModBlocks.ANDESITE_PILLAR.get(), Blocks.POLISHED_ANDESITE, List.of(Blocks.ANDESITE));
        pillarBlock(finishedRecipe, ModBlocks.PERIDOTITE_PILLAR.get(), ModBlocks.POLISHED_PERIDOTITE.get(), List.of(ModBlocks.PERIDOTITE.get()));
        pillarBlock(finishedRecipe, ModBlocks.PRISMARINE_PILLAR.get(), ModBlocks.POLISHED_PRISMARINE.get(), List.of(Blocks.PRISMARINE));
        pillarBlock(finishedRecipe, ModBlocks.PRISMARINE_PILLAR.get(), Blocks.PRISMARINE_BRICKS);
        pillarBlock(finishedRecipe, ModBlocks.DARK_PRISMARINE_PILLAR.get(), ModBlocks.POLISHED_DARK_PRISMARINE.get(), List.of(Blocks.DARK_PRISMARINE));
        pillarBlock(finishedRecipe, ModBlocks.END_STONE_PILLAR.get(), ModBlocks.POLISHED_END_STONE.get(), List.of(Blocks.END_STONE));
        pillarBlock(finishedRecipe, ModBlocks.END_STONE_PILLAR.get(), Blocks.END_STONE_BRICKS);
        pillarBlock(finishedRecipe, ModBlocks.NETHERRACK_PILLAR.get(), ModBlocks.POLISHED_NETHERRACK.get(), List.of(Blocks.NETHERRACK));
        pillarBlock(finishedRecipe, ModBlocks.RED_NETHER_PILLAR.get(), Blocks.RED_NETHER_BRICKS);
        pillarBlock(finishedRecipe, ModBlocks.OBSIDIAN_PILLAR.get(), Blocks.OBSIDIAN);
        pillarBlock(finishedRecipe, ModBlocks.OBSIDIAN_PILLAR.get(), ModBlocks.OBSIDIAN_BRICKS.get());
        bookshelfShaped(finishedRecipe, ModBlocks.SPRUCE_BOOKSHELF.get(), Blocks.SPRUCE_PLANKS);
        bookshelfShaped(finishedRecipe, ModBlocks.BIRCH_BOOKSHELF.get(), Blocks.BIRCH_PLANKS);
        bookshelfShaped(finishedRecipe, ModBlocks.JUNGLE_BOOKSHELF.get(), Blocks.JUNGLE_PLANKS);
        bookshelfShaped(finishedRecipe, ModBlocks.ACACIA_BOOKSHELF.get(), Blocks.ACACIA_PLANKS);
        bookshelfShaped(finishedRecipe, ModBlocks.DARK_OAK_BOOKSHELF.get(), Blocks.DARK_OAK_PLANKS);
        bookshelfShaped(finishedRecipe, ModBlocks.CRIMSON_BOOKSHELF.get(), Blocks.CRIMSON_PLANKS);
        bookshelfShaped(finishedRecipe, ModBlocks.WARPED_BOOKSHELF.get(), Blocks.WARPED_PLANKS);
        ladderShaped(finishedRecipe, ModBlocks.SPRUCE_LADDER.get(), Blocks.SPRUCE_SLAB);
        ladderShaped(finishedRecipe, ModBlocks.BIRCH_LADDER.get(), Blocks.BIRCH_SLAB);
        ladderShaped(finishedRecipe, ModBlocks.JUNGLE_LADDER.get(), Blocks.JUNGLE_SLAB);
        ladderShaped(finishedRecipe, ModBlocks.ACACIA_LADDER.get(), Blocks.ACACIA_SLAB);
        ladderShaped(finishedRecipe, ModBlocks.DARK_OAK_LADDER.get(), Blocks.DARK_OAK_SLAB);
        ladderShaped(finishedRecipe, ModBlocks.CRIMSON_LADDER.get(), Blocks.CRIMSON_SLAB);
        ladderShaped(finishedRecipe, ModBlocks.WARPED_LADDER.get(), Blocks.WARPED_SLAB);
        storageBlock(finishedRecipe, ModBlocks.CHARCOAL_BLOCK.get(), Items.CHARCOAL);
        storageBlock(finishedRecipe, ModBlocks.SUGAR_BLOCK.get(), Items.SUGAR);
        storageBlock(finishedRecipe, ModBlocks.SUGAR_CANE_BLOCK.get(), Items.SUGAR_CANE);
        storageBlock(finishedRecipe, ModBlocks.BAMBOO_BLOCK.get(), Items.BAMBOO);
        storageBlock(finishedRecipe, ModBlocks.GUNPOWDER_BLOCK.get(), Items.GUNPOWDER);
        storageBlock(finishedRecipe, ModBlocks.BLAZE_POWDER_BLOCK.get(), Items.BLAZE_POWDER);
        storageBlock(finishedRecipe, ModBlocks.MAGMA_CREAM_BLOCK.get(), Items.MAGMA_CREAM);
        storageBlock(finishedRecipe, ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get(), Items.PRISMARINE_CRYSTALS);
        storageBlock(finishedRecipe, ModBlocks.WITHER_BONE_BLOCK.get(), ModItems.WITHER_BONE.get());
        storageBlock(finishedRecipe, ModBlocks.ORANGE_DYE_BLOCK.get(), Items.ORANGE_DYE);
        storageBlock(finishedRecipe, ModBlocks.MAGENTA_DYE_BLOCK.get(), Items.MAGENTA_DYE);
        storageBlock(finishedRecipe, ModBlocks.LIGHT_BLUE_DYE_BLOCK.get(), Items.LIGHT_BLUE_DYE);
        storageBlock(finishedRecipe, ModBlocks.YELLOW_DYE_BLOCK.get(), Items.YELLOW_DYE);
        storageBlock(finishedRecipe, ModBlocks.LIME_DYE_BLOCK.get(), Items.LIME_DYE);
        storageBlock(finishedRecipe, ModBlocks.PINK_DYE_BLOCK.get(), Items.PINK_DYE);
        storageBlock(finishedRecipe, ModBlocks.GRAY_DYE_BLOCK.get(), Items.GRAY_DYE);
        storageBlock(finishedRecipe, ModBlocks.LIGHT_GRAY_DYE_BLOCK.get(), Items.LIGHT_GRAY_DYE);
        storageBlock(finishedRecipe, ModBlocks.CYAN_DYE_BLOCK.get(), Items.CYAN_DYE);
        storageBlock(finishedRecipe, ModBlocks.PURPLE_DYE_BLOCK.get(), Items.PURPLE_DYE);
        storageBlock(finishedRecipe, ModBlocks.BLUE_DYE_BLOCK.get(), Items.BLUE_DYE);
        storageBlock(finishedRecipe, ModBlocks.BROWN_DYE_BLOCK.get(), Items.BROWN_DYE);
        storageBlock(finishedRecipe, ModBlocks.GREEN_DYE_BLOCK.get(), Items.GREEN_DYE);
        storageBlock(finishedRecipe, ModBlocks.RED_DYE_BLOCK.get(), Items.RED_DYE);
        storageBlock(finishedRecipe, ModBlocks.BLACK_DYE_BLOCK.get(), Items.BLACK_DYE);
        smeltingAndBlasting(finishedRecipe, ModBlocks.SOUL_GLASS.get(), Blocks.SOUL_SAND, 0.1F);
        smeltingAndBlasting(finishedRecipe, ModBlocks.SOUL_GLASS.get(), Blocks.SOUL_SOIL, 0.1F);
        stainedSoulGlass(finishedRecipe, ModBlocks.WHITE_STAINED_SOUL_GLASS.get(), ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_WHITE);
        stainedSoulGlass(finishedRecipe, ModBlocks.ORANGE_STAINED_SOUL_GLASS.get(), ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_ORANGE);
        stainedSoulGlass(finishedRecipe, ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get(), ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_MAGENTA);
        stainedSoulGlass(finishedRecipe, ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get(), ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIGHT_BLUE);
        stainedSoulGlass(finishedRecipe, ModBlocks.YELLOW_STAINED_SOUL_GLASS.get(), ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_YELLOW);
        stainedSoulGlass(finishedRecipe, ModBlocks.LIME_STAINED_SOUL_GLASS.get(), ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIME);
        stainedSoulGlass(finishedRecipe, ModBlocks.PINK_STAINED_SOUL_GLASS.get(), ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_PINK);
        stainedSoulGlass(finishedRecipe, ModBlocks.GRAY_STAINED_SOUL_GLASS.get(), ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_GRAY);
        stainedSoulGlass(finishedRecipe, ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get(), ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIGHT_GRAY);
        stainedSoulGlass(finishedRecipe, ModBlocks.CYAN_STAINED_SOUL_GLASS.get(), ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_CYAN);
        stainedSoulGlass(finishedRecipe, ModBlocks.PURPLE_STAINED_SOUL_GLASS.get(), ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_PURPLE);
        stainedSoulGlass(finishedRecipe, ModBlocks.BLUE_STAINED_SOUL_GLASS.get(), ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BLUE);
        stainedSoulGlass(finishedRecipe, ModBlocks.BROWN_STAINED_SOUL_GLASS.get(), ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BROWN);
        stainedSoulGlass(finishedRecipe, ModBlocks.GREEN_STAINED_SOUL_GLASS.get(), ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_GREEN);
        stainedSoulGlass(finishedRecipe, ModBlocks.RED_STAINED_SOUL_GLASS.get(), ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_RED);
        stainedSoulGlass(finishedRecipe, ModBlocks.BLACK_STAINED_SOUL_GLASS.get(), ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BLACK);
        ShapedRecipeBuilder.shaped(ModBlocks.RAIN_DETECTOR.get())
                .define('x', Blocks.GLASS)
                .define('y', ModBlocks.HYDRO_ROCK.get())
                .define('z', ItemTags.WOODEN_SLABS)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("zzz")
                .unlockedBy(getHasName(ModBlocks.HYDRO_ROCK.get()), has(ModBlocks.HYDRO_ROCK.get()))
                .save(finishedRecipe);
        ShapedRecipeBuilder.shaped(ModBlocks.GOLD_BARS.get(), 16)
                .define('x', Tags.Items.INGOTS_GOLD)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(finishedRecipe);
        oneToOneShapeless(finishedRecipe, Items.RED_DYE, ModBlocks.ROSE.get(), 1);
        ModDataGenerator.STAIRS.forEach(pair -> stair(finishedRecipe, (ModStairBlock) pair.getFirst()));
        ModDataGenerator.SLABS.forEach(pair -> slab(finishedRecipe, (ModSlabBlock) pair.getFirst()));
        ModDataGenerator.WALLS.forEach(block -> wall(finishedRecipe, (ModWallBlock) block));
        ModDataGenerator.FENCES.forEach(pair -> fence(finishedRecipe, (FenceBlock) pair.getFirst(), pair.getSecond()));
        ModDataGenerator.FENCE_GATES.forEach(pair -> fenceGate(finishedRecipe, (FenceGateBlock) pair.getFirst(), pair.getSecond()));
        variants(finishedRecipe, ModBlocks.COBBLESTONE_BRICK_STAIRS.get(), ModBlocks.COBBLESTONE_BRICK_SLAB.get(), ModBlocks.COBBLESTONE_BRICK_WALL.get(), Blocks.COBBLESTONE);
        variants(finishedRecipe, ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get(), ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get(), ModBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get(), Blocks.MOSSY_COBBLESTONE);
        variants(finishedRecipe, ModBlocks.OBSIDIAN_BRICK_STAIRS.get(), ModBlocks.OBSIDIAN_BRICK_SLAB.get(), ModBlocks.OBSIDIAN_BRICK_WALL.get(), Blocks.OBSIDIAN);
        variants(finishedRecipe, ModBlocks.SNOW_BRICK_STAIRS.get(), ModBlocks.SNOW_BRICK_SLAB.get(), ModBlocks.SNOW_BRICK_WALL.get(), Blocks.SNOW_BLOCK);
        variants(finishedRecipe, ModBlocks.TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.TERRACOTTA_BRICK_SLAB.get(), ModBlocks.TERRACOTTA_BRICK_WALL.get(), Blocks.TERRACOTTA);
        variants(finishedRecipe, ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get(), Blocks.WHITE_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get(), Blocks.ORANGE_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get(), Blocks.MAGENTA_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get(), Blocks.YELLOW_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get(), Blocks.LIME_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get(), Blocks.PINK_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get(), Blocks.GRAY_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get(), Blocks.CYAN_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get(), Blocks.PURPLE_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get(), Blocks.BLUE_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get(), Blocks.BROWN_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get(), Blocks.GREEN_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.RED_TERRACOTTA_BRICK_WALL.get(), Blocks.RED_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get(), ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get(), ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get(), Blocks.BLACK_TERRACOTTA);
        variants(finishedRecipe, ModBlocks.POLISHED_PERIDOTITE_STAIRS.get(), ModBlocks.POLISHED_PERIDOTITE_SLAB.get(), ModBlocks.POLISHED_PERIDOTITE_WALL.get(), ModBlocks.PERIDOTITE.get());
        variants(finishedRecipe, ModBlocks.POLISHED_PRISMARINE_STAIRS.get(), ModBlocks.POLISHED_PRISMARINE_SLAB.get(), ModBlocks.POLISHED_PRISMARINE_WALL.get(), List.of(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS));
        variants(finishedRecipe, ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS.get(), ModBlocks.POLISHED_DARK_PRISMARINE_SLAB.get(), ModBlocks.POLISHED_DARK_PRISMARINE_WALL.get(), Blocks.DARK_PRISMARINE);
        variants(finishedRecipe, ModBlocks.POLISHED_END_STONE_STAIRS.get(), ModBlocks.POLISHED_END_STONE_SLAB.get(), ModBlocks.POLISHED_END_STONE_WALL.get(), List.of(Blocks.END_STONE, Blocks.END_STONE_BRICKS));
        variants(finishedRecipe, ModBlocks.POLISHED_NETHERRACK_STAIRS.get(), ModBlocks.POLISHED_NETHERRACK_SLAB.get(), ModBlocks.POLISHED_NETHERRACK_WALL.get(), Blocks.NETHERRACK);
        variants(finishedRecipe, ModBlocks.CHISELED_RED_NETHER_BRICK_STAIRS.get(), ModBlocks.CHISELED_RED_NETHER_BRICK_SLAB.get(), ModBlocks.CHISELED_RED_NETHER_BRICK_WALL.get(), Blocks.RED_NETHER_BRICKS);
        variants(finishedRecipe, ModBlocks.CHISELED_PURPUR_BLOCK_STAIRS.get(), ModBlocks.CHISELED_PURPUR_BLOCK_SLAB.get(), ModBlocks.CHISELED_PURPUR_BLOCK_WALL.get(), Blocks.PURPUR_BLOCK);
        variants(finishedRecipe, ModBlocks.CHISELED_OBSIDIAN_STAIRS.get(), ModBlocks.CHISELED_OBSIDIAN_SLAB.get(), ModBlocks.CHISELED_OBSIDIAN_WALL.get(), List.of(Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_BRICKS.get()));
        variants(finishedRecipe, ModBlocks.CHISELED_STONE_BRICK_STAIRS.get(), ModBlocks.CHISELED_STONE_BRICK_SLAB.get(), ModBlocks.CHISELED_STONE_BRICK_WALL.get(), List.of(Blocks.STONE, Blocks.STONE_BRICKS));
        variants(finishedRecipe, ModBlocks.CHISELED_SANDSTONE_STAIRS.get(), ModBlocks.CHISELED_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_SANDSTONE_WALL.get(), Blocks.SANDSTONE);
        variants(finishedRecipe, ModBlocks.CHISELED_RED_SANDSTONE_STAIRS.get(), ModBlocks.CHISELED_RED_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_RED_SANDSTONE_WALL.get(), Blocks.RED_SANDSTONE);
        variants(finishedRecipe, ModBlocks.CHISELED_NETHER_BRICK_STAIRS.get(), ModBlocks.CHISELED_NETHER_BRICK_SLAB.get(), ModBlocks.CHISELED_NETHER_BRICK_WALL.get(), Blocks.NETHER_BRICKS);
        variants(finishedRecipe, ModBlocks.CHISELED_POLISHED_BLACKSTONE_STAIRS.get(), ModBlocks.CHISELED_POLISHED_BLACKSTONE_SLAB.get(), ModBlocks.CHISELED_POLISHED_BLACKSTONE_WALL.get(), List.of(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE));
        variants(finishedRecipe, ModBlocks.CHISELED_QUARTZ_BLOCK_STAIRS.get(), ModBlocks.CHISELED_QUARTZ_BLOCK_SLAB.get(), ModBlocks.CHISELED_QUARTZ_BLOCK_WALL.get(), Blocks.QUARTZ_BLOCK);
        variants(finishedRecipe, ModBlocks.QUARTZ_BRICK_STAIRS.get(), ModBlocks.QUARTZ_BRICK_SLAB.get(), ModBlocks.QUARTZ_BRICK_WALL.get(), Blocks.QUARTZ_BLOCK);
        variants(finishedRecipe, ModBlocks.CUT_SANDSTONE_STAIRS.get(), ModBlocks.CUT_SANDSTONE_WALL.get(), Blocks.SANDSTONE);
        variants(finishedRecipe, ModBlocks.CUT_RED_SANDSTONE_STAIRS.get(), ModBlocks.CUT_RED_SANDSTONE_WALL.get(), Blocks.RED_SANDSTONE);
        variants(finishedRecipe, ModBlocks.POLISHED_GRANITE_WALL.get(), Blocks.GRANITE);
        variants(finishedRecipe, ModBlocks.POLISHED_DIORITE_WALL.get(), Blocks.DIORITE);
        variants(finishedRecipe, ModBlocks.POLISHED_ANDESITE_WALL.get(), Blocks.ANDESITE);

        //Items
        smeltingAndBlasting(finishedRecipe, ModItems.MAGMA_BRICK.get(), Blocks.MAGMA_BLOCK, 0.1F);
        oneToOneShapeless(finishedRecipe, ModItems.WITHER_BONE_MEAL.get(), ModItems.WITHER_BONE.get(), 3);
        oneToOneShapeless(finishedRecipe, Items.BLACK_DYE, ModItems.WITHER_BONE_MEAL.get(), 1);
        ShapedRecipeBuilder.shaped(ModItems.PRISMARINE_ARROW.get())
                .define('x', Items.PRISMARINE_SHARD)
                .define('y', Tags.Items.RODS_WOODEN)
                .define('z', Tags.Items.FEATHERS)
                .pattern("x")
                .pattern("y")
                .pattern("z")
                .group(name(ModItems.PRISMARINE_ARROW.get()))
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD))
                .unlockedBy(getHasName(Items.FEATHER), has(Items.FEATHER))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(ModItems.PRISMARINE_ARROW.get())
                .requires(Items.ARROW)
                .requires(Items.PRISMARINE_SHARD)
                .group(name(ModItems.PRISMARINE_ARROW.get()))
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD))
                .unlockedBy(getHasName(Items.FEATHER), has(Items.FEATHER))
                .save(finishedRecipe, getConversionRecipeName(ModItems.PRISMARINE_ARROW.get(), Items.ARROW));
        oneToOneShapeless(finishedRecipe, Items.LEATHER, ModItems.POLAR_BEAR_FUR.get(), 4);
        surroundedShaped(finishedRecipe, Items.BOOK, Items.PAPER, ModItems.POLAR_BEAR_FUR.get(), 4);
        surroundedShaped(finishedRecipe, Items.ITEM_FRAME, Tags.Items.RODS_WOODEN, ModItems.POLAR_BEAR_FUR.get(), 4);
        oneToOneShapeless(finishedRecipe, ModItems.TOMATO_SEEDS.get(), ModItems.TOMATO.get(), 1);
        oneToOneShapeless(finishedRecipe, ModItems.RICE_SEEDS.get(), ModItems.RICE_BOWL.get(), 1);
        cooking(finishedRecipe, ModItems.COOKED_EGG.get(), Items.EGG, 0.3F);
        ShapelessRecipeBuilder.shapeless(ModItems.MELON_POPSICLE.get(), 4)
                .requires(Items.MELON)
                .requires(Blocks.ICE)
                .requires(Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(Items.MELON), has(Items.MELON))
                .unlockedBy(getHasName(Blocks.ICE), has(Blocks.ICE))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(ModItems.CHOCOLATE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(Items.COCOA_BEANS)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(finishedRecipe);
        cakeShaped(finishedRecipe, ModItems.CHOCOLATE_CAKE.get(), ModItems.CHOCOLATE.get());
        cakeShaped(finishedRecipe, ModItems.BERRY_CAKE.get(), Items.SWEET_BERRIES);
        cakeShaped(finishedRecipe, ModItems.CARROT_CAKE.get(), Items.CARROT);
        pieShapeless(finishedRecipe, ModItems.APPLE_PIE.get(), Items.APPLE);
        pieShapeless(finishedRecipe, ModItems.BERRY_PIE.get(), Items.SWEET_BERRIES);
        pieShapeless(finishedRecipe, ModItems.MONSTER_PIE.get(), Items.ROTTEN_FLESH);
        cooking(finishedRecipe, ModItems.POLAR_BEAR_STEAK.get(), ModItems.RAW_POLAR_BEAR_MEAT.get(), 0.35F);
        ShapelessRecipeBuilder.shapeless(ModItems.POTATO_SOUP.get())
                .requires(Items.BOWL)
                .requires(ModTags.VanillaBoomTags.Items.POTATO_SOUP_INGREDIENTS)
                .requires(ModTags.VanillaBoomTags.Items.POTATO_SOUP_INGREDIENTS)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                .unlockedBy(getHasName(Items.POISONOUS_POTATO), has(Items.POISONOUS_POTATO))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(ModItems.MEAT_SOUP.get())
                .requires(Items.BOWL)
                .requires(Tags.Items.CROPS_POTATO)
                .requires(ModTags.ForgeTags.Items.COOKED_MEATS)
                .requires(ModTags.ForgeTags.Items.COOKED_MEATS)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(ModItems.FISH_SOUP.get())
                .requires(Items.BOWL)
                .requires(Items.SEA_PICKLE)
                .requires(ModTags.ForgeTags.Items.COOKED_FISHES)
                .requires(ModTags.ForgeTags.Items.COOKED_FISHES)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(Items.SEA_PICKLE), has(Items.SEA_PICKLE))
                .save(finishedRecipe);
        cooking(finishedRecipe, ModItems.COOKED_TUNA.get(), ModItems.TUNA.get(), 0.35F);
        cooking(finishedRecipe, ModItems.COOKED_PERCH.get(), ModItems.PERCH.get(), 0.35F);
        cooking(finishedRecipe, ModItems.COOKED_PIKE.get(), ModItems.PIKE.get(), 0.35F);
        cooking(finishedRecipe, ModItems.COOKED_EEL.get(), ModItems.EEL.get(), 0.35F);

        //Altered recipes from vanilla
        ShapedRecipeBuilder.shaped(Blocks.BONE_BLOCK)
                .define('x', Items.BONE)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(Items.BONE, 9)
                .requires(Blocks.BONE_BLOCK)
                .unlockedBy(getHasName(Blocks.BONE_BLOCK), has(Blocks.BONE_BLOCK))
                .save(finishedRecipe, "bone_meal_from_bone_block");
        ShapedRecipeBuilder.shaped(Blocks.BOOKSHELF)
                .define('x', Blocks.OAK_PLANKS)
                .define('y', Items.BOOK)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("xxx")
                .unlockedBy(getHasName(Blocks.BOOKSHELF), has(Blocks.BOOKSHELF))
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(finishedRecipe);
        ShapedRecipeBuilder.shaped(Blocks.NETHER_BRICK_FENCE, 3)
                .define('x', Items.NETHER_BRICK)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("xyx")
                .pattern("xyx")
                .unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(finishedRecipe);
    }

    //Templates
    public void bricks(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(finishedRecipe, result, ingredient, 4);
        stonecutting(finishedRecipe, result, ingredient);
    }

    public void terracottaBricks(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, Tag<Item> dye) {
        bricks(finishedRecipe, result, ingredient);
        dyeCenterShaped(finishedRecipe, result, ModBlocks.TERRACOTTA_BRICKS.get(), dye, getAltName(result));
    }

    public void polishedBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        polishedBlock(finishedRecipe, result, ingredient, List.of());
    }

    public void polishedBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        twoByTwoShaped(finishedRecipe, result, ingredient, 4);
        stonecutting(finishedRecipe, result, ingredient);
        variants.forEach(variant -> stonecutting(finishedRecipe, result, variant));
    }

    public void chiseledBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        stackedShaped(finishedRecipe, result, ingredient, 1);
        variants.forEach(variant -> stonecutting(finishedRecipe, result, variant));
    }

    public void pillarBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        pillarBlock(finishedRecipe, result, ingredient, List.of());
    }

    public void pillarBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        stackedShaped(finishedRecipe, result, ingredient, 2);
        stonecutting(finishedRecipe, result, ingredient);
        variants.forEach(variant -> stonecutting(finishedRecipe, result, variant));
    }

    public void storageBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        threeByThreeShaped(finishedRecipe, result, ingredient, 1);
        oneToOneShapeless(finishedRecipe, ingredient, result, 9);
    }

    public void stainedSoulGlass(Consumer<FinishedRecipe> finishedRecipe, ItemLike glass, ItemLike pane, Tag<Item> dye) {
        dyeCenterShaped(finishedRecipe, glass, ModBlocks.SOUL_GLASS.get(), dye, modLoc(glass));
        paneShaped(finishedRecipe, pane, glass);
    }

    public void smeltingAndBlasting(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, float xp) {
        smelting(finishedRecipe, result, ingredient, xp);
        blasting(finishedRecipe, result, ingredient, xp);
    }

    public void cooking(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, float xp) {
        smelting(finishedRecipe, result, ingredient, xp);
        smoking(finishedRecipe, result, ingredient, xp);
        campFire(finishedRecipe, result, ingredient, xp);
    }

    public void stair(Consumer<FinishedRecipe> finishedRecipe, ModStairBlock stair) {
        stairsShaped(finishedRecipe, stair.asItem(), stair.getParent().asItem());
        stonecutting(finishedRecipe, stair.asItem(), stair.getParent().asItem());
    }

    public void slab(Consumer<FinishedRecipe> finishedRecipe, ModSlabBlock slab) {
        slabShaped(finishedRecipe, slab.asItem(), slab.getParent().asItem());
        stonecutting(finishedRecipe, slab.asItem(), slab.getParent().asItem(), 2);
    }

    public void wall(Consumer<FinishedRecipe> finishedRecipe, ModWallBlock wall) {
        wallShaped(finishedRecipe, wall.asItem(), wall.getParent().asItem());
        stonecutting(finishedRecipe, wall.asItem(), wall.getParent().asItem());
    }

    public void fence(Consumer<FinishedRecipe> finishedRecipe, FenceBlock fence, Block parent) {
        fenceShaped(finishedRecipe, fence.asItem(), parent.asItem());
    }

    public void fenceGate(Consumer<FinishedRecipe> finishedRecipe, FenceGateBlock fenceGate, Block parent) {
        fenceGateShaped(finishedRecipe, fenceGate.asItem(), parent.asItem());
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike slab, ItemLike wall, ItemLike block) {
        variants(finishedRecipe, stair, slab, wall, List.of(block));
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike slab, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> {
            stonecutting(finishedRecipe, stair, block);
            stonecutting(finishedRecipe, slab, block, 2);
            stonecutting(finishedRecipe, wall, block);
        });
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike wall, ItemLike block) {
        variants(finishedRecipe, stair, wall, List.of(block));
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> {
            stonecutting(finishedRecipe, stair, block);
            stonecutting(finishedRecipe, wall, block);
        });
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike wall, ItemLike block) {
        variants(finishedRecipe, wall, List.of(block));
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> {
            stonecutting(finishedRecipe, wall, block);
        });
    }

    //Shaped Recipe
    public void twoByTwoShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(finishedRecipe, result, ingredient, 1);
    }

    public void twoByTwoShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(result, amount)
                .define('x', ingredient)
                .pattern("xx")
                .pattern("xx")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void threeByThreeShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(result, amount)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void surroundedShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike surround, ItemLike middle, int amount) {
        ShapedRecipeBuilder.shaped(result, amount)
                .define('x', surround)
                .define('y', middle)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .unlockedBy(getHasName(surround), has(surround))
                .unlockedBy(getHasName(middle), has(middle))
                .save(finishedRecipe, getConversionRecipeName(result, middle));
    }

    public void surroundedShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, Tag<Item> surround, ItemLike middle, int amount) {
        ShapedRecipeBuilder.shaped(result, amount)
                .define('x', surround)
                .define('y', middle)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .unlockedBy(getHasName(middle), has(middle))
                .save(finishedRecipe, getConversionRecipeName(result, middle));
    }

    public void dyeCenterShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, Tag<Item> dye, ResourceLocation name) {
        ShapedRecipeBuilder.shaped(result, 8)
                .define('x', ingredient)
                .define('y', dye)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, name);
    }

    public void stackedShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(result, amount)
                .define('x', ingredient)
                .pattern("x")
                .pattern("x")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeName(result, ingredient));
    }

    public void bookshelfShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike planks) {
        ShapedRecipeBuilder.shaped(result)
                .define('x', planks)
                .define('y', Items.BOOK)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .unlockedBy(getHasName(planks), has(planks))
                .save(finishedRecipe);
    }

    public void ladderShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike slab) {
        ShapedRecipeBuilder.shaped(result, 3)
                .define('x', slab)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("y y")
                .pattern("yxy")
                .pattern("y y")
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(slab), has(slab))
                .save(finishedRecipe);
    }

    public void paneShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(result, 16)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void stairsShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(result, 4)
                .define('x', ingredient)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void slabShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(result, 6)
                .define('x', ingredient)
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void wallShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(result, 6)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void fenceShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(result, 3)
                .define('x', ingredient)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("xyx")
                .pattern("xyx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void fenceGateShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(result)
                .define('x', ingredient)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("yxy")
                .pattern("yxy")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void cakeShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(result)
                .define('x', ingredient)
                .define('y', ModTags.ForgeTags.Items.MILK)
                .define('z', Items.SUGAR)
                .define('i', Tags.Items.EGGS)
                .define('j', Tags.Items.CROPS_WHEAT)
                .pattern("xyx")
                .pattern("ziz")
                .pattern("jjj")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(finishedRecipe);
    }

    //Shapeless Recipe
    public void oneToOneShapeless(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        ShapelessRecipeBuilder.shapeless(result, amount)
                .requires(ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeName(result, ingredient));
    }

    public void mossyCobblestoneBricksShapeless(Consumer<FinishedRecipe> finishedRecipe, ItemLike ingredient) {
        ShapelessRecipeBuilder.shapeless(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get())
                .requires(ModBlocks.COBBLESTONE_BRICKS.get())
                .requires(ingredient)
                .group(name(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get()))
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_BRICKS.get()), has(ModBlocks.COBBLESTONE_BRICKS.get()))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeName(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get(), ingredient));
    }

    public void pieShapeless(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapelessRecipeBuilder.shapeless(result)
                .requires(Items.APPLE)
                .requires(Tags.Items.EGGS)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    //Smelting
    public void smelting(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, xp, 200).
                unlockedBy(getHasName(ingredient), has(ingredient)).
                save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeName(result, ingredient), "_from_smelting"));
    }

    public void blasting(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, xp, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeName(result, ingredient), "_from_blasting"));
    }

    public void smoking(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), result, xp, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeName(result, ingredient), "_from_smoking"));
    }

    public void campFire(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), result, xp, 600)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeName(result, ingredient), "_from_campfire"));
    }

    //Stonecutting
    public void stonecutting(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        stonecutting(finishedRecipe, result, ingredient, 1);
    }

    public void stonecutting(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeName(result, ingredient), "_from_stonecutting"));
    }

    //Helper methods
    private static String getHasName(ItemLike item) {
        return "has_" + name(item);
    }

    /**
     * ModDataGenerator.extends a recipe name with "from" an ingredient. Ignores
     * namespace and always adds modid as namespace.
     *
     * @param result     - the item to be crafted
     * @param ingredient - the ingredient in the recipe
     * @return a modified ResourceLocation
     */
    private static ResourceLocation getConversionRecipeName(ItemLike result, ItemLike ingredient) {
        return ModDataGenerator.extend(modLoc(result), "_from_" + name(ingredient));
    }

    /**
     * ModDataGenerator.extends a recipe name with "alt" to allow different recipes
     * for one item. Ignores namespace and always adds modid as
     * namespace. Use getConversionRecipeName when possible.
     *
     * @param result - the item to be crafted
     * @return a modified ResourceLocation
     */
    private static ResourceLocation getAltName(ItemLike result) {
        return ModDataGenerator.extend(modLoc(result), "_alt");
    }

    /**
     * Returns a ResourceLocation with VanillaBoom's modid as the
     * namespace and the items name as path.
     *
     * @param item - the item
     * @return a ResourceLocation with modid namespace
     */
    private static ResourceLocation modLoc(ItemLike item) {
        return new ResourceLocation(VanillaBoom.MOD_ID, name(item));
    }

    /**
     * Returns the default ResourceLocation for an ItemLike.
     *
     * @param item - the item
     * @return the default ResourceLocation
     */
    private static ResourceLocation resLoc(ItemLike item) {
        return item.asItem().getRegistryName();
    }

    /**
     * Returns the item's registry name and ignores namespace.
     *
     * @param item - the item
     * @return the item's registry name
     */
    private static String name(ItemLike item) {
        return resLoc(item).getPath();
    }
}
