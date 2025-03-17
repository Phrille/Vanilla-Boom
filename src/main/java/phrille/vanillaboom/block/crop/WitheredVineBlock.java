/*
 * Copyright (C) 2024-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;

public class WitheredVineBlock extends VineBlock {
    public WitheredVineBlock() {
        super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().strength(0.2F).sound(SoundType.VINE));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        // No-op implementation
    }

    @Override
    public boolean canSupportAtFace(BlockGetter getter, BlockPos pos, Direction direction) {
        if (direction == Direction.DOWN) {
            return false;
        } else {
            if (VineBlock.isAcceptableNeighbour(getter, pos.relative(direction), direction)) {
                return true;
            } else if (direction.getAxis() == Direction.Axis.Y) {
                return false;
            } else {
                BlockState aboveState = getter.getBlockState(pos.above());
                return aboveState.is(Blocks.VINE) && aboveState.getValue(PROPERTY_BY_DIRECTION.get(direction));
            }
        }
    }

    @Override
    public BlockState getUpdatedState(BlockState state, BlockGetter getter, BlockPos pos) {
        BlockPos above = pos.above();
        if (state.getValue(UP)) {
            state = state.setValue(UP, VineBlock.isAcceptableNeighbour(getter, above, Direction.DOWN));
        }

        BlockState aboveState = null;
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BooleanProperty property = getPropertyForFace(direction);
            if (state.getValue(property)) {
                boolean canSupportFace = canSupportAtFace(getter, pos, direction);
                if (!canSupportFace) {
                    if (aboveState == null) {
                        aboveState = getter.getBlockState(above);
                    }
                    canSupportFace = aboveState.is(Blocks.VINE) && aboveState.getValue(property);
                }
                state = state.setValue(property, canSupportFace);
            }
        }
        return state;
    }
}
