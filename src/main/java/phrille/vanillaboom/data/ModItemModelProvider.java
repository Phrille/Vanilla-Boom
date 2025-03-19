/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.variant.*;
import phrille.vanillaboom.item.ModItems;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ModItems.MAGMA_BRICK.get());
        item(ModItems.WITHER_BONE.get());
        item(ModItems.WITHER_BONE_MEAL.get());
        item(ModItems.PRISMARINE_ARROW.get());
        item(ModItems.POLAR_BEAR_FUR.get());
        item(ModItems.TOMATO_SEEDS.get());
        item(ModItems.CHILI_SEEDS.get());
        item(ModItems.RICE_GRAINS.get());
        item(ModItems.PINE_CONE.get());
        item(ModItems.TOMATO.get());
        item(ModItems.CHILI.get());
        item(ModItems.FRIED_EGG.get());
        item(ModItems.DROWNED_FLESH.get());
        item(ModItems.MELON_POPSICLE.get());
        item(ModItems.CHOCOLATE.get());
        item(ModItems.CHOCOLATE_CAKE.get());
        item(ModItems.BERRY_CAKE.get());
        item(ModItems.CARROT_CAKE.get());
        item(ModItems.APPLE_PIE.get());
        item(ModItems.BERRY_PIE.get());
        item(ModItems.MONSTER_PIE.get());
        item(ModItems.RAW_POLAR_BEAR_MEAT.get());
        item(ModItems.POLAR_BEAR_STEAK.get());
        item(ModItems.POTATO_SOUP.get());
        item(ModItems.MEAT_SOUP.get());
        item(ModItems.FISH_SOUP.get());
        item(ModItems.RICE_BOWL.get());
        item(ModItems.TUNA.get());
        item(ModItems.COOKED_TUNA.get());
        item(ModItems.PERCH.get());
        item(ModItems.COOKED_PERCH.get());
        item(ModItems.PIKE.get());
        item(ModItems.COOKED_PIKE.get());
        item(ModItems.EEL.get());
        item(ModItems.COOKED_EEL.get());
        item(ModItems.TUNA_BUCKET.get());
        item(ModItems.PERCH_BUCKET.get());
        item(ModItems.PIKE_BUCKET.get());
        item(ModItems.EEL_BUCKET.get());
        spawnEggItem(ModItems.TUNA_SPAWN_EGG.get());
        spawnEggItem(ModItems.PERCH_SPAWN_EGG.get());
        spawnEggItem(ModItems.PIKE_SPAWN_EGG.get());
        spawnEggItem(ModItems.EEL_SPAWN_EGG.get());
        item(ModItems.CANVAS.get(), "generated").texture("layer0", itemTexture(Items.FLOWER_BANNER_PATTERN));

        // Bricks
        blockItem(ModItems.COBBLESTONE_BRICKS.get());
        blockItem(ModItems.MOSSY_COBBLESTONE_BRICKS.get());
        blockItem(ModItems.MAGMA_BRICKS.get());
        blockItem(ModItems.OBSIDIAN_BRICKS.get());
        blockItem(ModItems.SNOW_BRICKS.get());
        blockItem(ModItems.TERRACOTTA_BRICKS.get());
        blockItem(ModItems.WHITE_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.ORANGE_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.MAGENTA_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.YELLOW_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.LIME_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.PINK_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.GRAY_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.CYAN_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.PURPLE_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.BLUE_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.BROWN_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.GREEN_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.RED_TERRACOTTA_BRICKS.get());
        blockItem(ModItems.BLACK_TERRACOTTA_BRICKS.get());

        // Rocks
        blockItem(ModItems.PERIDOTITE.get());
        blockItem(ModItems.HYDRO_ROCK.get());
        blockItem(ModItems.INFERNAL_ROCK.get());

        // Sand and Gravel
        blockItem(ModItems.BONE_SAND.get());
        blockItem(ModItems.WITHER_BONE_SAND.get());

        // Polished
        blockItem(ModItems.POLISHED_PERIDOTITE.get());
        blockItem(ModItems.POLISHED_PRISMARINE.get());
        blockItem(ModItems.POLISHED_DARK_PRISMARINE.get());
        blockItem(ModItems.POLISHED_END_STONE.get());
        blockItem(ModItems.POLISHED_NETHERRACK.get());

        // Chiseled and cracked
        blockItem(ModItems.CRACKED_RED_NETHER_BRICKS.get());
        blockItem(ModItems.CHISELED_RED_NETHER_BRICKS.get());
        blockItem(ModItems.CHISELED_PURPUR_BLOCK.get());
        blockItem(ModItems.CHISELED_OBSIDIAN.get());

        // Pillars
        blockItem(ModItems.GRANITE_PILLAR.get());
        blockItem(ModItems.DIORITE_PILLAR.get());
        blockItem(ModItems.ANDESITE_PILLAR.get());
        blockItem(ModItems.PERIDOTITE_PILLAR.get());
        blockItem(ModItems.PRISMARINE_PILLAR.get());
        blockItem(ModItems.DARK_PRISMARINE_PILLAR.get());
        blockItem(ModItems.END_STONE_PILLAR.get());
        blockItem(ModItems.NETHERRACK_PILLAR.get());
        blockItem(ModItems.OBSIDIAN_PILLAR.get());

        // Storage Blocks
        blockItem(ModItems.CHARCOAL_BLOCK.get());
        blockItem(ModItems.SUGAR_BLOCK.get());
        blockItem(ModItems.SUGAR_CANE_BLOCK.get());
        blockItem(ModItems.GUNPOWDER_BLOCK.get());
        blockItem(ModItems.BLAZE_POWDER_BLOCK.get());
        blockItem(ModItems.MAGMA_CREAM_BLOCK.get());
        blockItem(ModItems.PRISMARINE_CRYSTAL_BLOCK.get());
        blockItem(ModItems.WITHER_BONE_BLOCK.get());
        blockItem(ModItems.WHITE_DYE_BLOCK.get());
        blockItem(ModItems.ORANGE_DYE_BLOCK.get());
        blockItem(ModItems.MAGENTA_DYE_BLOCK.get());
        blockItem(ModItems.LIGHT_BLUE_DYE_BLOCK.get());
        blockItem(ModItems.YELLOW_DYE_BLOCK.get());
        blockItem(ModItems.LIME_DYE_BLOCK.get());
        blockItem(ModItems.PINK_DYE_BLOCK.get());
        blockItem(ModItems.GRAY_DYE_BLOCK.get());
        blockItem(ModItems.LIGHT_GRAY_DYE_BLOCK.get());
        blockItem(ModItems.CYAN_DYE_BLOCK.get());
        blockItem(ModItems.PURPLE_DYE_BLOCK.get());
        blockItem(ModItems.BLUE_DYE_BLOCK.get());
        blockItem(ModItems.BROWN_DYE_BLOCK.get());
        blockItem(ModItems.GREEN_DYE_BLOCK.get());
        blockItem(ModItems.RED_DYE_BLOCK.get());
        blockItem(ModItems.BLACK_DYE_BLOCK.get());

        // Glass
        blockItem(ModItems.SOUL_GLASS.get());
        blockItem(ModItems.WHITE_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.ORANGE_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.MAGENTA_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.YELLOW_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.LIME_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.PINK_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.GRAY_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.CYAN_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.PURPLE_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.BLUE_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.BROWN_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.GREEN_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.RED_STAINED_SOUL_GLASS.get());
        blockItem(ModItems.BLACK_STAINED_SOUL_GLASS.get());

        glassPaneItem(ModBlocks.SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get());
        glassPaneItem(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get());

        // Misc
        blockItem(ModItems.EASEL.get());
        blockItem(ModItems.RAIN_DETECTOR.get());
        item(ModBlocks.GOLD_BARS.get());
        item(ModBlocks.ROSE.get());
        item(ModBlocks.SHEARED_ROSE_BUSH.get().asItem(), "generated")
                .texture("layer0", ModDataGenerator.extend(blockTexture(ModBlocks.SHEARED_ROSE_BUSH.get()), "_top"));
        item(ModBlocks.PEONY.get());
        item(ModBlocks.SHEARED_PEONY.get().asItem(), "generated")
                .texture("layer0", ModDataGenerator.extend(blockTexture(ModBlocks.SHEARED_PEONY.get()), "_top"));
        item(ModBlocks.LILAC.get());
        item(ModBlocks.SHEARED_LILAC.get().asItem(), "generated")
                .texture("layer0", ModDataGenerator.extend(blockTexture(ModBlocks.SHEARED_LILAC.get()), "_top"));
        item(ModBlocks.TRELLIS.get());
        item(ModBlocks.WITHERED_VINE.get());

        // Variant Blocks
        ModBookshelfBlock.BOOKSHELVES.forEach(bookshelf -> blockItem(bookshelf.asItem()));
        ModLadderBlock.LADDERS.forEach(this::item);
        ModStairBlock.STAIRS.forEach(stair -> blockItem(stair.asItem()));
        ModSlabBlock.SLABS.forEach(slab -> blockItem(slab.asItem()));
        ModWallBlock.WALLS.forEach(this::inventoryBlockItem);
        ModFenceBlock.FENCES.forEach(this::inventoryBlockItem);
        ModFenceGateBlock.FENCE_GATES.forEach(fenceGate -> blockItem(fenceGate.asItem()));
    }

    public void item(Item item) {
        item(item, "generated").texture("layer0", itemTexture(item));
    }

    public void item(Block block) {
        item(block.asItem(), "generated").texture("layer0", blockTexture(block));
    }

    public void blockItem(Item blockItem) {
        ResourceLocation parent = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(blockItem));
        withExistingParent(name(blockItem), new ResourceLocation(parent.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + parent.getPath()));
    }

    public void inventoryBlockItem(Block block) {
        ResourceLocation parent = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block));
        withExistingParent(name(block.asItem()), new ResourceLocation(parent.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + parent.getPath() + "_inventory"));
    }

    public void glassPaneItem(Block block) {
        item(block.asItem(), "generated").texture("layer0", blockTexture(block)).renderType(ModBlockStateProvider.RENDER_TYPE_TRANSLUCENT);
    }

    public void spawnEggItem(Item item) {
        item(item, "template_spawn_egg");
    }

    protected ItemModelBuilder item(Item item, String parent) {
        return withExistingParent(name(item), ModelProvider.ITEM_FOLDER + "/" + parent);
    }

    protected ResourceLocation itemTexture(Item item) {
        ResourceLocation name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        return new ResourceLocation(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }

    protected ResourceLocation blockTexture(Block block) {
        ResourceLocation name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block));
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath().replace("_pane", ""));
    }

    protected String name(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }
}
