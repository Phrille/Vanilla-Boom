package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModSlabBlock extends SlabBlock {
    protected Supplier<BlockState> state;

    public ModSlabBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.copy(state.get().getBlock()));
    }

    public ModSlabBlock(Supplier<BlockState> state, BlockBehaviour.Properties properties) {
        super(properties);
        this.state = state;
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        getParent().stepOn(world, pos, state, entity);
    }

    public Block getParent() {
        return state.get().getBlock();
    }
}
