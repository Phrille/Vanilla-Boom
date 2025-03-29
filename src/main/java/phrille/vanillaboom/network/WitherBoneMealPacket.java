/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.util.Utils;

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

    public static void handle(WitherBoneMealPacket payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().level() instanceof ClientLevel level) {
                Utils.spawnParticles(ParticleTypes.SOUL, level, payload.pos);
                level.playLocalSound(payload.pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
        });
    }
}
