package com.auto1.lr.model;

import com.auto1.lr.map.locations.LocationItem;

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
