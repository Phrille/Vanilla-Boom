/*
 * Copyright (C) 2025-2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.integration.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
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
import phrille.vanillaboom.block.entity.EaselBlockEntity;
import phrille.vanillaboom.crafting.PaintingRecipe;

import java.util.List;

public class PaintingRecipeCategory implements IRecipeCategory<PaintingRecipe> {
    public static final ResourceLocation TEXTURE = VanillaBoom.resLoc("textures/gui/jei/easel.png");
    public static final Component TITLE = VanillaBoom.translatable("jei.category.painting");
    private static final int PAINTING_BOX_SIZE = 50;

    private final IGuiHelper guiHelper;

    public PaintingRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
    }

    @Override
    public RecipeType<PaintingRecipe> getRecipeType() {
        return VanillaBoomJEIPlugin.PAINTING;
    }

    @Override
    public Component getTitle() {
        return TITLE;
    }

    @Override
    public int getWidth() {
        return 144;
    }

    @Override
    public int getHeight() {
        return 114;
    }

    @Override
    public IDrawable getIcon() {
        return guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.EASEL.get()));
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PaintingRecipe recipe, IFocusGroup focuses) {
        if (Minecraft.getInstance().level == null) {
            VanillaBoom.LOGGER.warn("ClientLevel is null when setting JEI recipe for {}", getClass());
            return;
        }

        builder.addSlot(RecipeIngredientRole.INPUT, 1, 31).addIngredients(recipe.canvas());

        for (int i = EaselBlockEntity.DYE_SLOT_START; i <= EaselBlockEntity.DYE_SLOT_END; i++) {
            int dyeSlotIndex = i - EaselBlockEntity.DYE_SLOT_START;
            int dyeSlotX = 1 + (dyeSlotIndex % 8) * 18;
            int dyeSlotY = 79 + (dyeSlotIndex / 8) * 18;
            Ingredient dye = dyeSlotIndex < recipe.dyes().size() ? recipe.dyes().get(dyeSlotIndex) : Ingredient.EMPTY;
            builder.addSlot(RecipeIngredientRole.INPUT, dyeSlotX, dyeSlotY).addIngredients(dye);
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 123, 31).addItemStack(recipe.getResultItem(Minecraft.getInstance().level.registryAccess()));
    }

    @Override
    public void draw(PaintingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        guiGraphics.blit(TEXTURE, 0, 0, 0, 0, getWidth(), getHeight());

        List<IRecipeSlotView> slots = recipeSlotsView.getSlotViews(RecipeIngredientRole.INPUT);
        for (int i = 0; i < slots.size(); i++) {
            if (!slots.get(i).isEmpty()) {
                continue;
            }
            if (i == 0) {
                guiGraphics.blit(TEXTURE, 1, 31, 160, 0, 16, 16);
            } else {
                int dyeSlotIndex = i - EaselBlockEntity.DYE_SLOT_START;
                int dyeSlotX = 1 + (dyeSlotIndex % 8) * 18;
                int dyeSlotY = 79 + (dyeSlotIndex / 8) * 18;
                guiGraphics.blit(TEXTURE, dyeSlotX, dyeSlotY, 144, 0, 16, 16);
            }
        }

        PaintingVariant variant = recipe.variant().value();
        TextureAtlasSprite sprite = Minecraft.getInstance().getPaintingTextures().get(variant);
        int area = variant.width() * variant.height();
        float scale = area == 1 ? 0.5f : area <= 4 ? 0.75f : 1.0f;
        int width = (int) (PAINTING_BOX_SIZE * scale);
        int height = (int) (PAINTING_BOX_SIZE * scale);

        if (variant.width() != variant.height()) {
            float ratio = (float) variant.width() / variant.height();
            if (variant.width() < variant.height()) {
                width = Math.round(width * ratio);
            } else {
                height = Math.round(height * (1 / ratio));
            }
        }

        int xOffset = (PAINTING_BOX_SIZE - width) / 2;
        int yOffset = (PAINTING_BOX_SIZE - height) / 2;
        guiGraphics.blit(43 + xOffset, 14 + yOffset, 0, width, height, sprite);
    }
}
