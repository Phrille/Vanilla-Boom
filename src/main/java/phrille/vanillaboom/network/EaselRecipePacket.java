/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.DistExecutor;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.client.ClientPacketHandler;
import phrille.vanillaboom.inventory.recipe.ModRecipes;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;

import java.util.List;
import java.util.function.Supplier;

public record EaselRecipePacket(List<RecipeHolder<PaintingRecipe>> recipes) {
    public static void encode(EaselRecipePacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.recipes.size());
        for (RecipeHolder<PaintingRecipe> holder : packet.recipes) {
            buffer.writeResourceLocation(holder.id());
            PaintingRecipe recipe = holder.value();
            recipe.getSerializer().toNetwork(buffer, recipe);
        }
    }

    public static EaselRecipePacket decode(FriendlyByteBuf buffer) {
        int size = buffer.readInt();
        List<RecipeHolder<PaintingRecipe>> recipes = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            ResourceLocation id = buffer.readResourceLocation();
            PaintingRecipe recipe = ModRecipes.PAINTING_SERIALIZER.get().fromNetwork(buffer);
            recipes.add(new RecipeHolder<>(id, recipe));
        }
        return new EaselRecipePacket(recipes);
    }

    public static void handle(EaselRecipePacket packet, NetworkEvent.ServerCustomPayloadEvent.Context ctx) {
        ctx.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientPacketHandler.handleEaselRecipePacket(packet)));
        ctx.setPacketHandled(true);
    }

    public static void send(Player player, List<RecipeHolder<PaintingRecipe>> recipes) {
        if (player instanceof ServerPlayer serverPlayer) {
            ModNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new EaselRecipePacket(recipes));
        }
    }
}
