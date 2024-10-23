package phrille.vanillaboom.util;

import com.google.common.collect.Maps;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.ModItems;

import java.util.Map;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class FuelHandler {
    private static final Map<Item, Integer> burnTimes = Maps.newHashMap();

    public static void registerBurnTimes() {
        burnTimes.put(Items.BLAZE_POWDER, 1200);
        burnTimes.put(ModItems.CHARCOAL_BLOCK.get(), 16000);
        burnTimes.put(ModItems.BLAZE_POWDER_BLOCK.get(), 10800);
        burnTimes.put(ModItems.WITHER_BONE_BLOCK.get(), 10800);
        burnTimes.put(ModItems.WITHER_BONE.get(), 1200);
        burnTimes.put(ModItems.WITHER_BONE_MEAL.get(), 400);
        burnTimes.put(ModItems.PINE_CONE.get(), 100);
    }

    @SubscribeEvent
    public static void fuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();

        if (!event.isCanceled() && burnTimes.containsKey(item)) {
            event.setBurnTime(burnTimes.get(item));
        }
    }
}
