package phrille.vanillaboom.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.inventory.EaselMenu;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class EaselScreen extends AbstractContainerScreen<EaselMenu> {
    private static final ResourceLocation BG_LOCATION = new ResourceLocation(VanillaBoom.MOD_ID, "textures/gui/container/easel.png");

    public EaselScreen(EaselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
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
        int i = leftPos;
        int j = topPos;
        blit(pose, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
