/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client.screen;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class EaselClientTooltip implements ClientTooltipComponent {
    public static final int MAX_ITEMS_PER_ROW = 7;
    public static final int ITEM_SIZE = 16;
    public static final int ITEM_SPACING = 2;

    private final List<ItemStack> items;
    private final int width;
    private final int height;

    public EaselClientTooltip(List<ItemStack> items) {
        this.items = items;
        width = Math.min(items.size(), MAX_ITEMS_PER_ROW) * (ITEM_SIZE + ITEM_SPACING);
        height = (int) Math.ceil(items.size() / (double) MAX_ITEMS_PER_ROW) * (ITEM_SIZE + ITEM_SPACING);
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
        int itemX = x;
        int itemY = y;

        for (int i = 0; i < items.size(); i++) {
            ItemStack stack = items.get(i);
            guiGraphics.renderItem(stack, itemX, itemY);
            guiGraphics.renderItemDecorations(font, stack, itemX, itemY);

            itemX += ITEM_SIZE + ITEM_SPACING;
            if ((i + 1) % MAX_ITEMS_PER_ROW == 0) {
                itemX = x;
                itemY += ITEM_SIZE + ITEM_SPACING;
            }
        }
    }
}
