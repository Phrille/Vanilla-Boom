package phrille.vanillaboom.block.tile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import phrille.vanillaboom.block.RainDetectorBlock;

public class RainDetectorTileEntity extends TileEntity implements ITickableTileEntity {
    public RainDetectorTileEntity() {
        super(ModTileEntities.RAIN_DETECTOR.get());
    }

    @Override
    public void tick() {
        if (level != null && !level.isClientSide && level.getGameTime() % 20L == 0L) {
            BlockState state = getBlockState();
            Block block = state.getBlock();
            if (block instanceof RainDetectorBlock) {
                RainDetectorBlock.updateSignalStrength(state, level, worldPosition);
            }
        }
    }
}
