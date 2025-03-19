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
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
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
    private static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder()
            .add(Registries.DAMAGE_TYPE, ModDataGenerator::bootstrap);

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        Utils.registerCandleCakes();

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

    public static ResourceLocation extend(ResourceLocation rl, String extend) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + extend);
    }

    public static ResourceLocation shrink(ResourceLocation rl, String shrink) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath().replace(shrink, ""));
    }
}
