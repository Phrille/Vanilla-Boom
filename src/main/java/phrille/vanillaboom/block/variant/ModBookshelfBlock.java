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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public class ModBookshelfBlock extends Block implements IVariantBlock {
    public static final List<ModBookshelfBlock> BOOKSHELVES = Lists.newArrayList();
    protected final Supplier<BlockState> state;

    public ModBookshelfBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.ofFullCopy(state.get().getBlock()));
    }

    public ModBookshelfBlock(Supplier<BlockState> state, Properties builder) {
        super(builder);
        this.state = state;
        BOOKSHELVES.add(this);
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader level, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public Block getParent() {
        return state.get().getBlock();
    }
}
