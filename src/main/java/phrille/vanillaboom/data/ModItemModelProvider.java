package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ModItems.MAGMA_BRICK.get());
        item(ModItems.WITHER_BONE.get());
        item(ModItems.WITHER_BONE_MEAL.get());
        item(ModItems.PRISMARINE_ARROW.get());
        item(ModItems.POLAR_BEAR_FUR.get());
        item(ModItems.TOMATO_SEEDS.get());
        item(ModItems.RICE_SEEDS.get());
        item(ModItems.PINE_CONE.get());
        item(ModItems.PUMPKIN_SLICE.get());
        item(ModItems.TOMATO.get());
        item(ModItems.COOKED_EGG.get());
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
        item(ModItems.CANVAS.get());
        item(ModItems.KEBAB_PAINTING.get());
        item(ModItems.AZTEC_PAINTING.get());
        item(ModItems.ALBAN_PAINTING.get());
        item(ModItems.AZTEC2_PAINTING.get());
        item(ModItems.BOMB_PAINTING.get());
        item(ModItems.PLANT_PAINTING.get());
        item(ModItems.WASTELAND_PAINTING.get());
        item(ModItems.POOL_PAINTING.get());
        item(ModItems.COURBET_PAINTING.get());
        item(ModItems.SEA_PAINTING.get());
        item(ModItems.SUNSET_PAINTING.get());
        item(ModItems.CREEBET_PAINTING.get());
        item(ModItems.WANDERER_PAINTING.get());
        item(ModItems.GRAHAM_PAINTING.get());
        item(ModItems.MATCH_PAINTING.get());
        item(ModItems.BUST_PAINTING.get());
        item(ModItems.STAGE_PAINTING.get());
        item(ModItems.VOID_PAINTING.get());
        item(ModItems.SKULL_AND_ROSES_PAINTING.get());
        item(ModItems.WITHER_PAINTING.get());
        item(ModItems.FIGHTERS_PAINTING.get());
        item(ModItems.POINTER_PAINTING.get());
        item(ModItems.PIGSCENE_PAINTING.get());
        item(ModItems.BURNING_SKULL_PAINTING.get());
        item(ModItems.SKELETON_PAINTING.get());
        item(ModItems.DONKEY_KONG_PAINTING.get());

        //Bricks
        blockItem(ModBlocks.COBBLESTONE_BRICKS.get());
        blockItem(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        blockItem(ModBlocks.MAGMA_BRICKS.get());
        blockItem(ModBlocks.OBSIDIAN_BRICKS.get());
        blockItem(ModBlocks.SNOW_BRICKS.get());
        blockItem(ModBlocks.TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.WHITE_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.LIME_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.PINK_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.GRAY_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.CYAN_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.BLUE_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.BROWN_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.GREEN_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.RED_TERRACOTTA_BRICKS.get());
        blockItem(ModBlocks.BLACK_TERRACOTTA_BRICKS.get());

        //Rocks
        blockItem(ModBlocks.PERIDOTITE.get());
        blockItem(ModBlocks.HYDRO_ROCK.get());
        blockItem(ModBlocks.INFERNAL_ROCK.get());

        //Sand and Gravel
        blockItem(ModBlocks.BONE_SAND.get());
        blockItem(ModBlocks.WITHER_BONE_SAND.get());

        //Polished
        blockItem(ModBlocks.POLISHED_PERIDOTITE.get());
        blockItem(ModBlocks.POLISHED_PRISMARINE.get());
        blockItem(ModBlocks.POLISHED_DARK_PRISMARINE.get());
        blockItem(ModBlocks.POLISHED_END_STONE.get());
        blockItem(ModBlocks.POLISHED_NETHERRACK.get());

        //Chiseled and cracked
        blockItem(ModBlocks.CRACKED_RED_NETHER_BRICKS.get());
        blockItem(ModBlocks.CHISELED_RED_NETHER_BRICKS.get());
        blockItem(ModBlocks.CHISELED_PURPUR_BLOCK.get());
        blockItem(ModBlocks.CHISELED_OBSIDIAN.get());

        //Pillars
        blockItem(ModBlocks.GRANITE_PILLAR.get());
        blockItem(ModBlocks.DIORITE_PILLAR.get());
        blockItem(ModBlocks.ANDESITE_PILLAR.get());
        blockItem(ModBlocks.PERIDOTITE_PILLAR.get());
        blockItem(ModBlocks.PRISMARINE_PILLAR.get());
        blockItem(ModBlocks.DARK_PRISMARINE_PILLAR.get());
        blockItem(ModBlocks.END_STONE_PILLAR.get());
        blockItem(ModBlocks.NETHERRACK_PILLAR.get());
        blockItem(ModBlocks.RED_NETHER_PILLAR.get());
        blockItem(ModBlocks.OBSIDIAN_PILLAR.get());

        //Wood Variations
        blockItem(ModBlocks.SPRUCE_BOOKSHELF.get());
        blockItem(ModBlocks.BIRCH_BOOKSHELF.get());
        blockItem(ModBlocks.JUNGLE_BOOKSHELF.get());
        blockItem(ModBlocks.ACACIA_BOOKSHELF.get());
        blockItem(ModBlocks.DARK_OAK_BOOKSHELF.get());
        blockItem(ModBlocks.CRIMSON_BOOKSHELF.get());
        blockItem(ModBlocks.WARPED_BOOKSHELF.get());
        item(ModBlocks.SPRUCE_LADDER.get());
        item(ModBlocks.BIRCH_LADDER.get());
        item(ModBlocks.JUNGLE_LADDER.get());
        item(ModBlocks.ACACIA_LADDER.get());
        item(ModBlocks.DARK_OAK_LADDER.get());
        item(ModBlocks.CRIMSON_LADDER.get());
        item(ModBlocks.WARPED_LADDER.get());

        //Storage Blocks
        blockItem(ModBlocks.CHARCOAL_BLOCK.get());
        blockItem(ModBlocks.SUGAR_BLOCK.get());
        blockItem(ModBlocks.SUGAR_CANE_BLOCK.get());
        blockItem(ModBlocks.BAMBOO_BLOCK.get());
        blockItem(ModBlocks.GUNPOWDER_BLOCK.get());
        blockItem(ModBlocks.BLAZE_POWDER_BLOCK.get());
        blockItem(ModBlocks.MAGMA_CREAM_BLOCK.get());
        blockItem(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        blockItem(ModBlocks.WITHER_BONE_BLOCK.get());
        blockItem(ModBlocks.WHITE_DYE_BLOCK.get());
        blockItem(ModBlocks.ORANGE_DYE_BLOCK.get());
        blockItem(ModBlocks.MAGENTA_DYE_BLOCK.get());
        blockItem(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get());
        blockItem(ModBlocks.YELLOW_DYE_BLOCK.get());
        blockItem(ModBlocks.LIME_DYE_BLOCK.get());
        blockItem(ModBlocks.PINK_DYE_BLOCK.get());
        blockItem(ModBlocks.GRAY_DYE_BLOCK.get());
        blockItem(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get());
        blockItem(ModBlocks.CYAN_DYE_BLOCK.get());
        blockItem(ModBlocks.PURPLE_DYE_BLOCK.get());
        blockItem(ModBlocks.BLUE_DYE_BLOCK.get());
        blockItem(ModBlocks.BROWN_DYE_BLOCK.get());
        blockItem(ModBlocks.GREEN_DYE_BLOCK.get());
        blockItem(ModBlocks.RED_DYE_BLOCK.get());
        blockItem(ModBlocks.BLACK_DYE_BLOCK.get());

        //Glass
        blockItem(ModBlocks.SOUL_GLASS.get());
        blockItem(ModBlocks.WHITE_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.LIME_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.PINK_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.GRAY_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.CYAN_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.BLUE_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.BROWN_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.GREEN_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.RED_STAINED_SOUL_GLASS.get());
        blockItem(ModBlocks.BLACK_STAINED_SOUL_GLASS.get());

        item(ModBlocks.SOUL_GLASS_PANE.get());
        item(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get());
        item(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get());

        //Misc
        blockItem(ModBlocks.RAIN_DETECTOR.get());
        item(ModBlocks.GOLD_BARS.get());
        item(ModBlocks.ROSE.get());

        //Stairs
        blockItem(ModBlocks.COBBLESTONE_BRICK_STAIRS.get());
        blockItem(ModBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get());
        blockItem(ModBlocks.MAGMA_BRICK_STAIRS.get());
        blockItem(ModBlocks.OBSIDIAN_BRICK_STAIRS.get());
        blockItem(ModBlocks.SNOW_BRICK_STAIRS.get());
        blockItem(ModBlocks.TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get());
        blockItem(ModBlocks.PERIDOTITE_STAIRS.get());
        blockItem(ModBlocks.HYDRO_ROCK_STAIRS.get());
        blockItem(ModBlocks.INFERNAL_ROCK_STAIRS.get());
        blockItem(ModBlocks.POLISHED_PERIDOTITE_STAIRS.get());
        blockItem(ModBlocks.POLISHED_PRISMARINE_STAIRS.get());
        blockItem(ModBlocks.POLISHED_DARK_PRISMARINE_STAIRS.get());
        blockItem(ModBlocks.POLISHED_END_STONE_STAIRS.get());
        blockItem(ModBlocks.POLISHED_NETHERRACK_STAIRS.get());
        blockItem(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get());
        blockItem(ModBlocks.CHISELED_RED_NETHER_BRICK_STAIRS.get());
        blockItem(ModBlocks.CHISELED_PURPUR_BLOCK_STAIRS.get());
        blockItem(ModBlocks.CHISELED_OBSIDIAN_STAIRS.get());


        //Vanilla Stairs
        blockItem(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get());
        blockItem(ModBlocks.CHISELED_STONE_BRICK_STAIRS.get());
        blockItem(ModBlocks.CHISELED_SANDSTONE_STAIRS.get());
        blockItem(ModBlocks.CHISELED_RED_SANDSTONE_STAIRS.get());
        blockItem(ModBlocks.IRON_BLOCK_STAIRS.get());
        blockItem(ModBlocks.GOLD_BLOCK_STAIRS.get());
        blockItem(ModBlocks.OBSIDIAN_STAIRS.get());
        blockItem(ModBlocks.BEDROCK_STAIRS.get());
        blockItem(ModBlocks.NETHERRACK_STAIRS.get());
        blockItem(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get());
        blockItem(ModBlocks.CHISELED_NETHER_BRICK_STAIRS.get());
        blockItem(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
        blockItem(ModBlocks.CHISELED_POLISHED_BLACKSTONE_STAIRS.get());
        blockItem(ModBlocks.END_STONE_STAIRS.get());
        blockItem(ModBlocks.CHISELED_QUARTZ_BLOCK_STAIRS.get());
        blockItem(ModBlocks.QUARTZ_BRICK_STAIRS.get());
        blockItem(ModBlocks.TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.WHITE_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.LIME_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.PINK_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.GRAY_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.CYAN_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.BLUE_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.BROWN_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.GREEN_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.RED_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.BLACK_TERRACOTTA_STAIRS.get());
        blockItem(ModBlocks.WHITE_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.ORANGE_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.YELLOW_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.LIME_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.PINK_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.GRAY_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.CYAN_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.PURPLE_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.BLUE_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.BROWN_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.GREEN_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.RED_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.BLACK_CONCRETE_STAIRS.get());
        blockItem(ModBlocks.OAK_WOOD_STAIRS.get());
        blockItem(ModBlocks.SPRUCE_WOOD_STAIRS.get());
        blockItem(ModBlocks.BIRCH_WOOD_STAIRS.get());
        blockItem(ModBlocks.JUNGLE_WOOD_STAIRS.get());
        blockItem(ModBlocks.ACACIA_WOOD_STAIRS.get());
        blockItem(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
        blockItem(ModBlocks.CRIMSON_HYPHAE_STAIRS.get());
        blockItem(ModBlocks.WARPED_HYPHAE_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_STAIRS.get());
        blockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_STAIRS.get());
        blockItem(ModBlocks.CUT_SANDSTONE_STAIRS.get());
        blockItem(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get());
        blockItem(ModBlocks.SMOOTH_STONE_STAIRS.get());

        //Slabs
        blockItem(ModBlocks.COBBLESTONE_BRICK_SLAB.get());
        blockItem(ModBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get());
        blockItem(ModBlocks.MAGMA_BRICK_SLAB.get());
        blockItem(ModBlocks.OBSIDIAN_BRICK_SLAB.get());
        blockItem(ModBlocks.SNOW_BRICK_SLAB.get());
        blockItem(ModBlocks.TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get());
        blockItem(ModBlocks.PERIDOTITE_SLAB.get());
        blockItem(ModBlocks.HYDRO_ROCK_SLAB.get());
        blockItem(ModBlocks.INFERNAL_ROCK_SLAB.get());
        blockItem(ModBlocks.POLISHED_PERIDOTITE_SLAB.get());
        blockItem(ModBlocks.POLISHED_PRISMARINE_SLAB.get());
        blockItem(ModBlocks.POLISHED_DARK_PRISMARINE_SLAB.get());
        blockItem(ModBlocks.POLISHED_END_STONE_SLAB.get());
        blockItem(ModBlocks.POLISHED_NETHERRACK_SLAB.get());
        blockItem(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get());
        blockItem(ModBlocks.CHISELED_RED_NETHER_BRICK_SLAB.get());
        blockItem(ModBlocks.CHISELED_PURPUR_BLOCK_SLAB.get());
        blockItem(ModBlocks.CHISELED_OBSIDIAN_SLAB.get());

        //Vanilla Slabs
        blockItem(ModBlocks.CRACKED_STONE_BRICK_SLAB.get());
        blockItem(ModBlocks.CHISELED_STONE_BRICK_SLAB.get());
        blockItem(ModBlocks.CHISELED_SANDSTONE_SLAB.get());
        blockItem(ModBlocks.CHISELED_RED_SANDSTONE_SLAB.get());
        blockItem(ModBlocks.IRON_BLOCK_SLAB.get());
        blockItem(ModBlocks.GOLD_BLOCK_SLAB.get());
        blockItem(ModBlocks.OBSIDIAN_SLAB.get());
        blockItem(ModBlocks.BEDROCK_SLAB.get());
        blockItem(ModBlocks.NETHERRACK_SLAB.get());
        blockItem(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get());
        blockItem(ModBlocks.CHISELED_NETHER_BRICK_SLAB.get());
        blockItem(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get());
        blockItem(ModBlocks.CHISELED_POLISHED_BLACKSTONE_SLAB.get());
        blockItem(ModBlocks.END_STONE_SLAB.get());
        blockItem(ModBlocks.CHISELED_QUARTZ_BLOCK_SLAB.get());
        blockItem(ModBlocks.QUARTZ_BRICK_SLAB.get());
        blockItem(ModBlocks.TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.WHITE_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.ORANGE_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.YELLOW_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.LIME_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.PINK_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.GRAY_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.CYAN_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.PURPLE_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.BLUE_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.BROWN_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.GREEN_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.RED_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.BLACK_TERRACOTTA_SLAB.get());
        blockItem(ModBlocks.WHITE_CONCRETE_SLAB.get());
        blockItem(ModBlocks.ORANGE_CONCRETE_SLAB.get());
        blockItem(ModBlocks.MAGENTA_CONCRETE_SLAB.get());
        blockItem(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());
        blockItem(ModBlocks.YELLOW_CONCRETE_SLAB.get());
        blockItem(ModBlocks.LIME_CONCRETE_SLAB.get());
        blockItem(ModBlocks.PINK_CONCRETE_SLAB.get());
        blockItem(ModBlocks.GRAY_CONCRETE_SLAB.get());
        blockItem(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());
        blockItem(ModBlocks.CYAN_CONCRETE_SLAB.get());
        blockItem(ModBlocks.PURPLE_CONCRETE_SLAB.get());
        blockItem(ModBlocks.BLUE_CONCRETE_SLAB.get());
        blockItem(ModBlocks.BROWN_CONCRETE_SLAB.get());
        blockItem(ModBlocks.GREEN_CONCRETE_SLAB.get());
        blockItem(ModBlocks.RED_CONCRETE_SLAB.get());
        blockItem(ModBlocks.BLACK_CONCRETE_SLAB.get());
        blockItem(ModBlocks.OAK_WOOD_SLAB.get());
        blockItem(ModBlocks.SPRUCE_WOOD_SLAB.get());
        blockItem(ModBlocks.BIRCH_WOOD_SLAB.get());
        blockItem(ModBlocks.JUNGLE_WOOD_SLAB.get());
        blockItem(ModBlocks.ACACIA_WOOD_SLAB.get());
        blockItem(ModBlocks.DARK_OAK_WOOD_SLAB.get());
        blockItem(ModBlocks.CRIMSON_HYPHAE_SLAB.get());
        blockItem(ModBlocks.WARPED_HYPHAE_SLAB.get());
        blockItem(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get());
        blockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get());
        blockItem(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get());
        blockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get());
        blockItem(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get());
        blockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get());
        blockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_SLAB.get());
        blockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_SLAB.get());

        //VanillaBoom Walls
        inventoryBlockItem(ModBlocks.COBBLESTONE_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.MAGMA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.OBSIDIAN_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.SNOW_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.RED_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.PERIDOTITE_WALL.get());
        inventoryBlockItem(ModBlocks.HYDRO_ROCK_WALL.get());
        inventoryBlockItem(ModBlocks.INFERNAL_ROCK_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_PERIDOTITE_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_PRISMARINE_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_DARK_PRISMARINE_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_END_STONE_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_NETHERRACK_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_PURPUR_BLOCK_WALL.get());
        inventoryBlockItem(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_RED_NETHER_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_OBSIDIAN_WALL.get());

        //Vanilla Walls
        inventoryBlockItem(ModBlocks.CRACKED_STONE_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_STONE_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_SANDSTONE_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_RED_SANDSTONE_WALL.get());
        inventoryBlockItem(ModBlocks.IRON_BLOCK_WALL.get());
        inventoryBlockItem(ModBlocks.GOLD_BLOCK_WALL.get());
        inventoryBlockItem(ModBlocks.OBSIDIAN_WALL.get());
        inventoryBlockItem(ModBlocks.BEDROCK_WALL.get());
        inventoryBlockItem(ModBlocks.NETHERRACK_WALL.get());
        inventoryBlockItem(ModBlocks.CRACKED_NETHER_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_NETHER_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_POLISHED_BLACKSTONE_WALL.get());
        inventoryBlockItem(ModBlocks.END_STONE_WALL.get());
        inventoryBlockItem(ModBlocks.CHISELED_QUARTZ_BLOCK_WALL.get());
        inventoryBlockItem(ModBlocks.QUARTZ_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.WHITE_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.ORANGE_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.MAGENTA_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.YELLOW_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.LIME_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.PINK_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.GRAY_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.CYAN_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.PURPLE_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.BLUE_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.BROWN_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.GREEN_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.RED_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.BLACK_TERRACOTTA_WALL.get());
        inventoryBlockItem(ModBlocks.WHITE_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.ORANGE_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.MAGENTA_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.YELLOW_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.LIME_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.PINK_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.GRAY_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.CYAN_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.PURPLE_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.BLUE_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.BROWN_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.GREEN_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.RED_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.BLACK_CONCRETE_WALL.get());
        inventoryBlockItem(ModBlocks.CUT_SANDSTONE_WALL.get());
        inventoryBlockItem(ModBlocks.CUT_RED_SANDSTONE_WALL.get());
        inventoryBlockItem(ModBlocks.SMOOTH_STONE_WALL.get());
        inventoryBlockItem(ModBlocks.STONE_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_GRANITE_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_DIORITE_WALL.get());
        inventoryBlockItem(ModBlocks.POLISHED_ANDESITE_WALL.get());
        inventoryBlockItem(ModBlocks.SMOOTH_SANDSTONE_WALL.get());
        inventoryBlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get());
        inventoryBlockItem(ModBlocks.PURPUR_BLOCK_WALL.get());
        inventoryBlockItem(ModBlocks.QUARTZ_BLOCK_WALL.get());
        inventoryBlockItem(ModBlocks.SMOOTH_QUARTZ_WALL.get());
        inventoryBlockItem(ModBlocks.PRISMARINE_BRICK_WALL.get());
        inventoryBlockItem(ModBlocks.DARK_PRISMARINE_WALL.get());

        //Vanilla Fences
        inventoryBlockItem(ModBlocks.OAK_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.SPRUCE_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.BIRCH_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.JUNGLE_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.ACACIA_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.DARK_OAK_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.CRIMSON_HYPHAE_FENCE.get());
        inventoryBlockItem(ModBlocks.WARPED_HYPHAE_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_OAK_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE.get());
        inventoryBlockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE.get());
        inventoryBlockItem(ModBlocks.RED_NETHER_BRICK_FENCE.get());
        blockItem(ModBlocks.OAK_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.BIRCH_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.ACACIA_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get());
        blockItem(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE.get());
        blockItem(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE.get());
        blockItem(ModBlocks.NETHER_BRICK_FENCE_GATE.get());
        blockItem(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get());
    }

    public void item(Item item) {
        item(item, "generated").texture("layer0", itemTexture(item));
    }

    public void item(Block block) {
        item(block.asItem(), "generated").texture("layer0", blockTexture(block));
    }

    public void blockItem(Block block) {
        ResourceLocation parent = block.getRegistryName();
        withExistingParent(name(block.asItem()), new ResourceLocation(parent.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + parent.getPath()));
    }

    public void inventoryBlockItem(Block block) {
        ResourceLocation parent = block.getRegistryName();
        withExistingParent(name(block.asItem()), new ResourceLocation(parent.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + parent.getPath() + "_inventory"));
    }

    public void spawnEggItem(Item item) {
        item(item, "template_spawn_egg");
    }

    protected ItemModelBuilder item(Item item, String parent) {
        return withExistingParent(name(item), ModelProvider.ITEM_FOLDER + "/" + parent);
    }

    protected ResourceLocation itemTexture(Item item) {
        ResourceLocation name = item.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }

    protected ResourceLocation blockTexture(Block block) {
        ResourceLocation name = block.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath().replace("_pane", ""));
    }

    protected String name(Item item) {
        return item.getRegistryName().getPath();
    }
}
