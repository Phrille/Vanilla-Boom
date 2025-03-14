package phrille.vanillaboom.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
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
import org.apache.commons.compress.utils.Lists;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;
import phrille.vanillaboom.util.Utils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
public class EaselScreen extends AbstractContainerScreen<EaselMenu> {
    private static final ResourceLocation BG_LOCATION = new ResourceLocation(VanillaBoom.MOD_ID, "textures/gui/container/easel.png");

    public static final int SCREEN_WIDTH = 176;
    public static final int SCREEN_HEIGHT = 184;

    /* Buttons */
    public static final int BUTTON_SIZE = 24;
    private final List<PaintingButton> buttonList;
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

        List<PaintingRecipe> recipeList = menu.getAllRecipes();
        buttonList = Lists.newArrayList();
        for (int buttonId = 0; buttonId < recipeList.size(); buttonId++) {
            PaintingRecipe recipe = recipeList.get(buttonId);
            PaintingVariant variant = Utils.paintingVariantFromStack(recipe.result());
            if (variant != null) {
                buttonList.add(buttonId, new PaintingButton(recipe, variant));
            }
        }
        buttonList.sort((a, b) -> a.area == b.area ? b.variant.getWidth() - a.variant.getWidth() : a.area - b.area);
    }

    @Override
    public void render(PoseStack pose, int mouseX, int mouseY, float partialTick) {
        super.render(pose, mouseX, mouseY, partialTick);
        renderTooltip(pose, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack pose, float partialTick, int mouseX, int mouseY) {
        renderBackground(pose);
        RenderSystem.setShaderTexture(0, BG_LOCATION);
        int x = leftPos;
        int y = topPos;

        // Background
        blit(pose, x, y, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Scrollbar
        int scrollY = (int) ((float) (SCROLLBAR_HEIGHT - SCROLL_BUTTON_HEIGHT) * scrollOffset);
        blit(pose, x + SCROLLBAR_X, y + SCROLLBAR_Y + scrollY, SCREEN_WIDTH + (isScrollBarActive() ? 0 : SCROLL_BUTTON_WIDTH), 0, SCROLL_BUTTON_WIDTH, SCROLL_BUTTON_HEIGHT);

        // Dye slots
        menu.getDyeSlots().stream()
                .filter(slot -> !slot.hasItem())
                .forEach(slot -> blit(pose, x + slot.x, y + slot.y, SCREEN_WIDTH, 15, SLOT_SIZE, SLOT_SIZE));

        // Canvas slot
        Slot canvasSlot = menu.getCanvasSlot();
        if (!canvasSlot.hasItem()) {
            blit(pose, x + canvasSlot.x, y + canvasSlot.y, SCREEN_WIDTH + SLOT_SIZE, 15, SLOT_SIZE, SLOT_SIZE);
        }

        // Grid
        renderGrid(pose, x + GRID_X, y + GRID_Y, mouseX, mouseY);
    }

    private void renderGrid(PoseStack pose, int x, int y, int mouseX, int mouseY) {
        int max = startIndex + GRID_MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            PaintingButton button = buttonList.get(buttonId);
            int i = buttonId - startIndex;
            int buttonX = x + i % GRID_COLUMNS * BUTTON_SIZE;
            int buttonY = y + i / GRID_COLUMNS * BUTTON_SIZE;
            button.render(pose, buttonX, buttonY, mouseX, mouseY);
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
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (isScrollBarActive()) {
            int rows = getOffscreenRows();
            float f = (float) delta / (float) rows;
            scrollOffset = Mth.clamp(scrollOffset - f, 0.0F, 1.0F);
            startIndex = (int) ((double) (scrollOffset * (float) rows) + 0.5D) * GRID_COLUMNS;
        }

        return true;
    }

    @Override
    protected void renderTooltip(PoseStack pose, int mouseX, int mouseY) {
        super.renderTooltip(pose, mouseX, mouseY);

        int x = leftPos + GRID_X;
        int y = topPos + GRID_Y;
        int max = startIndex + GRID_MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            PaintingButton button = buttonList.get(buttonId);
            int i = buttonId - startIndex;
            int buttonX = x + i % GRID_COLUMNS * BUTTON_SIZE;
            int buttonY = y + i / GRID_COLUMNS * BUTTON_SIZE;

            if (mouseX >= buttonX && mouseX < buttonX + BUTTON_SIZE && mouseY >= buttonY && mouseY < buttonY + BUTTON_SIZE) {
                button.renderButtonTooltip(pose, mouseX, mouseY);
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
            button.enabled = menu.getRecipes().contains(button.recipe);
            button.selected = button.enabled && button.selected;
        });

        if (!isScrollBarActive()) {
            scrollOffset = 0.0F;
            startIndex = 0;
        }
    }

    private class PaintingButton {
        private final PaintingRecipe recipe;
        private final PaintingVariant variant;
        private final TextureAtlasSprite sprite;
        private final int paintingWidth;
        private final int paintingHeight;
        private final int xOffset;
        private final int yOffset;
        private final int area;
        private boolean enabled;
        private boolean selected;

        public PaintingButton(PaintingRecipe recipe, PaintingVariant variant) {
            this.recipe = recipe;
            this.variant = variant;
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

            this.area = variant.getWidth() * variant.getHeight();
            this.enabled = false;
            this.selected = false;
        }

        public void render(PoseStack pose, int x, int y, int mouseX, int mouseY) {
            int textureY = 31;
            if (!enabled) {
                textureY += BUTTON_SIZE;
            } else if (selected) {
                textureY += BUTTON_SIZE * 3;
            } else if (mouseX >= x && mouseY >= y && mouseX < x + BUTTON_SIZE && mouseY < y + BUTTON_SIZE) {
                textureY += BUTTON_SIZE * 2;
            }

            blit(pose, x, y, SCREEN_WIDTH, textureY, BUTTON_SIZE, BUTTON_SIZE);

            RenderSystem.setShaderTexture(0, sprite.atlasLocation());
            blit(pose, x + 1 + xOffset, y + 1 + yOffset, 0, paintingWidth, paintingHeight, sprite);
            RenderSystem.setShaderTexture(0, BG_LOCATION);
        }

        public void renderButtonTooltip(PoseStack pose, int mouseX, int mouseY) {
            // TODO: Display ingredients
            renderTooltip(pose, recipe.result(), mouseX, mouseY);
        }

        @SuppressWarnings("ConstantConditions")
        public boolean onClick() {
            // TODO: this might set the wrong index since it's getting the index from the client side and setting it on the server.
            // Quickfix: sorting the recipes when updating the list on both client and server side.
            int recipeIndex = menu.getRecipes().indexOf(recipe);

            if (menu.clickMenuButton(minecraft.player, recipeIndex)) {
                Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_LOOM_SELECT_PATTERN, 1.0F));
                minecraft.gameMode.handleInventoryButtonClick(menu.containerId, recipeIndex);
                buttonList.forEach(button -> button.selected = false);
                selected = true;
                return true;
            }
            return false;
        }
    }
}
