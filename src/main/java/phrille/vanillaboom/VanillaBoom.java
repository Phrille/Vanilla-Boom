/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.event.lifecycle.InterModProcessEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.entity.ModBlockEntities;
import phrille.vanillaboom.config.VanillaBoomConfig;
import phrille.vanillaboom.entity.ModAttachmentTypes;
import phrille.vanillaboom.entity.ModEntityTypes;
import phrille.vanillaboom.inventory.ModMenuTypes;
import phrille.vanillaboom.crafting.ModRecipes;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.loot.ModGlobalLootModifiers;
import phrille.vanillaboom.util.ModDispenserBehavior;
import phrille.vanillaboom.util.ModStats;
import phrille.vanillaboom.util.Utils;

@Mod(VanillaBoom.MOD_ID)
public class VanillaBoom {
    public static final String MOD_ID = "vanillaboom";
    public static final Logger LOGGER = LogManager.getLogger();

    public VanillaBoom(IEventBus eventBus, ModContainer modContainer) {
        ModEntityTypes.ENTITY_TYPES.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(eventBus);
        ModAttachmentTypes.ATTACHMENT_TYPES.register(eventBus);
        ModRecipes.RECIPE_SERIALIZERS.register(eventBus);
        ModRecipes.RECIPE_TYPES.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);
        ModGlobalLootModifiers.GLOBAL_LOOT_MODIFIERS.register(eventBus);
        ModStats.STATS.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);

        modContainer.registerConfig(ModConfig.Type.COMMON, VanillaBoomConfig.SPEC);
    }

    public void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModStats.registerStats();
            Utils.registerFlowerPots();
            Utils.registerShearedTallFlowers();
            Utils.registerTrellisCrops();
            ModDispenserBehavior.registerWitherBonemealBehavior();
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
    }

    private void enqueueIMC(InterModEnqueueEvent event) {
    }

    private void processIMC(InterModProcessEvent event) {
    }

    public static ResourceLocation resLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(VanillaBoom.MOD_ID, path);
    }
}
