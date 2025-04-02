/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BasePressurePlateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.List;

public class LifePressurePlateBlock extends BasePressurePlateBlock {
    public static MapCodec<LifePressurePlateBlock> CODEC = MapCodec.unit(LifePressurePlateBlock::new);
    public static final IntegerProperty POWER = BlockStateProperties.POWER;

    public LifePressurePlateBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .forceSolidOn()
                .requiresCorrectToolForDrops()
                .noCollission()
                .strength(0.5F)
                .pushReaction(PushReaction.DESTROY), BlockSetType.STONE);
        registerDefaultState(stateDefinition.any().setValue(POWER, 0));
    }

    @Override
    protected MapCodec<? extends BasePressurePlateBlock> codec() {
        return CODEC;
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos pos) {
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, TOUCH_AABB.move(pos), EntitySelector.NO_SPECTATORS
                .and(entity -> !entity.isIgnoringBlockTriggers()));
        if (entities.isEmpty()) return 0;
        entities.forEach(System.out::println);

        double health = entities.stream().mapToDouble(LivingEntity::getHealth).sum();
        double maxHealth = entities.stream().mapToDouble(LivingEntity::getMaxHealth).sum();

        return maxHealth == 0 ? 0 : (int) Math.round((health / maxHealth) * 15);
    }

    @Override
    protected int getSignalForState(BlockState state) {
        return state.getValue(POWER);
    }

    @Override
    protected BlockState setSignalForState(BlockState state, int power) {
        return state.setValue(POWER, power);
    }

    @Override
    protected int getPressedTime() {
        return 10;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }
}
