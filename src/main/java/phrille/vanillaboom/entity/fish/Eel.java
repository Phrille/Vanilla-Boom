package phrille.vanillaboom.entity.fish;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

public class Eel extends Fish {
    public Eel(EntityType<? extends Eel> type, Level world) {
        super(type, world);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.EEL_BUCKET.get());
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }
}
