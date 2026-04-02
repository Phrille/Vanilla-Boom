/*
 * Copyright (C) 2024-2026 Phrille
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.common.CommonHooks;
import phrille.vanillaboom.block.BlockUtils;

import javax.annotation.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.DOUBLE_BLOCK_HALF;

public class DoubleCropBlock extends CropBlock {
    public DoubleCropBlock(Properties builder) {
        super(builder);
        registerDefaultState(stateDefinition.any()
                .setValue(DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER)
                .setValue(getAgeProperty(), 0));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf half = state.getValue(DOUBLE_BLOCK_HALF);
        if (direction.getAxis() != Direction.Axis.Y
                || half == DoubleBlockHalf.LOWER != (direction == Direction.UP)
                || neighborState.is(this) && neighborState.getValue(DOUBLE_BLOCK_HALF) != half) {
            return half == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }
        return Blocks.AIR.defaultBlockState();
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        if (pos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(pos.above()).canBeReplaced(context)) {
            return super.getStateForPlacement(context);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        BlockPos above = pos.above();
        level.setBlock(above, defaultBlockState().setValue(DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            return super.canSurvive(state, level, pos) && level.getBlockState(pos.above()).is(this);
        }

        BlockState belowState = level.getBlockState(pos.below());
        if (state.getBlock() != this) {
            return super.canSurvive(belowState, level, pos);
        }
        return belowState.is(this) && belowState.getValue(DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER && !isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!level.isAreaLoaded(pos, 1) || level.getRawBrightness(pos, 0) < 9) {
            return;
        }

        int age = getAge(state);
        if (age < getMaxAge()) {
            float growthSpeed = getGrowthSpeed(state, level, pos);

            if (CommonHooks.canCropGrow(level, pos, state, rand.nextInt((int) (25.0f / growthSpeed) + 1) == 0)) {
                DoublePlantBlock.placeAt(level, getStateForAge(age), pos, 2);
                CommonHooks.fireCropGrowPost(level, pos, state);
            }
        }
    }

    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        // Safety check, this should always be called from the lower half
        if (state.getValue(DOUBLE_BLOCK_HALF) != DoubleBlockHalf.LOWER) {
            return;
        }

        int age = Math.min(getAge(state) + getBonemealAgeIncrease(level), getMaxAge());
        DoublePlantBlock.placeAt(level, getStateForAge(age), pos, 2);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        if (state.getValue(DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER) {
            performBonemeal(level, rand, pos.below(), level.getBlockState(pos.below()));
            return;
        }
        super.performBonemeal(level, rand, pos, state);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                BlockUtils.preventCreativeDropFromBottomPart(level, pos, state, player);
            } else {
                dropResources(state, level, pos, null, player, player.getMainHandItem());
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), blockEntity, stack);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DOUBLE_BLOCK_HALF);
    }
}
