package phrille.vanillaboom.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModStairBlock extends StairBlock {
    protected Supplier<BlockState> state;

    public ModStairBlock(Supplier<BlockState> state) {
        super(state, Properties.copy(state.get().getBlock()));
        this.state = state;
    }

    public static String getStairName(Block block) {
        return block.getRegistryName().getPath().replace("bricks", "brick") + "_stairs";
    }

    public Block getParent() {
        return state.get().getBlock();
    }
}
