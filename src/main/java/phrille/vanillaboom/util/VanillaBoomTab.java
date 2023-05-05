package phrille.vanillaboom.util;

import com.google.common.collect.Ordering;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class VanillaBoomTab extends CreativeModeTab {
    public static final List<Item> VANILLABOOM_TAB_LIST = new ArrayList<>();
    public static final List<Item> VANILLABOOM_VARIANT_BLOCKS_TAB_LIST = new ArrayList<>();

    public static final CreativeModeTab VANILLABOOM_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_tab", () -> new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICKS), VANILLABOOM_TAB_LIST);
    public static final CreativeModeTab VANILLABOOM_VARIANT_BLOCKS_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_variant_blocks_tab", () -> new ItemStack(ModBlocks.MAGMA_BRICK_STAIRS), VANILLABOOM_VARIANT_BLOCKS_TAB_LIST);
    private final Supplier<ItemStack> iconSupplier;
    private final List<Item> tabList;

    public VanillaBoomTab(String name, Supplier<ItemStack> icon, List<Item> list) {
        super(name);
        iconSupplier = icon;
        tabList = list;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        super.fillItemList(items);

        Comparator<ItemStack> tabSorter = Ordering.explicit(tabList).onResultOf(ItemStack::getItem);
        items.sort(tabSorter);
    }

    @Override
    public ItemStack makeIcon() {
        return iconSupplier.get();
    }
}
