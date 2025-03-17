package phrille.vanillaboom.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.crop.IWitherBonemealable;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.util.Utils;

public class WitherBoneMealItem extends Item {
    public WitherBoneMealItem() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (VanillaBoomConfig.witherBoneMealEnabled) {
            if (applyWitherBoneMeal(level, pos, context.getItemInHand())) {
                Utils.spawnParticles(ParticleTypes.SOUL, level, pos);
                level.playLocalSound(pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    public static boolean apply(ItemStack stack, Level level, BlockPos pos) {
        if (level instanceof ServerLevel) {
            return applyWitherBoneMeal(level, pos, stack);
        }
        return false;
    }

    protected static boolean applyWitherBoneMeal(Level level, BlockPos pos, ItemStack stack) {
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        if (block instanceof IWitherBonemealable witherBonemealable) {
            return growWitherBonemealable(witherBonemealable, level, pos, state, stack);
        } else if (block == Blocks.NETHER_WART) {
            return growNetherWarts(level, pos, state, stack);
        } else if (block == Blocks.VINE) {
            return witherVines(level, pos, state, stack);
        }
        return false;
    }

    protected static boolean growWitherBonemealable(IWitherBonemealable witherBonemealable, Level level, BlockPos pos, BlockState state, ItemStack stack) {
        if (witherBonemealable.isValidWitherBonemealTarget(level, pos, state, level.isClientSide)) {
            if (level instanceof ServerLevel) {
                if (witherBonemealable.isWitherBonemealSuccess(level, level.random, pos, state)) {
                    witherBonemealable.performWitherBonemeal((ServerLevel) level, level.random, pos, state);
                }
                stack.shrink(1);
            }
            return true;
        }
        return false;
    }

    protected static boolean growNetherWarts(Level level, BlockPos pos, BlockState state, ItemStack stack) {
        int age = state.getValue(NetherWartBlock.AGE);

        if (VanillaBoomConfig.growNetherWarts && age < NetherWartBlock.MAX_AGE) {
            if (level instanceof ServerLevel) {
                if (level.random.nextFloat() < 0.625F) {
                    level.setBlock(pos, state.setValue(NetherWartBlock.AGE, age + 1), 2);
                }
                stack.shrink(1);
            }
            return true;
        }
        return false;
    }

    protected static boolean witherVines(Level level, BlockPos pos, BlockState state, ItemStack stack) {
        if (VanillaBoomConfig.witherVines) {
            if (level instanceof ServerLevel) {
                BlockState witheredVineState = ModBlocks.WITHERED_VINE.get().defaultBlockState();
                level.setBlock(pos, Utils.copyState(state, witheredVineState), 2);
                stack.shrink(1);
            }
            return true;
        }
        return false;
    }
}
