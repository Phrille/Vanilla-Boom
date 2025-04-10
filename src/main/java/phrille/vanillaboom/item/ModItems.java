/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.entity.ModEntityTypes;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VanillaBoom.MOD_ID);

    // Misc
    public static final DeferredItem<Item> MAGMA_BRICK = ITEMS.register("magma_brick", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WITHER_BONE = ITEMS.register("wither_bone", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WITHER_BONE_MEAL = ITEMS.register("wither_bone_meal", WitherBoneMealItem::new);
    public static final DeferredItem<Item> PRISMARINE_ARROW = ITEMS.register("prismarine_arrow", PrismarineArrowItem::new);
    public static final DeferredItem<Item> POLAR_BEAR_FUR = ITEMS.register("polar_bear_fur", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHILI_SEEDS = ITEMS.register("chili_seeds", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RICE_GRAINS = ITEMS.register("rice_grains", () -> new BlockItem(ModBlocks.RICE.get(), new Item.Properties()));
    public static final DeferredItem<Item> CANVAS = ITEMS.register("canvas", () -> new Item(new Item.Properties()));

    // Food
    public static final DeferredItem<Item> PINE_CONE = ITEMS.register("pine_cone", () -> new Item(new Item.Properties().food(ModFoods.PINE_CONE)));
    public static final DeferredItem<Item> TOMATO = ITEMS.register("tomato", () -> new Item(new Item.Properties().food(ModFoods.TOMATO)));
    public static final DeferredItem<Item> CHILI = ITEMS.register("chili", ChiliItem::new);
    public static final DeferredItem<Item> FRIED_EGG = ITEMS.register("fried_egg", () -> new Item(new Item.Properties().food(ModFoods.FRIED_EGG)));
    public static final DeferredItem<Item> DROWNED_FLESH = ITEMS.register("drowned_flesh", () -> new Item(new Item.Properties().food(ModFoods.DROWNED_FLESH)));
    public static final DeferredItem<Item> MELON_POPSICLE = ITEMS.register("melon_popsicle", () -> new IceCreamItem(new Item.Properties().food(ModFoods.MELON_POPSICLE)));
    public static final DeferredItem<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().food(ModFoods.CHOCOLATE)));
    public static final DeferredItem<Item> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake", () -> new BlockItem(ModBlocks.CHOCOLATE_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BERRY_CAKE = ITEMS.register("berry_cake", () -> new BlockItem(ModBlocks.BERRY_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CARROT_CAKE = ITEMS.register("carrot_cake", () -> new BlockItem(ModBlocks.CARROT_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().food(ModFoods.APPLE_PIE)));
    public static final DeferredItem<Item> BERRY_PIE = ITEMS.register("berry_pie", () -> new Item(new Item.Properties().food(ModFoods.BERRY_PIE)));
    public static final DeferredItem<Item> MONSTER_PIE = ITEMS.register("monster_pie", () -> new Item(new Item.Properties().food(ModFoods.MONSTER_PIE)));
    public static final DeferredItem<Item> RAW_POLAR_BEAR_MEAT = ITEMS.register("raw_polar_bear_meat", () -> new Item(new Item.Properties().food(ModFoods.RAW_POLAR_BEAR_MEAT)));
    public static final DeferredItem<Item> POLAR_BEAR_STEAK = ITEMS.register("polar_bear_steak", () -> new Item(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK)));
    public static final DeferredItem<Item> POTATO_SOUP = ITEMS.register("potato_soup", () -> new Item(new Item.Properties().food(ModFoods.POTATO_SOUP).stacksTo(1).craftRemainder(Items.BOWL)));
    public static final DeferredItem<Item> MEAT_SOUP = ITEMS.register("meat_soup", () -> new Item(new Item.Properties().food(ModFoods.MEAT_SOUP).stacksTo(1).craftRemainder(Items.BOWL)));
    public static final DeferredItem<Item> FISH_SOUP = ITEMS.register("fish_soup", () -> new Item(new Item.Properties().food(ModFoods.FISH_SOUP).stacksTo(1).craftRemainder(Items.BOWL)));
    public static final DeferredItem<Item> RICE_BOWL = ITEMS.register("rice_bowl", () -> new Item(new Item.Properties().food(ModFoods.RICE_BOWL).stacksTo(1).craftRemainder(Items.BOWL)));

    // Fish
    public static final DeferredItem<Item> TUNA = ITEMS.register("tuna", () -> new Item(new Item.Properties().food(ModFoods.TUNA)));
    public static final DeferredItem<Item> COOKED_TUNA = ITEMS.register("cooked_tuna", () -> new Item(new Item.Properties().food(ModFoods.COOKED_TUNA)));
    public static final DeferredItem<Item> PERCH = ITEMS.register("perch", () -> new Item(new Item.Properties().food(ModFoods.PERCH)));
    public static final DeferredItem<Item> COOKED_PERCH = ITEMS.register("cooked_perch", () -> new Item(new Item.Properties().food(ModFoods.COOKED_PERCH)));
    public static final DeferredItem<Item> PIKE = ITEMS.register("pike", () -> new Item(new Item.Properties().food(ModFoods.PIKE)));
    public static final DeferredItem<Item> COOKED_PIKE = ITEMS.register("cooked_pike", () -> new Item(new Item.Properties().food(ModFoods.COOKED_PIKE)));
    public static final DeferredItem<Item> EEL = ITEMS.register("eel", () -> new Item(new Item.Properties().food(ModFoods.EEL)));
    public static final DeferredItem<Item> COOKED_EEL = ITEMS.register("cooked_eel", () -> new Item(new Item.Properties().food(ModFoods.COOKED_EEL)));

    // Fish Buckets
    public static final DeferredItem<Item> TUNA_BUCKET = ITEMS.register("tuna_bucket", () -> new MobBucketItem(ModEntityTypes.TUNA.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PERCH_BUCKET = ITEMS.register("perch_bucket", () -> new MobBucketItem(ModEntityTypes.PERCH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PIKE_BUCKET = ITEMS.register("pike_bucket", () -> new MobBucketItem(ModEntityTypes.PIKE.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> EEL_BUCKET = ITEMS.register("eel_bucket", () -> new MobBucketItem(ModEntityTypes.EEL.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));

    // Spawn Eggs
    public static final DeferredItem<Item> TUNA_SPAWN_EGG = ITEMS.register("tuna_spawn_egg", () -> new DeferredSpawnEggItem(ModEntityTypes.TUNA, 0x33495E, 0xD7C376, new Item.Properties()));
    public static final DeferredItem<Item> PERCH_SPAWN_EGG = ITEMS.register("perch_spawn_egg", () -> new DeferredSpawnEggItem(ModEntityTypes.PERCH, 0x464614, 0xFD5100, new Item.Properties()));
    public static final DeferredItem<Item> PIKE_SPAWN_EGG = ITEMS.register("pike_spawn_egg", () -> new DeferredSpawnEggItem(ModEntityTypes.PIKE, 0x4C462A, 0xA0A169, new Item.Properties()));
    public static final DeferredItem<Item> EEL_SPAWN_EGG = ITEMS.register("eel_spawn_egg", () -> new DeferredSpawnEggItem(ModEntityTypes.EEL, 0x5F4F37, 0x312517, new Item.Properties()));

    public static class ModFoods {
        public static final FoodProperties RAW_POLAR_BEAR_MEAT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
        public static final FoodProperties POLAR_BEAR_STEAK = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build();
        public static final FoodProperties FRIED_EGG = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build();
        public static final FoodProperties DROWNED_FLESH = new FoodProperties.Builder().nutrition(4).saturationModifier(0.1F)
                .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F)
                .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 0.5F).build();
        public static final FoodProperties MELON_POPSICLE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).fast().build();
        public static final FoodProperties PINE_CONE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).fast().build();
        public static final FoodProperties CHOCOLATE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.3F)
                .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 0.5F).build();
        public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(4).saturationModifier(0.2F).build();
        public static final FoodProperties CHILI = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).alwaysEdible()
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).build();
        public static final FoodProperties APPLE_PIE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build();
        public static final FoodProperties BERRY_PIE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build();
        public static final FoodProperties MONSTER_PIE = new FoodProperties.Builder().nutrition(10).saturationModifier(0.2F)
                .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 1.0F).build();
        public static final FoodProperties POTATO_SOUP = new FoodProperties.Builder().nutrition(8).saturationModifier(0.5F).build();
        public static final FoodProperties MEAT_SOUP = new FoodProperties.Builder().nutrition(12).saturationModifier(0.7F).build();
        public static final FoodProperties FISH_SOUP = new FoodProperties.Builder().nutrition(10).saturationModifier(0.6F).build();
        public static final FoodProperties RICE_BOWL = new FoodProperties.Builder().nutrition(5).saturationModifier(0.2F).build();

        public static final FoodProperties TUNA = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).build();
        public static final FoodProperties COOKED_TUNA = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).build();
        public static final FoodProperties PERCH = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
        public static final FoodProperties COOKED_PERCH = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build();
        public static final FoodProperties PIKE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
        public static final FoodProperties COOKED_PIKE = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).build();
        public static final FoodProperties EEL = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
        public static final FoodProperties COOKED_EEL = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build();
    }

    // Bricks
    public static final DeferredItem<Item> COBBLESTONE_BRICKS = ITEMS.register("cobblestone_bricks", () -> new BlockItem(ModBlocks.COBBLESTONE_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MOSSY_COBBLESTONE_BRICKS = ITEMS.register("mossy_cobblestone_bricks", () -> new BlockItem(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGMA_BRICKS = ITEMS.register("magma_bricks", () -> new BlockItem(ModBlocks.MAGMA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_BRICKS = ITEMS.register("obsidian_bricks", () -> new BlockItem(ModBlocks.OBSIDIAN_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> SNOW_BRICKS = ITEMS.register("snow_bricks", () -> new BlockItem(ModBlocks.SNOW_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> TERRACOTTA_BRICKS = ITEMS.register("terracotta_bricks", () -> new BlockItem(ModBlocks.TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_TERRACOTTA_BRICKS = ITEMS.register("white_terracotta_bricks", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_TERRACOTTA_BRICKS = ITEMS.register("orange_terracotta_bricks", () -> new BlockItem(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_TERRACOTTA_BRICKS = ITEMS.register("magenta_terracotta_bricks", () -> new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_TERRACOTTA_BRICKS = ITEMS.register("light_blue_terracotta_bricks", () -> new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_TERRACOTTA_BRICKS = ITEMS.register("yellow_terracotta_bricks", () -> new BlockItem(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_TERRACOTTA_BRICKS = ITEMS.register("lime_terracotta_bricks", () -> new BlockItem(ModBlocks.LIME_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_TERRACOTTA_BRICKS = ITEMS.register("pink_terracotta_bricks", () -> new BlockItem(ModBlocks.PINK_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_TERRACOTTA_BRICKS = ITEMS.register("gray_terracotta_bricks", () -> new BlockItem(ModBlocks.GRAY_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_TERRACOTTA_BRICKS = ITEMS.register("light_gray_terracotta_bricks", () -> new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_TERRACOTTA_BRICKS = ITEMS.register("cyan_terracotta_bricks", () -> new BlockItem(ModBlocks.CYAN_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_TERRACOTTA_BRICKS = ITEMS.register("purple_terracotta_bricks", () -> new BlockItem(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_TERRACOTTA_BRICKS = ITEMS.register("blue_terracotta_bricks", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_TERRACOTTA_BRICKS = ITEMS.register("brown_terracotta_bricks", () -> new BlockItem(ModBlocks.BROWN_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_TERRACOTTA_BRICKS = ITEMS.register("green_terracotta_bricks", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_TERRACOTTA_BRICKS = ITEMS.register("red_terracotta_bricks", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_TERRACOTTA_BRICKS = ITEMS.register("black_terracotta_bricks", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_BRICKS.get(), new Item.Properties()));

    // Rocks
    public static final DeferredItem<Item> PERIDOTITE = ITEMS.register("peridotite", () -> new BlockItem(ModBlocks.PERIDOTITE.get(), new Item.Properties()));
    public static final DeferredItem<Item> HYDRO_ROCK = ITEMS.register("hydro_rock", () -> new BlockItem(ModBlocks.HYDRO_ROCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> INFERNAL_ROCK = ITEMS.register("infernal_rock", () -> new BlockItem(ModBlocks.INFERNAL_ROCK.get(), new Item.Properties()));

    // Sand and Gravel
    public static final DeferredItem<Item> BONE_SAND = ITEMS.register("bone_sand", () -> new BlockItem(ModBlocks.BONE_SAND.get(), new Item.Properties()));
    public static final DeferredItem<Item> WITHER_BONE_SAND = ITEMS.register("wither_bone_sand", () -> new BlockItem(ModBlocks.WITHER_BONE_SAND.get(), new Item.Properties()));

    // Polished
    public static final DeferredItem<Item> POLISHED_PERIDOTITE = ITEMS.register("polished_peridotite", () -> new BlockItem(ModBlocks.POLISHED_PERIDOTITE.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PRISMARINE = ITEMS.register("polished_prismarine", () -> new BlockItem(ModBlocks.POLISHED_PRISMARINE.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_DARK_PRISMARINE = ITEMS.register("polished_dark_prismarine", () -> new BlockItem(ModBlocks.POLISHED_DARK_PRISMARINE.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_END_STONE = ITEMS.register("polished_end_stone", () -> new BlockItem(ModBlocks.POLISHED_END_STONE.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_NETHERRACK = ITEMS.register("polished_netherrack", () -> new BlockItem(ModBlocks.POLISHED_NETHERRACK.get(), new Item.Properties()));

    // Chiseled and cracked
    public static final DeferredItem<Item> CRACKED_RED_NETHER_BRICKS = ITEMS.register("cracked_red_nether_bricks", () -> new BlockItem(ModBlocks.CRACKED_RED_NETHER_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHISELED_RED_NETHER_BRICKS = ITEMS.register("chiseled_red_nether_bricks", () -> new BlockItem(ModBlocks.CHISELED_RED_NETHER_BRICKS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHISELED_PURPUR_BLOCK = ITEMS.register("chiseled_purpur_block", () -> new BlockItem(ModBlocks.CHISELED_PURPUR_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHISELED_OBSIDIAN = ITEMS.register("chiseled_obsidian", () -> new BlockItem(ModBlocks.CHISELED_OBSIDIAN.get(), new Item.Properties()));

    // Pillars
    public static final DeferredItem<Item> GRANITE_PILLAR = ITEMS.register("granite_pillar", () -> new BlockItem(ModBlocks.GRANITE_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> DIORITE_PILLAR = ITEMS.register("diorite_pillar", () -> new BlockItem(ModBlocks.DIORITE_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> ANDESITE_PILLAR = ITEMS.register("andesite_pillar", () -> new BlockItem(ModBlocks.ANDESITE_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> PERIDOTITE_PILLAR = ITEMS.register("peridotite_pillar", () -> new BlockItem(ModBlocks.PERIDOTITE_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> PRISMARINE_PILLAR = ITEMS.register("prismarine_pillar", () -> new BlockItem(ModBlocks.PRISMARINE_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_PRISMARINE_PILLAR = ITEMS.register("dark_prismarine_pillar", () -> new BlockItem(ModBlocks.DARK_PRISMARINE_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> END_STONE_PILLAR = ITEMS.register("end_stone_pillar", () -> new BlockItem(ModBlocks.END_STONE_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> NETHERRACK_PILLAR = ITEMS.register("netherrack_pillar", () -> new BlockItem(ModBlocks.NETHERRACK_PILLAR.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_PILLAR = ITEMS.register("obsidian_pillar", () -> new BlockItem(ModBlocks.OBSIDIAN_PILLAR.get(), new Item.Properties()));

    // Wood Variations
    public static final DeferredItem<Item> SPRUCE_BOOKSHELF = ITEMS.register("spruce_bookshelf", () -> new BlockItem(ModBlocks.SPRUCE_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_BOOKSHELF = ITEMS.register("birch_bookshelf", () -> new BlockItem(ModBlocks.BIRCH_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_BOOKSHELF = ITEMS.register("jungle_bookshelf", () -> new BlockItem(ModBlocks.JUNGLE_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_BOOKSHELF = ITEMS.register("acacia_bookshelf", () -> new BlockItem(ModBlocks.ACACIA_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_BOOKSHELF = ITEMS.register("dark_oak_bookshelf", () -> new BlockItem(ModBlocks.DARK_OAK_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_BOOKSHELF = ITEMS.register("mangrove_bookshelf", () -> new BlockItem(ModBlocks.MANGROVE_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_BOOKSHELF = ITEMS.register("cherry_bookshelf", () -> new BlockItem(ModBlocks.CHERRY_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_BOOKSHELF = ITEMS.register("crimson_bookshelf", () -> new BlockItem(ModBlocks.CRIMSON_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> WARPED_BOOKSHELF = ITEMS.register("warped_bookshelf", () -> new BlockItem(ModBlocks.WARPED_BOOKSHELF.get(), new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_LADDER = ITEMS.register("spruce_ladder", () -> new BlockItem(ModBlocks.SPRUCE_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_LADDER = ITEMS.register("birch_ladder", () -> new BlockItem(ModBlocks.BIRCH_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_LADDER = ITEMS.register("jungle_ladder", () -> new BlockItem(ModBlocks.JUNGLE_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_LADDER = ITEMS.register("acacia_ladder", () -> new BlockItem(ModBlocks.ACACIA_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_LADDER = ITEMS.register("dark_oak_ladder", () -> new BlockItem(ModBlocks.DARK_OAK_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_LADDER = ITEMS.register("mangrove_ladder", () -> new BlockItem(ModBlocks.MANGROVE_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_LADDER = ITEMS.register("cherry_ladder", () -> new BlockItem(ModBlocks.CHERRY_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_LADDER = ITEMS.register("crimson_ladder", () -> new BlockItem(ModBlocks.CRIMSON_LADDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> WARPED_LADDER = ITEMS.register("warped_ladder", () -> new BlockItem(ModBlocks.WARPED_LADDER.get(), new Item.Properties()));

    // Storage
    public static final DeferredItem<Item> CHARCOAL_BLOCK = ITEMS.register("charcoal_block", () -> new BlockItem(ModBlocks.CHARCOAL_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> SUGAR_BLOCK = ITEMS.register("sugar_block", () -> new BlockItem(ModBlocks.SUGAR_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> SUGAR_CANE_BLOCK = ITEMS.register("sugar_cane_block", () -> new BlockItem(ModBlocks.SUGAR_CANE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> GUNPOWDER_BLOCK = ITEMS.register("gunpowder_block", () -> new BlockItem(ModBlocks.GUNPOWDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLAZE_POWDER_BLOCK = ITEMS.register("blaze_powder_block", () -> new BlockItem(ModBlocks.BLAZE_POWDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGMA_CREAM_BLOCK = ITEMS.register("magma_cream_block", () -> new BlockItem(ModBlocks.MAGMA_CREAM_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> PRISMARINE_CRYSTAL_BLOCK = ITEMS.register("prismarine_crystal_block", () -> new BlockItem(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> WITHER_BONE_BLOCK = ITEMS.register("wither_bone_block", () -> new BlockItem(ModBlocks.WITHER_BONE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_DYE_BLOCK = ITEMS.register("white_dye_block", () -> new BlockItem(ModBlocks.WHITE_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_DYE_BLOCK = ITEMS.register("orange_dye_block", () -> new BlockItem(ModBlocks.ORANGE_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_DYE_BLOCK = ITEMS.register("magenta_dye_block", () -> new BlockItem(ModBlocks.MAGENTA_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_DYE_BLOCK = ITEMS.register("light_blue_dye_block", () -> new BlockItem(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_DYE_BLOCK = ITEMS.register("yellow_dye_block", () -> new BlockItem(ModBlocks.YELLOW_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_DYE_BLOCK = ITEMS.register("lime_dye_block", () -> new BlockItem(ModBlocks.LIME_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_DYE_BLOCK = ITEMS.register("pink_dye_block", () -> new BlockItem(ModBlocks.PINK_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_DYE_BLOCK = ITEMS.register("gray_dye_block", () -> new BlockItem(ModBlocks.GRAY_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_DYE_BLOCK = ITEMS.register("light_gray_dye_block", () -> new BlockItem(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_DYE_BLOCK = ITEMS.register("cyan_dye_block", () -> new BlockItem(ModBlocks.CYAN_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_DYE_BLOCK = ITEMS.register("purple_dye_block", () -> new BlockItem(ModBlocks.PURPLE_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_DYE_BLOCK = ITEMS.register("blue_dye_block", () -> new BlockItem(ModBlocks.BLUE_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_DYE_BLOCK = ITEMS.register("brown_dye_block", () -> new BlockItem(ModBlocks.BROWN_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_DYE_BLOCK = ITEMS.register("green_dye_block", () -> new BlockItem(ModBlocks.GREEN_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_DYE_BLOCK = ITEMS.register("red_dye_block", () -> new BlockItem(ModBlocks.RED_DYE_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_DYE_BLOCK = ITEMS.register("black_dye_block", () -> new BlockItem(ModBlocks.BLACK_DYE_BLOCK.get(), new Item.Properties()));

    // Glass
    public static final DeferredItem<Item> SOUL_GLASS = ITEMS.register("soul_glass", () -> new BlockItem(ModBlocks.SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_STAINED_SOUL_GLASS = ITEMS.register("white_stained_soul_glass", () -> new BlockItem(ModBlocks.WHITE_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_STAINED_SOUL_GLASS = ITEMS.register("orange_stained_soul_glass", () -> new BlockItem(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_STAINED_SOUL_GLASS = ITEMS.register("magenta_stained_soul_glass", () -> new BlockItem(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_STAINED_SOUL_GLASS = ITEMS.register("light_blue_stained_soul_glass", () -> new BlockItem(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_STAINED_SOUL_GLASS = ITEMS.register("yellow_stained_soul_glass", () -> new BlockItem(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_STAINED_SOUL_GLASS = ITEMS.register("lime_stained_soul_glass", () -> new BlockItem(ModBlocks.LIME_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_STAINED_SOUL_GLASS = ITEMS.register("pink_stained_soul_glass", () -> new BlockItem(ModBlocks.PINK_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_STAINED_SOUL_GLASS = ITEMS.register("gray_stained_soul_glass", () -> new BlockItem(ModBlocks.GRAY_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_STAINED_SOUL_GLASS = ITEMS.register("light_gray_stained_soul_glass", () -> new BlockItem(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_STAINED_SOUL_GLASS = ITEMS.register("cyan_stained_soul_glass", () -> new BlockItem(ModBlocks.CYAN_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_STAINED_SOUL_GLASS = ITEMS.register("purple_stained_soul_glass", () -> new BlockItem(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_STAINED_SOUL_GLASS = ITEMS.register("blue_stained_soul_glass", () -> new BlockItem(ModBlocks.BLUE_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_STAINED_SOUL_GLASS = ITEMS.register("brown_stained_soul_glass", () -> new BlockItem(ModBlocks.BROWN_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_STAINED_SOUL_GLASS = ITEMS.register("green_stained_soul_glass", () -> new BlockItem(ModBlocks.GREEN_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_STAINED_SOUL_GLASS = ITEMS.register("red_stained_soul_glass", () -> new BlockItem(ModBlocks.RED_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_STAINED_SOUL_GLASS = ITEMS.register("black_stained_soul_glass", () -> new BlockItem(ModBlocks.BLACK_STAINED_SOUL_GLASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> SOUL_GLASS_PANE = ITEMS.register("soul_glass_pane", () -> new BlockItem(ModBlocks.SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_STAINED_SOUL_GLASS_PANE = ITEMS.register("white_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_STAINED_SOUL_GLASS_PANE = ITEMS.register("orange_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_STAINED_SOUL_GLASS_PANE = ITEMS.register("magenta_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_STAINED_SOUL_GLASS_PANE = ITEMS.register("light_blue_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_STAINED_SOUL_GLASS_PANE = ITEMS.register("yellow_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_STAINED_SOUL_GLASS_PANE = ITEMS.register("lime_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_STAINED_SOUL_GLASS_PANE = ITEMS.register("pink_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_STAINED_SOUL_GLASS_PANE = ITEMS.register("gray_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_STAINED_SOUL_GLASS_PANE = ITEMS.register("light_gray_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_STAINED_SOUL_GLASS_PANE = ITEMS.register("cyan_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_STAINED_SOUL_GLASS_PANE = ITEMS.register("purple_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_STAINED_SOUL_GLASS_PANE = ITEMS.register("blue_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_STAINED_SOUL_GLASS_PANE = ITEMS.register("brown_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_STAINED_SOUL_GLASS_PANE = ITEMS.register("green_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_STAINED_SOUL_GLASS_PANE = ITEMS.register("red_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_STAINED_SOUL_GLASS_PANE = ITEMS.register("black_stained_soul_glass_pane", () -> new BlockItem(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get(), new Item.Properties()));

    // Misc
    public static final DeferredItem<Item> EASEL = ITEMS.register("easel", () -> new BlockItem(ModBlocks.EASEL.get(), new Item.Properties()));
    public static final DeferredItem<Item> RAIN_DETECTOR = ITEMS.register("rain_detector", () -> new BlockItem(ModBlocks.RAIN_DETECTOR.get(), new Item.Properties()));
    public static final DeferredItem<Item> GOLD_BARS = ITEMS.register("gold_bars", () -> new BlockItem(ModBlocks.GOLD_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> COPPER_BARS = ITEMS.register("copper_bars", () -> new BlockItem(ModBlocks.COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> EXPOSED_COPPER_BARS = ITEMS.register("exposed_copper_bars", () -> new BlockItem(ModBlocks.EXPOSED_COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WEATHERED_COPPER_BARS = ITEMS.register("weathered_copper_bars", () -> new BlockItem(ModBlocks.WEATHERED_COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> OXIDIZED_COPPER_BARS = ITEMS.register("oxidized_copper_bars", () -> new BlockItem(ModBlocks.OXIDIZED_COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WAXED_COPPER_BARS = ITEMS.register("waxed_copper_bars", () -> new BlockItem(ModBlocks.WAXED_COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WAXED_EXPOSED_COPPER_BARS = ITEMS.register("waxed_exposed_copper_bars", () -> new BlockItem(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WAXED_WEATHERED_COPPER_BARS = ITEMS.register("waxed_weathered_copper_bars", () -> new BlockItem(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WAXED_OXIDIZED_COPPER_BARS = ITEMS.register("waxed_oxidized_copper_bars", () -> new BlockItem(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ROSE = ITEMS.register("rose", () -> new BlockItem(ModBlocks.ROSE.get(), new Item.Properties()));
    public static final DeferredItem<Item> SHEARED_ROSE_BUSH = ITEMS.register("sheared_rose_bush", () -> new BlockItem(ModBlocks.SHEARED_ROSE_BUSH.get(), new Item.Properties()));
    public static final DeferredItem<Item> PEONY = ITEMS.register("peony", () -> new BlockItem(ModBlocks.PEONY.get(), new Item.Properties()));
    public static final DeferredItem<Item> SHEARED_PEONY = ITEMS.register("sheared_peony", () -> new BlockItem(ModBlocks.SHEARED_PEONY.get(), new Item.Properties()));
    public static final DeferredItem<Item> LILAC = ITEMS.register("lilac", () -> new BlockItem(ModBlocks.LILAC.get(), new Item.Properties()));
    public static final DeferredItem<Item> SHEARED_LILAC = ITEMS.register("sheared_lilac", () -> new BlockItem(ModBlocks.SHEARED_LILAC.get(), new Item.Properties()));
    public static final DeferredItem<Item> TRELLIS = ITEMS.register("trellis", () -> new BlockItem(ModBlocks.TRELLIS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WITHERED_VINE = ITEMS.register("withered_vine", () -> new BlockItem(ModBlocks.WITHERED_VINE.get(), new Item.Properties()));

    // VanillaBoom Stairs
    public static final DeferredItem<Item> COBBLESTONE_BRICK_STAIRS = ITEMS.register("cobblestone_brick_stairs", () -> new BlockItem(ModBlocks.COBBLESTONE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MOSSY_COBBLESTONE_BRICK_STAIRS = ITEMS.register("mossy_cobblestone_brick_stairs", () -> new BlockItem(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGMA_BRICK_STAIRS = ITEMS.register("magma_brick_stairs", () -> new BlockItem(ModBlocks.MAGMA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_BRICK_STAIRS = ITEMS.register("obsidian_brick_stairs", () -> new BlockItem(ModBlocks.OBSIDIAN_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> SNOW_BRICK_STAIRS = ITEMS.register("snow_brick_stairs", () -> new BlockItem(ModBlocks.SNOW_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> TERRACOTTA_BRICK_STAIRS = ITEMS.register("terracotta_brick_stairs", () -> new BlockItem(ModBlocks.TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_TERRACOTTA_BRICK_STAIRS = ITEMS.register("white_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_TERRACOTTA_BRICK_STAIRS = ITEMS.register("orange_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_TERRACOTTA_BRICK_STAIRS = ITEMS.register("magenta_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = ITEMS.register("light_blue_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_TERRACOTTA_BRICK_STAIRS = ITEMS.register("yellow_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_TERRACOTTA_BRICK_STAIRS = ITEMS.register("lime_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_TERRACOTTA_BRICK_STAIRS = ITEMS.register("pink_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_TERRACOTTA_BRICK_STAIRS = ITEMS.register("gray_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = ITEMS.register("light_gray_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_TERRACOTTA_BRICK_STAIRS = ITEMS.register("cyan_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_TERRACOTTA_BRICK_STAIRS = ITEMS.register("purple_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_TERRACOTTA_BRICK_STAIRS = ITEMS.register("blue_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_TERRACOTTA_BRICK_STAIRS = ITEMS.register("brown_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_TERRACOTTA_BRICK_STAIRS = ITEMS.register("green_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_TERRACOTTA_BRICK_STAIRS = ITEMS.register("red_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_TERRACOTTA_BRICK_STAIRS = ITEMS.register("black_terracotta_brick_stairs", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PERIDOTITE_STAIRS = ITEMS.register("peridotite_stairs", () -> new BlockItem(ModBlocks.PERIDOTITE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PERIDOTITE_STAIRS = ITEMS.register("polished_peridotite_stairs", () -> new BlockItem(ModBlocks.POLISHED_PERIDOTITE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PRISMARINE_STAIRS = ITEMS.register("polished_prismarine_stairs", () -> new BlockItem(ModBlocks.POLISHED_PRISMARINE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_DARK_PRISMARINE_STAIRS = ITEMS.register("polished_dark_prismarine_stairs", () -> new BlockItem(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_END_STONE_STAIRS = ITEMS.register("polished_end_stone_stairs", () -> new BlockItem(ModBlocks.POLISHED_END_STONE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_NETHERRACK_STAIRS = ITEMS.register("polished_netherrack_stairs", () -> new BlockItem(ModBlocks.POLISHED_NETHERRACK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_RED_NETHER_BRICK_STAIRS = ITEMS.register("cracked_red_nether_brick_stairs", () -> new BlockItem(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get(), new Item.Properties()));

    // Vanilla Stairs
    public static final DeferredItem<Item> CRACKED_STONE_BRICK_STAIRS = ITEMS.register("cracked_stone_brick_stairs", () -> new BlockItem(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> IRON_BLOCK_STAIRS = ITEMS.register("iron_block_stairs", () -> new BlockItem(ModBlocks.IRON_BLOCK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GOLD_BLOCK_STAIRS = ITEMS.register("gold_block_stairs", () -> new BlockItem(ModBlocks.GOLD_BLOCK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_STAIRS = ITEMS.register("obsidian_stairs", () -> new BlockItem(ModBlocks.OBSIDIAN_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BEDROCK_STAIRS = ITEMS.register("bedrock_stairs", () -> new BlockItem(ModBlocks.BEDROCK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> NETHERRACK_STAIRS = ITEMS.register("netherrack_stairs", () -> new BlockItem(ModBlocks.NETHERRACK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_NETHER_BRICK_STAIRS = ITEMS.register("cracked_nether_brick_stairs", () -> new BlockItem(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = ITEMS.register("cracked_polished_blackstone_brick_stairs", () -> new BlockItem(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> END_STONE_STAIRS = ITEMS.register("end_stone_stairs", () -> new BlockItem(ModBlocks.END_STONE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> QUARTZ_BRICK_STAIRS = ITEMS.register("quartz_brick_stairs", () -> new BlockItem(ModBlocks.QUARTZ_BRICK_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> TERRACOTTA_STAIRS = ITEMS.register("terracotta_stairs", () -> new BlockItem(ModBlocks.TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_TERRACOTTA_STAIRS = ITEMS.register("white_terracotta_stairs", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_TERRACOTTA_STAIRS = ITEMS.register("orange_terracotta_stairs", () -> new BlockItem(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_TERRACOTTA_STAIRS = ITEMS.register("magenta_terracotta_stairs", () -> new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_TERRACOTTA_STAIRS = ITEMS.register("light_blue_terracotta_stairs", () -> new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_TERRACOTTA_STAIRS = ITEMS.register("yellow_terracotta_stairs", () -> new BlockItem(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_TERRACOTTA_STAIRS = ITEMS.register("lime_terracotta_stairs", () -> new BlockItem(ModBlocks.LIME_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_TERRACOTTA_STAIRS = ITEMS.register("pink_terracotta_stairs", () -> new BlockItem(ModBlocks.PINK_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_TERRACOTTA_STAIRS = ITEMS.register("gray_terracotta_stairs", () -> new BlockItem(ModBlocks.GRAY_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_TERRACOTTA_STAIRS = ITEMS.register("light_gray_terracotta_stairs", () -> new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_TERRACOTTA_STAIRS = ITEMS.register("cyan_terracotta_stairs", () -> new BlockItem(ModBlocks.CYAN_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_TERRACOTTA_STAIRS = ITEMS.register("purple_terracotta_stairs", () -> new BlockItem(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_TERRACOTTA_STAIRS = ITEMS.register("blue_terracotta_stairs", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_TERRACOTTA_STAIRS = ITEMS.register("brown_terracotta_stairs", () -> new BlockItem(ModBlocks.BROWN_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_TERRACOTTA_STAIRS = ITEMS.register("green_terracotta_stairs", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_TERRACOTTA_STAIRS = ITEMS.register("red_terracotta_stairs", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_TERRACOTTA_STAIRS = ITEMS.register("black_terracotta_stairs", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_CONCRETE_STAIRS = ITEMS.register("white_concrete_stairs", () -> new BlockItem(ModBlocks.WHITE_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_CONCRETE_STAIRS = ITEMS.register("orange_concrete_stairs", () -> new BlockItem(ModBlocks.ORANGE_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_CONCRETE_STAIRS = ITEMS.register("magenta_concrete_stairs", () -> new BlockItem(ModBlocks.MAGENTA_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_CONCRETE_STAIRS = ITEMS.register("light_blue_concrete_stairs", () -> new BlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_CONCRETE_STAIRS = ITEMS.register("yellow_concrete_stairs", () -> new BlockItem(ModBlocks.YELLOW_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_CONCRETE_STAIRS = ITEMS.register("lime_concrete_stairs", () -> new BlockItem(ModBlocks.LIME_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_CONCRETE_STAIRS = ITEMS.register("pink_concrete_stairs", () -> new BlockItem(ModBlocks.PINK_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_CONCRETE_STAIRS = ITEMS.register("gray_concrete_stairs", () -> new BlockItem(ModBlocks.GRAY_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_CONCRETE_STAIRS = ITEMS.register("light_gray_concrete_stairs", () -> new BlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_CONCRETE_STAIRS = ITEMS.register("cyan_concrete_stairs", () -> new BlockItem(ModBlocks.CYAN_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_CONCRETE_STAIRS = ITEMS.register("purple_concrete_stairs", () -> new BlockItem(ModBlocks.PURPLE_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_CONCRETE_STAIRS = ITEMS.register("blue_concrete_stairs", () -> new BlockItem(ModBlocks.BLUE_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_CONCRETE_STAIRS = ITEMS.register("brown_concrete_stairs", () -> new BlockItem(ModBlocks.BROWN_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_CONCRETE_STAIRS = ITEMS.register("green_concrete_stairs", () -> new BlockItem(ModBlocks.GREEN_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_CONCRETE_STAIRS = ITEMS.register("red_concrete_stairs", () -> new BlockItem(ModBlocks.RED_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_CONCRETE_STAIRS = ITEMS.register("black_concrete_stairs", () -> new BlockItem(ModBlocks.BLACK_CONCRETE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> OAK_WOOD_STAIRS = ITEMS.register("oak_wood_stairs", () -> new BlockItem(ModBlocks.OAK_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_WOOD_STAIRS = ITEMS.register("spruce_wood_stairs", () -> new BlockItem(ModBlocks.SPRUCE_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_WOOD_STAIRS = ITEMS.register("birch_wood_stairs", () -> new BlockItem(ModBlocks.BIRCH_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_WOOD_STAIRS = ITEMS.register("jungle_wood_stairs", () -> new BlockItem(ModBlocks.JUNGLE_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_WOOD_STAIRS = ITEMS.register("acacia_wood_stairs", () -> new BlockItem(ModBlocks.ACACIA_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_WOOD_STAIRS = ITEMS.register("dark_oak_wood_stairs", () -> new BlockItem(ModBlocks.DARK_OAK_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_WOOD_STAIRS = ITEMS.register("mangrove_wood_stairs", () -> new BlockItem(ModBlocks.MANGROVE_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_WOOD_STAIRS = ITEMS.register("cherry_wood_stairs", () -> new BlockItem(ModBlocks.CHERRY_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_HYPHAE_STAIRS = ITEMS.register("crimson_hyphae_stairs", () -> new BlockItem(ModBlocks.CRIMSON_HYPHAE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> WARPED_HYPHAE_STAIRS = ITEMS.register("warped_hyphae_stairs", () -> new BlockItem(ModBlocks.WARPED_HYPHAE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_OAK_WOOD_STAIRS = ITEMS.register("stripped_oak_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_SPRUCE_WOOD_STAIRS = ITEMS.register("stripped_spruce_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_BIRCH_WOOD_STAIRS = ITEMS.register("stripped_birch_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_JUNGLE_WOOD_STAIRS = ITEMS.register("stripped_jungle_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_ACACIA_WOOD_STAIRS = ITEMS.register("stripped_acacia_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_DARK_OAK_WOOD_STAIRS = ITEMS.register("stripped_dark_oak_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_MANGROVE_WOOD_STAIRS = ITEMS.register("stripped_mangrove_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CHERRY_WOOD_STAIRS = ITEMS.register("stripped_cherry_wood_stairs", () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CRIMSON_HYPHAE_STAIRS = ITEMS.register("stripped_crimson_hyphae_stairs", () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_WARPED_HYPHAE_STAIRS = ITEMS.register("stripped_warped_hyphae_stairs", () -> new BlockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CUT_SANDSTONE_STAIRS = ITEMS.register("cut_sandstone_stairs", () -> new BlockItem(ModBlocks.CUT_SANDSTONE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> CUT_RED_SANDSTONE_STAIRS = ITEMS.register("cut_red_sandstone_stairs", () -> new BlockItem(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<Item> SMOOTH_STONE_STAIRS = ITEMS.register("smooth_stone_stairs", () -> new BlockItem(ModBlocks.SMOOTH_STONE_STAIRS.get(), new Item.Properties()));

    // VanillaBoom Slabs
    public static final DeferredItem<Item> COBBLESTONE_BRICK_SLAB = ITEMS.register("cobblestone_brick_slab", () -> new BlockItem(ModBlocks.COBBLESTONE_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> MOSSY_COBBLESTONE_BRICK_SLAB = ITEMS.register("mossy_cobblestone_brick_slab", () -> new BlockItem(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGMA_BRICK_SLAB = ITEMS.register("magma_brick_slab", () -> new BlockItem(ModBlocks.MAGMA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_BRICK_SLAB = ITEMS.register("obsidian_brick_slab", () -> new BlockItem(ModBlocks.OBSIDIAN_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> SNOW_BRICK_SLAB = ITEMS.register("snow_brick_slab", () -> new BlockItem(ModBlocks.SNOW_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> TERRACOTTA_BRICK_SLAB = ITEMS.register("terracotta_brick_slab", () -> new BlockItem(ModBlocks.TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_TERRACOTTA_BRICK_SLAB = ITEMS.register("white_terracotta_brick_slab", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_TERRACOTTA_BRICK_SLAB = ITEMS.register("orange_terracotta_brick_slab", () -> new BlockItem(ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_TERRACOTTA_BRICK_SLAB = ITEMS.register("magenta_terracotta_brick_slab", () -> new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = ITEMS.register("light_blue_terracotta_brick_slab", () -> new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_TERRACOTTA_BRICK_SLAB = ITEMS.register("yellow_terracotta_brick_slab", () -> new BlockItem(ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_TERRACOTTA_BRICK_SLAB = ITEMS.register("lime_terracotta_brick_slab", () -> new BlockItem(ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_TERRACOTTA_BRICK_SLAB = ITEMS.register("pink_terracotta_brick_slab", () -> new BlockItem(ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_TERRACOTTA_BRICK_SLAB = ITEMS.register("gray_terracotta_brick_slab", () -> new BlockItem(ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = ITEMS.register("light_gray_terracotta_brick_slab", () -> new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_TERRACOTTA_BRICK_SLAB = ITEMS.register("cyan_terracotta_brick_slab", () -> new BlockItem(ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_TERRACOTTA_BRICK_SLAB = ITEMS.register("purple_terracotta_brick_slab", () -> new BlockItem(ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_TERRACOTTA_BRICK_SLAB = ITEMS.register("blue_terracotta_brick_slab", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_TERRACOTTA_BRICK_SLAB = ITEMS.register("brown_terracotta_brick_slab", () -> new BlockItem(ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_TERRACOTTA_BRICK_SLAB = ITEMS.register("green_terracotta_brick_slab", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_TERRACOTTA_BRICK_SLAB = ITEMS.register("red_terracotta_brick_slab", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_TERRACOTTA_BRICK_SLAB = ITEMS.register("black_terracotta_brick_slab", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> PERIDOTITE_SLAB = ITEMS.register("peridotite_slab", () -> new BlockItem(ModBlocks.PERIDOTITE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PERIDOTITE_SLAB = ITEMS.register("polished_peridotite_slab", () -> new BlockItem(ModBlocks.POLISHED_PERIDOTITE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PRISMARINE_SLAB = ITEMS.register("polished_prismarine_slab", () -> new BlockItem(ModBlocks.POLISHED_PRISMARINE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_DARK_PRISMARINE_SLAB = ITEMS.register("polished_dark_prismarine_slab", () -> new BlockItem(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_END_STONE_SLAB = ITEMS.register("polished_end_stone_slab", () -> new BlockItem(ModBlocks.POLISHED_END_STONE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_NETHERRACK_SLAB = ITEMS.register("polished_netherrack_slab", () -> new BlockItem(ModBlocks.POLISHED_NETHERRACK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_RED_NETHER_BRICK_SLAB = ITEMS.register("cracked_red_nether_brick_slab", () -> new BlockItem(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get(), new Item.Properties()));

    // Vanilla Slabs
    public static final DeferredItem<Item> CRACKED_STONE_BRICK_SLAB = ITEMS.register("cracked_stone_brick_slab", () -> new BlockItem(ModBlocks.CRACKED_STONE_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> IRON_BLOCK_SLAB = ITEMS.register("iron_block_slab", () -> new BlockItem(ModBlocks.IRON_BLOCK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> GOLD_BLOCK_SLAB = ITEMS.register("gold_block_slab", () -> new BlockItem(ModBlocks.GOLD_BLOCK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_SLAB = ITEMS.register("obsidian_slab", () -> new BlockItem(ModBlocks.OBSIDIAN_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BEDROCK_SLAB = ITEMS.register("bedrock_slab", () -> new BlockItem(ModBlocks.BEDROCK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> NETHERRACK_SLAB = ITEMS.register("netherrack_slab", () -> new BlockItem(ModBlocks.NETHERRACK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_NETHER_BRICK_SLAB = ITEMS.register("cracked_nether_brick_slab", () -> new BlockItem(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = ITEMS.register("cracked_polished_blackstone_brick_slab", () -> new BlockItem(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> END_STONE_SLAB = ITEMS.register("end_stone_slab", () -> new BlockItem(ModBlocks.END_STONE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> QUARTZ_BRICK_SLAB = ITEMS.register("quartz_brick_slab", () -> new BlockItem(ModBlocks.QUARTZ_BRICK_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> TERRACOTTA_SLAB = ITEMS.register("terracotta_slab", () -> new BlockItem(ModBlocks.TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_TERRACOTTA_SLAB = ITEMS.register("white_terracotta_slab", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_TERRACOTTA_SLAB = ITEMS.register("orange_terracotta_slab", () -> new BlockItem(ModBlocks.ORANGE_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_TERRACOTTA_SLAB = ITEMS.register("magenta_terracotta_slab", () -> new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_TERRACOTTA_SLAB = ITEMS.register("light_blue_terracotta_slab", () -> new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_TERRACOTTA_SLAB = ITEMS.register("yellow_terracotta_slab", () -> new BlockItem(ModBlocks.YELLOW_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_TERRACOTTA_SLAB = ITEMS.register("lime_terracotta_slab", () -> new BlockItem(ModBlocks.LIME_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_TERRACOTTA_SLAB = ITEMS.register("pink_terracotta_slab", () -> new BlockItem(ModBlocks.PINK_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_TERRACOTTA_SLAB = ITEMS.register("gray_terracotta_slab", () -> new BlockItem(ModBlocks.GRAY_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_TERRACOTTA_SLAB = ITEMS.register("light_gray_terracotta_slab", () -> new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_TERRACOTTA_SLAB = ITEMS.register("cyan_terracotta_slab", () -> new BlockItem(ModBlocks.CYAN_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_TERRACOTTA_SLAB = ITEMS.register("purple_terracotta_slab", () -> new BlockItem(ModBlocks.PURPLE_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_TERRACOTTA_SLAB = ITEMS.register("blue_terracotta_slab", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_TERRACOTTA_SLAB = ITEMS.register("brown_terracotta_slab", () -> new BlockItem(ModBlocks.BROWN_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_TERRACOTTA_SLAB = ITEMS.register("green_terracotta_slab", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_TERRACOTTA_SLAB = ITEMS.register("red_terracotta_slab", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_TERRACOTTA_SLAB = ITEMS.register("black_terracotta_slab", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_CONCRETE_SLAB = ITEMS.register("white_concrete_slab", () -> new BlockItem(ModBlocks.WHITE_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_CONCRETE_SLAB = ITEMS.register("orange_concrete_slab", () -> new BlockItem(ModBlocks.ORANGE_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_CONCRETE_SLAB = ITEMS.register("magenta_concrete_slab", () -> new BlockItem(ModBlocks.MAGENTA_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_CONCRETE_SLAB = ITEMS.register("light_blue_concrete_slab", () -> new BlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_CONCRETE_SLAB = ITEMS.register("yellow_concrete_slab", () -> new BlockItem(ModBlocks.YELLOW_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_CONCRETE_SLAB = ITEMS.register("lime_concrete_slab", () -> new BlockItem(ModBlocks.LIME_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_CONCRETE_SLAB = ITEMS.register("pink_concrete_slab", () -> new BlockItem(ModBlocks.PINK_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_CONCRETE_SLAB = ITEMS.register("gray_concrete_slab", () -> new BlockItem(ModBlocks.GRAY_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_CONCRETE_SLAB = ITEMS.register("light_gray_concrete_slab", () -> new BlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_CONCRETE_SLAB = ITEMS.register("cyan_concrete_slab", () -> new BlockItem(ModBlocks.CYAN_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_CONCRETE_SLAB = ITEMS.register("purple_concrete_slab", () -> new BlockItem(ModBlocks.PURPLE_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_CONCRETE_SLAB = ITEMS.register("blue_concrete_slab", () -> new BlockItem(ModBlocks.BLUE_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_CONCRETE_SLAB = ITEMS.register("brown_concrete_slab", () -> new BlockItem(ModBlocks.BROWN_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_CONCRETE_SLAB = ITEMS.register("green_concrete_slab", () -> new BlockItem(ModBlocks.GREEN_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_CONCRETE_SLAB = ITEMS.register("red_concrete_slab", () -> new BlockItem(ModBlocks.RED_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_CONCRETE_SLAB = ITEMS.register("black_concrete_slab", () -> new BlockItem(ModBlocks.BLACK_CONCRETE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> OAK_WOOD_SLAB = ITEMS.register("oak_wood_slab", () -> new BlockItem(ModBlocks.OAK_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_WOOD_SLAB = ITEMS.register("spruce_wood_slab", () -> new BlockItem(ModBlocks.SPRUCE_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_WOOD_SLAB = ITEMS.register("birch_wood_slab", () -> new BlockItem(ModBlocks.BIRCH_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_WOOD_SLAB = ITEMS.register("jungle_wood_slab", () -> new BlockItem(ModBlocks.JUNGLE_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_WOOD_SLAB = ITEMS.register("acacia_wood_slab", () -> new BlockItem(ModBlocks.ACACIA_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_WOOD_SLAB = ITEMS.register("dark_oak_wood_slab", () -> new BlockItem(ModBlocks.DARK_OAK_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_WOOD_SLAB = ITEMS.register("mangrove_wood_slab", () -> new BlockItem(ModBlocks.MANGROVE_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_WOOD_SLAB = ITEMS.register("cherry_wood_slab", () -> new BlockItem(ModBlocks.CHERRY_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_HYPHAE_SLAB = ITEMS.register("crimson_hyphae_slab", () -> new BlockItem(ModBlocks.CRIMSON_HYPHAE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> WARPED_HYPHAE_SLAB = ITEMS.register("warped_hyphae_slab", () -> new BlockItem(ModBlocks.WARPED_HYPHAE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_OAK_WOOD_SLAB = ITEMS.register("stripped_oak_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_SPRUCE_WOOD_SLAB = ITEMS.register("stripped_spruce_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_BIRCH_WOOD_SLAB = ITEMS.register("stripped_birch_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_JUNGLE_WOOD_SLAB = ITEMS.register("stripped_jungle_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_ACACIA_WOOD_SLAB = ITEMS.register("stripped_acacia_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_DARK_OAK_WOOD_SLAB = ITEMS.register("stripped_dark_oak_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_MANGROVE_WOOD_SLAB = ITEMS.register("stripped_mangrove_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CHERRY_WOOD_SLAB = ITEMS.register("stripped_cherry_wood_slab", () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_WOOD_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CRIMSON_HYPHAE_SLAB = ITEMS.register("stripped_crimson_hyphae_slab", () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_WARPED_HYPHAE_SLAB = ITEMS.register("stripped_warped_hyphae_slab", () -> new BlockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_SLAB.get(), new Item.Properties()));

    // VanillaBoom Walls
    public static final DeferredItem<Item> COBBLESTONE_BRICK_WALL = ITEMS.register("cobblestone_brick_wall", () -> new BlockItem(ModBlocks.COBBLESTONE_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> MOSSY_COBBLESTONE_BRICK_WALL = ITEMS.register("mossy_cobblestone_brick_wall", () -> new BlockItem(ModBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGMA_BRICK_WALL = ITEMS.register("magma_brick_wall", () -> new BlockItem(ModBlocks.MAGMA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_BRICK_WALL = ITEMS.register("obsidian_brick_wall", () -> new BlockItem(ModBlocks.OBSIDIAN_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> SNOW_BRICK_WALL = ITEMS.register("snow_brick_wall", () -> new BlockItem(ModBlocks.SNOW_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> TERRACOTTA_BRICK_WALL = ITEMS.register("terracotta_brick_wall", () -> new BlockItem(ModBlocks.TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_TERRACOTTA_BRICK_WALL = ITEMS.register("white_terracotta_brick_wall", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_TERRACOTTA_BRICK_WALL = ITEMS.register("orange_terracotta_brick_wall", () -> new BlockItem(ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_TERRACOTTA_BRICK_WALL = ITEMS.register("magenta_terracotta_brick_wall", () -> new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_TERRACOTTA_BRICK_WALL = ITEMS.register("light_blue_terracotta_brick_wall", () -> new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_TERRACOTTA_BRICK_WALL = ITEMS.register("yellow_terracotta_brick_wall", () -> new BlockItem(ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_TERRACOTTA_BRICK_WALL = ITEMS.register("lime_terracotta_brick_wall", () -> new BlockItem(ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_TERRACOTTA_BRICK_WALL = ITEMS.register("pink_terracotta_brick_wall", () -> new BlockItem(ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_TERRACOTTA_BRICK_WALL = ITEMS.register("gray_terracotta_brick_wall", () -> new BlockItem(ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_TERRACOTTA_BRICK_WALL = ITEMS.register("light_gray_terracotta_brick_wall", () -> new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_TERRACOTTA_BRICK_WALL = ITEMS.register("cyan_terracotta_brick_wall", () -> new BlockItem(ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_TERRACOTTA_BRICK_WALL = ITEMS.register("purple_terracotta_brick_wall", () -> new BlockItem(ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_TERRACOTTA_BRICK_WALL = ITEMS.register("blue_terracotta_brick_wall", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_TERRACOTTA_BRICK_WALL = ITEMS.register("brown_terracotta_brick_wall", () -> new BlockItem(ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_TERRACOTTA_BRICK_WALL = ITEMS.register("green_terracotta_brick_wall", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_TERRACOTTA_BRICK_WALL = ITEMS.register("red_terracotta_brick_wall", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_TERRACOTTA_BRICK_WALL = ITEMS.register("black_terracotta_brick_wall", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PERIDOTITE_WALL = ITEMS.register("peridotite_wall", () -> new BlockItem(ModBlocks.PERIDOTITE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PERIDOTITE_WALL = ITEMS.register("polished_peridotite_wall", () -> new BlockItem(ModBlocks.POLISHED_PERIDOTITE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PRISMARINE_WALL = ITEMS.register("polished_prismarine_wall", () -> new BlockItem(ModBlocks.POLISHED_PRISMARINE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_DARK_PRISMARINE_WALL = ITEMS.register("polished_dark_prismarine_wall", () -> new BlockItem(ModBlocks.POLISHED_DARK_PRISMARINE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_END_STONE_WALL = ITEMS.register("polished_end_stone_wall", () -> new BlockItem(ModBlocks.POLISHED_END_STONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_NETHERRACK_WALL = ITEMS.register("polished_netherrack_wall", () -> new BlockItem(ModBlocks.POLISHED_NETHERRACK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_RED_NETHER_BRICK_WALL = ITEMS.register("cracked_red_nether_brick_wall", () -> new BlockItem(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get(), new Item.Properties()));

    // Vanilla Walls
    public static final DeferredItem<Item> CRACKED_STONE_BRICK_WALL = ITEMS.register("cracked_stone_brick_wall", () -> new BlockItem(ModBlocks.CRACKED_STONE_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> IRON_BLOCK_WALL = ITEMS.register("iron_block_wall", () -> new BlockItem(ModBlocks.IRON_BLOCK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> GOLD_BLOCK_WALL = ITEMS.register("gold_block_wall", () -> new BlockItem(ModBlocks.GOLD_BLOCK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN_WALL = ITEMS.register("obsidian_wall", () -> new BlockItem(ModBlocks.OBSIDIAN_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BEDROCK_WALL = ITEMS.register("bedrock_wall", () -> new BlockItem(ModBlocks.BEDROCK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> NETHERRACK_WALL = ITEMS.register("netherrack_wall", () -> new BlockItem(ModBlocks.NETHERRACK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_NETHER_BRICK_WALL = ITEMS.register("cracked_nether_brick_wall", () -> new BlockItem(ModBlocks.CRACKED_NETHER_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = ITEMS.register("cracked_polished_blackstone_brick_wall", () -> new BlockItem(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> END_STONE_WALL = ITEMS.register("end_stone_wall", () -> new BlockItem(ModBlocks.END_STONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> QUARTZ_BRICK_WALL = ITEMS.register("quartz_brick_wall", () -> new BlockItem(ModBlocks.QUARTZ_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> TERRACOTTA_WALL = ITEMS.register("terracotta_wall", () -> new BlockItem(ModBlocks.TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_TERRACOTTA_WALL = ITEMS.register("white_terracotta_wall", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_TERRACOTTA_WALL = ITEMS.register("orange_terracotta_wall", () -> new BlockItem(ModBlocks.ORANGE_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_TERRACOTTA_WALL = ITEMS.register("magenta_terracotta_wall", () -> new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_TERRACOTTA_WALL = ITEMS.register("light_blue_terracotta_wall", () -> new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_TERRACOTTA_WALL = ITEMS.register("yellow_terracotta_wall", () -> new BlockItem(ModBlocks.YELLOW_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_TERRACOTTA_WALL = ITEMS.register("lime_terracotta_wall", () -> new BlockItem(ModBlocks.LIME_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_TERRACOTTA_WALL = ITEMS.register("pink_terracotta_wall", () -> new BlockItem(ModBlocks.PINK_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_TERRACOTTA_WALL = ITEMS.register("gray_terracotta_wall", () -> new BlockItem(ModBlocks.GRAY_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_TERRACOTTA_WALL = ITEMS.register("light_gray_terracotta_wall", () -> new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_TERRACOTTA_WALL = ITEMS.register("cyan_terracotta_wall", () -> new BlockItem(ModBlocks.CYAN_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_TERRACOTTA_WALL = ITEMS.register("purple_terracotta_wall", () -> new BlockItem(ModBlocks.PURPLE_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_TERRACOTTA_WALL = ITEMS.register("blue_terracotta_wall", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_TERRACOTTA_WALL = ITEMS.register("brown_terracotta_wall", () -> new BlockItem(ModBlocks.BROWN_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_TERRACOTTA_WALL = ITEMS.register("green_terracotta_wall", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_TERRACOTTA_WALL = ITEMS.register("red_terracotta_wall", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_TERRACOTTA_WALL = ITEMS.register("black_terracotta_wall", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> WHITE_CONCRETE_WALL = ITEMS.register("white_concrete_wall", () -> new BlockItem(ModBlocks.WHITE_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_CONCRETE_WALL = ITEMS.register("orange_concrete_wall", () -> new BlockItem(ModBlocks.ORANGE_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_CONCRETE_WALL = ITEMS.register("magenta_concrete_wall", () -> new BlockItem(ModBlocks.MAGENTA_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_CONCRETE_WALL = ITEMS.register("light_blue_concrete_wall", () -> new BlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_CONCRETE_WALL = ITEMS.register("yellow_concrete_wall", () -> new BlockItem(ModBlocks.YELLOW_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIME_CONCRETE_WALL = ITEMS.register("lime_concrete_wall", () -> new BlockItem(ModBlocks.LIME_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_CONCRETE_WALL = ITEMS.register("pink_concrete_wall", () -> new BlockItem(ModBlocks.PINK_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> GRAY_CONCRETE_WALL = ITEMS.register("gray_concrete_wall", () -> new BlockItem(ModBlocks.GRAY_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_CONCRETE_WALL = ITEMS.register("light_gray_concrete_wall", () -> new BlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CYAN_CONCRETE_WALL = ITEMS.register("cyan_concrete_wall", () -> new BlockItem(ModBlocks.CYAN_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_CONCRETE_WALL = ITEMS.register("purple_concrete_wall", () -> new BlockItem(ModBlocks.PURPLE_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUE_CONCRETE_WALL = ITEMS.register("blue_concrete_wall", () -> new BlockItem(ModBlocks.BLUE_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROWN_CONCRETE_WALL = ITEMS.register("brown_concrete_wall", () -> new BlockItem(ModBlocks.BROWN_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_CONCRETE_WALL = ITEMS.register("green_concrete_wall", () -> new BlockItem(ModBlocks.GREEN_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_CONCRETE_WALL = ITEMS.register("red_concrete_wall", () -> new BlockItem(ModBlocks.RED_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLACK_CONCRETE_WALL = ITEMS.register("black_concrete_wall", () -> new BlockItem(ModBlocks.BLACK_CONCRETE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CUT_SANDSTONE_WALL = ITEMS.register("cut_sandstone_wall", () -> new BlockItem(ModBlocks.CUT_SANDSTONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> CUT_RED_SANDSTONE_WALL = ITEMS.register("cut_red_sandstone_wall", () -> new BlockItem(ModBlocks.CUT_RED_SANDSTONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> SMOOTH_STONE_WALL = ITEMS.register("smooth_stone_wall", () -> new BlockItem(ModBlocks.SMOOTH_STONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> STONE_WALL = ITEMS.register("stone_wall", () -> new BlockItem(ModBlocks.STONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_GRANITE_WALL = ITEMS.register("polished_granite_wall", () -> new BlockItem(ModBlocks.POLISHED_GRANITE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_DIORITE_WALL = ITEMS.register("polished_diorite_wall", () -> new BlockItem(ModBlocks.POLISHED_DIORITE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_ANDESITE_WALL = ITEMS.register("polished_andesite_wall", () -> new BlockItem(ModBlocks.POLISHED_ANDESITE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> SMOOTH_SANDSTONE_WALL = ITEMS.register("smooth_sandstone_wall", () -> new BlockItem(ModBlocks.SMOOTH_SANDSTONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> SMOOTH_RED_SANDSTONE_WALL = ITEMS.register("smooth_red_sandstone_wall", () -> new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PURPUR_BLOCK_WALL = ITEMS.register("purpur_block_wall", () -> new BlockItem(ModBlocks.PURPUR_BLOCK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> QUARTZ_BLOCK_WALL = ITEMS.register("quartz_block_wall", () -> new BlockItem(ModBlocks.QUARTZ_BLOCK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> SMOOTH_QUARTZ_WALL = ITEMS.register("smooth_quartz_wall", () -> new BlockItem(ModBlocks.SMOOTH_QUARTZ_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> PRISMARINE_BRICK_WALL = ITEMS.register("prismarine_brick_wall", () -> new BlockItem(ModBlocks.PRISMARINE_BRICK_WALL.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_PRISMARINE_WALL = ITEMS.register("dark_prismarine_wall", () -> new BlockItem(ModBlocks.DARK_PRISMARINE_WALL.get(), new Item.Properties()));

    // Vanilla Fences and Fence Gates
    public static final DeferredItem<Item> OAK_WOOD_FENCE = ITEMS.register("oak_wood_fence", () -> new BlockItem(ModBlocks.OAK_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_WOOD_FENCE = ITEMS.register("spruce_wood_fence", () -> new BlockItem(ModBlocks.SPRUCE_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_WOOD_FENCE = ITEMS.register("birch_wood_fence", () -> new BlockItem(ModBlocks.BIRCH_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_WOOD_FENCE = ITEMS.register("jungle_wood_fence", () -> new BlockItem(ModBlocks.JUNGLE_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_WOOD_FENCE = ITEMS.register("acacia_wood_fence", () -> new BlockItem(ModBlocks.ACACIA_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_WOOD_FENCE = ITEMS.register("dark_oak_wood_fence", () -> new BlockItem(ModBlocks.DARK_OAK_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_WOOD_FENCE = ITEMS.register("mangrove_wood_fence", () -> new BlockItem(ModBlocks.MANGROVE_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_WOOD_FENCE = ITEMS.register("cherry_wood_fence", () -> new BlockItem(ModBlocks.CHERRY_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_HYPHAE_FENCE = ITEMS.register("crimson_hyphae_fence", () -> new BlockItem(ModBlocks.CRIMSON_HYPHAE_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> WARPED_HYPHAE_FENCE = ITEMS.register("warped_hyphae_fence", () -> new BlockItem(ModBlocks.WARPED_HYPHAE_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_OAK_WOOD_FENCE = ITEMS.register("stripped_oak_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_OAK_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_SPRUCE_WOOD_FENCE = ITEMS.register("stripped_spruce_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_BIRCH_WOOD_FENCE = ITEMS.register("stripped_birch_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_JUNGLE_WOOD_FENCE = ITEMS.register("stripped_jungle_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_ACACIA_WOOD_FENCE = ITEMS.register("stripped_acacia_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_DARK_OAK_WOOD_FENCE = ITEMS.register("stripped_dark_oak_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_MANGROVE_WOOD_FENCE = ITEMS.register("stripped_mangrove_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CHERRY_WOOD_FENCE = ITEMS.register("stripped_cherry_wood_fence", () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_WOOD_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CRIMSON_HYPHAE_FENCE = ITEMS.register("stripped_crimson_hyphae_fence", () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_WARPED_HYPHAE_FENCE = ITEMS.register("stripped_warped_hyphae_fence", () -> new BlockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_NETHER_BRICK_FENCE = ITEMS.register("red_nether_brick_fence", () -> new BlockItem(ModBlocks.RED_NETHER_BRICK_FENCE.get(), new Item.Properties()));
    public static final DeferredItem<Item> OAK_WOOD_FENCE_GATE = ITEMS.register("oak_wood_fence_gate", () -> new BlockItem(ModBlocks.OAK_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_WOOD_FENCE_GATE = ITEMS.register("spruce_wood_fence_gate", () -> new BlockItem(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_WOOD_FENCE_GATE = ITEMS.register("birch_wood_fence_gate", () -> new BlockItem(ModBlocks.BIRCH_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_WOOD_FENCE_GATE = ITEMS.register("jungle_wood_fence_gate", () -> new BlockItem(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_WOOD_FENCE_GATE = ITEMS.register("acacia_wood_fence_gate", () -> new BlockItem(ModBlocks.ACACIA_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_WOOD_FENCE_GATE = ITEMS.register("dark_oak_wood_fence_gate", () -> new BlockItem(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_WOOD_FENCE_GATE = ITEMS.register("mangrove_wood_fence_gate", () -> new BlockItem(ModBlocks.MANGROVE_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_WOOD_FENCE_GATE = ITEMS.register("cherry_wood_fence_gate", () -> new BlockItem(ModBlocks.CHERRY_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_HYPHAE_FENCE_GATE = ITEMS.register("crimson_hyphae_fence_gate", () -> new BlockItem(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> WARPED_HYPHAE_FENCE_GATE = ITEMS.register("warped_hyphae_fence_gate", () -> new BlockItem(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_OAK_WOOD_FENCE_GATE = ITEMS.register("stripped_oak_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_SPRUCE_WOOD_FENCE_GATE = ITEMS.register("stripped_spruce_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_BIRCH_WOOD_FENCE_GATE = ITEMS.register("stripped_birch_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_JUNGLE_WOOD_FENCE_GATE = ITEMS.register("stripped_jungle_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_ACACIA_WOOD_FENCE_GATE = ITEMS.register("stripped_acacia_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_DARK_OAK_WOOD_FENCE_GATE = ITEMS.register("stripped_dark_oak_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_MANGROVE_WOOD_FENCE_GATE = ITEMS.register("stripped_mangrove_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CHERRY_WOOD_FENCE_GATE = ITEMS.register("stripped_cherry_wood_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_WOOD_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_CRIMSON_HYPHAE_FENCE_GATE = ITEMS.register("stripped_crimson_hyphae_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_WARPED_HYPHAE_FENCE_GATE = ITEMS.register("stripped_warped_hyphae_fence_gate", () -> new BlockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> NETHER_BRICK_FENCE_GATE = ITEMS.register("nether_brick_fence_gate", () -> new BlockItem(ModBlocks.NETHER_BRICK_FENCE_GATE.get(), new Item.Properties()));
    public static final DeferredItem<Item> RED_NETHER_BRICK_FENCE_GATE = ITEMS.register("red_nether_brick_fence_gate", () -> new BlockItem(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get(), new Item.Properties()));
}
