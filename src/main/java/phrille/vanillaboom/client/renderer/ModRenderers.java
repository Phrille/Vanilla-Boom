/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client.renderer;

import net.minecraft.client.model.SalmonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.client.model.EelModel;
import phrille.vanillaboom.client.model.PerchModel;
import phrille.vanillaboom.client.model.TunaModel;
import phrille.vanillaboom.entity.ModEntityTypes;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ModRenderers {
    public static final ModelLayerLocation PERCH_MODEL = new ModelLayerLocation(VanillaBoom.resLoc("perch_model"), "perch_model");
    public static final ModelLayerLocation TUNA_MODEL = new ModelLayerLocation(VanillaBoom.resLoc("tuna_model"), "tuna_model");
    public static final ModelLayerLocation EEl_MODEL = new ModelLayerLocation(VanillaBoom.resLoc("eel_model"), "eel_model");

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.PRISMARINE_ARROW.get(), PrismarineArrowRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.PERCH.get(), context -> new FishRenderer(context, new PerchModel<>(context.bakeLayer(ModRenderers.PERCH_MODEL))));
        event.registerEntityRenderer(ModEntityTypes.TUNA.get(), context -> new FishRenderer(context, new TunaModel<>(context.bakeLayer(ModRenderers.TUNA_MODEL))));
        event.registerEntityRenderer(ModEntityTypes.PIKE.get(), context -> new FishRenderer(context, new SalmonModel<>(context.bakeLayer(ModelLayers.SALMON))));
        event.registerEntityRenderer(ModEntityTypes.EEL.get(), context -> new FishRenderer(context, new EelModel<>(context.bakeLayer(ModRenderers.EEl_MODEL))));
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PERCH_MODEL, PerchModel::createBodyLayer);
        event.registerLayerDefinition(TUNA_MODEL, TunaModel::createBodyLayer);
        event.registerLayerDefinition(EEl_MODEL, EelModel::createBodyLayer);
    }
}