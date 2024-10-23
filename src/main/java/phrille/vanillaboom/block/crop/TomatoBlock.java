package phrille.vanillaboom.block.crop;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

public class TomatoBlock extends TrellisCropBlock {
    public TomatoBlock(Properties builder) {
        super(builder);
    }

    @Override
    public ItemLike getSeed() {
        return ModItems.TOMATO_SEEDS.get();
    }

    @Override
    public ItemLike getFruit() {
        return ModItems.TOMATO.get();
    }

    @Override
    public int getBonemealIncrease(Level level) {
        return level.random.nextInt(2) + 1;
    }
}
