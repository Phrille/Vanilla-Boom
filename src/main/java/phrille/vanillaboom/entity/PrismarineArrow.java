package phrille.vanillaboom.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import phrille.vanillaboom.item.ModItems;

public class PrismarineArrow extends Arrow {
    public PrismarineArrow(EntityType<? extends PrismarineArrow> entityType, Level world) {
        super(entityType, world);
    }

    public PrismarineArrow(FMLPlayMessages.SpawnEntity spawnPacket, Level world) {
        super(world, 0, 0, 0);
    }

    public PrismarineArrow(Level world, LivingEntity shooter) {
        super(world, shooter);
    }

    @Override
    public EntityType<?> getType() {
        return ModEntities.PRISMARINE_ARROW.get();
    }

    /**
    @Override
    protected void onEntityHit(EntityRayTraceResult raytrace) {
        if (raytrace.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) raytrace).getEntity();

            if (entity.isImmuneToFire()) {
                setDamage(getDamage() * 1.1F);
            }
        }

        super.onEntityHit(raytrace);
    }*/

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected float getWaterInertia() {
        return 1.0F;
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.PRISMARINE_ARROW.get());
    }
}
