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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.client.model.EelModel;
import phrille.vanillaboom.client.model.PerchModel;
import phrille.vanillaboom.client.model.TunaModel;
import phrille.vanillaboom.entity.ModEntities;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ModRenderers {
    public static final ModelLayerLocation PERCH_MODEL = new ModelLayerLocation(VanillaBoom.resLoc("perch_model"), "perch_model");
    public static final ModelLayerLocation TUNA_MODEL = new ModelLayerLocation(VanillaBoom.resLoc("tuna_model"), "tuna_model");
    public static final ModelLayerLocation EEl_MODEL = new ModelLayerLocation(VanillaBoom.resLoc("eel_model"), "eel_model");

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.PRISMARINE_ARROW.get(), PrismarineArrowRenderer::new);
        event.registerEntityRenderer(ModEntities.PERCH.get(), context -> new FishRenderer(context, new PerchModel<>(context.bakeLayer(ModRenderers.PERCH_MODEL))));
        event.registerEntityRenderer(ModEntities.TUNA.get(), context -> new FishRenderer(context, new TunaModel<>(context.bakeLayer(ModRenderers.TUNA_MODEL))));
        event.registerEntityRenderer(ModEntities.PIKE.get(), context -> new FishRenderer(context, new SalmonModel<>(context.bakeLayer(ModelLayers.SALMON))));
        event.registerEntityRenderer(ModEntities.EEL.get(), context -> new FishRenderer(context, new EelModel<>(context.bakeLayer(ModRenderers.EEl_MODEL))));
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PERCH_MODEL, PerchModel::createBodyLayer);
        event.registerLayerDefinition(TUNA_MODEL, TunaModel::createBodyLayer);
        event.registerLayerDefinition(EEl_MODEL, EelModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) ->
                        event.getBlockColors().getColor(Blocks.VINE.defaultBlockState(), level, pos, tintIndex),
                ModBlocks.WITHERED_VINE.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) ->
                        event.getItemColors().getColor(new ItemStack(Blocks.VINE), tintIndex),
                ModBlocks.WITHERED_VINE.get()
        );
    }
}