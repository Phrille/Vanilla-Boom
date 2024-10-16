package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public interface ITrellisCrop {

    ItemLike getSeed();

    ItemLike getFruit();

    int getBonemealIncrease(Level level);

    void placeAt(Level level, BlockPos pos);
}
