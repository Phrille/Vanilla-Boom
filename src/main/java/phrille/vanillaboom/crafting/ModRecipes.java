/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;
import phrille.vanillaboom.VanillaBoom;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, VanillaBoom.MOD_ID);
    public static final Supplier<RecipeSerializer<PaintingRecipe>> PAINTING_SERIALIZER = RECIPE_SERIALIZERS.register("painting", PaintingRecipe.Serializer::new);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, VanillaBoom.MOD_ID);
    public static final Supplier<RecipeType<PaintingRecipe>> PAINTING = RECIPE_TYPES.register("painting", () -> new VanillaBoomRecipeType<>(VanillaBoom.resLoc("painting")));

    private record VanillaBoomRecipeType<T extends Recipe<?>>(ResourceLocation id) implements RecipeType<T> {
        @Override
        public String toString() {
            return id.toString();
        }
    }
}
