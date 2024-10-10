package phrille.vanillaboom.config;

import net.minecraftforge.fml.config.ModConfig;

public class VanillaBoomConfig {
    //General
    public static boolean growNetherWarts;
    public static boolean growWitherRoses;
    public static boolean placeSlimeBallPistons;
    public static boolean removeSlimeBallPistons;
    public static boolean fillWaterBottleHydroRock;

    public static void bakeCommon(ModConfig config) {
        growNetherWarts = ConfigHandler.COMMON.growNetherWarts.get();
        growWitherRoses = ConfigHandler.COMMON.growWitherRoses.get();
        placeSlimeBallPistons = ConfigHandler.COMMON.placeSlimeBallPistons.get();
        removeSlimeBallPistons = ConfigHandler.COMMON.removeSlimeBallPistons.get();
        fillWaterBottleHydroRock = ConfigHandler.COMMON.fillWaterBottleHydroRock.get();
    }
}