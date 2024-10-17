package phrille.vanillaboom.entity.fish;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class Perch extends Fish {
    public Perch(EntityType<? extends Perch> type, World world) {
        super(type, world);
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
