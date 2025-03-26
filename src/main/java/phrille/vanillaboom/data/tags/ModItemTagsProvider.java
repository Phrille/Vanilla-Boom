/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.CommonTags;
import phrille.vanillaboom.util.ModTags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        modTags();
        customCommonTags();
        defaultCommonTags();
        minecraftTags();
    }

    protected void minecraftTags() {
        copy(BlockTags.FENCES, ItemTags.FENCES);
        copy(BlockTags.SAND, ItemTags.SAND);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        copy(BlockTags.SOUL_FIRE_BASE_BLOCKS, ItemTags.SOUL_FIRE_BASE_BLOCKS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

        tag(ItemTags.ARROWS)
                .add(ModItems.PRISMARINE_ARROW.get());
        tag(ItemTags.CAMEL_FOOD)
                .add(ModItems.CHILI.get());
        tag(ItemTags.CAT_FOOD)
                .add(ModItems.PIKE.get())
                .add(ModItems.TUNA.get())
                .add(ModItems.PERCH.get());
        tag(ItemTags.CHICKEN_FOOD)
                .add(ModItems.TOMATO_SEEDS.get())
                .add(ModItems.CHILI_SEEDS.get())
                .add(ModItems.RICE_GRAINS.get());
        tag(ItemTags.FISHES)
                .addTags(ModTags.Items.RAW_FISHES)
                .addTags(ModTags.Items.COOKED_FISHES);
        tag(ItemTags.MEAT)
                .add(ModItems.DROWNED_FLESH.get())
                .add(ModItems.POLAR_BEAR_STEAK.get())
                .add(ModItems.RAW_POLAR_BEAR_MEAT.get());
        tag(ItemTags.NON_FLAMMABLE_WOOD)
                .addTags(ModTags.Items.NETHER_BOOKSHELVES)
                .addTags(ModTags.Items.NETHER_LADDERS)
                .addTags(ModTags.Items.NETHER_WOODEN_FENCES)
                .addTags(ModTags.Items.NETHER_WOODEN_FENCE_GATES)
                .addTags(ModTags.Items.NETHER_WOODEN_SLABS)
                .addTags(ModTags.Items.NETHER_WOODEN_STAIRS);
        tag(ItemTags.OCELOT_FOOD)
                .add(ModItems.PIKE.get())
                .add(ModItems.TUNA.get())
                .add(ModItems.PERCH.get());
        tag(ItemTags.PARROT_FOOD)
                .add(ModItems.TOMATO_SEEDS.get())
                .add(ModItems.CHILI_SEEDS.get())
                .add(ModItems.RICE_GRAINS.get());
        tag(ItemTags.PARROT_POISONOUS_FOOD)
                .add(ModItems.CHOCOLATE.get())
                .add(ModItems.CHOCOLATE_CAKE.get());
        tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.GOLD_BARS.get())
                .add(ModItems.GOLD_BLOCK_STAIRS.get())
                .add(ModItems.GOLD_BLOCK_SLAB.get())
                .add(ModItems.GOLD_BLOCK_WALL.get());
        /*
         TODO: Add this tag when villager AI to handle custom crops have been added.
         tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                 .add(ModItems.TOMATO_SEEDS.get())
                 .add(ModItems.CHILI_SEEDS.get())
                 .add(ModItems.RICE_GRAINS.get());
        */
        tag(ItemTags.WOLF_FOOD)
                .add(ModItems.MONSTER_PIE.get());
    }

    protected void defaultCommonTags() {
        copy(Tags.Blocks.BOOKSHELVES, Tags.Items.BOOKSHELVES);
        copy(Tags.Blocks.FENCES_NETHER_BRICK, Tags.Items.FENCES_NETHER_BRICK);
        copy(Tags.Blocks.FENCES_WOODEN, Tags.Items.FENCES_WOODEN);
        copy(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
        copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(Tags.Items.CROPS)
                .addTags(CommonTags.Items.CROPS_TOMATO)
                .addTags(CommonTags.Items.CROPS_CHILI)
                .addTags(CommonTags.Items.CROPS_RICE);
        tag(Tags.Items.FOODS)
                .addTags(CommonTags.Items.FOODS_PIES)
                .addTags(CommonTags.Items.FOODS_RICES);
        tag(Tags.Items.FOODS_CANDIES)
                .add(ModItems.CHOCOLATE.get())
                .add(ModItems.MELON_POPSICLE.get());
        tag(Tags.Items.FOODS_COOKED_FISHES)
                .addTags(ModTags.Items.COOKED_FISHES);
        tag(Tags.Items.FOODS_COOKED_MEATS)
                .add(ModItems.POLAR_BEAR_STEAK.get());
        tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
                .add(ModItems.CHOCOLATE_CAKE.get())
                .add(ModItems.BERRY_CAKE.get())
                .add(ModItems.CARROT_CAKE.get());
        tag(Tags.Items.FOODS_FOOD_POISONING)
                .add(ModItems.DROWNED_FLESH.get())
                .add(ModItems.MONSTER_PIE.get());
        tag(Tags.Items.FOODS_RAW_FISHES)
                .addTags(ModTags.Items.RAW_FISHES);
        tag(Tags.Items.FOODS_RAW_MEATS)
                .add(ModItems.RAW_POLAR_BEAR_MEAT.get());
        tag(Tags.Items.FOODS_SOUPS)
                .add(ModItems.FISH_SOUP.get())
                .add(ModItems.MEAT_SOUP.get())
                .add(ModItems.POTATO_SOUP.get());
        tag(Tags.Items.FOODS_VEGETABLES)
                .add(ModItems.CHILI.get())
                .add(ModItems.TOMATO.get());
        tag(Tags.Items.INGOTS)
                .addTags(CommonTags.Items.INGOTS_MAGMA_BRICK);
        tag(Tags.Items.SEEDS)
                .addTags(CommonTags.Items.SEEDS_TOMATO)
                .addTags(CommonTags.Items.SEEDS_CHILI)
                .addTags(CommonTags.Items.SEEDS_RICE);
    }

    protected void customCommonTags() {
        copy(CommonTags.Blocks.LADDERS, CommonTags.Items.LADDERS);
        copy(CommonTags.Blocks.FENCE_GATES_NETHER_BRICK, CommonTags.Items.FENCE_GATES_NETHER_BRICK);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_CHARCOAL, CommonTags.Items.STORAGE_BLOCKS_CHARCOAL);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_SUGAR, CommonTags.Items.STORAGE_BLOCKS_SUGAR);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE, CommonTags.Items.STORAGE_BLOCKS_SUGAR_CANE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_GUNPOWDER, CommonTags.Items.STORAGE_BLOCKS_GUNPOWDER);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_BLAZE_POWDER, CommonTags.Items.STORAGE_BLOCKS_BLAZE_POWDER);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_MAGMA_CREAM, CommonTags.Items.STORAGE_BLOCKS_MAGMA_CREAM);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_PRISMARINE_CRYSTAL, CommonTags.Items.STORAGE_BLOCKS_PRISMARINE_CRYSTAL);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_WITHER_BONE_MEAL, CommonTags.Items.STORAGE_BLOCKS_WITHER_BONE_MEAL);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_WHITE_DYE, CommonTags.Items.STORAGE_BLOCKS_WHITE_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_ORANGE_DYE, CommonTags.Items.STORAGE_BLOCKS_ORANGE_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_MAGENTA_DYE, CommonTags.Items.STORAGE_BLOCKS_MAGENTA_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_LIGHT_BLUE_DYE, CommonTags.Items.STORAGE_BLOCKS_LIGHT_BLUE_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_YELLOW_DYE, CommonTags.Items.STORAGE_BLOCKS_YELLOW_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_LIME_DYE, CommonTags.Items.STORAGE_BLOCKS_LIME_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_PINK_DYE, CommonTags.Items.STORAGE_BLOCKS_PINK_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_GRAY_DYE, CommonTags.Items.STORAGE_BLOCKS_GRAY_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_LIGHT_GRAY_DYE, CommonTags.Items.STORAGE_BLOCKS_LIGHT_GRAY_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_CYAN_DYE, CommonTags.Items.STORAGE_BLOCKS_CYAN_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_PURPLE_DYE, CommonTags.Items.STORAGE_BLOCKS_PURPLE_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_BLUE_DYE, CommonTags.Items.STORAGE_BLOCKS_BLUE_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_BROWN_DYE, CommonTags.Items.STORAGE_BLOCKS_BROWN_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_GREEN_DYE, CommonTags.Items.STORAGE_BLOCKS_GREEN_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_RED_DYE, CommonTags.Items.STORAGE_BLOCKS_RED_DYE);
        copy(CommonTags.Blocks.STORAGE_BLOCKS_BLACK_DYE, CommonTags.Items.STORAGE_BLOCKS_BLACK_DYE);

        tag(CommonTags.Items.CANVASES)
                .add(ModItems.CANVAS.get());
        tag(CommonTags.Items.CROPS_CHILI)
                .add(ModItems.CHILI.get());
        tag(CommonTags.Items.CROPS_RICE)
                .add(ModItems.RICE_GRAINS.get());
        tag(CommonTags.Items.CROPS_TOMATO)
                .add(ModItems.TOMATO.get());
        tag(CommonTags.Items.FOODS_PIES)
                .add(Items.PUMPKIN_PIE)
                .add(ModItems.APPLE_PIE.get())
                .add(ModItems.BERRY_PIE.get())
                .add(ModItems.MONSTER_PIE.get());
        tag(CommonTags.Items.FOODS_RICES)
                .add(ModItems.RICE_GRAINS.get());
        tag(CommonTags.Items.INGOTS_MAGMA_BRICK)
                .add(ModItems.MAGMA_BRICK.get());
        tag(CommonTags.Items.SEEDS_CHILI)
                .add(ModItems.CHILI_SEEDS.get());
        tag(CommonTags.Items.SEEDS_RICE)
                .add(ModItems.RICE_GRAINS.get());
        tag(CommonTags.Items.SEEDS_TOMATO)
                .add(ModItems.TOMATO_SEEDS.get());
        tag(CommonTags.Items.WITHER_BONES)
                .add(ModItems.WITHER_BONE.get());
        tag(CommonTags.Items.WITHER_BONE_MEALS)
                .add(ModItems.WITHER_BONE_MEAL.get());
    }

    protected void modTags() {
        copy(ModTags.Blocks.BRICKS, ModTags.Items.BRICKS);
        copy(ModTags.Blocks.DYE_BLOCKS, ModTags.Items.DYE_BLOCKS);
        copy(ModTags.Blocks.NETHER_BOOKSHELVES, ModTags.Items.NETHER_BOOKSHELVES);
        copy(ModTags.Blocks.NETHER_BRICK_FENCES, ModTags.Items.NETHER_BRICK_FENCES);
        copy(ModTags.Blocks.NETHER_BRICK_FENCE_GATES, ModTags.Items.NETHER_BRICK_FENCE_GATES);
        copy(ModTags.Blocks.NETHER_LADDERS, ModTags.Items.NETHER_LADDERS);
        copy(ModTags.Blocks.NETHER_WOODEN_FENCES, ModTags.Items.NETHER_WOODEN_FENCES);
        copy(ModTags.Blocks.NETHER_WOODEN_FENCE_GATES, ModTags.Items.NETHER_WOODEN_FENCE_GATES);
        copy(ModTags.Blocks.NETHER_WOODEN_SLABS, ModTags.Items.NETHER_WOODEN_SLABS);
        copy(ModTags.Blocks.NETHER_WOODEN_STAIRS, ModTags.Items.NETHER_WOODEN_STAIRS);
        copy(ModTags.Blocks.OVERWORLD_BOOKSHELVES, ModTags.Items.OVERWORLD_BOOKSHELVES);
        copy(ModTags.Blocks.OVERWORLD_LADDERS, ModTags.Items.OVERWORLD_LADDERS);
        copy(ModTags.Blocks.OVERWORLD_WOODEN_FENCES, ModTags.Items.OVERWORLD_WOODEN_FENCES);
        copy(ModTags.Blocks.OVERWORLD_WOODEN_FENCE_GATES, ModTags.Items.OVERWORLD_WOODEN_FENCE_GATES);
        copy(ModTags.Blocks.OVERWORLD_WOODEN_SLABS, ModTags.Items.OVERWORLD_WOODEN_SLABS);
        copy(ModTags.Blocks.OVERWORLD_WOODEN_STAIRS, ModTags.Items.OVERWORLD_WOODEN_STAIRS);
        copy(ModTags.Blocks.PILLARS, ModTags.Items.PILLARS);
        copy(ModTags.Blocks.POLISHED, ModTags.Items.POLISHED);
        copy(ModTags.Blocks.SLABS, ModTags.Items.SLABS);
        copy(ModTags.Blocks.STAIRS, ModTags.Items.STAIRS);
        copy(ModTags.Blocks.WALLS, ModTags.Items.WALLS);

        tag(ModTags.Items.COOKED_FISHES)
                .add(ModItems.COOKED_TUNA.get())
                .add(ModItems.COOKED_PERCH.get())
                .add(ModItems.COOKED_PIKE.get())
                .add(ModItems.COOKED_EEL.get());
        tag(ModTags.Items.POTATO_SOUP_INGREDIENTS)
                .add(Items.POISONOUS_POTATO)
                .addTags(Tags.Items.CROPS_POTATO);
        tag(ModTags.Items.RAW_FISHES)
                .add(ModItems.TUNA.get())
                .add(ModItems.PERCH.get())
                .add(ModItems.PIKE.get())
                .add(ModItems.EEL.get());
    }
}
