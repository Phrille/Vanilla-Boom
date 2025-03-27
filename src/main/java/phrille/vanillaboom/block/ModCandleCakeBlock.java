/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class ModCandleCakeBlock extends CandleCakeBlock {
    private final Supplier<Block> parent;

    public ModCandleCakeBlock(Block candle, Supplier<Block> parent) {
        super(candle, BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));

        if (candle instanceof CandleBlock candleBlock) {
            if (parent.get() instanceof ModCakeBlock cakeBlock) {
                cakeBlock.addCandleCake(candleBlock, this);
                this.parent = parent;
            } else {
                throw new IllegalArgumentException("Expected block to be of " + ModCakeBlock.class + " was " + parent.get().getClass());
            }
        } else {
            throw new IllegalArgumentException("Expected block to be of " + CandleBlock.class + " was " + candle.getClass());
        }

    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult result) {
        InteractionResult interactionResult = ModCakeBlock.eat(level, pos, parent.get().defaultBlockState(), player);
        if (interactionResult.consumesAction()) {
            dropResources(state, level, pos);
        }

        return interactionResult;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(parent.get());
    }
}