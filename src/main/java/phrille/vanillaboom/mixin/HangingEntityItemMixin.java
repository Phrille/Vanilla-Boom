/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.item.HangingEntityItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.entity.ModAttachmentTypes;

@Mixin(HangingEntityItem.class)
public class HangingEntityItemMixin {
    @ModifyArg(
            method = "useOn",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EntityType;" +
                                                "updateCustomEntityTag(Lnet/minecraft/world/level/Level;" +
                                                "Lnet/minecraft/world/entity/player/Player;" +
                                                "Lnet/minecraft/world/entity/Entity;" +
                                                "Lnet/minecraft/world/item/component/CustomData;)V"),
            index = 2)
    private Entity modifyPaintingDrop(Entity entity) {
        if (VanillaBoomConfig.variantSensitivePaintingDrops && entity instanceof Painting) {
            entity.setData(ModAttachmentTypes.VARIANT_SET, true);
        }
        return entity;
    }
}
