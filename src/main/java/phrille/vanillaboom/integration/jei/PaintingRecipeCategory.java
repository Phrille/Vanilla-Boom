/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.integration.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;
import phrille.vanillaboom.util.Utils;

public class PaintingRecipeCategory implements IRecipeCategory<PaintingRecipe> {
    public static final ResourceLocation BACKGROUND = VanillaBoom.resLoc("textures/gui/container/easel.png");
    private static final int PAINTING_BOX_SIZE = 38;

    private final IGuiHelper guiHelper;
    private final Component title;

    public PaintingRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
        this.title = Component.translatable(VanillaBoom.MOD_ID + ".recipe.category.painting");
    }

    @Override
    public RecipeType<PaintingRecipe> getRecipeType() {
        return VanillaBoomJEIPlugin.PAINTING;
    }

    @Override
    public Component getTitle() {
        return title;
    }

    @Override
    public int getWidth() {
        return 106;
    }

    @Override
    public int getHeight() {
        return 72;
    }

    @Override
    public IDrawable getIcon() {
        return guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.EASEL.get()));
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PaintingRecipe recipe, IFocusGroup focuses) {
        for (int i = EaselMenu.DYE_SLOT_START; i < EaselMenu.DYE_SLOT_END + 1; i++) {
            Ingredient dye = i < recipe.dyes().size() ? recipe.dyes().get(i) : Ingredient.EMPTY;
            builder.addSlot(RecipeIngredientRole.INPUT, 1 + (i % 2) * 18, 1 + (i / 2) * 18)
                    .addIngredients(dye);
        }

        builder.addSlot(RecipeIngredientRole.INPUT, 19, 55).addIngredients(recipe.canvas());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 85, 51).addItemStack(recipe.result());
    }

    @Override
    public void draw(PaintingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        guiGraphics.blit(BACKGROUND, 0, 0, 0, 184, getWidth(), getHeight());
        PaintingVariant variant = Utils.paintingVariantFromStack(recipe.result());

        if (variant != null) {
            TextureAtlasSprite sprite = Minecraft.getInstance().getPaintingTextures().get(variant);
            float maxSize = PAINTING_BOX_SIZE;
            float scaleFactor = Math.min(maxSize / variant.getWidth(), maxSize / variant.getHeight());

            if (variant.getWidth() <= 16 && variant.getHeight() <= 16) {
                scaleFactor *= 0.5F;
            } else if (variant.getWidth() <= 32 && variant.getHeight() <= 32) {
                scaleFactor *= 0.85F;
            }

            int paintingWidth = Math.max(1, (int) (variant.getWidth() * scaleFactor));
            int paintingHeight = Math.max(1, (int) (variant.getHeight() * scaleFactor));
            int xOffset = (int) ((maxSize - paintingWidth) / 2);
            int yOffset = (int) ((maxSize - paintingHeight) / 2);
            guiGraphics.blit(52 + xOffset, 4 + yOffset, 0, paintingWidth, paintingHeight, sprite);
        }
    }
}
