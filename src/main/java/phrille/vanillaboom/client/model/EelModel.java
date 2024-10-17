package phrille.vanillaboom.client.model;

import com.google.common.collect.ImmutableList;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@MethodsReturnNonnullByDefault
public class EelModel<T extends Entity> extends SegmentedModel<T> {
    protected ModelRenderer finRight;
    protected ModelRenderer finLeft;
    protected ModelRenderer bodyFront;
    protected ModelRenderer bodyMiddle;
    protected ModelRenderer head;
    protected ModelRenderer finFront;
    protected ModelRenderer finMiddle;
    protected ModelRenderer bodyBack;
    protected ModelRenderer finTail;
    protected ModelRenderer finBack;

    public EelModel()
    {
        texWidth = 32;
        texHeight = 32;

        head = new ModelRenderer(this, 12, 0);
        head.setPos(0.0F, 22.0F, -1.0F);
        head.addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);

        finFront = new ModelRenderer(this, 0, 4);
        finFront.setPos(0.0F, -2.0F, 0.0F);
        finFront.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        bodyFront = new ModelRenderer(this, 0, 0);
        bodyFront.setPos(0.0F, 0.0F, -1.0F);
        bodyFront.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        bodyMiddle = new ModelRenderer(this, 12, 11);
        bodyMiddle.setPos(0.0F, 0.0F, 8.0F);
        bodyMiddle.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        finMiddle = new ModelRenderer(this, 0, 5);
        finMiddle.setPos(0.0F, -2.0F, 0.0F);
        finMiddle.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        bodyBack = new ModelRenderer(this, 0, 21);
        bodyBack.setPos(0.0F, 0.0F, 8.0F);
        bodyBack.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        finBack = new ModelRenderer(this, 0, 6);
        finBack.setPos(0.0F, -2.0F, 0.0F);
        finBack.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        finTail = new ModelRenderer(this, 2, 12);
        finTail.setPos(0.0F, 0.0F, 8.0F);
        finTail.addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);

        finRight = new ModelRenderer(this, -4, 0);
        finRight.setPos(-1.0F, 0.5F, 2.0F);
        finRight.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        finRight.zRot = (-(float) Math.PI / 4F);

        finLeft = new ModelRenderer(this, 0, 0);
        finLeft.setPos(1.0F, 0.5F, 2.0F);
        finLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        finLeft.zRot = ((float) Math.PI / 4F);

        head.addChild(bodyFront);
        bodyFront.addChild(bodyMiddle);
        bodyFront.addChild(finLeft);
        bodyFront.addChild(finRight);
        bodyFront.addChild(finFront);
        bodyMiddle.addChild(bodyBack);
        bodyMiddle.addChild(finMiddle);
        bodyBack.addChild(finBack);
        bodyBack.addChild(finTail);
    }

    @Override
    public Iterable<ModelRenderer> parts()
    {
        return ImmutableList.of(head);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float movement = 1.3F;
        float finMovement = 1.7F;

        if (entity.isInWater()) {
            movement = (float) MathHelper.clamp(Math.max(Math.abs(entity.getDeltaMovement().x), Math.abs(entity.getDeltaMovement().z)) * 20.0F, 0.2F, 1.0F);
            finMovement = 1.0F;
        }

        bodyFront.yRot = movement * 0.25F * MathHelper.sin(finMovement * 0.5F * ageInTicks);
        bodyMiddle.yRot = bodyFront.yRot * -2.0F;
        bodyBack.yRot = bodyFront.yRot * 2.0F;
        finTail.yRot = bodyMiddle.yRot * -0.8F;
    }
}
