/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.fish.Fish;

import java.util.Objects;

public class FishRenderer extends MobRenderer<Fish, EntityModel<Fish>> {
    public FishRenderer(EntityRendererProvider.Context context, EntityModel<Fish> model) {
        super(context, model, 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Fish fish) {
        return VanillaBoom.resLoc("textures/entity/" + Objects.requireNonNull(BuiltInRegistries.ENTITY_TYPE.getKey(fish.getType())).getPath() + ".png");
    }

    @Override
    protected void setupRotations(Fish fish, PoseStack matrix, float ageInTicks, float rotationYaw, float partialTicks) {
        super.setupRotations(fish, matrix, ageInTicks, rotationYaw, partialTicks);

        float rotation = 4.3F * Mth.sin(0.6F * ageInTicks);
        matrix.mulPose(Axis.YP.rotationDegrees(rotation));

        if (fish.getSize() == Fish.Size.LARGE) {
            matrix.translate(0.0F, 0.0F, -0.4F);
        }

        if (!fish.isInWater()) {
            if (fish.getSize() == Fish.Size.LARGE) {
                matrix.translate(0.2F, 0.1F, 0.0F);
            }

            matrix.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }
}
