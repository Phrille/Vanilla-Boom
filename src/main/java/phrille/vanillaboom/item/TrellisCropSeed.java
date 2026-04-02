/*
 * Copyright (C) 2026 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.common.SpecialPlantable;
import org.jetbrains.annotations.Nullable;
import phrille.vanillaboom.block.crop.TrellisBlock;
import phrille.vanillaboom.block.crop.TrellisCropBlock;

public class TrellisCropSeed extends Item implements ITrellisCropSeed, SpecialPlantable {
    private final TrellisCropBlock trellisCrop;

    public TrellisCropSeed(TrellisCropBlock trellisCrop, Properties properties) {
        super(properties);
        this.trellisCrop = trellisCrop;
    }

    @Override
    public boolean canPlacePlantAtPosition(ItemStack stack, LevelReader level, BlockPos pos, @Nullable Direction direction) {
        return level.getBlockState(pos).getBlock() instanceof TrellisBlock;
    }

    @Override
    public void spawnPlantAtPosition(ItemStack stack, LevelAccessor level, BlockPos pos, @Nullable Direction direction) {
        BlockState state = level.getBlockState(pos);
        BlockPos lowerPos = state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? pos : pos.below();
        DoublePlantBlock.placeAt(level, trellisCrop.getStateForAge(0), lowerPos, 2);
    }

    @Override
    public boolean villagerCanPlantItem(Villager villager) {
        return true;
    }

    @Override
    public TrellisCropBlock crop() {
        return trellisCrop;
    }
}
