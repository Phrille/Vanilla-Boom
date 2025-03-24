/*
 * Copyright (C) 2024-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import phrille.vanillaboom.util.Utils;

import javax.annotation.Nullable;

public abstract class TrellisCropBlock extends DoubleCropBlock implements ITrellisCrop {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public TrellisCropBlock(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return TrellisBlock.TRELLIS_SHAPE;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return null;
    }

    @Override
    public void placeAt(Level level, BlockPos pos) {
        Utils.setDoubleBlock(level, getStateForAge(0), pos, HALF);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER && !isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!level.isAreaLoaded(pos, 1) || level.getRawBrightness(pos, 0) < 9) {
            return;
        }

        int age = getAge(state);
        if (age < getMaxAge()) {
            float growthSpeed = getGrowthSpeed(this, level, pos);
            if (CommonHooks.onCropsGrowPre(level, pos, state, rand.nextInt((int) (25.0F / growthSpeed) + 1) == 0)) {
                growToAge(level, state, pos, age + 1, 2);
                CommonHooks.onCropsGrowPost(level, pos, state);
            }
        }
    }

    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int newAge = getAge(state) + getBonemealAgeIncrease(level);
        int maxAge = getMaxAge();

        if (newAge > maxAge) {
            newAge = maxAge;
        }
        growToAge(level, state, pos, newAge, 2);
    }

    @SuppressWarnings("SameParameterValue")
    protected void growToAge(Level level, BlockState oldState, BlockPos pos, int age, int flag) {
        if (age >= oldState.getValue(getAgeProperty())) {
            level.setBlock(pos, getStateForAge(age).setValue(HALF, DoubleBlockHalf.LOWER), flag);
            level.setBlock(pos.above(), getStateForAge(age).setValue(HALF, DoubleBlockHalf.UPPER), flag);
        } else {
            level.setBlock(pos.above(), getStateForAge(age).setValue(HALF, DoubleBlockHalf.UPPER), flag);
            level.setBlock(pos, getStateForAge(age).setValue(HALF, DoubleBlockHalf.LOWER), flag);
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            performBonemeal(level, rand, pos.below(), level.getBlockState(pos.below()));
            return;
        }
        super.performBonemeal(level, rand, pos, state);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return getBonemealIncrease(level);
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(AGE);
        boolean isMaxAge = age == getMaxAge();
        ItemStack stack = player.getItemInHand(hand);

        if (!isMaxAge && stack.is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        }
        if (isMaxAge) {
            popResource(level, pos, new ItemStack(getFruit()));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
                pos = pos.below();
            }
            growToAge(level, state, pos, 4, 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return getSeed();
    }
}
