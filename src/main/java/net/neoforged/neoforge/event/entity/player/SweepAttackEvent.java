/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SweepAttackEvent extends PlayerEvent {
    private final Entity target;
    private final boolean vanillaAllowSweepPreconditions, itemSupportSweep, disabledByCrit;

    private boolean allowSweep;

    public SweepAttackEvent(Player player, Entity target, boolean vanillaAllowSweepPreconditions, boolean itemSupportSweep, boolean disabledByCrit) {
        super(player);
        this.target = target;
        this.vanillaAllowSweepPreconditions = vanillaAllowSweepPreconditions;
        this.itemSupportSweep = itemSupportSweep;
        this.disabledByCrit = disabledByCrit;
        this.allowSweep = vanillaAllowSweepPreconditions && itemSupportSweep && !disabledByCrit;
    }

    /**
     * @return Attack target
     */
    public Entity getTarget() {
        return target;
    }

    /**
     * @return true if the attack would have been a sweep attack by vanilla's rules in {@link Player#attack(Entity)}, other than the condition of not critical hit.
     */
    public boolean vanillaAllowSweepPreconditions() {
        return vanillaAllowSweepPreconditions;
    }

    /**
     * @return true if the attack weapon support sweep attack.
     */
    public boolean itemSupportSweep() {
        return itemSupportSweep;
    }

    /**
     * @return true if the sweep attack would be disabled by critical hit
     */
    public boolean sweepDisabledByCrit() {
        return disabledByCrit;
    }

    /**
     * @return true if the attack would have been a sweep attack by vanilla's rules in {@link Player#attack(Entity)}.
     */
    public boolean vanillaAllowSweep() {
        return vanillaAllowSweepPreconditions && itemSupportSweep && !disabledByCrit;
    }

    /**
     * @return true if the sweep attack would happen
     */
    public boolean allowSweep() {
        return allowSweep;
    }

    /**
     * @param sweep Whether to enable sweep attack for this attack
     */
    public void setAllowSweep(boolean sweep) {
        allowSweep = sweep;
    }
}
