package phrille.vanillaboom.handler;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class VillagerTradeHandler {

    @SubscribeEvent
    public static void onVillagerTrade(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        ResourceLocation profession = ForgeRegistries.VILLAGER_PROFESSIONS.getKey(event.getType());

        if (profession == null) {
            return;
        }
        if (profession.getPath().equals("farmer")) {
            trades.get(1).add(itemToEmeralds(ModItems.TOMATO.get(), 26, 16, 2));
            trades.get(2).add(itemToEmeralds(ModItems.RICE_BOWL.get(), 1, 20, 4));
        }
    }

    @SubscribeEvent
    public static void onWandererTrade(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        trades.add(emeraldsToItem(1, ModItems.TOMATO_SEEDS.get(), 1, 10));
        trades.add(emeraldsToItem(1, ModItems.RICE_SEEDS.get(), 1, 10));
    }

    private static BasicItemListing itemToEmeralds(ItemLike item, int amount, int maxTrades, int xp) {
        return new BasicItemListing(new ItemStack(item, amount), new ItemStack(Items.EMERALD), maxTrades, xp, 0.05F);
    }

    @SuppressWarnings("SameParameterValue")
    private static BasicItemListing emeraldsToItem(int amount, ItemLike item, int maxTrades, int xp) {
        return new BasicItemListing(amount, new ItemStack(item), maxTrades, xp, 0.05F);
    }
}
