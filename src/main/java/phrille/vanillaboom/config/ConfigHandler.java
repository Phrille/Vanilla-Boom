package phrille.vanillaboom.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import phrille.vanillaboom.VanillaBoom;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ConfigHandler
{
    public static class Client
    {
        public final ForgeConfigSpec.BooleanValue addFoodTooltips;

        public Client(ForgeConfigSpec.Builder builder)
        {
            builder.push("general");
            
            addFoodTooltips = builder.comment(" Set this to false to disable food icons being added to tooltips").define("add_food_tool_tips", true);
            
            builder.pop();
        }
    }

    public static final Client CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static
    {
        Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static class Common
    {
        //General
        public final ForgeConfigSpec.BooleanValue growNetherWarts;
        public final ForgeConfigSpec.BooleanValue growWitherRoses;
        public final ForgeConfigSpec.BooleanValue removeSlimeBallPistons;
        public final ForgeConfigSpec.BooleanValue fillWaterBottleHydroRock;

        //Worldgen Overworld
        public final ForgeConfigSpec.BooleanValue peridotiteGenEnabled;
        public final ForgeConfigSpec.BooleanValue fineGravelGenEnabled;
        public final ForgeConfigSpec.BooleanValue hydroRockGenEnabled;
        public final ForgeConfigSpec.BooleanValue roseGenEnabled;

        //Worldgen Nether
        public final ForgeConfigSpec.BooleanValue infernalRockGenEnabled;
        public final ForgeConfigSpec.BooleanValue boneSandGenEnabled;
        public final ForgeConfigSpec.BooleanValue witherBoneSandGenEnabled;

        public final ForgeConfigSpec.BooleanValue netherWellGenEnabled;
        public final ForgeConfigSpec.IntValue netherWellMinChunk;
        public final ForgeConfigSpec.IntValue netherWellMaxChunk;

        public final ForgeConfigSpec.BooleanValue graveGenEnabled;
        public final ForgeConfigSpec.IntValue gravelMinChunk;
        public final ForgeConfigSpec.IntValue graveMaxChunk;

        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("general");

            growNetherWarts = builder.comment(" Set this to false to disable Blaze Powder or Wither Bone Meal being used to grow Nether Wart.").define("grow_nether_warts", true);
            growWitherRoses = builder.comment("\n Set this to false to disable Wither Bone Meal being used to grow Roses into Wither Roses.").define("grow_wither_roses", true);
            removeSlimeBallPistons = builder.comment("\n Set this to false to disable removing a Slime Ball from a Sticky Piston when right clickling and crouching with a Shovel.").define("remove_slime_ball_pistons", true);
            fillWaterBottleHydroRock = builder.comment("\n Set this to false to disable Glass Bottles being able to be filled up when right clickling a Hydro Rock block.").define("fill_water_bottle_hydro_rock", true);

            builder.pop();
            builder.comment(" Warning: \n Changing world gen config options will require \n the world to be reloaded to take action. \n For servers this means a server restart.");
            builder.push("worldgen");

            peridotiteGenEnabled = builder.comment(" Set this to false to stop Peridotite being generated in the Overworld.").define("peridotite_gen", true);
            fineGravelGenEnabled = builder.comment("\n Set this to false to stop Fine Gravel being generated in the Overworld.").define("fine_gravel_gen", true);
            hydroRockGenEnabled = builder.comment("\n Set this to false to stop Hydro Rock being generated in the Overworld.").define("hydro_rock_gen", true);
            roseGenEnabled = builder.comment("\n Set this to false to stop Roses being generated in the Overworld.").define("rose_gen", true);

            infernalRockGenEnabled = builder.comment("\n Set this to false to stop Infernal Rock being generated in the Nether.").define("infernal_rock_gen", true);
            boneSandGenEnabled = builder.comment("\n Set this to false to stop Bone Sand being generated in the Nether.").define("bone_sand_gen", true);
            witherBoneSandGenEnabled = builder.comment("\n Set this to false to stop Wither Bone Sand being generated in the Nether.").define("wither_bone_sand_gen", true);

            netherWellGenEnabled = builder.comment("\n Set this to false to stop Nether Wells being generated in the Nether.").define("nether_well_gen", true);
            netherWellMinChunk = builder.comment("Minium chunk distance between Nether Wells").defineInRange("nether_well_min_chunk", 3, 1, Integer.MAX_VALUE);
            netherWellMaxChunk = builder.comment("Maximum chunk distance between Nether Wells").defineInRange("nether_well_max_chunk", 7, 2, Integer.MAX_VALUE);

            graveGenEnabled = builder.comment("\n Set this to false to stop Graves being generated in the Nether.").define("grave_gen", true);
            gravelMinChunk = builder.comment("Minium chunk distance between Graves").defineInRange("grave_min_chunk", 3, 1, Integer.MAX_VALUE);
            graveMaxChunk = builder.comment("Maximum chunk distance between Graves").defineInRange("grave_max_chunk", 5, 2, Integer.MAX_VALUE);

            builder.pop();
        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static
    {
        Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onModConfigEvent(ModConfig.ModConfigEvent event)
    {
        ModConfig config = event.getConfig();

        if (config.getSpec() == CLIENT_SPEC)
        {
            VanillaBoomConfig.bakeClient(config);
            VanillaBoom.LOGGER.debug("Baked client config");
        }
        else if (config.getSpec() == COMMON_SPEC)
        {
            VanillaBoomConfig.bakeCommon(config);
            VanillaBoom.LOGGER.debug("Baked common config");
        }
    }
}
