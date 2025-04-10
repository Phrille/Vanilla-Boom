/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.client.ClientPacketHandler;
import phrille.vanillaboom.crafting.PaintingRecipe;

import java.util.List;

public record EaselRecipePacket(short containerId,
                                List<RecipeHolder<PaintingRecipe>> recipes) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<EaselRecipePacket> TYPE = new CustomPacketPayload.Type<>(VanillaBoom.resLoc("easel_recipe_packet"));

    @SuppressWarnings("unchecked")
    public static final StreamCodec<RegistryFriendlyByteBuf, EaselRecipePacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.SHORT,
            EaselRecipePacket::containerId,
            (StreamCodec<RegistryFriendlyByteBuf, List<RecipeHolder<PaintingRecipe>>>) (StreamCodec<RegistryFriendlyByteBuf, ?>) RecipeHolder.STREAM_CODEC.apply(ByteBufCodecs.list()),
            EaselRecipePacket::recipes,
            EaselRecipePacket::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(EaselRecipePacket packet, IPayloadContext context) {
        context.enqueueWork(() -> ClientPacketHandler.handleEaselRecipePacket(context.player(), packet.containerId(), packet.recipes()));
    }

    public static void send(ServerPlayer player, int containerId, List<RecipeHolder<PaintingRecipe>> recipes) {
        PacketDistributor.sendToPlayer(player, new EaselRecipePacket((short) containerId, recipes));
    }
}
