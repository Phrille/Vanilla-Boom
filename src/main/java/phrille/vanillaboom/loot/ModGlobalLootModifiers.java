/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.loot;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import phrille.vanillaboom.VanillaBoom;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModGlobalLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    public static final Supplier<Codec<DropLootModifier>> DROP_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("drop_loot_modifier", DropLootModifier.CODEC);
    public static final Supplier<Codec<FishingLootModifier>> FISHING_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("fishing_modifier", FishingLootModifier.CODEC);

    public static LootTableReference getLootTableReference(String location) {
        // Replace with ResourceLocation.parse(location)
        return getLootTableReference(new ResourceLocation(location));
    }

    public static LootTableReference getLootTableReference(ResourceLocation resLoc) {
        return (LootTableReference) LootTableReference.lootTableReference(resLoc).build();
    }

    public static String getString(LootTableReference lootTable) {
        return lootTable.name.toString();
    }
}