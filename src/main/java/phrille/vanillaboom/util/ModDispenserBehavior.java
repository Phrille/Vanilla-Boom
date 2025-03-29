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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.neoforge.network.PacketDistributor;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.item.WitherBoneMealItem;
import phrille.vanillaboom.network.WitherBoneMealPacket;

public class ModDispenserBehavior {
    public static void registerWitherBonemealBehavior() {
        if (!VanillaBoomConfig.witherBoneMealEnabled) {
            return;
        }

        DispenserBlock.registerBehavior(ModItems.WITHER_BONE_MEAL.get(), new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                setSuccess(true);
                ServerLevel level = source.level();
                BlockPos pos = source.pos().relative(source.state().getValue(DispenserBlock.FACING));

                if (!WitherBoneMealItem.apply(stack, level, pos)) {
                    setSuccess(false);
                } else if (!level.isClientSide) {
                    PacketDistributor.sendToPlayersNear(level, null, pos.getX(), pos.getY(), pos.getZ(), 64.0, new WitherBoneMealPacket(pos));
                }
                return stack;
            }
        });
    }
}
