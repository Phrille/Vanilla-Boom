/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.loot;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

import javax.annotation.Nullable;
import java.util.List;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, VanillaBoom.MOD_ID);
    }

    @Override
    protected void start() {
        // Blocks
        add("spruce_leaves", new DropLootModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES).build()},
                ModGlobalLootModifiers.getLootTableReference(VanillaBoom.resLoc("blocks/loot_modifiers/spruce_leaves")),
                null));

        // Entities
        entityLootModifier("drowned", EntityType.DROWNED, List.of(Items.ROTTEN_FLESH));
        entityLootModifier("polar_bear", EntityType.POLAR_BEAR, List.of(Items.COD, Items.SALMON));
        entityLootModifier("silverfish", EntityType.SILVERFISH, null);
        entityLootModifier("wither_skeleton", EntityType.WITHER_SKELETON, List.of(Items.BONE));

        // Gameplay
        add("fishing", new FishingLootModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "gameplay/fishing/fish")).build()},
                ModGlobalLootModifiers.getLootTableReference(VanillaBoom.resLoc("gameplay/fishing/fish")),
                0.3F));
    }

    private void entityLootModifier(String name, EntityType<?> entityType, @Nullable List<Item> removeItems) {
        add(name, new DropLootModifier(new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(
                        LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityType))).build()},
                ModGlobalLootModifiers.getLootTableReference(VanillaBoom.resLoc("entities/loot_modifiers/" + name)),
                removeItems));
    }
}
