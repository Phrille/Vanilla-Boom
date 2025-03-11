package phrille.vanillaboom.data;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.data.loot.ModBlockLootTables;
import phrille.vanillaboom.data.loot.ModGlobalLootModifierProvider;
import phrille.vanillaboom.data.tags.ModBlockTagsProvider;
import phrille.vanillaboom.data.tags.ModEntityTypeTagsProvider;
import phrille.vanillaboom.data.tags.ModItemTagsProvider;
import phrille.vanillaboom.util.ModDamageTypes;
import phrille.vanillaboom.util.Utils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    public static final List<Pair<Block, ResourceLocation>> STAIRS = Lists.newArrayList();
    public static final List<Pair<Block, ResourceLocation>> SLABS = Lists.newArrayList();
    public static final List<Block> WALLS = Lists.newArrayList();
    public static final List<Pair<Block, Block>> FENCES = Lists.newArrayList();
    public static final List<Pair<Block, Block>> FENCE_GATES = Lists.newArrayList();

    private static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder()
            .add(Registries.DAMAGE_TYPE, ModDataGenerator::bootstrap);

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        init();

        // Assets
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(output));

        // Data
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(output, lookupProvider, blockTags, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModEntityTypeTagsProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output));
        List<LootTableProvider.SubProviderEntry> subProviders = List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), subProviders));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(output));
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, lookupProvider, REGISTRY_SET_BUILDER, Set.of(VanillaBoom.MOD_ID)));
    }

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(ModDamageTypes.CHILI, new DamageType("vanillaboom.chili", DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.3F, DamageEffects.BURNING));
    }

    private static void init() {
        addStairs();
        addSlabs();
        addWalls();
        addFences();
        addFenceGates();
        Utils.registerCandleCakes();
    }

    private static void addStairs() {
        // Stairs
        addStair(ModBlocks.COBBLESTONE_BRICK_STAIRS.get());
        addStair(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get());
        addStair(ModBlocks.MAGMA_BRICK_STAIRS.get());
        addStair(ModBlocks.OBSIDIAN_BRICK_STAIRS.get());
        addStair(ModBlocks.SNOW_BRICK_STAIRS.get());
        addStair(ModBlocks.TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get());
        addStair(ModBlocks.PERIDOTITE_STAIRS.get());
        addStair(ModBlocks.HYDRO_ROCK_STAIRS.get());
        addStair(ModBlocks.INFERNAL_ROCK_STAIRS.get());
        addStair(ModBlocks.POLISHED_PERIDOTITE_STAIRS.get());
        addStair(ModBlocks.POLISHED_PRISMARINE_STAIRS.get());
        addStair(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS.get());
        addStair(ModBlocks.POLISHED_END_STONE_STAIRS.get());
        addStair(ModBlocks.POLISHED_NETHERRACK_STAIRS.get());
        addStair(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get());
        addStair(ModBlocks.CHISELED_RED_NETHER_BRICK_STAIRS.get());
        addStair(ModBlocks.CHISELED_PURPUR_BLOCK_STAIRS.get());
        addStair(ModBlocks.CHISELED_OBSIDIAN_STAIRS.get());

        // Vanilla Stairs
        addStair(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get());
        addStair(ModBlocks.CHISELED_STONE_BRICK_STAIRS.get());
        addStair(ModBlocks.CHISELED_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.SANDSTONE), "_top"));
        addStair(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        addStair(ModBlocks.IRON_BLOCK_STAIRS.get());
        addStair(ModBlocks.GOLD_BLOCK_STAIRS.get());
        addStair(ModBlocks.OBSIDIAN_STAIRS.get());
        addStair(ModBlocks.BEDROCK_STAIRS.get());
        addStair(ModBlocks.NETHERRACK_STAIRS.get());
        addStair(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get());
        addStair(ModBlocks.CHISELED_NETHER_BRICK_STAIRS.get());
        addStair(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
        addStair(ModBlocks.CHISELED_POLISHED_BLACKSTONE_STAIRS.get());
        addStair(ModBlocks.END_STONE_STAIRS.get());
        addStair(ModBlocks.CHISELED_QUARTZ_BLOCK_STAIRS.get());
        addStair(ModBlocks.QUARTZ_BRICK_STAIRS.get());
        addStair(ModBlocks.TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.WHITE_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.LIME_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.PINK_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.GRAY_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.CYAN_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.BLUE_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.BROWN_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.GREEN_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.RED_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.BLACK_TERRACOTTA_STAIRS.get());
        addStair(ModBlocks.WHITE_CONCRETE_STAIRS.get());
        addStair(ModBlocks.ORANGE_CONCRETE_STAIRS.get());
        addStair(ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
        addStair(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
        addStair(ModBlocks.YELLOW_CONCRETE_STAIRS.get());
        addStair(ModBlocks.LIME_CONCRETE_STAIRS.get());
        addStair(ModBlocks.PINK_CONCRETE_STAIRS.get());
        addStair(ModBlocks.GRAY_CONCRETE_STAIRS.get());
        addStair(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
        addStair(ModBlocks.CYAN_CONCRETE_STAIRS.get());
        addStair(ModBlocks.PURPLE_CONCRETE_STAIRS.get());
        addStair(ModBlocks.BLUE_CONCRETE_STAIRS.get());
        addStair(ModBlocks.BROWN_CONCRETE_STAIRS.get());
        addStair(ModBlocks.GREEN_CONCRETE_STAIRS.get());
        addStair(ModBlocks.RED_CONCRETE_STAIRS.get());
        addStair(ModBlocks.BLACK_CONCRETE_STAIRS.get());
        addStair(ModBlocks.OAK_WOOD_STAIRS.get());
        addStair(ModBlocks.SPRUCE_WOOD_STAIRS.get());
        addStair(ModBlocks.BIRCH_WOOD_STAIRS.get());
        addStair(ModBlocks.JUNGLE_WOOD_STAIRS.get());
        addStair(ModBlocks.ACACIA_WOOD_STAIRS.get());
        addStair(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
        addStair(ModBlocks.CRIMSON_HYPHAE_STAIRS.get());
        addStair(ModBlocks.WARPED_HYPHAE_STAIRS.get());
        addStair(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get());
        addStair(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get());
        addStair(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get());
        addStair(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get());
        addStair(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get());
        addStair(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get());
        addStair(ModBlocks.STRIPPED_CRIMSON_HYPHAE_STAIRS.get());
        addStair(ModBlocks.STRIPPED_WARPED_HYPHAE_STAIRS.get());
        addStair(ModBlocks.CUT_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.SANDSTONE), "_top"));
        addStair(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get(), extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        addStair(ModBlocks.SMOOTH_STONE_STAIRS.get());
    }

    private static void addSlabs() {
        // Slabs
        addSlab(ModBlocks.COBBLESTONE_BRICK_SLAB.get());
        addSlab(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get());
        addSlab(ModBlocks.MAGMA_BRICK_SLAB.get());
        addSlab(ModBlocks.OBSIDIAN_BRICK_SLAB.get());
        addSlab(ModBlocks.SNOW_BRICK_SLAB.get());
        addSlab(ModBlocks.TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get());
        addSlab(ModBlocks.PERIDOTITE_SLAB.get());
        addSlab(ModBlocks.HYDRO_ROCK_SLAB.get());
        addSlab(ModBlocks.INFERNAL_ROCK_SLAB.get());
        addSlab(ModBlocks.POLISHED_PERIDOTITE_SLAB.get());
        addSlab(ModBlocks.POLISHED_PRISMARINE_SLAB.get());
        addSlab(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB.get());
        addSlab(ModBlocks.POLISHED_END_STONE_SLAB.get());
        addSlab(ModBlocks.POLISHED_NETHERRACK_SLAB.get());
        addSlab(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get());
        addSlab(ModBlocks.CHISELED_RED_NETHER_BRICK_SLAB.get());
        addSlab(ModBlocks.CHISELED_PURPUR_BLOCK_SLAB.get());
        addSlab(ModBlocks.CHISELED_OBSIDIAN_SLAB.get());

        // Vanilla Slabs
        addSlab(ModBlocks.CRACKED_STONE_BRICK_SLAB.get());
        addSlab(ModBlocks.CHISELED_STONE_BRICK_SLAB.get());
        addSlab(ModBlocks.CHISELED_SANDSTONE_SLAB.get(), ModDataGenerator.extend(blockTexture(Blocks.SANDSTONE), "_top"));
        addSlab(ModBlocks.CHISELED_RED_SANDSTONE_SLAB.get(), ModDataGenerator.extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
        addSlab(ModBlocks.IRON_BLOCK_SLAB.get());
        addSlab(ModBlocks.GOLD_BLOCK_SLAB.get());
        addSlab(ModBlocks.OBSIDIAN_SLAB.get());
        addSlab(ModBlocks.BEDROCK_SLAB.get());
        addSlab(ModBlocks.NETHERRACK_SLAB.get());
        addSlab(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get());
        addSlab(ModBlocks.CHISELED_NETHER_BRICK_SLAB.get());
        addSlab(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get());
        addSlab(ModBlocks.CHISELED_POLISHED_BLACKSTONE_SLAB.get());
        addSlab(ModBlocks.END_STONE_SLAB.get());
        addSlab(ModBlocks.CHISELED_QUARTZ_BLOCK_SLAB.get());
        addSlab(ModBlocks.QUARTZ_BRICK_SLAB.get());
        addSlab(ModBlocks.TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.WHITE_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.ORANGE_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.YELLOW_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.LIME_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.PINK_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.GRAY_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.CYAN_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.PURPLE_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.BLUE_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.BROWN_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.GREEN_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.RED_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.BLACK_TERRACOTTA_SLAB.get());
        addSlab(ModBlocks.WHITE_CONCRETE_SLAB.get());
        addSlab(ModBlocks.ORANGE_CONCRETE_SLAB.get());
        addSlab(ModBlocks.MAGENTA_CONCRETE_SLAB.get());
        addSlab(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());
        addSlab(ModBlocks.YELLOW_CONCRETE_SLAB.get());
        addSlab(ModBlocks.LIME_CONCRETE_SLAB.get());
        addSlab(ModBlocks.PINK_CONCRETE_SLAB.get());
        addSlab(ModBlocks.GRAY_CONCRETE_SLAB.get());
        addSlab(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());
        addSlab(ModBlocks.CYAN_CONCRETE_SLAB.get());
        addSlab(ModBlocks.PURPLE_CONCRETE_SLAB.get());
        addSlab(ModBlocks.BLUE_CONCRETE_SLAB.get());
        addSlab(ModBlocks.BROWN_CONCRETE_SLAB.get());
        addSlab(ModBlocks.GREEN_CONCRETE_SLAB.get());
        addSlab(ModBlocks.RED_CONCRETE_SLAB.get());
        addSlab(ModBlocks.BLACK_CONCRETE_SLAB.get());
        addSlab(ModBlocks.OAK_WOOD_SLAB.get());
        addSlab(ModBlocks.SPRUCE_WOOD_SLAB.get());
        addSlab(ModBlocks.BIRCH_WOOD_SLAB.get());
        addSlab(ModBlocks.JUNGLE_WOOD_SLAB.get());
        addSlab(ModBlocks.ACACIA_WOOD_SLAB.get());
        addSlab(ModBlocks.DARK_OAK_WOOD_SLAB.get());
        addSlab(ModBlocks.CRIMSON_HYPHAE_SLAB.get());
        addSlab(ModBlocks.WARPED_HYPHAE_SLAB.get());
        addSlab(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get());
        addSlab(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get());
        addSlab(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get());
        addSlab(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get());
        addSlab(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get());
        addSlab(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get());
        addSlab(ModBlocks.STRIPPED_CRIMSON_HYPHAE_SLAB.get());
        addSlab(ModBlocks.STRIPPED_WARPED_HYPHAE_SLAB.get());
    }

    private static void addWalls() {
        // VanillaBoom Walls
        addWall(ModBlocks.COBBLESTONE_BRICK_WALL.get());
        addWall(ModBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get());
        addWall(ModBlocks.MAGMA_BRICK_WALL.get());
        addWall(ModBlocks.OBSIDIAN_BRICK_WALL.get());
        addWall(ModBlocks.SNOW_BRICK_WALL.get());
        addWall(ModBlocks.TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.RED_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get());
        addWall(ModBlocks.PERIDOTITE_WALL.get());
        addWall(ModBlocks.HYDRO_ROCK_WALL.get());
        addWall(ModBlocks.INFERNAL_ROCK_WALL.get());
        addWall(ModBlocks.POLISHED_PERIDOTITE_WALL.get());
        addWall(ModBlocks.POLISHED_PRISMARINE_WALL.get());
        addWall(ModBlocks.POLISHED_DARK_PRISMARINE_WALL.get());
        addWall(ModBlocks.POLISHED_END_STONE_WALL.get());
        addWall(ModBlocks.POLISHED_NETHERRACK_WALL.get());
        addWall(ModBlocks.CHISELED_PURPUR_BLOCK_WALL.get());
        addWall(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get());
        addWall(ModBlocks.CHISELED_RED_NETHER_BRICK_WALL.get());
        addWall(ModBlocks.CHISELED_OBSIDIAN_WALL.get());

        // Vanilla Walls
        addWall(ModBlocks.CRACKED_STONE_BRICK_WALL.get());
        addWall(ModBlocks.CHISELED_STONE_BRICK_WALL.get());
        addWall(ModBlocks.CHISELED_SANDSTONE_WALL.get());
        addWall(ModBlocks.CHISELED_RED_SANDSTONE_WALL.get());
        addWall(ModBlocks.IRON_BLOCK_WALL.get());
        addWall(ModBlocks.GOLD_BLOCK_WALL.get());
        addWall(ModBlocks.OBSIDIAN_WALL.get());
        addWall(ModBlocks.BEDROCK_WALL.get());
        addWall(ModBlocks.NETHERRACK_WALL.get());
        addWall(ModBlocks.CRACKED_NETHER_BRICK_WALL.get());
        addWall(ModBlocks.CHISELED_NETHER_BRICK_WALL.get());
        addWall(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get());
        addWall(ModBlocks.CHISELED_POLISHED_BLACKSTONE_WALL.get());
        addWall(ModBlocks.END_STONE_WALL.get());
        addWall(ModBlocks.CHISELED_QUARTZ_BLOCK_WALL.get());
        addWall(ModBlocks.QUARTZ_BRICK_WALL.get());
        addWall(ModBlocks.TERRACOTTA_WALL.get());
        addWall(ModBlocks.WHITE_TERRACOTTA_WALL.get());
        addWall(ModBlocks.ORANGE_TERRACOTTA_WALL.get());
        addWall(ModBlocks.MAGENTA_TERRACOTTA_WALL.get());
        addWall(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
        addWall(ModBlocks.YELLOW_TERRACOTTA_WALL.get());
        addWall(ModBlocks.LIME_TERRACOTTA_WALL.get());
        addWall(ModBlocks.PINK_TERRACOTTA_WALL.get());
        addWall(ModBlocks.GRAY_TERRACOTTA_WALL.get());
        addWall(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
        addWall(ModBlocks.CYAN_TERRACOTTA_WALL.get());
        addWall(ModBlocks.PURPLE_TERRACOTTA_WALL.get());
        addWall(ModBlocks.BLUE_TERRACOTTA_WALL.get());
        addWall(ModBlocks.BROWN_TERRACOTTA_WALL.get());
        addWall(ModBlocks.GREEN_TERRACOTTA_WALL.get());
        addWall(ModBlocks.RED_TERRACOTTA_WALL.get());
        addWall(ModBlocks.BLACK_TERRACOTTA_WALL.get());
        addWall(ModBlocks.WHITE_CONCRETE_WALL.get());
        addWall(ModBlocks.ORANGE_CONCRETE_WALL.get());
        addWall(ModBlocks.MAGENTA_CONCRETE_WALL.get());
        addWall(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
        addWall(ModBlocks.YELLOW_CONCRETE_WALL.get());
        addWall(ModBlocks.LIME_CONCRETE_WALL.get());
        addWall(ModBlocks.PINK_CONCRETE_WALL.get());
        addWall(ModBlocks.GRAY_CONCRETE_WALL.get());
        addWall(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
        addWall(ModBlocks.CYAN_CONCRETE_WALL.get());
        addWall(ModBlocks.PURPLE_CONCRETE_WALL.get());
        addWall(ModBlocks.BLUE_CONCRETE_WALL.get());
        addWall(ModBlocks.BROWN_CONCRETE_WALL.get());
        addWall(ModBlocks.GREEN_CONCRETE_WALL.get());
        addWall(ModBlocks.RED_CONCRETE_WALL.get());
        addWall(ModBlocks.BLACK_CONCRETE_WALL.get());
        addWall(ModBlocks.CUT_SANDSTONE_WALL.get());
        addWall(ModBlocks.CUT_RED_SANDSTONE_WALL.get());
        addWall(ModBlocks.SMOOTH_STONE_WALL.get());
        addWall(ModBlocks.STONE_WALL.get());
        addWall(ModBlocks.POLISHED_GRANITE_WALL.get());
        addWall(ModBlocks.POLISHED_DIORITE_WALL.get());
        addWall(ModBlocks.POLISHED_ANDESITE_WALL.get());
        addWall(ModBlocks.SMOOTH_SANDSTONE_WALL.get());
        addWall(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get());
        addWall(ModBlocks.PURPUR_BLOCK_WALL.get());
        addWall(ModBlocks.QUARTZ_BLOCK_WALL.get());
        addWall(ModBlocks.SMOOTH_QUARTZ_WALL.get());
        addWall(ModBlocks.PRISMARINE_BRICK_WALL.get());
        addWall(ModBlocks.DARK_PRISMARINE_WALL.get());
    }

    private static void addFences() {
        addFence(ModBlocks.OAK_WOOD_FENCE.get(), Blocks.OAK_WOOD);
        addFence(ModBlocks.SPRUCE_WOOD_FENCE.get(), Blocks.SPRUCE_WOOD);
        addFence(ModBlocks.BIRCH_WOOD_FENCE.get(), Blocks.BIRCH_WOOD);
        addFence(ModBlocks.JUNGLE_WOOD_FENCE.get(), Blocks.JUNGLE_WOOD);
        addFence(ModBlocks.ACACIA_WOOD_FENCE.get(), Blocks.ACACIA_WOOD);
        addFence(ModBlocks.DARK_OAK_WOOD_FENCE.get(), Blocks.DARK_OAK_WOOD);
        addFence(ModBlocks.CRIMSON_HYPHAE_FENCE.get(), Blocks.CRIMSON_HYPHAE);
        addFence(ModBlocks.WARPED_HYPHAE_FENCE.get(), Blocks.WARPED_HYPHAE);
        addFence(ModBlocks.STRIPPED_OAK_WOOD_FENCE.get(), Blocks.STRIPPED_OAK_WOOD);
        addFence(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE.get(), Blocks.STRIPPED_SPRUCE_WOOD);
        addFence(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE.get(), Blocks.STRIPPED_BIRCH_WOOD);
        addFence(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE.get(), Blocks.STRIPPED_JUNGLE_WOOD);
        addFence(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE.get(), Blocks.STRIPPED_ACACIA_WOOD);
        addFence(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE.get(), Blocks.STRIPPED_DARK_OAK_WOOD);
        addFence(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE.get(), Blocks.STRIPPED_CRIMSON_HYPHAE);
        addFence(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE.get(), Blocks.STRIPPED_WARPED_HYPHAE);
        addFence(ModBlocks.RED_NETHER_BRICK_FENCE.get(), Blocks.RED_NETHER_BRICKS);
    }

    private static void addFenceGates() {
        addFenceGate(ModBlocks.OAK_WOOD_FENCE_GATE.get(), Blocks.OAK_WOOD);
        addFenceGate(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get(), Blocks.SPRUCE_WOOD);
        addFenceGate(ModBlocks.BIRCH_WOOD_FENCE_GATE.get(), Blocks.BIRCH_WOOD);
        addFenceGate(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get(), Blocks.JUNGLE_WOOD);
        addFenceGate(ModBlocks.ACACIA_WOOD_FENCE_GATE.get(), Blocks.ACACIA_WOOD);
        addFenceGate(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get(), Blocks.DARK_OAK_WOOD);
        addFenceGate(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get(), Blocks.CRIMSON_HYPHAE);
        addFenceGate(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get(), Blocks.WARPED_HYPHAE);
        addFenceGate(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_OAK_WOOD);
        addFenceGate(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_SPRUCE_WOOD);
        addFenceGate(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_BIRCH_WOOD);
        addFenceGate(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_JUNGLE_WOOD);
        addFenceGate(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_ACACIA_WOOD);
        addFenceGate(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE.get(), Blocks.STRIPPED_DARK_OAK_WOOD);
        addFenceGate(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE.get(), Blocks.STRIPPED_CRIMSON_HYPHAE);
        addFenceGate(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE.get(), Blocks.STRIPPED_WARPED_HYPHAE);
        addFenceGate(ModBlocks.NETHER_BRICK_FENCE_GATE.get(), Blocks.NETHER_BRICKS);
        addFenceGate(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get(), Blocks.RED_NETHER_BRICKS);
    }

    public static ResourceLocation extend(ResourceLocation rl, String extend) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + extend);
    }

    public static ResourceLocation shrink(ResourceLocation rl, String shrink) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath().replace(shrink, ""));
    }

    public static ResourceLocation blockTexture(Block block) {
        ResourceLocation name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block));
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }

    private static void addStair(Block block) {
        addStair(block, null);
    }

    private static void addStair(Block block, ResourceLocation resLoc) {
        STAIRS.add(Pair.of(block, resLoc));
    }

    private static void addSlab(Block block) {
        addSlab(block, null);
    }

    private static void addSlab(Block block, ResourceLocation resLoc) {
        SLABS.add(Pair.of(block, resLoc));
    }

    private static void addWall(Block block) {
        WALLS.add(block);
    }

    private static void addFence(Block block, Block parent) {
        FENCES.add(Pair.of(block, parent));
    }

    private static void addFenceGate(Block block, Block parent) {
        FENCE_GATES.add(Pair.of(block, parent));
    }
}
