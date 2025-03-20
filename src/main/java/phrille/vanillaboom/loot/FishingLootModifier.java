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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.Supplier;

public class FishingLootModifier extends LootModifier {
    public static final Supplier<Codec<FishingLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    inst.group(
                            Codec.STRING.fieldOf("modifier_loot_table")
                                    .xmap(ModGlobalLootModifiers::getLootTableReference, ModGlobalLootModifiers::getString)
                                    .forGetter(modifier -> modifier.modifierLootTable),
                            Codec.FLOAT.fieldOf("replace_chance")
                                    .forGetter(modifier -> modifier.replaceChance)
                    )).apply(inst, FishingLootModifier::new)
            )
    );

    private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "f_278466_");
    private final LootTableReference modifierLootTable;
    private final float replaceChance;

    public FishingLootModifier(LootItemCondition[] conditions, LootTableReference modifierLootTable, float replaceChance) {
        super(conditions);
        this.modifierLootTable = modifierLootTable;
        this.replaceChance = replaceChance;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        try {
            Set<LootContext.VisitedEntry<?>> set = (Set<LootContext.VisitedEntry<?>>) LOOT_FIELD.get(context);

            if (set.isEmpty() && replaceChance >= context.getRandom().nextFloat()) {
                ObjectArrayList<ItemStack> loot = ObjectArrayList.of();
                modifierLootTable.createItemStack(loot::add, context);

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