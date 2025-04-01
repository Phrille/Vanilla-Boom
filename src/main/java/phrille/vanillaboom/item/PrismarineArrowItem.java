/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.entity.PrismarineArrow;

import javax.annotation.Nullable;

public class PrismarineArrowItem extends ArrowItem {
    public PrismarineArrowItem() {
        super(new Item.Properties());
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        return new PrismarineArrow(level, shooter, ammo.copyWithCount(1), weapon);
    }
}
