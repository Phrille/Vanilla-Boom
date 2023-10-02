package phrille.vanillaboom.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Supplier;

public class DropLootModifier extends LootModifier {
    public static final Supplier<Codec<DropLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    inst.group(
                            Codec.STRING.fieldOf("table").xmap(LootTableHandler::getLootTableReference, LootTableHandler::getString).forGetter(m -> m.lootTable),
                            ForgeRegistries.ITEMS.getCodec().listOf().fieldOf("overwrites").forGetter(m -> m.overwrites)
                    )).apply(inst, DropLootModifier::new)
            )
    );

    private final LootTableReference lootTable;
    private final List<Item> overwrites;

    public DropLootModifier(LootItemCondition[] conditions, LootTableReference lootTable, List<Item> overwrites) {
        super(conditions);
        this.lootTable = lootTable;
        this.overwrites = overwrites;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (!overwrites.isEmpty()) {
            overwrites.forEach(item -> generatedLoot.removeIf(stack -> stack.is(item)));
        }

        lootTable.createItemStack(generatedLoot::add, context);

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
