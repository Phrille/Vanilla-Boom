package phrille.vanillaboom.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.block.variant.*;
import phrille.vanillaboom.util.ModTags;
import phrille.vanillaboom.util.Utils;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        /*
         * Forge tags
         */
        tag(ModTags.ForgeTags.Blocks.FENCE_GATES_NETHER_BRICK).addTags(ModTags.VanillaBoomTags.Blocks.FENCE_GATES);
        tag(Tags.Blocks.FENCE_GATES_WOODEN).addTags(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCE_GATES);
        tag(Tags.Blocks.FENCE_GATES).addTags(ModTags.ForgeTags.Blocks.FENCE_GATES_NETHER_BRICK);
        tag(Tags.Blocks.FENCES_NETHER_BRICK).addTags(ModTags.VanillaBoomTags.Blocks.FENCES);
        tag(Tags.Blocks.FENCES_WOODEN).addTags(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCES);
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_CHARCOAL).add(ModBlocks.CHARCOAL_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_SUGAR).add(ModBlocks.SUGAR_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE).add(ModBlocks.SUGAR_CANE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GUNPOWDER).add(ModBlocks.GUNPOWDER_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLAZE_POWDER).add(ModBlocks.BLAZE_POWDER_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_MAGMA_CREAM).add(ModBlocks.MAGMA_CREAM_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PRISMARINE_CRYSTAL).add(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_WITHER_BONE).add(ModBlocks.WITHER_BONE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_WHITE_DYE).add(ModBlocks.WHITE_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_ORANGE_DYE).add(ModBlocks.ORANGE_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_MAGENTA_DYE).add(ModBlocks.MAGENTA_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIGHT_BLUE_DYE).add(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_YELLOW_DYE).add(ModBlocks.YELLOW_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIME_DYE).add(ModBlocks.LIME_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PINK_DYE).add(ModBlocks.PINK_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GRAY_DYE).add(ModBlocks.GRAY_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIGHT_GRAY_DYE).add(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_CYAN_DYE).add(ModBlocks.CYAN_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PURPLE_DYE).add(ModBlocks.PURPLE_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLUE_DYE).add(ModBlocks.BLUE_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BROWN_DYE).add(ModBlocks.BROWN_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GREEN_DYE).add(ModBlocks.GREEN_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_RED_DYE).add(ModBlocks.RED_DYE_BLOCK.get());
        tag(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLACK_DYE).add(ModBlocks.BLACK_DYE_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_CHARCOAL)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_SUGAR)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GUNPOWDER)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLAZE_POWDER)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_MAGMA_CREAM)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PRISMARINE_CRYSTAL)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_WITHER_BONE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_WHITE_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_ORANGE_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_MAGENTA_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIGHT_BLUE_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_YELLOW_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIME_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PINK_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GRAY_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIGHT_GRAY_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_CYAN_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PURPLE_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLUE_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BROWN_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GREEN_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_RED_DYE)
                .addTags(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLACK_DYE);
        tag(ModTags.ForgeTags.Blocks.BOOKSHELVES)
                .addTags(ModTags.VanillaBoomTags.Blocks.BOOKSHELVES);
        tag(ModTags.ForgeTags.Blocks.CAKES)
                .add(Blocks.CAKE)
                .add(ModBlocks.CHOCOLATE_CAKE.get())
                .add(ModBlocks.BERRY_CAKE.get())
                .add(ModBlocks.CARROT_CAKE.get());
        tag(ModTags.ForgeTags.Blocks.LADDERS).addTags(ModTags.VanillaBoomTags.Blocks.LADDERS);

        /*
         * VanillaBoom tags
         */
        tag(ModTags.VanillaBoomTags.Blocks.BRICKS)
                .add(ModBlocks.COBBLESTONE_BRICKS.get())
                .add(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get())
                .add(ModBlocks.MAGMA_BRICKS.get())
                .add(ModBlocks.OBSIDIAN_BRICKS.get())
                .add(ModBlocks.SNOW_BRICKS.get())
                .add(ModBlocks.TERRACOTTA_BRICKS.get())
                .add(ModBlocks.WHITE_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.LIME_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.PINK_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.GRAY_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.CYAN_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.BLUE_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.BROWN_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.GREEN_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.RED_TERRACOTTA_BRICKS.get())
                .add(ModBlocks.BLACK_TERRACOTTA_BRICKS.get());
        tag(ModTags.VanillaBoomTags.Blocks.POLISHED)
                .add(ModBlocks.POLISHED_PERIDOTITE.get())
                .add(ModBlocks.POLISHED_PRISMARINE.get())
                .add(ModBlocks.POLISHED_DARK_PRISMARINE.get())
                .add(ModBlocks.POLISHED_END_STONE.get())
                .add(ModBlocks.POLISHED_NETHERRACK.get());
        tag(ModTags.VanillaBoomTags.Blocks.PILLARS)
                .add(ModBlocks.GRANITE_PILLAR.get())
                .add(ModBlocks.DIORITE_PILLAR.get())
                .add(ModBlocks.ANDESITE_PILLAR.get())
                .add(ModBlocks.PERIDOTITE_PILLAR.get())
                .add(ModBlocks.PRISMARINE_PILLAR.get())
                .add(ModBlocks.DARK_PRISMARINE_PILLAR.get())
                .add(ModBlocks.END_STONE_PILLAR.get())
                .add(ModBlocks.NETHERRACK_PILLAR.get())
                .add(ModBlocks.RED_NETHER_PILLAR.get())
                .add(ModBlocks.OBSIDIAN_PILLAR.get());
        tag(ModTags.VanillaBoomTags.Blocks.BOOKSHELVES)
                .add(ModBlocks.SPRUCE_BOOKSHELF.get())
                .add(ModBlocks.BIRCH_BOOKSHELF.get())
                .add(ModBlocks.JUNGLE_BOOKSHELF.get())
                .add(ModBlocks.ACACIA_BOOKSHELF.get())
                .add(ModBlocks.DARK_OAK_BOOKSHELF.get())
                .add(ModBlocks.MANGROVE_BOOKSHELF.get())
                .add(ModBlocks.CRIMSON_BOOKSHELF.get())
                .add(ModBlocks.WARPED_BOOKSHELF.get());
        tag(ModTags.VanillaBoomTags.Blocks.DYE_BLOCKS)
                .add(ModBlocks.WHITE_DYE_BLOCK.get())
                .add(ModBlocks.ORANGE_DYE_BLOCK.get())
                .add(ModBlocks.MAGENTA_DYE_BLOCK.get())
                .add(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get())
                .add(ModBlocks.YELLOW_DYE_BLOCK.get())
                .add(ModBlocks.LIME_DYE_BLOCK.get())
                .add(ModBlocks.PINK_DYE_BLOCK.get())
                .add(ModBlocks.GRAY_DYE_BLOCK.get())
                .add(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get())
                .add(ModBlocks.CYAN_DYE_BLOCK.get())
                .add(ModBlocks.PURPLE_DYE_BLOCK.get())
                .add(ModBlocks.BLUE_DYE_BLOCK.get())
                .add(ModBlocks.BROWN_DYE_BLOCK.get())
                .add(ModBlocks.GREEN_DYE_BLOCK.get())
                .add(ModBlocks.RED_DYE_BLOCK.get())
                .add(ModBlocks.BLACK_DYE_BLOCK.get());
        tag(ModTags.VanillaBoomTags.Blocks.LADDERS)
                .add(ModBlocks.SPRUCE_LADDER.get())
                .add(ModBlocks.BIRCH_LADDER.get())
                .add(ModBlocks.JUNGLE_LADDER.get())
                .add(ModBlocks.ACACIA_LADDER.get())
                .add(ModBlocks.DARK_OAK_LADDER.get())
                .add(ModBlocks.MANGROVE_LADDER.get())
                .add(ModBlocks.CRIMSON_LADDER.get())
                .add(ModBlocks.WARPED_LADDER.get());

        /*
         * Mineable and tool types tags
         */
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SUGAR_CANE_BLOCK.get())
                .addTags(ModTags.VanillaBoomTags.Blocks.BOOKSHELVES)
                .addTags(ModTags.VanillaBoomTags.Blocks.LADDERS);
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.SUGAR_CANE_BLOCK.get());
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
                .addTags(ModTags.VanillaBoomTags.Blocks.BRICKS)
                .addTags(ModTags.VanillaBoomTags.Blocks.POLISHED)
                .addTags(ModTags.VanillaBoomTags.Blocks.PILLARS)
                .addTags(ModTags.VanillaBoomTags.Blocks.DYE_BLOCKS)
                .addTags(ModTags.VanillaBoomTags.Blocks.STAIRS)
                .addTags(ModTags.VanillaBoomTags.Blocks.SLABS)
                .addTags(ModTags.VanillaBoomTags.Blocks.FENCES)
                .addTags(ModTags.VanillaBoomTags.Blocks.FENCE_GATES);
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.BONE_SAND.get())
                .add(ModBlocks.WITHER_BONE_SAND.get())
                .add(ModBlocks.SUGAR_BLOCK.get())
                .add(ModBlocks.GUNPOWDER_BLOCK.get())
                .add(ModBlocks.BLAZE_POWDER_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.OBSIDIAN_BRICKS.get())
                .add(ModBlocks.OBSIDIAN_PILLAR.get())
                .add(ModBlocks.CHISELED_OBSIDIAN.get())
                .add(ModBlocks.OBSIDIAN_STAIRS.get())
                .add(ModBlocks.OBSIDIAN_SLAB.get())
                .add(ModBlocks.OBSIDIAN_WALL.get())
                .add(ModBlocks.OBSIDIAN_BRICK_STAIRS.get())
                .add(ModBlocks.OBSIDIAN_BRICK_SLAB.get())
                .add(ModBlocks.OBSIDIAN_BRICK_WALL.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GOLD_BARS.get())
                .add(ModBlocks.GOLD_BLOCK_STAIRS.get())
                .add(ModBlocks.GOLD_BLOCK_SLAB.get())
                .add(ModBlocks.GOLD_BLOCK_WALL.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(Blocks.IRON_BARS)
                .add(ModBlocks.IRON_BLOCK_STAIRS.get())
                .add(ModBlocks.IRON_BLOCK_SLAB.get())
                .add(ModBlocks.IRON_BLOCK_WALL.get());

        /*
         * Misc tags
         */
        tag(BlockTags.BASE_STONE_OVERWORLD).add(ModBlocks.PERIDOTITE.get());
        Utils.CANDLES.forEach(candle -> tag(BlockTags.CANDLE_CAKES).add(((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).byCandle((CandleBlock) candle)));
        Utils.CANDLES.forEach(candle -> tag(BlockTags.CANDLE_CAKES).add(((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).byCandle((CandleBlock) candle)));
        Utils.CANDLES.forEach(candle -> tag(BlockTags.CANDLE_CAKES).add(((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).byCandle((CandleBlock) candle)));
        tag(BlockTags.CLIMBABLE).addTags(ModTags.VanillaBoomTags.Blocks.LADDERS);
        tag(BlockTags.CROPS)
                .add(ModBlocks.TOMATO.get())
                .add(ModBlocks.CHILI.get())
                .add(ModBlocks.RICE.get());
        tag(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.OBSIDIAN_BRICKS.get())
                .add(ModBlocks.OBSIDIAN_PILLAR.get())
                .add(ModBlocks.CHISELED_OBSIDIAN.get())
                .add(ModBlocks.OBSIDIAN_STAIRS.get())
                .add(ModBlocks.OBSIDIAN_SLAB.get())
                .add(ModBlocks.OBSIDIAN_WALL.get())
                .add(ModBlocks.OBSIDIAN_BRICK_STAIRS.get())
                .add(ModBlocks.OBSIDIAN_BRICK_SLAB.get())
                .add(ModBlocks.OBSIDIAN_BRICK_WALL.get())
                .add(ModBlocks.BEDROCK_STAIRS.get())
                .add(ModBlocks.BEDROCK_SLAB.get())
                .add(ModBlocks.BEDROCK_WALL.get());
        tag(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_ROSE.get())
                .add(ModBlocks.POTTED_PEONY.get())
                .add(ModBlocks.POTTED_LILAC.get());
        tag(BlockTags.IMPERMEABLE)
                .add(ModBlocks.SOUL_GLASS.get())
                .add(ModBlocks.WHITE_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.LIME_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.PINK_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.GRAY_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.CYAN_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.BLUE_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.BROWN_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.GREEN_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.RED_STAINED_SOUL_GLASS.get())
                .add(ModBlocks.BLACK_STAINED_SOUL_GLASS.get());
        tag(BlockTags.INFINIBURN_OVERWORLD)
                .add(ModBlocks.MAGMA_BRICKS.get())
                .add(ModBlocks.INFERNAL_ROCK.get())
                .add(ModBlocks.POLISHED_NETHERRACK.get())
                .add(ModBlocks.NETHERRACK_PILLAR.get());
        tag(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.ROSE.get())
                .add(ModBlocks.PEONY.get())
                .add(ModBlocks.LILAC.get());
        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModBlocks.BONE_SAND.get())
                .add(ModBlocks.WITHER_BONE_SAND.get());
        tag(BlockTags.STONE_ORE_REPLACEABLES).add(ModBlocks.PERIDOTITE.get());

        //Stairs
        ModStairBlock.STAIRS.forEach(stair -> {
            Material material = stair.defaultBlockState().getMaterial();

            if (material == Material.WOOD || material == Material.NETHER_WOOD) {
                tag(ModTags.VanillaBoomTags.Blocks.WOODEN_STAIRS).add(stair);
            } else {
                tag(ModTags.VanillaBoomTags.Blocks.STAIRS).add(stair);
            }
        });
        tag(BlockTags.STAIRS).addTags(ModTags.VanillaBoomTags.Blocks.STAIRS);
        tag(BlockTags.WOODEN_STAIRS).addTags(ModTags.VanillaBoomTags.Blocks.WOODEN_STAIRS);

        //Slabs
        ModSlabBlock.SLABS.forEach(slab -> {
            Material material = slab.defaultBlockState().getMaterial();

            if (material == Material.WOOD || material == Material.NETHER_WOOD) {
                tag(ModTags.VanillaBoomTags.Blocks.WOODEN_SLABS).add(slab);
            } else {
                tag(ModTags.VanillaBoomTags.Blocks.SLABS).add(slab);
            }
        });
        tag(BlockTags.SLABS).addTags(ModTags.VanillaBoomTags.Blocks.SLABS);
        tag(BlockTags.WOODEN_SLABS).addTags(ModTags.VanillaBoomTags.Blocks.WOODEN_SLABS);

        //Walls
        ModWallBlock.WALLS.forEach(wall -> tag(ModTags.VanillaBoomTags.Blocks.WALLS).add(wall));
        tag(BlockTags.WALLS).addTags(ModTags.VanillaBoomTags.Blocks.WALLS);

        //Fences
        ModFenceBlock.FENCES.forEach(fence -> {
            Material material = fence.defaultBlockState().getMaterial();

            if (material == Material.WOOD || material == Material.NETHER_WOOD) {
                tag(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCES).add(fence);
            } else {
                tag(ModTags.VanillaBoomTags.Blocks.FENCES).add(fence);
            }
        });
        tag(BlockTags.FENCES).addTags(ModTags.VanillaBoomTags.Blocks.FENCES);
        tag(BlockTags.WOODEN_FENCES).addTags(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCES);

        //Fence Gates
        ModFenceGateBlock.FENCE_GATES.forEach(fenceGate -> {
            Material material = fenceGate.defaultBlockState().getMaterial();

            if (material == Material.WOOD || material == Material.NETHER_WOOD) {
                tag(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCE_GATES).add(fenceGate);
            } else {
                tag(ModTags.VanillaBoomTags.Blocks.FENCE_GATES).add(fenceGate);
            }
        });
        tag(BlockTags.FENCE_GATES).addTags(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCE_GATES);
    }
}
