package phrille.vanillaboom.util;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public class VanillaBoomTab extends ItemGroup {
    public static final ItemGroup VANILLA_BOOM_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_tab", () -> new ItemStack(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get()));
    public static final ItemGroup VANILLA_BOOM_VARIANT_BLOCKS_TAB = new VanillaBoomTab(VanillaBoom.MOD_ID + "_variant_blocks_tab", () -> new ItemStack(ModBlocks.MAGMA_BRICK_STAIRS.get()));

    private final Supplier<ItemStack> iconSupplier;

    public VanillaBoomTab(String name, Supplier<ItemStack> icon) {
        super(name);
        iconSupplier = icon;
    }

    @Override
    public ItemStack makeIcon() {
        return iconSupplier.get();
    }
}
