package com.auto1.lr.actions.menu;

import com.auto1.lr.logger.ConsoleLogger;

import java.io.Serializable;

/**
 * Alien location menu
 * Contains menu for game location that contains Aliens
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class AlienLocationMenu extends AbstractMenu implements Serializable {


    @Override
    public void showMenu() {
        getCommands().clear();
        getCommands().add("Fight");
        ConsoleLogger.log("Please select an action: ");
        showCommands();
        ConsoleLogger.log("> ");
    }
}
