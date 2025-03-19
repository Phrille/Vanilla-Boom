/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client;

import net.minecraft.client.Minecraft;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.network.EaselRecipePacket;

public class ClientPacketHandler {
    public static void handleEaselRecipePacket(EaselRecipePacket packet) {
        if (Minecraft.getInstance().screen instanceof EaselScreen screen) {
            screen.updateRecipes(packet.recipes());
        }
    }
}
