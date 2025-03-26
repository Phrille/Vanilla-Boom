/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.loot;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import phrille.vanillaboom.VanillaBoom;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModGlobalLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    public static final Supplier<MapCodec<DropLootModifier>> DROP_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("drop_loot_modifier", DropLootModifier.CODEC);
    public static final Supplier<MapCodec<FishingLootModifier>> FISHING_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("fishing_modifier", FishingLootModifier.CODEC);

    public static NestedLootTable nestedTable(ResourceKey<LootTable> lootTable) {
        return (NestedLootTable) NestedLootTable.lootTableReference(lootTable).build();
    }
}