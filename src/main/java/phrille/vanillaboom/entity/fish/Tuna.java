package phrille.vanillaboom.entity.fish;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

public class Tuna extends Fish {
    public Tuna(EntityType<? extends Tuna> type, Level world) {
        super(type, world);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.TUNA_BUCKET);
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }
}
