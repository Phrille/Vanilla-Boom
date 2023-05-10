package phrille.vanillaboom.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModStairBlock extends StairBlock {
    protected Supplier<BlockState> state;

    public ModStairBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.copy(state.get().getBlock()));
    }

    public ModStairBlock(Supplier<BlockState> state, BlockBehaviour.Properties properties) {
        super(state, properties);
        this.state = state;
    }

    public Block getParent() {
        return state.get().getBlock();
    }
}
