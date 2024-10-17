package phrille.vanillaboom.block;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import phrille.vanillaboom.item.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TomatoPlantBlock extends CropsBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D),
            Block.box(7.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D),
            Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D),
            Block.box(3.0D, 0.0D, 3.0D, 14.0D, 16.0D, 14.0D)
    };

    public TomatoPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return state.getValue(getAgeProperty()) > 3 ? SHAPE_BY_AGE[4] : SHAPE_BY_AGE[state.getValue(getAgeProperty())];
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        int age = state.getValue(AGE);
        boolean isMaxAge = age == getMaxAge();
        ItemStack stack = player.getItemInHand(hand);

        if (!isMaxAge && !stack.isEmpty() && stack.getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (isMaxAge) {
            popResource(world, pos, new ItemStack(ModItems.TOMATO.get()));
            world.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlock(pos, state.setValue(AGE, 4), 2);

            return ActionResultType.sidedSuccess(world.isClientSide);
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ModItems.TOMATO_SEEDS.get();
    }

    @Override
    protected int getBonemealAgeIncrease(World world) {
        return world.random.nextInt(2) + 1;
    }
}
