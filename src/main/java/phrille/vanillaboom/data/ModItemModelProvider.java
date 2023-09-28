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
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
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

        //Rocks
        blockItem(ModItems.PERIDOTITE.get());
        blockItem(ModItems.HYDRO_ROCK.get());
        blockItem(ModItems.INFERNAL_ROCK.get());

        //Sand and Gravel
        blockItem(ModItems.BONE_SAND.get());
        blockItem(ModItems.WITHER_BONE_SAND.get());

        //Polished
        blockItem(ModItems.POLISHED_PERIDOTITE.get());
        blockItem(ModItems.POLISHED_PRISMARINE.get());
        blockItem(ModItems.POLISHED_DARK_PRISMARINE.get());
        blockItem(ModItems.POLISHED_END_STONE.get());
        blockItem(ModItems.POLISHED_NETHERRACK.get());

        //Chiseled and cracked
        blockItem(ModItems.CRACKED_RED_NETHER_BRICKS.get());
        blockItem(ModItems.CHISELED_RED_NETHER_BRICKS.get());
        blockItem(ModItems.CHISELED_PURPUR_BLOCK.get());
        blockItem(ModItems.CHISELED_OBSIDIAN.get());

        //Pillars
        blockItem(ModItems.GRANITE_PILLAR.get());
        blockItem(ModItems.DIORITE_PILLAR.get());
        blockItem(ModItems.ANDESITE_PILLAR.get());
        blockItem(ModItems.PERIDOTITE_PILLAR.get());
        blockItem(ModItems.PRISMARINE_PILLAR.get());
        blockItem(ModItems.DARK_PRISMARINE_PILLAR.get());
        blockItem(ModItems.END_STONE_PILLAR.get());
        blockItem(ModItems.NETHERRACK_PILLAR.get());
        blockItem(ModItems.RED_NETHER_PILLAR.get());
        blockItem(ModItems.OBSIDIAN_PILLAR.get());

        //Wood Variations
        blockItem(ModItems.SPRUCE_BOOKSHELF.get());
        blockItem(ModItems.BIRCH_BOOKSHELF.get());
        blockItem(ModItems.JUNGLE_BOOKSHELF.get());
        blockItem(ModItems.ACACIA_BOOKSHELF.get());
        blockItem(ModItems.DARK_OAK_BOOKSHELF.get());
        blockItem(ModItems.CRIMSON_BOOKSHELF.get());
        blockItem(ModItems.WARPED_BOOKSHELF.get());
        item(ModItems.SPRUCE_LADDER.get());
        item(ModItems.BIRCH_LADDER.get());
        item(ModItems.JUNGLE_LADDER.get());
        item(ModItems.ACACIA_LADDER.get());
        item(ModItems.DARK_OAK_LADDER.get());
        item(ModItems.CRIMSON_LADDER.get());
        item(ModItems.WARPED_LADDER.get());

        //Storage Blocks
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

        //Glass
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

        item(ModItems.SOUL_GLASS_PANE.get());
        item(ModItems.WHITE_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.ORANGE_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.MAGENTA_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.YELLOW_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.LIME_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.PINK_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.GRAY_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.CYAN_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.PURPLE_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.BLUE_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.BROWN_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.GREEN_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.RED_STAINED_SOUL_GLASS_PANE.get());
        item(ModItems.BLACK_STAINED_SOUL_GLASS_PANE.get());

        //Misc
        blockItem(ModItems.RAIN_DETECTOR.get());
        item(ModItems.GOLD_BARS.get());
        item(ModItems.ROSE.get());

        //Variant Blocks
        ModDataGenerator.STAIRS.forEach(pair -> blockItem(pair.getFirst().asItem()));
        ModDataGenerator.SLABS.forEach(pair -> blockItem(pair.getFirst().asItem()));
        ModDataGenerator.WALLS.forEach(this::inventoryBlockItem);
        ModDataGenerator.FENCES.forEach(pair -> inventoryBlockItem(pair.getFirst()));
        ModDataGenerator.FENCE_GATES.forEach(pair -> blockItem(pair.getFirst().asItem()));
    }

    public void item(Item item) {
        item(item, "generated").texture("layer0", itemTexture(item));
    }

    public void item(Block block) {
        item(block.asItem(), "generated").texture("layer0", blockTexture(block));
    }

    public void blockItem(Item blockItem) {
        ResourceLocation parent = ForgeRegistries.ITEMS.getKey(blockItem);
        withExistingParent(name(blockItem), new ResourceLocation(parent.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + parent.getPath()));
    }

    public void inventoryBlockItem(Block block) {
        ResourceLocation parent = ForgeRegistries.BLOCKS.getKey(block);
        withExistingParent(name(block.asItem()), new ResourceLocation(parent.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + parent.getPath() + "_inventory"));
    }

    public void spawnEggItem(Item item) {
        item(item, "template_spawn_egg");
    }

    protected ItemModelBuilder item(Item item, String parent) {
        return withExistingParent(name(item), ModelProvider.ITEM_FOLDER + "/" + parent);
    }

    protected ResourceLocation itemTexture(Item item) {
        ResourceLocation name = ForgeRegistries.ITEMS.getKey(item);
        return new ResourceLocation(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }

    protected ResourceLocation blockTexture(Block block) {
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath().replace("_pane", ""));
    }

    protected String name(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }
}
