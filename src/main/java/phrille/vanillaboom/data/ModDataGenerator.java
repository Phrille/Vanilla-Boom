/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

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
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
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
        addFences();
        addFenceGates();
        Utils.registerCandleCakes();
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

    private static void addFence(Block block, Block parent) {
        FENCES.add(Pair.of(block, parent));
    }

    private static void addFenceGate(Block block, Block parent) {
        FENCE_GATES.add(Pair.of(block, parent));
    }
}
