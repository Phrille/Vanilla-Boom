/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

import java.util.function.Supplier;

@SuppressWarnings("ConstantConditions")
public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, VanillaBoom.MOD_ID);

    public static final Supplier<BlockEntityType<RainDetectorBlockEntity>> RAIN_DETECTOR = BLOCK_ENTITY_TYPES.register("rain_detector", () -> BlockEntityType.Builder.of(RainDetectorBlockEntity::new, ModBlocks.RAIN_DETECTOR.get()).build(null));
    public static final Supplier<BlockEntityType<EaselBlockEntity>> EASEL = BLOCK_ENTITY_TYPES.register("easel", () -> BlockEntityType.Builder.of(EaselBlockEntity::new, ModBlocks.EASEL.get()).build(null));
}
