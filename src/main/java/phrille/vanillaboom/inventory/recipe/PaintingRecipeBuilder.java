package phrille.vanillaboom.inventory.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;
import phrille.vanillaboom.util.ModTags;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Consumer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class PaintingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Ingredient canvas;
    private final List<Ingredient> dyes;
    private final ResourceLocation variant;
    private final Item result;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private String group;

    public PaintingRecipeBuilder(RecipeCategory category, Ingredient canvas, List<Ingredient> dyes, ResourceLocation variant, ItemLike result, int count) {
        this.category = category;
        this.canvas = canvas;
        this.dyes = dyes;
        this.variant = variant;
        this.result = result.asItem();
        this.count = count;
    }

    public static PaintingRecipeBuilder painting(Ingredient canvas, List<Ingredient> dyes, RecipeCategory category, ResourceLocation variant, ItemLike result, int count) {
        return new PaintingRecipeBuilder(category, canvas, dyes, variant, result, count);
    }

    public static PaintingRecipeBuilder painting(List<Ingredient> dyes, RecipeCategory category, ResourceLocation variant) {
        return new PaintingRecipeBuilder(category, Ingredient.of(ModTags.ForgeTags.Items.CANVAS), dyes, variant, Items.PAINTING, 1);
    }

    @Override
    public PaintingRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    @Override
    public PaintingRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipe, ResourceLocation recipeId) {
        ensureValid(recipeId);
        advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
        finishedRecipe.accept(new PaintingRecipeBuilder.Result(recipeId, group == null ? "" : group, canvas, dyes, variant, count, advancement, recipeId.withPrefix("recipes/" + category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation recipeId) {
        if (advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation recipeId;
        private final String group;
        private final Ingredient canvas;
        private final List<Ingredient> dyes;
        private final ResourceLocation variant;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation recipeId, String group, Ingredient canvas, List<Ingredient> dyes, ResourceLocation variant, int count, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.recipeId = recipeId;
            this.group = group;
            this.canvas = canvas;
            this.dyes = dyes;
            this.variant = variant;
            this.count = count;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public void serializeRecipeData(JsonObject json) {
            if (!group.isEmpty()) {
                json.addProperty("group", group);
            }

            json.add("canvas", canvas.toJson());
            JsonArray jsonDyes = new JsonArray(PaintingRecipe.MAX_DYES);

            for (Ingredient dye : dyes) {
                jsonDyes.add(dye.toJson());
            }

            json.add("dyes", jsonDyes);
            json.addProperty("variant", variant.toString());
            json.addProperty("count", count);
        }

        @Override
        public ResourceLocation getId() {
            return recipeId;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipes.PAINTING_SERIALIZER.get();
        }

        @Override
        @Nullable
        public JsonObject serializeAdvancement() {
            return advancement.serializeToJson();
        }

        @Override
        @Nullable
        public ResourceLocation getAdvancementId() {
            return advancementId;
        }
    }
}
