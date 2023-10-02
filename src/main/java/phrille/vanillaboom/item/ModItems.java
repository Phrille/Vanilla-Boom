package phrille.vanillaboom.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.util.VanillaBoomTab;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaBoom.MOD_ID);

    //Misc
    public static final RegistryObject<Item> MAGMA_BRICK = ITEMS.register("magma_brick", () -> new Item(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> WITHER_BONE = ITEMS.register("wither_bone", () -> new Item(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> WITHER_BONE_MEAL = ITEMS.register("wither_bone_meal", () -> new Item(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> PRISMARINE_ARROW = ITEMS.register("prismarine_arrow", () -> new PrismarineArrowItem());
    public static final RegistryObject<Item> POLAR_BEAR_FUR = ITEMS.register("polar_bear_fur", () -> new Item(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new BlockItem(ModBlocks.TOMATO_PLANT.get(), new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds", () -> new BlockItem(ModBlocks.RICE_PLANT.get(), new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));

    //Food
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone", () -> new Item(new Item.Properties().food(ModFoods.PINE_CONE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> new Item(new Item.Properties().food(ModFoods.TOMATO).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> COOKED_EGG = ITEMS.register("cooked_egg", () -> new Item(new Item.Properties().food(ModFoods.COOKED_EGG).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> DROWNED_FLESH = ITEMS.register("drowned_flesh", () -> new Item(new Item.Properties().food(ModFoods.DROWNED_FLESH).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> MELON_POPSICLE = ITEMS.register("melon_popsicle", () -> new IceCreamItem(new Item.Properties().food(ModFoods.MELON_POPSICLE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().food(ModFoods.CHOCOLATE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake", () -> new BlockItem(ModBlocks.CHOCOLATE_CAKE.get(), new Item.Properties().stacksTo(1).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> BERRY_CAKE = ITEMS.register("berry_cake", () -> new BlockItem(ModBlocks.BERRY_CAKE.get(), new Item.Properties().stacksTo(1).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> CARROT_CAKE = ITEMS.register("carrot_cake", () -> new BlockItem(ModBlocks.CARROT_CAKE.get(), new Item.Properties().stacksTo(1).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().food(ModFoods.APPLE_PIE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> BERRY_PIE = ITEMS.register("berry_pie", () -> new Item(new Item.Properties().food(ModFoods.BERRY_PIE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> MONSTER_PIE = ITEMS.register("monster_pie", () -> new Item(new Item.Properties().food(ModFoods.MONSTER_PIE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> RAW_POLAR_BEAR_MEAT = ITEMS.register("raw_polar_bear_meat", () -> new Item(new Item.Properties().food(ModFoods.RAW_POLAR_BEAR_MEAT).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> POLAR_BEAR_STEAK = ITEMS.register("polar_bear_steak", () -> new Item(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> POTATO_SOUP = ITEMS.register("potato_soup", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.POTATO_SOUP).craftRemainder(Items.BOWL).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> MEAT_SOUP = ITEMS.register("meat_soup", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.MEAT_SOUP).craftRemainder(Items.BOWL).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> FISH_SOUP = ITEMS.register("fish_soup", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.FISH_SOUP).craftRemainder(Items.BOWL).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> RICE_BOWL = ITEMS.register("rice_bowl", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.RICE_BOWL).craftRemainder(Items.BOWL).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));

    //Fish
    public static final RegistryObject<Item> TUNA = ITEMS.register("tuna", () -> new Item(new Item.Properties().food(ModFoods.TUNA).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> COOKED_TUNA = ITEMS.register("cooked_tuna", () -> new Item(new Item.Properties().food(ModFoods.COOKED_TUNA).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> PERCH = ITEMS.register("perch", () -> new Item(new Item.Properties().food(ModFoods.PERCH).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> COOKED_PERCH = ITEMS.register("cooked_perch", () -> new Item(new Item.Properties().food(ModFoods.COOKED_PERCH).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> PIKE = ITEMS.register("pike", () -> new Item(new Item.Properties().food(ModFoods.PIKE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> COOKED_PIKE = ITEMS.register("cooked_pike", () -> new Item(new Item.Properties().food(ModFoods.COOKED_PIKE).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> EEL = ITEMS.register("eel", () -> new Item(new Item.Properties().food(ModFoods.EEL).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> COOKED_EEL = ITEMS.register("cooked_eel", () -> new Item(new Item.Properties().food(ModFoods.COOKED_EEL).tab(VanillaBoomTab.VANILLA_BOOM_TAB)));

    //Fish Buckets
    public static final RegistryObject<Item> TUNA_BUCKET = ITEMS.register("tuna_bucket", () -> new FishBucketItem(ModEntities.TUNA));
    public static final RegistryObject<Item> PERCH_BUCKET = ITEMS.register("perch_bucket", () -> new FishBucketItem(ModEntities.PERCH));
    public static final RegistryObject<Item> PIKE_BUCKET = ITEMS.register("pike_bucket", () -> new FishBucketItem(ModEntities.PIKE));
    public static final RegistryObject<Item> EEL_BUCKET = ITEMS.register("eel_bucket", () -> new FishBucketItem(ModEntities.EEL));

    //Spawn Eggs
    public static final RegistryObject<Item> TUNA_SPAWN_EGG = ITEMS.register("tuna_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.TUNA, 0x464614, 0xFD5100, new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> PERCH_SPAWN_EGG = ITEMS.register("perch_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.PERCH, 0x33495E, 0xD7C376, new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> PIKE_SPAWN_EGG = ITEMS.register("pike_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.PIKE, 0x4C462A, 0xA0A169, new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> EEL_SPAWN_EGG = ITEMS.register("eel_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.EEL, 0x5F4F37, 0x312517, new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));

    //Paintings
    public static final RegistryObject<Item> CANVAS = ITEMS.register("canvas", () -> new Item(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB)));
    public static final RegistryObject<Item> KEBAB_PAINTING = ITEMS.register("kebab_painting", () -> new PaintingItem(Motive.KEBAB));
    public static final RegistryObject<Item> AZTEC_PAINTING = ITEMS.register("aztec_painting", () -> new PaintingItem(Motive.AZTEC));
    public static final RegistryObject<Item> ALBAN_PAINTING = ITEMS.register("alban_painting", () -> new PaintingItem(Motive.ALBAN));
    public static final RegistryObject<Item> AZTEC2_PAINTING = ITEMS.register("aztec2_painting", () -> new PaintingItem(Motive.AZTEC2));
    public static final RegistryObject<Item> BOMB_PAINTING = ITEMS.register("bomb_painting", () -> new PaintingItem(Motive.BOMB));
    public static final RegistryObject<Item> PLANT_PAINTING = ITEMS.register("plant_painting", () -> new PaintingItem(Motive.PLANT));
    public static final RegistryObject<Item> WASTELAND_PAINTING = ITEMS.register("wasteland_painting", () -> new PaintingItem(Motive.WASTELAND));
    public static final RegistryObject<Item> POOL_PAINTING = ITEMS.register("pool_painting", () -> new PaintingItem(Motive.POOL));
    public static final RegistryObject<Item> COURBET_PAINTING = ITEMS.register("courbet_painting", () -> new PaintingItem(Motive.COURBET));
    public static final RegistryObject<Item> SEA_PAINTING = ITEMS.register("sea_painting", () -> new PaintingItem(Motive.SEA));
    public static final RegistryObject<Item> SUNSET_PAINTING = ITEMS.register("sunset_painting", () -> new PaintingItem(Motive.SUNSET));
    public static final RegistryObject<Item> CREEBET_PAINTING = ITEMS.register("creebet_painting", () -> new PaintingItem(Motive.CREEBET));
    public static final RegistryObject<Item> WANDERER_PAINTING = ITEMS.register("wanderer_painting", () -> new PaintingItem(Motive.WANDERER));
    public static final RegistryObject<Item> GRAHAM_PAINTING = ITEMS.register("graham_painting", () -> new PaintingItem(Motive.GRAHAM));
    public static final RegistryObject<Item> MATCH_PAINTING = ITEMS.register("match_painting", () -> new PaintingItem(Motive.MATCH));
    public static final RegistryObject<Item> BUST_PAINTING = ITEMS.register("bust_painting", () -> new PaintingItem(Motive.BUST));
    public static final RegistryObject<Item> STAGE_PAINTING = ITEMS.register("stage_painting", () -> new PaintingItem(Motive.STAGE));
    public static final RegistryObject<Item> VOID_PAINTING = ITEMS.register("void_painting", () -> new PaintingItem(Motive.VOID));
    public static final RegistryObject<Item> SKULL_AND_ROSES_PAINTING = ITEMS.register("skull_and_roses_painting", () -> new PaintingItem(Motive.SKULL_AND_ROSES));
    public static final RegistryObject<Item> WITHER_PAINTING = ITEMS.register("wither_painting", () -> new PaintingItem(Motive.WITHER));
    public static final RegistryObject<Item> FIGHTERS_PAINTING = ITEMS.register("fighters_painting", () -> new PaintingItem(Motive.FIGHTERS));
    public static final RegistryObject<Item> POINTER_PAINTING = ITEMS.register("pointer_painting", () -> new PaintingItem(Motive.POINTER));
    public static final RegistryObject<Item> PIGSCENE_PAINTING = ITEMS.register("pigscene_painting", () -> new PaintingItem(Motive.PIGSCENE));
    public static final RegistryObject<Item> BURNING_SKULL_PAINTING = ITEMS.register("burning_skull_painting", () -> new PaintingItem(Motive.BURNING_SKULL));
    public static final RegistryObject<Item> SKELETON_PAINTING = ITEMS.register("skeleton_painting", () -> new PaintingItem(Motive.SKELETON));
    public static final RegistryObject<Item> DONKEY_KONG_PAINTING = ITEMS.register("donkey_kong_painting", () -> new PaintingItem(Motive.DONKEY_KONG));

    public static class ModFoods {
        public static final FoodProperties RAW_POLAR_BEAR_MEAT = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).meat().build();
        public static final FoodProperties POLAR_BEAR_STEAK = new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).meat().build();
        public static final FoodProperties COOKED_EGG = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
        public static final FoodProperties DROWNED_FLESH = new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 0.5F).meat().build();
        public static final FoodProperties MELON_POPSICLE = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().build();
        public static final FoodProperties PINE_CONE = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).fast().build();
        public static final FoodProperties CHOCOLATE = new FoodProperties.Builder().nutrition(5).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 0.5F).build();
        public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(4).saturationMod(0.2F).build();
        public static final FoodProperties APPLE_PIE = new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).build();
        public static final FoodProperties BERRY_PIE = new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).build();
        public static final FoodProperties MONSTER_PIE = new FoodProperties.Builder().nutrition(10).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 1.0F).meat().build();
        public static final FoodProperties POTATO_SOUP = new FoodProperties.Builder().nutrition(8).saturationMod(0.5F).build();
        public static final FoodProperties MEAT_SOUP = new FoodProperties.Builder().nutrition(12).saturationMod(0.7F).build();
        public static final FoodProperties FISH_SOUP = new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).build();
        public static final FoodProperties RICE_BOWL = new FoodProperties.Builder().nutrition(5).saturationMod(0.2F).build();

        public static final FoodProperties TUNA = new FoodProperties.Builder().nutrition(3).saturationMod(0.1F).build();
        public static final FoodProperties COOKED_TUNA = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).build();
        public static final FoodProperties PERCH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
        public static final FoodProperties COOKED_PERCH = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
        public static final FoodProperties PIKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
        public static final FoodProperties COOKED_PIKE = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).build();
        public static final FoodProperties EEL = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
        public static final FoodProperties COOKED_EEL = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
    }
}
