/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class EelModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart head;
    private final ModelPart bodyFront;
    private final ModelPart bodyMiddle;
    private final ModelPart bodyBack;
    private final ModelPart tail;

    @SuppressWarnings("unused")
    public EelModel(ModelPart part) {
        head = part.getChild("head");

        bodyFront = head.getChild("body_front");
        ModelPart finFront = bodyFront.getChild("fin_front");
        ModelPart finRight = bodyFront.getChild("fin_right");
        ModelPart finLeft = bodyFront.getChild("fin_left");

        bodyMiddle = bodyFront.getChild("body_middle");
        ModelPart finMiddle = bodyMiddle.getChild("fin_middle");

        bodyBack = bodyMiddle.getChild("body_back");
        ModelPart finBack = bodyBack.getChild("fin_back");
        tail = bodyBack.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelDefinition = new MeshDefinition();
        PartDefinition def = modelDefinition.getRoot();
        float finRotation = ((float) Math.PI / 4F);

        PartDefinition head = def.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 22.0F, -1.0F));

        PartDefinition bodyFront = head.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F), PartPose.offset(0.0F, 0.0F, -1.0F));
        bodyFront.addOrReplaceChild("fin_front", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
        bodyFront.addOrReplaceChild("fin_right", CubeListBuilder.create().texOffs(-4, 0).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), PartPose.offsetAndRotation(-1.0F, 0.5F, 2.0F, 0.0F, 0.0F, -finRotation));
        bodyFront.addOrReplaceChild("fin_left", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), PartPose.offsetAndRotation(1.0F, 0.5F, 2.0F, 0.0F, 0.0F, finRotation));

        PartDefinition bodyMiddle = bodyFront.addOrReplaceChild("body_middle", CubeListBuilder.create().texOffs(12, 11).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
        bodyMiddle.addOrReplaceChild("fin_middle", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition bodyBack = bodyMiddle.addOrReplaceChild("body_back", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
        bodyBack.addOrReplaceChild("fin_back", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
        bodyBack.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(2, 12).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 8.0F));

        return LayerDefinition.create(modelDefinition, 32, 32);
    }

    @Override
    public ModelPart root() {
        return head;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float movement = 1.3F;
        float finMovement = 1.7F;

        if (entity.isInWater()) {
            movement = (float) Mth.clamp(Math.max(Math.abs(entity.getDeltaMovement().x), Math.abs(entity.getDeltaMovement().z)) * 20.0F, 0.2F, 1.0F);
            finMovement = 1.0F;
        }

        bodyFront.yRot = movement * 0.25F * Mth.sin(finMovement * 0.5F * ageInTicks);
        bodyMiddle.yRot = bodyFront.yRot * -2.0F;
        bodyBack.yRot = bodyFront.yRot * 2.0F;
        tail.yRot = bodyMiddle.yRot * -0.8F;
    }
}