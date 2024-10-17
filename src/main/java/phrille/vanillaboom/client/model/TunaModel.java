package phrille.vanillaboom.client.model;

import com.google.common.collect.ImmutableList;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@MethodsReturnNonnullByDefault
public class TunaModel<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer finLeft;
    public ModelRenderer finRight;
    public ModelRenderer bodyFront;
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer bodyBack;
    public ModelRenderer finTop;
    public ModelRenderer finBottom;
    public ModelRenderer jaw;
    public ModelRenderer finTail;

    public TunaModel()
    {
        texWidth = 32;
        texHeight = 32;

        head = new ModelRenderer(this, 22, 0);
        head.setPos(0.0F, 19.0F, 0.0F);
        head.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        jaw = new ModelRenderer(this, 24, 6);
        jaw.setPos(0.0F, 1.0F, 0.0F);
        jaw.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        body = new ModelRenderer(this, 0, 0);
        body.setPos(0.0F, 18.5F, 2.0F);
        body.addBox(-1.5F, -3.5F, 0.0F, 3.0F, 7.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        bodyFront = new ModelRenderer(this, 0, 15);
        bodyFront.setPos(0.0F, 18.5F, 0.0F);
        bodyFront.addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        bodyBack = new ModelRenderer(this, 0, 22);
        bodyBack.setPos(0.0F, 18.5F, 10.0F);
        bodyBack.addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);

        finLeft = new ModelRenderer(this, 0, 2);
        finLeft.setPos(-1.5F, 19.0F, 4.0F);
        finLeft.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        finRight = new ModelRenderer(this, 0, 0);
        finRight.setPos(1.5F, 19.0F, 4.0F);
        finRight.addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        finTail = new ModelRenderer(this, 22, 22);
        finTail.setPos(0.0F, 0.0F, 3.0F);
        finTail.addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);

        finTop = new ModelRenderer(this, 26, 19);
        finTop.setPos(0.0F, -5.5F, 4.0F);
        finTop.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);

        finBottom = new ModelRenderer(this, 26, 21);
        finBottom.setPos(0.0F, 3.5F, 3.0F);
        finBottom.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);

        head.addChild(jaw);
        body.addChild(finBottom);
        body.addChild(finTop);
        bodyBack.addChild(finTail);
    }

    @Override
    public Iterable<ModelRenderer> parts()
    {
        return ImmutableList.of(head, body, bodyBack, finLeft, bodyFront, finRight);
    }
    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float movement = entity.isInWater() ? 1.0F : 1.5F;
        float finMovement = -movement * 0.45F * MathHelper.sin(0.6F * ageInTicks);

        jaw.xRot = Math.abs(movement * 0.45F * MathHelper.sin(0.2F * ageInTicks));
        finLeft.zRot = -Math.abs(finMovement) * 1.2F;
        finRight.zRot = Math.abs(finMovement) * 1.2F;
        finTail.yRot = finMovement;
    }
}
