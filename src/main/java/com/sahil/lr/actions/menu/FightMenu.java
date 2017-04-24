package com.sahil.lr.actions.menu;

import com.sahil.lr.logger.ConsoleLogger;

import java.io.Serializable;

/**
 * Fight menu class contains menu commands
 * that player can use during battle
 *
 * @author Sahil lone
 * @since 1.0
 */
public class FightMenu extends AbstractMenu implements Serializable {


    @Override
    public void showMenu() {
        getCommands().clear();
        getCommands().add("Fight with Hands");
        getCommands().add("You can use your super power");
        ConsoleLogger.log("What would you like to do?");
        showCommands();
        ConsoleLogger.log(">");
    }
}
