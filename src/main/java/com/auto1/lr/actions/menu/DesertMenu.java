package com.auto1.lr.actions.menu;

import com.auto1.lr.actions.Actions;
import com.auto1.lr.logger.ConsoleLogger;
import com.auto1.lr.map.locations.DesertLocation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Provide a list of actions available in the {@link DesertLocation}
 * to the user
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class DesertMenu extends AbstractMenu implements Serializable {


    @Override
    public void showMenu() {
        getCommands().clear();
        getCommands().addAll(names());
        ConsoleLogger.log("Please select an action: ");
        showCommands();
        ConsoleLogger.log("> ");
    }

    public static List<String> names() {
        return Arrays.asList(Arrays.toString(Actions.values()).replaceAll("^.|.$", "").split(", "));
    }
}
