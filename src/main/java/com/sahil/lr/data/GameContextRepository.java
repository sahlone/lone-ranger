package com.sahil.lr.data;

import com.sahil.lr.model.GameContext;

/**
 * Holds current {@link GameContext} instance
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class GameContextRepository {

    private GameContext gameContext;

    /**
     * Check if game context exist. Create new if game context is null
     * and return current game context
     *
     * @return current {@link GameContext} instance
     */
    public GameContext getGameContext() {
        if (gameContext == null) {
            gameContext = new GameContext();
        }
        return gameContext;
    }

    /**
     * Set's given {@link GameContext} instance for global availability
     *
     * @param gameContext instance to be set
     */
    public void setGameContext(GameContext gameContext) {
        this.gameContext = gameContext;
    }


}
