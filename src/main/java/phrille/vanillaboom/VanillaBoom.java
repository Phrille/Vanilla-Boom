/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.entity.ModBlockEntities;
import phrille.vanillaboom.client.ClientUtils;
import phrille.vanillaboom.config.ConfigHandler;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.inventory.ModMenuTypes;
import phrille.vanillaboom.inventory.recipe.ModRecipes;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.loot.ModGlobalLootModifiers;
import phrille.vanillaboom.network.ModNetwork;
import phrille.vanillaboom.util.ModDispenserBehavior;
import phrille.vanillaboom.util.ModStats;
import phrille.vanillaboom.util.Utils;

@Mod(VanillaBoom.MOD_ID)
public class VanillaBoom {
    public static final String MOD_ID = "vanillaboom";
    public static final Logger LOGGER = LogManager.getLogger();

    public VanillaBoom() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModNetwork.register();
        ModEntities.ENTITY_TYPES.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(eventBus);
        ModRecipes.RECIPE_SERIALIZERS.register(eventBus);
        ModRecipes.RECIPE_TYPES.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);
        ModGlobalLootModifiers.GLOBAL_LOOT_MODIFIERS.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
    }

    public void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModStats.register();
            Utils.addCompostMaterials();
            Utils.registerBurnTimes();
            Utils.registerFlowerPots();
            Utils.registerShearedTallFlowers();
            Utils.registerTrellisCrops();
            Utils.registerCandleCakes();
            ModDispenserBehavior.registerWitherBonemealBehavior();
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ClientUtils::registerMenuScreen);
    }

    private void enqueueIMC(InterModEnqueueEvent event) {
    }

    private void processIMC(InterModProcessEvent event) {
    }

    public static ResourceLocation resLoc(String path) {
        return new ResourceLocation(VanillaBoom.MOD_ID, path);
    }
}
