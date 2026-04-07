/*
 * Copyright (C) 2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.client.ClientPacketHandler;

public record LevelEventPacket(BlockPos pos, byte ordinal) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<LevelEventPacket> TYPE = new CustomPacketPayload.Type<>(VanillaBoom.resLoc("level_event_packet"));
    public static final StreamCodec<ByteBuf, LevelEventPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC,
            LevelEventPacket::pos,
            ByteBufCodecs.BYTE,
            LevelEventPacket::ordinal,
            LevelEventPacket::new
    );

    public static void handle(LevelEventPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> ClientPacketHandler.handleLevelEventPacket(context.player(), packet.pos(), LevelEventType.values()[packet.ordinal()]));
    }

    public static void send(ServerLevel level, BlockPos pos, LevelEventType eventType) {
        PacketDistributor.sendToPlayersNear(level, null, pos.getX(), pos.getY(), pos.getZ(), 64.0, new LevelEventPacket(pos, (byte) eventType.ordinal()));
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public enum LevelEventType {
        WITHER_BONE_MEAL,
        MILK_COW
    }
}
