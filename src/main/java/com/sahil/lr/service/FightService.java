package com.auto1.lr.service;

import com.auto1.lr.model.Player;
import com.auto1.lr.map.locations.Location;

/**
 * Basic interface for handling battles between player and different NPC
 *
 * @author Sahil Lone
 * @since 1.0
 */
public interface FightService {

    /**
     * Executes battle logic
     *
     * @param hero     - player
     * @param location - Fighters location
     * @return updated {@link Location}
     */
    Location battle(Player hero, Location location);
}
