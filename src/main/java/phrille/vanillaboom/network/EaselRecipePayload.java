package phrille.vanillaboom.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.inventory.recipe.ModRecipes;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;

import java.util.List;

public record EaselRecipePayload(short containerId, List<RecipeHolder<PaintingRecipe>> recipes) implements CustomPacketPayload {
    public static final ResourceLocation ID = VanillaBoom.resLoc("easel_recipe_payload");

    public EaselRecipePayload(FriendlyByteBuf buffer) {
        this(buffer.readUnsignedByte(), getRecipeList(buffer));
    }

    @Override
    public void write(FriendlyByteBuf buffer) {
        buffer.writeByte(containerId);
        buffer.writeVarInt(recipes.size());
        for (RecipeHolder<PaintingRecipe> holder : recipes) {
            buffer.writeResourceLocation(holder.id());
            PaintingRecipe recipe = holder.value();
            recipe.getSerializer().toNetwork(buffer, recipe);
        }
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    public static void handle(EaselRecipePayload payload, PlayPayloadContext context) {
        context.workHandler().execute(() -> {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player != null && player.containerMenu instanceof EaselMenu menu && menu.containerId == payload.containerId()) {
                if (Minecraft.getInstance().screen instanceof EaselScreen screen) {
                    screen.updateRecipes(payload.recipes());
                }
            }
        });
    }

    public static List<RecipeHolder<PaintingRecipe>> getRecipeList(FriendlyByteBuf buffer) {
        int size = buffer.readVarInt();
        List<RecipeHolder<PaintingRecipe>> recipes = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            ResourceLocation id = buffer.readResourceLocation();
            PaintingRecipe recipe = ModRecipes.PAINTING_SERIALIZER.get().fromNetwork(buffer);
            recipes.add(new RecipeHolder<>(id, recipe));
        }
        return recipes;
    }
}
