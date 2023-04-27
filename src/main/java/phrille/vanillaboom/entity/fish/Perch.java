package phrille.vanillaboom.entity.fish;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

public class Perch extends Fish {
    public Perch(EntityType<? extends Perch> type, Level world) {
        super(type, world);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.PERCH_BUCKET);
    }

    @Override
    public Size getSize() {
        return Size.MEDIUM;
    }
}
