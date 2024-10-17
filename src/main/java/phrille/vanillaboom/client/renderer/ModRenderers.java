package phrille.vanillaboom.client.renderer;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.model.SalmonModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.client.model.EelModel;
import phrille.vanillaboom.client.model.PerchModel;
import phrille.vanillaboom.client.model.TunaModel;
import phrille.vanillaboom.entity.ModEntities;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRenderers {

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PRISMARINE_ARROW.get(), PrismarineArrowRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TUNA.get(), renderManager -> new FishRenderer(renderManager, new TunaModel<>()));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PERCH.get(), renderManager -> new FishRenderer(renderManager, new PerchModel<>()));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PIKE.get(), renderManager -> new FishRenderer(renderManager, new SalmonModel<>()));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.EEL.get(), renderManager -> new FishRenderer(renderManager, new EelModel<>()));

        RenderTypeLookup.setRenderLayer(ModBlocks.MAGMA_CREAM_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_SOUL_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.SPRUCE_LADDER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BIRCH_LADDER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.JUNGLE_LADDER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ACACIA_LADDER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DARK_OAK_LADDER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CRIMSON_LADDER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.WARPED_LADDER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_BARS.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.ROSE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_ROSE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TOMATO_PLANT.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.RICE_PLANT.get(), RenderType.cutout());
    }
}