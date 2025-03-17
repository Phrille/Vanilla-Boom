package phrille.vanillaboom.client.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.PrismarineArrow;

public class PrismarineArrowRenderer extends ArrowRenderer<PrismarineArrow> {
    public static final ResourceLocation PRISMARINE_ARROW_TEXTURE = new ResourceLocation(VanillaBoom.MOD_ID, "textures/entity/prismarine_arrow.png");

    public PrismarineArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PrismarineArrow arrow) {
        return PRISMARINE_ARROW_TEXTURE;
    }
}