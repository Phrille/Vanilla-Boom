package phrille.vanillaboom.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.fish.Eel;
import phrille.vanillaboom.entity.fish.Perch;
import phrille.vanillaboom.entity.fish.Pike;
import phrille.vanillaboom.entity.fish.Tuna;
import phrille.vanillaboom.util.Utils;

@ObjectHolder(VanillaBoom.MOD_ID)
public class ModEntities {
    public static final EntityType<PrismarineArrow> PRISMARINE_ARROW = Utils._null();
    public static final EntityType<Tuna> TUNA = Utils._null();
    public static final EntityType<Perch> PERCH = Utils._null();
    public static final EntityType<Pike> PIKE = Utils._null();
    public static final EntityType<Eel> EEL = Utils._null();

    @Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
            IForgeRegistry<EntityType<?>> registry = event.getRegistry();

            registry.register(build("prismarine_arrow", EntityType.Builder.<PrismarineArrow>of(PrismarineArrow::new, MobCategory.MISC).setCustomClientFactory((spawnEntity, world) -> new PrismarineArrow(PRISMARINE_ARROW, world)).sized(0.5F, 0.5F)));
            registry.register(build("tuna", EntityType.Builder.of(Tuna::new, MobCategory.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new Tuna(TUNA, world)).sized(0.6F, 0.6F).clientTrackingRange(4)));
            registry.register(build("perch", EntityType.Builder.of(Perch::new, MobCategory.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new Perch(PERCH, world)).sized(0.5F, 0.3F).clientTrackingRange(4)));
            registry.register(build("pike", EntityType.Builder.of(Pike::new, MobCategory.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new Pike(PIKE, world)).sized(0.7F, 0.4F).clientTrackingRange(4)));
            registry.register(build("eel", EntityType.Builder.of(Eel::new, MobCategory.WATER_AMBIENT).setCustomClientFactory((spawnEntity, world) -> new Eel(EEL, world)).sized(0.8F, 0.2F).clientTrackingRange(4)));
        }

        @SubscribeEvent
        public static void registerEntities(EntityAttributeCreationEvent event) {
            event.put(TUNA, AbstractFish.createAttributes().build());
            event.put(PERCH, AbstractFish.createAttributes().build());
            event.put(PIKE, AbstractFish.createAttributes().build());
            event.put(EEL, AbstractFish.createAttributes().build());
        }

        public static void registerSpawnPlacements() {
            SpawnPlacements.register(TUNA, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractFish::checkFishSpawnRules);
            SpawnPlacements.register(PERCH, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractFish::checkFishSpawnRules);
            SpawnPlacements.register(PIKE, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractFish::checkFishSpawnRules);
            SpawnPlacements.register(EEL, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractFish::checkFishSpawnRules);
        }

        private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
            ResourceLocation registryName = new ResourceLocation(VanillaBoom.MOD_ID, name);
            EntityType<T> entityType = builder.build(registryName.toString());
            entityType.setRegistryName(registryName);

            return entityType;
        }
    }
}
