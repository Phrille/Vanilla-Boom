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
import phrille.vanillaboom.loot.LootTableHandler;
import phrille.vanillaboom.util.FuelHandler;
import phrille.vanillaboom.util.Utils;

@Mod(VanillaBoom.MOD_ID)
public class VanillaBoom {
    public static final String MOD_ID = "vanillaboom";
    public static final Logger LOGGER = LogManager.getLogger();

    public VanillaBoom() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);

        ModBlocks.init(eventBus);
        LootTableHandler.init(eventBus);
        ModBlockEntities.init(eventBus);

        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHandler.CLIENT_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
    }

    public void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModEntities.RegistrationHandler.registerSpawnPlacements();
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
