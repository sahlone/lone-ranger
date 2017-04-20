package com.auto1.lr.ui.menu;

import com.auto1.lr.actions.menu.Menu;
import com.auto1.lr.actions.menu.AlienLocationMenu;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlienLocationMenuTest {

    @Test
    public void testShowMenu() throws Exception {
        Menu menu = new AlienLocationMenu();
        menu.showMenu();
        assertEquals(2, menu.getCommands().size());
    }
}