package phrille.vanillaboom.util;

import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.item.ModItems;

public class Utils {

    public static void spawnParticles(BasicParticleType particle, World world, BlockPos pos) {
        if (!world.getBlockState(pos).isSolidRender(world, pos)) {
            for (int l = 0; l < 8; ++l) {
                world.addParticle(particle, (double) pos.getX() + Math.random(), (double) pos.getY() + Math.random(), (double) pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static void addCompostMaterials() {
        ComposterBlock.COMPOSTABLES.put(ModItems.PINE_CONE.get(), 0.35F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO.get(), 0.6F);
        ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.RICE_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.ROSE.get().asItem(), 0.6F);
    }

    public static void registerFlowerPots() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(new ResourceLocation(VanillaBoom.MOD_ID, "rose"), ModBlocks.POTTED_ROSE);
    }
}
