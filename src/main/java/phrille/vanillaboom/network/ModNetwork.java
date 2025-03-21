/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.PlayNetworkDirection;
import net.neoforged.neoforge.network.simple.SimpleChannel;
import phrille.vanillaboom.VanillaBoom;

public class ModNetwork {
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            VanillaBoom.resLoc("main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    public static void register() {
        CHANNEL.messageBuilder(EaselRecipePacket.class, 0, PlayNetworkDirection.PLAY_TO_CLIENT)
                .encoder(EaselRecipePacket::encode)
                .decoder(EaselRecipePacket::decode)
                .consumerMainThread(EaselRecipePacket::handle)
                .add();
    }
}
