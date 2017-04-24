package com.sahil.lr.application;

import com.sahil.lr.controller.GameStartupController;

/**
 * Main class of the application
 *
 * @author Sahil lone
 * @since 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {
        new GameStartupController().startupGame();
    }
}
