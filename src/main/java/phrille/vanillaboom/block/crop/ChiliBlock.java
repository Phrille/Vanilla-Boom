package phrille.vanillaboom.block.crop;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

public class ChiliBlock extends TrellisCropBlock {
    public ChiliBlock(Properties builder) {
        super(builder);
    }

    @Override
    public ItemLike getSeed() {
        return ModItems.CHILI_SEEDS.get();
    }

    @Override
    public ItemLike getFruit() {
        return ModItems.CHILI.get();
    }

    @Override
    public int getBonemealIncrease(Level level) {
        return level.random.nextInt(2) + 1;
    }
}
