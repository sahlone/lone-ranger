package com.auto1.lr.ui.menu;

import com.auto1.lr.actions.menu.TopicMenu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static junit.framework.TestCase.assertEquals;

public class TopicMenuTest {

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
    }

    @Test
    public void testShowMenu() throws Exception {
        TopicMenu topicMenu = new TopicMenu();
        topicMenu.showMenu();
        int selection = topicMenu.getSelectionIndex();

        assertEquals(3, selection);
    }
}