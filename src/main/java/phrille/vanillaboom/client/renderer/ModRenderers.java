package phrille.vanillaboom.client.renderer;

import net.minecraft.client.model.SalmonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.client.model.EelModel;
import phrille.vanillaboom.client.model.PerchModel;
import phrille.vanillaboom.client.model.TunaModel;
import phrille.vanillaboom.entity.ModEntities;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ModRenderers {

    public static final ModelLayerLocation PERCH_MODEL = new ModelLayerLocation(new ResourceLocation(VanillaBoom.MOD_ID, "perch_model"), "perch_model");
    public static final ModelLayerLocation TUNA_MODEL = new ModelLayerLocation(new ResourceLocation(VanillaBoom.MOD_ID, "tuna_model"), "tuna_model");
    public static final ModelLayerLocation EEl_MODEL = new ModelLayerLocation(new ResourceLocation(VanillaBoom.MOD_ID, "eel_model"), "eel_model");

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGMA_CREAM_BLOCK, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGENTA_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAY_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_STAINED_SOUL_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_LADDER, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIRCH_LADDER, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.JUNGLE_LADDER, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ACACIA_LADDER, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_OAK_LADDER, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRIMSON_LADDER, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARPED_LADDER, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOLD_BARS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROSE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ROSE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOMATO_PLANT, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RICE_PLANT, RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.PRISMARINE_ARROW, context -> new PrismarineArrowRenderer(context));
        event.registerEntityRenderer(ModEntities.PERCH, context -> new FishRenderer(context, new PerchModel<>(context.bakeLayer(ModRenderers.PERCH_MODEL))));
        event.registerEntityRenderer(ModEntities.TUNA, context -> new FishRenderer(context, new TunaModel<>(context.bakeLayer(ModRenderers.TUNA_MODEL))));
        event.registerEntityRenderer(ModEntities.PIKE, context -> new FishRenderer(context, new SalmonModel<>(context.bakeLayer(ModelLayers.SALMON))));
        event.registerEntityRenderer(ModEntities.EEL, context -> new FishRenderer(context, new EelModel<>(context.bakeLayer(ModRenderers.EEl_MODEL))));
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PERCH_MODEL, PerchModel::createBodyLayer);
        event.registerLayerDefinition(TUNA_MODEL, TunaModel::createBodyLayer);
        event.registerLayerDefinition(EEl_MODEL, EelModel::createBodyLayer);
    }
}