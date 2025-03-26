package phrille.vanillaboom.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import phrille.vanillaboom.VanillaBoom;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PayloadHandler {
    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(Integer.toString(1));
        registrar.playToClient(
                EaselRecipePayload.TYPE,
                EaselRecipePayload.STREAM_CODEC,
                EaselRecipePayload::handle
        );
    }
}
