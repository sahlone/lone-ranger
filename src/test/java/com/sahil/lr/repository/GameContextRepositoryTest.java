package com.auto1.lr.repository;

import com.sahil.lr.model.GameContext;
import com.sahil.lr.data.GameContextRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameContextRepositoryTest {

    @Test
    public void testGetGameContext() throws Exception {
        GameContextRepository gameContextRepository = new GameContextRepository();
        GameContext gameContext = gameContextRepository.getGameContext();
        assertNotNull(gameContext);
    }

    @Test
    public void testSetGameContext() throws Exception {
        GameContextRepository gameContextRepository = new GameContextRepository();
        GameContext gameContext = gameContextRepository.getGameContext();
        GameContext newGameContext = new GameContext();
        newGameContext.setTopic("test");
        gameContextRepository.setGameContext(newGameContext);
        Assert.assertNotEquals(gameContext, gameContextRepository.getGameContext());
    }
}