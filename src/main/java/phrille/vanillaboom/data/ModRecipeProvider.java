package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipe) {
        bricks(finishedRecipe, ModBlocks.COBBLESTONE_BRICKS.get(), Blocks.COBBLESTONE);
        bricks(finishedRecipe, ModBlocks.MOSSY_COBBLESTONE_BRICKS.get(), Blocks.MOSSY_COBBLESTONE);
        mossyCobblestoneBricksShapeless(finishedRecipe, Blocks.MOSS_BLOCK);
        mossyCobblestoneBricksShapeless(finishedRecipe, Blocks.VINE);
        twoByTwoShaped(finishedRecipe, ModBlocks.MAGMA_BRICKS.get(), ModItems.MAGMA_BRICK.get());
        bricks(finishedRecipe, ModBlocks.OBSIDIAN_BRICKS.get(), Blocks.OBSIDIAN);
        bricks(finishedRecipe, ModBlocks.SNOW_BRICKS.get(), Blocks.SNOW_BLOCK);
        bricks(finishedRecipe, ModBlocks.TERRACOTTA_BRICKS.get(), Blocks.TERRACOTTA);
        terracottaBricks(finishedRecipe, ModBlocks.WHITE_TERRACOTTA_BRICKS.get(), Blocks.WHITE_TERRACOTTA, Tags.Items.DYES_WHITE);
        terracottaBricks(finishedRecipe, ModBlocks.ORANGE_TERRACOTTA_BRICKS.get(), Blocks.ORANGE_TERRACOTTA, Tags.Items.DYES_ORANGE);
        terracottaBricks(finishedRecipe, ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get(), Blocks.MAGENTA_TERRACOTTA, Tags.Items.DYES_MAGENTA);
        terracottaBricks(finishedRecipe, ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_BLUE_TERRACOTTA, Tags.Items.DYES_LIGHT_BLUE);
        terracottaBricks(finishedRecipe, ModBlocks.YELLOW_TERRACOTTA_BRICKS.get(), Blocks.YELLOW_TERRACOTTA, Tags.Items.DYES_YELLOW);
        terracottaBricks(finishedRecipe, ModBlocks.LIME_TERRACOTTA_BRICKS.get(), Blocks.LIME_TERRACOTTA, Tags.Items.DYES_LIME);
        terracottaBricks(finishedRecipe, ModBlocks.PINK_TERRACOTTA_BRICKS.get(), Blocks.PINK_TERRACOTTA, Tags.Items.DYES_PINK);
        terracottaBricks(finishedRecipe, ModBlocks.GRAY_TERRACOTTA_BRICKS.get(), Blocks.GRAY_TERRACOTTA, Tags.Items.DYES_GRAY);
        terracottaBricks(finishedRecipe, ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_GRAY_TERRACOTTA, Tags.Items.DYES_LIGHT_GRAY);
        terracottaBricks(finishedRecipe, ModBlocks.CYAN_TERRACOTTA_BRICKS.get(), Blocks.CYAN_TERRACOTTA, Tags.Items.DYES_CYAN);
        terracottaBricks(finishedRecipe, ModBlocks.PURPLE_TERRACOTTA_BRICKS.get(), Blocks.PURPLE_TERRACOTTA, Tags.Items.DYES_PURPLE);
        terracottaBricks(finishedRecipe, ModBlocks.BLUE_TERRACOTTA_BRICKS.get(), Blocks.BLUE_TERRACOTTA, Tags.Items.DYES_BLUE);
        terracottaBricks(finishedRecipe, ModBlocks.BROWN_TERRACOTTA_BRICKS.get(), Blocks.BROWN_TERRACOTTA, Tags.Items.DYES_BROWN);
        terracottaBricks(finishedRecipe, ModBlocks.GREEN_TERRACOTTA_BRICKS.get(), Blocks.GREEN_TERRACOTTA, Tags.Items.DYES_GREEN);
        terracottaBricks(finishedRecipe, ModBlocks.RED_TERRACOTTA_BRICKS.get(), Blocks.RED_TERRACOTTA, Tags.Items.DYES_RED);
        terracottaBricks(finishedRecipe, ModBlocks.BLACK_TERRACOTTA_BRICKS.get(), Blocks.BLACK_TERRACOTTA, Tags.Items.DYES_BLACK);
        twoByTwoShaped(finishedRecipe, ModBlocks.BONE_SAND.get(), Items.BONE_MEAL);
        twoByTwoShaped(finishedRecipe, ModBlocks.WITHER_BONE_SAND.get(), ModItems.WITHER_BONE_MEAL.get());
    }

    public void bricks(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(finishedRecipe, result, ingredient, 4);
        stonecutting(finishedRecipe, result, ingredient);
    }

    public void terracottaBricks(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, Tag<Item> dye) {
        bricks(finishedRecipe, result, ingredient);
        terracottaBricksShaped(finishedRecipe, result, dye);
    }

    public void polishedBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        polishedBlock(finishedRecipe, result, ingredient, List.of());
    }

    public void polishedBlock(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, List<ItemLike> variants) {
        twoByTwoShaped(finishedRecipe, result, ingredient, 4);
        stonecutting(finishedRecipe, result, ingredient);
        variants.forEach(variant -> stonecutting(finishedRecipe, result, variant));
    }

    //Shaped Recipe
    public void twoByTwoShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        twoByTwoShaped(finishedRecipe, result, ingredient, 1);
    }

    public void twoByTwoShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        ShapedRecipeBuilder.shaped(result, amount)
                .define('x', ingredient)
                .pattern("xx")
                .pattern("xx")
                .group(name(result))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe);
    }

    public void terracottaBricksShaped(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, Tag<Item> dye) {
        ShapedRecipeBuilder.shaped(result, 8)
                .define('x', ModBlocks.TERRACOTTA_BRICKS.get())
                .define('y', dye)
                .pattern("xxx")
                .pattern("xyx")
                .pattern("xxx")
                .group(name(result))
                .unlockedBy(getHasName(ModBlocks.TERRACOTTA_BRICKS.get()), has(ModBlocks.TERRACOTTA_BRICKS.get()))
                .save(finishedRecipe, getAltName(result));
    }

    //Shapeless Recipe
    public void oneToOneShapeless(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        ShapelessRecipeBuilder.shapeless(result, amount)
                .requires(ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeName(result, ingredient));
    }

    public void mossyCobblestoneBricksShapeless(Consumer<FinishedRecipe> finishedRecipe, ItemLike ingredient) {
        ShapelessRecipeBuilder.shapeless(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get())
                .requires(ModBlocks.COBBLESTONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_BRICKS.get()), has(ModBlocks.COBBLESTONE_BRICKS.get()))
                .requires(ingredient)
                .group(name(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get()))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeName(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get(), ingredient));
    }

    //Stonecutting
    public void stonecutting(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient) {
        stonecutting(finishedRecipe, result, ingredient, 1);
    }

    public void stonecutting(Consumer<FinishedRecipe> finishedRecipe, ItemLike result, ItemLike ingredient, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(finishedRecipe, getConversionRecipeName(result, ingredient, "_stonecutting"));
    }

    private static String getHasName(ItemLike item) {
        return "has_" + name(item);
    }

    private static ResourceLocation getConversionRecipeName(ItemLike result, ItemLike ingredient) {
        return getConversionRecipeName(result, ingredient, "");
    }

    private static ResourceLocation getConversionRecipeName(ItemLike result, ItemLike ingredient, String suffix) {
        return modLoc(name(result) + "_from_" + name(ingredient) + suffix);
    }

    private static ResourceLocation getAltName(ItemLike result) {
        return modLoc(name(result) + "_alt");
    }

    private static ResourceLocation modLoc(String name) {
        return new ResourceLocation(VanillaBoom.MOD_ID, name);
    }

    private static String name(ItemLike item) {
        return item.asItem().getRegistryName().getPath();
    }
}
