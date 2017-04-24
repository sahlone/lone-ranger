package com.sahil.lr.ui.menu;

import com.sahil.lr.actions.menu.FightMenu;
import com.sahil.lr.actions.menu.Menu;
import org.junit.Test;

import static org.junit.Assert.*;


public class BattleMenuTest {

    @Test
    public void testShowMenu() throws Exception {
        Menu menu = new FightMenu();
        menu.showMenu();
        assertEquals(2, menu.getCommands().size());
    }
}