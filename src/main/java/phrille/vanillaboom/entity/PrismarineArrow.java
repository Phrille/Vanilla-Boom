package phrille.vanillaboom.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class PrismarineArrow extends Arrow {
    public PrismarineArrow(EntityType<? extends PrismarineArrow> entityType, Level level) {
        super(entityType, level);
    }

    @SuppressWarnings("unused")
    public PrismarineArrow(FMLPlayMessages.SpawnEntity spawnPacket, Level level) {
        super(level, 0, 0, 0);
    }

    public PrismarineArrow(Level level, LivingEntity shooter) {
        super(level, shooter);
    }

    @Override
    public EntityType<?> getType() {
        return ModEntities.PRISMARINE_ARROW.get();
    }

    /**
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
