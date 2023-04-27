package phrille.vanillaboom.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import phrille.vanillaboom.entity.PrismarineArrow;
import phrille.vanillaboom.util.VanillaBoomTab;

public class PrismarineArrowItem extends ArrowItem {
    public PrismarineArrowItem() {
        super(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB));
    }

    @Override
    public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter) {
        return new PrismarineArrow(world, shooter);
    }
}
