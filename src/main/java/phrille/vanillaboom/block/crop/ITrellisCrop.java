/*
 * Copyright (C) 2024-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public interface ITrellisCrop {
    ItemLike getSeed();

    ItemLike getFruit();

    int getBonemealIncrease(Level level);

    void placeAt(Level level, BlockPos pos);
}
