package phrille.vanillaboom.world;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class WorldGenEventHandler {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        Biome.BiomeCategory category = event.getCategory();
        BiomeGenerationSettingsBuilder gen = event.getGeneration();

        generateIfConfig(gen, GenerationStep.Decoration.UNDERGROUND_ORES, ModFeatures.PlacedFeatures.ORE_PERIDOTITE.getHolder().get(), VanillaBoomConfig.peridotiteGenEnabled);

        if (category == Biome.BiomeCategory.FOREST) {
            generateIfConfig(gen, GenerationStep.Decoration.VEGETAL_DECORATION, ModFeatures.PlacedFeatures.ROSE_PATCH.getHolder().get(), VanillaBoomConfig.roseGenEnabled);
        }

        if (category == Biome.BiomeCategory.OCEAN) {
            generateIfConfig(gen, GenerationStep.Decoration.UNDERGROUND_ORES, ModFeatures.PlacedFeatures.DISK_HYDRO_ROCK.getHolder().get(), VanillaBoomConfig.hydroRockGenEnabled);
        }

        if (category == Biome.BiomeCategory.NETHER) {
            generateIfConfig(gen, GenerationStep.Decoration.UNDERGROUND_ORES, ModFeatures.PlacedFeatures.ORE_INFERNAL_ROCK.getHolder().get(), VanillaBoomConfig.infernalRockGenEnabled);
            generateIfConfig(gen, GenerationStep.Decoration.UNDERGROUND_ORES, ModFeatures.PlacedFeatures.ORE_BONE_SAND.getHolder().get(), VanillaBoomConfig.boneSandGenEnabled);
            generateIfConfig(gen, GenerationStep.Decoration.UNDERGROUND_ORES, ModFeatures.PlacedFeatures.ORE_WITHER_BONE_SAND.getHolder().get(), VanillaBoomConfig.witherBoneSandGenEnabled);
        }
    }

    private static void generateIfConfig(BiomeGenerationSettingsBuilder gen, GenerationStep.Decoration step, Holder<PlacedFeature> feature, boolean config) {
        if (config) {
            gen.addFeature(step, feature);
        }
    }
}