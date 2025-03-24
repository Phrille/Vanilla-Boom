/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.recipe;

import com.google.common.collect.Maps;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;
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
    private NonNullList<Ingredient> dyes;
    @Nullable
    private String group;

    protected PaintingRecipeBuilder(RecipeCategory category, ResourceKey<PaintingVariant> variant, int count) {
        this.category = category;
        this.variant = variant;
        this.count = count;
    }

    public static PaintingRecipeBuilder painting(RecipeCategory category, ResourceKey<PaintingVariant> variant, int count) {
        return new PaintingRecipeBuilder(category, variant, count);
    }

    public static PaintingRecipeBuilder painting(RecipeCategory category, ResourceKey<PaintingVariant> variant) {
        return new PaintingRecipeBuilder(category, variant, 1);
    }

    public PaintingRecipeBuilder canvas(Ingredient canvas) {
        this.canvas = canvas;
        return this;
    }

    public PaintingRecipeBuilder dyes(List<Ingredient> dyes) {
        this.dyes = NonNullList.copyOf(dyes);
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
        ItemStack resultStack = Utils.stackFromPaintingVariant(Utils.resLocFromPaintingVariant(variant));
        resultStack.setCount(count);
        PaintingRecipe recipe = new PaintingRecipe(Objects.requireNonNullElse(group, ""), canvas, dyes, resultStack);
        output.accept(id, recipe, builder.build(id.withPrefix("recipes/" + category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation id) {
        if (criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }
}
