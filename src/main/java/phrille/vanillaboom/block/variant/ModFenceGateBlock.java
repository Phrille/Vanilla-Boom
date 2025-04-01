/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.variant;

import com.google.common.collect.Lists;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.List;
import java.util.function.Supplier;

public class ModFenceGateBlock extends FenceGateBlock implements IVariantBlock {
    public static final List<ModFenceGateBlock> FENCE_GATES = Lists.newArrayList();
    protected final Supplier<BlockState> state;

    @SuppressWarnings("deprecation")
    public ModFenceGateBlock(Supplier<BlockState> state, WoodType woodType) {
        this(state, BlockBehaviour.Properties.ofLegacyCopy(state.get().getBlock()).forceSolidOn(), woodType);
    }

    public ModFenceGateBlock(Supplier<BlockState> state, Properties builder, WoodType woodType) {
        this(state, builder, woodType.fenceGateOpen(), woodType.fenceGateClose());
    }

    public ModFenceGateBlock(Supplier<BlockState> state, Properties builder, SoundEvent open, SoundEvent close) {
        super(builder, open, close);
        this.state = state;
        FENCE_GATES.add(this);
    }

    @Override
    public Block getParent() {
        return state.get().getBlock();
    }
}
