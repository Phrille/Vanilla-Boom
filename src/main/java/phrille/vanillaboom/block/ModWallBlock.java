package phrille.vanillaboom.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
public class ModWallBlock extends WallBlock {
    protected Supplier<BlockState> state;

    public ModWallBlock(Supplier<BlockState> state) {
        this(state, AbstractBlock.Properties.copy(state.get().getBlock()));
    }

    public ModWallBlock(Supplier<BlockState> state, AbstractBlock.Properties properties) {
        super(properties);
        this.state = state;
    }

    @Override
    public void stepOn(World world, BlockPos pos, Entity entity) {
        getParent().stepOn(world, pos, entity);
    }

    public Block getParent() {
        return state.get().getBlock();
    }
}
