package phrille.vanillaboom.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.fish.Fish;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class FishRenderer extends MobRenderer<Fish, EntityModel<Fish>> {
    public FishRenderer(EntityRendererProvider.Context context, EntityModel<Fish> model) {
        super(context, model, 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Fish fish) {
        return new ResourceLocation(VanillaBoom.MOD_ID, "textures/entity/" + Objects.requireNonNull(fish.getType().getRegistryName()).getPath() + ".png");
    }

    @Override
    protected void setupRotations(Fish fish, PoseStack matrix, float ageInTicks, float rotationYaw, float partialTicks) {
        super.setupRotations(fish, matrix, ageInTicks, rotationYaw, partialTicks);

        float rotation = 4.3F * Mth.sin(0.6F * ageInTicks);
        matrix.mulPose(Vector3f.YP.rotationDegrees(rotation));

        if (fish.getSize() == Fish.Size.LARGE) {
            matrix.translate(0.0F, 0.0F, -0.4F);
        }

        if (!fish.isInWater()) {
            if (fish.getSize() == Fish.Size.LARGE) {
                matrix.translate(0.2F, 0.1F, 0.0F);
            }

            matrix.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }
}
