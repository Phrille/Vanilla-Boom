package phrille.vanillaboom.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nonnull;

public class TunaModel<T extends Entity> extends ListModel<T> {
    private final ModelPart body;
    private final ModelPart bodyFront;
    private final ModelPart bodyBack;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart finRight;
    private final ModelPart finLeft;
    private final ModelPart tail;

    @SuppressWarnings("unused")
    public TunaModel(ModelPart part) {
        body = part.getChild("body");
        bodyFront = part.getChild("body_front");
        bodyBack = part.getChild("body_back");
        head = part.getChild("head");
        jaw = head.getChild("jaw");
        ModelPart finTop = body.getChild("fin_top");
        ModelPart finBottom = body.getChild("fin_bottom");
        finRight = part.getChild("fin_right");
        finLeft = part.getChild("fin_left");
        tail = bodyBack.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelDefinition = new MeshDefinition();
        PartDefinition def = modelDefinition.getRoot();

        PartDefinition bodyPart = def.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.5F, 0.0F, 3.0F, 7.0F, 8.0F), PartPose.offset(0.0F, 18.5F, 2.0F));
        def.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 18.5F, 0.0F));
        PartDefinition bodyBackPart = def.addOrReplaceChild("body_back", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 3.0F), PartPose.offset(0.0F, 18.5F, 10.0F));
        PartDefinition headPart = def.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
        headPart.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(24, 6).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 1.0F, 0.0F));
        bodyPart.addOrReplaceChild("fin_top", CubeListBuilder.create().texOffs(26, 19).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F), PartPose.offset(0.0F, -5.5F, 4.0F));
        bodyPart.addOrReplaceChild("fin_bottom", CubeListBuilder.create().texOffs(26, 21).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 3.5F, 3.0F));
        def.addOrReplaceChild("fin_right", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), PartPose.offset(1.5F, 19.0F, 4.0F));
        def.addOrReplaceChild("fin_left", CubeListBuilder.create().texOffs(0, 2).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), PartPose.offset(-1.5F, 19.0F, 4.0F));
        bodyBackPart.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(22, 22).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 3.0F));

        return LayerDefinition.create(modelDefinition, 32, 32);
    }

    @Override
    @Nonnull
    public Iterable<ModelPart> parts() {
        return ImmutableList.of(body, bodyFront, bodyBack, head, finRight, finLeft);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float movement = entity.isInWater() ? 1.0F : 1.5F;
        float f1 = -movement * 0.45F * Mth.sin(0.6F * ageInTicks);

        jaw.xRot = Math.abs(movement * 0.45F * Mth.sin(0.2F * ageInTicks));
        finLeft.zRot = -Math.abs(f1) * 1.2F;
        finRight.zRot = Math.abs(f1) * 1.2F;
        tail.yRot = f1;
    }
}
