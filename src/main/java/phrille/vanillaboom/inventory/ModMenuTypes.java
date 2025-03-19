/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.VanillaBoom;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, VanillaBoom.MOD_ID);

    public static final RegistryObject<MenuType<EaselMenu>> EASEL_MENU = MENU_TYPES.register("easel", () -> new MenuType<>(EaselMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
