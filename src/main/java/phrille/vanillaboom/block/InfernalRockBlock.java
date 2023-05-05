package phrille.vanillaboom.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class InfernalRockBlock extends Block {
    public InfernalRockBlock() {
        super(Properties.copy(Blocks.NETHERRACK));
    }

    /**
     @Override public void animateTick(BlockState state, Level world, BlockPos pos, Random rand)
     {
     if (rand.nextInt(4) == 0)
     {
     Direction direction = Direction.getRandom(rand);

     if (direction != Direction.UP)
     {
     BlockPos blockpos = pos.offset(direction);
     BlockState blockstate = world.getBlockState(blockpos);

     if (blockstate.getFluidState().isEmpty() && (!blockstate.isSolid() || !blockstate.isSolidSide(world, blockpos, direction.getOpposite())))
     {
     Direction.Axis direction$axis = direction.getAxis();
     double d1 = direction.getXOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getXOffset() * 0.6D;
     double d2 = direction.getYOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getYOffset() * 0.6D;
     double d3 = direction.getZOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getZOffset() * 0.6D;

     world.addParticle(ParticleTypes.DRIPPING_LAVA, (double) pos.getX() + d1, (double) pos.getY() + d2, (double) pos.getZ() + d3, 0.0D, 0.0D, 0.0D);
     }
     }
     }
     }
     */
}
