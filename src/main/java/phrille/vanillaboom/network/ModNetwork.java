/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import phrille.vanillaboom.VanillaBoom;

public class ModNetwork {
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(VanillaBoom.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    @SuppressWarnings("UnusedAssignment")
    public static void register () {
        int id = 0;
        CHANNEL.registerMessage(id++, EaselRecipePacket.class, EaselRecipePacket::encode, EaselRecipePacket::decode, EaselRecipePacket::handle);
    }
}
