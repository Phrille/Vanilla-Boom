/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class FishBucketItem extends MobBucketItem {
    public FishBucketItem(Supplier<? extends EntityType<?>> entityType) {
        super(entityType, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1));
    }

    @Override
    public void checkExtraContent(@Nullable Player player, Level level, ItemStack stack, BlockPos pos) {
        if (level instanceof ServerLevel) {
            spawn((ServerLevel) level, stack, pos);
            level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }

    private void spawn(ServerLevel level, ItemStack stack, BlockPos pos) {
        Entity entity = getFishType().spawn(level, stack, null, pos, MobSpawnType.BUCKET, true, false);

        if (entity instanceof Bucketable bucketable) {
            bucketable.loadFromBucketTag(stack.getOrCreateTag());
            bucketable.setFromBucket(true);
        }
    }
}
