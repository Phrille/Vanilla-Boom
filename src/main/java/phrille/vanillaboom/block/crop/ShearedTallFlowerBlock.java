package phrille.vanillaboom.block.crop;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import phrille.vanillaboom.util.Utils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
public class ShearedTallFlowerBlock extends TallFlowerBlock {
    private static final BiMap<TallFlowerBlock, ShearedTallFlowerBlock> SHEARED_FLOWER_BLOCKS = HashBiMap.create();
    private final Supplier<Block> flowerBlock;

    public ShearedTallFlowerBlock(BlockBehaviour.Properties builder, Supplier<Block> flowerBlock) {
        super(builder);
        this.flowerBlock = flowerBlock;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        if (rand.nextFloat() < 0.5F) {
            DoubleBlockHalf half = state.getValue(TallFlowerBlock.HALF);
            if (half == DoubleBlockHalf.UPPER) {
                pos = pos.below();
            }

            Utils.setDoubleBlock(level, SHEARED_FLOWER_BLOCKS.inverse().get(this).defaultBlockState(), pos, TallFlowerBlock.HALF);
        }
    }

    public Block getFlower() {
        return flowerBlock.get();
    }

    public static void registerShearedTallFlowerBlock(TallFlowerBlock tallFlower, ShearedTallFlowerBlock shearedTallFlower) {
        SHEARED_FLOWER_BLOCKS.put(tallFlower, shearedTallFlower);
    }

    public static BiMap<TallFlowerBlock, ShearedTallFlowerBlock> getShearedFlowerBlocks() {
        return SHEARED_FLOWER_BLOCKS;
    }
}
