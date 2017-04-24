package com.auto1.lr.map.locations;

import com.auto1.lr.logger.ConsoleLogger;
import com.auto1.lr.map.MapMarker;
import com.auto1.lr.actions.menu.AlienLocationMenu;
import com.auto1.lr.actions.menu.AbstractMenu;
import com.auto1.lr.actions.menu.DesertMenu;
import com.auto1.lr.actions.menu.Menu;

import java.io.Serializable;

/**
 * Fighter location class represents map
 * location with fighter that should be defeated
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class FighterLocation extends Location implements Serializable {

    private static final String DESCRIPTION = "to Fighter's location";

    private AlienLocationMenu locationMenu;

    private DesertMenu desertMenu;

    private Menu currentMenu;

    public FighterLocation(String name,
                           int x, int y, LocationItem monster) {
        super(name, DESCRIPTION, monster, LocationType.FIGHTER, x, y, MapMarker.CLOSED);
        this.locationMenu = new AlienLocationMenu();
        this.desertMenu = new DesertMenu();
        this.currentMenu = locationMenu;

    }

    /**
     * Print location information to the console
     */
    @Override
    public void printLocationInfo() {
        ConsoleLogger.log("You got into fighter's cave.");
        if (getLocationItem() == null && LocationType.EMPTY.equals(getLocationType())) {
            ConsoleLogger.log("But it's empty.");
            this.currentMenu = desertMenu;
        } else {
            ConsoleLogger.log("Old and evil fighter lives here.");
            ConsoleLogger.log("He saw you and attacks.");

        }
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
     * Print location info to the console
     */
    @Override
    public void printLocationMenu() {
        this.currentMenu.showMenu();
    }
}
