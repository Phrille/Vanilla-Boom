package phrille.vanillaboom.handler;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.PistonType;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.util.ModTags;
import phrille.vanillaboom.util.Utils;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class ItemEventHandler {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = event.getItemStack();
        Player player = event.getEntity();

        if (event.isCanceled() || stack.isEmpty()) {
            return;
        }

        Event.Result result = Event.Result.DEFAULT;

        if (stack.is(ModTags.ForgeTags.Items.WITHER_BONE_MEALS)) {
            result = useWitherBoneMeal(level, player, state, pos, stack);
        } else if (stack.is(Tags.Items.SLIMEBALLS)) {
            result = useSlimeBall(level, player, state, pos, stack);
        } else if (stack.is(ItemTags.AXES) && player.isCrouching()) {
            result = removeSlimeBall(level, player, state, pos, stack, event.getHand());
        }

        event.setUseBlock(result);
    }

    protected static Event.Result useWitherBoneMeal(Level level, Player player, BlockState state, BlockPos pos, ItemStack stack) {
        if (state.getBlock() == Blocks.NETHER_WART) {
            if (!VanillaBoomConfig.growNetherWarts) {
                return Event.Result.DEFAULT;
            }

            int age = state.getValue(NetherWartBlock.AGE);

            if (age < 3) {
                if (!level.isClientSide) {
                    if (level.random.nextFloat() < 0.625F) {
                        level.setBlock(pos, state.setValue(NetherWartBlock.AGE, age + 1), 2);
                    }
                }
            } else {
                return Event.Result.DEFAULT;
            }
        } else if (state.getBlock() == ModBlocks.ROSE.get()) {
            if (!VanillaBoomConfig.growWitherRoses) {
                return Event.Result.DEFAULT;
            }

            if (!level.isClientSide) {
                if (level.random.nextFloat() < 0.25F) {
                    level.setBlock(pos, Blocks.WITHER_ROSE.defaultBlockState(), 2);
                }
            }
        } else {
            return Event.Result.DEFAULT;
        }

        Utils.spawnParticles(ParticleTypes.SMOKE, level, pos);
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        if (!player.isCreative()) {
            stack.shrink(1);
        }

        return Event.Result.DENY;
    }

    protected static Event.Result useSlimeBall(Level level, Player player, BlockState state, BlockPos pos, ItemStack stack) {
        if (!VanillaBoomConfig.placeSlimeBallPistons) {
            return Event.Result.DEFAULT;
        }

        if (state.getBlock() == Blocks.PISTON && !state.getValue(PistonBaseBlock.EXTENDED)) {
            Direction direction = state.getValue(PistonBaseBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.STICKY_PISTON.defaultBlockState().setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else if (state.getBlock() == Blocks.PISTON_HEAD && state.getValue(PistonHeadBlock.TYPE) == PistonType.DEFAULT) {
            Direction direction = state.getValue(PistonBaseBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.PISTON_HEAD.defaultBlockState().setValue(PistonHeadBlock.TYPE, PistonType.STICKY).setValue(PistonHeadBlock.FACING, direction), 2);
                level.setBlock(pos.relative(direction, -1), Blocks.STICKY_PISTON.defaultBlockState().setValue(PistonBaseBlock.EXTENDED, true).setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else {
            return Event.Result.DEFAULT;
        }

        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (!player.isCreative()) {
            stack.shrink(1);
        }

        return Event.Result.DENY;
    }

    protected static Event.Result removeSlimeBall(Level level, Player player, BlockState state, BlockPos pos, ItemStack stack, InteractionHand hand) {
        if (!VanillaBoomConfig.removeSlimeBallPistons) {
            return Event.Result.DEFAULT;
        }

        if (state.getBlock() == Blocks.STICKY_PISTON && !state.getValue(PistonBaseBlock.EXTENDED)) {
            Direction direction = state.getValue(PistonBaseBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.PISTON.defaultBlockState().setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else if (state.getBlock() == Blocks.PISTON_HEAD && state.getValue(PistonHeadBlock.TYPE) == PistonType.STICKY) {
            Direction direction = state.getValue(PistonHeadBlock.FACING);
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.PISTON_HEAD.defaultBlockState().setValue(PistonHeadBlock.TYPE, PistonType.DEFAULT).setValue(PistonHeadBlock.FACING, direction), 2);
                level.setBlock(pos.relative(direction, -1), Blocks.PISTON.defaultBlockState().setValue(PistonBaseBlock.EXTENDED, true).setValue(PistonBaseBlock.FACING, direction), 2);
            }
        } else {
            return Event.Result.DEFAULT;
        }

        Block.popResource(level, pos, new ItemStack(Items.SLIME_BALL));
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        level.playSound(null, pos, SoundEvents.CHICKEN_EGG, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (!player.isCreative()) {
            stack.hurtAndBreak(1, player, entity -> entity.broadcastBreakEvent(hand));
        }

        return Event.Result.DENY;
    }
}