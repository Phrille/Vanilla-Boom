package phrille.vanillaboom.loot;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class FishingLootModifier extends LootModifier {
    private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "field_186504_g");
    protected final TableLootEntry lootTable;
    protected final float replaceChance;

    public FishingLootModifier(ILootCondition[] conditions, TableLootEntry lootTable, float replaceChance) {
        super(conditions);
        this.lootTable = lootTable;
        this.replaceChance = replaceChance;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        try {
            Set<LootTable> set = (Set<LootTable>) LOOT_FIELD.get(context);

            if (set.isEmpty() && context.getRandom().nextFloat() <= replaceChance) {
                List<ItemStack> loot = Lists.newArrayList();
                lootTable.createItemStack(loot::add, context);

                return loot;
            } else {
                return generatedLoot;
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("Could not access lootTables", e);
        }
    }

    public static class Serializer extends GlobalLootModifierSerializer<FishingLootModifier> {

        @Override
        public FishingLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] lootConditions) {
            String resLoc = JSONUtils.getAsString(object, "table");
            TableLootEntry table = (TableLootEntry) TableLootEntry.lootTableReference(new ResourceLocation(resLoc)).build();
            float chance = JSONUtils.getAsFloat(object, "chance");

            return new FishingLootModifier(lootConditions, table, chance);
        }

        @Override
        public JsonObject write(FishingLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("table", instance.lootTable.name.toString());
            json.addProperty("chance", instance.replaceChance);

            return json;
        }
    }
}
