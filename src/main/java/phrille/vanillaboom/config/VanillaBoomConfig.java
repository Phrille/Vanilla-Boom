/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import phrille.vanillaboom.VanillaBoom;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class VanillaBoomConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue WITHER_BONE_MEAL_ENABLED = BUILDER
            .comment("Set this to false to disable Wither Bone Meal all together. This config option will override all other Wither Bone Meal config options")
            .define("wither_bone_meal_enabled", true);
    private static final ModConfigSpec.BooleanValue GROW_NETHER_WARTS = BUILDER
            .comment("Set this to false to disable Wither Bone Meal being used to grow Nether Wart.")
            .define("grow_nether_warts", true);
    private static final ModConfigSpec.BooleanValue WITHER_ROSES = BUILDER
            .comment("Set this to false to disable Wither Bone Meal being used to grow Roses into Wither Roses.")
            .define("wither_roses", true);
    private static final ModConfigSpec.BooleanValue WITHER_VINES = BUILDER
            .comment("Set this to false to disable Wither Bone Meal being used to turn Vines into Withered Vines to stop growth.")
            .define("wither_vines", true);
    private static final ModConfigSpec.BooleanValue WITHER_GRASS = BUILDER
            .comment("Set this to false to disable Wither Bone Meal being used to turn Grass and Ferns into Dead Bushes.")
            .define("wither_grass", true);
    private static final ModConfigSpec.BooleanValue PLACE_SLIME_BALLS_PISTONS = BUILDER
            .comment("Set this to false to disable placing Slime Balls on Sticky Pistons when right clicking with a Slime Ball.")
            .define("place_slime_ball_pistons", true);
    private static final ModConfigSpec.BooleanValue REMOVE_SLIME_BALLS_PISTONS = BUILDER
            .comment("Set this to false to disable removing Slime Balls from Sticky Pistons when right clicking and crouching with an Axe.")
            .define("remove_slime_ball_pistons", true);
    private static final ModConfigSpec.BooleanValue FILL_WATER_BOTTLE_HYDRO_ROCK = BUILDER
            .comment("Set this to false to disable Glass Bottles being able to be filled up when right clicking a Hydro Rock block.")
            .define("fill_water_bottle_hydro_rock", true);
    private static final ModConfigSpec.BooleanValue SHEAR_TALL_FLOWERS = BUILDER
            .comment("Set this to false to disable shearing Tall Flower Blocks to obtain their flower.")
            .define("shear_rose_bushes", true);
    private static final ModConfigSpec.BooleanValue GENERATE_VILLAGE_STRUCTURES = BUILDER
            .comment("Set this to false to disable custom Village structures to be generated in the world.")
            .define("generate_village_structures", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean witherBoneMealEnabled;
    public static boolean growNetherWarts;
    public static boolean witherRoses;
    public static boolean witherVines;
    public static boolean witherGrass;
    public static boolean placeSlimeBallPistons;
    public static boolean removeSlimeBallPistons;
    public static boolean fillWaterBottleHydroRock;
    public static boolean shearTallFlowers;
    public static boolean generateVillageStructures;

    @SubscribeEvent
    static void onLoad(ModConfigEvent event) {
        witherBoneMealEnabled = WITHER_BONE_MEAL_ENABLED.get();
        growNetherWarts = GROW_NETHER_WARTS.get();
        witherRoses = WITHER_ROSES.get();
        witherVines = WITHER_VINES.get();
        witherGrass = WITHER_GRASS.get();
        placeSlimeBallPistons = PLACE_SLIME_BALLS_PISTONS.get();
        removeSlimeBallPistons = REMOVE_SLIME_BALLS_PISTONS.get();
        fillWaterBottleHydroRock = FILL_WATER_BOTTLE_HYDRO_ROCK.get();
        shearTallFlowers = SHEAR_TALL_FLOWERS.get();
        generateVillageStructures = GENERATE_VILLAGE_STRUCTURES.get();
    }
}
