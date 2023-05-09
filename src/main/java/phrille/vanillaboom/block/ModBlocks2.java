package phrille.vanillaboom.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.util.Names;
import phrille.vanillaboom.util.Utils;

public class ModBlocks2 {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VanillaBoom.MOD_ID);

    //Bricks
    public static final RegistryObject<Block> COBBLESTONE_BRICKS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICKS = BLOCKS.register("mossy_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE)));
    public static final RegistryObject<Block> MAGMA_BRICKS = BLOCKS.register("magma_bricks", () -> new MagmaBlock(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK)));
    public static final RegistryObject<Block> OBSIDIAN_BRICKS = BLOCKS.register("obsidian_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    public static final RegistryObject<Block> SNOW_BRICKS = BLOCKS.register("snow_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SNOW)));
    public static final RegistryObject<Block> TERRACOTTA_BRICKS = BLOCKS.register("terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)));
    public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICKS = BLOCKS.register("white_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)));
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICKS = BLOCKS.register("orange_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ORANGE_TERRACOTTA)));
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICKS = BLOCKS.register("magenta_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MAGENTA_TERRACOTTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICKS = BLOCKS.register("light_blue_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICKS = BLOCKS.register("yellow_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.YELLOW_TERRACOTTA)));
    public static final RegistryObject<Block> LIME_TERRACOTTA_BRICKS = BLOCKS.register("lime_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIME_TERRACOTTA)));
    public static final RegistryObject<Block> PINK_TERRACOTTA_BRICKS = BLOCKS.register("pink_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.PINK_TERRACOTTA)));
    public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICKS = BLOCKS.register("gray_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRAY_TERRACOTTA)));
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICKS = BLOCKS.register("light_gray_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICKS = BLOCKS.register("cyan_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CYAN_TERRACOTTA)));
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICKS = BLOCKS.register("purple_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPLE_TERRACOTTA)));
    public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICKS = BLOCKS.register("blue_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_TERRACOTTA)));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICKS = BLOCKS.register("brown_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BROWN_TERRACOTTA)));
    public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICKS = BLOCKS.register("green_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GREEN_TERRACOTTA)));
    public static final RegistryObject<Block> RED_TERRACOTTA_BRICKS = BLOCKS.register("red_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));
    public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICKS = BLOCKS.register("black_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACK_TERRACOTTA)));

    //Rocks
    public static final RegistryObject<Block> PERIDOTITE = BLOCKS.register("peridotite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> HYDRO_ROCK = BLOCKS.register("hydro_rock", HydroRockBlock::new);
    public static final RegistryObject<Block> INFERNAL_ROCK = BLOCKS.register("infernal_rock", InfernalRockBlock::new);

    //Sand and Gravel
    public static final RegistryObject<Block> BONE_SAND = BLOCKS.register("bone_sand", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SNOW).strength(0.5F, 0.0F).sound(SoundType.SOUL_SAND).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WITHER_BONE_SAND = BLOCKS.register("wither_bone_sand", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_BLACK).strength(0.5F, 0.0F).sound(SoundType.SOUL_SAND).requiresCorrectToolForDrops()));

    //Polished
    public static final RegistryObject<Block> POLISHED_PERIDOTITE = BLOCKS.register("polished_peridotite", () -> new Block(BlockBehaviour.Properties.copy(PERIDOTITE.get())));
    public static final RegistryObject<Block> POLISHED_PRISMARINE = BLOCKS.register("polished_prismarine", () -> new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<Block> POLISHED_DARK_PRISMARINE = BLOCKS.register("polished_dark_prismarine", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE)));
    public static final RegistryObject<Block> POLISHED_END_STONE = BLOCKS.register("polished_end_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> POLISHED_NETHERRACK = BLOCKS.register("polished_netherrack", () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)));

    //Chiseled and cracked
    public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICKS = BLOCKS.register("cracked_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS)));
    public static final RegistryObject<Block> CHISELED_RED_NETHER_BRICKS = BLOCKS.register("chiseled_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS)));
    public static final RegistryObject<Block> CHISELED_PURPUR_BLOCK = BLOCKS.register("chiseled_purpur_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK)));
    public static final RegistryObject<Block> CHISELED_OBSIDIAN = BLOCKS.register("chiseled_obsidian", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));

    //Pillars
    public static final RegistryObject<Block> GRANITE_PILLAR = BLOCKS.register("granite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_GRANITE)));
    public static final RegistryObject<Block> DIORITE_PILLAR = BLOCKS.register("diorite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE)));
    public static final RegistryObject<Block> ANDESITE_PILLAR = BLOCKS.register("andesite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE)));
    public static final RegistryObject<Block> PERIDOTITE_PILLAR = BLOCKS.register("peridotite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(POLISHED_PERIDOTITE.get())));
    public static final RegistryObject<Block> PRISMARINE_PILLAR = BLOCKS.register("prismarine_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(POLISHED_PRISMARINE.get())));
    public static final RegistryObject<Block> DARK_PRISMARINE_PILLAR = BLOCKS.register("dark_prismarine_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(POLISHED_DARK_PRISMARINE.get())));
    public static final RegistryObject<Block> END_STONE_PILLAR = BLOCKS.register("end_stone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(POLISHED_END_STONE.get())));
    public static final RegistryObject<Block> NETHERRACK_PILLAR = BLOCKS.register("netherrack_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(POLISHED_NETHERRACK.get())));
    public static final RegistryObject<Block> RED_NETHER_PILLAR = BLOCKS.register("red_nether_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS)));
    public static final RegistryObject<Block> OBSIDIAN_PILLAR = BLOCKS.register("obsidian_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));

    //Wood Variations
    public static final RegistryObject<Block> SPRUCE_BOOKSHELF = BLOCKS.register("spruce_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> BIRCH_BOOKSHELF = BLOCKS.register("birch_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_BOOKSHELF = BLOCKS.register("jungle_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> ACACIA_BOOKSHELF = BLOCKS.register("acacia_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF = BLOCKS.register("dark_oak_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_BOOKSHELF = BLOCKS.register("crimson_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WARPED_BOOKSHELF = BLOCKS.register("warped_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_LADDER = BLOCKS.register("spruce_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> BIRCH_LADDER = BLOCKS.register("birch_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> JUNGLE_LADDER = BLOCKS.register("jungle_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> ACACIA_LADDER = BLOCKS.register("acacia_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> DARK_OAK_LADDER = BLOCKS.register("dark_oak_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> CRIMSON_LADDER = BLOCKS.register("crimson_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> WARPED_LADDER = BLOCKS.register("warped_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));

    //Storage
    public static final RegistryObject<Block> CHARCOAL_BLOCK = BLOCKS.register("charcoal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> SUGAR_BLOCK = BLOCKS.register("sugar_block", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SNOW).strength(0.5F, 0.0F).sound(SoundType.SAND).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUGAR_CANE_BLOCK = BLOCKS.register("sugar_cane_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).strength(0.5F, 0.0F)));
    public static final RegistryObject<Block> BAMBOO_BLOCK = BLOCKS.register("bamboo_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.BAMBOO, MaterialColor.PLANT).instabreak().strength(1.0F).sound(SoundType.BAMBOO)));
    public static final RegistryObject<Block> GUNPOWDER_BLOCK = BLOCKS.register("gunpowder_block", GunpowderBlock::new);
    public static final RegistryObject<Block> BLAZE_POWDER_BLOCK = BLOCKS.register("blaze_powder_block", () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SNOW).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGMA_CREAM_BLOCK = BLOCKS.register("magma_cream_block", () -> new SlimeBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)));
    public static final RegistryObject<Block> PRISMARINE_CRYSTAL_BLOCK = BLOCKS.register("prismarine_crystal_block", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_CYAN).strength(0.3F, 0.5F).sound(SoundType.GLASS).lightLevel((lightValue) -> 5)));
    public static final RegistryObject<Block> WITHER_BONE_BLOCK = BLOCKS.register("wither_bone_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.BONE_BLOCK).strength(1.8F, 3.33F)));
    public static final RegistryObject<Block> WHITE_DYE_BLOCK = BLOCKS.register("white_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> ORANGE_DYE_BLOCK = BLOCKS.register("orange_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> MAGENTA_DYE_BLOCK = BLOCKS.register("magenta_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> LIGHT_BLUE_DYE_BLOCK = BLOCKS.register("light_blue_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> YELLOW_DYE_BLOCK = BLOCKS.register("yellow_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> LIME_DYE_BLOCK = BLOCKS.register("lime_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> PINK_DYE_BLOCK = BLOCKS.register("pink_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> GRAY_DYE_BLOCK = BLOCKS.register("gray_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> LIGHT_GRAY_DYE_BLOCK = BLOCKS.register("light_gray_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> CYAN_DYE_BLOCK = BLOCKS.register("cyan_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> PURPLE_DYE_BLOCK = BLOCKS.register("purple_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> BLUE_DYE_BLOCK = BLOCKS.register("blue_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> BROWN_DYE_BLOCK = BLOCKS.register("brown_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> GREEN_DYE_BLOCK = BLOCKS.register("green_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> RED_DYE_BLOCK = BLOCKS.register("red_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(3.0F, 5.0F)));
    public static final RegistryObject<Block> BLACK_DYE_BLOCK = BLOCKS.register("black_dye_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F, 5.0F)));

    //Glass
    public static final RegistryObject<Block> SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> WHITE_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> ORANGE_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> MAGENTA_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> YELLOW_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> LIME_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> PINK_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> GRAY_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> CYAN_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> PURPLE_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> BLUE_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> BROWN_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> GREEN_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> RED_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> BLACK_STAINED_SOUL_GLASS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> WHITE_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> ORANGE_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> MAGENTA_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> YELLOW_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> LIME_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> PINK_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> GRAY_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> CYAN_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> PURPLE_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> BLUE_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> BROWN_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> GREEN_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> RED_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> BLACK_STAINED_SOUL_GLASS_PANE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    //Misc
    public static final RegistryObject<Block> RAIN_DETECTOR = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> GOLD_BARS = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> ROSE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> POTTED_ROSE = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> TOMATO_PLANT = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> RICE_PLANT = BLOCKS.register("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    
    
    public static final RegistryObject<Block> COBBLESTONE_BRICK_STAIRS = BLOCKS.register("cobblestone_brick_stairs", () -> new ModStairBlock(() -> COBBLESTONE_BRICKS.get().defaultBlockState()));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_SLAB = BLOCKS.register("cobblestone_brick_slab", () -> new ModSlabBlock(() -> COBBLESTONE_BRICKS.get().defaultBlockState()));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_WALL = BLOCKS.register("cobblestone_brick_wall", () -> new ModWallBlock(() -> COBBLESTONE_BRICKS.get().defaultBlockState()));


    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
 
}
