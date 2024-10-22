package phrille.vanillaboom.entity.fish;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Perch extends Fish {
    public Perch(EntityType<? extends Perch> type, Level level) {
        super(type, level);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.PERCH_BUCKET.get());
    }

    @Override
    public Size getSize() {
        return Size.MEDIUM;
    }
}
