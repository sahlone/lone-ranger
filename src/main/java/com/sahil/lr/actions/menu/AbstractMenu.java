package com.sahil.lr.actions.menu;

import com.sahil.lr.logger.ConsoleLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Basic  abstract {@link Menu} interface implementation
 * contains common logic
 * Should be extended by each {@link Menu} implementation
 *
 * @author Sahil Lone
 * @since 1.0
 */
public abstract class AbstractMenu implements Menu {

    private Scanner scanner = new Scanner(System.in);

    private List<String> commands = new ArrayList<>();


    @Override
    public int getSelectionIndex() {
        int result;
        while (true) {
            try {
                result = scanner.nextInt();
                if (result < 0 || result > commands.size()) {
                    ConsoleLogger.log("No a valid input. Please try again.");
                    ConsoleLogger.log(">");
                } else {
                    ConsoleLogger.log("");
                    return result;
                }
            } catch (Exception e) {
                ConsoleLogger.log("No a valid input");
            }
        }
    }


    @Override
    public String getCommandByIndex(int index) {
        return commands.get(index - 1);
    }

    /**
     * Parse text file by given absolute path and return {@link Stream} of it's content
     *
     * @param filePath - absolute file path
     * @return {@link Stream} of the file lines
     * @throws IOException if file parsing fails
     */
    protected Stream<String> parseFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.lines(path);
    }

    /**
     * Prints formatted list of commands to the console
     */
    protected void showCommands() {
        for (int i = 0; i < commands.size(); i++) {
            int printIndex = i + 1;
            ConsoleLogger.log("    " + printIndex + ". " + commands.get(i));
        }
    }

    /**
     * Display given errors to the player and exit the game
     *
     * @param message - error message to display
     */
    protected void exitWithError(String message) {
        ConsoleLogger.log(message);
        System.exit(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getCommands() {
        return commands;
    }

}
