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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

public class LootTableHandler {
    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    private static final RegistryObject<LootTableDropModifier.Serializer> WITHER_SKELETON = GLM.register("wither_skeleton", LootTableDropModifier.Serializer::new);

    public static void init(IEventBus modEventBus) {
        GLM.register(modEventBus);
    }

    public static class LootTableDropModifier extends LootModifier {
        protected final LootTableReference table;
        protected final Item[] overwriteItems;

        public LootTableDropModifier(LootItemCondition[] conditions, LootTableReference lootTable, Item... overwrite) {
            super(conditions);
            table = lootTable;
            overwriteItems = overwrite;
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
            for (Item item : overwriteItems) {
                generatedLoot = generatedLoot.stream().filter(stack -> !stack.is(item)).collect(Collectors.toList());
            }

            table.createItemStack(generatedLoot::add, context);

            return generatedLoot;
        }

        public static class Serializer extends GlobalLootModifierSerializer<LootTableDropModifier> {
            @Override
            public LootTableDropModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] lootConditions) {
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

                return new LootTableDropModifier(lootConditions, table, items);
            }

            @Override
            public JsonObject write(LootTableDropModifier instance) {
                JsonObject json = makeConditions(instance.conditions);
                JsonArray overwrites = new JsonArray();

                for (int i = 0; i < instance.overwriteItems.length; i++) {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.overwriteItems[i]).toString());
                    overwrites.add(obj);
                }

                json.addProperty("table", instance.table.name.toString());
                json.add("overwrites", overwrites);

                return json;
            }
        }
    }
}
