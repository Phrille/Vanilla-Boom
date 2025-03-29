/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.util;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;

import java.util.Objects;

public class PaintingUtils {
    public static ItemStack stackFromVariant(ResourceKey<PaintingVariant> variant) {
        return stackFromHolder(BuiltInRegistries.PAINTING_VARIANT.getHolderOrThrow(variant));
    }

    public static ItemStack stackFromHolder(Holder<PaintingVariant> holder) {
        CustomData data = CustomData.EMPTY
                .update(Painting.VARIANT_MAP_CODEC, holder)
                .getOrThrow()
                .update(compoundTag -> compoundTag.putString("id", holder.getRegisteredName()));
        ItemStack painting = new ItemStack(Items.PAINTING);
        painting.set(DataComponents.ENTITY_DATA, data);
        return painting;
    }

    public static Holder<PaintingVariant> holderFromStack(ItemStack painting) {
        CustomData data = Objects.requireNonNull(painting.get(DataComponents.ENTITY_DATA));
        return data.read(Painting.VARIANT_MAP_CODEC).getOrThrow();
    }
}
