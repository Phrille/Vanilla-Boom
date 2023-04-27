package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModStairBlock extends StairBlock {
    protected Block modelBlock;

    public ModStairBlock(Block block) {
        super(() -> block.defaultBlockState(), Properties.copy(block));
        modelBlock = block;
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        modelBlock.stepOn(world, pos, state, entity);
    }
}
