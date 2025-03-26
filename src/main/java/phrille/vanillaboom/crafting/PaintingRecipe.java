/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.crafting;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.Container;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.util.PaintingUtils;

import java.util.Comparator;
import java.util.List;

public record PaintingRecipe(String group, Ingredient canvas, NonNullList<Ingredient> dyes,
                             ItemStack result) implements Recipe<Container> {
    public static final int MAX_DYES = 7;
    public static final Comparator<RecipeHolder<PaintingRecipe>> RECIPE_COMPARATOR = Comparator.comparing(recipe -> PaintingUtils.holderFromStack(recipe.value().result()).value(),
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
    public ItemStack assemble(Container container, HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result;
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

    public static class Serializer implements RecipeSerializer<PaintingRecipe> {
        private static final MapCodec<PaintingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst ->
                inst.group(
                        Codec.STRING.optionalFieldOf("group", "")
                                .forGetter(recipe -> recipe.group),
                        Ingredient.CODEC_NONEMPTY.fieldOf("canvas")
                                .forGetter(recipe -> recipe.canvas),
                        Ingredient.CODEC.listOf().fieldOf("dyes")
                                .flatXmap(ingredientList -> {
                                    Ingredient[] ingredients = ingredientList.toArray(Ingredient[]::new);
                                    if (ingredients.length == 0) {
                                        return DataResult.error(() -> "List of dye ingredients can not be empty");
                                    } else if (ingredients.length > MAX_DYES) {
                                        return DataResult.error(() -> "List of dye ingredients can not exceed %s items".formatted(MAX_DYES));
                                    }
                                    return DataResult.success(NonNullList.of(Ingredient.EMPTY, ingredients));
                                }, DataResult::success)
                                .forGetter(recipe -> recipe.dyes),
                        Painting.VARIANT_MAP_CODEC.fieldOf("result")
                                .xmap(PaintingUtils::stackFromHolder, PaintingUtils::holderFromStack)
                                .dependent(Codec.INT.optionalFieldOf("count", 1),
                                        stack -> Pair.of(stack.getCount(), Codec.INT.optionalFieldOf("count", stack.getCount())),
                                        (stack, count) -> {
                                            stack.setCount(count);
                                            return stack;
                                        })
                                .forGetter(recipe -> recipe.result)
                ).apply(inst, PaintingRecipe::new));

        private static final StreamCodec<RegistryFriendlyByteBuf, PaintingRecipe> STREAM_CODEC = StreamCodec.of(
                PaintingRecipe.Serializer::toNetwork, PaintingRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<PaintingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, PaintingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        public static PaintingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            Ingredient canvas = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);

            int size = buffer.readVarInt();
            NonNullList<Ingredient> dyes = NonNullList.withSize(size, Ingredient.EMPTY);
            dyes.replaceAll(ingredient -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));

            ItemStack result = ItemStack.STREAM_CODEC.decode(buffer);
            return new PaintingRecipe(group, canvas, dyes, result);
        }

        public static void toNetwork(RegistryFriendlyByteBuf buffer, PaintingRecipe paintingRecipe) {
            buffer.writeUtf(paintingRecipe.group());
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, paintingRecipe.canvas());

            buffer.writeVarInt(paintingRecipe.dyes().size());
            for (Ingredient dye : paintingRecipe.dyes()) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, dye);
            }

            ItemStack.STREAM_CODEC.encode(buffer, paintingRecipe.result());
        }
    }
}
