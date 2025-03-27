/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.crafting.PaintingRecipe;
import phrille.vanillaboom.inventory.EaselMenu;

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

    public static void handle(EaselRecipePacket payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof LocalPlayer player) {
                if (player.containerMenu instanceof EaselMenu menu && menu.containerId == payload.containerId()) {
                    if (Minecraft.getInstance().screen instanceof EaselScreen screen) {
                        screen.updateRecipes(payload.recipes());
                    }
                }
            }
        });
    }
}
