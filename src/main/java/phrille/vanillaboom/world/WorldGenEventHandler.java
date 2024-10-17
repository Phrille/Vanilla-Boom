package phrille.vanillaboom.world;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class WorldGenEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void addFeaturesToBiomes(BiomeLoadingEvent event) {

        ResourceLocation biomeName = Objects.requireNonNull(event.getName(), "Biome registry name was null");
        RegistryKey<Biome> biomeRegistryKey = RegistryKey.create(ForgeRegistries.Keys.BIOMES, biomeName);

        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OVERWORLD)) {
            generate(event, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_PERIDOTITE, VanillaBoomConfig.peridotiteGenEnabled);
            generate(event, GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.ROSE_PATCHES, VanillaBoomConfig.roseGenEnabled);

            if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OCEAN)) {
                generate(event, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.DISK_HYDRO_ROCK, VanillaBoomConfig.hydroRockGenEnabled);
            }
        }
        else if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.NETHER)) {
            generate(event, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_INFERNAL_ROCK, VanillaBoomConfig.infernalRockGenEnabled);
            generate(event, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_BONE_SAND, VanillaBoomConfig.boneSandGenEnabled);
            generate(event, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_WITHER_BONE_SAND, VanillaBoomConfig.witherBoneSandGenEnabled);
        }
    }

    public static void generate(BiomeLoadingEvent event, GenerationStage.Decoration decorationStage, RegistryKey<ConfiguredFeature<?, ?>> key, boolean config) {
        if (config) {
            event.getGeneration().addFeature(decorationStage, getFeature(key));
        }
    }

    private static ConfiguredFeature<?, ?> getFeature(RegistryKey<ConfiguredFeature<?, ?>> key) {
        return WorldGenRegistries.CONFIGURED_FEATURE.getOrThrow(key);
    }
}