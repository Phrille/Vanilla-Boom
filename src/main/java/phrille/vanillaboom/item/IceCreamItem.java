package phrille.vanillaboom.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class IceCreamItem extends Item {
    public IceCreamItem(Item.Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        ItemStack itemstack = super.finishUsingItem(stack, world, entity);

        return entity instanceof Player && ((Player) entity).getAbilities().instabuild ? itemstack : new ItemStack(Items.STICK);
    }
}
