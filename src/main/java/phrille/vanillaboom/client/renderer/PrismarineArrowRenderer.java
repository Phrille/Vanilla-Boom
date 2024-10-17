package phrille.vanillaboom.client.renderer;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.PrismarineArrow;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class PrismarineArrowRenderer extends ArrowRenderer<PrismarineArrow> {
    public static final ResourceLocation PRISMARINE_ARROW_TEXTURE = new ResourceLocation(VanillaBoom.MOD_ID, "textures/entity/prismarine_arrow.png");

    public PrismarineArrowRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    public ResourceLocation getTextureLocation(PrismarineArrow entity) {
        return PRISMARINE_ARROW_TEXTURE;
    }
}