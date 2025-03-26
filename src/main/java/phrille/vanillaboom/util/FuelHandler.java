/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import com.google.common.collect.Maps;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import phrille.vanillaboom.VanillaBoom;

import java.util.Map;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class FuelHandler {
    private static final Map<Item, Integer> burnTimes = Maps.newHashMap();

    public static void registerBurnTime(ItemLike item, int burnTime) {
        burnTimes.put(item.asItem(), burnTime);
    }

    @SubscribeEvent
    public static void fuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();

        if (event.isCanceled() || !burnTimes.containsKey(item)) return;

        event.setBurnTime(burnTimes.get(item));
    }
}
