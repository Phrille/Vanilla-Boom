package phrille.vanillaboom.config;

import net.minecraftforge.fml.config.ModConfig;

public class VanillaBoomConfig {
    // General
    public static boolean growNetherWarts;
    public static boolean growWitherRoses;
    public static boolean placeSlimeBallPistons;
    public static boolean removeSlimeBallPistons;
    public static boolean fillWaterBottleHydroRock;

    // Worldgen Overworld
    public static boolean peridotiteGenEnabled;
    public static boolean hydroRockGenEnabled;
    public static boolean roseGenEnabled;

    // Worldgen Nether
    public static boolean infernalRockGenEnabled;
    public static boolean boneSandGenEnabled;
    public static boolean witherBoneSandGenEnabled;


    public static void bakeCommon(ModConfig config) {
        growNetherWarts = ConfigHandler.COMMON.growNetherWarts.get();
        growWitherRoses = ConfigHandler.COMMON.growWitherRoses.get();
        placeSlimeBallPistons = ConfigHandler.COMMON.placeSlimeBallPistons.get();
        removeSlimeBallPistons = ConfigHandler.COMMON.removeSlimeBallPistons.get();
        fillWaterBottleHydroRock = ConfigHandler.COMMON.fillWaterBottleHydroRock.get();

        peridotiteGenEnabled = ConfigHandler.COMMON.peridotiteGenEnabled.get();
        hydroRockGenEnabled = ConfigHandler.COMMON.hydroRockGenEnabled.get();
        roseGenEnabled = ConfigHandler.COMMON.roseGenEnabled.get();

        infernalRockGenEnabled = ConfigHandler.COMMON.infernalRockGenEnabled.get();
        boneSandGenEnabled = ConfigHandler.COMMON.boneSandGenEnabled.get();
        witherBoneSandGenEnabled = ConfigHandler.COMMON.witherBoneSandGenEnabled.get();
    }
}