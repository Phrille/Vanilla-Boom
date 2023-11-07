package phrille.vanillaboom.block;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeMod;

public class RandomizerBlock extends DiodeBlock {
    public static final BooleanProperty NORTH_ON = BooleanProperty.create("north_on");
    public static final BooleanProperty WEST_ON = BooleanProperty.create("west_on");
    public static final BooleanProperty EAST_ON = BooleanProperty.create("east_on");

    protected static final VoxelShape TORCH_NORTH = Block.box(7.0D, 2.0D, 12.0D, 9.0D, 4.0D, 14.0D);
    protected static final VoxelShape TORCH_SOUTH = Block.box(7.0D, 2.0D, 2.0D, 9.0D, 4.0D, 4.0D);
    protected static final VoxelShape TORCH_WEST = Block.box(12.0D, 2.0D, 7.0D, 14.0D, 4.0D, 9.0D);
    protected static final VoxelShape TORCH_EAST = Block.box(2.0D, 2.0D, 7.0D, 4.0D, 4.0D, 9.0D);

    public RandomizerBlock() {
        super(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().sound(SoundType.WOOD));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, Boolean.valueOf(false)).setValue(NORTH_ON, Boolean.valueOf(false)).setValue(WEST_ON, Boolean.valueOf(false)).setValue(EAST_ON, Boolean.valueOf(false)));
    }

    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext context) {
        Direction dir = state.getValue(FACING);

        return switch (dir) {
            case NORTH -> Shapes.or(TORCH_NORTH, TORCH_WEST, TORCH_EAST, super.getShape(state, block, pos, context));
            case SOUTH -> Shapes.or(TORCH_SOUTH, TORCH_WEST, TORCH_EAST, super.getShape(state, block, pos, context));
            case WEST -> Shapes.or(TORCH_NORTH, TORCH_SOUTH, TORCH_WEST, super.getShape(state, block, pos, context));
            default -> Shapes.or(TORCH_NORTH, TORCH_SOUTH, TORCH_EAST, super.getShape(state, block, pos, context));
        };
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.PASS;
        } else {
            Vec3 viewVector = player.getViewVector(0.0F);
            double reach = player.getAttribute(ForgeMod.REACH_DISTANCE.get()).getValue();
            Vec3 rayPath = viewVector.scale(reach);

            Vec3 from = player.getEyePosition(0.0F);
            Vec3 to = from.add(rayPath);

            if (checkHit(from, to, pos, TORCH_NORTH)){
                System.out.print("NORTH TORCH");
            }
            else if (checkHit(from, to, pos, TORCH_EAST)){
                System.out.print("EAST TORCH");
            }
            else if (checkHit(from, to, pos, TORCH_WEST)){
                System.out.print("WEST TORCH");
            }
            else if (checkHit(from, to, pos, TORCH_SOUTH)){
                System.out.print("SOUTH TORCH");
            }


            //state = state.cycle(MODE);
            //float f = state.getValue(MODE) == RandomizerMode.STRENGTH ? 0.55F : 0.5F;
            //world.playSound(player, pos, SoundEvents.COMPARATOR_CLICK, SoundSource.BLOCKS, 0.3F, f);
            //world.setBlock(pos, state, 2);
            //refreshOutputState(world, pos, state);
            return InteractionResult.sidedSuccess(world.isClientSide);
        }
    }

    private boolean checkHit(Vec3 from, Vec3 to, BlockPos pos, VoxelShape shape){
        BlockHitResult hit = shape.clip(from, to, pos);
        return hit != null && hit.getType() != BlockHitResult.Type.MISS;
    }


    @Override
    protected int getDelay(BlockState state) {
        return 2;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, NORTH_ON, WEST_ON, EAST_ON);
    }
}
