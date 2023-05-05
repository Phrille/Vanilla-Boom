package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModWallBlock extends WallBlock {
    protected Supplier<BlockState> state;

    public ModWallBlock(Supplier<BlockState> state) {
        super(Properties.copy(state.get().getBlock()));
        this.state = state;
    }

    public static String getWallName(Block block) {
        return block.getRegistryName().getPath().replace("bricks", "brick") + "_wall";
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        getParent().stepOn(world, pos, state, entity);
    }

    public Block getParent() {
        return state.get().getBlock();
    }
}
