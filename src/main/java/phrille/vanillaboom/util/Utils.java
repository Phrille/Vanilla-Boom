package phrille.vanillaboom.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.item.ModItems;

import javax.annotation.Nonnull;

public class Utils {
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

    public static final String getStairName(String name) {
        return name.replace("bricks", "brick") + "_stairs";
    }

    public static final String getSlabName(String name) {
        return name.replace("bricks", "brick") + "_slab";
    }

    public static final String getWallName(String name) {
        return name.replace("bricks", "brick") + "_wall";
    }
}
