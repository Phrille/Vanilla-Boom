package phrille.vanillaboom.inventory.recipe;

import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.util.ModTags;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Set;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record PaintingRecipe(ResourceLocation recipeId, String group, Ingredient canvas, NonNullList<Ingredient> dyes,
                             ItemStack result) implements Recipe<Container> {
    @Override
    public boolean matches(Container container, Level level) {
        if (!container.getItem(EaselMenu.CANVAS_SLOT).is(ModTags.ForgeTags.Items.CANVAS)) {
            return false;
        }

        Set<Integer> usedSlots = Sets.newHashSet();
        for (Ingredient ingredient : dyes) {
            boolean foundMatch = false;
            for (int i = 0; i < container.getContainerSize() - 1; i++) {
                if (usedSlots.contains(i)) continue;

                if (ingredient.test(container.getItem(i))) {
                    usedSlots.add(i);
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) return false;
        }
        return true;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess access) {
        return result.copy();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.PAINTING.get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.PAINTING_SERIALIZER.get();
    }

    @Override
    public ItemStack getResultItem(@Nullable RegistryAccess access) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return recipeId;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(canvas);
        ingredients.addAll(dyes);
        return ingredients;
    }

    public static class PaintingRecipeSerializer implements RecipeSerializer<PaintingRecipe> {
        @Override
        public PaintingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");

            Ingredient canvas = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "canvas"));
            NonNullList<Ingredient> dyes = NonNullList.create();
            JsonArray jsonDyes = GsonHelper.getAsJsonArray(json, "dyes");

            if (jsonDyes.isEmpty()) {
                throw new JsonSyntaxException("List of dye ingredients can not be empty");
            } else if (jsonDyes.size() > 4) {
                throw new JsonSyntaxException("List of dye ingredients can not exceed 4 items");
            }

            jsonDyes.asList().forEach((jsonDye) -> dyes.add(Ingredient.fromJson(jsonDye)));

            ItemStack result = new ItemStack(Items.PAINTING, GsonHelper.getAsInt(json, "count", 1));
            CompoundTag entityTag = new CompoundTag();
            entityTag.putString("variant", GsonHelper.getAsString(json, "variant"));
            result.getOrCreateTag().put("EntityTag", entityTag);

            return new PaintingRecipe(recipeId, group, canvas, dyes, result);
        }

        @Override
        public PaintingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            int size = buffer.readVarInt();
            Ingredient canvas = Ingredient.fromNetwork(buffer);
            NonNullList<Ingredient> dyes = NonNullList.create();

            for (int i = 1; i < size; i++) {
                dyes.add(Ingredient.fromNetwork(buffer));
            }

            ItemStack result = buffer.readItem();
            return new PaintingRecipe(recipeId, group, canvas, dyes, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, PaintingRecipe paintingRecipe) {
            buffer.writeUtf(paintingRecipe.group());
            buffer.writeVarInt(paintingRecipe.getIngredients().size());
            paintingRecipe.canvas().toNetwork(buffer);
            for (Ingredient ingredient : paintingRecipe.dyes()) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItem(paintingRecipe.result());
        }
    }
}
