package phrille.vanillaboom.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.inventory.EaselMenu;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class EaselScreen extends AbstractContainerScreen<EaselMenu> {
    public static final int SCREEN_WIDTH = 176;
    public static final int SCREEN_HEIGHT = 184;
    public static final int SCROLL_X = 126;
    public static final int SCROLL_Y = 15;
    public static final int SCROLL_HEIGHT = 72;
    public static final int LIST_X = 51;
    public static final int LIST_Y = 15;
    public static final int BUTTON_SIZE = 18;
    public static final int MAX_ITEMS = 16;
    private static final ResourceLocation BG_LOCATION = new ResourceLocation(VanillaBoom.MOD_ID, "textures/gui/container/easel.png");
    private boolean displayRecipes;
    private float scrollOffset;
    private boolean scrolling;
    private int startIndex;

    public EaselScreen(EaselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        menu.registerUpdateListener(this::containerChanged);
        imageWidth = SCREEN_WIDTH;
        imageHeight = SCREEN_HEIGHT;
        --titleLabelY;
        inventoryLabelY += 19;
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
        blit(pose, x, y, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        int scrollY = (int) (41.0F * scrollOffset);
        blit(pose, x + SCROLL_X, y + SCROLL_Y + scrollY, SCREEN_WIDTH + (isScrollBarActive() ? 0 : 12), 0, 12, 15);

        renderButtons(pose, x + LIST_X, y + LIST_Y, mouseX, mouseY);
        renderRecipes(pose, x + LIST_X, y + LIST_Y);
    }

    private void renderButtons(PoseStack pose, int x, int y, int mouseX, int mouseY) {
        int max = startIndex + MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < menu.getRecipes().size(); buttonId++) {
            int i = buttonId - startIndex;
            int buttonX = x + i % 4 * BUTTON_SIZE;
            int buttonY = y + i / 4 * BUTTON_SIZE;

            int textureX = SCREEN_WIDTH;
            int textureY = 15;
            if (buttonId == menu.getSelectedPaintingIndex()) {
                textureX += BUTTON_SIZE;
            } else if (mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + BUTTON_SIZE && mouseY < buttonY + BUTTON_SIZE) {
                textureX += BUTTON_SIZE * 2;
            }

            blit(pose, buttonX, buttonY, textureX, textureY, BUTTON_SIZE, BUTTON_SIZE);
        }
    }

    private void renderRecipes(PoseStack pose, int x, int y) {
        int max = startIndex + MAX_ITEMS;

        for (int buttonId = startIndex; buttonId < max && buttonId < menu.getRecipes().size(); buttonId++) {
            int i = buttonId - startIndex;
            int buttonX = x + i % 4 * BUTTON_SIZE;
            int buttonY = y + i / 4 * BUTTON_SIZE;

            PaintingVariant variant = getPaintingVariant(menu.getRecipes().get(buttonId).result());
            if (variant == null) {
                continue;
            }

            TextureAtlasSprite sprite = Minecraft.getInstance().getPaintingTextures().get(variant);
            RenderSystem.setShaderTexture(0, sprite.atlasLocation());
            blit(pose, buttonX + 1, buttonY + 1, 0, BUTTON_SIZE - 2, BUTTON_SIZE - 2, sprite);
            RenderSystem.setShaderTexture(0, BG_LOCATION);
        }
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        scrolling = false;

        if (displayRecipes) {
            int x = leftPos + LIST_X;
            int y = topPos + LIST_Y;
            int max = startIndex + MAX_ITEMS;

            for (int index = startIndex; index < max; ++index) {
                int i = index - startIndex;
                double buttonX = mouseX - (double) (x + i % 4 * BUTTON_SIZE);
                double buttonY = mouseY - (double) (y + i / 4 * BUTTON_SIZE);

                if (buttonX >= 0.0D && buttonY >= 0.0D && buttonX < (double) BUTTON_SIZE && buttonY < (double) BUTTON_SIZE && menu.clickMenuButton(minecraft.player, index)) {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_LOOM_SELECT_PATTERN, 1.0F));
                    minecraft.gameMode.handleInventoryButtonClick(menu.containerId, index);
                    return true;
                }
            }

            x = leftPos + SCROLL_X;
            y = topPos + SCROLL_Y;
            if (mouseX >= (double) x && mouseX < (double) (x + 12) && mouseY >= (double) y && mouseY < (double) (y + 72)) {
                scrolling = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
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
        if (this.isScrollBarActive()) {
            int rows = this.getOffscreenRows();
            float f = (float) delta / (float) rows;
            scrollOffset = Mth.clamp(scrollOffset - f, 0.0F, 1.0F);
            startIndex = (int) ((double) (scrollOffset * (float) rows) + 0.5D) * 4;
        }

        return true;
    }

    private boolean isScrollBarActive() {
        return displayRecipes && menu.getRecipes().size() > MAX_ITEMS;
    }

    protected int getOffscreenRows() {
        return ((menu.getRecipes().size() + 3) / 4) - 4;
    }

    private void containerChanged() {
        displayRecipes = menu.getRecipes().size() > 0;
        if (!displayRecipes) {
            scrollOffset = 0.0F;
            startIndex = 0;
        }
    }

    private PaintingVariant getPaintingVariant(ItemStack paintingStack) {
        if (paintingStack.getTag() != null && paintingStack.getTag().contains("EntityTag")) {
            CompoundTag entityTag = paintingStack.getTag().getCompound("EntityTag");
            String variant = entityTag.getString("variant");
            return ForgeRegistries.PAINTING_VARIANTS.getValue(new ResourceLocation(variant));
        }

        return null;
    }
}
