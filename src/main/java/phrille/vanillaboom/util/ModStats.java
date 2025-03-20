/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import phrille.vanillaboom.VanillaBoom;

public class ModStats {
    public static final ResourceLocation INTERACT_WITH_EASEL = makeCustomStat("interact_with_easel", StatFormatter.DEFAULT);

    @SuppressWarnings("SameParameterValue")
    private static ResourceLocation makeCustomStat(String id, StatFormatter statFormatter) {
        ResourceLocation resourcelocation = VanillaBoom.resLoc(id);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, id, resourcelocation);
        Stats.CUSTOM.get(resourcelocation, statFormatter);
        return resourcelocation;
    }

    public static void register() {
        // No-op implementation
    }
}
