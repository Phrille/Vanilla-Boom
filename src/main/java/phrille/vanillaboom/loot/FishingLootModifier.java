package phrille.vanillaboom.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.Supplier;

public class FishingLootModifier extends LootModifier {
    public static final Supplier<Codec<FishingLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    inst.group(
                            Codec.STRING.fieldOf("table").xmap(ModGlobalLootModifiers::getLootTableReference, ModGlobalLootModifiers::getString).forGetter(m -> m.lootTable),
                            Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance)
                    )).apply(inst, FishingLootModifier::new)
            )
    );

    private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "f_78911_");
    private final LootTableReference lootTable;
    private final float chance;

    public FishingLootModifier(LootItemCondition[] conditions, LootTableReference lootTable, float chance) {
        super(conditions);
        this.lootTable = lootTable;
        this.chance = chance;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        try {
            Set<LootTable> set = (Set<LootTable>) LOOT_FIELD.get(context);

            if (set.isEmpty() && context.getRandom().nextFloat() <= chance) {
                ObjectArrayList<ItemStack> loot = ObjectArrayList.of();
                lootTable.createItemStack(loot::add, context);

                return loot;
            } else {
                return generatedLoot;
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("Could not access lootTables", e);
        }
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}