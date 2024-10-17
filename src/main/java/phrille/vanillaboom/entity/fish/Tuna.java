package phrille.vanillaboom.entity.fish;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class Tuna extends Fish {
    public Tuna(EntityType<? extends Tuna> type, World world) {
        super(type, world);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.TUNA_BUCKET.get());
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }
}
