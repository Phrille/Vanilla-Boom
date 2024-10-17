package phrille.vanillaboom.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.entity.PrismarineArrow;
import phrille.vanillaboom.util.VanillaBoomTab;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PrismarineArrowItem extends ArrowItem {
    public PrismarineArrowItem() {
        super(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB));
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        return new PrismarineArrow(level, shooter);
    }
}
