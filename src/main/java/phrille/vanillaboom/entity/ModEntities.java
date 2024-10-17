package phrille.vanillaboom.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.fish.Eel;
import phrille.vanillaboom.entity.fish.Perch;
import phrille.vanillaboom.entity.fish.Pike;
import phrille.vanillaboom.entity.fish.Tuna;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, VanillaBoom.MOD_ID);

    public static final RegistryObject<EntityType<PrismarineArrow>> PRISMARINE_ARROW = register("prismarine_arrow", EntityType.Builder.<PrismarineArrow>of(PrismarineArrow::new, EntityClassification.MISC).setCustomClientFactory(PrismarineArrow::new).sized(0.5F, 0.5F));
    public static final RegistryObject<EntityType<Tuna>> TUNA = register("tuna", EntityType.Builder.of(Tuna::new, EntityClassification.WATER_AMBIENT).sized(0.6F, 0.6F).clientTrackingRange(4));
    public static final RegistryObject<EntityType<Perch>> PERCH = register("perch", EntityType.Builder.of(Perch::new, EntityClassification.WATER_AMBIENT).sized(0.5F, 0.3F).clientTrackingRange(4));
    public static final RegistryObject<EntityType<Pike>> PIKE = register("pike", EntityType.Builder.of(Pike::new, EntityClassification.WATER_AMBIENT).sized(0.7F, 0.4F).clientTrackingRange(4));
    public static final RegistryObject<EntityType<Eel>> EEL = register("eel", EntityType.Builder.of(Eel::new, EntityClassification.WATER_AMBIENT).sized(0.8F, 0.2F).clientTrackingRange(4));

    public static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }

    @SubscribeEvent
    public static void registerEntities(EntityAttributeCreationEvent event) {
        event.put(TUNA.get(), AbstractFishEntity.createAttributes().build());
        event.put(PERCH.get(), AbstractFishEntity.createAttributes().build());
        event.put(PIKE.get(), AbstractFishEntity.createAttributes().build());
        event.put(EEL.get(), AbstractFishEntity.createAttributes().build());
    }

    public static void registerSpawnPlacements() {
        EntitySpawnPlacementRegistry.register(TUNA.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(PERCH.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(PIKE.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(EEL.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::checkFishSpawnRules);
    }
}
