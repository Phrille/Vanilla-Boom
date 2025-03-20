/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.VanillaBoom;

import java.util.List;
import java.util.function.Supplier;

public class ModStats {
    public static final DeferredRegister<ResourceLocation> STATS = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT, VanillaBoom.MOD_ID);

    public static final Supplier<ResourceLocation> INTERACT_WITH_EASEL = registerStat("interact_with_easel");

    private static final List<Runnable> TRIGGERS = Lists.newArrayList();

    @SuppressWarnings("SameParameterValue")
    private static Supplier<ResourceLocation> registerStat(String id) {
        return STATS.register(id, () -> {
            ResourceLocation resLoc = VanillaBoom.resLoc(id);
            TRIGGERS.add(() -> Stats.CUSTOM.get(resLoc, StatFormatter.DEFAULT));
            return resLoc;
        });
    }

    public static void registerStats() {
        TRIGGERS.forEach(Runnable::run);
    }
}
