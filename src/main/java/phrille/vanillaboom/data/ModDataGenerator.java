/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.data.loot.ModBlockLootTables;
import phrille.vanillaboom.data.loot.ModGlobalLootModifierProvider;
import phrille.vanillaboom.data.recipe.ModRecipeProvider;
import phrille.vanillaboom.data.tags.ModBlockTagsProvider;
import phrille.vanillaboom.data.tags.ModEntityTypeTagsProvider;
import phrille.vanillaboom.data.tags.ModItemTagsProvider;
import phrille.vanillaboom.util.ModDamageTypes;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    private static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder()
            .add(Registries.DAMAGE_TYPE, ModDataGenerator::bootstrap);

    public static final Set<Block> WOOD_BLOCKS = Set.of(
            Blocks.OAK_WOOD,
            Blocks.SPRUCE_WOOD,
            Blocks.BIRCH_WOOD,
            Blocks.JUNGLE_WOOD,
            Blocks.ACACIA_WOOD,
            Blocks.DARK_OAK_WOOD,
            Blocks.MANGROVE_WOOD,
            Blocks.CHERRY_WOOD,
            Blocks.CRIMSON_HYPHAE,
            Blocks.WARPED_HYPHAE,
            Blocks.STRIPPED_OAK_WOOD,
            Blocks.STRIPPED_SPRUCE_WOOD,
            Blocks.STRIPPED_BIRCH_WOOD,
            Blocks.STRIPPED_JUNGLE_WOOD,
            Blocks.STRIPPED_ACACIA_WOOD,
            Blocks.STRIPPED_DARK_OAK_WOOD,
            Blocks.STRIPPED_MANGROVE_WOOD,
            Blocks.STRIPPED_CHERRY_WOOD,
            Blocks.STRIPPED_CRIMSON_HYPHAE,
            Blocks.STRIPPED_WARPED_HYPHAE
    );

    @SuppressWarnings("unchecked")
    public static final List<CandleBlock> CANDLES = (List<CandleBlock>) (List<?>) List.of(
            Blocks.CANDLE,
            Blocks.WHITE_CANDLE,
            Blocks.ORANGE_CANDLE,
            Blocks.MAGENTA_CANDLE,
            Blocks.LIGHT_BLUE_CANDLE,
            Blocks.YELLOW_CANDLE,
            Blocks.LIME_CANDLE,
            Blocks.PINK_CANDLE,
            Blocks.GRAY_CANDLE,
            Blocks.LIGHT_GRAY_CANDLE,
            Blocks.CYAN_CANDLE,
            Blocks.PURPLE_CANDLE,
            Blocks.BLUE_CANDLE,
            Blocks.BROWN_CANDLE,
            Blocks.GREEN_CANDLE,
            Blocks.RED_CANDLE,
            Blocks.BLACK_CANDLE
    );

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Assets
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(output));

        // Data
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(output, lookupProvider, blockTags, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModEntityTypeTagsProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));
        List<LootTableProvider.SubProviderEntry> subProviders = List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), subProviders, lookupProvider));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, lookupProvider, REGISTRY_SET_BUILDER, Set.of(VanillaBoom.MOD_ID)));
    }

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(ModDamageTypes.CHILI, new DamageType("vanillaboom.chili", DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.3F, DamageEffects.BURNING));
    }

    public static ResourceLocation extend(ResourceLocation rl, String extend) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + extend);
    }

    public static ResourceLocation shrink(ResourceLocation rl, String shrink) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath().replace(shrink, ""));
    }
}
