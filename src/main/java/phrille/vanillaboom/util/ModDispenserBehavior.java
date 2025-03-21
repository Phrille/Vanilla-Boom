/*
 * Copyright (C) 2024-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.item.WitherBoneMealItem;

public class ModDispenserBehavior {
    public static void registerWitherBonemealBehavior() {
        if (!VanillaBoomConfig.witherBoneMealEnabled) {
            return;
        }

        DispenserBlock.registerBehavior(ModItems.WITHER_BONE_MEAL.get(), new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                setSuccess(true);
                Level level = source.level();
                BlockPos pos = source.pos().relative(source.state().getValue(DispenserBlock.FACING));

                if (!WitherBoneMealItem.apply(stack, level, pos)) {
                    setSuccess(false);
                } else {
                    Utils.spawnParticles(ParticleTypes.SOUL, level, pos);
                    level.playLocalSound(pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                }
                return stack;
            }
        });
    }
}
