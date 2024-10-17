package phrille.vanillaboom.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

import java.util.function.Supplier;

public class ModStairBlock extends StairsBlock {
    protected Supplier<BlockState> state;

    public ModStairBlock(Supplier<BlockState> state) {
        this(state, AbstractBlock.Properties.copy(state.get().getBlock()));
    }

    public ModStairBlock(Supplier<BlockState> state, AbstractBlock.Properties properties) {
        super(state, properties);
        this.state = state;
    }

    public Block getParent() {
        return state.get().getBlock();
    }
}
