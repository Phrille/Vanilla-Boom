/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Supplier;

public class DropLootModifier extends LootModifier {
    public static final Supplier<Codec<DropLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    inst.group(
                            Codec.STRING.fieldOf("modifier_loot_table")
                                    .xmap(ModGlobalLootModifiers::getLootTableReference, ModGlobalLootModifiers::getString)
                                    .forGetter(modifier -> modifier.modifierLootTable),
                            ForgeRegistries.ITEMS.getCodec().listOf().optionalFieldOf("remove_items", List.of())
                                    .forGetter(modifier -> modifier.removeItems)
                    )).apply(inst, DropLootModifier::new)
            )
    );

    private final LootTableReference modifierLootTable;
    private final List<Item> removeItems;

    public DropLootModifier(LootItemCondition[] conditions, LootTableReference modifierLootTable, List<Item> removeItems) {
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
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
