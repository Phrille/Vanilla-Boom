package phrille.vanillaboom.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.PistonType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.util.Utils;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class ItemEventHandler {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        ItemStack stack = event.getItemStack();
        Player player = event.getPlayer();

        if (event.isCanceled() || stack.isEmpty()) {
            return;
        }

        if (VanillaBoomConfig.growNetherWarts && tryGrowNetherWart(world, player, state, pos, stack)) {
            return;
        }

        if (VanillaBoomConfig.growWitherRoses && tryGrowWitherRose(world, player, state, pos, stack)) {
            return;
        }

        if (VanillaBoomConfig.removeSlimeBallPistons && tryRemoveSlimeBall(world, player, state, pos, stack, event.getHand())) {
        }
    }

    //TODO: replace item check with tags
    protected static boolean tryGrowNetherWart(Level world, Player player, BlockState state, BlockPos pos, ItemStack stack) {
        if (state.getBlock() == Blocks.NETHER_WART && (stack.is(Items.BLAZE_POWDER) || stack.is(ModItems.WITHER_BONE_MEAL))) {
            int age = state.getValue(NetherWartBlock.AGE);

            if (age < NetherWartBlock.MAX_AGE) {
                if (world.random.nextFloat() < 0.625F) {
                    state = state.setValue(NetherWartBlock.AGE, Integer.valueOf(age + 1));
                    world.setBlock(pos, state, 2);
                }

                Utils.spawnParticles(ParticleTypes.FLAME, world, pos);
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));

                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                return true;
            }
        }

        return false;
    }

    protected static boolean tryGrowWitherRose(Level world, Player player, BlockState state, BlockPos pos, ItemStack stack) {
        if (state.getBlock() == ModBlocks.ROSE && stack.is(ModItems.WITHER_BONE_MEAL)) {
            if (world.random.nextFloat() < 0.25F) {
                world.setBlock(pos, Blocks.WITHER_ROSE.defaultBlockState(), 2);
            }

            Utils.spawnParticles(ParticleTypes.SMOKE, world, pos);
            player.awardStat(Stats.ITEM_USED.get(stack.getItem()));

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            return true;
        }

        return false;
    }

    //TODO: check tag instead of ShovelItem
    protected static boolean tryRemoveSlimeBall(Level world, Player player, BlockState state, BlockPos pos, ItemStack stack, InteractionHand hand) {
        if (stack.getItem() instanceof ShovelItem && player.isCrouching()) {
            if (state.getBlock() == Blocks.STICKY_PISTON && !state.getValue(PistonBaseBlock.EXTENDED)) {
                Direction direction = state.getValue(PistonBaseBlock.FACING);
                world.setBlock(pos, Blocks.PISTON.defaultBlockState().setValue(PistonBaseBlock.FACING, direction), 2);
                onSuccess(world, pos, player, stack, hand, direction);

                return true;
            } else if (state.getBlock() == Blocks.PISTON_HEAD && state.getValue(PistonHeadBlock.TYPE) == PistonType.STICKY) {
                Direction direction = state.getValue(PistonHeadBlock.FACING);
                world.setBlock(pos, Blocks.PISTON_HEAD.defaultBlockState().setValue(PistonHeadBlock.TYPE, PistonType.DEFAULT).setValue(PistonHeadBlock.FACING, direction), 2);
                world.setBlock(pos.relative(direction, -1), Blocks.PISTON.defaultBlockState().setValue(PistonBaseBlock.EXTENDED, Boolean.valueOf(true)).setValue(PistonBaseBlock.FACING, direction), 2);
                onSuccess(world, pos, player, stack, hand, direction);

                return true;
            }
        }

        return false;
    }

    protected static void onSuccess(Level world, BlockPos pos, Player player, ItemStack stack, InteractionHand hand, Direction direction) {
        if (!player.isCreative()) {
            stack.hurtAndBreak(1, player, (entity) -> {
                entity.broadcastBreakEvent(hand);
            });
        }

        Block.popResourceFromFace(world, pos, direction, new ItemStack(Items.SLIME_BALL));
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        world.playSound(null, pos, SoundEvents.CHICKEN_EGG, SoundSource.BLOCKS, 1.0F, 1.0F);
    }
}