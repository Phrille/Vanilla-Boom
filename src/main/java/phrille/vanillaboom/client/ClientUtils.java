/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client;

import net.minecraft.client.gui.screens.MenuScreens;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.inventory.ModMenuTypes;

public class ClientUtils {
    @SuppressWarnings("deprecation")
    public static void registerMenuScreen() {
        MenuScreens.register(ModMenuTypes.EASEL_MENU.get(), EaselScreen::new);
    }
}
