package phrille.vanillaboom.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.client.ClientPacketHandler;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;

import java.util.List;
import java.util.function.Supplier;

public record EaselRecipePacket(List<PaintingRecipe> recipes) {

    public static void encode(EaselRecipePacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.recipes.size());
        for (PaintingRecipe recipe : packet.recipes) {
            buffer.writeResourceLocation(recipe.getId());
            PaintingRecipe.toNetwork(buffer, recipe);
        }
    }

    public static EaselRecipePacket decode(FriendlyByteBuf buffer) {
        int size = buffer.readInt();
        List<PaintingRecipe> recipes = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            recipes.add(PaintingRecipe.fromNetwork(buffer.readResourceLocation(), buffer));
        }
        return new EaselRecipePacket(recipes);
    }

    public static void handle(EaselRecipePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context ctx = contextSupplier.get();
        ctx.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientPacketHandler.handleEaselRecipePacket(packet)));
        ctx.setPacketHandled(true);
    }

    public static void send(Player player, List<PaintingRecipe> recipes) {
        if (player instanceof ServerPlayer serverPlayer) {
            ModNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new EaselRecipePacket(recipes));
        }
    }
}
