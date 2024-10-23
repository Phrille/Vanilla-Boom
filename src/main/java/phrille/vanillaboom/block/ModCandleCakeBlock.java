package phrille.vanillaboom.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ModCandleCakeBlock extends CandleCakeBlock {
    private final Supplier<Block> parent;
    private final Supplier<Block> candle;

    @SuppressWarnings("ConstantConditions")
    public ModCandleCakeBlock(Supplier<Block> candle, Supplier<Block> parent) {
        super(null, BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE));
        this.candle = candle;
        this.parent = parent;
    }

    protected static boolean candleHit(BlockHitResult result) {
        return result.getLocation().y - (double) result.getBlockPos().getY() > 0.5D;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (!stack.is(Items.FLINT_AND_STEEL) && !stack.is(Items.FIRE_CHARGE)) {
            if (candleHit(hit) && player.getItemInHand(hand).isEmpty() && state.getValue(LIT)) {
                extinguish(player, state, level, pos);

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                InteractionResult interactionresult = ModCakeBlock.eat(level, pos, parent.get().defaultBlockState(), player);

                if (interactionresult.consumesAction()) {
                    dropResources(state, level, pos);
                }

                return interactionresult;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(parent.get());
    }

    public Block getCandle() {
        return candle.get();
    }
}