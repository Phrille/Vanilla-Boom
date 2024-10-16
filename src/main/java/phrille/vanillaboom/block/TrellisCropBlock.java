package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import phrille.vanillaboom.util.Utils;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class TrellisCropBlock extends CropBlock implements ITrellisCrop {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public TrellisCropBlock(Properties builder) {
        super(builder);
        registerDefaultState(stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(getAgeProperty(), 0));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return TrellisBlock.TRELLIS_SHAPE;
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlock = state.getValue(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleBlock == DoubleBlockHalf.LOWER != (direction == Direction.UP) || neighborState.is(this) && neighborState.getValue(HALF) != doubleBlock) {
            return doubleBlock == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }
        return Blocks.AIR.defaultBlockState();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        return pos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(pos.above()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        BlockPos above = pos.above();
        level.setBlock(above, DoublePlantBlock.copyWaterloggedFrom(level, above, defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)), 3);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        BlockState belowState = level.getBlockState(below);

        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return mayPlaceOn(belowState, level, below);
        }
        if (state.getBlock() != this) {
            // Called during world gen and placement, before this block is set,
            // so if we are not 'here' then assume it's the pre-check.
            return mayPlaceOn(belowState, level, below);
        }
        return belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER && belowState.getValue(getAgeProperty()) >= state.getValue(getAgeProperty());
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(Blocks.FARMLAND);
    }

    @Override
    public void placeAt(Level level, BlockPos pos) {
        level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 20);
        level.setBlock(pos, getStateForAge(0).setValue(HALF, DoubleBlockHalf.LOWER), 2);
        level.setBlock(pos.above(), getStateForAge(0).setValue(HALF, DoubleBlockHalf.UPPER), 2);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER && !isMaxAge(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!level.isAreaLoaded(pos, 1) || level.getRawBrightness(pos, 0) < 9) {
            return;
        }

        int age = getAge(state);
        if (age < getMaxAge()) {
            float growthSpeed = getGrowthSpeed(this, level, pos);
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, rand.nextInt((int) (25.0F / growthSpeed) + 1) == 0)) {
                growToAge(level, state, pos, age + 1, 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
            }
        }
    }

    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int newAge = getAge(state) + getBonemealAgeIncrease(level);
        int maxAge = getMaxAge();

        if (newAge > maxAge) {
            newAge = maxAge;
        }
        growToAge(level, state, pos, newAge, 2);
    }

    protected void growToAge(Level level, BlockState oldState, BlockPos pos, int age, int flag) {
        if (age >= oldState.getValue(getAgeProperty())) {
            level.setBlock(pos, getStateForAge(age).setValue(HALF, DoubleBlockHalf.LOWER), flag);
            level.setBlock(pos.above(), getStateForAge(age).setValue(HALF, DoubleBlockHalf.UPPER), flag);
        } else {
            level.setBlock(pos.above(), getStateForAge(age).setValue(HALF, DoubleBlockHalf.UPPER), flag);
            level.setBlock(pos, getStateForAge(age).setValue(HALF, DoubleBlockHalf.LOWER), flag);
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            performBonemeal(level, rand, pos.below(), level.getBlockState(pos.below()));
            return;
        }
        super.performBonemeal(level, rand, pos, state);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return getBonemealIncrease(level);
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(AGE);
        boolean isMaxAge = age == getMaxAge();
        ItemStack stack = player.getItemInHand(hand);

        if (!isMaxAge && stack.is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        }
        if (isMaxAge) {
            popResource(level, pos, new ItemStack(getFruit()));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
                pos = pos.below();
            }
            growToAge(level, state, pos, 4, 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return getSeed();
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                Utils.preventCreativeDropFromBottomPart(level, pos, state, player, HALF);
            } else {
                dropResources(state, level, pos, null, player, player.getMainHandItem());
            }
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), blockEntity, stack);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HALF);
    }
}
