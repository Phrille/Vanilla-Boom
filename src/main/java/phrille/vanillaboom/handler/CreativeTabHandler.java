package phrille.vanillaboom.handler;

import com.google.common.collect.Lists;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabHandler {

    @SubscribeEvent
    public static void buildContents(CreativeModeTabEvent.BuildContents event) {
        CreativeModeTab tab = event.getTab();
        MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();

        // Building Blocks
        if (tab == CreativeModeTabs.BUILDING_BLOCKS) {
            remove(entries, List.of(
                    Blocks.CRACKED_STONE_BRICKS,
                    Blocks.CRACKED_NETHER_BRICKS,
                    Blocks.GILDED_BLACKSTONE,
                    Blocks.CHISELED_POLISHED_BLACKSTONE,
                    Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS,
                    Blocks.PURPUR_PILLAR,
                    Blocks.QUARTZ_PILLAR
            ));
            // Wood Blocks
            putAfter(entries, Blocks.OAK_WOOD, List.of(
                    ModItems.OAK_WOOD_STAIRS.get(),
                    ModItems.OAK_WOOD_SLAB.get(),
                    ModItems.OAK_WOOD_FENCE.get(),
                    ModItems.OAK_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_OAK_WOOD, List.of(
                    ModItems.STRIPPED_OAK_WOOD_STAIRS.get(),
                    ModItems.STRIPPED_OAK_WOOD_SLAB.get(),
                    ModItems.STRIPPED_OAK_WOOD_FENCE.get(),
                    ModItems.STRIPPED_OAK_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.OAK_FENCE_GATE, Blocks.BOOKSHELF);
            putAfter(entries, Blocks.OAK_BUTTON, Blocks.LADDER);
            putAfter(entries, Blocks.SPRUCE_WOOD, List.of(
                    ModItems.SPRUCE_WOOD_STAIRS.get(),
                    ModItems.SPRUCE_WOOD_SLAB.get(),
                    ModItems.SPRUCE_WOOD_FENCE.get(),
                    ModItems.SPRUCE_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_SPRUCE_WOOD, List.of(
                    ModItems.STRIPPED_SPRUCE_WOOD_STAIRS.get(),
                    ModItems.STRIPPED_SPRUCE_WOOD_SLAB.get(),
                    ModItems.STRIPPED_SPRUCE_WOOD_FENCE.get(),
                    ModItems.STRIPPED_SPRUCE_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.SPRUCE_FENCE_GATE, ModItems.SPRUCE_BOOKSHELF.get());
            putAfter(entries, Blocks.SPRUCE_BUTTON, ModItems.SPRUCE_LADDER.get());
            putAfter(entries, Blocks.BIRCH_WOOD, List.of(
                    ModItems.BIRCH_WOOD_STAIRS.get(),
                    ModItems.BIRCH_WOOD_SLAB.get(),
                    ModItems.BIRCH_WOOD_FENCE.get(),
                    ModItems.BIRCH_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_BIRCH_WOOD, List.of(
                    ModItems.STRIPPED_BIRCH_WOOD_STAIRS.get(),
                    ModItems.STRIPPED_BIRCH_WOOD_SLAB.get(),
                    ModItems.STRIPPED_BIRCH_WOOD_FENCE.get(),
                    ModItems.STRIPPED_BIRCH_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.BIRCH_FENCE_GATE, ModItems.BIRCH_BOOKSHELF.get());
            putAfter(entries, Blocks.BIRCH_BUTTON, ModItems.BIRCH_LADDER.get());
            putAfter(entries, Blocks.JUNGLE_WOOD, List.of(
                    ModItems.JUNGLE_WOOD_STAIRS.get(),
                    ModItems.JUNGLE_WOOD_SLAB.get(),
                    ModItems.JUNGLE_WOOD_FENCE.get(),
                    ModItems.JUNGLE_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_JUNGLE_WOOD, List.of(
                    ModItems.STRIPPED_JUNGLE_WOOD_STAIRS.get(),
                    ModItems.STRIPPED_JUNGLE_WOOD_SLAB.get(),
                    ModItems.STRIPPED_JUNGLE_WOOD_FENCE.get(),
                    ModItems.STRIPPED_JUNGLE_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.JUNGLE_FENCE_GATE, ModItems.JUNGLE_BOOKSHELF.get());
            putAfter(entries, Blocks.JUNGLE_BUTTON, ModItems.JUNGLE_LADDER.get());
            putAfter(entries, Blocks.ACACIA_WOOD, List.of(
                    ModItems.ACACIA_WOOD_STAIRS.get(),
                    ModItems.ACACIA_WOOD_SLAB.get(),
                    ModItems.ACACIA_WOOD_FENCE.get(),
                    ModItems.ACACIA_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_ACACIA_WOOD, List.of(
                    ModItems.STRIPPED_ACACIA_WOOD_STAIRS.get(),
                    ModItems.STRIPPED_ACACIA_WOOD_SLAB.get(),
                    ModItems.STRIPPED_ACACIA_WOOD_FENCE.get(),
                    ModItems.STRIPPED_ACACIA_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.ACACIA_FENCE_GATE, ModItems.ACACIA_BOOKSHELF.get());
            putAfter(entries, Blocks.ACACIA_BUTTON, ModItems.ACACIA_LADDER.get());
            putAfter(entries, Blocks.DARK_OAK_WOOD, List.of(
                    ModItems.DARK_OAK_WOOD_STAIRS.get(),
                    ModItems.DARK_OAK_WOOD_SLAB.get(),
                    ModItems.DARK_OAK_WOOD_FENCE.get(),
                    ModItems.DARK_OAK_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_DARK_OAK_WOOD, List.of(
                    ModItems.STRIPPED_DARK_OAK_WOOD_STAIRS.get(),
                    ModItems.STRIPPED_DARK_OAK_WOOD_SLAB.get(),
                    ModItems.STRIPPED_DARK_OAK_WOOD_FENCE.get(),
                    ModItems.STRIPPED_DARK_OAK_WOOD_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.DARK_OAK_FENCE_GATE, ModItems.DARK_OAK_BOOKSHELF.get());
            putAfter(entries, Blocks.DARK_OAK_BUTTON, ModItems.DARK_OAK_LADDER.get());
            putAfter(entries, Blocks.CRIMSON_HYPHAE, List.of(
                    ModItems.CRIMSON_HYPHAE_STAIRS.get(),
                    ModItems.CRIMSON_HYPHAE_SLAB.get(),
                    ModItems.CRIMSON_HYPHAE_FENCE.get(),
                    ModItems.CRIMSON_HYPHAE_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_CRIMSON_HYPHAE, List.of(
                    ModItems.STRIPPED_CRIMSON_HYPHAE_STAIRS.get(),
                    ModItems.STRIPPED_CRIMSON_HYPHAE_SLAB.get(),
                    ModItems.STRIPPED_CRIMSON_HYPHAE_FENCE.get(),
                    ModItems.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.CRIMSON_FENCE_GATE, ModItems.CRIMSON_BOOKSHELF.get());
            putAfter(entries, Blocks.CRIMSON_BUTTON, ModItems.CRIMSON_LADDER.get());
            putAfter(entries, Blocks.WARPED_HYPHAE, List.of(
                    ModItems.WARPED_HYPHAE_STAIRS.get(),
                    ModItems.WARPED_HYPHAE_SLAB.get(),
                    ModItems.WARPED_HYPHAE_FENCE.get(),
                    ModItems.WARPED_HYPHAE_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.STRIPPED_WARPED_HYPHAE, List.of(
                    ModItems.STRIPPED_WARPED_HYPHAE_STAIRS.get(),
                    ModItems.STRIPPED_WARPED_HYPHAE_SLAB.get(),
                    ModItems.STRIPPED_WARPED_HYPHAE_FENCE.get(),
                    ModItems.STRIPPED_WARPED_HYPHAE_FENCE_GATE.get()
            ));
            putAfter(entries, Blocks.WARPED_FENCE_GATE, ModItems.WARPED_BOOKSHELF.get());
            putAfter(entries, Blocks.WARPED_BUTTON, ModItems.WARPED_LADDER.get());
            // Stone Blocks
            putAfter(entries, Blocks.STONE_SLAB, ModItems.STONE_WALL.get());
            putAfter(entries, Blocks.MOSSY_COBBLESTONE, List.of(
                    ModItems.COBBLESTONE_BRICKS.get(),
                    ModItems.COBBLESTONE_BRICK_STAIRS.get(),
                    ModItems.COBBLESTONE_BRICK_SLAB.get(),
                    ModItems.COBBLESTONE_BRICK_WALL.get()
            ));
            putBefore(entries, Blocks.SMOOTH_STONE, List.of(
                    ModItems.MOSSY_COBBLESTONE_BRICKS.get(),
                    ModItems.MOSSY_COBBLESTONE_BRICK_STAIRS.get(),
                    ModItems.MOSSY_COBBLESTONE_BRICK_SLAB.get(),
                    ModItems.MOSSY_COBBLESTONE_BRICK_WALL.get()
            ));
            putBefore(entries, Blocks.SMOOTH_STONE_SLAB, ModItems.SMOOTH_STONE_STAIRS.get());
            putAfter(entries, Blocks.SMOOTH_STONE_SLAB, ModItems.SMOOTH_STONE_WALL.get());
            putAfter(entries, Blocks.STONE_BRICK_WALL, List.of(
                    Blocks.CRACKED_STONE_BRICKS,
                    ModItems.CRACKED_STONE_BRICK_STAIRS.get(),
                    ModItems.CRACKED_STONE_BRICK_SLAB.get(),
                    ModItems.CRACKED_STONE_BRICK_WALL.get()
            ));
            putAfter(entries, Blocks.CHISELED_STONE_BRICKS, List.of(
                    ModItems.CHISELED_STONE_BRICK_STAIRS.get(),
                    ModItems.CHISELED_STONE_BRICK_SLAB.get(),
                    ModItems.CHISELED_STONE_BRICK_WALL.get()
            ));
            putAfter(entries, Blocks.POLISHED_GRANITE_SLAB, List.of(
                    ModItems.POLISHED_GRANITE_WALL.get(),
                    ModItems.GRANITE_PILLAR.get()
            ));
            putAfter(entries, Blocks.POLISHED_DIORITE_SLAB, List.of(
                    ModItems.POLISHED_DIORITE_WALL.get(),
                    ModItems.DIORITE_PILLAR.get()
            ));
            putAfter(entries, Blocks.POLISHED_ANDESITE_SLAB, List.of(
                    ModItems.POLISHED_ANDESITE_WALL.get(),
                    ModItems.ANDESITE_PILLAR.get(),
                    ModItems.PERIDOTITE.get(),
                    ModItems.PERIDOTITE_STAIRS.get(),
                    ModItems.PERIDOTITE_SLAB.get(),
                    ModItems.PERIDOTITE_WALL.get(),
                    ModItems.POLISHED_PERIDOTITE.get(),
                    ModItems.POLISHED_PERIDOTITE_STAIRS.get(),
                    ModItems.POLISHED_PERIDOTITE_SLAB.get(),
                    ModItems.POLISHED_PERIDOTITE_WALL.get(),
                    ModItems.PERIDOTITE_PILLAR.get()
            ));
            // Sandstone Blocks
            putAfter(entries, Blocks.CHISELED_SANDSTONE, List.of(
                    ModItems.CHISELED_SANDSTONE_STAIRS.get(),
                    ModItems.CHISELED_SANDSTONE_SLAB.get(),
                    ModItems.CHISELED_SANDSTONE_WALL.get()
            ));
            putAfter(entries, Blocks.SMOOTH_SANDSTONE_SLAB, ModItems.SMOOTH_SANDSTONE_WALL.get());
            putAfter(entries, Blocks.CUT_SANDSTONE, ModItems.CUT_SANDSTONE_STAIRS.get());
            putAfter(entries, Blocks.CUT_SANDSTONE_SLAB, ModItems.CUT_SANDSTONE_WALL.get());
            putAfter(entries, Blocks.CHISELED_RED_SANDSTONE, List.of(
                    ModItems.CHISELED_RED_SANDSTONE_STAIRS.get(),
                    ModItems.CHISELED_RED_SANDSTONE_SLAB.get(),
                    ModItems.CHISELED_RED_SANDSTONE_WALL.get()
            ));
            putAfter(entries, Blocks.SMOOTH_RED_SANDSTONE_SLAB, ModItems.SMOOTH_RED_SANDSTONE_WALL.get());
            putAfter(entries, Blocks.CUT_RED_SANDSTONE, ModItems.CUT_RED_SANDSTONE_STAIRS.get());
            putAfter(entries, Blocks.CUT_RED_SANDSTONE_SLAB, ModItems.CUT_RED_SANDSTONE_WALL.get());
            // Prismarine Blocks
            putAfter(entries, Blocks.PRISMARINE_WALL, List.of(
                    ModItems.POLISHED_PRISMARINE.get(),
                    ModItems.POLISHED_PRISMARINE_STAIRS.get(),
                    ModItems.POLISHED_PRISMARINE_SLAB.get(),
                    ModItems.POLISHED_PRISMARINE_WALL.get()
            ));
            putAfter(entries, Blocks.PRISMARINE_BRICK_SLAB, List.of(ModItems.PRISMARINE_BRICK_WALL.get(), ModItems.PRISMARINE_PILLAR.get()));
            putAfter(entries, Blocks.DARK_PRISMARINE_SLAB, List.of(
                    ModItems.DARK_PRISMARINE_WALL.get(),
                    ModItems.POLISHED_DARK_PRISMARINE.get(),
                    ModItems.POLISHED_DARK_PRISMARINE_STAIRS.get(),
                    ModItems.POLISHED_DARK_PRISMARINE_SLAB.get(),
                    ModItems.POLISHED_DARK_PRISMARINE_WALL.get(),
                    ModItems.DARK_PRISMARINE_PILLAR.get(),
                    ModItems.HYDRO_ROCK.get(),
                    ModItems.HYDRO_ROCK_STAIRS.get(),
                    ModItems.HYDRO_ROCK_SLAB.get(),
                    ModItems.HYDRO_ROCK_WALL.get(),
                    ModItems.PRISMARINE_CRYSTAL_BLOCK.get()
            ));
            // Nether Blocks
            putBefore(entries, Blocks.NETHERRACK, List.of(
                    Blocks.OBSIDIAN,
                    ModItems.OBSIDIAN_STAIRS.get(),
                    ModItems.OBSIDIAN_SLAB.get(),
                    ModItems.OBSIDIAN_WALL.get(),
                    ModItems.OBSIDIAN_BRICKS.get(),
                    ModItems.OBSIDIAN_BRICK_STAIRS.get(),
                    ModItems.OBSIDIAN_BRICK_SLAB.get(),
                    ModItems.OBSIDIAN_BRICK_WALL.get(),
                    ModItems.CHISELED_OBSIDIAN.get(),
                    ModItems.CHISELED_OBSIDIAN_STAIRS.get(),
                    ModItems.CHISELED_OBSIDIAN_SLAB.get(),
                    ModItems.CHISELED_OBSIDIAN_WALL.get(),
                    ModItems.OBSIDIAN_PILLAR.get()
            ));
            putAfter(entries, Blocks.NETHERRACK, List.of(
                    ModItems.NETHERRACK_STAIRS.get(),
                    ModItems.NETHERRACK_SLAB.get(),
                    ModItems.NETHERRACK_WALL.get(),
                    ModItems.POLISHED_NETHERRACK.get(),
                    ModItems.POLISHED_NETHERRACK_STAIRS.get(),
                    ModItems.POLISHED_NETHERRACK_SLAB.get(),
                    ModItems.POLISHED_NETHERRACK_WALL.get(),
                    ModItems.NETHERRACK_PILLAR.get()
            ));
            putAfter(entries, Blocks.NETHER_BRICK_FENCE, List.of(
                    ModItems.NETHER_BRICK_FENCE_GATE.get(),
                    Blocks.CRACKED_NETHER_BRICKS,
                    ModItems.CRACKED_NETHER_BRICK_STAIRS.get(),
                    ModItems.CRACKED_NETHER_BRICK_SLAB.get(),
                    ModItems.CRACKED_NETHER_BRICK_WALL.get()
            ));
            putAfter(entries, Blocks.CHISELED_NETHER_BRICKS, List.of(
                    ModItems.CHISELED_NETHER_BRICK_STAIRS.get(),
                    ModItems.CHISELED_NETHER_BRICK_SLAB.get(),
                    ModItems.CHISELED_NETHER_BRICK_WALL.get()
            ));
            putAfter(entries, Blocks.RED_NETHER_BRICK_WALL, List.of(
                    ModItems.RED_NETHER_BRICK_FENCE.get(),
                    ModItems.RED_NETHER_BRICK_FENCE_GATE.get(),
                    ModItems.CRACKED_RED_NETHER_BRICKS.get(),
                    ModItems.CRACKED_RED_NETHER_BRICK_STAIRS.get(),
                    ModItems.CRACKED_RED_NETHER_BRICK_SLAB.get(),
                    ModItems.CRACKED_RED_NETHER_BRICK_WALL.get(),
                    ModItems.CHISELED_RED_NETHER_BRICKS.get(),
                    ModItems.CHISELED_RED_NETHER_BRICK_STAIRS.get(),
                    ModItems.CHISELED_RED_NETHER_BRICK_SLAB.get(),
                    ModItems.CHISELED_RED_NETHER_BRICK_WALL.get(),
                    ModItems.RED_NETHER_PILLAR.get()
            ));
            putBefore(entries, Blocks.BASALT, List.of(
                    Blocks.MAGMA_BLOCK,
                    ModItems.MAGMA_BRICKS.get(),
                    ModItems.MAGMA_BRICK_STAIRS.get(),
                    ModItems.MAGMA_BRICK_SLAB.get(),
                    ModItems.MAGMA_BRICK_WALL.get(),
                    ModItems.INFERNAL_ROCK.get(),
                    ModItems.INFERNAL_ROCK_STAIRS.get(),
                    ModItems.INFERNAL_ROCK_SLAB.get(),
                    ModItems.INFERNAL_ROCK_WALL.get(),
                    ModItems.MAGMA_CREAM_BLOCK.get(),
                    ModItems.BLAZE_POWDER_BLOCK.get()
            ));
            putAfter(entries, Blocks.POLISHED_BLACKSTONE_BRICK_WALL, List.of(
                    Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS,
                    ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(),
                    ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get(),
                    ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get(),
                    Blocks.CHISELED_POLISHED_BLACKSTONE,
                    ModItems.CHISELED_POLISHED_BLACKSTONE_STAIRS.get(),
                    ModItems.CHISELED_POLISHED_BLACKSTONE_SLAB.get(),
                    ModItems.CHISELED_POLISHED_BLACKSTONE_WALL.get(),
                    Blocks.GILDED_BLACKSTONE
            ));
            // End Blocks
            putAfter(entries, Blocks.END_STONE, List.of(
                    ModItems.END_STONE_STAIRS.get(),
                    ModItems.END_STONE_SLAB.get(),
                    ModItems.END_STONE_WALL.get(),
                    ModItems.POLISHED_END_STONE.get(),
                    ModItems.POLISHED_END_STONE_STAIRS.get(),
                    ModItems.POLISHED_END_STONE_SLAB.get(),
                    ModItems.POLISHED_END_STONE_WALL.get()
            ));
            putAfter(entries, Blocks.END_STONE_BRICK_WALL, ModItems.END_STONE_PILLAR.get());
            putAfter(entries, Blocks.PURPUR_SLAB, List.of(
                    ModItems.PURPUR_BLOCK_WALL.get(),
                    ModItems.CHISELED_PURPUR_BLOCK.get(),
                    ModItems.CHISELED_PURPUR_BLOCK_STAIRS.get(),
                    ModItems.CHISELED_PURPUR_BLOCK_SLAB.get(),
                    ModItems.CHISELED_PURPUR_BLOCK_WALL.get(),
                    Blocks.PURPUR_PILLAR
            ));
            // Storage Blocks
            putAfter(entries, Blocks.COAL_BLOCK, ModItems.CHARCOAL_BLOCK.get());
            putAfter(entries, Blocks.IRON_BLOCK, List.of(
                    ModItems.IRON_BLOCK_STAIRS.get(),
                    ModItems.IRON_BLOCK_SLAB.get(),
                    ModItems.IRON_BLOCK_WALL.get()
            ));
            putAfter(entries, Blocks.GOLD_BLOCK, List.of(
                    ModItems.GOLD_BLOCK_STAIRS.get(),
                    ModItems.GOLD_BLOCK_SLAB.get(),
                    ModItems.GOLD_BLOCK_WALL.get(),
                    ModItems.GOLD_BARS.get()
            ));
            putAfter(entries, Blocks.NETHERITE_BLOCK, List.of(
                    ModItems.SUGAR_CANE_BLOCK.get(),
                    ModItems.SUGAR_BLOCK.get(),
                    ModItems.GUNPOWDER_BLOCK.get()
            ));
            // Quartz Blocks
            putAfter(entries, Blocks.QUARTZ_SLAB, ModItems.QUARTZ_BLOCK_WALL.get());
            putAfter(entries, Blocks.CHISELED_QUARTZ_BLOCK, List.of(
                    ModItems.CHISELED_QUARTZ_BLOCK_STAIRS.get(),
                    ModItems.CHISELED_QUARTZ_BLOCK_SLAB.get(),
                    ModItems.CHISELED_QUARTZ_BLOCK_WALL.get()
            ));
            putAfter(entries, Blocks.QUARTZ_BRICKS, List.of(
                    ModItems.QUARTZ_BRICK_STAIRS.get(),
                    ModItems.QUARTZ_BRICK_SLAB.get(),
                    ModItems.QUARTZ_BRICK_WALL.get()
            ));
            putAfter(entries, Blocks.SMOOTH_QUARTZ_SLAB, List.of(ModItems.SMOOTH_QUARTZ_WALL.get(), Blocks.QUARTZ_PILLAR));
            // Snow Bricks
            putBefore(entries, Blocks.AMETHYST_BLOCK, List.of(
                    Blocks.SNOW_BLOCK,
                    ModItems.SNOW_BRICKS.get(),
                    ModItems.SNOW_BRICK_STAIRS.get(),
                    ModItems.SNOW_BRICK_SLAB.get(),
                    ModItems.SNOW_BRICK_WALL.get()
            ));
            // Bedrock
            put(entries, List.of(
                    Blocks.BEDROCK,
                    ModItems.BEDROCK_STAIRS.get(),
                    ModItems.BEDROCK_SLAB.get(),
                    ModItems.BEDROCK_WALL.get()
            ));
        }

        // Colored Blocks
        if (tab == CreativeModeTabs.COLORED_BLOCKS) {
            putAfter(entries, Blocks.PINK_TERRACOTTA, List.of(
                    ModItems.TERRACOTTA_STAIRS.get(),
                    ModItems.WHITE_TERRACOTTA_STAIRS.get(),
                    ModItems.LIGHT_GRAY_TERRACOTTA_STAIRS.get(),
                    ModItems.GRAY_TERRACOTTA_STAIRS.get(),
                    ModItems.BLACK_TERRACOTTA_STAIRS.get(),
                    ModItems.BROWN_TERRACOTTA_STAIRS.get(),
                    ModItems.RED_TERRACOTTA_STAIRS.get(),
                    ModItems.ORANGE_TERRACOTTA_STAIRS.get(),
                    ModItems.YELLOW_TERRACOTTA_STAIRS.get(),
                    ModItems.LIME_TERRACOTTA_STAIRS.get(),
                    ModItems.GREEN_TERRACOTTA_STAIRS.get(),
                    ModItems.CYAN_TERRACOTTA_STAIRS.get(),
                    ModItems.LIGHT_BLUE_TERRACOTTA_STAIRS.get(),
                    ModItems.BLUE_TERRACOTTA_STAIRS.get(),
                    ModItems.PURPLE_TERRACOTTA_STAIRS.get(),
                    ModItems.MAGENTA_TERRACOTTA_STAIRS.get(),
                    ModItems.PINK_TERRACOTTA_STAIRS.get(),
                    ModItems.TERRACOTTA_SLAB.get(),
                    ModItems.WHITE_TERRACOTTA_SLAB.get(),
                    ModItems.LIGHT_GRAY_TERRACOTTA_SLAB.get(),
                    ModItems.GRAY_TERRACOTTA_SLAB.get(),
                    ModItems.BLACK_TERRACOTTA_SLAB.get(),
                    ModItems.BROWN_TERRACOTTA_SLAB.get(),
                    ModItems.RED_TERRACOTTA_SLAB.get(),
                    ModItems.ORANGE_TERRACOTTA_SLAB.get(),
                    ModItems.YELLOW_TERRACOTTA_SLAB.get(),
                    ModItems.LIME_TERRACOTTA_SLAB.get(),
                    ModItems.GREEN_TERRACOTTA_SLAB.get(),
                    ModItems.CYAN_TERRACOTTA_SLAB.get(),
                    ModItems.LIGHT_BLUE_TERRACOTTA_SLAB.get(),
                    ModItems.BLUE_TERRACOTTA_SLAB.get(),
                    ModItems.PURPLE_TERRACOTTA_SLAB.get(),
                    ModItems.MAGENTA_TERRACOTTA_SLAB.get(),
                    ModItems.PINK_TERRACOTTA_SLAB.get(),
                    ModItems.TERRACOTTA_WALL.get(),
                    ModItems.WHITE_TERRACOTTA_WALL.get(),
                    ModItems.LIGHT_GRAY_TERRACOTTA_WALL.get(),
                    ModItems.GRAY_TERRACOTTA_WALL.get(),
                    ModItems.BLACK_TERRACOTTA_WALL.get(),
                    ModItems.BROWN_TERRACOTTA_WALL.get(),
                    ModItems.RED_TERRACOTTA_WALL.get(),
                    ModItems.ORANGE_TERRACOTTA_WALL.get(),
                    ModItems.YELLOW_TERRACOTTA_WALL.get(),
                    ModItems.LIME_TERRACOTTA_WALL.get(),
                    ModItems.GREEN_TERRACOTTA_WALL.get(),
                    ModItems.CYAN_TERRACOTTA_WALL.get(),
                    ModItems.LIGHT_BLUE_TERRACOTTA_WALL.get(),
                    ModItems.BLUE_TERRACOTTA_WALL.get(),
                    ModItems.PURPLE_TERRACOTTA_WALL.get(),
                    ModItems.MAGENTA_TERRACOTTA_WALL.get(),
                    ModItems.PINK_TERRACOTTA_WALL.get(),
                    ModItems.TERRACOTTA_BRICKS.get(),
                    ModItems.WHITE_TERRACOTTA_BRICKS.get(),
                    ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get(),
                    ModItems.GRAY_TERRACOTTA_BRICKS.get(),
                    ModItems.BLACK_TERRACOTTA_BRICKS.get(),
                    ModItems.BROWN_TERRACOTTA_BRICKS.get(),
                    ModItems.RED_TERRACOTTA_BRICKS.get(),
                    ModItems.ORANGE_TERRACOTTA_BRICKS.get(),
                    ModItems.YELLOW_TERRACOTTA_BRICKS.get(),
                    ModItems.LIME_TERRACOTTA_BRICKS.get(),
                    ModItems.GREEN_TERRACOTTA_BRICKS.get(),
                    ModItems.CYAN_TERRACOTTA_BRICKS.get(),
                    ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get(),
                    ModItems.BLUE_TERRACOTTA_BRICKS.get(),
                    ModItems.PURPLE_TERRACOTTA_BRICKS.get(),
                    ModItems.MAGENTA_TERRACOTTA_BRICKS.get(),
                    ModItems.PINK_TERRACOTTA_BRICKS.get(),
                    ModItems.TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.WHITE_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.GRAY_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.BLACK_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.BROWN_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.RED_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.ORANGE_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.YELLOW_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.LIME_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.GREEN_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.CYAN_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.BLUE_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.PURPLE_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.PINK_TERRACOTTA_BRICK_STAIRS.get(),
                    ModItems.TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.WHITE_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.GRAY_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.BLACK_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.BROWN_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.RED_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.ORANGE_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.YELLOW_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.LIME_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.GREEN_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.CYAN_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.BLUE_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.PURPLE_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.MAGENTA_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.PINK_TERRACOTTA_BRICK_SLAB.get(),
                    ModItems.TERRACOTTA_BRICK_WALL.get(),
                    ModItems.WHITE_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.GRAY_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.BLACK_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.BROWN_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.RED_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.ORANGE_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.YELLOW_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.LIME_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.GREEN_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.CYAN_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.BLUE_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.PURPLE_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.MAGENTA_TERRACOTTA_BRICK_WALL.get(),
                    ModItems.PINK_TERRACOTTA_BRICK_WALL.get()
            ));
            putAfter(entries, Blocks.PINK_CONCRETE, List.of(
                    ModItems.WHITE_CONCRETE_STAIRS.get(),
                    ModItems.LIGHT_GRAY_CONCRETE_STAIRS.get(),
                    ModItems.GRAY_CONCRETE_STAIRS.get(),
                    ModItems.BLACK_CONCRETE_STAIRS.get(),
                    ModItems.BROWN_CONCRETE_STAIRS.get(),
                    ModItems.RED_CONCRETE_STAIRS.get(),
                    ModItems.ORANGE_CONCRETE_STAIRS.get(),
                    ModItems.YELLOW_CONCRETE_STAIRS.get(),
                    ModItems.LIME_CONCRETE_STAIRS.get(),
                    ModItems.GREEN_CONCRETE_STAIRS.get(),
                    ModItems.CYAN_CONCRETE_STAIRS.get(),
                    ModItems.LIGHT_BLUE_CONCRETE_STAIRS.get(),
                    ModItems.BLUE_CONCRETE_STAIRS.get(),
                    ModItems.PURPLE_CONCRETE_STAIRS.get(),
                    ModItems.MAGENTA_CONCRETE_STAIRS.get(),
                    ModItems.PINK_CONCRETE_STAIRS.get(),
                    ModItems.WHITE_CONCRETE_SLAB.get(),
                    ModItems.LIGHT_GRAY_CONCRETE_SLAB.get(),
                    ModItems.GRAY_CONCRETE_SLAB.get(),
                    ModItems.BLACK_CONCRETE_SLAB.get(),
                    ModItems.BROWN_CONCRETE_SLAB.get(),
                    ModItems.RED_CONCRETE_SLAB.get(),
                    ModItems.ORANGE_CONCRETE_SLAB.get(),
                    ModItems.YELLOW_CONCRETE_SLAB.get(),
                    ModItems.LIME_CONCRETE_SLAB.get(),
                    ModItems.GREEN_CONCRETE_SLAB.get(),
                    ModItems.CYAN_CONCRETE_SLAB.get(),
                    ModItems.LIGHT_BLUE_CONCRETE_SLAB.get(),
                    ModItems.BLUE_CONCRETE_SLAB.get(),
                    ModItems.PURPLE_CONCRETE_SLAB.get(),
                    ModItems.MAGENTA_CONCRETE_SLAB.get(),
                    ModItems.PINK_CONCRETE_SLAB.get(),
                    ModItems.WHITE_CONCRETE_WALL.get(),
                    ModItems.LIGHT_GRAY_CONCRETE_WALL.get(),
                    ModItems.GRAY_CONCRETE_WALL.get(),
                    ModItems.BLACK_CONCRETE_WALL.get(),
                    ModItems.BROWN_CONCRETE_WALL.get(),
                    ModItems.RED_CONCRETE_WALL.get(),
                    ModItems.ORANGE_CONCRETE_WALL.get(),
                    ModItems.YELLOW_CONCRETE_WALL.get(),
                    ModItems.LIME_CONCRETE_WALL.get(),
                    ModItems.GREEN_CONCRETE_WALL.get(),
                    ModItems.CYAN_CONCRETE_WALL.get(),
                    ModItems.LIGHT_BLUE_CONCRETE_WALL.get(),
                    ModItems.BLUE_CONCRETE_WALL.get(),
                    ModItems.PURPLE_CONCRETE_WALL.get(),
                    ModItems.MAGENTA_CONCRETE_WALL.get(),
                    ModItems.PINK_CONCRETE_WALL.get()
            ));
            putAfter(entries, Blocks.PINK_GLAZED_TERRACOTTA, List.of(
                    ModItems.WHITE_DYE_BLOCK.get(),
                    ModItems.LIGHT_GRAY_DYE_BLOCK.get(),
                    ModItems.GRAY_DYE_BLOCK.get(),
                    ModItems.BLACK_DYE_BLOCK.get(),
                    ModItems.BROWN_DYE_BLOCK.get(),
                    ModItems.RED_DYE_BLOCK.get(),
                    ModItems.ORANGE_DYE_BLOCK.get(),
                    ModItems.YELLOW_DYE_BLOCK.get(),
                    ModItems.LIME_DYE_BLOCK.get(),
                    ModItems.GREEN_DYE_BLOCK.get(),
                    ModItems.CYAN_DYE_BLOCK.get(),
                    ModItems.LIGHT_BLUE_DYE_BLOCK.get(),
                    ModItems.BLUE_DYE_BLOCK.get(),
                    ModItems.PURPLE_DYE_BLOCK.get(),
                    ModItems.MAGENTA_DYE_BLOCK.get(),
                    ModItems.PINK_DYE_BLOCK.get()
            ));
            putAfter(entries, Blocks.PINK_STAINED_GLASS_PANE, List.of(
                    ModItems.SOUL_GLASS.get(),
                    ModItems.WHITE_STAINED_SOUL_GLASS.get(),
                    ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS.get(),
                    ModItems.GRAY_STAINED_SOUL_GLASS.get(),
                    ModItems.BLACK_STAINED_SOUL_GLASS.get(),
                    ModItems.BROWN_STAINED_SOUL_GLASS.get(),
                    ModItems.RED_STAINED_SOUL_GLASS.get(),
                    ModItems.ORANGE_STAINED_SOUL_GLASS.get(),
                    ModItems.YELLOW_STAINED_SOUL_GLASS.get(),
                    ModItems.LIME_STAINED_SOUL_GLASS.get(),
                    ModItems.GREEN_STAINED_SOUL_GLASS.get(),
                    ModItems.CYAN_STAINED_SOUL_GLASS.get(),
                    ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS.get(),
                    ModItems.BLUE_STAINED_SOUL_GLASS.get(),
                    ModItems.PURPLE_STAINED_SOUL_GLASS.get(),
                    ModItems.MAGENTA_STAINED_SOUL_GLASS.get(),
                    ModItems.PINK_STAINED_SOUL_GLASS.get(),
                    ModItems.SOUL_GLASS_PANE.get(),
                    ModItems.WHITE_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.GRAY_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.BLACK_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.BROWN_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.RED_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.ORANGE_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.YELLOW_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.LIME_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.GREEN_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.CYAN_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.BLUE_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.PURPLE_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.MAGENTA_STAINED_SOUL_GLASS_PANE.get(),
                    ModItems.PINK_STAINED_SOUL_GLASS_PANE.get()
            ));
        }

        // Natural Blocks
        if (tab == CreativeModeTabs.NATURAL_BLOCKS) {
            putAfter(entries, Blocks.ANDESITE, ModItems.PERIDOTITE.get());
            putAfter(entries, Blocks.PRISMARINE, ModItems.HYDRO_ROCK.get());
            putAfter(entries, Blocks.SOUL_SOIL, List.of(ModItems.BONE_SAND.get(), ModItems.WITHER_BONE_SAND.get()));
            putAfter(entries, Blocks.SMOOTH_BASALT, ModItems.INFERNAL_ROCK.get());
            putAfter(entries, Blocks.LILY_OF_THE_VALLEY, ModItems.ROSE.get());
            putAfter(entries, Blocks.ROSE_BUSH, ModItems.SHEARED_ROSE_BUSH.get());
            putAfter(entries, Items.BEETROOT_SEEDS, List.of(ModItems.TOMATO_SEEDS.get(), ModItems.RICE_SEEDS.get()));
            putAfter(entries, Blocks.VINE, ModItems.WITHERED_VINE.get());
        }

        // Functional Blocks
        if (tab == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            putAfter(entries, Blocks.LADDER, List.of(
                    ModItems.SPRUCE_LADDER.get(),
                    ModItems.BIRCH_LADDER.get(),
                    ModItems.JUNGLE_LADDER.get(),
                    ModItems.ACACIA_LADDER.get(),
                    ModItems.DARK_OAK_LADDER.get(),
                    ModItems.CRIMSON_LADDER.get(),
                    ModItems.WARPED_LADDER.get(),
                    ModItems.TRELLIS.get()
            ));
            putAfter(entries, Items.PAINTING, List.of(
                    ModItems.KEBAB_PAINTING.get(),
                    ModItems.AZTEC_PAINTING.get(),
                    ModItems.ALBAN_PAINTING.get(),
                    ModItems.AZTEC2_PAINTING.get(),
                    ModItems.BOMB_PAINTING.get(),
                    ModItems.PLANT_PAINTING.get(),
                    ModItems.WASTELAND_PAINTING.get(),
                    ModItems.POOL_PAINTING.get(),
                    ModItems.COURBET_PAINTING.get(),
                    ModItems.SEA_PAINTING.get(),
                    ModItems.SUNSET_PAINTING.get(),
                    ModItems.CREEBET_PAINTING.get(),
                    ModItems.WANDERER_PAINTING.get(),
                    ModItems.GRAHAM_PAINTING.get(),
                    ModItems.MATCH_PAINTING.get(),
                    ModItems.BUST_PAINTING.get(),
                    ModItems.STAGE_PAINTING.get(),
                    ModItems.VOID_PAINTING.get(),
                    ModItems.SKULL_AND_ROSES_PAINTING.get(),
                    ModItems.WITHER_PAINTING.get(),
                    ModItems.FIGHTERS_PAINTING.get(),
                    ModItems.POINTER_PAINTING.get(),
                    ModItems.PIGSCENE_PAINTING.get(),
                    ModItems.BURNING_SKULL_PAINTING.get(),
                    ModItems.SKELETON_PAINTING.get(),
                    ModItems.DONKEY_KONG_PAINTING.get()
            ));
            putAfter(entries, Blocks.BOOKSHELF, List.of(
                    ModItems.SPRUCE_BOOKSHELF.get(),
                    ModItems.BIRCH_BOOKSHELF.get(),
                    ModItems.JUNGLE_BOOKSHELF.get(),
                    ModItems.ACACIA_BOOKSHELF.get(),
                    ModItems.DARK_OAK_BOOKSHELF.get(),
                    ModItems.CRIMSON_BOOKSHELF.get(),
                    ModItems.WARPED_BOOKSHELF.get()
            ));
        }

        // Redstone Blocks
        if (tab == CreativeModeTabs.REDSTONE_BLOCKS) {
            putAfter(entries, Blocks.DAYLIGHT_DETECTOR, ModItems.RAIN_DETECTOR.get());
        }

        // Tools & Utilities
        if (tab == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            putAfter(entries, Items.TROPICAL_FISH_BUCKET, List.of(
                    ModItems.PERCH_BUCKET.get(),
                    ModItems.PIKE_BUCKET.get(),
                    ModItems.TUNA_BUCKET.get(),
                    ModItems.EEL_BUCKET.get()
            ));
            putAfter(entries, Items.BONE_MEAL, ModItems.WITHER_BONE_MEAL.get());
        }

        // Combat
        if (tab == CreativeModeTabs.COMBAT) {
            putAfter(entries, Items.SPECTRAL_ARROW, ModItems.PRISMARINE_ARROW.get());
        }

        // Food & Drinks
        if (tab == CreativeModeTabs.FOOD_AND_DRINKS) {
            putAfter(entries, Items.BEETROOT, List.of(ModItems.TOMATO.get(), ModItems.PINE_CONE.get()));
            putAfter(entries, Items.COOKED_PORKCHOP, List.of(ModItems.RAW_POLAR_BEAR_MEAT.get(), ModItems.POLAR_BEAR_STEAK.get()));
            putAfter(entries, Items.COOKED_SALMON, List.of(
                    ModItems.PERCH.get(),
                    ModItems.COOKED_PERCH.get(),
                    ModItems.PIKE.get(),
                    ModItems.COOKED_PIKE.get(),
                    ModItems.TUNA.get(),
                    ModItems.COOKED_TUNA.get(),
                    ModItems.EEL.get(),
                    ModItems.COOKED_EEL.get()
            ));
            putBefore(entries, Items.BREAD, ModItems.COOKED_EGG.get());
            putAfter(entries, Items.COOKIE, List.of(ModItems.CHOCOLATE.get(), ModItems.MELON_POPSICLE.get()));
            putAfter(entries, Items.CAKE, List.of(ModItems.CHOCOLATE_CAKE.get(), ModItems.BERRY_CAKE.get(), ModItems.CARROT_CAKE.get()));
            putAfter(entries, Items.PUMPKIN_PIE, List.of(ModItems.APPLE_PIE.get(), ModItems.BERRY_PIE.get(), ModItems.MONSTER_PIE.get()));
            putAfter(entries, Items.ROTTEN_FLESH, ModItems.DROWNED_FLESH.get());
            putBefore(entries, Items.MUSHROOM_STEW, ModItems.RICE_BOWL.get());
            putAfter(entries, Items.RABBIT_STEW, List.of(ModItems.POTATO_SOUP.get(), ModItems.MEAT_SOUP.get(), ModItems.FISH_SOUP.get()));
        }

        // Ingredients
        if (tab == CreativeModeTabs.INGREDIENTS) {
            putAfter(entries, Items.BONE, ModItems.WITHER_BONE.get());
            putAfter(entries, Items.BONE_MEAL, ModItems.WITHER_BONE_MEAL.get());
            putAfter(entries, Items.LEATHER, ModItems.POLAR_BEAR_FUR.get());
            putAfter(entries, Items.NETHER_BRICK, ModItems.MAGMA_BRICK.get());
            putAfter(entries, Items.PAPER, ModItems.CANVAS.get());
        }

        // Spawn Eggs
        if (tab == CreativeModeTabs.SPAWN_EGGS) {
            putBefore(entries, Items.ELDER_GUARDIAN_SPAWN_EGG, ModItems.EEL_SPAWN_EGG.get());
            putBefore(entries, Items.PHANTOM_SPAWN_EGG, ModItems.PERCH_SPAWN_EGG.get());
            putBefore(entries, Items.PILLAGER_SPAWN_EGG, ModItems.PIKE_SPAWN_EGG.get());
            putBefore(entries, Items.TURTLE_SPAWN_EGG, ModItems.TUNA_SPAWN_EGG.get());
        }
    }

    private static void put(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, List<ItemLike> items) {
        items.forEach(item -> entries.put(new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void putAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, ItemLike before, List<ItemLike> afterItems) {
        Lists.reverse(afterItems).forEach(after -> putAfter(entries, before, after));
    }

    private static void putAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, ItemLike before, ItemLike after) {
        entries.putAfter(new ItemStack(before), new ItemStack(after), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void putBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, ItemLike after, List<ItemLike> beforeItems) {
        beforeItems.forEach(before -> putBefore(entries, after, before));
    }

    private static void putBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, ItemLike after, ItemLike before) {
        entries.putBefore(new ItemStack(after), new ItemStack(before), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void remove(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, List<ItemLike> items) {
        items.forEach(item -> remove(entries, item));
    }

    private static void remove(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, ItemLike item) {
        entries.remove(new ItemStack(item));
    }
}
