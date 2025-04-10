/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class InfernalRockBlock extends Block {
    public InfernalRockBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.NETHER)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops()
                .strength(0.6F, 0.8F)
                .sound(SoundType.NETHERRACK));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        Direction direction = Direction.getRandom(rand);

        if (direction != Direction.UP) {
            BlockPos blockpos = pos.relative(direction);
            BlockState blockstate = level.getBlockState(blockpos);

            if (!state.canOcclude() || !blockstate.isFaceSturdy(level, blockpos, direction.getOpposite())) {
                double x = pos.getX();
                double y = pos.getY();
                double z = pos.getZ();

                if (direction == Direction.DOWN) {
                    y = y - 0.05D;
                    x += rand.nextDouble();
                    z += rand.nextDouble();
                } else {
                    y = y + rand.nextDouble() * 0.8D;
                    if (direction.getAxis() == Direction.Axis.X) {
                        z += rand.nextDouble();
                        if (direction == Direction.EAST) {
                            x++;
                        } else {
                            x -= 0.03D;
                        }
                    } else {
                        x += rand.nextDouble();
                        if (direction == Direction.SOUTH) {
                            z++;
                        } else {
                            z -= 0.03D;
                        }
                    }
                }

                level.addParticle(ParticleTypes.DRIPPING_LAVA, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
