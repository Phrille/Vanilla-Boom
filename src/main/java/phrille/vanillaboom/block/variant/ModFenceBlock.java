/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.variant;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.function.Supplier;

public class ModFenceBlock extends FenceBlock implements IVariantBlock {
    public static final List<ModFenceBlock> FENCES = Lists.newArrayList();
    protected final Supplier<BlockState> state;

    public ModFenceBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.copy(state.get().getBlock()));
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
