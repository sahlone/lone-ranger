package com.auto1.lr.ui.menu;

import com.sahil.lr.actions.menu.MainMenu;
import com.sahil.lr.actions.menu.Menu;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MainMenuTest {

    @Test
    public void testShotMenu() throws Exception {
        Menu menu = new MainMenu();
        menu.showMenu();
        assertEquals(3, menu.getCommands().size());
    }

}