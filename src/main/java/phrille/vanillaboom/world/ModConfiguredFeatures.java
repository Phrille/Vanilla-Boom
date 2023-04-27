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
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_HYDRO_ROCK = key("disk_hydro_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_PATCHES = key("rose_patches");

    //Nether
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_INFERNAL_ROCK = key("ore_infernal_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BONE_SAND = key("ore_bone_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_WITHER_BONE_SAND = key("ore_wither_bone_sand");

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(VanillaBoom.MOD_ID, name));
    }

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {

        @SubscribeEvent(priority = EventPriority.LOW)
        public static void register(RegistryEvent.Register<Feature<?>> event) {
            //OverWorld
            register(ORE_PERIDOTITE, Feature.ORE.configured(Configs.PERIDOTITE_CONFIG).rangeUniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(79)).squared().count(10));
            //register(DISK_HYDRO_ROCK, Feature.DISK.withConfiguration(new SphereReplaceConfig(ModBlocks.HYDRO_ROCK.getDefaultState(), FeatureSpread.func_242253_a(2, 1), 1, ImmutableList.of(Blocks.STONE.getDefaultState(), Blocks.GRAVEL.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));
            register(ROSE_PATCHES, Feature.FLOWER.configured(Configs.ROSE_CONFIG).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE));

            //Nether
            //register(ORE_INFERNAL_ROCK, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.INFERNAL_ROCK.getDefaultState(), 33)).withPlacement(Placement.MAGMA.configure(NoPlacementConfig.INSTANCE)).square().func_242731_b(4));
            register(ORE_BONE_SAND, Feature.ORE.configured(Configs.BONE_SAND_CONFIG).rangeUniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(90)).squared().count(10));
            register(ORE_WITHER_BONE_SAND, Feature.ORE.configured(Configs.WITHER_BONE_SAND_CONFIG).rangeUniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(62)).squared().count(8));
        }

        private static void register(ResourceKey<ConfiguredFeature<?, ?>> key, ConfiguredFeature<?, ?> configuredFeature) {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.location(), configuredFeature);
        }
    }

    public static final class Configs {
        //Overworld
        public static final OreConfiguration PERIDOTITE_CONFIG = new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.PERIDOTITE.defaultBlockState(), 33);
        public static final RandomPatchConfiguration ROSE_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.ROSE.defaultBlockState()), SimpleBlockPlacer.INSTANCE).tries(32).build();

        //Nether
        public static final OreConfiguration BONE_SAND_CONFIG = new OreConfiguration(Predicates.SOUL_SOIL, ModBlocks.BONE_SAND.defaultBlockState(), 29);
        public static final OreConfiguration WITHER_BONE_SAND_CONFIG = new OreConfiguration(Predicates.BONE_SAND, ModBlocks.WITHER_BONE_SAND.defaultBlockState(), 10);
    }

    public static final class Predicates {
        public static final RuleTest SOUL_SOIL = new BlockMatchTest(Blocks.SOUL_SOIL);
        public static final RuleTest BONE_SAND = new BlockMatchTest(ModBlocks.BONE_SAND);
    }
}