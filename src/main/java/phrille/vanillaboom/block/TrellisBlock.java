package phrille.vanillaboom.block;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
import java.util.Map;

@ParametersAreNonnullByDefault
public class TrellisBlock extends Block {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final VoxelShape TRELLIS_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final Map<ItemLike, ITrellisCrop> TRELLIS_CROPS = Maps.newHashMap();

    public TrellisBlock(Properties builder) {
        super(builder);
        registerDefaultState(stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return TrellisBlock.TRELLIS_SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlock = state.getValue(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleBlock == DoubleBlockHalf.LOWER != (direction == Direction.UP) || neighborState.is(this) && neighborState.getValue(HALF) != doubleBlock) {
            return doubleBlock == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }
        return Blocks.AIR.defaultBlockState();
    }

    @Override
    @Nullable
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
    @SuppressWarnings("deprecation")
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
        return belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(Blocks.FARMLAND);
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (!TRELLIS_CROPS.containsKey(stack.getItem())) {
            return InteractionResult.PASS;
        }

        level.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
        ITrellisCrop cropBlock = TRELLIS_CROPS.get(stack.getItem());

        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            pos = pos.below();
        }

        cropBlock.placeAt(level, pos);
        return InteractionResult.sidedSuccess(level.isClientSide);
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
        builder.add(HALF);
    }

    public void registerTrellisCrop(ITrellisCrop trellisCrop) {
        TRELLIS_CROPS.put(trellisCrop.getSeed(), trellisCrop);
    }
}
