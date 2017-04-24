package com.sahil.lr.actions.menu;

import java.util.List;

/**
 * Menu interface. Define the required function for each menu in the game
 *
 * @author Sahil Lone
 * @since 1.0
 */
public interface Menu {

    /**
     * Print the menu
     */
    void showMenu();

    /**
     * Get console value
     * Validates it.
     *
     * @return index of player's selected value
     */
    int getSelectionIndex();

    /**
     * Get command from list commands list by given index
     *
     * @param index of the selected command
     * @return string representation of selected command
     */
    String getCommandByIndex(int index);

    /**
     * Return list of available commands commands
     *
     * @return list of available commands commands
     */
    List<String> getCommands();
}
