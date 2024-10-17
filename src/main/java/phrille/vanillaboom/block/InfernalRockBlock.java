package phrille.vanillaboom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public class InfernalRockBlock extends Block {
    public InfernalRockBlock() {
        super(Properties.copy(Blocks.NETHERRACK));
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        Direction direction = Direction.getRandom(rand);

        if (direction != Direction.UP) {
            BlockPos blockpos = pos.relative(direction);
            BlockState blockstate = world.getBlockState(blockpos);

            if (!state.canOcclude() || !blockstate.isFaceSturdy(world, blockpos, direction.getOpposite())) {
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

                world.addParticle(ParticleTypes.DRIPPING_LAVA, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
