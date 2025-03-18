/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.util.ModStats;

public class EaselBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final Component CONTAINER_TITLE = Component.translatable(VanillaBoom.MOD_ID + ".container.easel");

    public EaselBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    @SuppressWarnings("deprecation")
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter getter, BlockPos pos) {
        return LecternBlock.SHAPE_COMMON;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return LecternBlock.SHAPE_COLLISION;
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> LecternBlock.SHAPE_NORTH;
            case SOUTH -> LecternBlock.SHAPE_SOUTH;
            case EAST -> LecternBlock.SHAPE_EAST;
            case WEST -> LecternBlock.SHAPE_WEST;
            default -> LecternBlock.SHAPE_COMMON;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));
            player.awardStat(Stats.CUSTOM.get(ModStats.INTERACT_WITH_EASEL));
            return InteractionResult.CONSUME;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((containerId, inventory, player) -> new EaselMenu(containerId, inventory, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }
}
