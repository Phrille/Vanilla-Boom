/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.util.Utils;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

public record PaintingRecipe(ResourceLocation recipeId, String group, Ingredient canvas, NonNullList<Ingredient> dyes,
                             ItemStack result) implements Recipe<Container> {
    public static final int MAX_DYES = 7;
    public static final Comparator<PaintingRecipe> RECIPE_COMPARATOR = Comparator.comparing(recipe -> Utils.paintingVariantFromStack(recipe.result()),
            Comparator.<PaintingVariant>comparingInt(variant -> variant.getHeight() * variant.getWidth())
                    .thenComparing(PaintingVariant::getWidth)
                    .thenComparing(ForgeRegistries.PAINTING_VARIANTS::getKey));

    @Override
    public boolean matches(Container container, Level level) {
        if (!canvas.test(container.getItem(EaselMenu.CANVAS_SLOT))) {
            return false;
        }

        List<ItemStack> dyeStacks = Lists.newArrayList();
        for (int i = EaselMenu.DYE_SLOT_START; i < EaselMenu.DYE_SLOT_END + 1; i++) {
            dyeStacks.add(container.getItem(i).copy());
        }

        for (Ingredient ingredient : dyes) {
            boolean foundMatch = false;
            for (ItemStack dyeStack : dyeStacks) {
                if (ingredient.test(dyeStack)) {
                    dyeStack.shrink(1);
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

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.EASEL.get());
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PaintingRecipe otherRecipe && otherRecipe.recipeId.equals(recipeId);
    }

    public static PaintingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
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

    public static void toNetwork(FriendlyByteBuf buffer, PaintingRecipe paintingRecipe) {
        buffer.writeUtf(paintingRecipe.group());
        buffer.writeVarInt(paintingRecipe.getIngredients().size());
        paintingRecipe.canvas().toNetwork(buffer);

        for (Ingredient ingredient : paintingRecipe.dyes()) {
            ingredient.toNetwork(buffer);
        }

        buffer.writeItem(paintingRecipe.result());
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
            } else if (jsonDyes.size() > MAX_DYES) {
                throw new JsonSyntaxException("List of dye ingredients can not exceed " + MAX_DYES + " items");
            }

            jsonDyes.asList().forEach((jsonDye) -> dyes.add(Ingredient.fromJson(jsonDye)));
            ItemStack result = Utils.stackFromPaintingVariant(new ResourceLocation(GsonHelper.getAsString(json, "variant")));

            return new PaintingRecipe(recipeId, group, canvas, dyes, result);
        }

        @Override
        public PaintingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            return PaintingRecipe.fromNetwork(recipeId, buffer);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, PaintingRecipe paintingRecipe) {
            PaintingRecipe.toNetwork(buffer, paintingRecipe);
        }
    }
}
