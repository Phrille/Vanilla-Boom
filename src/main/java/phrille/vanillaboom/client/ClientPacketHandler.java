/*
 * Copyright (C) 2025-2026 Phrille
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
import phrille.vanillaboom.block.BlockUtils;
import phrille.vanillaboom.client.screen.EaselScreen;
import phrille.vanillaboom.crafting.PaintingRecipe;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.network.LevelEventPacket;

import java.util.List;

public class ClientPacketHandler {
    public static void handleEaselRecipePacket(Player player, int containerId, List<RecipeHolder<PaintingRecipe>> recipes) {
        if (!(player instanceof LocalPlayer clientPlayer)) {
            return;
        }

        if (clientPlayer.containerMenu instanceof EaselMenu menu && menu.containerId == containerId) {
            if (Minecraft.getInstance().screen instanceof EaselScreen screen) {
                screen.updateRecipes(recipes);
            }
        }
    }

    public static void handleLevelEventPacket(Player player, BlockPos pos, LevelEventPacket.LevelEventType eventType) {
        if (!(player.level() instanceof ClientLevel level)) {
            return;
        }

        switch (eventType) {
            case WITHER_BONE_MEAL -> {
                BlockUtils.spawnParticles(ParticleTypes.SOUL, level, pos);
                level.playLocalSound(pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0f, 1.0f, false);
            }
            case MILK_COW -> level.playLocalSound(pos, SoundEvents.COW_MILK, SoundSource.BLOCKS, 1.0f, 1.0f, false);
        }
    }
}
