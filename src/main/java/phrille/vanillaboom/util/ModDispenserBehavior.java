/*
 * Copyright (C) 2024-2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.item.WitherBoneMealItem;
import phrille.vanillaboom.network.LevelEventPacket;

import java.util.List;

public class ModDispenserBehavior {
    public static void registerModDispenserBehavior() {
        if (VanillaBoomConfig.witherBoneMealEnabled) {
            DispenserBlock.registerBehavior(ModItems.WITHER_BONE_MEAL.get(), new OptionalDispenseItemBehavior() {
                @Override
                protected ItemStack execute(BlockSource source, ItemStack stack) {
                    setSuccess(true);
                    ServerLevel level = source.level();
                    BlockPos pos = source.pos().relative(source.state().getValue(DispenserBlock.FACING));

                    if (WitherBoneMealItem.apply(stack, level, pos)) {
                        LevelEventPacket.send(level, pos, LevelEventPacket.LevelEventType.WITHER_BONE_MEAL);
                    } else {
                        setSuccess(false);
                    }
                    return stack;
                }
            });
        }

        if (VanillaBoomConfig.dispenserMilkCows || VanillaBoomConfig.dispenserEmptyCauldrons) {
            DispenseItemBehavior defaultBucketBehavior = DispenserBlock.DISPENSER_REGISTRY.get(Items.BUCKET);
            DispenserBlock.registerBehavior(Items.BUCKET, new DefaultDispenseItemBehavior() {
                @Override
                protected ItemStack execute(BlockSource source, ItemStack stack) {
                    ServerLevel level = source.level();
                    BlockPos pos = source.pos().relative(source.state().getValue(DispenserBlock.FACING));

                    if (VanillaBoomConfig.dispenserMilkCows) {
                        List<Cow> cows = level.getEntitiesOfClass(Cow.class, new AABB(pos), EntitySelector.NO_SPECTATORS);
                        if (!cows.isEmpty()) {
                            LevelEventPacket.send(level, pos, LevelEventPacket.LevelEventType.MILK_COW);
                            return consumeWithRemainder(source, stack, Items.MILK_BUCKET.getDefaultInstance());
                        }
                    }

                    if (VanillaBoomConfig.dispenserEmptyCauldrons) {
                        BlockState state = level.getBlockState(pos);
                        Block block = state.getBlock();
                        if (block instanceof AbstractCauldronBlock cauldron && cauldron.isFull(state)) {
                            Item filledBucket = null;
                            SoundEvent sound = SoundEvents.BUCKET_FILL;

                            if (block == Blocks.WATER_CAULDRON) {
                                filledBucket = Items.WATER_BUCKET;
                            } else if (block == Blocks.LAVA_CAULDRON) {
                                filledBucket = Items.LAVA_BUCKET;
                                sound = SoundEvents.BUCKET_FILL_LAVA;
                            } else if (block == Blocks.POWDER_SNOW_CAULDRON) {
                                filledBucket = Items.POWDER_SNOW_BUCKET;
                                sound = SoundEvents.BUCKET_FILL_POWDER_SNOW;
                            }

                            if (filledBucket != null) {
                                level.setBlock(pos, Blocks.CAULDRON.defaultBlockState(), 3);
                                level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);
                                level.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
                                return consumeWithRemainder(source, stack, filledBucket.getDefaultInstance());
                            }
                        }
                    }
                    return defaultBucketBehavior.dispense(source, stack);
                }
            });
        }

        if (VanillaBoomConfig.dispenserFillCauldrons) {
            addBucketCauldronBehavior(Items.WATER_BUCKET, Blocks.WATER_CAULDRON, SoundEvents.BUCKET_EMPTY);
            addBucketCauldronBehavior(Items.LAVA_BUCKET, Blocks.LAVA_CAULDRON, SoundEvents.BUCKET_EMPTY_LAVA);
            addBucketCauldronBehavior(Items.POWDER_SNOW_BUCKET, Blocks.POWDER_SNOW_CAULDRON, SoundEvents.BUCKET_EMPTY_POWDER_SNOW);
        }
    }

    private static void addBucketCauldronBehavior(Item filledBucket, Block filledCauldron, SoundEvent sound) {
        BlockState filledCauldronState = filledCauldron.defaultBlockState();
        if (filledCauldronState.hasProperty(LayeredCauldronBlock.LEVEL)) {
            filledCauldronState = filledCauldronState.setValue(LayeredCauldronBlock.LEVEL, LayeredCauldronBlock.MAX_FILL_LEVEL);
        }

        final BlockState resultState = filledCauldronState;
        DispenseItemBehavior defaultBehavior = DispenserBlock.DISPENSER_REGISTRY.get(filledBucket);
        DispenserBlock.registerBehavior(filledBucket, new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                ServerLevel level = source.level();
                BlockPos pos = source.pos().relative(source.state().getValue(DispenserBlock.FACING));
                BlockState state = level.getBlockState(pos);

                if (state.is(Blocks.CAULDRON)) {
                    level.setBlock(pos, resultState, 3);
                    level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);
                    level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                    return consumeWithRemainder(source, stack, Items.BUCKET.getDefaultInstance());
                }
                return defaultBehavior.dispense(source, stack);
            }
        });
    }
}
