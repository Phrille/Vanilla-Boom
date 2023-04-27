package phrille.vanillaboom.block;

import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.util.Names;
import phrille.vanillaboom.util.Utils;

import java.util.Map;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModBlocks {
    //Bricks
    public static final Block COBBLESTONE_BRICKS = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICKS = Utils._null();
    public static final Block MAGMA_BRICKS = Utils._null();
    public static final Block OBSIDIAN_BRICKS = Utils._null();
    public static final Block SNOW_BRICKS = Utils._null();
    public static final Block TERRACOTTA_BRICKS = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICKS = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICKS = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICKS = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICKS = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICKS = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICKS = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICKS = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICKS = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICKS = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICKS = Utils._null();
    public static final Block RED_TERRACOTTA_BRICKS = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICKS = Utils._null();

    //Rocks
    public static final Block PERIDOTITE = Utils._null();
    public static final Block HYDRO_ROCK = Utils._null();
    public static final Block INFERNAL_ROCK = Utils._null();

    //Sand and Gravel
    public static final Block BONE_SAND = Utils._null();
    public static final Block WITHER_BONE_SAND = Utils._null();
    public static final Block FINE_GRAVEL = Utils._null();
    public static final Block GRAVEL_STONE = Utils._null();
    public static final Block FINE_GRAVEL_STONE = Utils._null();
    public static final Block GRAVEL_BRICKS = Utils._null();

    //Polished
    public static final Block POLISHED_PERIDOTITE = Utils._null();
    public static final Block POLISHED_PRISMARINE = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE = Utils._null();
    public static final Block POLISHED_END_STONE = Utils._null();
    public static final Block POLISHED_NETHERRACK = Utils._null();

    //Chiseled and cracked
    public static final Block CRACKED_RED_NETHER_BRICKS = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICKS = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK = Utils._null();
    public static final Block CHISELED_OBSIDIAN = Utils._null();

    //Pillars
    public static final Block GRANITE_PILLAR = Utils._null();
    public static final Block DIORITE_PILLAR = Utils._null();
    public static final Block ANDESITE_PILLAR = Utils._null();
    public static final Block PERIDOTITE_PILLAR = Utils._null();
    public static final Block PRISMARINE_PILLAR = Utils._null();
    public static final Block DARK_PRISMARINE_PILLAR = Utils._null();
    public static final Block END_STONE_PILLAR = Utils._null();
    public static final Block NETHERRACK_PILLAR = Utils._null();
    public static final Block RED_NETHER_PILLAR = Utils._null();
    public static final Block OBSIDIAN_PILLAR = Utils._null();

    //Wood Variations
    public static final Block SPRUCE_BOOKSHELF = Utils._null();
    public static final Block BIRCH_BOOKSHELF = Utils._null();
    public static final Block JUNGLE_BOOKSHELF = Utils._null();
    public static final Block ACACIA_BOOKSHELF = Utils._null();
    public static final Block DARK_OAK_BOOKSHELF = Utils._null();
    public static final Block CRIMSON_BOOKSHELF = Utils._null();
    public static final Block WARPED_BOOKSHELF = Utils._null();
    public static final Block SPRUCE_LADDER = Utils._null();
    public static final Block BIRCH_LADDER = Utils._null();
    public static final Block JUNGLE_LADDER = Utils._null();
    public static final Block ACACIA_LADDER = Utils._null();
    public static final Block DARK_OAK_LADDER = Utils._null();
    public static final Block CRIMSON_LADDER = Utils._null();
    public static final Block WARPED_LADDER = Utils._null();

    //Storage
    public static final Block CHARCOAL_BLOCK = Utils._null();
    public static final Block SUGAR_BLOCK = Utils._null();
    public static final Block SUGAR_CANE_BLOCK = Utils._null();
    public static final Block BAMBOO_BLOCK = Utils._null();
    public static final Block GUNPOWDER_BLOCK = Utils._null();
    public static final Block BLAZE_POWDER_BLOCK = Utils._null();
    public static final Block MAGMA_CREAM_BLOCK = Utils._null();
    public static final Block PRISMARINE_CRYSTAL_BLOCK = Utils._null();
    public static final Block WITHER_BONE_BLOCK = Utils._null();
    public static final Block WHITE_DYE_BLOCK = Utils._null();
    public static final Block ORANGE_DYE_BLOCK = Utils._null();
    public static final Block MAGENTA_DYE_BLOCK = Utils._null();
    public static final Block LIGHT_BLUE_DYE_BLOCK = Utils._null();
    public static final Block YELLOW_DYE_BLOCK = Utils._null();
    public static final Block LIME_DYE_BLOCK = Utils._null();
    public static final Block PINK_DYE_BLOCK = Utils._null();
    public static final Block GRAY_DYE_BLOCK = Utils._null();
    public static final Block LIGHT_GRAY_DYE_BLOCK = Utils._null();
    public static final Block CYAN_DYE_BLOCK = Utils._null();
    public static final Block PURPLE_DYE_BLOCK = Utils._null();
    public static final Block BLUE_DYE_BLOCK = Utils._null();
    public static final Block BROWN_DYE_BLOCK = Utils._null();
    public static final Block GREEN_DYE_BLOCK = Utils._null();
    public static final Block RED_DYE_BLOCK = Utils._null();
    public static final Block BLACK_DYE_BLOCK = Utils._null();

    //Glass
    public static final Block SOUL_GLASS = Utils._null();
    public static final Block WHITE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block ORANGE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block MAGENTA_STAINED_SOUL_GLASS = Utils._null();
    public static final Block LIGHT_BLUE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block YELLOW_STAINED_SOUL_GLASS = Utils._null();
    public static final Block LIME_STAINED_SOUL_GLASS = Utils._null();
    public static final Block PINK_STAINED_SOUL_GLASS = Utils._null();
    public static final Block GRAY_STAINED_SOUL_GLASS = Utils._null();
    public static final Block LIGHT_GRAY_STAINED_SOUL_GLASS = Utils._null();
    public static final Block CYAN_STAINED_SOUL_GLASS = Utils._null();
    public static final Block PURPLE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block BLUE_STAINED_SOUL_GLASS = Utils._null();
    public static final Block BROWN_STAINED_SOUL_GLASS = Utils._null();
    public static final Block GREEN_STAINED_SOUL_GLASS = Utils._null();
    public static final Block RED_STAINED_SOUL_GLASS = Utils._null();
    public static final Block BLACK_STAINED_SOUL_GLASS = Utils._null();
    public static final Block SOUL_GLASS_PANE = Utils._null();
    public static final Block WHITE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block ORANGE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block MAGENTA_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block LIGHT_BLUE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block YELLOW_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block LIME_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block PINK_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block GRAY_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block LIGHT_GRAY_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block CYAN_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block PURPLE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block BLUE_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block BROWN_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block GREEN_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block RED_STAINED_SOUL_GLASS_PANE = Utils._null();
    public static final Block BLACK_STAINED_SOUL_GLASS_PANE = Utils._null();

    //Misc
    public static final Block RAIN_DETECTOR = Utils._null();
    public static final Block GOLD_BARS = Utils._null();
    public static final Block ROSE = Utils._null();
    public static final Block POTTED_ROSE = Utils._null();
    public static final Block TOMATO_PLANT = Utils._null();
    public static final Block RICE_PLANT = Utils._null();

    //Cakes
    public static final Block CHOCOLATE_CAKE = Utils._null();
    public static final Block CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block WHITE_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block ORANGE_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block MAGENTA_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block YELLOW_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block LIME_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block PINK_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block GRAY_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block CYAN_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block PURPLE_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block BLUE_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block BROWN_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block GREEN_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block RED_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block BLACK_CANDLE_CHOCOLATE_CAKE = Utils._null();
    public static final Block BERRY_CAKE = Utils._null();
    public static final Block CANDLE_BERRY_CAKE = Utils._null();
    public static final Block WHITE_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block ORANGE_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block MAGENTA_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block LIGHT_BLUE_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block YELLOW_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block LIME_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block PINK_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block GRAY_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block LIGHT_GRAY_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block CYAN_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block PURPLE_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block BLUE_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block BROWN_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block GREEN_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block RED_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block BLACK_CANDLE_BERRY_CAKE = Utils._null();
    public static final Block CARROT_CAKE = Utils._null();
    public static final Block CANDLE_CARROT_CAKE = Utils._null();
    public static final Block WHITE_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block ORANGE_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block MAGENTA_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block LIGHT_BLUE_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block YELLOW_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block LIME_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block PINK_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block GRAY_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block LIGHT_GRAY_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block CYAN_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block PURPLE_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block BLUE_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block BROWN_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block GREEN_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block RED_CANDLE_CARROT_CAKE = Utils._null();
    public static final Block BLACK_CANDLE_CARROT_CAKE = Utils._null();

    //VanillaBoom Stairs
    public static final Block COBBLESTONE_BRICK_STAIRS = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICK_STAIRS = Utils._null();
    public static final Block MAGMA_BRICK_STAIRS = Utils._null();
    public static final Block OBSIDIAN_BRICK_STAIRS = Utils._null();
    public static final Block SNOW_BRICK_STAIRS = Utils._null();
    public static final Block TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block RED_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICK_STAIRS = Utils._null();
    public static final Block PERIDOTITE_STAIRS = Utils._null();
    public static final Block HYDRO_ROCK_STAIRS = Utils._null();
    public static final Block INFERNAL_ROCK_STAIRS = Utils._null();
    public static final Block GRAVEL_STONE_STAIRS = Utils._null();
    public static final Block FINE_GRAVEL_STONE_STAIRS = Utils._null();
    public static final Block GRAVEL_BRICK_STAIRS = Utils._null();
    public static final Block POLISHED_PERIDOTITE_STAIRS = Utils._null();
    public static final Block POLISHED_PRISMARINE_STAIRS = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE_STAIRS = Utils._null();
    public static final Block POLISHED_END_STONE_STAIRS = Utils._null();
    public static final Block POLISHED_NETHERRACK_STAIRS = Utils._null();
    public static final Block CRACKED_RED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK_STAIRS = Utils._null();
    public static final Block CHISELED_OBSIDIAN_STAIRS = Utils._null();

    //Vanilla Stairs
    public static final Block CRACKED_STONE_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_STONE_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_SANDSTONE_STAIRS = Utils._null();
    public static final Block CHISELED_RED_SANDSTONE_STAIRS = Utils._null();
    public static final Block IRON_BLOCK_STAIRS = Utils._null();
    public static final Block GOLD_BLOCK_STAIRS = Utils._null();
    public static final Block OBSIDIAN_STAIRS = Utils._null();
    public static final Block BEDROCK_STAIRS = Utils._null();
    public static final Block NETHERRACK_STAIRS = Utils._null();
    public static final Block CRACKED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_NETHER_BRICK_STAIRS = Utils._null();
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = Utils._null();
    public static final Block CHISELED_POLISHED_BLACKSTONE_STAIRS = Utils._null();
    public static final Block END_STONE_STAIRS = Utils._null();
    public static final Block CHISELED_QUARTZ_BLOCK_STAIRS = Utils._null();
    public static final Block QUARTZ_BRICK_STAIRS = Utils._null();
    public static final Block TERRACOTTA_STAIRS = Utils._null();
    public static final Block WHITE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block ORANGE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_STAIRS = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block YELLOW_TERRACOTTA_STAIRS = Utils._null();
    public static final Block LIME_TERRACOTTA_STAIRS = Utils._null();
    public static final Block PINK_TERRACOTTA_STAIRS = Utils._null();
    public static final Block GRAY_TERRACOTTA_STAIRS = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = Utils._null();
    public static final Block CYAN_TERRACOTTA_STAIRS = Utils._null();
    public static final Block PURPLE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block BLUE_TERRACOTTA_STAIRS = Utils._null();
    public static final Block BROWN_TERRACOTTA_STAIRS = Utils._null();
    public static final Block GREEN_TERRACOTTA_STAIRS = Utils._null();
    public static final Block RED_TERRACOTTA_STAIRS = Utils._null();
    public static final Block BLACK_TERRACOTTA_STAIRS = Utils._null();
    public static final Block WHITE_CONCRETE_STAIRS = Utils._null();
    public static final Block ORANGE_CONCRETE_STAIRS = Utils._null();
    public static final Block MAGENTA_CONCRETE_STAIRS = Utils._null();
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = Utils._null();
    public static final Block YELLOW_CONCRETE_STAIRS = Utils._null();
    public static final Block LIME_CONCRETE_STAIRS = Utils._null();
    public static final Block PINK_CONCRETE_STAIRS = Utils._null();
    public static final Block GRAY_CONCRETE_STAIRS = Utils._null();
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = Utils._null();
    public static final Block CYAN_CONCRETE_STAIRS = Utils._null();
    public static final Block PURPLE_CONCRETE_STAIRS = Utils._null();
    public static final Block BLUE_CONCRETE_STAIRS = Utils._null();
    public static final Block BROWN_CONCRETE_STAIRS = Utils._null();
    public static final Block GREEN_CONCRETE_STAIRS = Utils._null();
    public static final Block RED_CONCRETE_STAIRS = Utils._null();
    public static final Block BLACK_CONCRETE_STAIRS = Utils._null();
    public static final Block OAK_WOOD_STAIRS = Utils._null();
    public static final Block SPRUCE_WOOD_STAIRS = Utils._null();
    public static final Block BIRCH_WOOD_STAIRS = Utils._null();
    public static final Block JUNGLE_WOOD_STAIRS = Utils._null();
    public static final Block ACACIA_WOOD_STAIRS = Utils._null();
    public static final Block DARK_OAK_WOOD_STAIRS = Utils._null();
    public static final Block CRIMSON_HYPHAE_STAIRS = Utils._null();
    public static final Block WARPED_HYPHAE_STAIRS = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_STAIRS = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_STAIRS = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_STAIRS = Utils._null();
    public static final Block CUT_SANDSTONE_STAIRS = Utils._null();
    public static final Block CUT_RED_SANDSTONE_STAIRS = Utils._null();
    public static final Block SMOOTH_STONE_STAIRS = Utils._null();

    //VanillaBoom Slabs
    public static final Block COBBLESTONE_BRICK_SLAB = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICK_SLAB = Utils._null();
    public static final Block MAGMA_BRICK_SLAB = Utils._null();
    public static final Block OBSIDIAN_BRICK_SLAB = Utils._null();
    public static final Block SNOW_BRICK_SLAB = Utils._null();
    public static final Block TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block RED_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICK_SLAB = Utils._null();
    public static final Block PERIDOTITE_SLAB = Utils._null();
    public static final Block HYDRO_ROCK_SLAB = Utils._null();
    public static final Block INFERNAL_ROCK_SLAB = Utils._null();
    public static final Block GRAVEL_STONE_SLAB = Utils._null();
    public static final Block FINE_GRAVEL_STONE_SLAB = Utils._null();
    public static final Block GRAVEL_BRICK_SLAB = Utils._null();
    public static final Block POLISHED_PERIDOTITE_SLAB = Utils._null();
    public static final Block POLISHED_PRISMARINE_SLAB = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE_SLAB = Utils._null();
    public static final Block POLISHED_END_STONE_SLAB = Utils._null();
    public static final Block POLISHED_NETHERRACK_SLAB = Utils._null();
    public static final Block CRACKED_RED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK_SLAB = Utils._null();
    public static final Block CHISELED_OBSIDIAN_SLAB = Utils._null();

    //Vanilla Slabs
    public static final Block CRACKED_STONE_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_STONE_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_SANDSTONE_SLAB = Utils._null();
    public static final Block CHISELED_RED_SANDSTONE_SLAB = Utils._null();
    public static final Block IRON_BLOCK_SLAB = Utils._null();
    public static final Block GOLD_BLOCK_SLAB = Utils._null();
    public static final Block OBSIDIAN_SLAB = Utils._null();
    public static final Block BEDROCK_SLAB = Utils._null();
    public static final Block NETHERRACK_SLAB = Utils._null();
    public static final Block CRACKED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_NETHER_BRICK_SLAB = Utils._null();
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = Utils._null();
    public static final Block CHISELED_POLISHED_BLACKSTONE_SLAB = Utils._null();
    public static final Block END_STONE_SLAB = Utils._null();
    public static final Block CHISELED_QUARTZ_BLOCK_SLAB = Utils._null();
    public static final Block QUARTZ_BRICK_SLAB = Utils._null();
    public static final Block TERRACOTTA_SLAB = Utils._null();
    public static final Block WHITE_TERRACOTTA_SLAB = Utils._null();
    public static final Block ORANGE_TERRACOTTA_SLAB = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_SLAB = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = Utils._null();
    public static final Block YELLOW_TERRACOTTA_SLAB = Utils._null();
    public static final Block LIME_TERRACOTTA_SLAB = Utils._null();
    public static final Block PINK_TERRACOTTA_SLAB = Utils._null();
    public static final Block GRAY_TERRACOTTA_SLAB = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = Utils._null();
    public static final Block CYAN_TERRACOTTA_SLAB = Utils._null();
    public static final Block PURPLE_TERRACOTTA_SLAB = Utils._null();
    public static final Block BLUE_TERRACOTTA_SLAB = Utils._null();
    public static final Block BROWN_TERRACOTTA_SLAB = Utils._null();
    public static final Block GREEN_TERRACOTTA_SLAB = Utils._null();
    public static final Block RED_TERRACOTTA_SLAB = Utils._null();
    public static final Block BLACK_TERRACOTTA_SLAB = Utils._null();
    public static final Block WHITE_CONCRETE_SLAB = Utils._null();
    public static final Block ORANGE_CONCRETE_SLAB = Utils._null();
    public static final Block MAGENTA_CONCRETE_SLAB = Utils._null();
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = Utils._null();
    public static final Block YELLOW_CONCRETE_SLAB = Utils._null();
    public static final Block LIME_CONCRETE_SLAB = Utils._null();
    public static final Block PINK_CONCRETE_SLAB = Utils._null();
    public static final Block GRAY_CONCRETE_SLAB = Utils._null();
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = Utils._null();
    public static final Block CYAN_CONCRETE_SLAB = Utils._null();
    public static final Block PURPLE_CONCRETE_SLAB = Utils._null();
    public static final Block BLUE_CONCRETE_SLAB = Utils._null();
    public static final Block BROWN_CONCRETE_SLAB = Utils._null();
    public static final Block GREEN_CONCRETE_SLAB = Utils._null();
    public static final Block RED_CONCRETE_SLAB = Utils._null();
    public static final Block BLACK_CONCRETE_SLAB = Utils._null();
    public static final Block OAK_WOOD_SLAB = Utils._null();
    public static final Block SPRUCE_WOOD_SLAB = Utils._null();
    public static final Block BIRCH_WOOD_SLAB = Utils._null();
    public static final Block JUNGLE_WOOD_SLAB = Utils._null();
    public static final Block ACACIA_WOOD_SLAB = Utils._null();
    public static final Block DARK_OAK_WOOD_SLAB = Utils._null();
    public static final Block CRIMSON_HYPHAE_SLAB = Utils._null();
    public static final Block WARPED_HYPHAE_SLAB = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_SLAB = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_SLAB = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_SLAB = Utils._null();

    //VanillaBoom Walls
    public static final Block COBBLESTONE_BRICK_WALL = Utils._null();
    public static final Block MOSSY_COBBLESTONE_BRICK_WALL = Utils._null();
    public static final Block MAGMA_BRICK_WALL = Utils._null();
    public static final Block OBSIDIAN_BRICK_WALL = Utils._null();
    public static final Block SNOW_BRICK_WALL = Utils._null();
    public static final Block TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block WHITE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block ORANGE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block YELLOW_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block LIME_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block PINK_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block GRAY_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block CYAN_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block PURPLE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block BLUE_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block BROWN_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block GREEN_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block RED_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block BLACK_TERRACOTTA_BRICK_WALL = Utils._null();
    public static final Block PERIDOTITE_WALL = Utils._null();
    public static final Block HYDRO_ROCK_WALL = Utils._null();
    public static final Block INFERNAL_ROCK_WALL = Utils._null();
    public static final Block GRAVEL_STONE_WALL = Utils._null();
    public static final Block FINE_GRAVEL_STONE_WALL = Utils._null();
    public static final Block GRAVEL_BRICK_WALL = Utils._null();
    public static final Block POLISHED_PERIDOTITE_WALL = Utils._null();
    public static final Block POLISHED_PRISMARINE_WALL = Utils._null();
    public static final Block POLISHED_DARK_PRISMARINE_WALL = Utils._null();
    public static final Block POLISHED_END_STONE_WALL = Utils._null();
    public static final Block POLISHED_NETHERRACK_WALL = Utils._null();
    public static final Block CHISELED_PURPUR_BLOCK_WALL = Utils._null();
    public static final Block CRACKED_RED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CHISELED_RED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CHISELED_OBSIDIAN_WALL = Utils._null();

    //Vanilla Walls
    public static final Block CRACKED_STONE_BRICK_WALL = Utils._null();
    public static final Block CHISELED_STONE_BRICK_WALL = Utils._null();
    public static final Block CHISELED_SANDSTONE_WALL = Utils._null();
    public static final Block CHISELED_RED_SANDSTONE_WALL = Utils._null();
    public static final Block IRON_BLOCK_WALL = Utils._null();
    public static final Block GOLD_BLOCK_WALL = Utils._null();
    public static final Block OBSIDIAN_WALL = Utils._null();
    public static final Block BEDROCK_WALL = Utils._null();
    public static final Block NETHERRACK_WALL = Utils._null();
    public static final Block CRACKED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CHISELED_NETHER_BRICK_WALL = Utils._null();
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = Utils._null();
    public static final Block CHISELED_POLISHED_BLACKSTONE_WALL = Utils._null();
    public static final Block END_STONE_WALL = Utils._null();
    public static final Block CHISELED_QUARTZ_BLOCK_WALL = Utils._null();
    public static final Block QUARTZ_BRICK_WALL = Utils._null();
    public static final Block TERRACOTTA_WALL = Utils._null();
    public static final Block WHITE_TERRACOTTA_WALL = Utils._null();
    public static final Block ORANGE_TERRACOTTA_WALL = Utils._null();
    public static final Block MAGENTA_TERRACOTTA_WALL = Utils._null();
    public static final Block LIGHT_BLUE_TERRACOTTA_WALL = Utils._null();
    public static final Block YELLOW_TERRACOTTA_WALL = Utils._null();
    public static final Block LIME_TERRACOTTA_WALL = Utils._null();
    public static final Block PINK_TERRACOTTA_WALL = Utils._null();
    public static final Block GRAY_TERRACOTTA_WALL = Utils._null();
    public static final Block LIGHT_GRAY_TERRACOTTA_WALL = Utils._null();
    public static final Block CYAN_TERRACOTTA_WALL = Utils._null();
    public static final Block PURPLE_TERRACOTTA_WALL = Utils._null();
    public static final Block BLUE_TERRACOTTA_WALL = Utils._null();
    public static final Block BROWN_TERRACOTTA_WALL = Utils._null();
    public static final Block GREEN_TERRACOTTA_WALL = Utils._null();
    public static final Block RED_TERRACOTTA_WALL = Utils._null();
    public static final Block BLACK_TERRACOTTA_WALL = Utils._null();
    public static final Block WHITE_CONCRETE_WALL = Utils._null();
    public static final Block ORANGE_CONCRETE_WALL = Utils._null();
    public static final Block MAGENTA_CONCRETE_WALL = Utils._null();
    public static final Block LIGHT_BLUE_CONCRETE_WALL = Utils._null();
    public static final Block YELLOW_CONCRETE_WALL = Utils._null();
    public static final Block LIME_CONCRETE_WALL = Utils._null();
    public static final Block PINK_CONCRETE_WALL = Utils._null();
    public static final Block GRAY_CONCRETE_WALL = Utils._null();
    public static final Block LIGHT_GRAY_CONCRETE_WALL = Utils._null();
    public static final Block CYAN_CONCRETE_WALL = Utils._null();
    public static final Block PURPLE_CONCRETE_WALL = Utils._null();
    public static final Block BLUE_CONCRETE_WALL = Utils._null();
    public static final Block BROWN_CONCRETE_WALL = Utils._null();
    public static final Block GREEN_CONCRETE_WALL = Utils._null();
    public static final Block RED_CONCRETE_WALL = Utils._null();
    public static final Block BLACK_CONCRETE_WALL = Utils._null();
    public static final Block CUT_SANDSTONE_WALL = Utils._null();
    public static final Block CUT_RED_SANDSTONE_WALL = Utils._null();
    public static final Block SMOOTH_STONE_WALL = Utils._null();
    public static final Block STONE_WALL = Utils._null();
    public static final Block POLISHED_GRANITE_WALL = Utils._null();
    public static final Block POLISHED_DIORITE_WALL = Utils._null();
    public static final Block POLISHED_ANDESITE_WALL = Utils._null();
    public static final Block SMOOTH_SANDSTONE_WALL = Utils._null();
    public static final Block SMOOTH_RED_SANDSTONE_WALL = Utils._null();
    public static final Block PURPUR_BLOCK_WALL = Utils._null();
    public static final Block QUARTZ_BLOCK_WALL = Utils._null();
    public static final Block SMOOTH_QUARTZ_WALL = Utils._null();
    public static final Block PRISMARINE_BRICK_WALL = Utils._null();
    public static final Block DARK_PRISMARINE_WALL = Utils._null();

    //Vanilla Fences
    public static final Block OAK_WOOD_FENCE = Utils._null();
    public static final Block SPRUCE_WOOD_FENCE = Utils._null();
    public static final Block BIRCH_WOOD_FENCE = Utils._null();
    public static final Block JUNGLE_WOOD_FENCE = Utils._null();
    public static final Block ACACIA_WOOD_FENCE = Utils._null();
    public static final Block DARK_OAK_WOOD_FENCE = Utils._null();
    public static final Block CRIMSON_HYPHAE_FENCE = Utils._null();
    public static final Block WARPED_HYPHAE_FENCE = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_FENCE = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_FENCE = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_FENCE = Utils._null();
    public static final Block RED_NETHER_BRICK_FENCE = Utils._null();
    public static final Block OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block SPRUCE_WOOD_FENCE_GATE = Utils._null();
    public static final Block BIRCH_WOOD_FENCE_GATE = Utils._null();
    public static final Block JUNGLE_WOOD_FENCE_GATE = Utils._null();
    public static final Block ACACIA_WOOD_FENCE_GATE = Utils._null();
    public static final Block DARK_OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block CRIMSON_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block WARPED_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_SPRUCE_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_BIRCH_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_JUNGLE_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_ACACIA_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_DARK_OAK_WOOD_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_CRIMSON_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block STRIPPED_WARPED_HYPHAE_FENCE_GATE = Utils._null();
    public static final Block NETHER_BRICK_FENCE_GATE = Utils._null();
    public static final Block RED_NETHER_BRICK_FENCE_GATE = Utils._null();

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {

        private static final Block[] CANDLES = {Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE};
        public static final String[] CANDLE_COLORS = {"candle_", "white_candle_", "orange_candle_", "magenta_candle_", "light_blue_candle_", "yellow_candle_", "lime_candle_", "pink_candle_", "gray_candle_", "light_gray_candle_", "cyan_candle_", "purple_candle_", "blue_candle_", "brown_candle_", "green_candle_", "red_candle_", "black_candle_"};

        @SubscribeEvent
        public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
            IForgeRegistry<Block> registry = event.getRegistry();

            //Bricks
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.COBBLESTONE), Names.COBBLESTONE_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE), Names.MOSSY_COBBLESTONE_BRICKS);
            createSpecialBlock(registry, new MagmaBlock(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK)), Names.MAGMA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.OBSIDIAN), Names.OBSIDIAN_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK), Names.SNOW_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.TERRACOTTA), Names.TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA), Names.WHITE_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.ORANGE_TERRACOTTA), Names.ORANGE_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.MAGENTA_TERRACOTTA), Names.MAGENTA_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_TERRACOTTA), Names.LIGHT_BLUE_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.YELLOW_TERRACOTTA), Names.YELLOW_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.LIME_TERRACOTTA), Names.LIME_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.PINK_TERRACOTTA), Names.PINK_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.GRAY_TERRACOTTA), Names.GRAY_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_TERRACOTTA), Names.LIGHT_GRAY_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.CYAN_TERRACOTTA), Names.CYAN_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.PURPLE_TERRACOTTA), Names.PURPLE_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.BLUE_TERRACOTTA), Names.BLUE_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.BROWN_TERRACOTTA), Names.BROWN_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.GREEN_TERRACOTTA), Names.GREEN_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA), Names.RED_TERRACOTTA_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.BLACK_TERRACOTTA), Names.BLACK_TERRACOTTA_BRICKS);

            //Rocks
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.ANDESITE), Names.PERIDOTITE);
            createSpecialBlock(registry, new HydroRockBlock(), Names.HYDRO_ROCK);
            createSpecialBlock(registry, new InfernalRockBlock(), Names.INFERNAL_ROCK);

            //Sand and Gravel
            registry.register(setup(new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SNOW).strength(0.5F, 0.0F).sound(SoundType.SOUL_SAND).requiresCorrectToolForDrops()), Names.BONE_SAND));
            registry.register(setup(new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_BLACK).strength(0.5F, 0.0F).sound(SoundType.SOUL_SAND).requiresCorrectToolForDrops()), Names.WITHER_BONE_SAND));
            registry.register(setup(new FallingBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).requiresCorrectToolForDrops()), Names.FINE_GRAVEL));
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.STONE), Names.GRAVEL_STONE);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.STONE), Names.FINE_GRAVEL_STONE);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS), Names.GRAVEL_BRICKS);

            //Polished
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE), Names.POLISHED_PERIDOTITE);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.PRISMARINE), Names.POLISHED_PRISMARINE);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE), Names.POLISHED_DARK_PRISMARINE);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.END_STONE), Names.POLISHED_END_STONE);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.NETHERRACK), Names.POLISHED_NETHERRACK);

            //Chiseled and cracked
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK), Names.CHISELED_PURPUR_BLOCK);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS), Names.CRACKED_RED_NETHER_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS), Names.CHISELED_RED_NETHER_BRICKS);
            createSpecialBlock(registry, BlockBehaviour.Properties.copy(Blocks.OBSIDIAN), Names.CHISELED_OBSIDIAN);

            //Pillars
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)), Names.GRANITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)), Names.DIORITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), Names.ANDESITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), Names.PERIDOTITE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)), Names.PRISMARINE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE)), Names.DARK_PRISMARINE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)), Names.END_STONE_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)), Names.NETHERRACK_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS)), Names.RED_NETHER_PILLAR));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)), Names.OBSIDIAN_PILLAR));

            //Wood Variations
            registry.register(setup(new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), Names.SPRUCE_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), Names.BIRCH_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), Names.JUNGLE_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), Names.ACACIA_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), Names.DARK_OAK_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), Names.CRIMSON_BOOKSHELF));
            registry.register(setup(new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), Names.WARPED_BOOKSHELF));

            //Storage Blocks
            registry.register(setup(new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)), Names.CHARCOAL_BLOCK));
            registry.register(setup(new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SNOW).strength(0.5F, 0.0F).sound(SoundType.SAND).requiresCorrectToolForDrops()), Names.SUGAR_BLOCK));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).strength(0.5F, 0.0F)), Names.SUGAR_CANE_BLOCK));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO)), "bamboo_block"));
            registry.register(setup(new GunpowderBlock(), Names.GUNPOWDER_BLOCK));
            registry.register(setup(new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SNOW).requiresCorrectToolForDrops()), Names.BLAZE_POWDER_BLOCK));
            registry.register(setup(new SlimeBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)), Names.MAGMA_CREAM_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_CYAN).strength(0.3F, 0.5F).sound(SoundType.GLASS).lightLevel((lightValue) ->
            {
                return 5;
            })), Names.PRISMARINE_CRYSTAL_BLOCK));
            registry.register(setup(new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.BONE_BLOCK).strength(1.8F, 3.33F)), Names.WITHER_BONE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).strength(3.0F, 5.0F)), Names.WHITE_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).strength(3.0F, 5.0F)), Names.ORANGE_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength(3.0F, 5.0F)), Names.MAGENTA_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE).strength(3.0F, 5.0F)), Names.LIGHT_BLUE_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).strength(3.0F, 5.0F)), Names.YELLOW_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).strength(3.0F, 5.0F)), Names.LIME_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).strength(3.0F, 5.0F)), Names.PINK_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0F, 5.0F)), Names.GRAY_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 5.0F)), Names.LIGHT_GRAY_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).strength(3.0F, 5.0F)), Names.CYAN_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE).strength(3.0F, 5.0F)), Names.PURPLE_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(3.0F, 5.0F)), Names.BLUE_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(3.0F, 5.0F)), Names.BROWN_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0F, 5.0F)), Names.GREEN_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(3.0F, 5.0F)), Names.RED_DYE_BLOCK));
            registry.register(setup(new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F, 5.0F)), Names.BLACK_DYE_BLOCK));

            //Glass
            registry.register(setup(new StainedGlassBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.GLASS)), Names.SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)), Names.WHITE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.ORANGE, BlockBehaviour.Properties.copy(Blocks.ORANGE_STAINED_GLASS)), Names.ORANGE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.copy(Blocks.MAGENTA_STAINED_GLASS)), Names.MAGENTA_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_STAINED_GLASS)), Names.LIGHT_BLUE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.YELLOW, BlockBehaviour.Properties.copy(Blocks.YELLOW_STAINED_GLASS)), Names.YELLOW_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.LIME, BlockBehaviour.Properties.copy(Blocks.LIME_STAINED_GLASS)), Names.LIME_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.PINK, BlockBehaviour.Properties.copy(Blocks.PINK_STAINED_GLASS)), Names.PINK_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.GRAY, BlockBehaviour.Properties.copy(Blocks.GRAY_STAINED_GLASS)), Names.GRAY_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_STAINED_GLASS)), Names.LIGHT_GRAY_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.CYAN, BlockBehaviour.Properties.copy(Blocks.CYAN_STAINED_GLASS)), Names.CYAN_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.PURPLE, BlockBehaviour.Properties.copy(Blocks.PURPLE_STAINED_GLASS)), Names.PURPLE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.BLUE, BlockBehaviour.Properties.copy(Blocks.BLUE_STAINED_GLASS)), Names.BLUE_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.BROWN, BlockBehaviour.Properties.copy(Blocks.BROWN_STAINED_GLASS)), Names.BROWN_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.GREEN, BlockBehaviour.Properties.copy(Blocks.GREEN_STAINED_GLASS)), Names.GREEN_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.RED, BlockBehaviour.Properties.copy(Blocks.RED_STAINED_GLASS)), Names.RED_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassBlock(DyeColor.BLACK, BlockBehaviour.Properties.copy(Blocks.BLACK_STAINED_GLASS)), Names.BLACK_STAINED_SOUL_GLASS));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.GLASS_PANE)), Names.SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)), Names.WHITE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.ORANGE, BlockBehaviour.Properties.copy(Blocks.ORANGE_STAINED_GLASS_PANE)), Names.ORANGE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.copy(Blocks.MAGENTA_STAINED_GLASS_PANE)), Names.MAGENTA_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)), Names.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.YELLOW, BlockBehaviour.Properties.copy(Blocks.YELLOW_STAINED_GLASS_PANE)), Names.YELLOW_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.LIME, BlockBehaviour.Properties.copy(Blocks.LIME_STAINED_GLASS_PANE)), Names.LIME_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.PINK, BlockBehaviour.Properties.copy(Blocks.PINK_STAINED_GLASS_PANE)), Names.PINK_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.GRAY, BlockBehaviour.Properties.copy(Blocks.GRAY_STAINED_GLASS_PANE)), Names.GRAY_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)), Names.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.CYAN, BlockBehaviour.Properties.copy(Blocks.CYAN_STAINED_GLASS_PANE)), Names.CYAN_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.PURPLE, BlockBehaviour.Properties.copy(Blocks.PURPLE_STAINED_GLASS_PANE)), Names.PURPLE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.BLUE, BlockBehaviour.Properties.copy(Blocks.BLUE_STAINED_GLASS_PANE)), Names.BLUE_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.BROWN, BlockBehaviour.Properties.copy(Blocks.BROWN_STAINED_GLASS_PANE)), Names.BROWN_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.GREEN, BlockBehaviour.Properties.copy(Blocks.GREEN_STAINED_GLASS_PANE)), Names.GREEN_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.RED, BlockBehaviour.Properties.copy(Blocks.RED_STAINED_GLASS_PANE)), Names.RED_STAINED_SOUL_GLASS_PANE));
            registry.register(setup(new StainedGlassPaneBlock(DyeColor.BLACK, BlockBehaviour.Properties.copy(Blocks.BLACK_STAINED_GLASS_PANE)), Names.BLACK_STAINED_SOUL_GLASS_PANE));

            //Misc
            registry.register(setup(new RainDetectorBlock(BlockBehaviour.Properties.copy(Blocks.DAYLIGHT_DETECTOR)), "rain_detector"));
            registry.register(setup(new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)), Names.GOLD_BARS));
            registry.register(setup(new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), Names.SPRUCE_LADDER));
            registry.register(setup(new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), Names.BIRCH_LADDER));
            registry.register(setup(new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), Names.JUNGLE_LADDER));
            registry.register(setup(new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), Names.ACACIA_LADDER));
            registry.register(setup(new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), Names.DARK_OAK_LADDER));
            registry.register(setup(new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), Names.CRIMSON_LADDER));
            registry.register(setup(new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), Names.WARPED_LADDER));
            createFlower(registry, MobEffects.DIG_SPEED, 10, Names.ROSE);
            registry.register(setup(new TomatoPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)), "tomato_plant"));
            registry.register(setup(new RicePlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)), "rice_plant"));
            createCake(registry, "chocolate_cake");
            createCake(registry, "berry_cake");
            createCake(registry, "carrot_cake");

            //Vanilla Stairs, Slabs and Walls
            addVanillaVariants(registry, Blocks.CRACKED_STONE_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_STONE_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_SANDSTONE, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_RED_SANDSTONE, true, true, true);
            addVanillaVariants(registry, Blocks.IRON_BLOCK, true, true, true);
            addVanillaVariants(registry, Blocks.GOLD_BLOCK, true, true, true);
            addVanillaVariants(registry, Blocks.OBSIDIAN, true, true, true);
            addVanillaVariants(registry, Blocks.BEDROCK, true, true, true);
            addVanillaVariants(registry, Blocks.NETHERRACK, true, true, true);
            addVanillaVariants(registry, Blocks.CRACKED_NETHER_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_NETHER_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_POLISHED_BLACKSTONE, true, true, true);
            addVanillaVariants(registry, Blocks.END_STONE, true, true, true);
            addVanillaVariants(registry, Blocks.CHISELED_QUARTZ_BLOCK, true, true, true);
            addVanillaVariants(registry, Blocks.QUARTZ_BRICKS, true, true, true);
            addVanillaVariants(registry, Blocks.TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.WHITE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.ORANGE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.MAGENTA_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_BLUE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.YELLOW_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.LIME_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.PINK_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.GRAY_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_GRAY_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.CYAN_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.PURPLE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.BLUE_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.BROWN_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.GREEN_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.RED_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.BLACK_TERRACOTTA, true, true, true);
            addVanillaVariants(registry, Blocks.WHITE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.ORANGE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.MAGENTA_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_BLUE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.YELLOW_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.LIME_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.PINK_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.GRAY_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.LIGHT_GRAY_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.CYAN_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.PURPLE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.BLUE_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.BROWN_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.GREEN_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.RED_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.BLACK_CONCRETE, true, true, true);
            addVanillaVariants(registry, Blocks.OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.SPRUCE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.BIRCH_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.JUNGLE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.ACACIA_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.DARK_OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.CRIMSON_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.WARPED_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_SPRUCE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_BIRCH_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_JUNGLE_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_ACACIA_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_DARK_OAK_WOOD, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_CRIMSON_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.STRIPPED_WARPED_HYPHAE, true, true, false);
            addVanillaVariants(registry, Blocks.CUT_SANDSTONE, true, false, true);
            addVanillaVariants(registry, Blocks.CUT_RED_SANDSTONE, true, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_STONE, true, false, true);
            addVanillaVariants(registry, Blocks.STONE, false, false, true);
            addVanillaVariants(registry, Blocks.POLISHED_GRANITE, false, false, true);
            addVanillaVariants(registry, Blocks.POLISHED_DIORITE, false, false, true);
            addVanillaVariants(registry, Blocks.POLISHED_ANDESITE, false, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_SANDSTONE, false, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_RED_SANDSTONE, false, false, true);
            addVanillaVariants(registry, Blocks.PURPUR_BLOCK, false, false, true);
            addVanillaVariants(registry, Blocks.QUARTZ_BLOCK, false, false, true);
            addVanillaVariants(registry, Blocks.SMOOTH_QUARTZ, false, false, true);
            addVanillaVariants(registry, Blocks.PRISMARINE_BRICKS, false, false, true);
            addVanillaVariants(registry, Blocks.DARK_PRISMARINE, false, false, true);

            //Fences
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), Names.OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)), Names.SPRUCE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)), Names.BIRCH_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE)), Names.JUNGLE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE)), Names.ACACIA_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE)), Names.DARK_OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE).sound(SoundType.STEM)), Names.CRIMSON_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE).sound(SoundType.STEM)), Names.WARPED_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), Names.STRIPPED_OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)), Names.STRIPPED_SPRUCE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)), Names.STRIPPED_BIRCH_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE)), Names.STRIPPED_JUNGLE_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE)), Names.STRIPPED_ACACIA_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE)), Names.STRIPPED_DARK_OAK_WOOD_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE).sound(SoundType.STEM)), Names.STRIPPED_CRIMSON_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE).sound(SoundType.STEM)), Names.STRIPPED_WARPED_HYPHAE_FENCE));
            registry.register(setup(new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE)), Names.RED_NETHER_BRICK_FENCE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), Names.OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE)), Names.SPRUCE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE_GATE)), Names.BIRCH_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE_GATE)), Names.JUNGLE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE_GATE)), Names.ACACIA_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE_GATE)), Names.DARK_OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE_GATE).sound(SoundType.STEM)), Names.CRIMSON_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE_GATE).sound(SoundType.STEM)), Names.WARPED_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), Names.STRIPPED_OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE)), Names.STRIPPED_SPRUCE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE_GATE)), Names.STRIPPED_BIRCH_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE_GATE)), Names.STRIPPED_JUNGLE_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE_GATE)), Names.STRIPPED_ACACIA_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE_GATE)), Names.STRIPPED_DARK_OAK_WOOD_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE_GATE).sound(SoundType.STEM)), Names.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE_GATE).sound(SoundType.STEM)), Names.STRIPPED_WARPED_HYPHAE_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE)), Names.NETHER_BRICK_FENCE_GATE));
            registry.register(setup(new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE)), Names.RED_NETHER_BRICK_FENCE_GATE));
        }

        private static void addVanillaVariants(IForgeRegistry<Block> registry, Block block, boolean addStair, boolean addSlab, boolean addWall) {
            if (addStair) {
                registry.register(setup(new ModStairBlock(block), Utils.getStairName(block.getRegistryName().getPath())));
            }

            if (addSlab) {
                registry.register(setup(new ModSlabBlock(block), Utils.getSlabName(block.getRegistryName().getPath())));
            }

            if (addWall) {
                registry.register(setup(new ModWallBlock(block), Utils.getWallName(block.getRegistryName().getPath())));
            }
        }

        private static void createSpecialBlock(IForgeRegistry<Block> registry, BlockBehaviour.Properties builder, String name) {
            createSpecialBlock(registry, new Block(builder), name);
        }

        private static void createSpecialBlock(IForgeRegistry<Block> registry, Block block, String name) {
            registry.register(setup(block, name));
            registry.register(setup(new ModStairBlock(block), Utils.getStairName(name)));
            registry.register(setup(new ModSlabBlock(block), Utils.getSlabName(name)));
            registry.register(setup(new ModWallBlock(block), Utils.getWallName(name)));
        }

        private static void createFlower(IForgeRegistry<Block> registry, MobEffect effect, int effectDuration, String name) {
            Block flower = new FlowerBlock(effect, effectDuration, BlockBehaviour.Properties.copy(Blocks.POPPY));
            registry.register(setup(flower, name));
            registry.register(setup(new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> flower, BlockBehaviour.Properties.of(Material.DECORATION).strength(0.0F)), "potted_" + name));
        }

        private static void createCake(IForgeRegistry<Block> registry, String name) {
            Block cake = new ModCakeBlock();
            registry.register(setup(cake, name));
            Map<Block, CandleCakeBlock> candleMap = Maps.newHashMap();

            for (int i = 0; i < CANDLE_COLORS.length; i++){
                CandleCakeBlock candleCake = new ModCandleCakeBlock(cake);
                candleMap.put(CANDLES[i], candleCake);
                registry.register(setup(candleCake, CANDLE_COLORS[i]  + name));
            }

            ModCakeBlock.CANDLE_CAKES.put(cake, candleMap);
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(T entry, String name) {
            return setup(entry, new ResourceLocation(VanillaBoom.MOD_ID, name));
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(T entry, ResourceLocation registryName) {
            entry.setRegistryName(registryName);
            return entry;
        }
    }
}
