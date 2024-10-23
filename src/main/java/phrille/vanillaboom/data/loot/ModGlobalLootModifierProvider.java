package phrille.vanillaboom.data.loot;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.loot.DropLootModifier;
import phrille.vanillaboom.loot.FishingLootModifier;
import phrille.vanillaboom.loot.ModGlobalLootModifiers;

import java.util.List;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(DataGenerator generator) {
        super(generator, VanillaBoom.MOD_ID);
    }

    @Override
    protected void start() {
        entityLootModifier("drowned", EntityType.DROWNED, List.of(Items.ROTTEN_FLESH));
        entityLootModifier("polar_bear", EntityType.POLAR_BEAR, List.of(Items.COD, Items.SALMON));
        entityLootModifier("silverfish", EntityType.SILVERFISH, List.of());
        entityLootModifier("wither_skeleton", EntityType.WITHER_SKELETON, List.of(Items.BONE));
        blockLootModifier("spruce_leaves", Blocks.SPRUCE_LEAVES, List.of());
        add("fishing", new FishingLootModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "gameplay/fishing")).build()
        }, ModGlobalLootModifiers.getLootTableReference("vanillaboom:fishing"), 0.3F));
    }

    private void entityLootModifier(String name, EntityType<?> entityType, List<Item> overwrites) {
        dropLootModifier(name, new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityType))).build()
        }, overwrites);
    }

    @SuppressWarnings("SameParameterValue")
    private void blockLootModifier(String name, Block block, List<Item> overwrites) {
        dropLootModifier(name, new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).build()
        }, overwrites);
    }

    private void dropLootModifier(String name, LootItemCondition[] conditions, List<Item> overwrites) {
        add(name, new DropLootModifier(conditions, ModGlobalLootModifiers.getLootTableReference("vanillaboom:minecraft/" + name), overwrites));
    }
}
