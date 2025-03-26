/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;
import java.util.function.Supplier;

public class DropLootModifier extends LootModifier {
    public static final Supplier<MapCodec<DropLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.mapCodec(inst -> LootModifier.codecStart(inst).and(
                    inst.group(
                            NestedLootTable.CODEC.fieldOf("modifier_loot_table")
                                    .forGetter(modifier -> modifier.modifierLootTable),
                            BuiltInRegistries.ITEM.byNameCodec().listOf().optionalFieldOf("remove_items", List.of())
                                    .forGetter(modifier -> modifier.removeItems)
                    )).apply(inst, DropLootModifier::new)
            )
    );

    private final NestedLootTable modifierLootTable;
    private final List<Item> removeItems;

    public DropLootModifier(LootItemCondition[] conditions, NestedLootTable modifierLootTable, List<Item> removeItems) {
        super(conditions);
        this.modifierLootTable = modifierLootTable;
        this.removeItems = removeItems;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (!removeItems.isEmpty()) {
            removeItems.forEach(item -> generatedLoot.removeIf(stack -> stack.is(item)));
        }

        modifierLootTable.createItemStack(generatedLoot::add, context);

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
