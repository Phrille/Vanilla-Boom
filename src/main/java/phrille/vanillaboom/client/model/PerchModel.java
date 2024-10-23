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

public class PerchModel<T extends Entity> extends ListModel<T> {
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart headFront;
    private final ModelPart finTop;
    private final ModelPart finRight;
    private final ModelPart finLeft;
    private final ModelPart tail;

    public PerchModel(ModelPart part) {
        body = part.getChild("body");
        head = part.getChild("head");
        headFront = part.getChild("head_front");
        finTop = part.getChild("fin_top");
        finRight = part.getChild("fin_right");
        finLeft = part.getChild("fin_left");
        tail = part.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelDefinition = new MeshDefinition();
        PartDefinition def = modelDefinition.getRoot();
        float finRotation = ((float) Math.PI / 4F);

        def.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 7.0F), PartPose.offset(0.0F, 22.0F, 0.0F));
        def.addOrReplaceChild("head", CubeListBuilder.create().texOffs(11, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 22.0F, 0.0F));
        def.addOrReplaceChild("head_front", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 22.0F, -3.0F));
        def.addOrReplaceChild("fin_top", CubeListBuilder.create().texOffs(20, -6).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 20.0F, -3.0F));
        def.addOrReplaceChild("fin_right", CubeListBuilder.create().texOffs(22, 2).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F), PartPose.offsetAndRotation(-1.0F, 23.0F, 0.0F, 0.0F, 0.0F, -finRotation));
        def.addOrReplaceChild("fin_left", CubeListBuilder.create().texOffs(22, 4).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F), PartPose.offsetAndRotation(1.0F, 23.0F, 0.0F, 0.0F, 0.0F, finRotation));
        def.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(22, 3).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 22.0F, 7.0F));

        return LayerDefinition.create(modelDefinition, 32, 32);
    }

    @Override
    @Nonnull
    public Iterable<ModelPart> parts() {
        return ImmutableList.of(body, head, headFront, finRight, finLeft, tail, finTop);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float movement = entity.isInWater() ? 1.0F : 1.5F;
        tail.yRot = -movement * 0.45F * Mth.sin(0.6F * ageInTicks);
    }
}
