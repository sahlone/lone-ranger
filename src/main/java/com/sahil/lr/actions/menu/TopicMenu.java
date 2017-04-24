package com.sahil.lr.actions.menu;

import com.sahil.lr.logger.CentralizedLogger;
import com.sahil.lr.logger.ConsoleLogger;
import com.sahil.lr.logger.LogLevel;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Provides text UI for showing basic theme.
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class TopicMenu extends AbstractMenu {

    private static final String ASSETS_TOPICS = "assets/topic.txt";
    public static final String DEAFAULT_TOPICS = "Lone Ranger";


    @Override
    public void showMenu() {
        try {
            Stream<String> lines = parseFile(ASSETS_TOPICS);
            lines.forEach(s -> getCommands().add(s));
            showCommands();
            System.out.print("> ");
        } catch (IOException ex) {
            exitWithError("Could not load game.Look into logs");
            CentralizedLogger.log(LogLevel.ERROR, "", ex);
        }
    }

    @Override
    protected void showCommands() {
        for (int i = 0; i < getCommands().size(); i++) {
            ConsoleLogger.log(getCommands().get(i));
        }
    }


}
