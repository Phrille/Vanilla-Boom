package phrille.vanillaboom.util;

import com.google.common.collect.Ordering;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class VanillaBoomTab extends CreativeModeTab {
    public static final CreativeModeTab VANILLA_BOOM_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_tab", () -> new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get()));
    public static final CreativeModeTab VANILLA_BOOM_VARIANT_BLOCKS_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_variant_blocks_tab", () -> new ItemStack(ModBlocks.MAGMA_BRICK_STAIRS.get()));

    private final Supplier<ItemStack> iconSupplier;
    private final List<Item> tabList;

    public VanillaBoomTab(String name, Supplier<ItemStack> icon) {
        super(name);
        iconSupplier = icon;
        tabList = ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> item.getRegistryName().getNamespace().equals(VanillaBoom.MOD_ID))
                .filter(item -> item.getCreativeTabs().contains(this))
                .toList();
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        super.fillItemList(items);

        //Comparator<ItemStack> tabSorter = Ordering.explicit(tabList).onResultOf(ItemStack::getItem);
        //items.sort(tabSorter);
    }

    @Override
    public ItemStack makeIcon() {
        return iconSupplier.get();
    }
}
