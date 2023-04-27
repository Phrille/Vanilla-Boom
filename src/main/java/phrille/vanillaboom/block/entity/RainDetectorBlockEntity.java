package phrille.vanillaboom.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RainDetectorBlockEntity extends BlockEntity {
    public RainDetectorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RAIN_DETECTOR.get(), pos, state);
    }
}
