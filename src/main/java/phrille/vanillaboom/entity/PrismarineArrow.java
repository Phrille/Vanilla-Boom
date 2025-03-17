package phrille.vanillaboom.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.util.ModTags;

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

    @Override
    protected void onHitEntity(EntityHitResult result) {
        double baseDamage = getBaseDamage();
        Entity entity = result.getEntity();

        if (isExtraHurtTarget(entity)) {
            setBaseDamage(baseDamage * 1.5D);
        }

        super.onHitEntity(result);
        setBaseDamage(baseDamage);
    }

    public boolean isExtraHurtTarget(Entity entity) {
        return entity.getType().is(ModTags.VanillaBoomTags.Entities.PRISMARINE_EXTRA_HURT);
    }

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
