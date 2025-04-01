/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.fish.Eel;
import phrille.vanillaboom.entity.fish.Perch;
import phrille.vanillaboom.entity.fish.Pike;
import phrille.vanillaboom.entity.fish.Tuna;

import java.util.function.Supplier;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, VanillaBoom.MOD_ID);

    public static final Supplier<EntityType<PrismarineArrow>> PRISMARINE_ARROW = register("prismarine_arrow", EntityType.Builder.<PrismarineArrow>of(PrismarineArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));
    public static final Supplier<EntityType<Tuna>> TUNA = register("tuna", EntityType.Builder.of(Tuna::new, MobCategory.WATER_AMBIENT).sized(0.6F, 0.6F).clientTrackingRange(4));
    public static final Supplier<EntityType<Perch>> PERCH = register("perch", EntityType.Builder.of(Perch::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.3F).clientTrackingRange(4));
    public static final Supplier<EntityType<Pike>> PIKE = register("pike", EntityType.Builder.of(Pike::new, MobCategory.WATER_AMBIENT).sized(0.7F, 0.4F).clientTrackingRange(4));
    public static final Supplier<EntityType<Eel>> EEL = register("eel", EntityType.Builder.of(Eel::new, MobCategory.WATER_AMBIENT).sized(0.8F, 0.2F).clientTrackingRange(4));

    public static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(name));
    }

    @SubscribeEvent
    public static void registerEntities(EntityAttributeCreationEvent event) {
        event.put(TUNA.get(), AbstractFish.createAttributes().build());
        event.put(PERCH.get(), AbstractFish.createAttributes().build());
        event.put(PIKE.get(), AbstractFish.createAttributes().build());
        event.put(EEL.get(), AbstractFish.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(TUNA.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(PERCH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(PIKE.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(EEL.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);
    }
}
