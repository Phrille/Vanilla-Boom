/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.decoration.PaintingVariants;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.variant.*;
import phrille.vanillaboom.inventory.recipe.PaintingRecipeBuilder;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.ModTags;
import phrille.vanillaboom.util.Utils;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> finishedRecipe) {
        bricks(finishedRecipe, ModItems.COBBLESTONE_BRICKS.get(), Blocks.COBBLESTONE);
        bricks(finishedRecipe, ModItems.MOSSY_COBBLESTONE_BRICKS.get(), Blocks.MOSSY_COBBLESTONE);
        mossyCobblestoneBricksShapeless(finishedRecipe, Blocks.MOSS_BLOCK);
        mossyCobblestoneBricksShapeless(finishedRecipe, Blocks.VINE);
        twoByTwoShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, ModItems.MAGMA_BRICKS.get(), ModItems.MAGMA_BRICK.get());
        bricks(finishedRecipe, ModItems.OBSIDIAN_BRICKS.get(), Blocks.OBSIDIAN);
        bricks(finishedRecipe, ModItems.SNOW_BRICKS.get(), Blocks.SNOW_BLOCK);
        bricks(finishedRecipe, ModItems.TERRACOTTA_BRICKS.get(), Blocks.TERRACOTTA);
        terracottaBricks(finishedRecipe, ModItems.WHITE_TERRACOTTA_BRICKS.get(), Blocks.WHITE_TERRACOTTA, Tags.Items.DYES_WHITE);
        terracottaBricks(finishedRecipe, ModItems.ORANGE_TERRACOTTA_BRICKS.get(), Blocks.ORANGE_TERRACOTTA, Tags.Items.DYES_ORANGE);
        terracottaBricks(finishedRecipe, ModItems.MAGENTA_TERRACOTTA_BRICKS.get(), Blocks.MAGENTA_TERRACOTTA, Tags.Items.DYES_MAGENTA);
        terracottaBricks(finishedRecipe, ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_BLUE_TERRACOTTA, Tags.Items.DYES_LIGHT_BLUE);
        terracottaBricks(finishedRecipe, ModItems.YELLOW_TERRACOTTA_BRICKS.get(), Blocks.YELLOW_TERRACOTTA, Tags.Items.DYES_YELLOW);
        terracottaBricks(finishedRecipe, ModItems.LIME_TERRACOTTA_BRICKS.get(), Blocks.LIME_TERRACOTTA, Tags.Items.DYES_LIME);
        terracottaBricks(finishedRecipe, ModItems.PINK_TERRACOTTA_BRICKS.get(), Blocks.PINK_TERRACOTTA, Tags.Items.DYES_PINK);
        terracottaBricks(finishedRecipe, ModItems.GRAY_TERRACOTTA_BRICKS.get(), Blocks.GRAY_TERRACOTTA, Tags.Items.DYES_GRAY);
        terracottaBricks(finishedRecipe, ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_GRAY_TERRACOTTA, Tags.Items.DYES_LIGHT_GRAY);
        terracottaBricks(finishedRecipe, ModItems.CYAN_TERRACOTTA_BRICKS.get(), Blocks.CYAN_TERRACOTTA, Tags.Items.DYES_CYAN);
        terracottaBricks(finishedRecipe, ModItems.PURPLE_TERRACOTTA_BRICKS.get(), Blocks.PURPLE_TERRACOTTA, Tags.Items.DYES_PURPLE);
        terracottaBricks(finishedRecipe, ModItems.BLUE_TERRACOTTA_BRICKS.get(), Blocks.BLUE_TERRACOTTA, Tags.Items.DYES_BLUE);
        terracottaBricks(finishedRecipe, ModItems.BROWN_TERRACOTTA_BRICKS.get(), Blocks.BROWN_TERRACOTTA, Tags.Items.DYES_BROWN);
        terracottaBricks(finishedRecipe, ModItems.GREEN_TERRACOTTA_BRICKS.get(), Blocks.GREEN_TERRACOTTA, Tags.Items.DYES_GREEN);
        terracottaBricks(finishedRecipe, ModItems.RED_TERRACOTTA_BRICKS.get(), Blocks.RED_TERRACOTTA, Tags.Items.DYES_RED);
        terracottaBricks(finishedRecipe, ModItems.BLACK_TERRACOTTA_BRICKS.get(), Blocks.BLACK_TERRACOTTA, Tags.Items.DYES_BLACK);
        twoByTwoShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, ModItems.BONE_SAND.get(), Items.BONE_MEAL);
        twoByTwoShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, ModItems.WITHER_BONE_SAND.get(), ModItems.WITHER_BONE_MEAL.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.PERIDOTITE.get(), 2)
                .requires(Blocks.DIORITE)
                .requires(Blocks.PRISMARINE)
                .unlockedBy(getHasName(Blocks.DIORITE), has(Blocks.DIORITE))
                .unlockedBy(getHasName(Blocks.PRISMARINE), has(Blocks.PRISMARINE))
                .save(finishedRecipe);
        polishedBlock(finishedRecipe, ModItems.POLISHED_PERIDOTITE.get(), ModItems.PERIDOTITE.get());
        polishedBlock(finishedRecipe, ModItems.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE, List.of(Blocks.PRISMARINE_BRICKS));
        polishedBlock(finishedRecipe, ModItems.POLISHED_DARK_PRISMARINE.get(), Blocks.DARK_PRISMARINE);
        polishedBlock(finishedRecipe, ModItems.POLISHED_END_STONE.get(), Blocks.END_STONE_BRICKS, List.of(Blocks.END_STONE));
        polishedBlock(finishedRecipe, ModItems.POLISHED_NETHERRACK.get(), Blocks.NETHERRACK);
        smelting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICKS, 0.1F);
        chiseledBlock(finishedRecipe, ModItems.CHISELED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICK_SLAB, List.of(Blocks.RED_NETHER_BRICKS));
        chiseledBlock(finishedRecipe, ModItems.CHISELED_PURPUR_BLOCK.get(), Blocks.PURPUR_SLAB, List.of(Blocks.PURPUR_BLOCK));
        chiseledBlock(finishedRecipe, ModItems.CHISELED_OBSIDIAN.get(), ModItems.OBSIDIAN_SLAB.get(), List.of(Blocks.OBSIDIAN, ModItems.OBSIDIAN_BRICKS.get()));
        pillarBlock(finishedRecipe, ModItems.GRANITE_PILLAR.get(), Blocks.POLISHED_GRANITE, List.of(Blocks.GRANITE));
        pillarBlock(finishedRecipe, ModItems.DIORITE_PILLAR.get(), Blocks.POLISHED_DIORITE, List.of(Blocks.DIORITE));
        pillarBlock(finishedRecipe, ModItems.ANDESITE_PILLAR.get(), Blocks.POLISHED_ANDESITE, List.of(Blocks.ANDESITE));
        pillarBlock(finishedRecipe, ModItems.PERIDOTITE_PILLAR.get(), ModItems.POLISHED_PERIDOTITE.get(), List.of(ModItems.PERIDOTITE.get()));
        pillarBlock(finishedRecipe, ModItems.PRISMARINE_PILLAR.get(), ModItems.POLISHED_PRISMARINE.get(), List.of(Blocks.PRISMARINE));
        pillarBlock(finishedRecipe, ModItems.PRISMARINE_PILLAR.get(), Blocks.PRISMARINE_BRICKS);
        pillarBlock(finishedRecipe, ModItems.DARK_PRISMARINE_PILLAR.get(), ModItems.POLISHED_DARK_PRISMARINE.get(), List.of(Blocks.DARK_PRISMARINE));
        pillarBlock(finishedRecipe, ModItems.END_STONE_PILLAR.get(), ModItems.POLISHED_END_STONE.get(), List.of(Blocks.END_STONE));
        pillarBlock(finishedRecipe, ModItems.END_STONE_PILLAR.get(), Blocks.END_STONE_BRICKS);
        pillarBlock(finishedRecipe, ModItems.NETHERRACK_PILLAR.get(), ModItems.POLISHED_NETHERRACK.get(), List.of(Blocks.NETHERRACK));
        pillarBlock(finishedRecipe, ModItems.OBSIDIAN_PILLAR.get(), Blocks.OBSIDIAN);
        pillarBlock(finishedRecipe, ModItems.OBSIDIAN_PILLAR.get(), ModItems.OBSIDIAN_BRICKS.get());
        storageBlock(finishedRecipe, ModItems.CHARCOAL_BLOCK.get(), Items.CHARCOAL);
        storageBlock(finishedRecipe, ModItems.SUGAR_BLOCK.get(), Items.SUGAR);
        storageBlock(finishedRecipe, ModItems.SUGAR_CANE_BLOCK.get(), Items.SUGAR_CANE);
        storageBlock(finishedRecipe, ModItems.GUNPOWDER_BLOCK.get(), Items.GUNPOWDER);
        storageBlock(finishedRecipe, ModItems.BLAZE_POWDER_BLOCK.get(), Items.BLAZE_POWDER);
        storageBlock(finishedRecipe, ModItems.MAGMA_CREAM_BLOCK.get(), Items.MAGMA_CREAM);
        storageBlock(finishedRecipe, ModItems.PRISMARINE_CRYSTAL_BLOCK.get(), Items.PRISMARINE_CRYSTALS);
        storageBlock(finishedRecipe, ModItems.WITHER_BONE_BLOCK.get(), ModItems.WITHER_BONE.get());
        storageBlock(finishedRecipe, ModItems.ORANGE_DYE_BLOCK.get(), Items.ORANGE_DYE);
        storageBlock(finishedRecipe, ModItems.MAGENTA_DYE_BLOCK.get(), Items.MAGENTA_DYE);
        storageBlock(finishedRecipe, ModItems.LIGHT_BLUE_DYE_BLOCK.get(), Items.LIGHT_BLUE_DYE);
        storageBlock(finishedRecipe, ModItems.YELLOW_DYE_BLOCK.get(), Items.YELLOW_DYE);
        storageBlock(finishedRecipe, ModItems.LIME_DYE_BLOCK.get(), Items.LIME_DYE);
        storageBlock(finishedRecipe, ModItems.PINK_DYE_BLOCK.get(), Items.PINK_DYE);
        storageBlock(finishedRecipe, ModItems.GRAY_DYE_BLOCK.get(), Items.GRAY_DYE);
        storageBlock(finishedRecipe, ModItems.LIGHT_GRAY_DYE_BLOCK.get(), Items.LIGHT_GRAY_DYE);
        storageBlock(finishedRecipe, ModItems.CYAN_DYE_BLOCK.get(), Items.CYAN_DYE);
        storageBlock(finishedRecipe, ModItems.PURPLE_DYE_BLOCK.get(), Items.PURPLE_DYE);
        storageBlock(finishedRecipe, ModItems.BLUE_DYE_BLOCK.get(), Items.BLUE_DYE);
        storageBlock(finishedRecipe, ModItems.BROWN_DYE_BLOCK.get(), Items.BROWN_DYE);
        storageBlock(finishedRecipe, ModItems.GREEN_DYE_BLOCK.get(), Items.GREEN_DYE);
        storageBlock(finishedRecipe, ModItems.RED_DYE_BLOCK.get(), Items.RED_DYE);
        storageBlock(finishedRecipe, ModItems.BLACK_DYE_BLOCK.get(), Items.BLACK_DYE);
        smeltingAndBlasting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_GLASS.get(), Blocks.SOUL_SAND, 0.1F);
        smeltingAndBlasting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_GLASS.get(), Blocks.SOUL_SOIL, 0.1F);
        stainedSoulGlass(finishedRecipe, ModItems.WHITE_STAINED_SOUL_GLASS.get(), ModItems.WHITE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_WHITE);
        stainedSoulGlass(finishedRecipe, ModItems.ORANGE_STAINED_SOUL_GLASS.get(), ModItems.ORANGE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_ORANGE);
        stainedSoulGlass(finishedRecipe, ModItems.MAGENTA_STAINED_SOUL_GLASS.get(), ModItems.MAGENTA_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_MAGENTA);
        stainedSoulGlass(finishedRecipe, ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS.get(), ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIGHT_BLUE);
        stainedSoulGlass(finishedRecipe, ModItems.YELLOW_STAINED_SOUL_GLASS.get(), ModItems.YELLOW_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_YELLOW);
        stainedSoulGlass(finishedRecipe, ModItems.LIME_STAINED_SOUL_GLASS.get(), ModItems.LIME_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIME);
        stainedSoulGlass(finishedRecipe, ModItems.PINK_STAINED_SOUL_GLASS.get(), ModItems.PINK_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_PINK);
        stainedSoulGlass(finishedRecipe, ModItems.GRAY_STAINED_SOUL_GLASS.get(), ModItems.GRAY_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_GRAY);
        stainedSoulGlass(finishedRecipe, ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS.get(), ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIGHT_GRAY);
        stainedSoulGlass(finishedRecipe, ModItems.CYAN_STAINED_SOUL_GLASS.get(), ModItems.CYAN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_CYAN);
        stainedSoulGlass(finishedRecipe, ModItems.PURPLE_STAINED_SOUL_GLASS.get(), ModItems.PURPLE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_PURPLE);
        stainedSoulGlass(finishedRecipe, ModItems.BLUE_STAINED_SOUL_GLASS.get(), ModItems.BLUE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BLUE);
        stainedSoulGlass(finishedRecipe, ModItems.BROWN_STAINED_SOUL_GLASS.get(), ModItems.BROWN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BROWN);
        stainedSoulGlass(finishedRecipe, ModItems.GREEN_STAINED_SOUL_GLASS.get(), ModItems.GREEN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_GREEN);
        stainedSoulGlass(finishedRecipe, ModItems.RED_STAINED_SOUL_GLASS.get(), ModItems.RED_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_RED);
        stainedSoulGlass(finishedRecipe, ModItems.BLACK_STAINED_SOUL_GLASS.get(), ModItems.BLACK_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BLACK);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.RAIN_DETECTOR.get())
                .define('x', Blocks.GLASS)
                .define('y', ModItems.HYDRO_ROCK.get())
                .define('z', ItemTags.WOODEN_SLABS)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("zzz")
                .unlockedBy(getHasName(ModItems.HYDRO_ROCK.get()), has(ModItems.HYDRO_ROCK.get()))
                .save(finishedRecipe);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.GOLD_BARS.get(), 16)
                .define('x', Tags.Items.INGOTS_GOLD)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(finishedRecipe);
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, Items.RED_DYE, ModItems.ROSE.get(), 1);
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, Items.PINK_DYE, ModItems.PEONY.get(), 1);
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, Items.MAGENTA_DYE, ModItems.LILAC.get(), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRELLIS.get(), 4)
                .define('x', Items.BAMBOO)
                .pattern("x x")
                .pattern("x x")
                .pattern("x x")
                .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO))
                .save(finishedRecipe);
        ModBookshelfBlock.BOOKSHELVES.forEach(bookshelf -> bookshelfShaped(finishedRecipe, bookshelf));
        ModLadderBlock.LADDERS.forEach(ladder -> ladderShaped(finishedRecipe, ladder));
        ModStairBlock.STAIRS.forEach(stair -> stair(finishedRecipe, stair));
        ModSlabBlock.SLABS.forEach(slab -> slab(finishedRecipe, slab));
        ModWallBlock.WALLS.forEach(wall -> wall(finishedRecipe, wall));
        ModFenceBlock.FENCES.forEach(fence -> fence(finishedRecipe, fence));
        ModFenceGateBlock.FENCE_GATES.forEach(fenceGate -> fenceGate(finishedRecipe, fenceGate));
        variants(finishedRecipe, ModItems.COBBLESTONE_BRICK_STAIRS.get(), ModItems.COBBLESTONE_BRICK_SLAB.get(), ModItems.COBBLESTONE_BRICK_WALL.get(), Blocks.COBBLESTONE);
        variants(finishedRecipe, ModItems.MOSSY_COBBLESTONE_BRICK_STAIRS.get(), ModItems.MOSSY_COBBLESTONE_BRICK_SLAB.get(), ModItems.MOSSY_COBBLESTONE_BRICK_WALL.get(), Blocks.MOSSY_COBBLESTONE);
        variants(finishedRecipe, ModItems.OBSIDIAN_BRICK_STAIRS.get(), ModItems.OBSIDIAN_BRICK_SLAB.get(), ModItems.OBSIDIAN_BRICK_WALL.get(), Blocks.OBSIDIAN);
        variants(finishedRecipe, ModItems.SNOW_BRICK_STAIRS.get(), ModItems.SNOW_BRICK_SLAB.get(), ModItems.SNOW_BRICK_WALL.get(), Blocks.SNOW_BLOCK);
        variants(finishedRecipe, ModItems.TERRACOTTA_BRICK_STAIRS.get(), ModItems.TERRACOTTA_BRICK_SLAB.get(), ModItems.TERRACOTTA_BRICK_WALL.get(), Blocks.TERRACOTTA);
        variants(finishedRecipe, ModItems.WHITE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.WHITE_TERRACOTTA_BRICK_SLAB.get(), ModItems.WHITE_TERRACOTTA_BRICK_WALL.get(), Blocks.WHITE_TERRACOTTA);
        variants(finishedRecipe, ModItems.ORANGE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.ORANGE_TERRACOTTA_BRICK_SLAB.get(), ModItems.ORANGE_TERRACOTTA_BRICK_WALL.get(), Blocks.ORANGE_TERRACOTTA);
        variants(finishedRecipe, ModItems.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(), ModItems.MAGENTA_TERRACOTTA_BRICK_SLAB.get(), ModItems.MAGENTA_TERRACOTTA_BRICK_WALL.get(), Blocks.MAGENTA_TERRACOTTA);
        variants(finishedRecipe, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        variants(finishedRecipe, ModItems.YELLOW_TERRACOTTA_BRICK_STAIRS.get(), ModItems.YELLOW_TERRACOTTA_BRICK_SLAB.get(), ModItems.YELLOW_TERRACOTTA_BRICK_WALL.get(), Blocks.YELLOW_TERRACOTTA);
        variants(finishedRecipe, ModItems.LIME_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIME_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIME_TERRACOTTA_BRICK_WALL.get(), Blocks.LIME_TERRACOTTA);
        variants(finishedRecipe, ModItems.PINK_TERRACOTTA_BRICK_STAIRS.get(), ModItems.PINK_TERRACOTTA_BRICK_SLAB.get(), ModItems.PINK_TERRACOTTA_BRICK_WALL.get(), Blocks.PINK_TERRACOTTA);
        variants(finishedRecipe, ModItems.GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModItems.GRAY_TERRACOTTA_BRICK_SLAB.get(), ModItems.GRAY_TERRACOTTA_BRICK_WALL.get(), Blocks.GRAY_TERRACOTTA);
        variants(finishedRecipe, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        variants(finishedRecipe, ModItems.CYAN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.CYAN_TERRACOTTA_BRICK_SLAB.get(), ModItems.CYAN_TERRACOTTA_BRICK_WALL.get(), Blocks.CYAN_TERRACOTTA);
        variants(finishedRecipe, ModItems.PURPLE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.PURPLE_TERRACOTTA_BRICK_SLAB.get(), ModItems.PURPLE_TERRACOTTA_BRICK_WALL.get(), Blocks.PURPLE_TERRACOTTA);
        variants(finishedRecipe, ModItems.BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BLUE_TERRACOTTA_BRICK_SLAB.get(), ModItems.BLUE_TERRACOTTA_BRICK_WALL.get(), Blocks.BLUE_TERRACOTTA);
        variants(finishedRecipe, ModItems.BROWN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BROWN_TERRACOTTA_BRICK_SLAB.get(), ModItems.BROWN_TERRACOTTA_BRICK_WALL.get(), Blocks.BROWN_TERRACOTTA);
        variants(finishedRecipe, ModItems.GREEN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.GREEN_TERRACOTTA_BRICK_SLAB.get(), ModItems.GREEN_TERRACOTTA_BRICK_WALL.get(), Blocks.GREEN_TERRACOTTA);
        variants(finishedRecipe, ModItems.RED_TERRACOTTA_BRICK_STAIRS.get(), ModItems.RED_TERRACOTTA_BRICK_SLAB.get(), ModItems.RED_TERRACOTTA_BRICK_WALL.get(), Blocks.RED_TERRACOTTA);
        variants(finishedRecipe, ModItems.BLACK_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BLACK_TERRACOTTA_BRICK_SLAB.get(), ModItems.BLACK_TERRACOTTA_BRICK_WALL.get(), Blocks.BLACK_TERRACOTTA);
        variants(finishedRecipe, ModItems.POLISHED_PERIDOTITE_STAIRS.get(), ModItems.POLISHED_PERIDOTITE_SLAB.get(), ModItems.POLISHED_PERIDOTITE_WALL.get(), ModItems.PERIDOTITE.get());
        variants(finishedRecipe, ModItems.POLISHED_PRISMARINE_STAIRS.get(), ModItems.POLISHED_PRISMARINE_SLAB.get(), ModItems.POLISHED_PRISMARINE_WALL.get(), List.of(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS));
        variants(finishedRecipe, ModItems.POLISHED_DARK_PRISMARINE_STAIRS.get(), ModItems.POLISHED_DARK_PRISMARINE_SLAB.get(), ModItems.POLISHED_DARK_PRISMARINE_WALL.get(), Blocks.DARK_PRISMARINE);
        variants(finishedRecipe, ModItems.POLISHED_END_STONE_STAIRS.get(), ModItems.POLISHED_END_STONE_SLAB.get(), ModItems.POLISHED_END_STONE_WALL.get(), List.of(Blocks.END_STONE, Blocks.END_STONE_BRICKS));
        variants(finishedRecipe, ModItems.POLISHED_NETHERRACK_STAIRS.get(), ModItems.POLISHED_NETHERRACK_SLAB.get(), ModItems.POLISHED_NETHERRACK_WALL.get(), Blocks.NETHERRACK);
        variants(finishedRecipe, ModItems.QUARTZ_BRICK_STAIRS.get(), ModItems.QUARTZ_BRICK_SLAB.get(), ModItems.QUARTZ_BRICK_WALL.get(), Blocks.QUARTZ_BLOCK);
        variants(finishedRecipe, ModItems.CUT_SANDSTONE_STAIRS.get(), ModItems.CUT_SANDSTONE_WALL.get(), Blocks.SANDSTONE);
        variants(finishedRecipe, ModItems.CUT_RED_SANDSTONE_STAIRS.get(), ModItems.CUT_RED_SANDSTONE_WALL.get(), Blocks.RED_SANDSTONE);
        variants(finishedRecipe, RecipeCategory.DECORATIONS, ModItems.POLISHED_GRANITE_WALL.get(), Blocks.GRANITE);
        variants(finishedRecipe, RecipeCategory.DECORATIONS, ModItems.POLISHED_DIORITE_WALL.get(), Blocks.DIORITE);
        variants(finishedRecipe, RecipeCategory.DECORATIONS, ModItems.POLISHED_ANDESITE_WALL.get(), Blocks.ANDESITE);

        // Items
        smeltingAndBlasting(finishedRecipe, RecipeCategory.MISC, ModItems.MAGMA_BRICK.get(), Blocks.MAGMA_BLOCK, 0.1F);
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, ModItems.WITHER_BONE_MEAL.get(), ModItems.WITHER_BONE.get(), 3);
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, Items.BLACK_DYE, ModItems.WITHER_BONE_MEAL.get(), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PRISMARINE_ARROW.get())
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.PRISMARINE_ARROW.get())
                .requires(Items.ARROW)
                .requires(Items.PRISMARINE_SHARD)
                .group(name(ModItems.PRISMARINE_ARROW.get()))
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD))
                .unlockedBy(getHasName(Items.FEATHER), has(Items.FEATHER))
                .save(finishedRecipe, getConversionRecipeResourceLocation(ModItems.PRISMARINE_ARROW.get(), Items.ARROW));
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, Items.LEATHER, ModItems.POLAR_BEAR_FUR.get(), 4);
        surroundedShaped(finishedRecipe, RecipeCategory.MISC, Items.BOOK, Items.PAPER, ModItems.POLAR_BEAR_FUR.get(), 4);
        surroundedShaped(finishedRecipe, RecipeCategory.DECORATIONS, Items.ITEM_FRAME, Tags.Items.RODS_WOODEN, ModItems.POLAR_BEAR_FUR.get(), 4);
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, ModItems.TOMATO_SEEDS.get(), ModItems.TOMATO.get(), 1);
        oneToOneShapeless(finishedRecipe, RecipeCategory.MISC, ModItems.CHILI_SEEDS.get(), ModItems.CHILI.get(), 1);
        cooking(finishedRecipe, ModItems.FRIED_EGG.get(), Items.EGG, 0.3F);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MELON_POPSICLE.get(), 4)
                .requires(Items.MELON_SLICE)
                .requires(Blocks.ICE)
                .requires(Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON))
                .unlockedBy(getHasName(Blocks.ICE), has(Blocks.ICE))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE.get(), 2)
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.POTATO_SOUP.get())
                .requires(Items.BOWL)
                .requires(ModTags.VanillaBoomTags.Items.POTATO_SOUP_INGREDIENTS)
                .requires(ModTags.VanillaBoomTags.Items.POTATO_SOUP_INGREDIENTS)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                .unlockedBy(getHasName(Items.POISONOUS_POTATO), has(Items.POISONOUS_POTATO))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MEAT_SOUP.get())
                .requires(Items.BOWL)
                .requires(Tags.Items.CROPS_POTATO)
                .requires(ModTags.ForgeTags.Items.COOKED_MEATS)
                .requires(ModTags.ForgeTags.Items.COOKED_MEATS)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FISH_SOUP.get())
                .requires(Items.BOWL)
                .requires(Items.SEA_PICKLE)
                .requires(ModTags.ForgeTags.Items.COOKED_FISHES)
                .requires(ModTags.ForgeTags.Items.COOKED_FISHES)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(Items.SEA_PICKLE), has(Items.SEA_PICKLE))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RICE_BOWL.get())
                .requires(Items.BOWL)
                .requires(ModTags.ForgeTags.Items.RICE)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(ModItems.RICE_GRAINS.get()), has(ModItems.RICE_GRAINS.get()))
                .save(finishedRecipe);
        cooking(finishedRecipe, ModItems.COOKED_TUNA.get(), ModItems.TUNA.get(), 0.35F);
        cooking(finishedRecipe, ModItems.COOKED_PERCH.get(), ModItems.PERCH.get(), 0.35F);
        cooking(finishedRecipe, ModItems.COOKED_PIKE.get(), ModItems.PIKE.get(), 0.35F);
        cooking(finishedRecipe, ModItems.COOKED_EEL.get(), ModItems.EEL.get(), 0.35F);

        // Altered recipes from vanilla
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BONE_BLOCK)
                .define('x', Items.BONE)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE, 9)
                .requires(Blocks.BONE_BLOCK)
                .unlockedBy(getHasName(Blocks.BONE_BLOCK), has(Blocks.BONE_BLOCK))
                .save(finishedRecipe, "bone_meal_from_bone_block");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.BOOKSHELF)
                .define('x', Blocks.OAK_PLANKS)
                .define('y', Items.BOOK)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("xxx")
                .unlockedBy(getHasName(Blocks.BOOKSHELF), has(Blocks.BOOKSHELF))
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(finishedRecipe);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.NETHER_BRICK_FENCE, 3)
                .define('x', Items.NETHER_BRICK)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("xyx")
                .pattern("xyx")
                .unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(finishedRecipe);

        // Paintings
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.EASEL.get())
                .define('x', ItemTags.WOODEN_SLABS)
                .define('y', ModTags.ForgeTags.Items.CANVAS)
                .define('z', Blocks.OAK_PLANKS) // TODO: 1.20 replace with brush
                .pattern("xyx")
                .pattern(" z ")
                .pattern(" x ")
                .unlockedBy(getHasName(ModItems.CANVAS.get()), has(ModItems.CANVAS.get())) // TODO: add unlocked by brush
                .save(finishedRecipe);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CANVAS.get(), 2)
                .requires(ItemTags.WOOL)
                .requires(Tags.Items.SHEARS)
                .unlockedBy(getHasName(Blocks.WHITE_WOOL), has(Blocks.WHITE_WOOL))
                .unlockedBy(getHasName(Items.SHEARS), has(Items.SHEARS))
                .save(finishedRecipe);
        painting(finishedRecipe, PaintingVariants.KEBAB, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_LIME));
        painting(finishedRecipe, PaintingVariants.AZTEC, List.of(Tags.Items.DYES_BLACK, Tags.Items.DYES_LIGHT_GRAY));
        painting(finishedRecipe, PaintingVariants.ALBAN, List.of(Tags.Items.DYES_YELLOW, Tags.Items.DYES_GREEN));
        painting(finishedRecipe, PaintingVariants.AZTEC2, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_GREEN));
        painting(finishedRecipe, PaintingVariants.BOMB, List.of(Tags.Items.DYES_YELLOW, Tags.Items.DYES_LIME));
        painting(finishedRecipe, PaintingVariants.PLANT, List.of(Tags.Items.DYES_GREEN, Tags.Items.DYES_WHITE));
        painting(finishedRecipe, PaintingVariants.WASTELAND, List.of(Tags.Items.DYES_YELLOW, Tags.Items.DYES_BROWN));
        painting(finishedRecipe, PaintingVariants.POOL, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_BROWN));
        painting(finishedRecipe, PaintingVariants.COURBET, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_BLACK, Tags.Items.DYES_LIGHT_GRAY));
        painting(finishedRecipe, PaintingVariants.SEA, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_LIME));
        painting(finishedRecipe, PaintingVariants.SUNSET, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_BLACK));
        painting(finishedRecipe, PaintingVariants.CREEBET, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_LIME));
        painting(finishedRecipe, PaintingVariants.WANDERER, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_PINK, Tags.Items.DYES_BLACK));
        painting(finishedRecipe, PaintingVariants.GRAHAM, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_BLACK, Tags.Items.DYES_YELLOW));
        painting(finishedRecipe, PaintingVariants.MATCH, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_BROWN, Tags.Items.DYES_ORANGE));
        painting(finishedRecipe, PaintingVariants.BUST, List.of(Tags.Items.DYES_LIME, Tags.Items.DYES_BLACK, Tags.Items.DYES_ORANGE));
        painting(finishedRecipe, PaintingVariants.STAGE, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_BLACK, Tags.Items.DYES_WHITE));
        painting(finishedRecipe, PaintingVariants.VOID, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_BLACK, Tags.Items.DYES_MAGENTA));
        painting(finishedRecipe, PaintingVariants.SKULL_AND_ROSES, List.of(Tags.Items.DYES_CYAN, Tags.Items.DYES_GREEN, Tags.Items.DYES_RED));
        painting(finishedRecipe, PaintingVariants.WITHER, List.of(Tags.Items.DYES_BLACK, Tags.Items.DYES_GREEN, Tags.Items.DYES_RED));
        painting(finishedRecipe, PaintingVariants.FIGHTERS, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_GREEN, Tags.Items.DYES_WHITE, Tags.Items.DYES_BROWN, Tags.Items.DYES_BLACK, Tags.Items.DYES_ORANGE));
        painting(finishedRecipe, PaintingVariants.POINTER, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_WHITE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_BLACK, Tags.Items.DYES_PURPLE, Tags.Items.DYES_BROWN));
        painting(finishedRecipe, PaintingVariants.PIGSCENE, List.of(Tags.Items.DYES_PINK, Tags.Items.DYES_ORANGE, Tags.Items.DYES_BROWN, Tags.Items.DYES_BLACK, Tags.Items.DYES_BLACK, Tags.Items.DYES_GREEN));
        painting(finishedRecipe, PaintingVariants.BURNING_SKULL, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_GREEN, Tags.Items.DYES_BLACK, Tags.Items.DYES_WHITE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_LIGHT_GRAY));
        painting(finishedRecipe, PaintingVariants.SKELETON, List.of(Tags.Items.DYES_ORANGE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_WHITE, Tags.Items.DYES_WHITE, Tags.Items.DYES_GRAY, Tags.Items.DYES_LIGHT_GRAY));
        painting(finishedRecipe, PaintingVariants.DONKEY_KONG, List.of(Tags.Items.DYES_BLACK, Tags.Items.DYES_BLACK, Tags.Items.DYES_PINK, Tags.Items.DYES_RED, Tags.Items.DYES_WHITE, Tags.Items.DYES_BROWN));

        painting(finishedRecipe, PaintingVariants.EARTH, List.of(Tags.Items.DYES_BROWN, Tags.Items.DYES_BROWN, Tags.Items.DYES_ORANGE));
        painting(finishedRecipe, PaintingVariants.WIND, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_LIGHT_GRAY, Tags.Items.DYES_YELLOW));
        painting(finishedRecipe, PaintingVariants.FIRE, List.of(Tags.Items.DYES_ORANGE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_YELLOW));
        painting(finishedRecipe, PaintingVariants.WATER, List.of(Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_BLUE, Tags.Items.DYES_WHITE));
    }

    // Templates
    public void bricks(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 4);
        stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient);
    }

    public void terracottaBricks(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, TagKey<Item> dye) {
        bricks(finishedRecipe, result, ingredient);
        dyeCenterShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ModItems.TERRACOTTA_BRICKS.get(), dye, getAltName(result));
    }

    public void polishedBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        polishedBlock(finishedRecipe, result, ingredient, List.of());
    }

    public void polishedBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        twoByTwoShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 4);
        stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient);
        variants.forEach(variant -> stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, variant));
    }

    public void chiseledBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        stackedShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 1);
        variants.forEach(variant -> stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, variant));
    }

    public void pillarBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        pillarBlock(finishedRecipe, result, ingredient, List.of());
    }

    public void pillarBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        stackedShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 2);
        stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient);
        variants.forEach(variant -> stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, variant));
    }

    public void storageBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        threeByThreeShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 1);
        oneToOneShapeless(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, ingredient, result, 9);
    }

    public void stainedSoulGlass(Consumer<FinishedRecipe> finishedRecipe, ItemLike glass, ItemLike pane, TagKey<Item> dye) {
        dyeCenterShaped(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, glass, ModItems.SOUL_GLASS.get(), dye, modLoc(glass));
        paneShaped(finishedRecipe, pane, glass);
    }

    public void smeltingAndBlasting(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        smelting(finishedRecipe, category, result, ingredient, xp);
        blasting(finishedRecipe, category, result, ingredient, xp);
    }

    public void cooking(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, float xp) {
        smelting(finishedRecipe, RecipeCategory.FOOD, result, ingredient, xp);
        smoking(finishedRecipe, RecipeCategory.FOOD, result, ingredient, xp);
        campFire(finishedRecipe, RecipeCategory.FOOD, result, ingredient, xp);
    }

    public void stair(Consumer<FinishedRecipe> finishedRecipe, ModStairBlock stair) {
        stairsShaped(finishedRecipe, stair.asItem(), stair.getParent().asItem());
        if (name(stair).contains("wood") || name(stair).contains("hyphae")) {
            return;
        }
        stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, stair.asItem(), stair.getParent().asItem());
    }

    public void slab(Consumer<FinishedRecipe> finishedRecipe, ModSlabBlock slab) {
        slabShaped(finishedRecipe, slab.asItem(), slab.getParent().asItem());
        if (name(slab).contains("wood") || name(slab).contains("hyphae")) {
            return;
        }
        stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, slab.asItem(), slab.getParent().asItem(), 2);
    }

    public void wall(Consumer<FinishedRecipe> finishedRecipe, ModWallBlock wall) {
        wallShaped(finishedRecipe, wall.asItem(), wall.getParent().asItem());
        if (name(wall).contains("wood") || name(wall).contains("hyphae")) {
            return;
        }
        stonecutting(finishedRecipe, RecipeCategory.DECORATIONS, wall.asItem(), wall.getParent().asItem());
    }

    public void fence(Consumer<FinishedRecipe> finishedRecipe, ModFenceBlock fence) {
        fenceShaped(finishedRecipe, fence.asItem(), fence.getParent().asItem());
    }

    public void fenceGate(Consumer<FinishedRecipe> finishedRecipe, ModFenceGateBlock fenceGate) {
        fenceGateShaped(finishedRecipe, fenceGate.asItem(), fenceGate.getParent().asItem());
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike slab, ItemLike wall, ItemLike block) {
        variants(finishedRecipe, stair, slab, wall, List.of(block));
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike slab, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> {
            stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, stair, block);
            stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, slab, block, 2);
            stonecutting(finishedRecipe, RecipeCategory.DECORATIONS, wall, block);
        });
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike wall, ItemLike block) {
        variants(finishedRecipe, stair, wall, List.of(block));
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, ItemLike stair, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> {
            stonecutting(finishedRecipe, RecipeCategory.BUILDING_BLOCKS, stair, block);
            stonecutting(finishedRecipe, RecipeCategory.DECORATIONS, wall, block);
        });
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike wall, ItemLike block) {
        variants(finishedRecipe, category, wall, List.of(block));
    }

    public void variants(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> stonecutting(finishedRecipe, category, wall, block));
    }

    //Shaped Recipe
    public void twoByTwoShaped(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(finishedRecipe, category, result, ingredient, 1);
    }

    public void twoByTwoShaped(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', ingredient)
                .pattern("xx")
                .pattern("xx")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void threeByThreeShaped(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void surroundedShaped(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike surround, ItemLike middle, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', surround)
                .define('y', middle)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .unlockedBy(getHasName(surround), has(surround))
                .unlockedBy(getHasName(middle), has(middle))
                .save(finishedRecipe, getConversionRecipeResourceLocation(result, middle));
    }

    public void surroundedShaped(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, TagKey<Item> surround, ItemLike middle, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', surround)
                .define('y', middle)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .unlockedBy(getHasName(middle), has(middle))
                .save(finishedRecipe, getConversionRecipeResourceLocation(result, middle));
    }

    public void dyeCenterShaped(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, TagKey<Item> dye, ResourceLocation name) {
        ShapedRecipeBuilder.shaped(category, result, 8)
                .define('x', ingredient)
                .define('y', dye)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, name);
    }

    public void stackedShaped(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', ingredient)
                .pattern("x")
                .pattern("x")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeResourceLocation(result, ingredient));
    }

    public void bookshelfShaped(Consumer<FinishedRecipe> finishedRecipe, ModBookshelfBlock bookshelf) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, bookshelf)
                .define('x', bookshelf.getParent())
                .define('y', Items.BOOK)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .unlockedBy(getHasName(bookshelf.getParent()), has(bookshelf.getParent()))
                .save(finishedRecipe);
    }

    public void ladderShaped(Consumer<FinishedRecipe> finishedRecipe, ModLadderBlock ladder) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ladder, 3)
                .define('x', ladder.getCraftingIngredient())
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("y y")
                .pattern("yxy")
                .pattern("y y")
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(ladder.getCraftingIngredient()), has(ladder.getCraftingIngredient()))
                .save(finishedRecipe);
    }

    public void paneShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 16)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void stairsShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .define('x', ingredient)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void slabShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .define('x', ingredient)
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void wallShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 6)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void fenceShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 3)
                .define('x', ingredient)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("xyx")
                .pattern("xyx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void fenceGateShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                .define('x', ingredient)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("yxy")
                .pattern("yxy")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void cakeShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
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

    // Shapeless Recipe
    public void oneToOneShapeless(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapelessRecipeBuilder.shapeless(category, result, amount)
                .requires(ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeResourceLocation(result, ingredient));
    }

    public void mossyCobblestoneBricksShapeless(Consumer<FinishedRecipe> finishedRecipe, ItemLike ingredient) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MOSSY_COBBLESTONE_BRICKS.get())
                .requires(ModItems.COBBLESTONE_BRICKS.get())
                .requires(ingredient)
                .group(name(ModItems.MOSSY_COBBLESTONE_BRICKS.get()))
                .unlockedBy(getHasName(ModItems.COBBLESTONE_BRICKS.get()), has(ModItems.COBBLESTONE_BRICKS.get()))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeResourceLocation(ModItems.MOSSY_COBBLESTONE_BRICKS.get(), ingredient));
    }

    public void pieShapeless(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(ingredient)
                .requires(Tags.Items.EGGS)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    // Smelting
    public void smelting(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), category, result, xp, 200).
                unlockedBy(getHasName(ingredient), has(ingredient)).
                save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_smelting"));
    }

    public void blasting(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), category, result, xp, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_blasting"));
    }

    public void smoking(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), category, result, xp, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_smoking"));
    }

    public void campFire(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), category, result, xp, 600)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_campfire"));
    }

    // Stonecutting
    public void stonecutting(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient) {
        stonecutting(finishedRecipe, category, result, ingredient, 1);
    }

    public void stonecutting(Consumer<FinishedRecipe> finishedRecipe, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), category, result, amount)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_stonecutting"));
    }

    public void painting(Consumer<FinishedRecipe> finishedRecipe, ResourceKey<PaintingVariant> variant, List<TagKey<Item>> dyes) {
        painting(finishedRecipe, Utils.resLocFromPaintingVariant(variant), dyes);
    }

    public void painting(Consumer<FinishedRecipe> finishedRecipe, ResourceLocation variant, List<TagKey<Item>> dyes) {
        List<Ingredient> ingredientDyes = Lists.newArrayList();
        dyes.forEach(dye -> ingredientDyes.add(Ingredient.of(dye)));
        PaintingRecipeBuilder.painting(ingredientDyes, RecipeCategory.DECORATIONS, variant)
                .unlockedBy(getHasName(ModItems.CANVAS.get()), has(ModItems.CANVAS.get()))
                .save(finishedRecipe, VanillaBoom.resLoc(variant.getPath() + "_from_painting"));
    }

    /**
     * Extends a recipe name with "from" an ingredient. Ignores
     * namespace and always adds modid as namespace.
     *
     * @param result     - the item to be crafted
     * @param ingredient - the ingredient in the recipe
     * @return a modified ResourceLocation
     */
    private static ResourceLocation getConversionRecipeResourceLocation(ItemLike result, ItemLike ingredient) {
        return ModDataGenerator.extend(modLoc(result), "_from_" + name(ingredient));
    }

    /**
     * Extends a recipe name with "alt" to allow different recipes
     * for one item. Ignores namespace and always adds modid as
     * namespace. Use getConversionRecipeResourceLocation when possible.
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
        return VanillaBoom.resLoc(name(item));
    }

    /**
     * Returns the default ResourceLocation for an ItemLike.
     *
     * @param item - the item
     * @return the default ResourceLocation
     */
    private static ResourceLocation resLoc(ItemLike item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem()));
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
