package phrille.vanillaboom.loot;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class FishingLootModifier extends LootModifier {
    private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "f_78911_");
    protected final LootTableReference lootTable;
    protected final float replaceChance;

    public FishingLootModifier(LootItemCondition[] conditions, LootTableReference lootTable, float replaceChance) {
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
        public FishingLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] lootConditions) {
            String resLoc = GsonHelper.getAsString(object, "table");
            LootTableReference table = (LootTableReference) LootTableReference.lootTableReference(new ResourceLocation(resLoc)).build();
            float chance = GsonHelper.getAsFloat(object, "chance");

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
