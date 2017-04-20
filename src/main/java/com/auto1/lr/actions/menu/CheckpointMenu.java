package com.auto1.lr.actions.menu;

import com.auto1.lr.logger.ConsoleLogger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides logic to loading previously saved game
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class CheckpointMenu extends AbstractMenu {

    private String saveDirectory;

    public CheckpointMenu(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    @Override
    public void showMenu() {
        List<String> saveFiles = loadSaveFileNames();
        saveFiles.forEach(s -> getCommands().add(s));
        if (!getCommands().isEmpty()) {
            ConsoleLogger.log("Please select saved game to load");
            showCommands();
            ConsoleLogger.log("> ");
        } else {
            ConsoleLogger.log("No saved games found");
        }
    }

    /**
     * Scans directory with save files and populate list with file paths
     *
     * @return list of file paths
     */
    private List<String> loadSaveFileNames() {
        List<String> saveFiles = new ArrayList<>();
        File dir = new File(saveDirectory);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                saveFiles.add(file.getAbsolutePath());
            }
        }
        return saveFiles;
    }
}
