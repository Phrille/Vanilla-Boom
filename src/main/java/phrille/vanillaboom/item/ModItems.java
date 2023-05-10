package phrille.vanillaboom.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.util.Names;
import phrille.vanillaboom.util.Utils;
import phrille.vanillaboom.util.VanillaBoomTab;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModItems {
    //Misc
    public static final Item MAGMA_BRICK = Utils._null();
    public static final Item WITHER_BONE = Utils._null();
    public static final Item WITHER_BONE_MEAL = Utils._null();
    public static final Item PRISMARINE_ARROW = Utils._null();
    public static final Item POLAR_BEAR_FUR = Utils._null();
    public static final Item TOMATO_SEEDS = Utils._null();
    public static final Item RICE_SEEDS = Utils._null();

    //Food
    public static final Item PINE_CONE = Utils._null();
    public static final Item PUMPKIN_SLICE = Utils._null();
    public static final Item TOMATO = Utils._null();
    public static final Item COOKED_EGG = Utils._null();
    public static final Item DROWNED_FLESH = Utils._null();
    public static final Item MELON_POPSICLE = Utils._null();
    public static final Item CHOCOLATE = Utils._null();
    public static final Item CHOCOLATE_CAKE = Utils._null();
    public static final Item BERRY_CAKE = Utils._null();
    public static final Item CARROT_CAKE = Utils._null();
    public static final Item APPLE_PIE = Utils._null();
    public static final Item BERRY_PIE = Utils._null();
    public static final Item MONSTER_PIE = Utils._null();
    public static final Item RAW_POLAR_BEAR_MEAT = Utils._null();
    public static final Item POLAR_BEAR_STEAK = Utils._null();
    public static final Item POTATO_SOUP = Utils._null();
    public static final Item MEAT_SOUP = Utils._null();
    public static final Item FISH_SOUP = Utils._null();
    public static final Item RICE_BOWL = Utils._null();

    //Fish
    public static final Item TUNA = Utils._null();
    public static final Item COOKED_TUNA = Utils._null();
    public static final Item PERCH = Utils._null();
    public static final Item COOKED_PERCH = Utils._null();
    public static final Item PIKE = Utils._null();
    public static final Item COOKED_PIKE = Utils._null();
    public static final Item EEL = Utils._null();
    public static final Item COOKED_EEL = Utils._null();

    //Fish Buckets
    public static final Item TUNA_BUCKET = Utils._null();
    public static final Item PERCH_BUCKET = Utils._null();
    public static final Item PIKE_BUCKET = Utils._null();
    public static final Item EEL_BUCKET = Utils._null();

    //Spawn Eggs
    public static final Item TUNA_SPAWN_EGG = Utils._null();
    public static final Item PERCH_SPAWN_EGG = Utils._null();
    public static final Item PIKE_SPAWN_EGG = Utils._null();
    public static final Item EEL_SPAWN_EGG = Utils._null();

    //Painting Items
    public static final Item CANVAS = Utils._null();
    public static final Item SMALL_PAINTING = Utils._null();
    public static final Item HORIZONTAL_PAINTING = Utils._null();
    public static final Item VERTICAL_PAINTING = Utils._null();
    public static final Item MEDIUM_PAINTING = Utils._null();
    public static final Item LARGE_HORIZONTAL_PAINTING = Utils._null();
    public static final Item LARGE_PAINTING = Utils._null();
    public static final Item KEBAB_PAINTING = Utils._null();
    public static final Item AZTEC_PAINTING = Utils._null();
    public static final Item ALBAN_PAINTING = Utils._null();
    public static final Item AZTEC2_PAINTING = Utils._null();
    public static final Item BOMB_PAINTING = Utils._null();
    public static final Item PLANT_PAINTING = Utils._null();
    public static final Item WASTELAND_PAINTING = Utils._null();
    public static final Item POOL_PAINTING = Utils._null();
    public static final Item COURBET_PAINTING = Utils._null();
    public static final Item SEA_PAINTING = Utils._null();
    public static final Item SUNSET_PAINTING = Utils._null();
    public static final Item CREEBET_PAINTING = Utils._null();
    public static final Item WANDERER_PAINTING = Utils._null();
    public static final Item GRAHAM_PAINTING = Utils._null();
    public static final Item MATCH_PAINTING = Utils._null();
    public static final Item BUST_PAINTING = Utils._null();
    public static final Item STAGE_PAINTING = Utils._null();
    public static final Item VOID_PAINTING = Utils._null();
    public static final Item SKULL_AND_ROSES_PAINTING = Utils._null();
    public static final Item WITHER_PAINTING = Utils._null();
    public static final Item FIGHTERS_PAINTING = Utils._null();
    public static final Item POINTER_PAINTING = Utils._null();
    public static final Item PIGSCENE_PAINTING = Utils._null();
    public static final Item BURNING_SKULL_PAINTING = Utils._null();
    public static final Item SKELETON_PAINTING = Utils._null();
    public static final Item DONKEY_KONG_PAINTING = Utils._null();

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void onRegisterItems(RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> registry = event.getRegistry();
            registerItemBlocks(registry);

            //Misc
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "magma_brick"));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "wither_bone"));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "wither_bone_meal"));
            registerItem(registry, setup(new PrismarineArrowItem(), "prismarine_arrow"));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "polar_bear_fur"));
            registerItem(registry, setup(new BlockItem(ModBlocks.TOMATO_PLANT.get(), new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "tomato_seeds"));
            registerItem(registry, setup(new BlockItem(ModBlocks.RICE_PLANT.get(), new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "rice_seeds"));

            /* TODO:
             * Fix fish foods - effects and amount
             * Add tags to fish items
             * Add furnace, smoker and campfire recipes
             * Pie and popsicle recipe
             */

            //Foods
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PINE_CONE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "pine_cone"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PUMPKIN_SLICE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "pumpkin_slice"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.TOMATO).tab(VanillaBoomTab.VANILLABOOM_TAB)), "tomato"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_EGG).tab(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_egg"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.DROWNED_FLESH).tab(VanillaBoomTab.VANILLABOOM_TAB)), "drowned_flesh"));
            registerItem(registry, setup(new IceCreamItem(new Item.Properties().food(ModFoods.MELON_POPSICLE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "melon_popsicle"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.CHOCOLATE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "chocolate"));
            registerItem(registry, setup(new BlockItem(ModBlocks.CHOCOLATE_CAKE.get(), new Item.Properties().stacksTo(1).tab(VanillaBoomTab.VANILLABOOM_TAB)), "chocolate_cake"));
            registerItem(registry, setup(new BlockItem(ModBlocks.BERRY_CAKE.get(), new Item.Properties().stacksTo(1).tab(VanillaBoomTab.VANILLABOOM_TAB)), "berry_cake"));
            registerItem(registry, setup(new BlockItem(ModBlocks.CARROT_CAKE.get(), new Item.Properties().stacksTo(1).tab(VanillaBoomTab.VANILLABOOM_TAB)), "carrot_cake"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.APPLE_PIE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "apple_pie"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.BERRY_PIE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "berry_pie"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.MONSTER_PIE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "monster_pie"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.RAW_POLAR_BEAR_MEAT).tab(VanillaBoomTab.VANILLABOOM_TAB)), "raw_polar_bear_meat"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).tab(VanillaBoomTab.VANILLABOOM_TAB)), "polar_bear_steak"));
            registerItem(registry, setup(new BowlFoodItem(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).tab(VanillaBoomTab.VANILLABOOM_TAB)), "potato_soup"));
            registerItem(registry, setup(new BowlFoodItem(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).tab(VanillaBoomTab.VANILLABOOM_TAB)), "meat_soup"));
            registerItem(registry, setup(new BowlFoodItem(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).tab(VanillaBoomTab.VANILLABOOM_TAB)), "fish_soup"));
            registerItem(registry, setup(new BowlFoodItem(new Item.Properties().food(ModFoods.POLAR_BEAR_STEAK).tab(VanillaBoomTab.VANILLABOOM_TAB)), "rice_bowl"));

            //Fish
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.TUNA).tab(VanillaBoomTab.VANILLABOOM_TAB)), "tuna"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_TUNA).tab(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_tuna"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PERCH).tab(VanillaBoomTab.VANILLABOOM_TAB)), "perch"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_PERCH).tab(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_perch"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.PIKE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "pike"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_PIKE).tab(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_pike"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.EEL).tab(VanillaBoomTab.VANILLABOOM_TAB)), "eel"));
            registerItem(registry, setup(new Item(new Item.Properties().food(ModFoods.COOKED_EEL).tab(VanillaBoomTab.VANILLABOOM_TAB)), "cooked_eel"));

            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.PERCH), "perch_bucket"));
            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.TUNA), "tuna_bucket"));
            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.PIKE), "pike_bucket"));
            registerItem(registry, setup(new FishBucketItem(() -> ModEntities.EEL), "eel_bucket"));

            registerItem(registry, setup(new ForgeSpawnEggItem(() -> ModEntities.PERCH, 0x464614, 0xFD5100, new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "perch_spawn_egg"));
            registerItem(registry, setup(new ForgeSpawnEggItem(() -> ModEntities.TUNA, 0x33495E, 0xD7C376, new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "tuna_spawn_egg"));
            registerItem(registry, setup(new ForgeSpawnEggItem(() -> ModEntities.PIKE, 0x4C462A, 0xA0A169, new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "pike_spawn_egg"));
            registerItem(registry, setup(new ForgeSpawnEggItem(() -> ModEntities.EEL, 0x5F4F37, 0x312517, new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), "eel_spawn_egg"));

            //Paintings
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), Names.CANVAS));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), Names.SMALL_PAINTING));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), Names.HORIZONTAL_PAINTING));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), Names.VERTICAL_PAINTING));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), Names.MEDIUM_PAINTING));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), Names.LARGE_HORIZONTAL_PAINTING));
            registerItem(registry, setup(new Item(new Item.Properties().tab(VanillaBoomTab.VANILLABOOM_TAB)), Names.LARGE_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.KEBAB), Names.KEBAB_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.AZTEC), Names.AZTEC_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.ALBAN), Names.ALBAN_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.AZTEC2), Names.AZTEC2_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.BOMB), Names.BOMB_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.PLANT), Names.PLANT_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.WASTELAND), Names.WASTELAND_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.POOL), Names.POOL_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.COURBET), Names.COURBET_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.SEA), Names.SEA_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.SUNSET), Names.SUNSET_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.CREEBET), Names.CREEBET_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.WANDERER), Names.WANDERER_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.GRAHAM), Names.GRAHAM_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.MATCH), Names.MATCH_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.BUST), Names.BUST_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.STAGE), Names.STAGE_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.VOID), Names.VOID_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.SKULL_AND_ROSES), Names.SKULL_AND_ROSES_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.WITHER), Names.WITHER_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.FIGHTERS), Names.FIGHTERS_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.POINTER), Names.POINTER_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.PIGSCENE), Names.PIGSCENE_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.BURNING_SKULL), Names.BURNING_SKULL_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.SKELETON), Names.SKELETON_PAINTING));
            registerItem(registry, setup(new PaintingItem(Motive.DONKEY_KONG), Names.DONKEY_KONG_PAINTING));
        }

        private static void registerItem(IForgeRegistry<Item> registry, Item item) {
            registerItem(registry, item, false);
        }

        private static void registerItem(IForgeRegistry<Item> registry, Item item, boolean variantBlock) {
            registry.register(item);

            if (variantBlock) {
                VanillaBoomTab.VANILLABOOM_VARIANT_BLOCKS_TAB_LIST.add(item);
            } else {
                VanillaBoomTab.VANILLABOOM_TAB_LIST.add(item);
            }
        }

        private static void registerItemBlocks(IForgeRegistry<Item> registry) {
            for (Block block : ForgeRegistries.BLOCKS.getValues()) {
                ResourceLocation blockRegistryName = block.getRegistryName();

                if (!blockRegistryName.getNamespace().equals(VanillaBoom.MOD_ID)) {
                    continue;
                }

                boolean notAdd = block instanceof FlowerPotBlock || block instanceof BonemealableBlock || block instanceof CakeBlock || block instanceof CandleCakeBlock;

                if (!notAdd) {
                    boolean variantBlock = block instanceof SlabBlock || block instanceof StairBlock || block instanceof WallBlock || block instanceof FenceBlock || block instanceof FenceGateBlock;
                    Item.Properties properties = new Item.Properties().tab(variantBlock ? VanillaBoomTab.VANILLABOOM_VARIANT_BLOCKS_TAB : VanillaBoomTab.VANILLABOOM_TAB);
                    BlockItem blockItem = new BlockItem(block, properties);
                    registerItem(registry, setup(blockItem, blockRegistryName), variantBlock);
                }
            }
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(T entry, String name) {
            return setup(entry, new ResourceLocation(VanillaBoom.MOD_ID, name));
        }

        public static <T extends IForgeRegistryEntry<T>> T setup(T entry, ResourceLocation registryName) {
            entry.setRegistryName(registryName);
            return entry;
        }
    }

    public static class ModFoods {
        public static final FoodProperties RAW_POLAR_BEAR_MEAT = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).meat().build();
        public static final FoodProperties POLAR_BEAR_STEAK = new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).meat().build();
        public static final FoodProperties PUMPKIN_SLICE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().build();
        public static final FoodProperties COOKED_EGG = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
        public static final FoodProperties DROWNED_FLESH = new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 0.5F).meat().build();
        public static final FoodProperties MELON_POPSICLE = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().build();
        public static final FoodProperties PINE_CONE = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).fast().build();
        public static final FoodProperties CHOCOLATE = new FoodProperties.Builder().nutrition(5).saturationMod(0.3F).build();
        public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(4).saturationMod(0.2F).build();
        public static final FoodProperties APPLE_PIE = new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).build();
        public static final FoodProperties BERRY_PIE = new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).build();
        public static final FoodProperties MONSTER_PIE = new FoodProperties.Builder().nutrition(10).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 1.0F).meat().build();

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
