/*
 * Copyright (C) 2025-2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client.screen;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;

public class EaselClientTooltip implements ClientTooltipComponent {
    private static final int MAX_ITEMS_PER_ROW = 6;
    private static final int ITEM_SIZE = 16;
    private static final int PADDING = 2;

    private final ImmutableList<ItemStack> ingredients;
    private final int width;
    private final int height;

    public EaselClientTooltip(ImmutableList<ItemStack> ingredients) {
        this.ingredients = ingredients;
        width = Math.min(ingredients.size(), MAX_ITEMS_PER_ROW) * (ITEM_SIZE + PADDING);
        height = (int) Math.ceil(ingredients.size() / (double) MAX_ITEMS_PER_ROW) * (ITEM_SIZE + PADDING);
    }

    @Override
    public int getWidth(Font font) {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        for (int i = 0; i < ingredients.size(); i++) {
            ItemStack stack = ingredients.get(i);
            int itemX = x + (ITEM_SIZE + PADDING) * (i % MAX_ITEMS_PER_ROW);
            int itemY = y + (ITEM_SIZE + PADDING) * (i / MAX_ITEMS_PER_ROW);
            guiGraphics.renderItem(stack, itemX, itemY);
            guiGraphics.renderItemDecorations(font, stack, itemX, itemY);
        }
    }
}
