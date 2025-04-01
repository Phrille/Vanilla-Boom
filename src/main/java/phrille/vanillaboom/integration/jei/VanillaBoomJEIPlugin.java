/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.entity.EaselBlockEntity;
import phrille.vanillaboom.crafting.ModRecipes;
import phrille.vanillaboom.crafting.PaintingRecipe;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.inventory.ModMenuTypes;

import java.util.List;

@JeiPlugin
public class VanillaBoomJEIPlugin implements IModPlugin {
    public static final ResourceLocation UID = VanillaBoom.resLoc("main");
    public static final RecipeType<PaintingRecipe> PAINTING = RecipeType.create(VanillaBoom.MOD_ID, "painting", PaintingRecipe.class);

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new PaintingRecipeCategory(guiHelper));
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void registerRecipes(IRecipeRegistration registration) {
        List<RecipeHolder<PaintingRecipe>> recipes = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.PAINTING.get());
        registration.addRecipes(PAINTING, recipes.stream().sorted(PaintingRecipe.RECIPE_COMPARATOR).map(RecipeHolder::value).toList());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.EASEL.get()), PAINTING);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(EaselMenu.class, ModMenuTypes.EASEL_MENU.get(), PAINTING, EaselBlockEntity.DYE_SLOT_START, EaselBlockEntity.CANVAS_SLOT + 1, 9, 36);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }
}
