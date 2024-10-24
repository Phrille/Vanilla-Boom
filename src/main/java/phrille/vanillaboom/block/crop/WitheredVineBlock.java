package phrille.vanillaboom.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class WitheredVineBlock extends VineBlock {
    public WitheredVineBlock() {
        super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().strength(0.2F).sound(SoundType.VINE));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        //No-op implementation
    }
}
