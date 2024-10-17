package phrille.vanillaboom.block;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
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
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (VanillaBoomConfig.fillWaterBottleHydroRock && !stack.isEmpty() && stack.getItem() == Items.GLASS_BOTTLE) {
            if (world.dimensionType().ultraWarm()) {
                world.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                Utils.spawnParticles(ParticleTypes.SMOKE, world, pos.above());
            } else {
                fillBottle(stack, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));
                world.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                Utils.spawnParticles(ParticleTypes.SPLASH, world, pos.above());
            }

            return ActionResultType.sidedSuccess(world.isClientSide);
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    protected void fillBottle(ItemStack heldStack, PlayerEntity player, ItemStack newStack) {
        player.awardStat(Stats.ITEM_USED.get(heldStack.getItem()));
        DrinkHelper.createFilledResult(heldStack, player, newStack);
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        Direction direction = Direction.getRandom(rand);
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = world.getBlockState(blockpos);
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        if (direction != Direction.UP && !world.dimensionType().ultraWarm()) {
            if (!state.canOcclude() || !blockstate.isFaceSturdy(world, blockpos, direction.getOpposite())) {
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

                world.addParticle(ParticleTypes.DRIPPING_WATER, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        } else if (world.dimensionType().ultraWarm()) {
            y++;
            x += rand.nextDouble();
            z += rand.nextDouble();

            world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }
}
