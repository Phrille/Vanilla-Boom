package phrille.vanillaboom.block;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class ModCakeBlock extends CakeBlock {

    private final Map<CandleBlock, ModCandleCakeBlock> CANDLE_CAKES = Maps.newHashMap();

    public ModCakeBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.CAKE));
    }

    public static InteractionResult eat(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
        return CakeBlock.eat(world, pos, state, player);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.is(ItemTags.CANDLES) && state.getValue(BITES) == 0) {
            Block candle = Block.byItem(stack.getItem());

            if (candle instanceof CandleBlock) {
                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                world.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.setBlockAndUpdate(pos, byCandle((CandleBlock) candle).defaultBlockState());
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                return InteractionResult.SUCCESS;
            }
        }

        if (world.isClientSide) {
            if (CakeBlock.eat(world, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (stack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return CakeBlock.eat(world, pos, state, player);
    }

    public Block byCandle(CandleBlock candle) {
        return CANDLE_CAKES.get(candle);
    }

    public void addCandleCake(ModCandleCakeBlock candleCake){
        CANDLE_CAKES.put((CandleBlock) candleCake.getCandle(), candleCake);
    }
}
