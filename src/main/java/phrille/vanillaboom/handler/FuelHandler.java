package phrille.vanillaboom.handler;

import com.google.common.collect.Maps;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;

import java.util.Map;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class FuelHandler {
    private static final Map<Item, Integer> burnTimes = Maps.newHashMap();

    public static void registerBurnTime(ItemLike item, int burnTime) {
        burnTimes.put(item.asItem(), burnTime);
    }

    @SubscribeEvent
    public static void fuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();

        if (!event.isCanceled() && burnTimes.containsKey(item)) {
            event.setBurnTime(burnTimes.get(item));
        }
    }
}