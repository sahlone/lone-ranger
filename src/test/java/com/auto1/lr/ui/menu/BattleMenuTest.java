package com.auto1.lr.ui.menu;

import com.auto1.lr.actions.menu.FightMenu;
import com.auto1.lr.actions.menu.Menu;
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