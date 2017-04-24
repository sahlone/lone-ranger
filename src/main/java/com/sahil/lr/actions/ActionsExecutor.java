package com.auto1.lr.actions;

import com.auto1.lr.actions.menu.CheckpointMenu;
import com.auto1.lr.actions.menu.Menu;
import com.auto1.lr.logger.CentralizedLogger;
import com.auto1.lr.logger.ConsoleLogger;
import com.auto1.lr.logger.LogLevel;
import com.auto1.lr.model.GameContext;

import java.io.*;

/**
 * Actions executor to show side effects of Actions performed
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class ActionsExecutor {

    /**
     * Iterate over "save" directory and output to the user's console
     * list of all saved games in menu view (numbered list, with ability to select)
     * Deserialize selected file to {@link GameContext} class instance and return it.
     *
     * @param saveDirectory directory contains save game files
     * @return deserialized file to {@link GameContext} class instance
     */
    public static GameContext load(String saveDirectory) {
        Menu gameLoadMenu = new CheckpointMenu(saveDirectory);
        gameLoadMenu.showMenu();
        if (gameLoadMenu.getCommands().isEmpty()) {
            return null;
        }
        int selectionIndex = gameLoadMenu.getSelectionIndex();
        String selectedFile = gameLoadMenu.getCommandByIndex(selectionIndex);
        ConsoleLogger.log("Loading game....");
        try {
            ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(selectedFile)));
            return (GameContext) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            ConsoleLogger.log("Error occurred during loading the game.");
            CentralizedLogger.log(LogLevel.ERROR, "Error occurred during loading the game : ", e);
            return null;
        }
    }

    /**
     * Serialize given {@link GameContext} instance to the file under "save" directory
     * with current timestamp as file name
     *
     * @param gameContext to serialize
     */

    public static void save(GameContext gameContext, String name, String saveDirectory) {
        ConsoleLogger.log("Saving current game....");
        try {

            File saveDir = new File(saveDirectory);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(saveDirectory + "/" + name + ".data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameContext);
            ConsoleLogger.log("Saved game to the file: " + name + ".data ");
        } catch (IOException e) {
            ConsoleLogger.log("Could not save game.");
            CentralizedLogger.log(LogLevel.ERROR, "Could not save game: ", e);
        }
    }

    /**
     * Exit from the game
     */
    public static void exit() {
        ConsoleLogger.log("Thanks you for playing. See you Soon.");
        System.exit(0);
    }
}
