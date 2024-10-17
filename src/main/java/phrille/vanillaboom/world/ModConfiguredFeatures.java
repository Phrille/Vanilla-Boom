package phrille.vanillaboom.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModConfiguredFeatures {
    //Overworld
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PERIDOTITE = key("ore_peridotite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DISK_HYDRO_ROCK = key("disk_hydro_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROSE_PATCHES = key("rose_patches");

    //Nether
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_INFERNAL_ROCK = key("ore_infernal_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_BONE_SAND = key("ore_bone_sand");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_WITHER_BONE_SAND = key("ore_wither_bone_sand");

    private static RegistryKey<ConfiguredFeature<?, ?>> key(String name) {
        return RegistryKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(VanillaBoom.MOD_ID, name));
    }

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {

        @SubscribeEvent(priority = EventPriority.LOW)
        public static void register(RegistryEvent.Register<Feature<?>> event) {
            //OverWorld
            register(ORE_PERIDOTITE, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.PERIDOTITE.get().defaultBlockState(), 33)).range(80).squared().count(10));
            register(DISK_HYDRO_ROCK, Feature.DISK.configured(new SphereReplaceConfig(ModBlocks.HYDRO_ROCK.get().defaultBlockState(), FeatureSpread.of(2, 1), 1, ImmutableList.of(Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()))).decorated(Features.Placements.TOP_SOLID_HEIGHTMAP_SQUARE));
            register(ROSE_PATCHES, Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.ROSE.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(32).build()).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));

            //Nether
            register(ORE_INFERNAL_ROCK, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.INFERNAL_ROCK.get().defaultBlockState(), 33)).decorated(Placement.MAGMA.configured(NoPlacementConfig.INSTANCE)).squared().count(4));
            register(ORE_BONE_SAND, Feature.ORE.configured(new OreFeatureConfig(Predicates.SOUL_SOIL_FILLER, ModBlocks.BONE_SAND.get().defaultBlockState(), 26)).decorated(Features.Placements.RANGE_10_20_ROOFED).squared().count(16));
            register(ORE_WITHER_BONE_SAND, Feature.ORE.configured(new OreFeatureConfig(Predicates.SOUL_SOIL_FILLER, ModBlocks.WITHER_BONE_SAND.get().defaultBlockState(), 12)).decorated(Features.Placements.RANGE_10_20_ROOFED).squared().count(10));
        }

        private static void register(RegistryKey<ConfiguredFeature<?, ?>> key, ConfiguredFeature<?, ?> configuredFeature) {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key.location(), configuredFeature);
        }
    }

    public static final class Predicates {
        public static final RuleTest SOUL_SOIL_FILLER = new BlockMatchRuleTest(Blocks.SOUL_SOIL);
    }
}