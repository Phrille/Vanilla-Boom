package phrille.vanillaboom.item;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.PistonType;
import net.minecraft.stats.Stats;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        ItemStack stack = event.getItemStack();
        PlayerEntity player = event.getPlayer();

        if (event.isCanceled() || stack.isEmpty()) {
            return;
        }

        Item item = stack.getItem();
        Event.Result result = Event.Result.DEFAULT;

        if (item.is(ModTags.ForgeTags.Items.WITHER_BONE_MEALS)) {
            result = useWitherBoneMeal(world, player, state, pos, stack);
        } else if (item.is(Tags.Items.SLIMEBALLS)) {
            result = useSlimeBall(world, player, state, pos, stack);
        } else if (item instanceof AxeItem && player.isCrouching()) {
            result = removeSlimeBall(world, player, state, pos, stack, event.getHand());
        }

        event.setUseBlock(result);
    }

    protected static Event.Result useWitherBoneMeal(World world, PlayerEntity player, BlockState state, BlockPos pos, ItemStack stack) {
        if (state.getBlock() == Blocks.NETHER_WART) {
            if (!VanillaBoomConfig.growNetherWarts) {
                return Event.Result.DEFAULT;
            }

            int age = state.getValue(NetherWartBlock.AGE);

            if (age < 3) {
                if (!world.isClientSide) {
                    if (world.random.nextFloat() < 0.625F) {
                        world.setBlock(pos, state.setValue(NetherWartBlock.AGE, age + 1), 2);
                    }
                }
            } else {
                return Event.Result.DEFAULT;
            }
        } else if (state.getBlock() == ModBlocks.ROSE.get() && stack.getItem().is(ModTags.ForgeTags.Items.WITHER_BONE_MEALS)) {
            if (!VanillaBoomConfig.growWitherRoses) {
                return Event.Result.DEFAULT;
            }

            if (!world.isClientSide) {
                if (world.random.nextFloat() < 0.25F) {
                    world.setBlock(pos, Blocks.WITHER_ROSE.defaultBlockState(), 2);
                }
            }
        } else {
            return Event.Result.DEFAULT;
        }

        Utils.spawnParticles(ParticleTypes.SMOKE, world, pos);
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        if (!player.isCreative()) {
            stack.shrink(1);
        }

        return Event.Result.DENY;
    }

    protected static Event.Result useSlimeBall(World world, PlayerEntity player, BlockState state, BlockPos pos, ItemStack stack) {
        if (!VanillaBoomConfig.placeSlimeBallPistons) {
            return Event.Result.DEFAULT;
        }

        if (state.getBlock() == Blocks.PISTON && !state.getValue(PistonBlock.EXTENDED)) {
            Direction direction = state.getValue(PistonBlock.FACING);
            if (!world.isClientSide) {
                world.setBlock(pos, Blocks.STICKY_PISTON.defaultBlockState().setValue(PistonBlock.FACING, direction), 2);
            }
        } else if (state.getBlock() == Blocks.PISTON_HEAD && state.getValue(PistonHeadBlock.TYPE) == PistonType.DEFAULT) {
            Direction direction = state.getValue(PistonBlock.FACING);
            if (!world.isClientSide) {
                world.setBlock(pos, Blocks.PISTON_HEAD.defaultBlockState().setValue(PistonHeadBlock.TYPE, PistonType.STICKY).setValue(PistonHeadBlock.FACING, direction), 2);
                world.setBlock(pos.relative(direction, -1), Blocks.STICKY_PISTON.defaultBlockState().setValue(PistonBlock.EXTENDED, true).setValue(PistonBlock.FACING, direction), 2);
            }
        } else {
            return Event.Result.DEFAULT;
        }

        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        world.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        if (!player.isCreative()) {
            stack.shrink(1);
        }

        return Event.Result.DENY;
    }

    protected static Event.Result removeSlimeBall(World world, PlayerEntity player, BlockState state, BlockPos pos, ItemStack stack, Hand hand) {
        if (!VanillaBoomConfig.removeSlimeBallPistons) {
            return Event.Result.DEFAULT;
        }

        if (state.getBlock() == Blocks.STICKY_PISTON && !state.getValue(PistonBlock.EXTENDED)) {
            Direction direction = state.getValue(PistonBlock.FACING);
            if (!world.isClientSide) {
                world.setBlock(pos, Blocks.PISTON.defaultBlockState().setValue(PistonBlock.FACING, direction), 2);
            }
        } else if (state.getBlock() == Blocks.PISTON_HEAD && state.getValue(PistonHeadBlock.TYPE) == PistonType.STICKY) {
            Direction direction = state.getValue(PistonHeadBlock.FACING);
            if (!world.isClientSide) {
                world.setBlock(pos, Blocks.PISTON_HEAD.defaultBlockState().setValue(PistonHeadBlock.TYPE, PistonType.DEFAULT).setValue(PistonHeadBlock.FACING, direction), 2);
                world.setBlock(pos.relative(direction, -1), Blocks.PISTON.defaultBlockState().setValue(PistonBlock.EXTENDED, true).setValue(PistonBlock.FACING, direction), 2);
            }
        } else {
            return Event.Result.DEFAULT;
        }

        Block.popResource(world, pos, new ItemStack(Items.SLIME_BALL));
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        world.playSound(null, pos, SoundEvents.CHICKEN_EGG, SoundCategory.BLOCKS, 1.0F, 1.0F);
        if (!player.isCreative()) {
            stack.hurtAndBreak(1, player, entity -> entity.broadcastBreakEvent(hand));
        }

        return Event.Result.DENY;
    }
}