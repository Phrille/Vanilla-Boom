package phrille.vanillaboom.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IceCreamItem extends Item {
    public IceCreamItem(Item.Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack newStack = super.finishUsingItem(stack, level, entity);

        return entity instanceof Player && ((Player) entity).getAbilities().instabuild ? newStack : new ItemStack(Items.STICK);
    }
}
