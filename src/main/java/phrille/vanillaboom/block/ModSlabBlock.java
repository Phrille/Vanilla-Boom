package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModSlabBlock extends SlabBlock {
    protected final Block modelBlock;

    public ModSlabBlock(Block block) {
        super(Properties.copy(block));
        modelBlock = block;
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        modelBlock.stepOn(world, pos, state, entity);
    }
}
