package phrille.vanillaboom.loot;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.stream.Collectors;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DropLootModifier extends LootModifier {
    protected final TableLootEntry lootTable;
    protected final Item[] overwrites;

    public DropLootModifier(ILootCondition[] conditions, TableLootEntry lootTable, Item... overwrites) {
        super(conditions);
        this.lootTable = lootTable;
        this.overwrites = overwrites;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        for (Item item : overwrites) {
            generatedLoot = generatedLoot.stream().filter(stack -> stack.getItem() != item).collect(Collectors.toList());
        }

        lootTable.createItemStack(generatedLoot::add, context);

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<DropLootModifier> {

        @Override
        public DropLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] lootConditions) {
            String resLoc = JSONUtils.getAsString(object, "table");
            TableLootEntry table = (TableLootEntry) TableLootEntry.lootTableReference(new ResourceLocation(resLoc)).build();
            JsonArray overwrites = JSONUtils.getAsJsonArray(object, "overwrites");
            Item[] items = new Item[overwrites.size()];

            for (int i = 0; i < items.length; i++) {
                JsonElement element = overwrites.get(i);

                if (element.isJsonObject()) {
                    JsonObject obj = element.getAsJsonObject();
                    items[i] = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getAsString(obj, "item")));
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
