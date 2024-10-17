package phrille.vanillaboom.block;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import phrille.vanillaboom.block.tile.RainDetectorTileEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RainDetectorBlock extends ContainerBlock {
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    public RainDetectorBlock() {
        super(Properties.copy(Blocks.DAYLIGHT_DETECTOR));
        registerDefaultState(stateDefinition.any().setValue(INVERTED, false).setValue(POWER, 0));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (player.mayBuild()) {
            if (world.isClientSide) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState blockstate = state.cycle(INVERTED);
                world.setBlock(pos, blockstate, 4);
                updateSignalStrength(blockstate, world, pos);

                return ActionResultType.CONSUME;
            }
        } else {
            return super.use(state, world, pos, player, hand, hit);
        }
    }

    public static void updateSignalStrength(BlockState state, World world, BlockPos pos) {
        if (world.dimensionType().hasSkyLight()) {
            boolean inverted = state.getValue(INVERTED);
            int power = world.isThundering() ? 2 : world.isRaining() ? 1 : 0;

            if (inverted) {
                power = 15 - power;
            }

            if (state.getValue(POWER) != power) {
                world.setBlock(pos, state.setValue(POWER, MathHelper.clamp(power, 0, 15)), 3);
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public int getSignal(BlockState state, IBlockReader reader, BlockPos pos, Direction direction) {
        return state.getValue(POWER);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new RainDetectorTileEntity();
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWER, INVERTED);
    }
}
