/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block.variant;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.function.Supplier;

public class ModLadderBlock extends LadderBlock {
    public static final List<ModLadderBlock> LADDERS = Lists.newArrayList();
    private final Supplier<Block> craftingIngredient;

    public ModLadderBlock(Supplier<Block> craftingIngredient) {
        this(craftingIngredient, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER));
    }

    public ModLadderBlock(Supplier<Block> craftingIngredient, BlockBehaviour.Properties builder) {
        super(builder);
        this.craftingIngredient = craftingIngredient;
        LADDERS.add(this);
    }

    public Block getCraftingIngredient() {
        return craftingIngredient.get();
    }
}
