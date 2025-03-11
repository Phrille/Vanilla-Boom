package phrille.vanillaboom.data.loot;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.block.crop.ITrellisCrop;
import phrille.vanillaboom.block.crop.ShearedTallFlowerBlock;
import phrille.vanillaboom.block.crop.TrellisBlock;
import phrille.vanillaboom.block.crop.TrellisCropBlock;
import phrille.vanillaboom.data.ModDataGenerator;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.Utils;

import java.util.Set;

@MethodsReturnNonnullByDefault
public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
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
        dropSelf(ModBlocks.RED_NETHER_PILLAR.get());
        dropSelf(ModBlocks.OBSIDIAN_PILLAR.get());

        // Wood Variations
        add(ModBlocks.SPRUCE_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        add(ModBlocks.BIRCH_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        add(ModBlocks.JUNGLE_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        add(ModBlocks.ACACIA_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        add(ModBlocks.DARK_OAK_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        add(ModBlocks.CRIMSON_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        add(ModBlocks.WARPED_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        dropSelf(ModBlocks.SPRUCE_LADDER.get());
        dropSelf(ModBlocks.BIRCH_LADDER.get());
        dropSelf(ModBlocks.JUNGLE_LADDER.get());
        dropSelf(ModBlocks.ACACIA_LADDER.get());
        dropSelf(ModBlocks.DARK_OAK_LADDER.get());
        dropSelf(ModBlocks.CRIMSON_LADDER.get());
        dropSelf(ModBlocks.WARPED_LADDER.get());

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
        //TODO: Fix loot table
        add(ModBlocks.RICE.get(), createCropDrops(ModBlocks.RICE.get(), ModItems.RICE_BOWL.get(), ModItems.RICE_BOWL.get(), riceCondition));
        add(ModBlocks.WITHERED_VINE.get(), BlockLootSubProvider::createShearsOnlyDrop);
        dropSelf(ModBlocks.WITHERED_BAMBOO.get());

        // Cakes
        add(ModBlocks.CHOCOLATE_CAKE.get(), noDrop());
        add(ModBlocks.CARROT_CAKE.get(), noDrop());
        add(ModBlocks.BERRY_CAKE.get(), noDrop());
        Utils.CANDLES.forEach(candle -> add(((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).byCandle((CandleBlock) candle), createCandleCakeDrops(candle)));
        Utils.CANDLES.forEach(candle -> add(((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).byCandle((CandleBlock) candle), createCandleCakeDrops(candle)));
        Utils.CANDLES.forEach(candle -> add(((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).byCandle((CandleBlock) candle), createCandleCakeDrops(candle)));

        ModDataGenerator.STAIRS.forEach(pair -> dropSelf(pair.getFirst()));
        ModDataGenerator.SLABS.forEach(pair -> dropSelf(pair.getFirst()));
        ModDataGenerator.WALLS.forEach(this::dropSelf);
        ModDataGenerator.FENCES.forEach(pair -> dropSelf(pair.getFirst()));
        ModDataGenerator.FENCE_GATES.forEach(pair -> dropSelf(pair.getFirst()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createBoneSandDrops(Block block, ItemLike item) {
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 5.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createTrellisCropDrops(Block cropBlock) {
        ITrellisCrop trellisCrop = (ITrellisCrop) cropBlock;
        LootItemCondition.Builder ageCondition = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        LootItemBlockStatePropertyCondition.Builder halfCondition = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TrellisCropBlock.HALF, DoubleBlockHalf.LOWER));

        return this.applyExplosionDecay(cropBlock, LootTable.lootTable()
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
                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.TRELLIS.get())
                                .when(halfCondition)))
        );
    }
}
