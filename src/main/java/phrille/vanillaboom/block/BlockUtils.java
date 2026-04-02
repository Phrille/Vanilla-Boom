/*
 * Copyright (C) 2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Fluids;
import phrille.vanillaboom.VanillaBoom;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.DOUBLE_BLOCK_HALF;

public class BlockUtils {
    public static void preventCreativeDropFromBottomPart(Level level, BlockPos pos, BlockState state, Player player) {
        if (state.getValue(DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER) {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            if (belowState.is(state.getBlock()) && belowState.getValue(DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
                BlockState fluidState = belowState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(belowPos, fluidState, 35);
                level.levelEvent(player, 2001, belowPos, Block.getId(belowState));
            }
        }
    }

    public static void spawnParticles(SimpleParticleType particle, Level level, BlockPos pos) {
        if (!level.getBlockState(pos).isSolidRender(level, pos)) {
            for (int l = 0; l < 8; ++l) {
                level.addParticle(particle,
                        (double) pos.getX() + level.random.nextDouble(),
                        (double) pos.getY() + level.random.nextDouble(),
                        (double) pos.getZ() + level.random.nextDouble(),
                        0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static void registerFlowerPots() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VanillaBoom.resLoc("rose"), ModBlocks.POTTED_ROSE);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VanillaBoom.resLoc("peony"), ModBlocks.POTTED_PEONY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VanillaBoom.resLoc("lilac"), ModBlocks.POTTED_LILAC);
    }
}
