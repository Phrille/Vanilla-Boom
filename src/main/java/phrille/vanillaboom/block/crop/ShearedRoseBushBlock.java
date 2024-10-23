package phrille.vanillaboom.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import phrille.vanillaboom.util.Utils;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ShearedRoseBushBlock extends TallFlowerBlock {
    public ShearedRoseBushBlock(BlockBehaviour.Properties builder) {
        super(builder);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        if (rand.nextFloat() < 0.5F) {
            DoubleBlockHalf half = state.getValue(TallFlowerBlock.HALF);
            if (half == DoubleBlockHalf.UPPER) {
                pos = pos.below();
            }

            Utils.setDoubleBlock(level, Blocks.ROSE_BUSH.defaultBlockState(), pos, TallFlowerBlock.HALF);
        }
    }
}
