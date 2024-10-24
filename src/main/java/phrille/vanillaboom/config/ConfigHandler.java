package phrille.vanillaboom.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;
import phrille.vanillaboom.VanillaBoom;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ConfigHandler {
    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onModConfigEvent(ModConfigEvent event) {
        ModConfig config = event.getConfig();

        if (config.getSpec() == COMMON_SPEC) {
            VanillaBoomConfig.bakeCommon(config);
            VanillaBoom.LOGGER.debug("Baked common config");
        }
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue growNetherWarts;
        public final ForgeConfigSpec.BooleanValue growWitherRoses;
        public final ForgeConfigSpec.BooleanValue placeSlimeBallPistons;
        public final ForgeConfigSpec.BooleanValue removeSlimeBallPistons;
        public final ForgeConfigSpec.BooleanValue fillWaterBottleHydroRock;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            growNetherWarts = builder.comment(" Set this to false to disable Wither Bone Meal being used to grow Nether Wart.").define("grow_nether_warts", true);
            growWitherRoses = builder.comment("\n Set this to false to disable Wither Bone Meal being used to grow Roses into Wither Roses.").define("grow_wither_roses", true);
            placeSlimeBallPistons = builder.comment("\n Set this to false to disable placing Slime Balls on Sticky Pistons when right clicking with a Slime Ball.").define("place_slime_ball_pistons", true);
            removeSlimeBallPistons = builder.comment("\n Set this to false to disable removing Slime Balls from Sticky Pistons when right clicking and crouching with an Axe.").define("remove_slime_ball_pistons", true);
            fillWaterBottleHydroRock = builder.comment("\n Set this to false to disable Glass Bottles being able to be filled up when right clicking a Hydro Rock block.").define("fill_water_bottle_hydro_rock", true);
            builder.pop();
        }
    }
}
