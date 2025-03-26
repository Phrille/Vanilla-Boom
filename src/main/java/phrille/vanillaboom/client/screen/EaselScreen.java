/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.crafting.PaintingRecipe;
import phrille.vanillaboom.util.PaintingUtils;

import java.util.List;

public class EaselScreen extends AbstractContainerScreen<EaselMenu> {
    private static final ResourceLocation BG_LOCATION = VanillaBoom.resLoc("textures/gui/container/easel.png");

    private static List<RecipeHolder<PaintingRecipe>> availableRecipes = Lists.newArrayList();

    public static final int SCREEN_WIDTH = 176;
    public static final int SCREEN_HEIGHT = 184;

    /* Buttons */
    public static final int BUTTON_SIZE = 24;
    private final List<PaintingButton> buttonList = Lists.newArrayList();
    private int startIndex;

    /* Grid */
    public static final int GRID_X = 49;
    public static final int GRID_Y = 15;
    public static final int GRID_ROWS = 3;
    public static final int GRID_COLUMNS = 3;
    public static final int GRID_MAX_ITEMS = GRID_ROWS * GRID_COLUMNS;

    /* Slots */
    public static final int SLOT_SIZE = 16;

    /* Scrolling */
    public static final int SCROLLBAR_X = 124;
    public static final int SCROLLBAR_Y = 15;
    public static final int SCROLLBAR_WIDTH = 12;
    public static final int SCROLLBAR_HEIGHT = 72;
    public static final int SCROLL_BUTTON_WIDTH = SCROLLBAR_WIDTH;
    public static final int SCROLL_BUTTON_HEIGHT = 15;
    private float scrollOffset;
    private boolean scrolling;

