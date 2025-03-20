/*
 * Copyright (C) 2024-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import phrille.vanillaboom.VanillaBoom;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> CHILI = register("chili");

    @SuppressWarnings("SameParameterValue")
    private static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, VanillaBoom.resLoc(name));
    }
}
