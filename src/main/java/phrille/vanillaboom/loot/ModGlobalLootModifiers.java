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
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.VanillaBoom;

@SuppressWarnings("unused")
public class ModGlobalLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    public static final RegistryObject<Codec<DropLootModifier>> DROP_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("drop_loot_modifier", DropLootModifier.CODEC);
    public static final RegistryObject<Codec<FishingLootModifier>> FISHING_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("fishing_modifier", FishingLootModifier.CODEC);

    public static LootTableReference getLootTableReference(String resLoc) {
        return (LootTableReference) LootTableReference.lootTableReference(new ResourceLocation(resLoc)).build();
    }

    public static String getString(LootTableReference lootTable) {
        return lootTable.name.toString();
    }
}