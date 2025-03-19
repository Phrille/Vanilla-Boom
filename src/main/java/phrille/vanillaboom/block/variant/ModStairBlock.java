/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.variant;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public class ModStairBlock extends StairBlock implements IVariantBlock {
    public static final List<ModStairBlock> STAIRS = Lists.newArrayList();
    protected final Supplier<BlockState> state;

    public ModStairBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.copy(state.get().getBlock()));
    }

    public ModStairBlock(Supplier<BlockState> state, BlockBehaviour.Properties builder) {
        super(state, builder);
        this.state = state;
        STAIRS.add(this);
    }

    @Override
    public Block getParent() {
        return state.get().getBlock();
    }
}
