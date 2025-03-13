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
import java.util.Optional;

@ParametersAreNonnullByDefault
public class EaselScreen extends AbstractContainerScreen<EaselMenu> {
    private static final ResourceLocation BG_LOCATION = new ResourceLocation(VanillaBoom.MOD_ID, "textures/gui/container/easel.png");

    /* Screen coords */
    public static final int SCREEN_WIDTH = 176;
    public static final int SCREEN_HEIGHT = 184;
    public static final int SCROLL_BUTTON_WIDTH = 12;
    public static final int SCROLL_BUTTON_HEIGHT = 15;
    public static final int SCROLL_X = 126;
    public static final int SCROLL_Y = 15;
    public static final int SCROLL_HEIGHT = 72;
    public static final int LIST_X = 51;
    public static final int LIST_Y = 15;
    public static final int BUTTON_SIZE = 18;
    public static final int MAX_ITEMS = 16;

    /* Buttons */
    private final List<Button> buttonList;
    private int startIndex;

    /* Scrolling */
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
            Optional<PaintingVariant> variant = Utils.paintingVariantFromStack(recipe.result());
            if (variant.isPresent()) {
                buttonList.add(buttonId, new Button(recipe, variant.get(), false));
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
        int scrollY = (int) ((float) (SCROLL_HEIGHT - SCROLL_BUTTON_HEIGHT) * scrollOffset);
        blit(pose, x + SCROLL_X, y + SCROLL_Y + scrollY, SCREEN_WIDTH + (isScrollBarActive() ? 0 : SCROLL_BUTTON_WIDTH), 0, SCROLL_BUTTON_WIDTH, SCROLL_BUTTON_HEIGHT);

        // Dye slots
        menu.getDyeSlots().stream()
                .filter(slot -> !slot.hasItem())
                .forEach(slot -> blit(pose, x + slot.x, y + slot.y, SCREEN_WIDTH, 15, 16, 16));

        // Canvas slot
        Slot canvasSlot = menu.getCanvasSlot();
        if (!canvasSlot.hasItem()) {
            blit(pose, x + canvasSlot.x, y + canvasSlot.y, SCREEN_WIDTH + 16, 15, 16, 16);
        }

        // Buttons
        renderButtons(pose, x + LIST_X, y + LIST_Y, mouseX, mouseY);
    }

    private void renderButtons(PoseStack pose, int x, int y, int mouseX, int mouseY) {
        int max = startIndex + MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            Button button = buttonList.get(buttonId);
            int i = buttonId - startIndex;
            int buttonX = x + i % 4 * button.width;
            int buttonY = y + i / 4 * button.height;

            int textureX = SCREEN_WIDTH;
            if (button.selected) {
                textureX += button.width;
            } else if (mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + button.width && mouseY < buttonY + button.height) {
                textureX += button.width * 2;
            }

            blit(pose, buttonX, buttonY, textureX, 31, button.width, button.height);

            if (!button.enabled) {
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                RenderSystem.setShaderColor(0.3F, 0.3F, 0.3F, 1.0F);
            }

            RenderSystem.setShaderTexture(0, button.sprite.atlasLocation());
            blit(pose, buttonX + 1, buttonY + 1, 0, button.width - 2, button.height - 2, button.sprite);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.disableBlend();
            RenderSystem.setShaderTexture(0, BG_LOCATION);
        }
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public boolean mouseClicked(double mouseX, double mouseY, int buttonCode) {
        scrolling = false;

        int x = leftPos + LIST_X;
        int y = topPos + LIST_Y;
        int max = startIndex + MAX_ITEMS;
        boolean clicked = false;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            Button button = buttonList.get(buttonId);

            if (!button.enabled) {
                button.selected = false;
                continue;
            }

            int i = buttonId - startIndex;
            double buttonX = mouseX - (double) (x + i % 4 * button.width);
            double buttonY = mouseY - (double) (y + i / 4 * button.height);

            if (!clicked && buttonX >= 0.0D && buttonY >= 0.0D && buttonX < (double) button.width && buttonY < (double) button.height) {
                int recipeIndex = menu.getRecipes().indexOf(button.recipe);
                if (menu.clickMenuButton(minecraft.player, recipeIndex)) {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_LOOM_SELECT_PATTERN, 1.0F));
                    minecraft.gameMode.handleInventoryButtonClick(menu.containerId, recipeIndex);
                    button.selected = true;
                    clicked = true;
                }
            } else {
                button.selected = false;
            }
        }

        if (clicked) {
            return true;
        }

        x = leftPos + SCROLL_X;
        y = topPos + SCROLL_Y;
        if (mouseX >= (double) x && mouseX < (double) (x + SCROLL_BUTTON_WIDTH) && mouseY >= (double) y && mouseY < (double) (y + SCROLL_HEIGHT)) {
            scrolling = true;
        }

        return super.mouseClicked(mouseX, mouseY, buttonCode);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (scrolling && isScrollBarActive()) {
            int scrollY = topPos + SCROLL_Y;
            int scrollHeight = scrollY + SCROLL_HEIGHT;
            scrollOffset = ((float) mouseY - (float) scrollY - 7.5F) / ((float) (scrollHeight - scrollY) - 15.0F);
            scrollOffset = Mth.clamp(scrollOffset, 0.0F, 1.0F);
            startIndex = (int) ((double) (scrollOffset * (float) getOffscreenRows()) + 0.5D) * 4;
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
            startIndex = (int) ((double) (scrollOffset * (float) rows) + 0.5D) * 4;
        }

        return true;
    }

    @Override
    protected void renderTooltip(PoseStack pose, int mouseX, int mouseY) {
        super.renderTooltip(pose, mouseX, mouseY);

        int x = leftPos + LIST_X;
        int y = topPos + LIST_Y;
        int max = startIndex + MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < buttonList.size(); buttonId++) {
            Button button = buttonList.get(buttonId);
            int i = buttonId - startIndex;
            int buttonX = x + i % 4 * BUTTON_SIZE;
            int buttonY = y + i / 4 * BUTTON_SIZE;
            if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                renderTooltip(pose, button.recipe.result(), mouseX, mouseY);
            }
        }
    }

    private boolean isScrollBarActive() {
        return buttonList.size() > MAX_ITEMS;
    }

    protected int getOffscreenRows() {
        return ((buttonList.size() + 3) / 4) - 4;
    }

    private void containerChanged() {
        buttonList.forEach(button -> {
            button.enabled = menu.getRecipes().contains(button.recipe);
            button.selected = false;
        });

        if (!isScrollBarActive()) {
            scrollOffset = 0.0F;
            startIndex = 0;
        }
    }

    private static class Button {
        public final PaintingRecipe recipe;
        public final PaintingVariant variant;
        public final TextureAtlasSprite sprite;
        public final int width;
        public final int height;
        public final int area;
        public boolean enabled;
        public boolean selected;

        public Button(PaintingRecipe recipe, PaintingVariant variant, boolean enabled) {
            this.recipe = recipe;
            this.variant = variant;
            this.sprite = Minecraft.getInstance().getPaintingTextures().get(variant);
            this.enabled = enabled;
            // this.width = (variant.getWidth() / 16) * BUTTON_SIZE;
            // this.height = (variant.getHeight() / 16) * BUTTON_SIZE;
            this.width = BUTTON_SIZE;
            this.height = BUTTON_SIZE;
            this.area = variant.getWidth() * variant.getHeight();
        }
    }
}
