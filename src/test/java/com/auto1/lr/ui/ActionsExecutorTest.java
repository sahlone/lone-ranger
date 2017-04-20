package com.auto1.lr.ui;

import com.auto1.lr.model.GameContext;
import com.auto1.lr.actions.ActionsExecutor;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;

import static org.junit.Assert.*;

public class ActionsExecutorTest {

    public static final String TEST_SAVE = "test-data";

    @Test
    public void testLoad() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        GameContext gameContext = new GameContext();
        String name = "testSave";
        ActionsExecutor.save(gameContext, name, TEST_SAVE);
        GameContext loadedGameContext = ActionsExecutor.load(TEST_SAVE);
        assertNotNull(loadedGameContext);
        assertEquals(gameContext, loadedGameContext);
    }

    @Test
    public void testSave() throws Exception {
        GameContext gameContext = new GameContext();
        String name = "testSave";
        ActionsExecutor.save(gameContext, name, TEST_SAVE);
        assertTrue("Save file not found", new File(TEST_SAVE + "/" + name + ".data").exists());
    }
}