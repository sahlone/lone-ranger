package com.auto1.lr.actions.menu;

import com.auto1.lr.logger.ConsoleLogger;
import com.auto1.lr.model.GameContext;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Players menu representation
 * Provides user to select character from the list loaded
 * from appropriate topic file
 *
 * @author Sahil Lone
 * @since 1.0
 */

public class PlayerMenu extends AbstractMenu {

    private GameContext gameContext;
    private static final String PLAYERS="assets/players.txt";

    public PlayerMenu(GameContext gameContext) {
        this.gameContext = gameContext;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showMenu() {
        String topicKey = gameContext.getTopic().replaceAll(" ", "_").toLowerCase();
        try {
            Stream<String> availablePlayers = parseFile(PLAYERS);
            availablePlayers.forEach(s -> getCommands().add(s));
            ConsoleLogger.log("You will act as :");
            showCommands();
            System.out.print("> ");
        } catch (IOException e) {
            exitWithError("Could not load " + topicKey + " file. Please verify that file exist.");
        }

    }

    @Override
    protected void showCommands() {
        for (int i = 0; i < getCommands().size(); i++) {
            ConsoleLogger.log(getCommands().get(i));
        }
    }

    @Override
    public int getSelectionIndex() {
        return 1;
    }

}
