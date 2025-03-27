/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import phrille.vanillaboom.block.ModCandleCakeBlock;

import java.util.Map;

@Mixin(CandleCakeBlock.class)
public class CandleCakeMixin {
    @WrapWithCondition(
            method = "<init>",
            at = @At(value = "INVOKE", target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;")
    )
    public boolean isNotVanillaBoomCake(Map<CandleBlock, CandleCakeBlock> instance, Object candle, Object candleCake) {
        return !(candleCake instanceof ModCandleCakeBlock);
    }
}