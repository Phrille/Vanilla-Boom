/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.entity.EaselBlockEntity;
import phrille.vanillaboom.util.Utils;

import java.util.Comparator;
import java.util.List;

public record PaintingRecipe(String group, Ingredient canvas, NonNullList<Ingredient> dyes,
                             Holder<PaintingVariant> variant,
                             int resultCount) implements Recipe<EaselRecipeInput> {
    public static final int MAX_DYES = 7;
    public static final Comparator<RecipeHolder<PaintingRecipe>> RECIPE_COMPARATOR =
            Comparator.comparing(recipe -> recipe.value().variant().value(),
                    Comparator.comparingInt(PaintingVariant::area)
                            .thenComparing(PaintingVariant::width)
                            .thenComparing(PaintingVariant::assetId));

    @Override
    public boolean matches(EaselRecipeInput input, Level level) {
        if (!canvas.test(input.getItem(EaselBlockEntity.CANVAS_SLOT))) {
            return false;
        }

        List<ItemStack> dyeStacks = input.dyes()
                .stream()
                .map(ItemStack::copy)
                .toList();
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
    public ItemStack assemble(EaselRecipeInput input, HolderLookup.Provider registries) {
        return loadVariantToStack(registries).copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return loadVariantToStack(registries);
    }

    private ItemStack loadVariantToStack(HolderLookup.Provider registries) {
        ItemStack result = Utils.stackFromHolder(registries, variant);
        result.setCount(resultCount);
        return result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(canvas);
        ingredients.addAll(dyes);
        return ingredients;
    }

    public List<ItemStack> getCombinedDyeStacks() {
        List<ItemStack> dyeStacks = Lists.newArrayList();
        dyeStacks.add(canvas().getItems()[0]);

        for (Ingredient dye : dyes()) {
            if (dye.hasNoItems()) continue;

            ItemStack[] possibleStacks = dye.getItems();
            DyeColor color = DyeColor.getColor(possibleStacks[0]);
            if (color == null) continue;

            ItemStack dyeStack = new ItemStack(DyeItem.byColor(color));
            boolean foundMatch = false;
            for (ItemStack existingStack : dyeStacks) {
                if (existingStack.is(dyeStack.getItem())) {
                    existingStack.grow(1);
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                dyeStacks.add(dyeStack);
            }
        }
        return dyeStacks;
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
                                .forGetter(recipe -> recipe.variant),
                        Codec.INT.optionalFieldOf("count", 1)
                                .forGetter(recipe -> recipe.resultCount)
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

            Holder<PaintingVariant> variant = PaintingVariant.STREAM_CODEC.decode(buffer);
            int resultCount = buffer.readInt();
            return new PaintingRecipe(group, canvas, dyes, variant, resultCount);
        }

        public static void toNetwork(RegistryFriendlyByteBuf buffer, PaintingRecipe recipe) {
            buffer.writeUtf(recipe.group());
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.canvas());

            buffer.writeVarInt(recipe.dyes().size());
            for (Ingredient dye : recipe.dyes()) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, dye);
            }

            PaintingVariant.STREAM_CODEC.encode(buffer, recipe.variant());
            buffer.writeInt(recipe.resultCount);
        }
    }
}
