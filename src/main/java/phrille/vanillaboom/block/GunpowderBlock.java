/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class GunpowderBlock extends ColoredFallingBlock {
    public GunpowderBlock() {
        super(new ColorRGBA(4737096), BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_GRAY)
                .strength(0.5F)
                .sound(SoundType.SAND)
                .ignitedByLava());
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (!stack.is(Items.FLINT_AND_STEEL) && !stack.is(Items.FIRE_CHARGE)) {
            return super.use(state, level, pos, player, hand, hit);
        } else {
            onCaughtFire(state, level, pos, hit.getDirection(), player);

            Item item = stack.getItem();
            if (!player.isCreative()) {
                if (stack.is(Items.FLINT_AND_STEEL)) {
                    stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
                } else {
                    stack.shrink(1);
                }
            }

            player.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        onCaughtFire(level.getBlockState(pos), level, pos, null, explosion.getIndirectSourceEntity());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        if (!level.isClientSide) {
            if (projectile.isOnFire()) {
                Entity owner = projectile.getOwner();
                onCaughtFire(state, level, hit.getBlockPos(), null, owner instanceof LivingEntity ? (LivingEntity) owner : null);
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean dropFromExplosion(Explosion explosion) {
        return false;
    }

    @Override
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
        explode(level, pos, igniter);
    }

    private void explode(Level level, BlockPos pos, @Nullable Entity entity) {
        if (!level.isClientSide) {
            level.explode(entity, pos.getX(), pos.getY(), pos.getZ(), 1.0F, true, Level.ExplosionInteraction.BLOCK);
        }
    }
}
