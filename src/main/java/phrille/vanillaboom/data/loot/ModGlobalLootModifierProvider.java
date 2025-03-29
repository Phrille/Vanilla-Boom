/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.loot;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.loot.DropLootModifier;
import phrille.vanillaboom.loot.FishingLootModifier;
import phrille.vanillaboom.loot.ModGlobalLootModifiers;
import phrille.vanillaboom.loot.ModLootTables;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, VanillaBoom.MOD_ID);
    }

    @Override
    protected void start() {
        // Blocks
        add("spruce_leaves", new DropLootModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES).build()},
                ModGlobalLootModifiers.nestedTable(ModLootTables.SPRUCE_LEAVES),
                List.of()));

        // Entities
        entityLootModifier("drowned", EntityType.DROWNED, ModLootTables.DROWNED, List.of(Items.ROTTEN_FLESH));
        entityLootModifier("polar_bear", EntityType.POLAR_BEAR, ModLootTables.POLAR_BEAR, List.of(Items.COD, Items.SALMON));
        entityLootModifier("silverfish", EntityType.SILVERFISH, ModLootTables.SILVERFISH, List.of());
        entityLootModifier("wither_skeleton", EntityType.WITHER_SKELETON, ModLootTables.WITHER_SKELETON, List.of(Items.BONE));

        // Gameplay
        add("fishing", new FishingLootModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "gameplay/fishing/fish")).build()},
                ModGlobalLootModifiers.nestedTable(ModLootTables.FISHING_FISH),
                0.45F));
    }

    private void entityLootModifier(String name, EntityType<?> entityType, ResourceKey<LootTable> modifierTable, List<Item> removeItems) {
        add(name, new DropLootModifier(new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(
                        LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityType))).build()},
                ModGlobalLootModifiers.nestedTable(modifierTable),
                removeItems));
    }
}
