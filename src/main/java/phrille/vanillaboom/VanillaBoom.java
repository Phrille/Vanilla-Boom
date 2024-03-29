package phrille.vanillaboom;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.entity.ModBlockEntities;
import phrille.vanillaboom.config.ConfigHandler;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.item.ModItems;
import phrille.vanillaboom.loot.LootTableHandler;
import phrille.vanillaboom.util.FuelHandler;
import phrille.vanillaboom.util.Utils;
import phrille.vanillaboom.world.ModFeatures;

@Mod(VanillaBoom.MOD_ID)
public class VanillaBoom {
    public static final String MOD_ID = "vanillaboom";
    public static final Logger LOGGER = LogManager.getLogger();

    public VanillaBoom() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.ENTITIES.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(eventBus);
        ModFeatures.ConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        ModFeatures.PlacedFeatures.PLACED_FEATURES.register(eventBus);
        LootTableHandler.GLMS.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
    }

    public void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModEntities.registerSpawnPlacements();
            FuelHandler.registerBurnTimes();
            Utils.registerFlowerPots();
            Utils.addCompostMaterials();
            Utils.registerCandleCakes();
        });
    }

    private void enqueueIMC(InterModEnqueueEvent event) {
    }

    private void processIMC(InterModProcessEvent event) {
    }
}
