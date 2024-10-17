package phrille.vanillaboom.item;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IceCreamItem extends Item {
    public IceCreamItem(Item.Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
        ItemStack finishStack = super.finishUsingItem(stack, world, entity);
        return entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.instabuild ? finishStack : new ItemStack(Items.STICK);
    }
}
