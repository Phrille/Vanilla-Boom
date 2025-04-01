/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.client.ClientPacketHandler;

public record WitherBoneMealPacket(BlockPos pos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<WitherBoneMealPacket> TYPE = new CustomPacketPayload.Type<>(VanillaBoom.resLoc("wither_bone_meal_packet"));

    public static final StreamCodec<ByteBuf, WitherBoneMealPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC,
            WitherBoneMealPacket::pos,
            WitherBoneMealPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(WitherBoneMealPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> ClientPacketHandler.handleWitherBoneMealPacket(context.player(), packet.pos()));
    }

    public static void send(ServerLevel level, BlockPos pos) {
        PacketDistributor.sendToPlayersNear(level, null, pos.getX(), pos.getY(), pos.getZ(), 64.0, new WitherBoneMealPacket(pos));
    }
}
