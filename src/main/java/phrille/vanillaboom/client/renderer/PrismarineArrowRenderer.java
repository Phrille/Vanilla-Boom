package phrille.vanillaboom.client.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.PrismarineArrow;

@OnlyIn(Dist.CLIENT)
public class PrismarineArrowRenderer extends ArrowRenderer<PrismarineArrow> {
    public static final ResourceLocation PRISMARINE_ARROW_TEXTURE = new ResourceLocation(VanillaBoom.MOD_ID, "textures/entity/prismarine_arrow.png");

    public PrismarineArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PrismarineArrow entity) {
        return PRISMARINE_ARROW_TEXTURE;
    }
}