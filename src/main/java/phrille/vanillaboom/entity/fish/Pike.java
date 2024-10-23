package phrille.vanillaboom.entity.fish;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class Pike extends Fish {
    public Pike(EntityType<? extends Pike> type, Level level) {
        super(type, level);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.PIKE_BUCKET.get());
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }
}
