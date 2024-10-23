package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
public class ModSlabBlock extends SlabBlock implements IVariantBlock {
    protected Supplier<BlockState> state;

    public ModSlabBlock(Supplier<BlockState> state) {
        this(state, BlockBehaviour.Properties.copy(state.get().getBlock()));
    }

    public ModSlabBlock(Supplier<BlockState> state, BlockBehaviour.Properties builder) {
        super(builder);
        this.state = state;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        getParent().stepOn(level, pos, state, entity);
    }

    @Override
    public Block getParent() {
        return state.get().getBlock();
    }
}
