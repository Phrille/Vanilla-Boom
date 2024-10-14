package phrille.vanillaboom.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        /*
         * Forge tags
         */
        copy(ModTags.ForgeTags.Blocks.BOOKSHELVES, Tags.Items.BOOKSHELVES);
        copy(ModTags.ForgeTags.Blocks.CAKES, ModTags.ForgeTags.Items.CAKES);
        copy(ModTags.ForgeTags.Blocks.LADDERS, ModTags.ForgeTags.Items.LADDERS);
        copy(Tags.Blocks.FENCES_WOODEN, Tags.Items.FENCES_WOODEN);
        copy(Tags.Blocks.FENCES_NETHER_BRICK, Tags.Items.FENCES_NETHER_BRICK);
        copy(ModTags.ForgeTags.Blocks.FENCE_GATES_NETHER_BRICK, ModTags.ForgeTags.Items.FENCE_GATES_NETHER_BRICK);
        copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        copy(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_CHARCOAL, ModTags.ForgeTags.Items.STORAGE_BLOCKS_CHARCOAL);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_SUGAR, ModTags.ForgeTags.Items.STORAGE_BLOCKS_SUGAR);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_SUGAR_CANE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GUNPOWDER, ModTags.ForgeTags.Items.STORAGE_BLOCKS_GUNPOWDER);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLAZE_POWDER, ModTags.ForgeTags.Items.STORAGE_BLOCKS_BLAZE_POWDER);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_MAGMA_CREAM, ModTags.ForgeTags.Items.STORAGE_BLOCKS_MAGMA_CREAM);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PRISMARINE_CRYSTAL, ModTags.ForgeTags.Items.STORAGE_BLOCKS_PRISMARINE_CRYSTAL);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_WITHER_BONE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_WITHER_BONE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_WHITE_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_WHITE_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_ORANGE_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_ORANGE_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_MAGENTA_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_MAGENTA_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIGHT_BLUE_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_LIGHT_BLUE_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_YELLOW_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_YELLOW_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIME_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_LIME_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PINK_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_PINK_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GRAY_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_GRAY_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_LIGHT_GRAY_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_LIGHT_GRAY_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_CYAN_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_CYAN_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_PURPLE_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_PURPLE_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLUE_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_BLUE_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BROWN_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_BROWN_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_GREEN_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_GREEN_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_RED_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_RED_DYE);
        copy(ModTags.ForgeTags.Blocks.STORAGE_BLOCKS_BLACK_DYE, ModTags.ForgeTags.Items.STORAGE_BLOCKS_BLACK_DYE);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        tag(ModTags.ForgeTags.Items.CROPS_TOMATO).add(ModItems.TOMATO.get());
        tag(ModTags.ForgeTags.Items.CROPS_RICE).add(ModItems.RICE_BOWL.get());
        tag(Tags.Items.CROPS)
                .addTags(ModTags.ForgeTags.Items.CROPS_TOMATO)
                .addTags(ModTags.ForgeTags.Items.CROPS_RICE);
        tag(ModTags.ForgeTags.Items.SEEDS_TOMATO).add(ModItems.TOMATO_SEEDS.get());
        tag(ModTags.ForgeTags.Items.SEEDS_RICE).add(ModItems.RICE_SEEDS.get());
        tag(Tags.Items.SEEDS)
                .addTags(ModTags.ForgeTags.Items.SEEDS_TOMATO)
                .addTags(ModTags.ForgeTags.Items.SEEDS_RICE);
        tag(ModTags.ForgeTags.Items.INGOTS_MAGMA_BRICK).add(ModItems.MAGMA_BRICK.get());
        tag(Tags.Items.INGOTS).addTags(ModTags.ForgeTags.Items.INGOTS_MAGMA_BRICK);
        tag(ModTags.ForgeTags.Items.WITHER_BONES).add(ModItems.WITHER_BONE.get());
        tag(ModTags.ForgeTags.Items.WITHER_BONE_MEALS).add(ModItems.WITHER_BONE_MEAL.get());
        tag(ModTags.ForgeTags.Items.RAW_FISHES)
                .add(Items.COD)
                .add(Items.SALMON)
                .add(Items.PUFFERFISH)
                .add(Items.TROPICAL_FISH)
                .addTags(ModTags.VanillaBoomTags.Items.RAW_FISHES);
        tag(ModTags.ForgeTags.Items.COOKED_FISHES)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
                .addTags(ModTags.VanillaBoomTags.Items.COOKED_FISHES);
        tag(ModTags.ForgeTags.Items.RAW_MEATS)
                .add(Items.PORKCHOP)
                .add(Items.BEEF)
                .add(Items.CHICKEN)
                .add(Items.MUTTON)
                .add(Items.RABBIT)
                .add(ModItems.RAW_POLAR_BEAR_MEAT.get());
        tag(ModTags.ForgeTags.Items.COOKED_MEATS)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_CHICKEN)
                .add(Items.COOKED_MUTTON)
                .add(Items.COOKED_RABBIT)
                .add(ModItems.POLAR_BEAR_STEAK.get());
        tag(ModTags.ForgeTags.Items.CANVAS).add(ModItems.CANVAS.get());
        tag(ModTags.ForgeTags.Items.MILK).add(Items.MILK_BUCKET);

        /*
         * VanillaBoom tags
         */
        copy(ModTags.VanillaBoomTags.Blocks.BRICKS, ModTags.VanillaBoomTags.Items.BRICKS);
        copy(ModTags.VanillaBoomTags.Blocks.POLISHED, ModTags.VanillaBoomTags.Items.POLISHED);
        copy(ModTags.VanillaBoomTags.Blocks.PILLARS, ModTags.VanillaBoomTags.Items.PILLARS);
        copy(ModTags.VanillaBoomTags.Blocks.BOOKSHELVES, ModTags.VanillaBoomTags.Items.BOOKSHELVES);
        copy(ModTags.VanillaBoomTags.Blocks.DYE_BLOCKS, ModTags.VanillaBoomTags.Items.DYE_BLOCKS);
        copy(ModTags.VanillaBoomTags.Blocks.LADDERS, ModTags.VanillaBoomTags.Items.LADDERS);
        copy(ModTags.VanillaBoomTags.Blocks.STAIRS, ModTags.VanillaBoomTags.Items.STAIRS);
        copy(ModTags.VanillaBoomTags.Blocks.SLABS, ModTags.VanillaBoomTags.Items.SLABS);
        copy(ModTags.VanillaBoomTags.Blocks.WALLS, ModTags.VanillaBoomTags.Items.WALLS);
        copy(ModTags.VanillaBoomTags.Blocks.FENCES, ModTags.VanillaBoomTags.Items.FENCES);
        copy(ModTags.VanillaBoomTags.Blocks.FENCE_GATES, ModTags.VanillaBoomTags.Items.FENCE_GATES);
        copy(ModTags.VanillaBoomTags.Blocks.WOODEN_STAIRS, ModTags.VanillaBoomTags.Items.WOODEN_STAIRS);
        copy(ModTags.VanillaBoomTags.Blocks.WOODEN_SLABS, ModTags.VanillaBoomTags.Items.WOODEN_SLABS);
        copy(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCES, ModTags.VanillaBoomTags.Items.WOODEN_FENCES);
        copy(ModTags.VanillaBoomTags.Blocks.WOODEN_FENCE_GATES, ModTags.VanillaBoomTags.Items.WOODEN_FENCE_GATES);
        tag(ModTags.VanillaBoomTags.Items.RAW_FISHES)
                .add(ModItems.TUNA.get())
                .add(ModItems.PERCH.get())
                .add(ModItems.PIKE.get())
                .add(ModItems.EEL.get());
        tag(ModTags.VanillaBoomTags.Items.COOKED_FISHES)
                .add(ModItems.COOKED_TUNA.get())
                .add(ModItems.COOKED_PERCH.get())
                .add(ModItems.COOKED_PIKE.get())
                .add(ModItems.COOKED_EEL.get());
        tag(ModTags.VanillaBoomTags.Items.POTATO_SOUP_INGREDIENTS)
                .add(Items.POISONOUS_POTATO)
                .addTags(Tags.Items.CROPS_POTATO);

        /*
         * Vanilla tags
         */
        copy(BlockTags.FENCES, ItemTags.FENCES);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        copy(BlockTags.SOUL_FIRE_BASE_BLOCKS, ItemTags.SOUL_FIRE_BASE_BLOCKS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        tag(ItemTags.ARROWS).add(ModItems.PRISMARINE_ARROW.get());
        tag(ItemTags.FISHES)
                .addTags(ModTags.VanillaBoomTags.Items.RAW_FISHES)
                .addTags(ModTags.VanillaBoomTags.Items.COOKED_FISHES);
        tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.GOLD_BARS.get())
                .add(ModItems.GOLD_BLOCK_STAIRS.get())
                .add(ModItems.GOLD_BLOCK_SLAB.get())
                .add(ModItems.GOLD_BLOCK_WALL.get());
    }
}
