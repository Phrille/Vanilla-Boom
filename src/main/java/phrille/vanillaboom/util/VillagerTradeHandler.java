/*
 * Copyright (C) 2024-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.ModItems;

import java.util.List;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID)
@SuppressWarnings("SameParameterValue")
public class VillagerTradeHandler {
    @SubscribeEvent
    public static void onVillagerTrade(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        ResourceLocation profession = BuiltInRegistries.VILLAGER_PROFESSION.getKey(event.getType());

        if (profession.getPath().equals("farmer")) {
            trades.get(1).add(itemToEmeralds(ModItems.TOMATO.get(), 22, 16, 2));
            trades.get(1).add(itemToEmeralds(ModItems.CHILI.get(), 20, 16, 2));
            trades.get(1).add(itemToEmeralds(ModItems.RICE_GRAINS.get(), 30, 16, 2));
        } else if (profession.getPath().equals("fisherman")) {
            trades.get(1).add(emeraldsToItem(3, ModItems.TUNA_BUCKET.get(), 16, 1));
            trades.get(1).add(emeraldsToItem(3, ModItems.PERCH_BUCKET.get(), 16, 1));
            trades.get(1).add(emeraldsToItem(3, ModItems.PIKE_BUCKET.get(), 16, 1));
            trades.get(1).add(emeraldsToItem(3, ModItems.EEL_BUCKET.get(), 16, 1));
        }
    }

    @SubscribeEvent
    public static void onWandererTrade(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        trades.add(emeraldsToItem(1, ModItems.TOMATO_SEEDS.get(), 1, 10));
        trades.add(emeraldsToItem(1, ModItems.CHILI_SEEDS.get(), 1, 10));
        trades.add(emeraldsToItem(1, ModItems.RICE_GRAINS.get(), 1, 10));
    }

    private static BasicItemListing itemToEmeralds(ItemLike item, int amount, int maxTrades, int xp) {
        return new BasicItemListing(new ItemStack(item, amount), new ItemStack(Items.EMERALD), maxTrades, xp, 0.05F);
    }

    private static BasicItemListing emeraldsToItem(int emeralds, ItemLike item, int maxTrades, int xp) {
        return new BasicItemListing(emeralds, new ItemStack(item), maxTrades, xp, 0.05F);
    }
}
