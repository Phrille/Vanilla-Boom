/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.variant;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public class ModWallBlock extends WallBlock implements IVariantBlock {
    public static final List<ModWallBlock> WALLS = Lists.newArrayList();
    protected final Supplier<BlockState> state;

    @SuppressWarnings("deprecation")
    public ModWallBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.ofLegacyCopy(state.get().getBlock()).forceSolidOn());
    }

    public ModWallBlock(Supplier<BlockState> state, BlockBehaviour.Properties builder) {
        super(builder);
        this.state = state;
        WALLS.add(this);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        getParent().stepOn(level, pos, state, entity);
    }

    @Override
    public Block getParent() {
        return state.get().getBlock();
    }
}
