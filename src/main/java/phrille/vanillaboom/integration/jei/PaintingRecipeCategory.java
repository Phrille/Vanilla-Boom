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
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.entity.EaselBlockEntity;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.crafting.PaintingRecipe;

import java.util.List;

public class PaintingRecipeCategory implements IRecipeCategory<PaintingRecipe> {
    private static final Component TITLE = VanillaBoom.translatable("jei.category.painting");

    private static final int CANVAS_SLOT_X = 1;
    private static final int CANVAS_SLOT_Y = 31;
    private static final int DYE_SLOT_START_X = 1;
    private static final int DYE_SLOT_START_Y = 79;
    private static final int RESULT_SLOT_X = 123;
    private static final int RESULT_SLOT_Y = 31;
    private static final int PAINTING_BOX_SIZE = 50;
    private static final int PAINTING_X = 43;
    private static final int PAINTING_Y = 14;

    private final IGuiHelper guiHelper;
    private final IDrawable canvasBackground;
    private final IDrawable dyeBackground;

    public PaintingRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
        canvasBackground = guiHelper.createDrawable(EaselScreen.BACKGROUND, 240, 0, 16, 16);
        dyeBackground = guiHelper.createDrawable(EaselScreen.BACKGROUND, 224, 0, 16, 16);
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

        builder.addSlot(RecipeIngredientRole.INPUT, CANVAS_SLOT_X, CANVAS_SLOT_Y).addIngredients(recipe.canvas());

        for (int i = EaselBlockEntity.DYE_SLOT_START; i <= EaselBlockEntity.DYE_SLOT_END; i++) {
            int dyeSlotIndex = i - EaselBlockEntity.DYE_SLOT_START;
            int dyeSlotX = DYE_SLOT_START_X + (dyeSlotIndex % 8) * 18;
            int dyeSlotY = DYE_SLOT_START_Y + (dyeSlotIndex / 8) * 18;
            Ingredient dye = dyeSlotIndex < recipe.dyes().size() ? recipe.dyes().get(dyeSlotIndex) : Ingredient.EMPTY;
            builder.addSlot(RecipeIngredientRole.INPUT, dyeSlotX, dyeSlotY).addIngredients(dye);
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, RESULT_SLOT_X, RESULT_SLOT_Y).addItemStack(recipe.getResultItem(Minecraft.getInstance().level.registryAccess()));
    }

    @Override
    public void draw(PaintingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        List<IRecipeSlotView> slots = recipeSlotsView.getSlotViews();
        for (int slotIndex = 0; slotIndex < slots.size(); slotIndex++) {
            IRecipeSlotView slot = slots.get(slotIndex);

            if (slot.getRole() == RecipeIngredientRole.INPUT) {
                if (slotIndex == 0) {
                    guiHelper.getSlotDrawable().draw(guiGraphics, CANVAS_SLOT_X - 1, CANVAS_SLOT_Y - 1);

                    if (!slot.isEmpty()) continue;
                    canvasBackground.draw(guiGraphics, CANVAS_SLOT_X, CANVAS_SLOT_Y);
                } else {
                    int dyeSlotIndex = slotIndex - EaselBlockEntity.DYE_SLOT_START;
                    int dyeSlotX = DYE_SLOT_START_X + (dyeSlotIndex % 8) * 18;
                    int dyeSlotY = DYE_SLOT_START_Y + (dyeSlotIndex / 8) * 18;
                    guiHelper.getSlotDrawable().draw(guiGraphics, dyeSlotX - 1, dyeSlotY - 1);

                    if (!slot.isEmpty()) continue;
                    dyeBackground.draw(guiGraphics, dyeSlotX, dyeSlotY);
                }
            } else if (slot.getRole() == RecipeIngredientRole.OUTPUT) {
                guiHelper.getOutputSlot().draw(guiGraphics, RESULT_SLOT_X - 4, RESULT_SLOT_Y - 4);
            }
        }

        PaintingVariant variant = recipe.variant().value();
        TextureAtlasSprite sprite = Minecraft.getInstance().getPaintingTextures().get(variant);
        int area = variant.width() * variant.height();
        float scale = area == 1 ? 0.5f : area <= 4 ? 0.75f : 1.0f;
        int width = (int) (PAINTING_BOX_SIZE * scale);
        int height = (int) (PAINTING_BOX_SIZE * scale);

        if (variant.width() != variant.height()) {
            if (variant.width() < variant.height()) {
                width = Math.round(width * ((float) variant.width() / variant.height()));
            } else {
                height = Math.round(height * ((float) variant.height() / variant.width()));
            }
        }

        int xOffset = (PAINTING_BOX_SIZE - width) / 2;
        int yOffset = (PAINTING_BOX_SIZE - height) / 2;
        guiGraphics.blit(PAINTING_X + xOffset, PAINTING_Y + yOffset, 0, width, height, sprite);
    }
}
