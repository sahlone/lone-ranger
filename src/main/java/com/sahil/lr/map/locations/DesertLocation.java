package com.sahil.lr.map.locations;

import com.sahil.lr.logger.ConsoleLogger;
import com.sahil.lr.map.MapMarker;
import com.sahil.lr.actions.menu.AbstractMenu;
import com.sahil.lr.actions.menu.DesertMenu;

import java.io.Serializable;

/**
 * Desert location representation
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class DesertLocation extends Location implements Serializable {

    private DesertMenu locationMenu;

    private static final String DESCRIPTION = "Nothing interesting here";

    public DesertLocation(String name, int x, int y) {
        super(name, DESCRIPTION, null, LocationType.EMPTY, x, y, MapMarker.CLOSED);
        this.locationMenu = new DesertMenu();
    }

    /**
     * Print location information to the console
     */
    @Override
    public void printLocationInfo() {
       ConsoleLogger.log("You are at " + getName());
        ConsoleLogger.log(DESCRIPTION);
        ConsoleLogger.log("");
    }


    /**
     * Returns this location menu
     *
     * @return this location menu
     */
    @Override
    public AbstractMenu getLocationMenu() {
        return locationMenu;
    }

    /**
     * Print location menu to the console
     */
    @Override
    public void printLocationMenu() {
        locationMenu.showMenu();
    }
}
