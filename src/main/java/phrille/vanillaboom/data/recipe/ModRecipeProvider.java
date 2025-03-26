/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.recipe;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.variant.*;
import phrille.vanillaboom.data.ModDataGenerator;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.CommonTags;
import phrille.vanillaboom.util.ModTags;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        bricks(output, ModItems.COBBLESTONE_BRICKS.get(), Blocks.COBBLESTONE);
        bricks(output, ModItems.MOSSY_COBBLESTONE_BRICKS.get(), Blocks.MOSSY_COBBLESTONE);
        mossyCobblestoneBricksShapeless(output, Blocks.MOSS_BLOCK);
        mossyCobblestoneBricksShapeless(output, Blocks.VINE);
        twoByTwoShaped(output, RecipeCategory.BUILDING_BLOCKS, ModItems.MAGMA_BRICKS.get(), ModItems.MAGMA_BRICK.get());
        bricks(output, ModItems.OBSIDIAN_BRICKS.get(), Blocks.OBSIDIAN);
        bricks(output, ModItems.SNOW_BRICKS.get(), Blocks.SNOW_BLOCK);
        bricks(output, ModItems.TERRACOTTA_BRICKS.get(), Blocks.TERRACOTTA);
        terracottaBricks(output, ModItems.WHITE_TERRACOTTA_BRICKS.get(), Blocks.WHITE_TERRACOTTA, Tags.Items.DYES_WHITE);
        terracottaBricks(output, ModItems.ORANGE_TERRACOTTA_BRICKS.get(), Blocks.ORANGE_TERRACOTTA, Tags.Items.DYES_ORANGE);
        terracottaBricks(output, ModItems.MAGENTA_TERRACOTTA_BRICKS.get(), Blocks.MAGENTA_TERRACOTTA, Tags.Items.DYES_MAGENTA);
        terracottaBricks(output, ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_BLUE_TERRACOTTA, Tags.Items.DYES_LIGHT_BLUE);
        terracottaBricks(output, ModItems.YELLOW_TERRACOTTA_BRICKS.get(), Blocks.YELLOW_TERRACOTTA, Tags.Items.DYES_YELLOW);
        terracottaBricks(output, ModItems.LIME_TERRACOTTA_BRICKS.get(), Blocks.LIME_TERRACOTTA, Tags.Items.DYES_LIME);
        terracottaBricks(output, ModItems.PINK_TERRACOTTA_BRICKS.get(), Blocks.PINK_TERRACOTTA, Tags.Items.DYES_PINK);
        terracottaBricks(output, ModItems.GRAY_TERRACOTTA_BRICKS.get(), Blocks.GRAY_TERRACOTTA, Tags.Items.DYES_GRAY);
        terracottaBricks(output, ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_GRAY_TERRACOTTA, Tags.Items.DYES_LIGHT_GRAY);
        terracottaBricks(output, ModItems.CYAN_TERRACOTTA_BRICKS.get(), Blocks.CYAN_TERRACOTTA, Tags.Items.DYES_CYAN);
        terracottaBricks(output, ModItems.PURPLE_TERRACOTTA_BRICKS.get(), Blocks.PURPLE_TERRACOTTA, Tags.Items.DYES_PURPLE);
        terracottaBricks(output, ModItems.BLUE_TERRACOTTA_BRICKS.get(), Blocks.BLUE_TERRACOTTA, Tags.Items.DYES_BLUE);
        terracottaBricks(output, ModItems.BROWN_TERRACOTTA_BRICKS.get(), Blocks.BROWN_TERRACOTTA, Tags.Items.DYES_BROWN);
        terracottaBricks(output, ModItems.GREEN_TERRACOTTA_BRICKS.get(), Blocks.GREEN_TERRACOTTA, Tags.Items.DYES_GREEN);
        terracottaBricks(output, ModItems.RED_TERRACOTTA_BRICKS.get(), Blocks.RED_TERRACOTTA, Tags.Items.DYES_RED);
        terracottaBricks(output, ModItems.BLACK_TERRACOTTA_BRICKS.get(), Blocks.BLACK_TERRACOTTA, Tags.Items.DYES_BLACK);
        twoByTwoShaped(output, RecipeCategory.BUILDING_BLOCKS, ModItems.BONE_SAND.get(), Items.BONE_MEAL);
        twoByTwoShaped(output, RecipeCategory.BUILDING_BLOCKS, ModItems.WITHER_BONE_SAND.get(), ModItems.WITHER_BONE_MEAL.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.PERIDOTITE.get(), 2)
                .requires(Blocks.DIORITE)
                .requires(Blocks.PRISMARINE)
                .unlockedBy(getHasName(Blocks.DIORITE), has(Blocks.DIORITE))
                .unlockedBy(getHasName(Blocks.PRISMARINE), has(Blocks.PRISMARINE))
                .save(output);
        polishedBlock(output, ModItems.POLISHED_PERIDOTITE.get(), ModItems.PERIDOTITE.get());
        polishedBlock(output, ModItems.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE, List.of(Blocks.PRISMARINE_BRICKS));
        polishedBlock(output, ModItems.POLISHED_DARK_PRISMARINE.get(), Blocks.DARK_PRISMARINE);
        polishedBlock(output, ModItems.POLISHED_END_STONE.get(), Blocks.END_STONE_BRICKS, List.of(Blocks.END_STONE));
        polishedBlock(output, ModItems.POLISHED_NETHERRACK.get(), Blocks.NETHERRACK);
        smelting(output, RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICKS, 0.1F);
        chiseledBlock(output, ModItems.CHISELED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICK_SLAB, List.of(Blocks.RED_NETHER_BRICKS));
        chiseledBlock(output, ModItems.CHISELED_PURPUR_BLOCK.get(), Blocks.PURPUR_SLAB, List.of(Blocks.PURPUR_BLOCK));
        chiseledBlock(output, ModItems.CHISELED_OBSIDIAN.get(), ModItems.OBSIDIAN_SLAB.get(), List.of(Blocks.OBSIDIAN, ModItems.OBSIDIAN_BRICKS.get()));
        pillarBlock(output, ModItems.GRANITE_PILLAR.get(), Blocks.POLISHED_GRANITE, List.of(Blocks.GRANITE));
        pillarBlock(output, ModItems.DIORITE_PILLAR.get(), Blocks.POLISHED_DIORITE, List.of(Blocks.DIORITE));
        pillarBlock(output, ModItems.ANDESITE_PILLAR.get(), Blocks.POLISHED_ANDESITE, List.of(Blocks.ANDESITE));
        pillarBlock(output, ModItems.PERIDOTITE_PILLAR.get(), ModItems.POLISHED_PERIDOTITE.get(), List.of(ModItems.PERIDOTITE.get()));
        pillarBlock(output, ModItems.PRISMARINE_PILLAR.get(), ModItems.POLISHED_PRISMARINE.get(), List.of(Blocks.PRISMARINE));
        pillarBlock(output, ModItems.PRISMARINE_PILLAR.get(), Blocks.PRISMARINE_BRICKS);
        pillarBlock(output, ModItems.DARK_PRISMARINE_PILLAR.get(), ModItems.POLISHED_DARK_PRISMARINE.get(), List.of(Blocks.DARK_PRISMARINE));
        pillarBlock(output, ModItems.END_STONE_PILLAR.get(), ModItems.POLISHED_END_STONE.get(), List.of(Blocks.END_STONE));
        pillarBlock(output, ModItems.END_STONE_PILLAR.get(), Blocks.END_STONE_BRICKS);
        pillarBlock(output, ModItems.NETHERRACK_PILLAR.get(), ModItems.POLISHED_NETHERRACK.get(), List.of(Blocks.NETHERRACK));
        pillarBlock(output, ModItems.OBSIDIAN_PILLAR.get(), Blocks.OBSIDIAN);
        pillarBlock(output, ModItems.OBSIDIAN_PILLAR.get(), ModItems.OBSIDIAN_BRICKS.get());
        storageBlock(output, ModItems.CHARCOAL_BLOCK.get(), Items.CHARCOAL);
        storageBlock(output, ModItems.SUGAR_BLOCK.get(), Items.SUGAR);
        storageBlock(output, ModItems.SUGAR_CANE_BLOCK.get(), Items.SUGAR_CANE);
        storageBlock(output, ModItems.GUNPOWDER_BLOCK.get(), Items.GUNPOWDER);
        storageBlock(output, ModItems.BLAZE_POWDER_BLOCK.get(), Items.BLAZE_POWDER);
        storageBlock(output, ModItems.MAGMA_CREAM_BLOCK.get(), Items.MAGMA_CREAM);
        storageBlock(output, ModItems.PRISMARINE_CRYSTAL_BLOCK.get(), Items.PRISMARINE_CRYSTALS);
        storageBlock(output, ModItems.WITHER_BONE_BLOCK.get(), ModItems.WITHER_BONE_MEAL.get());
        storageBlock(output, ModItems.ORANGE_DYE_BLOCK.get(), Items.ORANGE_DYE);
        storageBlock(output, ModItems.MAGENTA_DYE_BLOCK.get(), Items.MAGENTA_DYE);
        storageBlock(output, ModItems.LIGHT_BLUE_DYE_BLOCK.get(), Items.LIGHT_BLUE_DYE);
        storageBlock(output, ModItems.YELLOW_DYE_BLOCK.get(), Items.YELLOW_DYE);
        storageBlock(output, ModItems.LIME_DYE_BLOCK.get(), Items.LIME_DYE);
        storageBlock(output, ModItems.PINK_DYE_BLOCK.get(), Items.PINK_DYE);
        storageBlock(output, ModItems.GRAY_DYE_BLOCK.get(), Items.GRAY_DYE);
        storageBlock(output, ModItems.LIGHT_GRAY_DYE_BLOCK.get(), Items.LIGHT_GRAY_DYE);
        storageBlock(output, ModItems.CYAN_DYE_BLOCK.get(), Items.CYAN_DYE);
        storageBlock(output, ModItems.PURPLE_DYE_BLOCK.get(), Items.PURPLE_DYE);
        storageBlock(output, ModItems.BLUE_DYE_BLOCK.get(), Items.BLUE_DYE);
        storageBlock(output, ModItems.BROWN_DYE_BLOCK.get(), Items.BROWN_DYE);
        storageBlock(output, ModItems.GREEN_DYE_BLOCK.get(), Items.GREEN_DYE);
        storageBlock(output, ModItems.RED_DYE_BLOCK.get(), Items.RED_DYE);
        storageBlock(output, ModItems.BLACK_DYE_BLOCK.get(), Items.BLACK_DYE);
        smeltingAndBlasting(output, RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_GLASS.get(), Blocks.SOUL_SAND, 0.1F);
        smeltingAndBlasting(output, RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_GLASS.get(), Blocks.SOUL_SOIL, 0.1F);
        stainedSoulGlass(output, ModItems.WHITE_STAINED_SOUL_GLASS.get(), ModItems.WHITE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_WHITE);
        stainedSoulGlass(output, ModItems.ORANGE_STAINED_SOUL_GLASS.get(), ModItems.ORANGE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_ORANGE);
        stainedSoulGlass(output, ModItems.MAGENTA_STAINED_SOUL_GLASS.get(), ModItems.MAGENTA_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_MAGENTA);
        stainedSoulGlass(output, ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS.get(), ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIGHT_BLUE);
        stainedSoulGlass(output, ModItems.YELLOW_STAINED_SOUL_GLASS.get(), ModItems.YELLOW_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_YELLOW);
        stainedSoulGlass(output, ModItems.LIME_STAINED_SOUL_GLASS.get(), ModItems.LIME_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIME);
        stainedSoulGlass(output, ModItems.PINK_STAINED_SOUL_GLASS.get(), ModItems.PINK_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_PINK);
        stainedSoulGlass(output, ModItems.GRAY_STAINED_SOUL_GLASS.get(), ModItems.GRAY_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_GRAY);
        stainedSoulGlass(output, ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS.get(), ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_LIGHT_GRAY);
        stainedSoulGlass(output, ModItems.CYAN_STAINED_SOUL_GLASS.get(), ModItems.CYAN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_CYAN);
        stainedSoulGlass(output, ModItems.PURPLE_STAINED_SOUL_GLASS.get(), ModItems.PURPLE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_PURPLE);
        stainedSoulGlass(output, ModItems.BLUE_STAINED_SOUL_GLASS.get(), ModItems.BLUE_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BLUE);
        stainedSoulGlass(output, ModItems.BROWN_STAINED_SOUL_GLASS.get(), ModItems.BROWN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BROWN);
        stainedSoulGlass(output, ModItems.GREEN_STAINED_SOUL_GLASS.get(), ModItems.GREEN_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_GREEN);
        stainedSoulGlass(output, ModItems.RED_STAINED_SOUL_GLASS.get(), ModItems.RED_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_RED);
        stainedSoulGlass(output, ModItems.BLACK_STAINED_SOUL_GLASS.get(), ModItems.BLACK_STAINED_SOUL_GLASS_PANE.get(), Tags.Items.DYES_BLACK);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.RAIN_DETECTOR.get())
                .define('x', Blocks.GLASS)
                .define('y', ModItems.HYDRO_ROCK.get())
                .define('z', ItemTags.WOODEN_SLABS)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("zzz")
                .unlockedBy(getHasName(ModItems.HYDRO_ROCK.get()), has(ModItems.HYDRO_ROCK.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.GOLD_BARS.get(), 16)
                .define('x', Tags.Items.INGOTS_GOLD)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(output);
        oneToOneShapeless(output, RecipeCategory.MISC, Items.RED_DYE, ModItems.ROSE.get(), 1);
        oneToOneShapeless(output, RecipeCategory.MISC, Items.PINK_DYE, ModItems.PEONY.get(), 1);
        oneToOneShapeless(output, RecipeCategory.MISC, Items.MAGENTA_DYE, ModItems.LILAC.get(), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRELLIS.get(), 4)
                .define('x', Items.BAMBOO)
                .pattern("x x")
                .pattern("x x")
                .pattern("x x")
                .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO))
                .save(output);
        ModBookshelfBlock.BOOKSHELVES.forEach(bookshelf -> bookshelfShaped(output, bookshelf));
        ModLadderBlock.LADDERS.forEach(ladder -> ladderShaped(output, ladder));
        ModStairBlock.STAIRS.forEach(stair -> stair(output, stair));
        ModSlabBlock.SLABS.forEach(slab -> slab(output, slab));
        ModWallBlock.WALLS.forEach(wall -> wall(output, wall));
        ModFenceBlock.FENCES.forEach(fence -> fence(output, fence));
        ModFenceGateBlock.FENCE_GATES.forEach(fenceGate -> fenceGate(output, fenceGate));
        variants(output, ModItems.COBBLESTONE_BRICK_STAIRS.get(), ModItems.COBBLESTONE_BRICK_SLAB.get(), ModItems.COBBLESTONE_BRICK_WALL.get(), Blocks.COBBLESTONE);
        variants(output, ModItems.MOSSY_COBBLESTONE_BRICK_STAIRS.get(), ModItems.MOSSY_COBBLESTONE_BRICK_SLAB.get(), ModItems.MOSSY_COBBLESTONE_BRICK_WALL.get(), Blocks.MOSSY_COBBLESTONE);
        variants(output, ModItems.OBSIDIAN_BRICK_STAIRS.get(), ModItems.OBSIDIAN_BRICK_SLAB.get(), ModItems.OBSIDIAN_BRICK_WALL.get(), Blocks.OBSIDIAN);
        variants(output, ModItems.SNOW_BRICK_STAIRS.get(), ModItems.SNOW_BRICK_SLAB.get(), ModItems.SNOW_BRICK_WALL.get(), Blocks.SNOW_BLOCK);
        variants(output, ModItems.TERRACOTTA_BRICK_STAIRS.get(), ModItems.TERRACOTTA_BRICK_SLAB.get(), ModItems.TERRACOTTA_BRICK_WALL.get(), Blocks.TERRACOTTA);
        variants(output, ModItems.WHITE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.WHITE_TERRACOTTA_BRICK_SLAB.get(), ModItems.WHITE_TERRACOTTA_BRICK_WALL.get(), Blocks.WHITE_TERRACOTTA);
        variants(output, ModItems.ORANGE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.ORANGE_TERRACOTTA_BRICK_SLAB.get(), ModItems.ORANGE_TERRACOTTA_BRICK_WALL.get(), Blocks.ORANGE_TERRACOTTA);
        variants(output, ModItems.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(), ModItems.MAGENTA_TERRACOTTA_BRICK_SLAB.get(), ModItems.MAGENTA_TERRACOTTA_BRICK_WALL.get(), Blocks.MAGENTA_TERRACOTTA);
        variants(output, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        variants(output, ModItems.YELLOW_TERRACOTTA_BRICK_STAIRS.get(), ModItems.YELLOW_TERRACOTTA_BRICK_SLAB.get(), ModItems.YELLOW_TERRACOTTA_BRICK_WALL.get(), Blocks.YELLOW_TERRACOTTA);
        variants(output, ModItems.LIME_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIME_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIME_TERRACOTTA_BRICK_WALL.get(), Blocks.LIME_TERRACOTTA);
        variants(output, ModItems.PINK_TERRACOTTA_BRICK_STAIRS.get(), ModItems.PINK_TERRACOTTA_BRICK_SLAB.get(), ModItems.PINK_TERRACOTTA_BRICK_WALL.get(), Blocks.PINK_TERRACOTTA);
        variants(output, ModItems.GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModItems.GRAY_TERRACOTTA_BRICK_SLAB.get(), ModItems.GRAY_TERRACOTTA_BRICK_WALL.get(), Blocks.GRAY_TERRACOTTA);
        variants(output, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        variants(output, ModItems.CYAN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.CYAN_TERRACOTTA_BRICK_SLAB.get(), ModItems.CYAN_TERRACOTTA_BRICK_WALL.get(), Blocks.CYAN_TERRACOTTA);
        variants(output, ModItems.PURPLE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.PURPLE_TERRACOTTA_BRICK_SLAB.get(), ModItems.PURPLE_TERRACOTTA_BRICK_WALL.get(), Blocks.PURPLE_TERRACOTTA);
        variants(output, ModItems.BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BLUE_TERRACOTTA_BRICK_SLAB.get(), ModItems.BLUE_TERRACOTTA_BRICK_WALL.get(), Blocks.BLUE_TERRACOTTA);
        variants(output, ModItems.BROWN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BROWN_TERRACOTTA_BRICK_SLAB.get(), ModItems.BROWN_TERRACOTTA_BRICK_WALL.get(), Blocks.BROWN_TERRACOTTA);
        variants(output, ModItems.GREEN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.GREEN_TERRACOTTA_BRICK_SLAB.get(), ModItems.GREEN_TERRACOTTA_BRICK_WALL.get(), Blocks.GREEN_TERRACOTTA);
        variants(output, ModItems.RED_TERRACOTTA_BRICK_STAIRS.get(), ModItems.RED_TERRACOTTA_BRICK_SLAB.get(), ModItems.RED_TERRACOTTA_BRICK_WALL.get(), Blocks.RED_TERRACOTTA);
        variants(output, ModItems.BLACK_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BLACK_TERRACOTTA_BRICK_SLAB.get(), ModItems.BLACK_TERRACOTTA_BRICK_WALL.get(), Blocks.BLACK_TERRACOTTA);
        variants(output, ModItems.POLISHED_PERIDOTITE_STAIRS.get(), ModItems.POLISHED_PERIDOTITE_SLAB.get(), ModItems.POLISHED_PERIDOTITE_WALL.get(), ModItems.PERIDOTITE.get());
        variants(output, ModItems.POLISHED_PRISMARINE_STAIRS.get(), ModItems.POLISHED_PRISMARINE_SLAB.get(), ModItems.POLISHED_PRISMARINE_WALL.get(), List.of(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS));
        variants(output, ModItems.POLISHED_DARK_PRISMARINE_STAIRS.get(), ModItems.POLISHED_DARK_PRISMARINE_SLAB.get(), ModItems.POLISHED_DARK_PRISMARINE_WALL.get(), Blocks.DARK_PRISMARINE);
        variants(output, ModItems.POLISHED_END_STONE_STAIRS.get(), ModItems.POLISHED_END_STONE_SLAB.get(), ModItems.POLISHED_END_STONE_WALL.get(), List.of(Blocks.END_STONE, Blocks.END_STONE_BRICKS));
        variants(output, ModItems.POLISHED_NETHERRACK_STAIRS.get(), ModItems.POLISHED_NETHERRACK_SLAB.get(), ModItems.POLISHED_NETHERRACK_WALL.get(), Blocks.NETHERRACK);
        variants(output, ModItems.QUARTZ_BRICK_STAIRS.get(), ModItems.QUARTZ_BRICK_SLAB.get(), ModItems.QUARTZ_BRICK_WALL.get(), Blocks.QUARTZ_BLOCK);
        variants(output, ModItems.CUT_SANDSTONE_STAIRS.get(), ModItems.CUT_SANDSTONE_WALL.get(), Blocks.SANDSTONE);
        variants(output, ModItems.CUT_RED_SANDSTONE_STAIRS.get(), ModItems.CUT_RED_SANDSTONE_WALL.get(), Blocks.RED_SANDSTONE);
        variants(output, RecipeCategory.DECORATIONS, ModItems.POLISHED_GRANITE_WALL.get(), Blocks.GRANITE);
        variants(output, RecipeCategory.DECORATIONS, ModItems.POLISHED_DIORITE_WALL.get(), Blocks.DIORITE);
        variants(output, RecipeCategory.DECORATIONS, ModItems.POLISHED_ANDESITE_WALL.get(), Blocks.ANDESITE);

        // Items
        smeltingAndBlasting(output, RecipeCategory.MISC, ModItems.MAGMA_BRICK.get(), Blocks.MAGMA_BLOCK, 0.1F);
        oneToOneShapeless(output, RecipeCategory.MISC, ModItems.WITHER_BONE_MEAL.get(), ModItems.WITHER_BONE.get(), 3);
        oneToOneShapeless(output, RecipeCategory.MISC, Items.BLACK_DYE, ModItems.WITHER_BONE_MEAL.get(), 1);
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
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.PRISMARINE_ARROW.get())
                .requires(Items.ARROW)
                .requires(Items.PRISMARINE_SHARD)
                .group(name(ModItems.PRISMARINE_ARROW.get()))
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD))
                .unlockedBy(getHasName(Items.FEATHER), has(Items.FEATHER))
                .save(output, getConversionRecipeResourceLocation(ModItems.PRISMARINE_ARROW.get(), Items.ARROW));
        oneToOneShapeless(output, RecipeCategory.MISC, Items.LEATHER, ModItems.POLAR_BEAR_FUR.get(), 4);
        surroundedShaped(output, RecipeCategory.MISC, Items.BOOK, Items.PAPER, ModItems.POLAR_BEAR_FUR.get(), 4);
        surroundedShaped(output, RecipeCategory.DECORATIONS, Items.ITEM_FRAME, Tags.Items.RODS_WOODEN, ModItems.POLAR_BEAR_FUR.get(), 4);
        oneToOneShapeless(output, RecipeCategory.MISC, ModItems.TOMATO_SEEDS.get(), ModItems.TOMATO.get(), 1);
        oneToOneShapeless(output, RecipeCategory.MISC, ModItems.CHILI_SEEDS.get(), ModItems.CHILI.get(), 1);
        cooking(output, ModItems.FRIED_EGG.get(), Items.EGG, 0.3F);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MELON_POPSICLE.get(), 4)
                .requires(Items.MELON_SLICE)
                .requires(Blocks.ICE)
                .requires(Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON))
                .unlockedBy(getHasName(Blocks.ICE), has(Blocks.ICE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE.get(), 2)
                .requires(Tags.Items.BUCKETS_MILK)
                .requires(Items.COCOA_BEANS)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(output);
        cakeShaped(output, ModItems.CHOCOLATE_CAKE.get(), ModItems.CHOCOLATE.get());
        cakeShaped(output, ModItems.BERRY_CAKE.get(), Items.SWEET_BERRIES);
        cakeShaped(output, ModItems.CARROT_CAKE.get(), Items.CARROT);
        pieShapeless(output, ModItems.APPLE_PIE.get(), Items.APPLE);
        pieShapeless(output, ModItems.BERRY_PIE.get(), Items.SWEET_BERRIES);
        pieShapeless(output, ModItems.MONSTER_PIE.get(), Items.ROTTEN_FLESH);
        cooking(output, ModItems.POLAR_BEAR_STEAK.get(), ModItems.RAW_POLAR_BEAR_MEAT.get(), 0.35F);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.POTATO_SOUP.get())
                .requires(Items.BOWL)
                .requires(ModTags.Items.POTATO_SOUP_INGREDIENTS)
                .requires(ModTags.Items.POTATO_SOUP_INGREDIENTS)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                .unlockedBy(getHasName(Items.POISONOUS_POTATO), has(Items.POISONOUS_POTATO))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MEAT_SOUP.get())
                .requires(Items.BOWL)
                .requires(Tags.Items.CROPS_POTATO)
                .requires(Tags.Items.FOODS_COOKED_MEATS)
                .requires(Tags.Items.FOODS_COOKED_MEATS)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FISH_SOUP.get())
                .requires(Items.BOWL)
                .requires(Items.SEA_PICKLE)
                .requires(Tags.Items.FOODS_COOKED_FISHES)
                .requires(Tags.Items.FOODS_COOKED_FISHES)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(Items.SEA_PICKLE), has(Items.SEA_PICKLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RICE_BOWL.get())
                .requires(Items.BOWL)
                .requires(CommonTags.Items.FOODS_RICES)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .unlockedBy(getHasName(ModItems.RICE_GRAINS.get()), has(ModItems.RICE_GRAINS.get()))
                .save(output);
        cooking(output, ModItems.COOKED_TUNA.get(), ModItems.TUNA.get(), 0.35F);
        cooking(output, ModItems.COOKED_PERCH.get(), ModItems.PERCH.get(), 0.35F);
        cooking(output, ModItems.COOKED_PIKE.get(), ModItems.PIKE.get(), 0.35F);
        cooking(output, ModItems.COOKED_EEL.get(), ModItems.EEL.get(), 0.35F);

        // Altered recipes from vanilla
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.BOOKSHELF)
                .define('x', Blocks.OAK_PLANKS)
                .define('y', Items.BOOK)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("xxx")
                .unlockedBy(getHasName(Blocks.BOOKSHELF), has(Blocks.BOOKSHELF))
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.NETHER_BRICK_FENCE, 3)
                .define('x', Items.NETHER_BRICK)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("xyx")
                .pattern("xyx")
                .unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(output);

        // Paintings
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.EASEL.get())
                .define('x', ItemTags.WOODEN_SLABS)
                .define('y', CommonTags.Items.CANVASES)
                .define('z', Items.BRUSH)
                .pattern("xyx")
                .pattern(" z ")
                .pattern(" x ")
                .unlockedBy(getHasName(ModItems.CANVAS.get()), has(ModItems.CANVAS.get()))
                .unlockedBy(getHasName(Items.BRUSH), has(Items.BRUSH))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CANVAS.get(), 2)
                .requires(ItemTags.WOOL)
                .requires(Tags.Items.TOOLS_SHEARS)
                .unlockedBy(getHasName(Blocks.WHITE_WOOL), has(Blocks.WHITE_WOOL))
                .unlockedBy(getHasName(Items.SHEARS), has(Items.SHEARS))
                .save(output);
        painting(output, PaintingVariants.KEBAB, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_LIME));
        painting(output, PaintingVariants.AZTEC, List.of(Tags.Items.DYES_BLACK, Tags.Items.DYES_LIGHT_GRAY));
        painting(output, PaintingVariants.ALBAN, List.of(Tags.Items.DYES_YELLOW, Tags.Items.DYES_GREEN));
        painting(output, PaintingVariants.AZTEC2, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_GREEN));
        painting(output, PaintingVariants.BOMB, List.of(Tags.Items.DYES_YELLOW, Tags.Items.DYES_LIME));
        painting(output, PaintingVariants.PLANT, List.of(Tags.Items.DYES_GREEN, Tags.Items.DYES_WHITE));
        painting(output, PaintingVariants.WASTELAND, List.of(Tags.Items.DYES_YELLOW, Tags.Items.DYES_BROWN));
        painting(output, PaintingVariants.POOL, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_BROWN));
        painting(output, PaintingVariants.COURBET, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_BLACK, Tags.Items.DYES_LIGHT_GRAY));
        painting(output, PaintingVariants.SEA, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_LIME));
        painting(output, PaintingVariants.SUNSET, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_BLACK));
        painting(output, PaintingVariants.CREEBET, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_LIME));
        painting(output, PaintingVariants.WANDERER, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_PINK, Tags.Items.DYES_BLACK));
        painting(output, PaintingVariants.GRAHAM, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_BLACK, Tags.Items.DYES_YELLOW));
        painting(output, PaintingVariants.MATCH, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_BROWN, Tags.Items.DYES_ORANGE));
        painting(output, PaintingVariants.BUST, List.of(Tags.Items.DYES_LIME, Tags.Items.DYES_BLACK, Tags.Items.DYES_ORANGE));
        painting(output, PaintingVariants.STAGE, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_BLACK, Tags.Items.DYES_WHITE));
        painting(output, PaintingVariants.VOID, List.of(Tags.Items.DYES_RED, Tags.Items.DYES_BLACK, Tags.Items.DYES_MAGENTA));
        painting(output, PaintingVariants.SKULL_AND_ROSES, List.of(Tags.Items.DYES_CYAN, Tags.Items.DYES_GREEN, Tags.Items.DYES_RED));
        painting(output, PaintingVariants.WITHER, List.of(Tags.Items.DYES_BLACK, Tags.Items.DYES_GREEN, Tags.Items.DYES_RED));
        painting(output, PaintingVariants.FIGHTERS, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_GREEN, Tags.Items.DYES_WHITE, Tags.Items.DYES_BROWN, Tags.Items.DYES_BLACK, Tags.Items.DYES_ORANGE));
        painting(output, PaintingVariants.POINTER, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_WHITE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_BLACK, Tags.Items.DYES_PURPLE, Tags.Items.DYES_BROWN));
        painting(output, PaintingVariants.PIGSCENE, List.of(Tags.Items.DYES_PINK, Tags.Items.DYES_ORANGE, Tags.Items.DYES_BROWN, Tags.Items.DYES_BLACK, Tags.Items.DYES_BLACK, Tags.Items.DYES_GREEN));
        painting(output, PaintingVariants.BURNING_SKULL, List.of(Tags.Items.DYES_BLUE, Tags.Items.DYES_GREEN, Tags.Items.DYES_BLACK, Tags.Items.DYES_WHITE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_LIGHT_GRAY));
        painting(output, PaintingVariants.SKELETON, List.of(Tags.Items.DYES_ORANGE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_WHITE, Tags.Items.DYES_WHITE, Tags.Items.DYES_GRAY, Tags.Items.DYES_LIGHT_GRAY));
        painting(output, PaintingVariants.DONKEY_KONG, List.of(Tags.Items.DYES_BLACK, Tags.Items.DYES_BLACK, Tags.Items.DYES_PINK, Tags.Items.DYES_RED, Tags.Items.DYES_WHITE, Tags.Items.DYES_BROWN));

        painting(output, PaintingVariants.EARTH, List.of(Tags.Items.DYES_BROWN, Tags.Items.DYES_BROWN, Tags.Items.DYES_ORANGE));
        painting(output, PaintingVariants.WIND, List.of(Tags.Items.DYES_WHITE, Tags.Items.DYES_LIGHT_GRAY, Tags.Items.DYES_YELLOW));
        painting(output, PaintingVariants.FIRE, List.of(Tags.Items.DYES_ORANGE, Tags.Items.DYES_ORANGE, Tags.Items.DYES_YELLOW));
        painting(output, PaintingVariants.WATER, List.of(Tags.Items.DYES_LIGHT_BLUE, Tags.Items.DYES_BLUE, Tags.Items.DYES_WHITE));
    }

    // Templates
    public void bricks(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 4);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient);
    }

    public void terracottaBricks(RecipeOutput output, ItemLike result, ItemLike ingredient, TagKey<Item> dye) {
        bricks(output, result, ingredient);
        dyeCenterShaped(output, RecipeCategory.BUILDING_BLOCKS, result, ModItems.TERRACOTTA_BRICKS.get(), dye, getAltName(result));
    }

    public void polishedBlock(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        polishedBlock(output, result, ingredient, List.of());
    }

    public void polishedBlock(RecipeOutput output, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        twoByTwoShaped(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 4);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient);
        variants.forEach(variant -> stonecutting(output, RecipeCategory.BUILDING_BLOCKS, result, variant));
    }

    public void chiseledBlock(RecipeOutput output, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        stackedShaped(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 1);
        variants.forEach(variant -> stonecutting(output, RecipeCategory.BUILDING_BLOCKS, result, variant));
    }

    public void pillarBlock(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        pillarBlock(output, result, ingredient, List.of());
    }

    public void pillarBlock(RecipeOutput output, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        stackedShaped(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient);
        variants.forEach(variant -> stonecutting(output, RecipeCategory.BUILDING_BLOCKS, result, variant));
    }

    public void storageBlock(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        threeByThreeShaped(output, RecipeCategory.BUILDING_BLOCKS, result, ingredient, 1);
        oneToOneShapeless(output, RecipeCategory.BUILDING_BLOCKS, ingredient, result, 9);
    }

    public void stainedSoulGlass(RecipeOutput output, ItemLike glass, ItemLike pane, TagKey<Item> dye) {
        dyeCenterShaped(output, RecipeCategory.BUILDING_BLOCKS, glass, ModItems.SOUL_GLASS.get(), dye, modLoc(glass));
        paneShaped(output, pane, glass);
    }

    public void smeltingAndBlasting(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        smelting(output, category, result, ingredient, xp);
        blasting(output, category, result, ingredient, xp);
    }

    public void cooking(RecipeOutput output, ItemLike result, ItemLike ingredient, float xp) {
        smelting(output, RecipeCategory.FOOD, result, ingredient, xp);
        smoking(output, RecipeCategory.FOOD, result, ingredient, xp);
        campFire(output, RecipeCategory.FOOD, result, ingredient, xp);
    }

    public void stair(RecipeOutput output, ModStairBlock stair) {
        stairsShaped(output, stair.asItem(), stair.getParent().asItem());
        if (name(stair).contains("wood") || name(stair).contains("hyphae")) {
            return;
        }
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, stair.asItem(), stair.getParent().asItem());
    }

    public void slab(RecipeOutput output, ModSlabBlock slab) {
        slabShaped(output, slab.asItem(), slab.getParent().asItem());
        if (name(slab).contains("wood") || name(slab).contains("hyphae")) {
            return;
        }
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, slab.asItem(), slab.getParent().asItem(), 2);
    }

    public void wall(RecipeOutput output, ModWallBlock wall) {
        wallShaped(output, wall.asItem(), wall.getParent().asItem());
        if (name(wall).contains("wood") || name(wall).contains("hyphae")) {
            return;
        }
        stonecutting(output, RecipeCategory.DECORATIONS, wall.asItem(), wall.getParent().asItem());
    }

    public void fence(RecipeOutput output, ModFenceBlock fence) {
        fenceShaped(output, fence.asItem(), fence.getParent().asItem());
    }

    public void fenceGate(RecipeOutput output, ModFenceGateBlock fenceGate) {
        fenceGateShaped(output, fenceGate.asItem(), fenceGate.getParent().asItem());
    }

    public void variants(RecipeOutput output, ItemLike stair, ItemLike slab, ItemLike wall, ItemLike block) {
        variants(output, stair, slab, wall, List.of(block));
    }

    public void variants(RecipeOutput output, ItemLike stair, ItemLike slab, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> {
            stonecutting(output, RecipeCategory.BUILDING_BLOCKS, stair, block);
            stonecutting(output, RecipeCategory.BUILDING_BLOCKS, slab, block, 2);
            stonecutting(output, RecipeCategory.DECORATIONS, wall, block);
        });
    }

    public void variants(RecipeOutput output, ItemLike stair, ItemLike wall, ItemLike block) {
        variants(output, stair, wall, List.of(block));
    }

    public void variants(RecipeOutput output, ItemLike stair, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> {
            stonecutting(output, RecipeCategory.BUILDING_BLOCKS, stair, block);
            stonecutting(output, RecipeCategory.DECORATIONS, wall, block);
        });
    }

    public void variants(RecipeOutput output, RecipeCategory category, ItemLike wall, ItemLike block) {
        variants(output, category, wall, List.of(block));
    }

    public void variants(RecipeOutput output, RecipeCategory category, ItemLike wall, List<ItemLike> blocks) {
        blocks.forEach(block -> stonecutting(output, category, wall, block));
    }

    //Shaped Recipe
    public void twoByTwoShaped(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(output, category, result, ingredient, 1);
    }

    public void twoByTwoShaped(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', ingredient)
                .pattern("xx")
                .pattern("xx")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void threeByThreeShaped(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void surroundedShaped(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike surround, ItemLike middle, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', surround)
                .define('y', middle)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .unlockedBy(getHasName(surround), has(surround))
                .unlockedBy(getHasName(middle), has(middle))
                .save(output, getConversionRecipeResourceLocation(result, middle));
    }

    public void surroundedShaped(RecipeOutput output, RecipeCategory category, ItemLike result, TagKey<Item> surround, ItemLike middle, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', surround)
                .define('y', middle)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .unlockedBy(getHasName(middle), has(middle))
                .save(output, getConversionRecipeResourceLocation(result, middle));
    }

    public void dyeCenterShaped(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, TagKey<Item> dye, ResourceLocation name) {
        ShapedRecipeBuilder.shaped(category, result, 8)
                .define('x', ingredient)
                .define('y', dye)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, name);
    }

    public void stackedShaped(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(category, result, amount)
                .define('x', ingredient)
                .pattern("x")
                .pattern("x")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, getConversionRecipeResourceLocation(result, ingredient));
    }

    public void bookshelfShaped(RecipeOutput output, ModBookshelfBlock bookshelf) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, bookshelf)
                .define('x', bookshelf.getParent())
                .define('y', Items.BOOK)
                .pattern("xxx")
                .pattern("yyy")
                .pattern("xxx")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .unlockedBy(getHasName(bookshelf.getParent()), has(bookshelf.getParent()))
                .save(output);
    }

    public void ladderShaped(RecipeOutput output, ModLadderBlock ladder) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ladder, 3)
                .define('x', ladder.getCraftingIngredient())
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("y y")
                .pattern("yxy")
                .pattern("y y")
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(ladder.getCraftingIngredient()), has(ladder.getCraftingIngredient()))
                .save(output);
    }

    public void paneShaped(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 16)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void stairsShaped(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .define('x', ingredient)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void slabShaped(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .define('x', ingredient)
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void wallShaped(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 6)
                .define('x', ingredient)
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void fenceShaped(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 3)
                .define('x', ingredient)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("xyx")
                .pattern("xyx")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void fenceGateShaped(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                .define('x', ingredient)
                .define('y', Tags.Items.RODS_WOODEN)
                .pattern("yxy")
                .pattern("yxy")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    public void cakeShaped(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .define('x', ingredient)
                .define('y', Tags.Items.BUCKETS_MILK)
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
                .save(output);
    }

    // Shapeless Recipe
    public void oneToOneShapeless(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        ShapelessRecipeBuilder.shapeless(category, result, amount)
                .requires(ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, getConversionRecipeResourceLocation(result, ingredient));
    }

    public void mossyCobblestoneBricksShapeless(RecipeOutput output, ItemLike ingredient) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MOSSY_COBBLESTONE_BRICKS.get())
                .requires(ModItems.COBBLESTONE_BRICKS.get())
                .requires(ingredient)
                .group(name(ModItems.MOSSY_COBBLESTONE_BRICKS.get()))
                .unlockedBy(getHasName(ModItems.COBBLESTONE_BRICKS.get()), has(ModItems.COBBLESTONE_BRICKS.get()))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, getConversionRecipeResourceLocation(ModItems.MOSSY_COBBLESTONE_BRICKS.get(), ingredient));
    }

    public void pieShapeless(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(ingredient)
                .requires(Tags.Items.EGGS)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    // Smelting
    public void smelting(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), category, result, xp, 200).
                unlockedBy(getHasName(ingredient), has(ingredient)).
                save(output, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_smelting"));
    }

    public void blasting(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), category, result, xp, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_blasting"));
    }

    public void smoking(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), category, result, xp, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_smoking"));
    }

    public void campFire(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, float xp) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), category, result, xp, 600)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_campfire"));
    }

    // Stonecutting
    public void stonecutting(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient) {
        stonecutting(output, category, result, ingredient, 1);
    }

    public void stonecutting(RecipeOutput output, RecipeCategory category, ItemLike result, ItemLike ingredient, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), category, result, amount)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, ModDataGenerator.extend(getConversionRecipeResourceLocation(result, ingredient), "_from_stonecutting"));
    }

    public void painting(RecipeOutput output, ResourceKey<PaintingVariant> variant, List<TagKey<Item>> dyes) {
        Holder<PaintingVariant> holder = BuiltInRegistries.PAINTING_VARIANT.getHolderOrThrow(variant);
        List<Ingredient> ingredientDyes = Lists.newArrayList();
        dyes.forEach(dye -> ingredientDyes.add(Ingredient.of(dye)));
        PaintingRecipeBuilder.painting(RecipeCategory.DECORATIONS, holder)
                .canvas(Ingredient.of(CommonTags.Items.CANVASES))
                .dyes(ingredientDyes)
                .unlockedBy(getHasName(ModItems.CANVAS.get()), has(ModItems.CANVAS.get()))
                .save(output, VanillaBoom.resLoc(variant.location().getPath() + "_from_painting"));
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
        return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item.asItem()));
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
