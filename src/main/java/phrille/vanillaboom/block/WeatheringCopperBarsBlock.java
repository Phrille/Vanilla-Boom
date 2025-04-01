/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperBarsBlock extends IronBarsBlock implements WeatheringCopper {
    public static final MapCodec<WeatheringCopperBarsBlock> CODEC = RecordCodecBuilder.mapCodec(inst ->
            inst.group(
                    WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state")
                            .forGetter(ChangeOverTimeBlock::getAge),
                    propertiesCodec()
            ).apply(inst, WeatheringCopperBarsBlock::new));
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperBarsBlock(WeatheringCopper.WeatherState weatherState, Properties builder) {
        super(builder);
        this.weatherState = weatherState;
    }

    @Override
    public MapCodec<WeatheringCopperBarsBlock> codec() {
        return CODEC;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (WeatheringCopper.getNext(state.getBlock()).isPresent()) {
            changeOverTime(state, level, pos, rand);
        }
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return weatherState != WeatherState.OXIDIZED;
    }

    @Override
    public WeatherState getAge() {
        return weatherState;
    }
}
