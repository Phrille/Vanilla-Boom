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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.*;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.util.Names;
import phrille.vanillaboom.util.Utils;

import java.util.Map;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModBlocks {



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

        @SubscribeEvent
        public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
            IForgeRegistry<Block> registry = event.getRegistry();

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
            flowerBlock(registry, MobEffects.DIG_SPEED, 10, Names.ROSE);
            registry.register(setup(new TomatoPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)), "tomato_plant"));
            registry.register(setup(new RicePlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)), "rice_plant"));
            cakeBlock(registry, "chocolate_cake");
            cakeBlock(registry, "berry_cake");
            cakeBlock(registry, "carrot_cake");

            //Vanilla Stairs, Slabs and Walls
            vanillaVariants(registry, Blocks.CRACKED_STONE_BRICKS, true, true, true);
            vanillaVariants(registry, Blocks.CHISELED_STONE_BRICKS, true, true, true);
            vanillaVariants(registry, Blocks.CHISELED_SANDSTONE, true, true, true);
            vanillaVariants(registry, Blocks.CHISELED_RED_SANDSTONE, true, true, true);
            vanillaVariants(registry, Blocks.IRON_BLOCK, true, true, true);
            vanillaVariants(registry, Blocks.GOLD_BLOCK, true, true, true);
            vanillaVariants(registry, Blocks.OBSIDIAN, true, true, true);
            vanillaVariants(registry, Blocks.BEDROCK, true, true, true);
            vanillaVariants(registry, Blocks.NETHERRACK, true, true, true);
            vanillaVariants(registry, Blocks.CRACKED_NETHER_BRICKS, true, true, true);
            vanillaVariants(registry, Blocks.CHISELED_NETHER_BRICKS, true, true, true);
            vanillaVariants(registry, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, true, true, true);
            vanillaVariants(registry, Blocks.CHISELED_POLISHED_BLACKSTONE, true, true, true);
            vanillaVariants(registry, Blocks.END_STONE, true, true, true);
            vanillaVariants(registry, Blocks.CHISELED_QUARTZ_BLOCK, true, true, true);
            vanillaVariants(registry, Blocks.QUARTZ_BRICKS, true, true, true);
            vanillaVariants(registry, Blocks.TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.WHITE_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.ORANGE_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.MAGENTA_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.LIGHT_BLUE_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.YELLOW_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.LIME_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.PINK_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.GRAY_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.LIGHT_GRAY_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.CYAN_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.PURPLE_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.BLUE_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.BROWN_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.GREEN_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.RED_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.BLACK_TERRACOTTA, true, true, true);
            vanillaVariants(registry, Blocks.WHITE_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.ORANGE_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.MAGENTA_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.LIGHT_BLUE_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.YELLOW_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.LIME_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.PINK_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.GRAY_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.LIGHT_GRAY_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.CYAN_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.PURPLE_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.BLUE_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.BROWN_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.GREEN_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.RED_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.BLACK_CONCRETE, true, true, true);
            vanillaVariants(registry, Blocks.OAK_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.SPRUCE_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.BIRCH_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.JUNGLE_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.ACACIA_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.DARK_OAK_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.CRIMSON_HYPHAE, true, true, false);
            vanillaVariants(registry, Blocks.WARPED_HYPHAE, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_OAK_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_SPRUCE_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_BIRCH_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_JUNGLE_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_ACACIA_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_DARK_OAK_WOOD, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_CRIMSON_HYPHAE, true, true, false);
            vanillaVariants(registry, Blocks.STRIPPED_WARPED_HYPHAE, true, true, false);
            vanillaVariants(registry, Blocks.CUT_SANDSTONE, true, false, true);
            vanillaVariants(registry, Blocks.CUT_RED_SANDSTONE, true, false, true);
            vanillaVariants(registry, Blocks.SMOOTH_STONE, true, false, true);
            vanillaVariants(registry, Blocks.STONE, false, false, true);
            vanillaVariants(registry, Blocks.POLISHED_GRANITE, false, false, true);
            vanillaVariants(registry, Blocks.POLISHED_DIORITE, false, false, true);
            vanillaVariants(registry, Blocks.POLISHED_ANDESITE, false, false, true);
            vanillaVariants(registry, Blocks.SMOOTH_SANDSTONE, false, false, true);
            vanillaVariants(registry, Blocks.SMOOTH_RED_SANDSTONE, false, false, true);
            vanillaVariants(registry, Blocks.PURPUR_BLOCK, false, false, true);
            vanillaVariants(registry, Blocks.QUARTZ_BLOCK, false, false, true);
            vanillaVariants(registry, Blocks.SMOOTH_QUARTZ, false, false, true);
            vanillaVariants(registry, Blocks.PRISMARINE_BRICKS, false, false, true);
            vanillaVariants(registry, Blocks.DARK_PRISMARINE, false, false, true);

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

        private static void vanillaVariants(IForgeRegistry<Block> registry, Block block, boolean addStair, boolean addSlab, boolean addWall) {
            if (addStair) {
                registry.register(setup(new ModStairBlock(block::defaultBlockState), ModStairBlock.getStairName(block)));
            }

            if (addSlab) {
                registry.register(setup(new ModSlabBlock(block::defaultBlockState), ModSlabBlock.getSlabName(block)));
            }

            if (addWall) {
                registry.register(setup(new ModWallBlock(block::defaultBlockState), ModWallBlock.getWallName(block)));
            }
        }

        private static void blockWithVariants(IForgeRegistry<Block> registry, BlockBehaviour.Properties builder, String name) {
            blockWithVariants(registry, new Block(builder), name);
        }

        private static void blockWithVariants(IForgeRegistry<Block> registry, Block block, String name) {
            registry.register(setup(block, name));
            registry.register(setup(new ModStairBlock(block::defaultBlockState), ModStairBlock.getStairName(block)));
            registry.register(setup(new ModSlabBlock(block::defaultBlockState), ModSlabBlock.getSlabName(block)));
            registry.register(setup(new ModWallBlock(block::defaultBlockState), ModWallBlock.getWallName(block)));
        }

        private static void flowerBlock(IForgeRegistry<Block> registry, MobEffect effect, int effectDuration, String name) {
            Block flower = new FlowerBlock(effect, effectDuration, BlockBehaviour.Properties.copy(Blocks.POPPY));
            registry.register(setup(flower, name));
            registry.register(setup(new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> flower, BlockBehaviour.Properties.of(Material.DECORATION).strength(0.0F)), "potted_" + name));
        }

        private static void cakeBlock(IForgeRegistry<Block> registry, String name) {
            Block cake = new ModCakeBlock();
            registry.register(setup(cake, name));
            Map<Block, CandleCakeBlock> candleMap = Maps.newHashMap();

            for (Block candle : Utils.CANDLES) {
                CandleCakeBlock candleCake = new ModCandleCakeBlock(cake);
                candleMap.put(candle, candleCake);
                registry.register(setup(candleCake, candle.getRegistryName().getPath() + "_" + name));
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
