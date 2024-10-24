package phrille.vanillaboom.config;

import net.minecraftforge.fml.config.ModConfig;

public class VanillaBoomConfig {
    public static boolean witherBoneMealEnabled;
    public static boolean growNetherWarts;
    public static boolean growWitherRoses;
    public static boolean witherVines;
    public static boolean placeSlimeBallPistons;
    public static boolean removeSlimeBallPistons;
    public static boolean fillWaterBottleHydroRock;
    public static boolean shearRoseBushes;

    @SuppressWarnings("unused")
    public static void bakeCommon(ModConfig config) {
        witherBoneMealEnabled = ConfigHandler.COMMON.witherBoneMealEnabled.get();
        growNetherWarts = ConfigHandler.COMMON.growNetherWarts.get();
        growWitherRoses = ConfigHandler.COMMON.growWitherRoses.get();
        witherVines = ConfigHandler.COMMON.witherVines.get();
        placeSlimeBallPistons = ConfigHandler.COMMON.placeSlimeBallPistons.get();
        removeSlimeBallPistons = ConfigHandler.COMMON.removeSlimeBallPistons.get();
        fillWaterBottleHydroRock = ConfigHandler.COMMON.fillWaterBottleHydroRock.get();
        shearRoseBushes = ConfigHandler.COMMON.shearRoseBushes.get();
    }
}