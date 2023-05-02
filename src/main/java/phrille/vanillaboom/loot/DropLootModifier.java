package phrille.vanillaboom.loot;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

public class DropLootModifier extends LootModifier {
    protected final LootTableReference lootTable;
    protected final Item[] overwrites;

    public DropLootModifier(LootItemCondition[] conditions, LootTableReference lootTable, Item... overwrites) {
        super(conditions);
        this.lootTable = lootTable;
        this.overwrites = overwrites;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        for (Item item : overwrites) {
            generatedLoot = generatedLoot.stream().filter(stack -> !stack.is(item)).collect(Collectors.toList());
        }

        lootTable.createItemStack(generatedLoot::add, context);

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<DropLootModifier> {

        @Override
        public DropLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] lootConditions) {
            String resLoc = GsonHelper.getAsString(object, "table");
            LootTableReference table = (LootTableReference) LootTableReference.lootTableReference(new ResourceLocation(resLoc)).build();
            JsonArray overwrites = GsonHelper.getAsJsonArray(object, "overwrites");
            Item[] items = new Item[overwrites.size()];

            for (int i = 0; i < items.length; i++) {
                JsonElement element = overwrites.get(i);

                if (element.isJsonObject()) {
                    JsonObject obj = element.getAsJsonObject();
                    items[i] = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(obj, "item")));
                }
            }

            return new DropLootModifier(lootConditions, table, items);
        }

        @Override
        public JsonObject write(DropLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            JsonArray overwrites = new JsonArray();

            for (int i = 0; i < instance.overwrites.length; i++) {
                JsonObject obj = new JsonObject();
                obj.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.overwrites[i]).toString());
                overwrites.add(obj);
            }

            json.addProperty("table", instance.lootTable.name.toString());
            json.add("overwrites", overwrites);

            return json;
        }
    }
}
