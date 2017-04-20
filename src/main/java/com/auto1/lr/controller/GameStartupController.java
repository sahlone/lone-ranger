package com.auto1.lr.controller;

import com.auto1.lr.logger.ConsoleLogger;
import com.auto1.lr.model.GameContext;
import com.auto1.lr.data.GameContextRepository;
import com.auto1.lr.actions.ActionsExecutor;
import com.auto1.lr.actions.menu.MainMenu;
import com.auto1.lr.actions.menu.Menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * controller  for startup
 * It all started here
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class GameStartupController {

    public void startupGame() {
        printBanner();
        Menu mainMenu = new MainMenu();
        GameContextRepository gameContextRepository = new GameContextRepository();
        GamePlayController gamePlayController = new GamePlayController(gameContextRepository);
        boolean modeSelected = false;
        while (!modeSelected) {
            mainMenu.showMenu();
            int selectionIndex = mainMenu.getSelectionIndex();
            if (1 == selectionIndex) {
                modeSelected = true;
                gamePlayController.startGame();
            } else if (2 == selectionIndex) {
                modeSelected = true;
                GameContext gameContext = ActionsExecutor.load(GamePlayController.DATA_DIR);
                if (gameContext != null) {
                    gameContextRepository.setGameContext(gameContext);
                    gamePlayController.continueGame();
                } else {
                    gamePlayController.startGame();
                }
            } else if (3 == selectionIndex) {
                ActionsExecutor.exit();
            }
        }
    }

    /**
     * ASCII art
     */
    private static void printBanner() {
        try {
            String banner = new String(Files.readAllBytes(Paths.get("assets/banner.txt")));
            ConsoleLogger.log(banner);
        } catch (IOException e) {
            ConsoleLogger.log("Just Play and understand");
        }
    }
}
