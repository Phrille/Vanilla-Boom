package phrille.vanillaboom.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

import java.util.List;

public class ModFeatures {
    public static final class ConfiguredFeatures {
        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, VanillaBoom.MOD_ID);

        public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_PERIDOTITE = CONFIGURED_FEATURES.register("ore_peridotite", () -> new ConfiguredFeature<>(Feature.ORE, Configs.PERIDOTITE_CONFIG));
        public static final RegistryObject<ConfiguredFeature<?, ?>> DISK_HYDRO_ROCK = CONFIGURED_FEATURES.register("disk_hydro_rock", () -> new ConfiguredFeature<>(Feature.DISK, Configs.HYDRO_ROCK_CONFIG));
        public static final RegistryObject<ConfiguredFeature<?, ?>> ROSE_PATCH = CONFIGURED_FEATURES.register("rose_patch", () -> new ConfiguredFeature<>(Feature.FLOWER, Configs.ROSE_CONFIG));
        public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_INFERNAL_ROCK = CONFIGURED_FEATURES.register("ore_infernal_rock", () -> new ConfiguredFeature<>(Feature.ORE, Configs.INFERNAL_ROCK_CONFIG));
        public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_BONE_SAND = CONFIGURED_FEATURES.register("ore_bone_sand", () -> new ConfiguredFeature<>(Feature.ORE, Configs.BONE_SAND_CONFIG));
        public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_WITHER_BONE_SAND = CONFIGURED_FEATURES.register("ore_wither_bone_sand", () -> new ConfiguredFeature<>(Feature.ORE, Configs.WITHER_BONE_SAND_CONFIG));
    }

    public static final class PlacedFeatures {
        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, VanillaBoom.MOD_ID);

        public static final RegistryObject<PlacedFeature> ORE_PERIDOTITE = register("ore_peridotite", ConfiguredFeatures.ORE_PERIDOTITE, makeOrePlacement(10, 20, 79));
        public static final RegistryObject<PlacedFeature> DISK_HYDRO_ROCK = register("disk_hydro_rock", ConfiguredFeatures.DISK_HYDRO_ROCK, makeDiskPlacement());
        public static final RegistryObject<PlacedFeature> ROSE_PATCH = register("rose_patch", ConfiguredFeatures.ROSE_PATCH, makeFlowerPlacement(16));
        public static final RegistryObject<PlacedFeature> ORE_INFERNAL_ROCK = register("ore_infernal_rock", ConfiguredFeatures.ORE_INFERNAL_ROCK, makeOrePlacement(2, 30, 41));
        public static final RegistryObject<PlacedFeature> ORE_BONE_SAND = register("ore_bone_sand", ConfiguredFeatures.ORE_BONE_SAND, makeOrePlacement(5, 40, 105));
        public static final RegistryObject<PlacedFeature> ORE_WITHER_BONE_SAND = register("ore_wither_bone_sand", ConfiguredFeatures.ORE_WITHER_BONE_SAND, makeOrePlacement(30, 40, 105));

        private static List<PlacementModifier> makeOrePlacement(int count, int min, int max) {
            return List.of(CountPlacement.of(count), HeightRangePlacement.uniform(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max)), InSquarePlacement.spread(), BiomeFilter.biome());
        }

        private static List<PlacementModifier> makeDiskPlacement() {
            return List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
        }

        private static List<PlacementModifier> makeFlowerPlacement(int chance) {
            return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        }

        private static RegistryObject<PlacedFeature> register(String name, RegistryObject<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placementModifiers) {
            return PLACED_FEATURES.register(name, () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) feature.getHolder().get(), ImmutableList.copyOf(placementModifiers)));
        }
    }

    public static final class Configs {
        public static final OreConfiguration PERIDOTITE_CONFIG = new OreConfiguration(OreFeatures.NATURAL_STONE, ModBlocks.PERIDOTITE.get().defaultBlockState(), 33);
        public static final RandomPatchConfiguration ROSE_CONFIG = new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ROSE.get()))));
        public static final DiskConfiguration HYDRO_ROCK_CONFIG = new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.HYDRO_ROCK.get()), BlockPredicate.matchesBlocks(List.of(Blocks.STONE, Blocks.GRAVEL)), UniformInt.of(1, 3), 2);
        public static final OreConfiguration INFERNAL_ROCK_CONFIG = new OreConfiguration(Predicates.NETHERRACK, ModBlocks.INFERNAL_ROCK.get().defaultBlockState(), 33);
        public static final OreConfiguration BONE_SAND_CONFIG = new OreConfiguration(Predicates.SOUL_SOIL, ModBlocks.BONE_SAND.get().defaultBlockState(), 29);
        public static final OreConfiguration WITHER_BONE_SAND_CONFIG = new OreConfiguration(Predicates.BONE_SAND, ModBlocks.WITHER_BONE_SAND.get().defaultBlockState(), 18);
    }

    public static final class Predicates {
        public static final RuleTest SOUL_SOIL = new BlockMatchTest(Blocks.SOUL_SOIL);
        public static final RuleTest BONE_SAND = new BlockMatchTest(ModBlocks.BONE_SAND.get());
        public static final RuleTest NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);
    }
}