package phrille.vanillaboom.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import phrille.vanillaboom.config.VanillaBoomConfig;

public class RoseBlock extends FlowerBlock implements IWitherBonemealable {
    public RoseBlock() {
        super(() -> MobEffects.DIG_SPEED, 10, BlockBehaviour.Properties.copy(Blocks.POPPY));
    }

    @Override
    public boolean isValidWitherBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return VanillaBoomConfig.growWitherRoses;
    }

    @Override
    public boolean isWitherBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
        return rand.nextFloat() < 0.25F;
    }

    @Override
    public void performWitherBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        level.setBlock(pos, Blocks.WITHER_ROSE.defaultBlockState(), 2);
    }
}
