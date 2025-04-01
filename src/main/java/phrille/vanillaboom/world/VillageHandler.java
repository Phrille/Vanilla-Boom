/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.config.VanillaBoomConfig;

import java.util.ArrayList;
import java.util.Objects;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID)
public class VillageHandler {
    private static final ResourceLocation PLAINS_HOUSES = ResourceLocation.withDefaultNamespace("village/plains/houses");
    private static final ResourceLocation DESERT_HOUSES = ResourceLocation.withDefaultNamespace("village/desert/houses");
    private static final ResourceLocation SAVANNA_HOUSES = ResourceLocation.withDefaultNamespace("village/savanna/houses");

    @SubscribeEvent
    public static void onTagsUpdated(TagsUpdatedEvent event) {
        if (event.getUpdateCause() != TagsUpdatedEvent.UpdateCause.SERVER_DATA_LOAD) return;

        if (!VanillaBoomConfig.generateVillageStructures) return;

        RegistryAccess registryAccess = event.getRegistryAccess();
        VanillaBoom.LOGGER.info("Registering custom Village structures");
        addToPool(registryAccess, PLAINS_HOUSES, "plains_small_farm_1", 3);
        addToPool(registryAccess, DESERT_HOUSES, "desert_farm_1", 7);
        addToPool(registryAccess, DESERT_HOUSES, "desert_farm_2", 4);
        addToPool(registryAccess, SAVANNA_HOUSES, "savanna_large_farm_1", 7);
        addToPool(registryAccess, SAVANNA_HOUSES, "savanna_large_farm_2", 4);
    }

    private static void addToPool(RegistryAccess registryAccess, ResourceLocation poolId, String add, int weight) {
        addToPool(registryAccess, poolId, VanillaBoom.resLoc(poolId.getPath() + "/" + add), weight);
    }

    /**
     * Modified version of Villages#addToPool from Immersive Engineering.
     * See: <a href="https://github.com/BluSunrize/ImmersiveEngineering/blob/1.19.4/src/main/java/blusunrize/immersiveengineering/common/world/Villages.java">Villages.java</a>
     *
     * @author BluSunrize
     * @author Phrille
     */
    private static void addToPool(RegistryAccess registryAccess, ResourceLocation poolId, ResourceLocation add, int weight) {
        Registry<StructureTemplatePool> registry = registryAccess.registryOrThrow(Registries.TEMPLATE_POOL);
        StructureTemplatePool pool = Objects.requireNonNull(registry.get(poolId), poolId.getPath());

        if (!(pool.rawTemplates instanceof ArrayList)) {
            pool.rawTemplates = new ArrayList<>(pool.rawTemplates);
        }

        SinglePoolElement addedElement = SinglePoolElement.single(add.toString()).apply(StructureTemplatePool.Projection.RIGID);
        pool.rawTemplates.add(Pair.of(addedElement, weight));

        for (int i = 0; i < weight; i++) {
            pool.templates.add(addedElement);
        }
    }
}
