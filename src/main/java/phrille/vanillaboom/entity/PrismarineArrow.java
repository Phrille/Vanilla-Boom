/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.ModTags;

public class PrismarineArrow extends AbstractArrow {
    public PrismarineArrow(EntityType<? extends PrismarineArrow> arrow, Level level) {
        super(arrow, level);
    }

    public PrismarineArrow(Level level, LivingEntity owner, ItemStack pickupStack) {
        super(ModEntities.PRISMARINE_ARROW.get(), owner, level, pickupStack);
    }

    @SuppressWarnings("unused")
    public PrismarineArrow(Level level, double x, double y, double z, ItemStack pickupStack) {
        super(ModEntities.PRISMARINE_ARROW.get(), x, y, z, level, pickupStack);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        double baseDamage = getBaseDamage();
        Entity entity = result.getEntity();

        if (isExtraHurtTarget(entity)) {
            setBaseDamage(baseDamage * 1.5D);
        }

        super.onHitEntity(result);
        setBaseDamage(baseDamage);
    }

    public boolean isExtraHurtTarget(Entity entity) {
        return entity.getType().is(ModTags.Entities.PRISMARINE_EXTRA_HURT);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.PRISMARINE_ARROW.get());
    }

    @Override
    protected float getWaterInertia() {
        return 1.0F;
    }
}
