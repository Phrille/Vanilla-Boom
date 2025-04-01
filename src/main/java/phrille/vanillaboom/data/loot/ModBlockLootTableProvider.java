/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.block.crop.ITrellisCrop;
import phrille.vanillaboom.block.crop.ShearedTallFlowerBlock;
import phrille.vanillaboom.block.crop.TrellisBlock;
import phrille.vanillaboom.block.crop.TrellisCropBlock;
import phrille.vanillaboom.block.variant.*;
import phrille.vanillaboom.data.ModDataGenerator;
import phrille.vanillaboom.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    private static final float[] PINE_CONE_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // Bricks
        dropSelf(ModBlocks.COBBLESTONE_BRICKS.get());
        dropSelf(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        dropSelf(ModBlocks.MAGMA_BRICKS.get());
        dropSelf(ModBlocks.OBSIDIAN_BRICKS.get());
        dropSelf(ModBlocks.SNOW_BRICKS.get());
        dropSelf(ModBlocks.TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.WHITE_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.LIME_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.PINK_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.GRAY_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.CYAN_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.BLUE_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.BROWN_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.GREEN_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.RED_TERRACOTTA_BRICKS.get());
        dropSelf(ModBlocks.BLACK_TERRACOTTA_BRICKS.get());

        // Rocks
        dropSelf(ModBlocks.PERIDOTITE.get());
        dropSelf(ModBlocks.HYDRO_ROCK.get());
        dropSelf(ModBlocks.INFERNAL_ROCK.get());

        // Sand and Gravel
        add(ModBlocks.BONE_SAND.get(), block -> createBoneSandDrops(block, Items.BONE_MEAL));
        add(ModBlocks.WITHER_BONE_SAND.get(), block -> createBoneSandDrops(block, ModItems.WITHER_BONE_MEAL.get()));

        // Polished
        dropSelf(ModBlocks.POLISHED_PERIDOTITE.get());
        dropSelf(ModBlocks.POLISHED_PRISMARINE.get());
        dropSelf(ModBlocks.POLISHED_DARK_PRISMARINE.get());
        dropSelf(ModBlocks.POLISHED_END_STONE.get());
        dropSelf(ModBlocks.POLISHED_NETHERRACK.get());

        // Chiseled and cracked
        dropSelf(ModBlocks.CRACKED_RED_NETHER_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_RED_NETHER_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_PURPUR_BLOCK.get());
        dropSelf(ModBlocks.CHISELED_OBSIDIAN.get());

        // Pillars
        dropSelf(ModBlocks.GRANITE_PILLAR.get());
        dropSelf(ModBlocks.DIORITE_PILLAR.get());
        dropSelf(ModBlocks.ANDESITE_PILLAR.get());
        dropSelf(ModBlocks.PERIDOTITE_PILLAR.get());
        dropSelf(ModBlocks.PRISMARINE_PILLAR.get());
        dropSelf(ModBlocks.DARK_PRISMARINE_PILLAR.get());
        dropSelf(ModBlocks.END_STONE_PILLAR.get());
        dropSelf(ModBlocks.NETHERRACK_PILLAR.get());
        dropSelf(ModBlocks.OBSIDIAN_PILLAR.get());

        // Storage Blocks
        dropSelf(ModBlocks.CHARCOAL_BLOCK.get());
        dropSelf(ModBlocks.SUGAR_BLOCK.get());
        dropSelf(ModBlocks.SUGAR_CANE_BLOCK.get());
        dropSelf(ModBlocks.GUNPOWDER_BLOCK.get());
        dropSelf(ModBlocks.BLAZE_POWDER_BLOCK.get());
        dropSelf(ModBlocks.MAGMA_CREAM_BLOCK.get());
        dropSelf(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        dropSelf(ModBlocks.WITHER_BONE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_DYE_BLOCK.get());
        dropSelf(ModBlocks.ORANGE_DYE_BLOCK.get());
        dropSelf(ModBlocks.MAGENTA_DYE_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get());
        dropSelf(ModBlocks.YELLOW_DYE_BLOCK.get());
        dropSelf(ModBlocks.LIME_DYE_BLOCK.get());
        dropSelf(ModBlocks.PINK_DYE_BLOCK.get());
        dropSelf(ModBlocks.GRAY_DYE_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get());
        dropSelf(ModBlocks.CYAN_DYE_BLOCK.get());
        dropSelf(ModBlocks.PURPLE_DYE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_DYE_BLOCK.get());
        dropSelf(ModBlocks.BROWN_DYE_BLOCK.get());
        dropSelf(ModBlocks.GREEN_DYE_BLOCK.get());
        dropSelf(ModBlocks.RED_DYE_BLOCK.get());
        dropSelf(ModBlocks.BLACK_DYE_BLOCK.get());

        // Glass
        dropWhenSilkTouch(ModBlocks.SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.WHITE_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.LIME_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.PINK_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.GRAY_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.CYAN_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.BLUE_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.BROWN_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.GREEN_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.RED_STAINED_SOUL_GLASS.get());
        dropWhenSilkTouch(ModBlocks.BLACK_STAINED_SOUL_GLASS.get());

        dropWhenSilkTouch(ModBlocks.SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get());
        dropWhenSilkTouch(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get());

        // Misc
        dropSelf(ModBlocks.EASEL.get());
        dropSelf(ModBlocks.RAIN_DETECTOR.get());
        dropSelf(ModBlocks.GOLD_BARS.get());
        dropSelf(ModBlocks.ROSE.get());
        dropPottedContents(ModBlocks.POTTED_ROSE.get());
        add(ModBlocks.SHEARED_ROSE_BUSH.get(), shearedRoseBush -> createSinglePropConditionTable(shearedRoseBush, ShearedTallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(ModBlocks.PEONY.get());
        dropPottedContents(ModBlocks.POTTED_PEONY.get());
        add(ModBlocks.SHEARED_PEONY.get(), shearedPeony -> createSinglePropConditionTable(shearedPeony, ShearedTallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(ModBlocks.LILAC.get());
        dropPottedContents(ModBlocks.POTTED_LILAC.get());
        add(ModBlocks.SHEARED_LILAC.get(), shearedLilac -> createSinglePropConditionTable(shearedLilac, ShearedTallFlowerBlock.HALF, DoubleBlockHalf.LOWER));
        add(ModBlocks.TRELLIS.get(), trellis -> createSinglePropConditionTable(trellis, TrellisBlock.HALF, DoubleBlockHalf.LOWER));
        add(ModBlocks.TOMATO.get(), this::createTrellisCropDrops);
        add(ModBlocks.CHILI.get(), this::createTrellisCropDrops);
        LootItemCondition.Builder riceCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RICE.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 8));
        add(ModBlocks.RICE.get(), createCropDrops(ModBlocks.RICE.get(), ModItems.RICE_GRAINS.get(), ModItems.RICE_GRAINS.get(), riceCondition));
        add(ModBlocks.WITHERED_VINE.get(), BlockLootSubProvider::createShearsOnlyDrop);

        // Cakes
        add(ModBlocks.CHOCOLATE_CAKE.get(), noDrop());
        add(ModBlocks.CARROT_CAKE.get(), noDrop());
        add(ModBlocks.BERRY_CAKE.get(), noDrop());
        ModDataGenerator.CANDLES.forEach(candle -> add(((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).byCandle(candle), createCandleCakeDrops(candle)));
        ModDataGenerator.CANDLES.forEach(candle -> add(((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).byCandle(candle), createCandleCakeDrops(candle)));
        ModDataGenerator.CANDLES.forEach(candle -> add(((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).byCandle(candle), createCandleCakeDrops(candle)));

        // Variants
        ModBookshelfBlock.BOOKSHELVES.forEach(bookshelf -> add(bookshelf, block -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F))));
        ModLadderBlock.LADDERS.forEach(this::dropSelf);
        ModStairBlock.STAIRS.forEach(this::dropSelf);
        ModSlabBlock.SLABS.forEach(this::dropSelf);
        ModWallBlock.WALLS.forEach(this::dropSelf);
        ModFenceBlock.FENCES.forEach(this::dropSelf);
        ModFenceGateBlock.FENCE_GATES.forEach(this::dropSelf);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value).toList();
    }

    @Override
    protected void add(Block block, LootTable.Builder builder) {
        if (block.getLootTable() == BuiltInLootTables.EMPTY) return;
        super.add(block, builder);
    }

    protected LootTable.Builder createBoneSandDrops(Block block, ItemLike item) {
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 5.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(enchantmentLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected LootTable.Builder createTrellisCropDrops(Block cropBlock) {
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);
        ITrellisCrop trellisCrop = (ITrellisCrop) cropBlock;
        LootItemCondition.Builder ageCondition = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        LootItemBlockStatePropertyCondition.Builder halfCondition = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TrellisCropBlock.HALF, DoubleBlockHalf.LOWER));

        return applyExplosionDecay(cropBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(trellisCrop.getFruit())
                                .when(ageCondition)
                                .when(halfCondition)
                                .otherwise(LootItem.lootTableItem(trellisCrop.getSeed())
                                        .when(halfCondition))))
                .withPool(LootPool.lootPool()
                        .when(ageCondition)
                        .when(halfCondition)
                        .add(LootItem.lootTableItem(trellisCrop.getSeed()))
                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3)))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.TRELLIS.get())
                                .when(halfCondition)))
        );
    }

    protected LootTable.Builder createPineConeDrops() {
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_SHEARS.or(hasSilkTouch()).invert())
                        .add(applyExplosionDecay(Blocks.SPRUCE_LEAVES, LootItem.lootTableItem(ModItems.PINE_CONE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), PINE_CONE_CHANCES)));
    }
}
