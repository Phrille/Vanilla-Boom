package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
        item(ModItems.CANVAS.get(), "generated").texture("layer0", itemTexture(Items.FLOWER_BANNER_PATTERN));
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

        //Variant Blocks
        ModDataGenerator.STAIRS.forEach(pair -> blockItem(pair.getFirst()));
        ModDataGenerator.SLABS.forEach(pair -> blockItem(pair.getFirst()));
        ModDataGenerator.WALLS.forEach(this::inventoryBlockItem);
        ModDataGenerator.FENCES.forEach(pair -> inventoryBlockItem(pair.getFirst()));
        ModDataGenerator.FENCE_GATES.forEach(pair -> blockItem(pair.getFirst()));
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
