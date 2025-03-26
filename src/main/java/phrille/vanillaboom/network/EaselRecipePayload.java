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
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.crafting.PaintingRecipe;

import java.util.List;

public record EaselRecipePayload(short containerId,
                                 List<RecipeHolder<PaintingRecipe>> recipes) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<EaselRecipePayload> TYPE = new CustomPacketPayload.Type<>(VanillaBoom.resLoc("easel_recipe_payload"));

    @SuppressWarnings("unchecked")
    public static final StreamCodec<RegistryFriendlyByteBuf, EaselRecipePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.SHORT,
            EaselRecipePayload::containerId,
            (StreamCodec<RegistryFriendlyByteBuf, List<RecipeHolder<PaintingRecipe>>>) (StreamCodec<RegistryFriendlyByteBuf, ?>) RecipeHolder.STREAM_CODEC.apply(ByteBufCodecs.list()),
            EaselRecipePayload::recipes,
            EaselRecipePayload::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(EaselRecipePayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player != null && player.containerMenu instanceof EaselMenu menu && menu.containerId == payload.containerId()) {
                if (Minecraft.getInstance().screen instanceof EaselScreen screen) {
                    screen.updateRecipes(payload.recipes());
                }
            }
        });
    }
}
