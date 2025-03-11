package phrille.vanillaboom.client;

import net.minecraft.client.gui.screens.MenuScreens;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.inventory.ModMenuTypes;

public class ClientUtils {
    public static void registerMenuScreen() {
        MenuScreens.register(ModMenuTypes.EASEL_MENU.get(), EaselScreen::new);
    }
}
