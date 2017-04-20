package com.auto1.lr.ui.menu;

import com.auto1.lr.model.GameContext;
import com.auto1.lr.actions.menu.PlayerMenu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static junit.framework.TestCase.assertEquals;

public class PlayerMenuTest {

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
    }

    @Test
    public void testShowMenu() throws Exception {
        GameContext gameContext = new GameContext();
        gameContext.setTopic("The 100");
        PlayerMenu playerMenu = new PlayerMenu(gameContext);
        playerMenu.showMenu();
        int selection = playerMenu.getSelectionIndex();

        assertEquals(1, selection);
    }
}