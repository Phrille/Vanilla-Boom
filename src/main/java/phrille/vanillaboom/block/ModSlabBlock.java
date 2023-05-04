package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModSlabBlock extends SlabBlock {
    protected Supplier<BlockState> state;

    public ModSlabBlock(Supplier<BlockState> state) {
        super(Properties.copy(state.get().getBlock()));
        this.state = state;
    }

    public static final String getSlabName(String name) {
        return name.replace("bricks", "brick") + "_slab";
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        getParent().stepOn(world, pos, state, entity);
    }

    public Block getParent() {
        return state.get().getBlock();
    }
}
