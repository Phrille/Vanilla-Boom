package phrille.vanillaboom.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public interface IWitherBonemealable {
    boolean isValidWitherBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient);

    boolean isWitherBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state);

    void performWitherBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state);
}