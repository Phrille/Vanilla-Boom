/*
 * Copyright (C) 2023-2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.PistonType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.crop.ShearedTallFlowerBlock;
import phrille.vanillaboom.config.VanillaBoomConfig;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class ItemEventHandler {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = event.getItemStack();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();

        if (event.isCanceled() || stack.isEmpty()) return;

        InteractionResult result = InteractionResult.PASS;

        if (stack.is(Tags.Items.SLIME_BALLS)) {
            result = useSlimeBall(level, player, state, pos, stack);
        } else if (stack.is(ItemTags.AXES) && player.isCrouching()) {
            result = removeSlimeBall(level, player, state, pos, stack, hand);
        } else if (stack.is(Tags.Items.TOOLS_SHEAR)) {
            result = shearTallFlower(level, player, state, pos, stack, hand);
        }

        event.setCancellationResult(result);
    }

    protected static InteractionResult useSlimeBall(Level level, Player player, BlockState state, BlockPos pos, ItemStack stack) {
        if (!VanillaBoomConfig.placeSlimeBallPistons) return InteractionResult.PASS;

        if (state.getBlock() == Blocks.PISTON && !state.getValue(PistonBaseBlock.EXTENDED)) {
            Direction direction = state.getValue(PistonBaseBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.STICKY_PISTON.defaultBlockState().setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else if (state.getBlock() == Blocks.PISTON_HEAD && state.getValue(PistonHeadBlock.TYPE) == PistonType.DEFAULT) {
            Direction direction = state.getValue(PistonBaseBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.PISTON_HEAD.defaultBlockState().setValue(PistonHeadBlock.TYPE, PistonType.STICKY).setValue(PistonHeadBlock.FACING, direction), 2);
                level.setBlock(pos.relative(direction, -1), Blocks.STICKY_PISTON.defaultBlockState().setValue(PistonBaseBlock.EXTENDED, true).setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else {
            return InteractionResult.PASS;
        }

        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (!player.isCreative() && !level.isClientSide) {
            stack.shrink(1);
        }

        return InteractionResult.CONSUME;
    }

    protected static InteractionResult removeSlimeBall(Level level, Player player, BlockState state, BlockPos pos, ItemStack stack, InteractionHand hand) {
        if (!VanillaBoomConfig.removeSlimeBallPistons) return InteractionResult.PASS;

        if (state.getBlock() == Blocks.STICKY_PISTON && !state.getValue(PistonBaseBlock.EXTENDED)) {
            Direction direction = state.getValue(PistonBaseBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.PISTON.defaultBlockState().setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else if (state.getBlock() == Blocks.PISTON_HEAD && state.getValue(PistonHeadBlock.TYPE) == PistonType.STICKY) {
            Direction direction = state.getValue(PistonHeadBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.PISTON_HEAD.defaultBlockState().setValue(PistonHeadBlock.TYPE, PistonType.DEFAULT).setValue(PistonHeadBlock.FACING, direction), 2);
                level.setBlock(pos.relative(direction, -1), Blocks.PISTON.defaultBlockState().setValue(PistonBaseBlock.EXTENDED, true).setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else {
            return InteractionResult.PASS;
        }

        Block.popResource(level, pos, new ItemStack(Items.SLIME_BALL));
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        level.playSound(null, pos, SoundEvents.CHICKEN_EGG, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (!player.isCreative()) {
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
        }

        return InteractionResult.CONSUME_PARTIAL;
    }

    protected static InteractionResult shearTallFlower(Level level, Player player, BlockState state, BlockPos pos, ItemStack stack, InteractionHand hand) {
        if (!VanillaBoomConfig.shearTallFlowers) return InteractionResult.PASS;

        ShearedTallFlowerBlock shearedTallFlower;
        if (state.getBlock() instanceof TallFlowerBlock tallFlower && ShearedTallFlowerBlock.getShearedFlowerBlocks().containsKey(tallFlower)) {
            BlockPos lowerPos = state.getValue(TallFlowerBlock.HALF) == DoubleBlockHalf.LOWER ? pos : pos.below();
            shearedTallFlower = ShearedTallFlowerBlock.getShearedFlowerBlocks().get(tallFlower);
            if (!level.isClientSide) {
                // Hacky workaround to prevent the newly placed ShearedTallFlowerBlock from breaking due to the lower
                // part being placed. This causes the upper part of TallFlowerBlock to break which in turn sends an
                // update to lower part of ShearedTallFlowerBlock. Thus, we are left with a floating upper part of
                // TallShearedFlowerPart. Prevent this by first setting the upper part of TallFlowerBlock to air and
                // suppress its drops.
                level.setBlock(lowerPos.above(), Blocks.AIR.defaultBlockState(), 20);
                DoublePlantBlock.placeAt(level, shearedTallFlower.defaultBlockState(), lowerPos, Block.UPDATE_CLIENTS);
            }
        } else {
            return InteractionResult.PASS;
        }

        Block.popResource(level, pos, new ItemStack(shearedTallFlower.getFlower()));
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        level.playSound(null, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (!player.isCreative()) {
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
        }

        return InteractionResult.CONSUME_PARTIAL;
    }
}