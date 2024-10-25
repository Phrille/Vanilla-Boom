package phrille.vanillaboom.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.util.ModDamageTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ChiliItem extends Item {
    public ChiliItem() {
        super(new Item.Properties().food(ModItems.ModFoods.CHILI));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        entity.hurt(level.damageSources().source(ModDamageTypes.CHILI), 3.0F);
        return super.finishUsingItem(stack, level, entity);
    }
}
