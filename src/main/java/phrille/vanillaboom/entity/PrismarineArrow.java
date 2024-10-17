package phrille.vanillaboom.entity;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import phrille.vanillaboom.item.ModItems;

@MethodsReturnNonnullByDefault
public class PrismarineArrow extends ArrowEntity {
    public PrismarineArrow(EntityType<? extends PrismarineArrow> entityType, World world) {
        super(entityType, world);
    }

    @SuppressWarnings("unused")
    public PrismarineArrow(FMLPlayMessages.SpawnEntity spawnPacket, World world) {
        super(world, 0, 0, 0);
    }

    public PrismarineArrow(World world, LivingEntity shooter) {
        super(world, shooter);
    }

    @Override
    public EntityType<?> getType() {
        return ModEntities.PRISMARINE_ARROW.get();
    }


    @Override
    protected void onHitEntity(EntityRayTraceResult raytrace) {
        if (raytrace.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = raytrace.getEntity();

            if (entity.fireImmune()) {
                setBaseDamage(getBaseDamage() * 1.1F);
            }
        }

        super.onHitEntity(raytrace);
    }


    @Override
    public IPacket<?> getAddEntityPacket() {
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
