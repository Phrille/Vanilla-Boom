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
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.inventory.recipe.ModRecipes;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;

import java.util.List;

public record EaselRecipePacket(List<RecipeHolder<PaintingRecipe>> recipes, short containerId) {
    public static void encode(EaselRecipePacket packet, FriendlyByteBuf buffer) {
        buffer.writeByte(packet.containerId);
        buffer.writeVarInt(packet.recipes.size());
        for (RecipeHolder<PaintingRecipe> holder : packet.recipes) {
            buffer.writeResourceLocation(holder.id());
            PaintingRecipe recipe = holder.value();
            recipe.getSerializer().toNetwork(buffer, recipe);
        }
    }

    public static EaselRecipePacket decode(FriendlyByteBuf buffer) {
        short containerId = buffer.readUnsignedByte();
        int size = buffer.readVarInt();
        List<RecipeHolder<PaintingRecipe>> recipes = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            ResourceLocation id = buffer.readResourceLocation();
            PaintingRecipe recipe = ModRecipes.PAINTING_SERIALIZER.get().fromNetwork(buffer);
            recipes.add(new RecipeHolder<>(id, recipe));
        }
        return new EaselRecipePacket(recipes, containerId);
    }

    public static void handle(EaselRecipePacket packet, NetworkEvent.ServerCustomPayloadEvent.Context ctx) {
        ctx.enqueueWork(() -> {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player != null && player.containerMenu instanceof EaselMenu menu && menu.containerId == packet.containerId) {
                if (Minecraft.getInstance().screen instanceof EaselScreen screen) {
                    screen.updateRecipes(packet.recipes());
                }
            }
        });
        ctx.setPacketHandled(true);
    }

    public static void send(Player player, List<RecipeHolder<PaintingRecipe>> recipes, short containerId) {
        if (player instanceof ServerPlayer serverPlayer && !(serverPlayer instanceof FakePlayer)) {
            ModNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new EaselRecipePacket(recipes, containerId));
        }
    }
}