    public EaselScreen(EaselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        menu.registerUpdateListener(this::containerChanged);
        imageWidth = SCREEN_WIDTH;
        imageHeight = SCREEN_HEIGHT;
        --titleLabelY;
        inventoryLabelY += 19;

        for (int buttonId = 0; buttonId < menu.getRecipes().size(); buttonId++) {
            RecipeHolder<PaintingRecipe> recipe = menu.getRecipes().get(buttonId);
            PaintingVariant variant = PaintingUtils.holderFromStack(recipe.value().result()).value();
            PaintingButton button = new PaintingButton(buttonId, recipe, variant);
            button.register();
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = leftPos;
        int y = topPos;

        // Background
        guiGraphics.blit(BG_LOCATION, x, y, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Scrollbar
        int scrollY = (int) ((float) (SCROLLBAR_HEIGHT - SCROLL_BUTTON_HEIGHT) * scrollOffset);
        guiGraphics.blit(BG_LOCATION, x + SCROLLBAR_X, y + SCROLLBAR_Y + scrollY, SCREEN_WIDTH + (isScrollBarActive() ? 0 : SCROLL_BUTTON_WIDTH), 0, SCROLL_BUTTON_WIDTH, SCROLL_BUTTON_HEIGHT);

        // Dye slots
        menu.getDyeSlots().stream()
                .filter(slot -> !slot.hasItem())
                .forEach(slot -> guiGraphics.blit(BG_LOCATION, x + slot.x, y + slot.y, SCREEN_WIDTH, 15, SLOT_SIZE, SLOT_SIZE));

        // Canvas slot
        Slot canvasSlot = menu.getCanvasSlot();
        if (!canvasSlot.hasItem()) {
            guiGraphics.blit(BG_LOCATION, x + canvasSlot.x, y + canvasSlot.y, SCREEN_WIDTH + SLOT_SIZE, 15, SLOT_SIZE, SLOT_SIZE);
        }

        // Grid
        renderGrid(guiGraphics, x + GRID_X, y + GRID_Y, mouseX, mouseY);
    }

    private void renderGrid(GuiGraphics guiGraphics, int x, int y, int mouseX, int mouseY) {
        int max = startIndex + GRID_MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            PaintingButton button = buttonList.get(buttonId);
            int i = buttonId - startIndex;
            int buttonX = x + i % GRID_COLUMNS * BUTTON_SIZE;
            int buttonY = y + i / GRID_COLUMNS * BUTTON_SIZE;
            button.render(guiGraphics, buttonX, buttonY, mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int buttonCode) {
        scrolling = false;
        int x = leftPos + GRID_X;
        int y = topPos + GRID_Y;
        int max = startIndex + GRID_MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            PaintingButton button = buttonList.get(buttonId);

            if (!button.enabled) continue;

            int i = buttonId - startIndex;
            double buttonX = mouseX - (double) (x + i % GRID_COLUMNS * BUTTON_SIZE);
            double buttonY = mouseY - (double) (y + i / GRID_COLUMNS * BUTTON_SIZE);

            if (buttonX >= 0.0D && buttonY >= 0.0D && buttonX < (double) BUTTON_SIZE && buttonY < (double) BUTTON_SIZE && button.onClick()) {
                return true;
            }
        }

        x = leftPos + SCROLLBAR_X;
        y = topPos + SCROLLBAR_Y;
        if (mouseX >= (double) x && mouseX < (double) (x + SCROLL_BUTTON_WIDTH) && mouseY >= (double) y && mouseY < (double) (y + SCROLLBAR_HEIGHT)) {
            scrolling = true;
        }

        return super.mouseClicked(mouseX, mouseY, buttonCode);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (scrolling && isScrollBarActive()) {
            int scrollY = topPos + SCROLLBAR_Y;
            int scrollHeight = scrollY + SCROLLBAR_HEIGHT;
            scrollOffset = ((float) mouseY - (float) scrollY - 7.5F) / ((float) (scrollHeight - scrollY) - 15.0F);
            scrollOffset = Mth.clamp(scrollOffset, 0.0F, 1.0F);
            startIndex = (int) ((double) (scrollOffset * (float) getOffscreenRows()) + 0.5D) * GRID_COLUMNS;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double deltaX, double deltaY) {
        if (isScrollBarActive()) {
            int rows = getOffscreenRows();
            float f = (float) deltaY / (float) rows;
            scrollOffset = Mth.clamp(scrollOffset - f, 0.0F, 1.0F);
            startIndex = (int) ((double) (scrollOffset * (float) rows) + 0.5D) * GRID_COLUMNS;
        }

        return true;
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);

        int x = leftPos + GRID_X;
        int y = topPos + GRID_Y;
        int max = startIndex + GRID_MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            PaintingButton button = buttonList.get(buttonId);
            int i = buttonId - startIndex;
            int buttonX = x + i % GRID_COLUMNS * BUTTON_SIZE;
            int buttonY = y + i / GRID_COLUMNS * BUTTON_SIZE;

            if (mouseX >= buttonX && mouseX < buttonX + BUTTON_SIZE && mouseY >= buttonY && mouseY < buttonY + BUTTON_SIZE) {
                button.renderButtonTooltip(guiGraphics, mouseX, mouseY);
            }
        }
    }

    private boolean isScrollBarActive() {
        return buttonList.size() > GRID_MAX_ITEMS;
    }

    private int getOffscreenRows() {
        int totalRows = (buttonList.size() + GRID_COLUMNS - 1) / GRID_COLUMNS;
        return Math.max(0, totalRows - GRID_ROWS);
    }

    private void containerChanged() {
        buttonList.forEach(button -> {
            button.enabled = availableRecipes.contains(button.recipe);
            button.selected = button.enabled && button.selected;
        });

        if (!isScrollBarActive()) {
            scrollOffset = 0.0F;
            startIndex = 0;
        }
    }

    public void updateRecipes(List<RecipeHolder<PaintingRecipe>> recipes) {
        availableRecipes = recipes;
        containerChanged();
    }

    @Override
    public void onClose() {
        super.onClose();
        availableRecipes.clear();
    }

    private class PaintingButton {
        private final int buttonId;
        private final RecipeHolder<PaintingRecipe> recipe;
        private final TextureAtlasSprite sprite;
        private final int paintingWidth;
        private final int paintingHeight;
        private final int xOffset;
        private final int yOffset;
        private boolean enabled;
        private boolean selected;

        public PaintingButton(int buttonId, RecipeHolder<PaintingRecipe> recipe, PaintingVariant variant) {
            this.buttonId = buttonId;
            this.recipe = recipe;
            this.sprite = Minecraft.getInstance().getPaintingTextures().get(variant);

            float maxSize = BUTTON_SIZE - 2;
            float scaleFactor = Math.min(maxSize / variant.getWidth(), maxSize / variant.getHeight());
            if (variant.getWidth() <= 16 && variant.getHeight() <= 16) {
                scaleFactor *= 0.6F;
            } else if (variant.getWidth() <= 32 && variant.getHeight() <= 32) {
                scaleFactor *= 0.85F;
            }

            this.paintingWidth = Math.max(1, (int) (variant.getWidth() * scaleFactor));
            this.paintingHeight = Math.max(1, (int) (variant.getHeight() * scaleFactor));
            this.xOffset = (int) ((maxSize - paintingWidth) / 2);
            this.yOffset = (int) ((maxSize - paintingHeight) / 2);
            this.enabled = false;
            this.selected = false;
        }

        public void register() {
            buttonList.add(buttonId, this);
        }

        public void render(GuiGraphics guiGraphics, int x, int y, int mouseX, int mouseY) {
            int textureY = 31;
            if (!enabled) {
                textureY += BUTTON_SIZE;
            } else if (selected) {
                textureY += BUTTON_SIZE * 3;
            } else if (mouseX >= x && mouseY >= y && mouseX < x + BUTTON_SIZE && mouseY < y + BUTTON_SIZE) {
                textureY += BUTTON_SIZE * 2;
            }

            guiGraphics.blit(BG_LOCATION, x, y, SCREEN_WIDTH, textureY, BUTTON_SIZE, BUTTON_SIZE);
            guiGraphics.blit(x + 1 + xOffset, y + 1 + yOffset, 0, paintingWidth, paintingHeight, sprite);
        }

        public void renderButtonTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
            // TODO: Display ingredients
            guiGraphics.renderTooltip(font, recipe.value().result(), mouseX, mouseY);
        }

        @SuppressWarnings("ConstantConditions")
        public boolean onClick() {
            if (menu.clickMenuButton(minecraft.player, buttonId)) {
                Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_LOOM_SELECT_PATTERN, 1.0F));
                minecraft.gameMode.handleInventoryButtonClick(menu.containerId, buttonId);
                buttonList.forEach(button -> button.selected = false);
                selected = true;
                return true;
            }
            return false;
        }
    }
}
