/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import phrille.vanillaboom.block.entity.EaselBlockEntity;

import java.util.List;

public record EaselRecipeInput(ItemStack canvas, List<ItemStack> dyes) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        if (index >= size()) {
            throw new IllegalArgumentException("Invalid index for painting recipe. Index: %s".formatted(index));
        } else if (index == EaselBlockEntity.CANVAS_SLOT) {
            return canvas;
        }
        return dyes.get(index);
    }

    @Override
    public int size() {
        return EaselBlockEntity.INPUT_SIZE;
    }
}
