package com.sahil.lr.model;

import com.sahil.lr.map.locations.LocationItem;

/**
 * This class deals with Non Player Character (Fighter) and all of their properties.
 */
public class NPC extends Player implements LocationItem {

    private final int expCost;

    public NPC(String name, int health, int experience, int damage, int defence, int expCost) {
        super(name, health, experience, damage, defence);
        this.expCost = expCost;
    }

    public int getExpCost() {
        return expCost;
    }
}
