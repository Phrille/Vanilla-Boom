package phrille.vanillaboom.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.entity.ModAttachmentTypes;
import phrille.vanillaboom.util.PaintingUtils;

@Mixin(Painting.class)
public class PaintingMixin {
    @ModifyExpressionValue(
            method = "dropItem",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/decoration/Painting;" +
                                                "spawnAtLocation(Lnet/minecraft/world/level/ItemLike;)" +
                                                "Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemEntity modifyPaintingDrop(ItemEntity original) {
        Painting painting = (Painting) (Object) this;
        if (painting != null && VanillaBoomConfig.variantSensitivePaintingDrops && painting.getData(ModAttachmentTypes.VARIANT_SET)) {
            original.setItem(PaintingUtils.stackFromHolder(painting.getVariant()));
        }
        return original;
    }
}
