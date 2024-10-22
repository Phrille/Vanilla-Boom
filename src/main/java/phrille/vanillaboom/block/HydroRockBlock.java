package phrille.vanillaboom.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HydroRockBlock extends Block {
    public HydroRockBlock() {
        super(Properties.copy(Blocks.PRISMARINE));
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (VanillaBoomConfig.fillWaterBottleHydroRock && stack.is(Items.GLASS_BOTTLE)) {
            if (level.dimensionType().ultraWarm()) {
                level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
                Utils.spawnParticles(ParticleTypes.SMOKE, level, pos.above());
            } else {
                fillBottle(stack, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));
                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                Utils.spawnParticles(ParticleTypes.SPLASH, level, pos.above());
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    protected void fillBottle(ItemStack heldStack, Player player, ItemStack newStack) {
        player.awardStat(Stats.ITEM_USED.get(heldStack.getItem()));
        ItemUtils.createFilledResult(heldStack, player, newStack);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random rand) {
        Direction direction = Direction.getRandom(rand);
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = level.getBlockState(blockpos);
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        if (direction != Direction.UP && !level.dimensionType().ultraWarm()) {
            if (!state.canOcclude() || !blockstate.isFaceSturdy(level, blockpos, direction.getOpposite())) {
                if (direction == Direction.DOWN) {
                    y = y - 0.05D;
                    x += rand.nextDouble();
                    z += rand.nextDouble();
                } else {
                    y = y + rand.nextDouble() * 0.8D;
                    if (direction.getAxis() == Direction.Axis.X) {
                        z += rand.nextDouble();
                        if (direction == Direction.EAST) {
                            x++;
                        } else {
                            x -= 0.03D;
                        }
                    } else {
                        x += rand.nextDouble();
                        if (direction == Direction.SOUTH) {
                            z++;
                        } else {
                            z -= 0.03D;
                        }
                    }
                }

                level.addParticle(ParticleTypes.DRIPPING_WATER, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        } else if (level.dimensionType().ultraWarm()) {
            y++;
            x += rand.nextDouble();
            z += rand.nextDouble();

            level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }
}
