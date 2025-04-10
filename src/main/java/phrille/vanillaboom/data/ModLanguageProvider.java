/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.item.ModItems;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, VanillaBoom.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("language.name", "English");
        add("language.region", "United States");
        add("language.locale", "en_us");

        // Damage Sources
        add("death.attack.vanillaboom.chili", "%s couldn't handle the spice");

        // Containers
        add("vanillaboom.container.easel", "Easel");
        add("vanillaboom.recipe.category.painting", "Painting");
        add("stat.vanillaboom.interact_with_easel", "Interactions with Easel");

        // Bricks
        add(ModBlocks.COBBLESTONE_BRICKS.get(), "Cobblestone Bricks");
        add(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get(), "Mossy Cobblestone Bricks");
        add(ModBlocks.MAGMA_BRICKS.get(), "Magma Bricks");
        add(ModBlocks.OBSIDIAN_BRICKS.get(), "Obsidian Bricks");
        add(ModBlocks.SNOW_BRICKS.get(), "Snow Bricks");
        add(ModBlocks.TERRACOTTA_BRICKS.get(), "Terracotta Bricks");
        add(ModBlocks.WHITE_TERRACOTTA_BRICKS.get(), "White Terracotta Bricks");
        add(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get(), "Orange Terracotta Bricks");
        add(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get(), "Magenta Terracotta Bricks");
        add(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), "Light Blue Terracotta Bricks");
        add(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get(), "Yellow Terracotta Bricks");
        add(ModBlocks.LIME_TERRACOTTA_BRICKS.get(), "Lime Terracotta Bricks");
        add(ModBlocks.PINK_TERRACOTTA_BRICKS.get(), "Pink Terracotta Bricks");
        add(ModBlocks.GRAY_TERRACOTTA_BRICKS.get(), "Gray Terracotta Bricks");
        add(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), "Light Gray Terracotta Bricks");
        add(ModBlocks.CYAN_TERRACOTTA_BRICKS.get(), "Cyan Terracotta Bricks");
        add(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get(), "Purple Terracotta Bricks");
        add(ModBlocks.BLUE_TERRACOTTA_BRICKS.get(), "Blue Terracotta Bricks");
        add(ModBlocks.BROWN_TERRACOTTA_BRICKS.get(), "Brown Terracotta Bricks");
        add(ModBlocks.GREEN_TERRACOTTA_BRICKS.get(), "Green Terracotta Bricks");
        add(ModBlocks.RED_TERRACOTTA_BRICKS.get(), "Red Terracotta Bricks");
        add(ModBlocks.BLACK_TERRACOTTA_BRICKS.get(), "Black Terracotta Bricks");

        // Rocks
        add(ModBlocks.PERIDOTITE.get(), "Peridotite");
        add(ModBlocks.HYDRO_ROCK.get(), "Hydro Rock");
        add(ModBlocks.INFERNAL_ROCK.get(), "Infernal Rock");

        // Sand and Gravel
        add(ModBlocks.BONE_SAND.get(), "Bone Sand");
        add(ModBlocks.WITHER_BONE_SAND.get(), "Wither Bone Sand");

        // Polished
        add(ModBlocks.POLISHED_PERIDOTITE.get(), "Polished Peridotite");
        add(ModBlocks.POLISHED_PRISMARINE.get(), "Polished Prismarine");
        add(ModBlocks.POLISHED_DARK_PRISMARINE.get(), "Polished Dark Prismarine");
        add(ModBlocks.POLISHED_END_STONE.get(), "Polished End Stone");
        add(ModBlocks.POLISHED_NETHERRACK.get(), "Polished Netherrack");

        // Chiseled and Cracked
        add(ModBlocks.CRACKED_RED_NETHER_BRICKS.get(), "Cracked Red Nether Bricks");
        add(ModBlocks.CHISELED_RED_NETHER_BRICKS.get(), "Chiseled Red Nether Bricks");
        add(ModBlocks.CHISELED_PURPUR_BLOCK.get(), "Chiseled Purpur Block");
        add(ModBlocks.CHISELED_OBSIDIAN.get(), "Chiseled Obsidian");

        // Pillars
        add(ModBlocks.GRANITE_PILLAR.get(), "Granite Pillar");
        add(ModBlocks.DIORITE_PILLAR.get(), "Diorite Pillar");
        add(ModBlocks.ANDESITE_PILLAR.get(), "Andesite Pillar");
        add(ModBlocks.PERIDOTITE_PILLAR.get(), "Peridotite Pillar");
        add(ModBlocks.PRISMARINE_PILLAR.get(), "Prismarine Pillar");
        add(ModBlocks.DARK_PRISMARINE_PILLAR.get(), "Dark Prismarine Pillar");
        add(ModBlocks.END_STONE_PILLAR.get(), "End Stone Pillar");
        add(ModBlocks.NETHERRACK_PILLAR.get(), "Netherrack Pillar");
        add(ModBlocks.OBSIDIAN_PILLAR.get(), "Obsidian Pillar");

        // Wood Variants
        add(ModBlocks.SPRUCE_BOOKSHELF.get(), "Spruce Bookshelf");
        add(ModBlocks.BIRCH_BOOKSHELF.get(), "Birch Bookshelf");
        add(ModBlocks.JUNGLE_BOOKSHELF.get(), "Jungle Bookshelf");
        add(ModBlocks.ACACIA_BOOKSHELF.get(), "Acacia Bookshelf");
        add(ModBlocks.DARK_OAK_BOOKSHELF.get(), "Dark Oak Bookshelf");
        add(ModBlocks.MANGROVE_BOOKSHELF.get(), "Mangrove Bookshelf");
        add(ModBlocks.CHERRY_BOOKSHELF.get(), "Cherry Bookshelf");
        add(ModBlocks.CRIMSON_BOOKSHELF.get(), "Crimson Bookshelf");
        add(ModBlocks.WARPED_BOOKSHELF.get(), "Warped Bookshelf");
        add(ModBlocks.SPRUCE_LADDER.get(), "Spruce Ladder");
        add(ModBlocks.BIRCH_LADDER.get(), "Birch Ladder");
        add(ModBlocks.JUNGLE_LADDER.get(), "Jungle Ladder");
        add(ModBlocks.ACACIA_LADDER.get(), "Acacia Ladder");
        add(ModBlocks.DARK_OAK_LADDER.get(), "Dark Oak Ladder");
        add(ModBlocks.MANGROVE_LADDER.get(), "Mangrove Ladder");
        add(ModBlocks.CHERRY_LADDER.get(), "Cherry Ladder");
        add(ModBlocks.CRIMSON_LADDER.get(), "Crimson Ladder");
        add(ModBlocks.WARPED_LADDER.get(), "Warped Ladder");

        // Storage
        add(ModBlocks.CHARCOAL_BLOCK.get(), "Charcoal Block");
        add(ModBlocks.SUGAR_BLOCK.get(), "Sugar Block");
        add(ModBlocks.SUGAR_CANE_BLOCK.get(), "Sugar Cane Block");
        add(ModBlocks.GUNPOWDER_BLOCK.get(), "Gunpowder Block");
        add(ModBlocks.BLAZE_POWDER_BLOCK.get(), "Blaze Powder Block");
        add(ModBlocks.MAGMA_CREAM_BLOCK.get(), "Magma Cream Block");
        add(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get(), "Prismarine Crystal Block");
        add(ModBlocks.WITHER_BONE_BLOCK.get(), "Wither Bone Block");
        add(ModBlocks.WHITE_DYE_BLOCK.get(), "White Dye Block");
        add(ModBlocks.ORANGE_DYE_BLOCK.get(), "Orange Dye Block");
        add(ModBlocks.MAGENTA_DYE_BLOCK.get(), "Magenta Dye Block");
        add(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get(), "Light Blue Dye Block");
        add(ModBlocks.YELLOW_DYE_BLOCK.get(), "Yellow Dye Block");
        add(ModBlocks.LIME_DYE_BLOCK.get(), "Lime Dye Block");
        add(ModBlocks.PINK_DYE_BLOCK.get(), "Pink Dye Block");
        add(ModBlocks.GRAY_DYE_BLOCK.get(), "Gray Dye Block");
        add(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get(), "Light Gray Dye Block");
        add(ModBlocks.CYAN_DYE_BLOCK.get(), "Cyan Dye Block");
        add(ModBlocks.PURPLE_DYE_BLOCK.get(), "Purple Dye Block");
        add(ModBlocks.BLUE_DYE_BLOCK.get(), "Blue Dye Block");
        add(ModBlocks.BROWN_DYE_BLOCK.get(), "Brown Dye Block");
        add(ModBlocks.GREEN_DYE_BLOCK.get(), "Green Dye Block");
        add(ModBlocks.RED_DYE_BLOCK.get(), "Red Dye Block");
        add(ModBlocks.BLACK_DYE_BLOCK.get(), "Black Dye Block");

        // Glass
        add(ModBlocks.SOUL_GLASS.get(), "Soul Glass");
        add(ModBlocks.WHITE_STAINED_SOUL_GLASS.get(), "White Stained Soul Glass");
        add(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get(), "Orange Stained Soul Glass");
        add(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get(), "Magenta Stained Soul Glass");
        add(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get(), "Light Blue Stained Soul Glass");
        add(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get(), "Yellow Stained Soul Glass");
        add(ModBlocks.LIME_STAINED_SOUL_GLASS.get(), "Lime Stained Soul Glass");
        add(ModBlocks.PINK_STAINED_SOUL_GLASS.get(), "Pink Stained Soul Glass");
        add(ModBlocks.GRAY_STAINED_SOUL_GLASS.get(), "Gray Stained Soul Glass");
        add(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get(), "Light Gray Stained Soul Glass");
        add(ModBlocks.CYAN_STAINED_SOUL_GLASS.get(), "Cyan Stained Soul Glass");
        add(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get(), "Purple Stained Soul Glass");
        add(ModBlocks.BLUE_STAINED_SOUL_GLASS.get(), "Blue Stained Soul Glass");
        add(ModBlocks.BROWN_STAINED_SOUL_GLASS.get(), "Brown Stained Soul Glass");
        add(ModBlocks.GREEN_STAINED_SOUL_GLASS.get(), "Green Stained Soul Glass");
        add(ModBlocks.RED_STAINED_SOUL_GLASS.get(), "Red Stained Soul Glass");
        add(ModBlocks.BLACK_STAINED_SOUL_GLASS.get(), "Black Stained Soul Glass");
        add(ModBlocks.SOUL_GLASS_PANE.get(), "Soul Glass Pane");
        add(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get(), "White Stained Soul Glass Pane");
        add(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get(), "Orange Stained Soul Glass Pane");
        add(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get(), "Magenta Stained Soul Glass Pane");
        add(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get(), "Light Blue Stained Soul Glass Pane");
        add(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get(), "Yellow Stained Soul Glass Pane");
        add(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get(), "Lime Stained Soul Glass Pane");
        add(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get(), "Pink Stained Soul Glass Pane");
        add(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get(), "Gray Stained Soul Glass Pane");
        add(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get(), "Light Gray Stained Soul Glass Pane");
        add(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get(), "Cyan Stained Soul Glass Pane");
        add(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get(), "Purple Stained Soul Glass Pane");
        add(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get(), "Blue Stained Soul Glass Pane");
        add(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get(), "Brown Stained Soul Glass Pane");
        add(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get(), "Green Stained Soul Glass Pane");
        add(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get(), "Red Stained Soul Glass Pane");
        add(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get(), "Black Stained Soul Glass Pane");

        // Misc
        add(ModBlocks.EASEL.get(), "Easel");
        add(ModBlocks.RAIN_DETECTOR.get(), "Rain Detector");
        add(ModBlocks.GOLD_BARS.get(), "Gold Bars");
        add(ModBlocks.COPPER_BARS.get(), "Copper Bars");
        add(ModBlocks.EXPOSED_COPPER_BARS.get(), "Exposed Copper Bars");
        add(ModBlocks.WEATHERED_COPPER_BARS.get(), "Weathered Copper Bars");
        add(ModBlocks.OXIDIZED_COPPER_BARS.get(), "Oxidized Copper Bars");
        add(ModBlocks.WAXED_COPPER_BARS.get(), "Waxed Copper Bars");
        add(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), "Waxed Exposed Copper Bars");
        add(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), "Waxed Weathered Copper Bars");
        add(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), "Waxed Oxidized Copper Bars");
        add(ModBlocks.ROSE.get(), "Rose");
        add(ModBlocks.SHEARED_ROSE_BUSH.get(), "Sheared Rose Bush");
        add(ModBlocks.PEONY.get(), "Peony");
        add(ModBlocks.SHEARED_PEONY.get(), "Sheared Peony");
        add(ModBlocks.LILAC.get(), "Lilac");
        add(ModBlocks.SHEARED_LILAC.get(), "Sheared Lilac");
        add(ModBlocks.TRELLIS.get(), "Trellis");
        add(ModBlocks.WITHERED_VINE.get(), "Withered Vine");

        // VanillaBoom Stairs
        add(ModBlocks.COBBLESTONE_BRICK_STAIRS.get(), "Cobblestone Brick Stairs");
        add(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get(), "Mossy Cobblestone Brick Stairs");
        add(ModBlocks.MAGMA_BRICK_STAIRS.get(), "Magma Brick Stairs");
        add(ModBlocks.OBSIDIAN_BRICK_STAIRS.get(), "Obsidian Brick Stairs");
        add(ModBlocks.SNOW_BRICK_STAIRS.get(), "Snow Brick Stairs");
        add(ModBlocks.TERRACOTTA_BRICK_STAIRS.get(), "Terracotta Brick Stairs");
        add(ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get(), "White Terracotta Brick Stairs");
        add(ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get(), "Orange Terracotta Brick Stairs");
        add(ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(), "Magenta Terracotta Brick Stairs");
        add(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(), "Light Blue Terracotta Brick Stairs");
        add(ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get(), "Yellow Terracotta Brick Stairs");
        add(ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get(), "Lime Terracotta Brick Stairs");
        add(ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get(), "Pink Terracotta Brick Stairs");
        add(ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get(), "Gray Terracotta Brick Stairs");
        add(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(), "Light Gray Terracotta Brick Stairs");
        add(ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get(), "Cyan Terracotta Brick Stairs");
        add(ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get(), "Purple Terracotta Brick Stairs");
        add(ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get(), "Blue Terracotta Brick Stairs");
        add(ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get(), "Brown Terracotta Brick Stairs");
        add(ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get(), "Green Terracotta Brick Stairs");
        add(ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get(), "Red Terracotta Brick Stairs");
        add(ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get(), "Black Terracotta Brick Stairs");
        add(ModBlocks.PERIDOTITE_STAIRS.get(), "Peridotite Stairs");
        add(ModBlocks.POLISHED_PERIDOTITE_STAIRS.get(), "Polished Peridotite Stairs");
        add(ModBlocks.POLISHED_PRISMARINE_STAIRS.get(), "Polished Prismarine Stairs");
        add(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS.get(), "Polished Dark Prismarine Stairs");
        add(ModBlocks.POLISHED_END_STONE_STAIRS.get(), "Polished End Stone Stairs");
        add(ModBlocks.POLISHED_NETHERRACK_STAIRS.get(), "Polished Netherrack Stairs");
        add(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get(), "Cracked Red Nether Brick Stairs");

        // VanillaBoom Slabs
        add(ModBlocks.COBBLESTONE_BRICK_SLAB.get(), "Cobblestone Brick Slab");
        add(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get(), "Mossy Cobblestone Brick Slab");
        add(ModBlocks.MAGMA_BRICK_SLAB.get(), "Magma Brick Slab");
        add(ModBlocks.OBSIDIAN_BRICK_SLAB.get(), "Obsidian Brick Slab");
        add(ModBlocks.SNOW_BRICK_SLAB.get(), "Snow Brick Slab");
        add(ModBlocks.TERRACOTTA_BRICK_SLAB.get(), "Terracotta Brick Slab");
        add(ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get(), "White Terracotta Brick Slab");
        add(ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get(), "Orange Terracotta Brick Slab");
        add(ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get(), "Magenta Terracotta Brick Slab");
        add(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(), "Light Blue Terracotta Brick Slab");
        add(ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get(), "Yellow Terracotta Brick Slab");
        add(ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get(), "Lime Terracotta Brick Slab");
        add(ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get(), "Pink Terracotta Brick Slab");
        add(ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get(), "Gray Terracotta Brick Slab");
        add(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(), "Light Gray Terracotta Brick Slab");
        add(ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get(), "Cyan Terracotta Brick Slab");
        add(ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get(), "Purple Terracotta Brick Slab");
        add(ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get(), "Blue Terracotta Brick Slab");
        add(ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get(), "Brown Terracotta Brick Slab");
        add(ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get(), "Green Terracotta Brick Slab");
        add(ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get(), "Red Terracotta Brick Slab");
        add(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get(), "Black Terracotta Brick Slab");
        add(ModBlocks.PERIDOTITE_SLAB.get(), "Peridotite Slab");
        add(ModBlocks.POLISHED_PERIDOTITE_SLAB.get(), "Polished Peridotite Slab");
        add(ModBlocks.POLISHED_PRISMARINE_SLAB.get(), "Polished Prismarine Slab");
        add(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB.get(), "Polished Dark Prismarine Slab");
        add(ModBlocks.POLISHED_END_STONE_SLAB.get(), "Polished End Stone Slab");
        add(ModBlocks.POLISHED_NETHERRACK_SLAB.get(), "Polished Netherrack Slab");
        add(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get(), "Cracked Red Nether Brick Slab");

        // VanillaBoom Walls
        add(ModBlocks.COBBLESTONE_BRICK_WALL.get(), "Cobblestone Brick Wall");
        add(ModBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get(), "Mossy Cobblestone Brick Wall");
        add(ModBlocks.MAGMA_BRICK_WALL.get(), "Magma Brick Wall");
        add(ModBlocks.OBSIDIAN_BRICK_WALL.get(), "Obsidian Brick Wall");
        add(ModBlocks.SNOW_BRICK_WALL.get(), "Snow Brick Wall");
        add(ModBlocks.TERRACOTTA_BRICK_WALL.get(), "Terracotta Brick Wall");
        add(ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get(), "White Terracotta Brick Wall");
        add(ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get(), "Orange Terracotta Brick Wall");
        add(ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get(), "Magenta Terracotta Brick Wall");
        add(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(), "Light Blue Terracotta Brick Wall");
        add(ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get(), "Yellow Terracotta Brick Wall");
        add(ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get(), "Lime Terracotta Brick Wall");
        add(ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get(), "Pink Terracotta Brick Wall");
        add(ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get(), "Gray Terracotta Brick Wall");
        add(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(), "Light Gray Terracotta Brick Wall");
        add(ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get(), "Cyan Terracotta Brick Wall");
        add(ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get(), "Purple Terracotta Brick Wall");
        add(ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get(), "Blue Terracotta Brick Wall");
        add(ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get(), "Brown Terracotta Brick Wall");
        add(ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get(), "Green Terracotta Brick Wall");
        add(ModBlocks.RED_TERRACOTTA_BRICK_WALL.get(), "Red Terracotta Brick Wall");
        add(ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get(), "Black Terracotta Brick Wall");
        add(ModBlocks.PERIDOTITE_WALL.get(), "Peridotite Wall");
        add(ModBlocks.POLISHED_PERIDOTITE_WALL.get(), "Polished Peridotite Wall");
        add(ModBlocks.POLISHED_PRISMARINE_WALL.get(), "Polished Prismarine Wall");
        add(ModBlocks.POLISHED_DARK_PRISMARINE_WALL.get(), "Polished Dark Prismarine Wall");
        add(ModBlocks.POLISHED_END_STONE_WALL.get(), "Polished End Stone Wall");
        add(ModBlocks.POLISHED_NETHERRACK_WALL.get(), "Polished Netherrack Wall");
        add(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get(), "Cracked Red Nether Brick Wall");

        // Vanilla Stairs
        add(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get(), "Cracked Stone Brick Stairs");
        add(ModBlocks.IRON_BLOCK_STAIRS.get(), "Iron Block Stairs");
        add(ModBlocks.GOLD_BLOCK_STAIRS.get(), "Gold Block Stairs");
        add(ModBlocks.OBSIDIAN_STAIRS.get(), "Obsidian Stairs");
        add(ModBlocks.BEDROCK_STAIRS.get(), "Bedrock Stairs");
        add(ModBlocks.NETHERRACK_STAIRS.get(), "Netherrack Stairs");
        add(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get(), "Cracked Nether Brick Stairs");
        add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), "Cracked Polished Blackstone Brick Stairs");
        add(ModBlocks.END_STONE_STAIRS.get(), "End Stone Stairs");
        add(ModBlocks.QUARTZ_BRICK_STAIRS.get(), "Quartz Brick Stairs");
        add(ModBlocks.TERRACOTTA_STAIRS.get(), "Terracotta Stairs");
        add(ModBlocks.WHITE_TERRACOTTA_STAIRS.get(), "White Terracotta Stairs");
        add(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get(), "Orange Terracotta Stairs");
        add(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get(), "Magenta Terracotta Stairs");
        add(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), "Light Blue Terracotta Stairs");
        add(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get(), "Yellow Terracotta Stairs");
        add(ModBlocks.LIME_TERRACOTTA_STAIRS.get(), "Lime Terracotta Stairs");
        add(ModBlocks.PINK_TERRACOTTA_STAIRS.get(), "Pink Terracotta Stairs");
        add(ModBlocks.GRAY_TERRACOTTA_STAIRS.get(), "Gray Terracotta Stairs");
        add(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), "Light Gray Terracotta Stairs");
        add(ModBlocks.CYAN_TERRACOTTA_STAIRS.get(), "Cyan Terracotta Stairs");
        add(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get(), "Purple Terracotta Stairs");
        add(ModBlocks.BLUE_TERRACOTTA_STAIRS.get(), "Blue Terracotta Stairs");
        add(ModBlocks.BROWN_TERRACOTTA_STAIRS.get(), "Brown Terracotta Stairs");
        add(ModBlocks.GREEN_TERRACOTTA_STAIRS.get(), "Green Terracotta Stairs");
        add(ModBlocks.RED_TERRACOTTA_STAIRS.get(), "Red Terracotta Stairs");
        add(ModBlocks.BLACK_TERRACOTTA_STAIRS.get(), "Black Terracotta Stairs");
        add(ModBlocks.WHITE_CONCRETE_STAIRS.get(), "White Concrete Stairs");
        add(ModBlocks.ORANGE_CONCRETE_STAIRS.get(), "Orange Concrete Stairs");
        add(ModBlocks.MAGENTA_CONCRETE_STAIRS.get(), "Magenta Concrete Stairs");
        add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), "Light Blue Concrete Stairs");
        add(ModBlocks.YELLOW_CONCRETE_STAIRS.get(), "Yellow Concrete Stairs");
        add(ModBlocks.LIME_CONCRETE_STAIRS.get(), "Lime Concrete Stairs");
        add(ModBlocks.PINK_CONCRETE_STAIRS.get(), "Pink Concrete Stairs");
        add(ModBlocks.GRAY_CONCRETE_STAIRS.get(), "Gray Concrete Stairs");
        add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), "Light Gray Concrete Stairs");
        add(ModBlocks.CYAN_CONCRETE_STAIRS.get(), "Cyan Concrete Stairs");
        add(ModBlocks.PURPLE_CONCRETE_STAIRS.get(), "Purple Concrete Stairs");
        add(ModBlocks.BLUE_CONCRETE_STAIRS.get(), "Blue Concrete Stairs");
        add(ModBlocks.BROWN_CONCRETE_STAIRS.get(), "Brown Concrete Stairs");
        add(ModBlocks.GREEN_CONCRETE_STAIRS.get(), "Green Concrete Stairs");
        add(ModBlocks.RED_CONCRETE_STAIRS.get(), "Red Concrete Stairs");
        add(ModBlocks.BLACK_CONCRETE_STAIRS.get(), "Black Concrete Stairs");
        add(ModBlocks.OAK_WOOD_STAIRS.get(), "Oak Wood Stairs");
        add(ModBlocks.SPRUCE_WOOD_STAIRS.get(), "Spruce Wood Stairs");
        add(ModBlocks.BIRCH_WOOD_STAIRS.get(), "Birch Wood Stairs");
        add(ModBlocks.JUNGLE_WOOD_STAIRS.get(), "Jungle Wood Stairs");
        add(ModBlocks.ACACIA_WOOD_STAIRS.get(), "Acacia Wood Stairs");
        add(ModBlocks.DARK_OAK_WOOD_STAIRS.get(), "Dark Oak Wood Stairs");
        add(ModBlocks.MANGROVE_WOOD_STAIRS.get(), "Mangrove Wood Stairs");
        add(ModBlocks.CHERRY_WOOD_STAIRS.get(), "Cherry Wood Stairs");
        add(ModBlocks.CRIMSON_HYPHAE_STAIRS.get(), "Crimson Hyphae Stairs");
        add(ModBlocks.WARPED_HYPHAE_STAIRS.get(), "Warped Hyphae Stairs");
        add(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get(), "Stripped Oak Wood Stairs");
        add(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get(), "Stripped Spruce Wood Stairs");
        add(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get(), "Stripped Birch Wood Stairs");
        add(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get(), "Stripped Jungle Wood Stairs");
        add(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get(), "Stripped Acacia Wood Stairs");
        add(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get(), "Stripped Dark Oak Wood Stairs");
        add(ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS.get(), "Stripped Mangrove Wood Stairs");
        add(ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS.get(), "Stripped Cherry Wood Stairs");
        add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_STAIRS.get(), "Stripped Crimson Hyphae Stairs");
        add(ModBlocks.STRIPPED_WARPED_HYPHAE_STAIRS.get(), "Stripped Warped Hyphae Stairs");
        add(ModBlocks.CUT_SANDSTONE_STAIRS.get(), "Cut Sandstone Stairs");
        add(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get(), "Cut Red Sandstone Stairs");
        add(ModBlocks.SMOOTH_STONE_STAIRS.get(), "Smooth Stone Stairs");

        // Vanilla Slabs
        add(ModBlocks.CRACKED_STONE_BRICK_SLAB.get(), "Cracked Stone Brick Slab");
        add(ModBlocks.IRON_BLOCK_SLAB.get(), "Iron Block Slab");
        add(ModBlocks.GOLD_BLOCK_SLAB.get(), "Gold Block Slab");
        add(ModBlocks.OBSIDIAN_SLAB.get(), "Obsidian Slab");
        add(ModBlocks.BEDROCK_SLAB.get(), "Bedrock Slab");
        add(ModBlocks.NETHERRACK_SLAB.get(), "Netherrack Slab");
        add(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get(), "Cracked Nether Brick Slab");
        add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get(), "Cracked Polished Blackstone Brick Slab");
        add(ModBlocks.END_STONE_SLAB.get(), "End Stone Slab");
        add(ModBlocks.QUARTZ_BRICK_SLAB.get(), "Quartz Brick Slab");
        add(ModBlocks.TERRACOTTA_SLAB.get(), "Terracotta Slab");
        add(ModBlocks.WHITE_TERRACOTTA_SLAB.get(), "White Terracotta Slab");
        add(ModBlocks.ORANGE_TERRACOTTA_SLAB.get(), "Orange Terracotta Slab");
        add(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get(), "Magenta Terracotta Slab");
        add(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), "Light Blue Terracotta Slab");
        add(ModBlocks.YELLOW_TERRACOTTA_SLAB.get(), "Yellow Terracotta Slab");
        add(ModBlocks.LIME_TERRACOTTA_SLAB.get(), "Lime Terracotta Slab");
        add(ModBlocks.PINK_TERRACOTTA_SLAB.get(), "Pink Terracotta Slab");
        add(ModBlocks.GRAY_TERRACOTTA_SLAB.get(), "Gray Terracotta Slab");
        add(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), "Light Gray Terracotta Slab");
        add(ModBlocks.CYAN_TERRACOTTA_SLAB.get(), "Cyan Terracotta Slab");
        add(ModBlocks.PURPLE_TERRACOTTA_SLAB.get(), "Purple Terracotta Slab");
        add(ModBlocks.BLUE_TERRACOTTA_SLAB.get(), "Blue Terracotta Slab");
        add(ModBlocks.BROWN_TERRACOTTA_SLAB.get(), "Brown Terracotta Slab");
        add(ModBlocks.GREEN_TERRACOTTA_SLAB.get(), "Green Terracotta Slab");
        add(ModBlocks.RED_TERRACOTTA_SLAB.get(), "Red Terracotta Slab");
        add(ModBlocks.BLACK_TERRACOTTA_SLAB.get(), "Black Terracotta Slab");
        add(ModBlocks.WHITE_CONCRETE_SLAB.get(), "White Concrete Slab");
        add(ModBlocks.ORANGE_CONCRETE_SLAB.get(), "Orange Concrete Slab");
        add(ModBlocks.MAGENTA_CONCRETE_SLAB.get(), "Magenta Concrete Slab");
        add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), "Light Blue Concrete Slab");
        add(ModBlocks.YELLOW_CONCRETE_SLAB.get(), "Yellow Concrete Slab");
        add(ModBlocks.LIME_CONCRETE_SLAB.get(), "Lime Concrete Slab");
        add(ModBlocks.PINK_CONCRETE_SLAB.get(), "Pink Concrete Slab");
        add(ModBlocks.GRAY_CONCRETE_SLAB.get(), "Gray Concrete Slab");
        add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), "Light Gray Concrete Slab");
        add(ModBlocks.CYAN_CONCRETE_SLAB.get(), "Cyan Concrete Slab");
        add(ModBlocks.PURPLE_CONCRETE_SLAB.get(), "Purple Concrete Slab");
        add(ModBlocks.BLUE_CONCRETE_SLAB.get(), "Blue Concrete Slab");
        add(ModBlocks.BROWN_CONCRETE_SLAB.get(), "Brown Concrete Slab");
        add(ModBlocks.GREEN_CONCRETE_SLAB.get(), "Green Concrete Slab");
        add(ModBlocks.RED_CONCRETE_SLAB.get(), "Red Concrete Slab");
        add(ModBlocks.BLACK_CONCRETE_SLAB.get(), "Black Concrete Slab");
        add(ModBlocks.OAK_WOOD_SLAB.get(), "Oak Wood Slab");
        add(ModBlocks.SPRUCE_WOOD_SLAB.get(), "Spruce Wood Slab");
        add(ModBlocks.BIRCH_WOOD_SLAB.get(), "Birch Wood Slab");
        add(ModBlocks.JUNGLE_WOOD_SLAB.get(), "Jungle Wood Slab");
        add(ModBlocks.ACACIA_WOOD_SLAB.get(), "Acacia Wood Slab");
        add(ModBlocks.DARK_OAK_WOOD_SLAB.get(), "Dark Oak Wood Slab");
        add(ModBlocks.MANGROVE_WOOD_SLAB.get(), "Mangrove Wood Slab");
        add(ModBlocks.CHERRY_WOOD_SLAB.get(), "Cherry Wood Slab");
        add(ModBlocks.CRIMSON_HYPHAE_SLAB.get(), "Crimson Hyphae Slab");
        add(ModBlocks.WARPED_HYPHAE_SLAB.get(), "Warped Hyphae Slab");
        add(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get(), "Stripped Oak Wood Slab");
        add(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get(), "Stripped Spruce Wood Slab");
        add(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get(), "Stripped Birch Wood Slab");
        add(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get(), "Stripped Jungle Wood Slab");
        add(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get(), "Stripped Acacia Wood Slab");
        add(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get(), "Stripped Dark Oak Wood Slab");
        add(ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB.get(), "Stripped Mangrove Wood Slab");
        add(ModBlocks.STRIPPED_CHERRY_WOOD_SLAB.get(), "Stripped Cherry Wood Slab");
        add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_SLAB.get(), "Stripped Crimson Hyphae Slab");
        add(ModBlocks.STRIPPED_WARPED_HYPHAE_SLAB.get(), "Stripped Warped Hyphae Slab");

        // Vanilla Walls
        add(ModBlocks.CRACKED_STONE_BRICK_WALL.get(), "Cracked Stone Brick Wall");
        add(ModBlocks.IRON_BLOCK_WALL.get(), "Iron Block Wall");
        add(ModBlocks.GOLD_BLOCK_WALL.get(), "Gold Block Wall");
        add(ModBlocks.OBSIDIAN_WALL.get(), "Obsidian Wall");
        add(ModBlocks.BEDROCK_WALL.get(), "Bedrock Wall");
        add(ModBlocks.NETHERRACK_WALL.get(), "Netherrack Wall");
        add(ModBlocks.CRACKED_NETHER_BRICK_WALL.get(), "Cracked Nether Brick Wall");
        add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get(), "Cracked Polished Blackstone Brick Wall");
        add(ModBlocks.END_STONE_WALL.get(), "End Stone Wall");
        add(ModBlocks.QUARTZ_BRICK_WALL.get(), "Quartz Brick Wall");
        add(ModBlocks.TERRACOTTA_WALL.get(), "Terracotta Wall");
        add(ModBlocks.WHITE_TERRACOTTA_WALL.get(), "White Terracotta Wall");
        add(ModBlocks.ORANGE_TERRACOTTA_WALL.get(), "Orange Terracotta Wall");
        add(ModBlocks.MAGENTA_TERRACOTTA_WALL.get(), "Magenta Terracotta Wall");
        add(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(), "Light Blue Terracotta Wall");
        add(ModBlocks.YELLOW_TERRACOTTA_WALL.get(), "Yellow Terracotta Wall");
        add(ModBlocks.LIME_TERRACOTTA_WALL.get(), "Lime Terracotta Wall");
        add(ModBlocks.PINK_TERRACOTTA_WALL.get(), "Pink Terracotta Wall");
        add(ModBlocks.GRAY_TERRACOTTA_WALL.get(), "Gray Terracotta Wall");
        add(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(), "Light Gray Terracotta Wall");
        add(ModBlocks.CYAN_TERRACOTTA_WALL.get(), "Cyan Terracotta Wall");
        add(ModBlocks.PURPLE_TERRACOTTA_WALL.get(), "Purple Terracotta Wall");
        add(ModBlocks.BLUE_TERRACOTTA_WALL.get(), "Blue Terracotta Wall");
        add(ModBlocks.BROWN_TERRACOTTA_WALL.get(), "Brown Terracotta Wall");
        add(ModBlocks.GREEN_TERRACOTTA_WALL.get(), "Green Terracotta Wall");
        add(ModBlocks.RED_TERRACOTTA_WALL.get(), "Red Terracotta Wall");
        add(ModBlocks.BLACK_TERRACOTTA_WALL.get(), "Black Terracotta Wall");
        add(ModBlocks.WHITE_CONCRETE_WALL.get(), "White Concrete Wall");
        add(ModBlocks.ORANGE_CONCRETE_WALL.get(), "Orange Concrete Wall");
        add(ModBlocks.MAGENTA_CONCRETE_WALL.get(), "Magenta Concrete Wall");
        add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get(), "Light Blue Concrete Wall");
        add(ModBlocks.YELLOW_CONCRETE_WALL.get(), "Yellow Concrete Wall");
        add(ModBlocks.LIME_CONCRETE_WALL.get(), "Lime Concrete Wall");
        add(ModBlocks.PINK_CONCRETE_WALL.get(), "Pink Concrete Wall");
        add(ModBlocks.GRAY_CONCRETE_WALL.get(), "Gray Concrete Wall");
        add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get(), "Light Gray Concrete Wall");
        add(ModBlocks.CYAN_CONCRETE_WALL.get(), "Cyan Concrete Wall");
        add(ModBlocks.PURPLE_CONCRETE_WALL.get(), "Purple Concrete Wall");
        add(ModBlocks.BLUE_CONCRETE_WALL.get(), "Blue Concrete Wall");
        add(ModBlocks.BROWN_CONCRETE_WALL.get(), "Brown Concrete Wall");
        add(ModBlocks.GREEN_CONCRETE_WALL.get(), "Green Concrete Wall");
        add(ModBlocks.RED_CONCRETE_WALL.get(), "Red Concrete Wall");
        add(ModBlocks.BLACK_CONCRETE_WALL.get(), "Black Concrete Wall");
        add(ModBlocks.CUT_SANDSTONE_WALL.get(), "Cut Sandstone Wall");
        add(ModBlocks.CUT_RED_SANDSTONE_WALL.get(), "Cut Red Sandstone Wall");
        add(ModBlocks.SMOOTH_STONE_WALL.get(), "Smooth Stone Wall");
        add(ModBlocks.STONE_WALL.get(), "Stone Wall");
        add(ModBlocks.POLISHED_GRANITE_WALL.get(), "Polished Granite Wall");
        add(ModBlocks.POLISHED_DIORITE_WALL.get(), "Polished Diorite Wall");
        add(ModBlocks.POLISHED_ANDESITE_WALL.get(), "Polished Andesite Wall");
        add(ModBlocks.SMOOTH_SANDSTONE_WALL.get(), "Smooth Sandstone Wall");
        add(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get(), "Smooth Red Sandstone Wall");
        add(ModBlocks.PURPUR_BLOCK_WALL.get(), "Purpur Block Wall");
        add(ModBlocks.QUARTZ_BLOCK_WALL.get(), "Quartz Wall");
        add(ModBlocks.SMOOTH_QUARTZ_WALL.get(), "Smooth Quartz Wall");
        add(ModBlocks.PRISMARINE_BRICK_WALL.get(), "Prismarine Brick Wall");
        add(ModBlocks.DARK_PRISMARINE_WALL.get(), "Dark Prismarine Wall");

        // Vanilla Fences
        add(ModBlocks.OAK_WOOD_FENCE.get(), "Oak Wood Fence");
        add(ModBlocks.SPRUCE_WOOD_FENCE.get(), "Spruce Wood Fence");
        add(ModBlocks.BIRCH_WOOD_FENCE.get(), "Birch Wood Fence");
        add(ModBlocks.JUNGLE_WOOD_FENCE.get(), "Jungle Wood Fence");
        add(ModBlocks.ACACIA_WOOD_FENCE.get(), "Acacia Wood Fence");
        add(ModBlocks.DARK_OAK_WOOD_FENCE.get(), "Dark Oak Wood Fence");
        add(ModBlocks.MANGROVE_WOOD_FENCE.get(), "Mangrove Wood Fence");
        add(ModBlocks.CHERRY_WOOD_FENCE.get(), "Cherry Wood Fence");
        add(ModBlocks.CRIMSON_HYPHAE_FENCE.get(), "Crimson Hyphae Fence");
        add(ModBlocks.WARPED_HYPHAE_FENCE.get(), "Warped Hyphae Fence");
        add(ModBlocks.STRIPPED_OAK_WOOD_FENCE.get(), "Stripped Oak Wood Fence");
        add(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE.get(), "Stripped Spruce Wood Fence");
        add(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE.get(), "Stripped Birch Wood Fence");
        add(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE.get(), "Stripped Jungle Wood Fence");
        add(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE.get(), "Stripped Acacia Wood Fence");
        add(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE.get(), "Stripped Dark Oak Wood Fence");
        add(ModBlocks.STRIPPED_MANGROVE_WOOD_FENCE.get(), "Stripped Mangrove Wood Fence");
        add(ModBlocks.STRIPPED_CHERRY_WOOD_FENCE.get(), "Stripped Cherry Wood Fence");
        add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE.get(), "Stripped Crimson Hyphae Fence");
        add(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE.get(), "Stripped Warped Hyphae Fence");
        add(ModBlocks.RED_NETHER_BRICK_FENCE.get(), "Red Nether Brick Fence");
        add(ModBlocks.OAK_WOOD_FENCE_GATE.get(), "Oak Wood Fence Gate");
        add(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get(), "Spruce Wood Fence Gate");
        add(ModBlocks.BIRCH_WOOD_FENCE_GATE.get(), "Birch Wood Fence Gate");
        add(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get(), "Jungle Wood Fence Gate");
        add(ModBlocks.ACACIA_WOOD_FENCE_GATE.get(), "Acacia Wood Fence Gate");
        add(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get(), "Dark Oak Wood Fence Gate");
        add(ModBlocks.MANGROVE_WOOD_FENCE_GATE.get(), "Mangrove Wood Fence Gate");
        add(ModBlocks.CHERRY_WOOD_FENCE_GATE.get(), "Cherry Wood Fence Gate");
        add(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get(), "Crimson Hyphae Fence Gate");
        add(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get(), "Warped Hyphae Fence Gate");
        add(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE.get(), "Stripped Oak Wood Fence Gate");
        add(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE.get(), "Stripped Spruce Wood Fence Gate");
        add(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE.get(), "Stripped Birch Wood Fence Gate");
        add(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE.get(), "Stripped Jungle Wood Fence Gate");
        add(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE.get(), "Stripped Acacia Wood Fence Gate");
        add(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE.get(), "Stripped Dark Oak Wood Fence Gate");
        add(ModBlocks.STRIPPED_MANGROVE_WOOD_FENCE_GATE.get(), "Stripped Mangrove Wood Fence Gate");
        add(ModBlocks.STRIPPED_CHERRY_WOOD_FENCE_GATE.get(), "Stripped Cherry Wood Fence Gate");
        add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE.get(), "Stripped Crimson Hyphae Fence Gate");
        add(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE.get(), "Stripped Warped Hyphae Fence Gate");
        add(ModBlocks.NETHER_BRICK_FENCE_GATE.get(), "Nether Brick Fence Gate");
        add(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get(), "Red Nether Brick Fence Gate");

        // Items
        add(ModItems.MAGMA_BRICK.get(), "Magma Brick");
        add(ModItems.WITHER_BONE.get(), "Wither Bone");
        add(ModItems.WITHER_BONE_MEAL.get(), "Wither Bone Meal");
        add(ModItems.PRISMARINE_ARROW.get(), "Prismarine Arrow");
        add(ModItems.CANVAS.get(), "Canvas", "Blank");
        add(ModItems.POLAR_BEAR_FUR.get(), "Polar Bear Fur");
        add(ModItems.RAW_POLAR_BEAR_MEAT.get(), "Raw Polar Bear Meat");
        add(ModItems.POLAR_BEAR_STEAK.get(), "Polar Bear Steak");
        add(ModItems.FRIED_EGG.get(), "Fried Egg");
        add(ModItems.DROWNED_FLESH.get(), "Drowned Flesh");
        add(ModItems.MELON_POPSICLE.get(), "Melon Popsicle");
        add(ModItems.PINE_CONE.get(), "Pine Cone");
        add(ModItems.CHOCOLATE.get(), "Chocolate");
        add(ModItems.CHOCOLATE_CAKE.get(), "Chocolate Cake");
        add(ModItems.BERRY_CAKE.get(), "Berry Cake");
        add(ModItems.CARROT_CAKE.get(), "Carrot Cake");
        add(ModItems.APPLE_PIE.get(), "Apple Pie");
        add(ModItems.BERRY_PIE.get(), "Berry Pie");
        add(ModItems.MONSTER_PIE.get(), "Monster Pie");
        add(ModItems.TOMATO.get(), "Tomato");
        add(ModItems.TOMATO_SEEDS.get(), "Tomato Seeds");
        add(ModItems.CHILI.get(), "Chili");
        add(ModItems.CHILI_SEEDS.get(), "Chili Seeds");
        add(ModBlocks.RICE.get(), "Rice Grains");
        add(ModItems.POTATO_SOUP.get(), "Potato Soup");
        add(ModItems.FISH_SOUP.get(), "Fish Soup");
        add(ModItems.MEAT_SOUP.get(), "Meat Soup");
        add(ModItems.RICE_BOWL.get(), "Bowl of Rice");

        add(ModItems.TUNA.get(), "Raw Tuna");
        add(ModItems.COOKED_TUNA.get(), "Cooked Tuna");
        add(ModItems.TUNA_BUCKET.get(), "Bucket of Tuna");
        add(ModItems.TUNA_SPAWN_EGG.get(), "Tuna Spawn Egg");

        add(ModItems.PERCH.get(), "Raw Perch");
        add(ModItems.COOKED_PERCH.get(), "Cooked Perch");
        add(ModItems.PERCH_BUCKET.get(), "Bucket of Perch");
        add(ModItems.PERCH_SPAWN_EGG.get(), "Perch Spawn Egg");

        add(ModItems.PIKE.get(), "Raw Pike");
        add(ModItems.COOKED_PIKE.get(), "Cooked Pike");
        add(ModItems.PIKE_BUCKET.get(), "Bucket of Pike");
        add(ModItems.PIKE_SPAWN_EGG.get(), "Pike Spawn Egg");

        add(ModItems.EEL.get(), "Raw Eel");
        add(ModItems.COOKED_EEL.get(), "Cooked Eel");
        add(ModItems.EEL_BUCKET.get(), "Bucket of Eel");
        add(ModItems.EEL_SPAWN_EGG.get(), "Eel Spawn Egg");
    }

    public void add(Item item, String name, String desc) {
        add(item, name);
        add(item.getDescriptionId() + ".desc", desc);
    }
}
