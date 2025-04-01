/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.variant;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public class ModFenceBlock extends FenceBlock implements IVariantBlock {
    public static final List<ModFenceBlock> FENCES = Lists.newArrayList();
    protected final Supplier<BlockState> state;

    @SuppressWarnings("deprecation")
    public ModFenceBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.ofLegacyCopy(state.get().getBlock()).forceSolidOn());
    }

    public ModFenceBlock(Supplier<BlockState> state, Properties builder) {
        super(builder);
        this.state = state;
        FENCES.add(this);
    }

    @Override
    public Block getParent() {
        return state.get().getBlock();
    }
}
