/*
 * Copyright (C) 2025-2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import phrille.vanillaboom.crafting.PaintingRecipe;

import java.util.List;

public class EaselTooltip implements TooltipComponent {
    private final List<ItemStack> ingredients;

    public EaselTooltip(PaintingRecipe recipe) {
        ingredients = Lists.newArrayList();
        ingredients.add(recipe.canvas().getItems()[0]);

        for (Ingredient dye : recipe.dyes()) {
            if (dye.hasNoItems()) continue;

            DyeColor color = DyeColor.getColor(dye.getItems()[0]);
            if (color == null) continue;

            ItemStack dyeStack = new ItemStack(DyeItem.byColor(color));
            boolean stackExists = false;
            for (ItemStack addedStack : ingredients) {
                if (addedStack.is(dyeStack.getItem())) {
                    addedStack.grow(1);
                    stackExists = true;
                    break;
                }
            }

            if (!stackExists) {
                ingredients.add(dyeStack);
            }
        }
    }

    public ImmutableList<ItemStack> ingredients() {
        return ImmutableList.copyOf(ingredients);
    }
}
