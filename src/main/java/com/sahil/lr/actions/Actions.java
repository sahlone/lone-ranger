package com.sahil.lr.actions;

/**
 * Contains all  game commands,
 * which could be called from different places
 *
 * @author Sahil Lone
 * @since 1.0
 */
public enum Actions {

    /**
     *  GOTO North in Matrix
     */
    NORTH,
    /**
     * Go South in Matrix
     */
    SOUTH,
    /**
     * Go West in Matrix
     */
    WEST,
    /**
     * Go East in Matrix
     */
    EAST,
    /**
     * Save the current state of game
     */
    SAVE,

    /**
     * Load previously saved Game position
     */
    LOAD,
    /**
     * SHow Map [Matrix]
     */
    MAP,
    /**
     * Fight Enemy
     */
    FIGHT,
    /**
     * Stats Listing
     */
    STATISTICS,
    /**
     * Run Away
     */
    RUN,
    /**
     * Exit JVM
     */
    EXIT
}
