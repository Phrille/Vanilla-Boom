/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory.recipe;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import phrille.vanillaboom.util.Utils;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PaintingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final ResourceKey<PaintingVariant> variant;
    private final int count;
    private final Map<String, Criterion<?>> criteria = Maps.newLinkedHashMap();

    private Ingredient canvas;
    private List<Ingredient> dyes;
    @Nullable
    private String group;

    public PaintingRecipeBuilder(RecipeCategory category, ResourceKey<PaintingVariant> variant, int count) {
        this.category = category;
        this.variant = variant;
        this.count = count;
    }

    public static PaintingRecipeBuilder painting(RecipeCategory category, ResourceKey<PaintingVariant> variant, int count) {
        return new PaintingRecipeBuilder(category, variant, count);
    }

    public PaintingRecipeBuilder canvas(Ingredient canvas) {
        this.canvas = canvas;
        return this;
    }

    public PaintingRecipeBuilder dyes(List<Ingredient> dyes) {
        this.dyes = dyes;
        return this;
    }

    @Override
    public PaintingRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
        criteria.put(criterionName, criterionTrigger);
        return this;
    }

    @Override
    public PaintingRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return Items.PAINTING;
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        ensureValid(id);
        Advancement.Builder builder = output.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(builder);
        criteria.forEach(builder::addCriterion);
        output.accept(new PaintingRecipeBuilder.Result(id, group == null ? "" : group, canvas, dyes, variant, count,
                builder.build(id.withPrefix("recipes/" + category.getFolderName() + "/"))));
    }

    private void ensureValid(ResourceLocation id) {
        if (criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

    public record Result(ResourceLocation id, String group, Ingredient canvas, List<Ingredient> dyes,
                         ResourceKey<PaintingVariant> variant, int count,
                         AdvancementHolder advancement) implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!group.isEmpty()) {
                json.addProperty("group", group);
            }

            json.add("canvas", canvas.toJson(false));
            JsonArray jsonDyes = new JsonArray(PaintingRecipe.MAX_DYES);

            for (Ingredient dye : dyes) {
                jsonDyes.add(dye.toJson(false));
            }

            json.add("dyes", jsonDyes);
            json.addProperty("variant", Utils.resLocFromPaintingVariant(variant).toString());
            if (count > 1) {
                json.addProperty("count", count);
            }
        }

        @Override
        public RecipeSerializer<PaintingRecipe> type() {
            return ModRecipes.PAINTING_SERIALIZER.get();
        }
    }
}
