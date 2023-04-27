package phrille.vanillaboom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.util.Utils;

public class HydroRockBlock extends Block {
    public HydroRockBlock() {
        super(Properties.copy(Blocks.PRISMARINE));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (VanillaBoomConfig.fillWaterBottleHydroRock && stack.is(Items.GLASS_BOTTLE)) {
            if (world.dimensionType().ultraWarm()) {
                world.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
                Utils.spawnParticles(ParticleTypes.SMOKE, world, pos.above());
            } else {
                fillBottle(stack, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));
                world.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                Utils.spawnParticles(ParticleTypes.SPLASH, world, pos.above());
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    protected ItemStack fillBottle(ItemStack heldStack, Player player, ItemStack newStack) {
        player.awardStat(Stats.ITEM_USED.get(heldStack.getItem()));
        return ItemUtils.createFilledResult(heldStack, player, newStack);
    }

    /**
     @Override public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
     Direction direction = Direction.getRandomDirection(rand);
     BlockPos blockpos = pos.offset(direction);
     BlockState blockstate = world.getBlockState(blockpos);

     if (blockstate.getFluidState().isEmpty() && (!blockstate.isSolid() || !blockstate.isSolidSide(world, blockpos, direction.getOpposite()))) {
     Direction.Axis direction$axis = direction.getAxis();
     double d1 = direction.getXOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getXOffset() * 0.6D;
     double d2 = direction.getYOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getYOffset() * 0.6D;
     double d3 = direction.getZOffset() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getZOffset() * 0.6D;

     if (rand.nextInt(2) == 0) {
     if (world.getDimensionType().isUltrawarm() && direction != Direction.DOWN) {
     world.addParticle(ParticleTypes.SMOKE, (double) pos.getX() + d1, (double) pos.getY() + d2, (double) pos.getZ() + d3, 0.0D, 0.0D, 0.0D);
     } else if (direction != Direction.UP) {
     world.addParticle(ParticleTypes.DRIPPING_WATER, (double) pos.getX() + d1, (double) pos.getY() + d2, (double) pos.getZ() + d3, 0.0D, 0.0D, 0.0D);
     }
     }
     }
     }
     */
}
