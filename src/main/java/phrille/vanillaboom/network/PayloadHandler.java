package phrille.vanillaboom.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import phrille.vanillaboom.VanillaBoom;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PayloadHandler {
    @SubscribeEvent
    public static void register(RegisterPayloadHandlerEvent event) {
        IPayloadRegistrar registrar = event.registrar(VanillaBoom.MOD_ID);
        registrar.play(EaselRecipePayload.ID, EaselRecipePayload::new, handler -> handler
                .client(EaselRecipePayload::handle));
    }
}
