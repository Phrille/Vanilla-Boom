package phrille.vanillaboom.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.block.ModCandleCakeBlock;
import phrille.vanillaboom.item.ModItems;

import java.util.List;

public class Utils {
    public static final List<Block> CANDLES = List.of(Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE);

    public static void spawnParticles(SimpleParticleType particle, Level world, BlockPos pos) {
        if (!world.getBlockState(pos).isSolidRender(world, pos)) {
            for (int l = 0; l < 8; ++l) {
                world.addParticle(particle, (double) pos.getX() + Math.random(), (double) pos.getY() + Math.random(), (double) pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static void addCompostMaterials() {
        ComposterBlock.COMPOSTABLES.put(ModItems.PINE_CONE.get(), 0.35F);
        ComposterBlock.COMPOSTABLES.put(ModItems.PUMPKIN_SLICE.get(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO.get(), 0.6F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.RICE_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.ROSE.get().asItem(), 0.6F);
    }

    public static void registerFlowerPots() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(new ResourceLocation(VanillaBoom.MOD_ID, "rose"), ModBlocks.POTTED_ROSE);
    }

    public static void registerCandleCakes() {
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.WHITE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.ORANGE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.MAGENTA_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.YELLOW_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIME_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PINK_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GRAY_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CYAN_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PURPLE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLUE_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BROWN_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GREEN_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.RED_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.CHOCOLATE_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLACK_CANDLE_CHOCOLATE_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.WHITE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.ORANGE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.MAGENTA_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_BLUE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.YELLOW_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIME_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PINK_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GRAY_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_GRAY_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CYAN_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PURPLE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLUE_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BROWN_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GREEN_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.RED_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.BERRY_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLACK_CANDLE_BERRY_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.WHITE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.ORANGE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.MAGENTA_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_BLUE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.YELLOW_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIME_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PINK_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GRAY_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.LIGHT_GRAY_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.CYAN_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.PURPLE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLUE_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BROWN_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.GREEN_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.RED_CANDLE_CARROT_CAKE.get());
        ((ModCakeBlock) ModBlocks.CARROT_CAKE.get()).addCandleCake((ModCandleCakeBlock) ModBlocks.BLACK_CANDLE_CARROT_CAKE.get());
    }
}
