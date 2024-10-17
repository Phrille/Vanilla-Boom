package phrille.vanillaboom.entity.fish;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class Pike extends Fish {
    public Pike(EntityType<? extends Pike> type, World world) {
        super(type, world);
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
