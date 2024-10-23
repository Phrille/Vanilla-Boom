package phrille.vanillaboom.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import phrille.vanillaboom.item.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class TomatoPlantBlock extends CropBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D),
            Block.box(7.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D),
            Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D),
            Block.box(3.0D, 0.0D, 3.0D, 14.0D, 16.0D, 14.0D)
    };

    public TomatoPlantBlock(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return state.getValue(getAgeProperty()) > 3 ? SHAPE_BY_AGE[4] : SHAPE_BY_AGE[state.getValue(getAgeProperty())];
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(AGE);
        boolean isMaxAge = age == getMaxAge();
        ItemStack stack = player.getItemInHand(hand);

        if (!isMaxAge && stack.is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (isMaxAge) {
            popResource(level, pos, new ItemStack(ModItems.TOMATO.get()));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(AGE, 4), 2);

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.TOMATO_SEEDS.get();
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return level.random.nextInt(2) + 1;
    }
}
