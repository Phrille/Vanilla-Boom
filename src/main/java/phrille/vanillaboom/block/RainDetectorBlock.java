package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import phrille.vanillaboom.block.entity.ModBlockEntities;
import phrille.vanillaboom.block.entity.RainDetectorBlockEntity;

import javax.annotation.Nullable;

public class RainDetectorBlock extends BaseEntityBlock {
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    public RainDetectorBlock(BlockBehaviour.Properties builder) {
        super(builder);
        registerDefaultState(stateDefinition.any().setValue(INVERTED, false).setValue(POWER, 0));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.mayBuild()) {
            if (world.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState blockstate = state.cycle(INVERTED);
                world.setBlock(pos, blockstate, 4);
                updateSignalStrength(blockstate, world, pos);

                return InteractionResult.CONSUME;
            }
        } else {
            return super.use(state, world, pos, player, hand, hit);
        }
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> entityType) {
        return !world.isClientSide && world.dimensionType().hasSkyLight() ? createTickerHelper(entityType, ModBlockEntities.RAIN_DETECTOR.get(), RainDetectorBlock::tickEntity) : null;
    }

    private static void tickEntity(Level world, BlockPos pos, BlockState state, RainDetectorBlockEntity blockEntity) {
        if (world.getGameTime() % 20L == 0L) {
            updateSignalStrength(state, world, pos);
        }
    }

    private static void updateSignalStrength(BlockState state, Level world, BlockPos pos) {
        if (world.dimensionType().hasSkyLight()) {
            boolean inverted = state.getValue(INVERTED);
            int power = world.isThundering() ? 2 : world.isRaining() ? 1 : 0;

            if (inverted) {
                power = 15 - power;
            }

            if (state.getValue(POWER) != power) {
                world.setBlock(pos, state.setValue(POWER, Integer.valueOf(Mth.clamp(power, 0, 15))), 3);
            }
        }
    }

    @Override
    public int getSignal(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
        return state.getValue(POWER);
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RainDetectorBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER, INVERTED);
    }
}
