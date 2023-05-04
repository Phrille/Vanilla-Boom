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
import phrille.vanillaboom.item.ModItems;

import javax.annotation.Nonnull;

public class Utils {
    public static final Block[] CANDLES = {Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE};

    @Nonnull
    public static <T> T _null() {
        return null;
    }

    public static void spawnParticles(SimpleParticleType particle, Level world, BlockPos pos) {
        if (!world.getBlockState(pos).isSolidRender(world, pos)) {
            for (int l = 0; l < 8; ++l) {
                world.addParticle(particle, (double) pos.getX() + Math.random(), (double) pos.getY() + Math.random(), (double) pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static void addCompostMaterials() {
        ComposterBlock.COMPOSTABLES.put(ModItems.PINE_CONE, 0.35F);
        ComposterBlock.COMPOSTABLES.put(ModItems.PUMPKIN_SLICE, 0.5F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO, 0.6F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO_SEEDS, 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.RICE_SEEDS, 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.ROSE, 0.6F);
    }

    public static void registerFlowerPots() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(new ResourceLocation(VanillaBoom.MOD_ID, Names.ROSE), () -> ModBlocks.POTTED_ROSE);
    }
}
