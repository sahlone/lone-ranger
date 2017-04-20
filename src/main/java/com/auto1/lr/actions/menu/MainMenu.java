package com.auto1.lr.actions.menu;

import com.auto1.lr.logger.ConsoleLogger;

/**
 * Main game menu. Give access to main games function such as
 * 1. Start new game;
 * 2. Load previously saved game
 * 3. Show user's manual
 * 4. Exit the game
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class MainMenu extends AbstractMenu {


    @Override
    public void showMenu() {
        ConsoleLogger.log("Main Menu:");
        addCommandIfNotExist("Start new game");
        addCommandIfNotExist("Load game");
        addCommandIfNotExist("Exit");
        showCommands();
        ConsoleLogger.log("> ");
    }

    private void addCommandIfNotExist(String command) {
        if (!getCommands().contains(command)) {
            getCommands().add(command);
        }
    }
}
