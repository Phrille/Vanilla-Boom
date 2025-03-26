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
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.block.variant.*;
import phrille.vanillaboom.data.ModDataGenerator;
import phrille.vanillaboom.util.CommonTags;
import phrille.vanillaboom.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

// TODO: add vb tags for sand, soul glass?
// TODO: common: glass, dyed, sands, sandstone, stones
@SuppressWarnings("unchecked")
public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        modTags();
        customCommonTags();
        defaultCommonTags();
        minecraftTags();
    }

    protected void minecraftTags() {
        tag(BlockTags.BASE_STONE_OVERWORLD)
                .add(ModBlocks.PERIDOTITE.get());
        tag(BlockTags.CAMEL_SAND_STEP_SOUND_BLOCKS)
                .add(ModBlocks.SUGAR_BLOCK.get())
                .add(ModBlocks.GUNPOWDER_BLOCK.get());
        tag(BlockTags.CANDLE_CAKES, ModDataGenerator.CANDLES
                .stream()
                .map(candle -> ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).byCandle(candle))
                .toList());
        tag(BlockTags.CANDLE_CAKES, ModDataGenerator.CANDLES
                .stream()
                .map(candle -> ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).byCandle(candle))
                .toList());
        tag(BlockTags.CANDLE_CAKES, ModDataGenerator.CANDLES
                .stream()
                .map(candle -> ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).byCandle(candle))
                .toList());
        tag(BlockTags.CLIMBABLE)
                .add(ModBlocks.WITHERED_VINE.get())
                .addTags(ModTags.Blocks.OVERWORLD_LADDERS)
                .addTags(ModTags.Blocks.NETHER_LADDERS);
        tag(BlockTags.CROPS, List.of(
                ModBlocks.TOMATO.get(),
                ModBlocks.CHILI.get(),
                ModBlocks.RICE.get()));
        tag(BlockTags.CRYSTAL_SOUND_BLOCKS)
                .add(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        tag(BlockTags.DRAGON_IMMUNE, List.of(
                ModBlocks.OBSIDIAN_BRICKS.get(),
                ModBlocks.OBSIDIAN_PILLAR.get(),
                ModBlocks.CHISELED_OBSIDIAN.get(),
                ModBlocks.OBSIDIAN_STAIRS.get(),
                ModBlocks.OBSIDIAN_SLAB.get(),
                ModBlocks.OBSIDIAN_WALL.get(),
                ModBlocks.OBSIDIAN_BRICK_STAIRS.get(),
                ModBlocks.OBSIDIAN_BRICK_SLAB.get(),
                ModBlocks.OBSIDIAN_BRICK_WALL.get(),
                ModBlocks.BEDROCK_STAIRS.get(),
                ModBlocks.BEDROCK_SLAB.get(),
                ModBlocks.BEDROCK_WALL.get()));
        tag(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                .addTags(ModTags.Blocks.OVERWORLD_BOOKSHELVES)
                .addTags(ModTags.Blocks.NETHER_BOOKSHELVES);
        tag(BlockTags.FENCES)
                .addTags(ModTags.Blocks.NETHER_BRICK_FENCES);
        tag(BlockTags.FENCE_GATES)
                .addTags(ModTags.Blocks.OVERWORLD_WOODEN_FENCE_GATES)
                .addTags(ModTags.Blocks.NETHER_WOODEN_FENCE_GATES)
                .addTags(ModTags.Blocks.NETHER_BRICK_FENCE_GATES);
        tag(BlockTags.FLOWER_POTS, List.of(
                ModBlocks.POTTED_ROSE.get(),
                ModBlocks.POTTED_PEONY.get(),
                ModBlocks.POTTED_LILAC.get()));
        tag(BlockTags.IMPERMEABLE, List.of(
                ModBlocks.SOUL_GLASS.get(),
                ModBlocks.WHITE_STAINED_SOUL_GLASS.get(),
                ModBlocks.ORANGE_STAINED_SOUL_GLASS.get(),
                ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get(),
                ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get(),
                ModBlocks.YELLOW_STAINED_SOUL_GLASS.get(),
                ModBlocks.LIME_STAINED_SOUL_GLASS.get(),
                ModBlocks.PINK_STAINED_SOUL_GLASS.get(),
                ModBlocks.GRAY_STAINED_SOUL_GLASS.get(),
                ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get(),
                ModBlocks.CYAN_STAINED_SOUL_GLASS.get(),
                ModBlocks.PURPLE_STAINED_SOUL_GLASS.get(),
                ModBlocks.BLUE_STAINED_SOUL_GLASS.get(),
                ModBlocks.BROWN_STAINED_SOUL_GLASS.get(),
                ModBlocks.GREEN_STAINED_SOUL_GLASS.get(),
                ModBlocks.RED_STAINED_SOUL_GLASS.get(),
                ModBlocks.BLACK_STAINED_SOUL_GLASS.get()));
        tag(BlockTags.INFINIBURN_OVERWORLD, List.of(
                ModBlocks.MAGMA_BRICKS.get(),
                ModBlocks.INFERNAL_ROCK.get(),
                ModBlocks.POLISHED_NETHERRACK.get(),
                ModBlocks.NETHERRACK_PILLAR.get()));
        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(ModBlocks.TRELLIS.get())
                .add(ModBlocks.TOMATO.get())
                .add(ModBlocks.CHILI.get())
                .add(ModBlocks.RICE.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SUGAR_CANE_BLOCK.get())
                .add(ModBlocks.EASEL.get())
                .addTags(ModTags.Blocks.OVERWORLD_BOOKSHELVES)
                .addTags(ModTags.Blocks.NETHER_BOOKSHELVES)
                .addTags(ModTags.Blocks.OVERWORLD_LADDERS)
                .addTags(ModTags.Blocks.NETHER_LADDERS);
        tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.SUGAR_CANE_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PERIDOTITE.get())
                .add(ModBlocks.HYDRO_ROCK.get())
                .add(ModBlocks.INFERNAL_ROCK.get())
                .add(ModBlocks.CRACKED_RED_NETHER_BRICKS.get())
                .add(ModBlocks.CHISELED_RED_NETHER_BRICKS.get())
                .add(ModBlocks.CHISELED_PURPUR_BLOCK.get())
                .add(ModBlocks.CHISELED_OBSIDIAN.get())
                .add(ModBlocks.CHARCOAL_BLOCK.get())
                .add(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get())
                .add(ModBlocks.WITHER_BONE_BLOCK.get())
                .add(ModBlocks.GOLD_BARS.get())
                .addTags(ModTags.Blocks.BRICKS)
                .addTags(ModTags.Blocks.POLISHED)
                .addTags(ModTags.Blocks.PILLARS)
                .addTags(ModTags.Blocks.DYE_BLOCKS)
                .addTags(ModTags.Blocks.STAIRS)
                .addTags(ModTags.Blocks.SLABS)
                .addTags(ModTags.Blocks.NETHER_BRICK_FENCES)
                .addTags(ModTags.Blocks.NETHER_BRICK_FENCE_GATES);
        tag(BlockTags.MINEABLE_WITH_SHOVEL, List.of(
                ModBlocks.BONE_SAND.get(),
                ModBlocks.WITHER_BONE_SAND.get(),
                ModBlocks.SUGAR_BLOCK.get(),
                ModBlocks.GUNPOWDER_BLOCK.get(),
                ModBlocks.BLAZE_POWDER_BLOCK.get()));
        tag(BlockTags.NEEDS_DIAMOND_TOOL, List.of(
                ModBlocks.OBSIDIAN_BRICKS.get(),
                ModBlocks.OBSIDIAN_PILLAR.get(),
                ModBlocks.CHISELED_OBSIDIAN.get(),
                ModBlocks.OBSIDIAN_STAIRS.get(),
                ModBlocks.OBSIDIAN_SLAB.get(),
                ModBlocks.OBSIDIAN_WALL.get(),
                ModBlocks.OBSIDIAN_BRICK_STAIRS.get(),
                ModBlocks.OBSIDIAN_BRICK_SLAB.get(),
                ModBlocks.OBSIDIAN_BRICK_WALL.get()));
        tag(BlockTags.NEEDS_IRON_TOOL, List.of(
                ModBlocks.GOLD_BARS.get(),
                ModBlocks.GOLD_BLOCK_STAIRS.get(),
                ModBlocks.GOLD_BLOCK_SLAB.get(),
                ModBlocks.GOLD_BLOCK_WALL.get()));
        tag(BlockTags.NEEDS_STONE_TOOL, List.of(
                Blocks.IRON_BARS,
                ModBlocks.IRON_BLOCK_STAIRS.get(),
                ModBlocks.IRON_BLOCK_SLAB.get(),
                ModBlocks.IRON_BLOCK_WALL.get()));
        tag(BlockTags.NETHER_CARVER_REPLACEABLES)
                .add(ModBlocks.INFERNAL_ROCK.get())
                .add(ModBlocks.BONE_SAND.get())
                .add(ModBlocks.WITHER_BONE_SAND.get());
        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
                .add(ModBlocks.HYDRO_ROCK.get());
        tag(BlockTags.REPLACEABLE)
                .add(ModBlocks.WITHERED_VINE.get());
        tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(ModBlocks.WITHERED_VINE.get());
        tag(BlockTags.SAND)
                .add(ModBlocks.BONE_SAND.get())
                .add(ModBlocks.WITHER_BONE_SAND.get());
        tag(BlockTags.SLABS)
                .addTags(ModTags.Blocks.SLABS);
        tag(BlockTags.SMALL_FLOWERS, List.of(
                ModBlocks.ROSE.get(),
                ModBlocks.PEONY.get(),
                ModBlocks.LILAC.get()));
        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS, List.of(
                ModBlocks.BONE_SAND.get(),
                ModBlocks.WITHER_BONE_SAND.get()));
        tag(BlockTags.STAIRS)
                .addTags(ModTags.Blocks.STAIRS);
        tag(BlockTags.STONE_ORE_REPLACEABLES)
                .add(ModBlocks.PERIDOTITE.get());
        tag(BlockTags.WALLS)
                .addTags(ModTags.Blocks.WALLS);
        tag(BlockTags.WITHER_IMMUNE, List.of(
                ModBlocks.BEDROCK_STAIRS.get(),
                ModBlocks.BEDROCK_SLAB.get(),
                ModBlocks.BEDROCK_WALL.get()));
        tag(BlockTags.WOODEN_FENCES)
                .addTags(ModTags.Blocks.OVERWORLD_WOODEN_FENCES)
                .addTags(ModTags.Blocks.NETHER_WOODEN_FENCES);
        tag(BlockTags.WOODEN_SLABS)
                .addTags(ModTags.Blocks.OVERWORLD_WOODEN_SLABS)
                .addTags(ModTags.Blocks.NETHER_WOODEN_SLABS);
        tag(BlockTags.WOODEN_STAIRS)
                .addTags(ModTags.Blocks.OVERWORLD_WOODEN_STAIRS)
                .addTags(ModTags.Blocks.NETHER_WOODEN_STAIRS);
    }

    protected void defaultCommonTags() {
        tag(Tags.Blocks.BOOKSHELVES)
                .addTags(ModTags.Blocks.OVERWORLD_BOOKSHELVES)
                .addTags(ModTags.Blocks.NETHER_BOOKSHELVES);
        tag(Tags.Blocks.FENCES_NETHER_BRICK)
                .addTags(ModTags.Blocks.NETHER_BRICK_FENCES);
        tag(Tags.Blocks.FENCES_WOODEN)
                .addTags(ModTags.Blocks.OVERWORLD_WOODEN_FENCES)
                .addTags(ModTags.Blocks.NETHER_WOODEN_FENCES);
        tag(Tags.Blocks.FENCE_GATES)
                .addTags(CommonTags.Blocks.FENCE_GATES_NETHER_BRICK);
        tag(Tags.Blocks.FENCE_GATES_WOODEN)
                .addTags(ModTags.Blocks.OVERWORLD_WOODEN_FENCE_GATES)
                .addTags(ModTags.Blocks.NETHER_WOODEN_FENCE_GATES);
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_CHARCOAL)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_SUGAR)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_GUNPOWDER)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_BLAZE_POWDER)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_MAGMA_CREAM)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_PRISMARINE_CRYSTAL)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_WITHER_BONE_MEAL)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_WHITE_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_ORANGE_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_MAGENTA_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_LIGHT_BLUE_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_YELLOW_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_LIME_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_PINK_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_GRAY_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_LIGHT_GRAY_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_CYAN_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_PURPLE_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_BLUE_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_BROWN_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_GREEN_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_RED_DYE)
                .addTags(CommonTags.Blocks.STORAGE_BLOCKS_BLACK_DYE);
    }

    protected void customCommonTags() {
        tag(CommonTags.Blocks.LADDERS)
                .addTags(ModTags.Blocks.OVERWORLD_LADDERS)
                .addTags(ModTags.Blocks.NETHER_LADDERS);
        tag(CommonTags.Blocks.FENCE_GATES_NETHER_BRICK)
                .addTags(ModTags.Blocks.NETHER_BRICK_FENCE_GATES);
        tag(CommonTags.Blocks.STORAGE_BLOCKS_CHARCOAL)
                .add(ModBlocks.CHARCOAL_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_SUGAR)
                .add(ModBlocks.SUGAR_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE)
                .add(ModBlocks.SUGAR_CANE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_GUNPOWDER)
                .add(ModBlocks.GUNPOWDER_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_BLAZE_POWDER)
                .add(ModBlocks.BLAZE_POWDER_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_MAGMA_CREAM)
                .add(ModBlocks.MAGMA_CREAM_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_PRISMARINE_CRYSTAL)
                .add(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_WITHER_BONE_MEAL)
                .add(ModBlocks.WITHER_BONE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_WHITE_DYE)
                .add(ModBlocks.WHITE_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_ORANGE_DYE)
                .add(ModBlocks.ORANGE_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_MAGENTA_DYE)
                .add(ModBlocks.MAGENTA_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_LIGHT_BLUE_DYE)
                .add(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_YELLOW_DYE)
                .add(ModBlocks.YELLOW_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_LIME_DYE)
                .add(ModBlocks.LIME_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_PINK_DYE)
                .add(ModBlocks.PINK_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_GRAY_DYE)
                .add(ModBlocks.GRAY_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_LIGHT_GRAY_DYE)
                .add(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_CYAN_DYE)
                .add(ModBlocks.CYAN_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_PURPLE_DYE)
                .add(ModBlocks.PURPLE_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_BLUE_DYE)
                .add(ModBlocks.BLUE_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_BROWN_DYE)
                .add(ModBlocks.BROWN_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_GREEN_DYE)
                .add(ModBlocks.GREEN_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_RED_DYE)
                .add(ModBlocks.RED_DYE_BLOCK.get());
        tag(CommonTags.Blocks.STORAGE_BLOCKS_BLACK_DYE)
                .add(ModBlocks.BLACK_DYE_BLOCK.get());
    }

    protected void modTags() {
        tag(ModTags.Blocks.BRICKS, List.of(
                ModBlocks.COBBLESTONE_BRICKS.get(),
                ModBlocks.MOSSY_COBBLESTONE_BRICKS.get(),
                ModBlocks.MAGMA_BRICKS.get(),
                ModBlocks.OBSIDIAN_BRICKS.get(),
                ModBlocks.SNOW_BRICKS.get(),
                ModBlocks.TERRACOTTA_BRICKS.get(),
                ModBlocks.WHITE_TERRACOTTA_BRICKS.get(),
                ModBlocks.ORANGE_TERRACOTTA_BRICKS.get(),
                ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get(),
                ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(),
                ModBlocks.YELLOW_TERRACOTTA_BRICKS.get(),
                ModBlocks.LIME_TERRACOTTA_BRICKS.get(),
                ModBlocks.PINK_TERRACOTTA_BRICKS.get(),
                ModBlocks.GRAY_TERRACOTTA_BRICKS.get(),
                ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(),
                ModBlocks.CYAN_TERRACOTTA_BRICKS.get(),
                ModBlocks.PURPLE_TERRACOTTA_BRICKS.get(),
                ModBlocks.BLUE_TERRACOTTA_BRICKS.get(),
                ModBlocks.BROWN_TERRACOTTA_BRICKS.get(),
                ModBlocks.GREEN_TERRACOTTA_BRICKS.get(),
                ModBlocks.RED_TERRACOTTA_BRICKS.get(),
                ModBlocks.BLACK_TERRACOTTA_BRICKS.get()));
        tag(ModTags.Blocks.DYE_BLOCKS, List.of(
                ModBlocks.WHITE_DYE_BLOCK.get(),
                ModBlocks.ORANGE_DYE_BLOCK.get(),
                ModBlocks.MAGENTA_DYE_BLOCK.get(),
                ModBlocks.LIGHT_BLUE_DYE_BLOCK.get(),
                ModBlocks.YELLOW_DYE_BLOCK.get(),
                ModBlocks.LIME_DYE_BLOCK.get(),
                ModBlocks.PINK_DYE_BLOCK.get(),
                ModBlocks.GRAY_DYE_BLOCK.get(),
                ModBlocks.LIGHT_GRAY_DYE_BLOCK.get(),
                ModBlocks.CYAN_DYE_BLOCK.get(),
                ModBlocks.PURPLE_DYE_BLOCK.get(),
                ModBlocks.BLUE_DYE_BLOCK.get(),
                ModBlocks.BROWN_DYE_BLOCK.get(),
                ModBlocks.GREEN_DYE_BLOCK.get(),
                ModBlocks.RED_DYE_BLOCK.get(),
                ModBlocks.BLACK_DYE_BLOCK.get()));
        tag(ModTags.Blocks.POLISHED, List.of(
                ModBlocks.POLISHED_PERIDOTITE.get(),
                ModBlocks.POLISHED_PRISMARINE.get(),
                ModBlocks.POLISHED_DARK_PRISMARINE.get(),
                ModBlocks.POLISHED_END_STONE.get(),
                ModBlocks.POLISHED_NETHERRACK.get()));
        tag(ModTags.Blocks.PILLARS, List.of(
                ModBlocks.GRANITE_PILLAR.get(),
                ModBlocks.DIORITE_PILLAR.get(),
                ModBlocks.ANDESITE_PILLAR.get(),
                ModBlocks.PERIDOTITE_PILLAR.get(),
                ModBlocks.PRISMARINE_PILLAR.get(),
                ModBlocks.DARK_PRISMARINE_PILLAR.get(),
                ModBlocks.END_STONE_PILLAR.get(),
                ModBlocks.NETHERRACK_PILLAR.get(),
                ModBlocks.OBSIDIAN_PILLAR.get()));
        variantTag(ModBookshelfBlock.BOOKSHELVES);
        variantTag(ModFenceBlock.FENCES);
        variantTag(ModFenceGateBlock.FENCE_GATES);
        variantTag(ModSlabBlock.SLABS);
        variantTag(ModStairBlock.STAIRS);
        variantTag(ModWallBlock.WALLS);
        ModLadderBlock.LADDERS.forEach(ladder -> {
            TagKey<Block> ladderTag = ModDataGenerator.OVERWORLD_WOOD_BLOCKS.contains(ladder.getCraftingIngredient()) ?
                    ModTags.Blocks.OVERWORLD_LADDERS : ModTags.Blocks.NETHER_LADDERS;
            tag(ladderTag).add(ladder);
        });
    }

    protected void tag(TagKey<Block> tagKey, List<? extends Block> blocks) {
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> tagsProvider = tag(tagKey);
        blocks.forEach(tagsProvider::add);
    }

    protected void variantTag(List<? extends IVariantBlock> variantBlocks) {
        variantBlocks.forEach(variant -> {
            TagKey<Block> variantTag = getVariantTag(variant);
            tag(variantTag).add((Block) variant);
        });
    }

    protected TagKey<Block> getVariantTag(IVariantBlock variant) {
        return switch (variant) {
            case ModBookshelfBlock bookshelf ->
                    ModDataGenerator.OVERWORLD_WOOD_BLOCKS.contains(bookshelf.getParent()) ? ModTags.Blocks.OVERWORLD_BOOKSHELVES : ModTags.Blocks.NETHER_BOOKSHELVES;
            case ModFenceBlock fence -> ModDataGenerator.OVERWORLD_WOOD_BLOCKS.contains(fence.getParent()) ?
                    ModTags.Blocks.OVERWORLD_WOODEN_FENCES :
                    ModDataGenerator.NETHER_WOOD_BLOCKS.contains(fence.getParent()) ?
                            ModTags.Blocks.NETHER_WOODEN_FENCES :
                            ModTags.Blocks.NETHER_BRICK_FENCES;
            case ModFenceGateBlock fenceGate -> ModDataGenerator.OVERWORLD_WOOD_BLOCKS.contains(fenceGate.getParent()) ?
                    ModTags.Blocks.OVERWORLD_WOODEN_FENCE_GATES :
                    ModDataGenerator.NETHER_WOOD_BLOCKS.contains(fenceGate.getParent()) ?
                            ModTags.Blocks.NETHER_WOODEN_FENCE_GATES :
                            ModTags.Blocks.NETHER_BRICK_FENCE_GATES;
            case ModSlabBlock slab -> ModDataGenerator.OVERWORLD_WOOD_BLOCKS.contains(slab.getParent()) ?
                    ModTags.Blocks.OVERWORLD_WOODEN_SLABS :
                    ModDataGenerator.NETHER_WOOD_BLOCKS.contains(slab.getParent()) ?
                            ModTags.Blocks.NETHER_WOODEN_SLABS :
                            ModTags.Blocks.SLABS;
            case ModStairBlock stair -> ModDataGenerator.OVERWORLD_WOOD_BLOCKS.contains(stair.getParent()) ?
                    ModTags.Blocks.OVERWORLD_WOODEN_STAIRS :
                    ModDataGenerator.NETHER_WOOD_BLOCKS.contains(stair.getParent()) ?
                            ModTags.Blocks.NETHER_WOODEN_STAIRS :
                            ModTags.Blocks.STAIRS;
            case ModWallBlock ignored -> ModTags.Blocks.WALLS;
            default ->
                    throw new IllegalArgumentException("Tried to get variant tag for invalid block %s".formatted(variant.getClass()));
        };
    }
}
