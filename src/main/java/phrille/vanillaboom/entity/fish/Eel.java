package phrille.vanillaboom.entity.fish;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class Eel extends Fish {
    public Eel(EntityType<? extends Eel> type, World world) {
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
