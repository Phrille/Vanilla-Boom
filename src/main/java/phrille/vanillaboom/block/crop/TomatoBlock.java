/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.crop;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

public class TomatoBlock extends TrellisCropBlock {
    public TomatoBlock(Properties builder) {
        super(builder);
    }

    @Override
    public ItemLike getSeed() {
        return ModItems.TOMATO_SEEDS.get();
    }

    @Override
    public ItemLike getFruit() {
        return ModItems.TOMATO.get();
    }

    @Override
    public int getBonemealIncrease(Level level) {
        return level.random.nextInt(2) + 1;
    }
}
