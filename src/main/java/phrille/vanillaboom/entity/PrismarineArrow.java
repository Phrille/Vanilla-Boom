package phrille.vanillaboom.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class PrismarineArrow extends Arrow {
    public PrismarineArrow(EntityType<? extends PrismarineArrow> entityType, Level level) {
        super(entityType, level);
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
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
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
