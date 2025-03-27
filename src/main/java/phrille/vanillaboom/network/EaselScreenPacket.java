/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.inventory.EaselMenu;

public record EaselScreenPacket(short containerId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<EaselScreenPacket> TYPE = new CustomPacketPayload.Type<>(VanillaBoom.resLoc("easel_screen_packet"));

    public static final StreamCodec<ByteBuf, EaselScreenPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.SHORT,
            EaselScreenPacket::containerId,
            EaselScreenPacket::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(EaselScreenPacket payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                if (player.containerMenu instanceof EaselMenu menu && menu.containerId == payload.containerId()) {
                    menu.refreshRecipes();
                }
            }
        });
    }
}

