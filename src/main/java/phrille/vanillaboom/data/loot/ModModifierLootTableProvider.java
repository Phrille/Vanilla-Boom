/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.loot;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.loot.ModLootTables;

import java.util.function.BiConsumer;

public class ModModifierLootTableProvider {
    public static class Blocks implements LootTableSubProvider {
        private final ModBlockLootTableProvider blockProvider;

        public Blocks(ModBlockLootTableProvider blockProvider) {
            this.blockProvider = blockProvider;
        }

        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> generator) {
            generator.accept(ModLootTables.SPRUCE_LEAVES, blockProvider.createPineConeDrops());
        }
    }

    public static class Entities implements LootTableSubProvider {
        private final ModEntityLootTableProvider entityProvider;

        public Entities(ModEntityLootTableProvider entityProvider) {
            this.entityProvider = entityProvider;
        }

        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> generator) {
            generator.accept(ModLootTables.DROWNED, entityProvider.createDrownedDrops());
            generator.accept(ModLootTables.POLAR_BEAR, entityProvider.createPolarBearDrops());
            generator.accept(ModLootTables.SILVERFISH, entityProvider.createSilverfishDrops());
            generator.accept(ModLootTables.WITHER_SKELETON, entityProvider.createWitherSkeletonDrops());
        }
    }

    public static class Fishing implements LootTableSubProvider {
        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> generator) {
            generator.accept(ModLootTables.FISHING_FISH, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .add(LootItem.lootTableItem(ModItems.PERCH.get())
                                    .setWeight(34))
                            .add(LootItem.lootTableItem(ModItems.PIKE.get())
                                    .setWeight(34))
                            .add(LootItem.lootTableItem(ModItems.TUNA.get())
                                    .setWeight(20))
                            .add(LootItem.lootTableItem(ModItems.EEL.get())
                                    .setWeight(12))));
        }
    }
}
