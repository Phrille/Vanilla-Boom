package phrille.vanillaboom.world;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
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
        ResourceKey<Biome> biomeRegistryKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, biomeName);

        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OVERWORLD)) {
            generate(event, GenerationStep.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_PERIDOTITE, VanillaBoomConfig.peridotiteGenEnabled);
            generate(event, GenerationStep.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.ROSE_PATCHES, VanillaBoomConfig.roseGenEnabled);

            /**
             generate(event, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_FINE_GRAVEL, VanillaBoomConfig.fineGravelGenEnabled);

             if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OCEAN)) {
             generate(event, GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.DISK_HYDRO_ROCK, VanillaBoomConfig.hydroRockGenEnabled);
             }
             */

        }

        if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.NETHER)) {
            //generate(event, GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_INFERNAL_ROCK, VanillaBoomConfig.infernalRockGenEnabled);
            generate(event, GenerationStep.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_BONE_SAND, VanillaBoomConfig.boneSandGenEnabled);
            generate(event, GenerationStep.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_WITHER_BONE_SAND, VanillaBoomConfig.witherBoneSandGenEnabled);

            /**
             if (VanillaBoomConfig.netherWellGenEnabled && !biomeName.getPath().equals("basalt_deltas")) {
             event.getGeneration().getStructures().add(() -> ModConfiguredStructures.NETHER_WELL);
             }

             if (VanillaBoomConfig.graveGenEnabled && biomeName.getPath().equals("soul_sand_valley")) {
             event.getGeneration().getStructures().add(() -> ModConfiguredStructures.GRAVE);
             }
             */
        }
    }

    /**
     * @SubscribeEvent(priority = EventPriority.NORMAL)
     * public static void addDimensionalSpacing(WorldEvent.Load event) {
     * if (event.getWorld() instanceof ServerLevel) {
     * ServerLevel world = (ServerLevel) event.getWorld();
     * <p>
     * if (world.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator && world.getDimensionKey().equals(World.OVERWORLD)) {
     * return;
     * }
     * <p>
     * Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(world.getChunkProvider().generator.func_235957_b_().func_236195_a_());
     * tempMap.put(ModStructures.NETHER_WELL.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.NETHER_WELL.get()));
     * tempMap.put(ModStructures.GRAVE.get(), DimensionStructuresSettings.field_236191_b_.get(ModStructures.GRAVE.get()));
     * serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
     * }
     * }
     */

    public static void generate(BiomeLoadingEvent event, GenerationStep.Decoration decorationStage, ResourceKey<ConfiguredFeature<?, ?>> key, boolean config) {
        if (config) {
            event.getGeneration().addFeature(decorationStage, getFeature(key));
        }
    }

    private static ConfiguredFeature<?, ?> getFeature(ResourceKey<ConfiguredFeature<?, ?>> key) {
        return BuiltinRegistries.CONFIGURED_FEATURE.getOrThrow(key);
    }
}