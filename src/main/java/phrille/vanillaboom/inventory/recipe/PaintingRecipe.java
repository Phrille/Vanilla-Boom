/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.util.Utils;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

public record PaintingRecipe(String group, Ingredient canvas, List<Ingredient> dyes,
                             ItemStack result) implements Recipe<Container> {
    public static final int MAX_DYES = 7;
    public static final Comparator<RecipeHolder<PaintingRecipe>> RECIPE_COMPARATOR = Comparator.comparing(recipe -> Utils.paintingVariantFromStack(recipe.value().result()),
            Comparator.<PaintingVariant>comparingInt(variant -> variant.getHeight() * variant.getWidth())
                    .thenComparing(PaintingVariant::getWidth)
                    .thenComparing(BuiltInRegistries.PAINTING_VARIANT::getKey));

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
    public RecipeType<PaintingRecipe> getType() {
        return ModRecipes.PAINTING.get();
    }

    @Override
    public RecipeSerializer<PaintingRecipe> getSerializer() {
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
        return other instanceof PaintingRecipe; //otherRecipe && otherRecipe.recipeId.equals(recipeId);
    }

    public static class PaintingRecipeSerializer implements RecipeSerializer<PaintingRecipe> {
        private static final Codec<PaintingRecipe> CODEC = RecordCodecBuilder.create(inst ->
                inst.group(
                        ExtraCodecs.strictOptionalField(Codec.STRING, "group", "")
                                .forGetter(recipe -> recipe.group),
                        Ingredient.CODEC_NONEMPTY.fieldOf("canvas")
                                .forGetter(recipe -> recipe.canvas),
                        Ingredient.LIST_CODEC_NONEMPTY.fieldOf("dyes")
                                .forGetter(recipe -> recipe.dyes),
                        ResourceLocation.CODEC.fieldOf("variant")
                                .xmap(Utils::stackFromPaintingVariant, Utils::resLocFromStack)
                                .forGetter(recipe -> recipe.result)
                ).apply(inst, PaintingRecipe::new));

        @Override
        public Codec<PaintingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PaintingRecipe fromNetwork(FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            int size = buffer.readVarInt();
            Ingredient canvas = Ingredient.fromNetwork(buffer);
            NonNullList<Ingredient> dyes = NonNullList.create();

            for (int i = 1; i < size; i++) {
                dyes.add(Ingredient.fromNetwork(buffer));
            }

            ItemStack result = buffer.readItem();
            return new PaintingRecipe(group, canvas, dyes, result);
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
