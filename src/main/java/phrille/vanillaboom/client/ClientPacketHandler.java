/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeHolder;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.crafting.PaintingRecipe;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.util.Utils;

import java.util.List;

public class ClientPacketHandler {
    public static void handleEaselRecipePacket(Player player, int containerId, List<RecipeHolder<PaintingRecipe>> recipes) {
        if (player instanceof LocalPlayer clientPlayer) {
            if (clientPlayer.containerMenu instanceof EaselMenu menu && menu.containerId == containerId) {
                if (Minecraft.getInstance().screen instanceof EaselScreen screen) {
                    screen.updateRecipes(recipes);
                }
            }
        }
    }

    public static void handleWitherBoneMealPacket(Player player, BlockPos pos) {
        if (player.level() instanceof ClientLevel level) {
            Utils.spawnParticles(ParticleTypes.SOUL, level, pos);
            level.playLocalSound(pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
        }
    }
}
