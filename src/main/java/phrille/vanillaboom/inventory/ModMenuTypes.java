/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;
import phrille.vanillaboom.VanillaBoom;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, VanillaBoom.MOD_ID);

    public static final Supplier<MenuType<EaselMenu>> EASEL_MENU = MENU_TYPES.register("easel", () -> new MenuType<>(EaselMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
