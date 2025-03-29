/*
 * Copyright (C) 2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;

public class EaselSlot extends Slot {
    private final EaselMenu menu;

    public EaselSlot(Container container, int index, int x, int y, EaselMenu easelMenu) {
        super(container, index, x, y);
        menu = easelMenu;
    }

    @Override
    public void setChanged() {
        super.setChanged();
        menu.slotsChanged(this.container);
    }
}
