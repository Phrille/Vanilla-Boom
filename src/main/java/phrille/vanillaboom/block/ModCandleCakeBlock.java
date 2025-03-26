/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModCandleCakeBlock extends CandleCakeBlock {
    private final Supplier<Block> parent;

    @SuppressWarnings("ConstantConditions")
    public ModCandleCakeBlock(Block candle, Supplier<Block> parent) {
        // TODO: mixin
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

/*
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (!stack.is(Items.FLINT_AND_STEEL) && !stack.is(Items.FIRE_CHARGE)) {
            if (candleHit(hit) && player.getItemInHand(hand).isEmpty() && state.getValue(LIT)) {
                extinguish(player, state, level, pos);

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                InteractionResult interactionresult = ModCakeBlock.eat(level, pos, parent.get().defaultBlockState(), player);

                if (interactionresult.consumesAction()) {
                    dropResources(state, level, pos);
                }

                return interactionresult;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
*/

    @Override
    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(parent.get());
    }
}