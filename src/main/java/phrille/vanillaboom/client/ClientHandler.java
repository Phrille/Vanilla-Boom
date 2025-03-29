/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.client.screen.EaselClientTooltip;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.inventory.EaselTooltip;
import phrille.vanillaboom.inventory.ModMenuTypes;

@EventBusSubscriber(modid = VanillaBoom.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientHandler {
    @SubscribeEvent
    public static void registerMenuScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.EASEL_MENU.get(), EaselScreen::new);
    }

    @SubscribeEvent
    public static void registerTooltipComponents(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(EaselTooltip.class, (tooltip) -> new EaselClientTooltip(tooltip.ingredients()));
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
