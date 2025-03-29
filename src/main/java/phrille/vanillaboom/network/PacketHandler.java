/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import phrille.vanillaboom.VanillaBoom;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PacketHandler {
    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(Integer.toString(1));
        registrar.playToClient(
                EaselRecipePacket.TYPE,
                EaselRecipePacket.STREAM_CODEC,
                EaselRecipePacket::handle
        );
        registrar.playToClient(
                WitherBoneMealPacket.TYPE,
                WitherBoneMealPacket.STREAM_CODEC,
                WitherBoneMealPacket::handle
        );
        registrar.playToServer(
                EaselScreenPacket.TYPE,
                EaselScreenPacket.STREAM_CODEC,
                EaselScreenPacket::handle
        );
    }
}
