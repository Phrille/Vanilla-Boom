package phrille.vanillaboom.world;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModConfiguredFeatures {
    //Overworld
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PERIDOTITE = key("ore_peridotite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_FINE_GRAVEL = key("ore_fine_gravel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_HYDRO_ROCK = key("disk_hydro_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_PATCHES = key("rose_patches");

    //Nether
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_INFERNAL_ROCK = key("ore_infernal_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BONE_SAND = key("ore_bone_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_WITHER_BONE_SAND = key("ore_wither_bone_sand");

    public static final RuleTest SOUL_SOIL_FILLER = new BlockMatchTest(Blocks.SOUL_SOIL);

    private static ResourceKey<ConfiguredFeature<?, ?>> key(final String name) {
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(VanillaBoom.MOD_ID, name));
    }

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {

        @SubscribeEvent(priority = EventPriority.LOW)
        public static void register(final RegistryEvent.Register<Feature<?>> event) {
            //OverWorld
            register(ORE_PERIDOTITE, Feature.ORE.configured(Configs.PERIDOTITE_CONFIG).rangeUniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(79)).squared().count(10));
            //register(DISK_HYDRO_ROCK, Feature.DISK.withConfiguration(new SphereReplaceConfig(ModBlocks.HYDRO_ROCK.getDefaultState(), FeatureSpread.func_242253_a(2, 1), 1, ImmutableList.of(Blocks.STONE.getDefaultState(), Blocks.GRAVEL.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));
            register(ROSE_PATCHES, Feature.FLOWER.configured(Configs.ROSE_CONFIG).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE));

            //Nether
            //register(ORE_INFERNAL_ROCK, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.INFERNAL_ROCK.getDefaultState(), 33)).withPlacement(Placement.MAGMA.configure(NoPlacementConfig.INSTANCE)).square().func_242731_b(4));
            //register(ORE_BONE_SAND, Feature.ORE.withConfiguration(new OreFeatureConfig(SOUL_SOIL_FILLER, ModBlocks.BONE_SAND.getDefaultState(), 26)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(16));
            //register(ORE_WITHER_BONE_SAND, Feature.ORE.withConfiguration(new OreFeatureConfig(SOUL_SOIL_FILLER, ModBlocks.WITHER_BONE_SAND.getDefaultState(), 12)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(10));
        }

        private static void register(final ResourceKey<ConfiguredFeature<?, ?>> key, final ConfiguredFeature<?, ?> configuredFeature) {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.location(), configuredFeature);
        }
    }

    public static final class Configs {
        public static final OreConfiguration PERIDOTITE_CONFIG = new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.PERIDOTITE.defaultBlockState(), 33);
        public static final RandomPatchConfiguration ROSE_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.ROSE.defaultBlockState()), SimpleBlockPlacer.INSTANCE).tries(32).build();
    }
}