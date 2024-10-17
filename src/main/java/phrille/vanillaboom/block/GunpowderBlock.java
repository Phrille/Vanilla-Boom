package phrille.vanillaboom.block;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GunpowderBlock extends FallingBlock {

    public GunpowderBlock() {
        super(AbstractBlock.Properties
                .of(Material.SAND, MaterialColor.COLOR_LIGHT_GRAY)
                .harvestTool(ToolType.SHOVEL)
                .strength(0.5F)
                .sound(SoundType.SAND));
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        boolean isFlintAndSteel = stack.getItem() instanceof FlintAndSteelItem;

        if (stack.isEmpty() || (!isFlintAndSteel && stack.getItem() != Items.FIRE_CHARGE)) {
            return super.use(state, world, pos, player, hand, hit);
        } else {
            catchFire(state, world, pos, hit.getDirection(), player);

            Item item = stack.getItem();
            if (!player.isCreative()) {
                if (isFlintAndSteel) {
                    stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
                } else {
                    stack.shrink(1);
                }
            }

            player.awardStat(Stats.ITEM_USED.get(item));
            return ActionResultType.SUCCESS;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onProjectileHit(World world, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
        if (!world.isClientSide) {
            if (projectile.isOnFire()) {
                Entity owner = projectile.getOwner();
                catchFire(state, world, hit.getBlockPos(), null, owner instanceof LivingEntity ? (LivingEntity) owner : null);
            }
        }
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader reader, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
        explode(world, pos, igniter);
    }

    @Override
    public void wasExploded(World world, BlockPos pos, Explosion explosion) {
        catchFire(world.getBlockState(pos), world, pos, null, explosion.getSourceMob());
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean dropFromExplosion(Explosion explosion) {
        return false;
    }

    protected void explode(World world, BlockPos pos, @Nullable Entity entity) {
        if (!world.isClientSide) {
            world.explode(entity, pos.getX(), pos.getY(), pos.getZ(), 1.0F, true, Explosion.Mode.DESTROY);
        }
    }
}
