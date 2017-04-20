package com.auto1.lr.game.battle;

import com.auto1.lr.service.FightService;
import com.auto1.lr.service.FightServiceImpl;
import com.auto1.lr.model.Player;
import com.auto1.lr.map.locations.FighterLocation;
import com.auto1.lr.model.NPC;
import com.auto1.lr.map.locations.Location;
import com.auto1.lr.map.locations.LocationType;
import com.auto1.lr.utils.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RandomUtil.class)
public class FightServiceImplTest {


    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testBattleWin() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        PowerMockito.mockStatic(RandomUtil.class);
        Mockito.when(RandomUtil.nextInt(10)).thenReturn(1);
        NPC npc = new NPC("Fighter", 1, 1, 10, 30, 500);
        Player player = new Player("Player", 100, 100, 100, 30);
        Location location = new FighterLocation("Fighter location", 0, 1, npc);
        FightService fightService = new FightServiceImpl();
        Location battleLocation = fightService.battle(player, location);
        assertEquals(600, player.getExperience());
        assertNull(battleLocation.getLocationItem());
        assertEquals(LocationType.EMPTY, battleLocation.getLocationType());
    }

    @Test
    public void testBattleLost() throws Exception {
        exit.expectSystemExitWithStatus(0);
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        PowerMockito.mockStatic(RandomUtil.class);
        Mockito.when(RandomUtil.nextInt(10)).thenReturn(10);
        Mockito.when(RandomUtil.nextInt(100)).thenReturn(20);
        NPC npc = new NPC("Fighter", 1000, 1, 100, 300, 500);
        Player player = new Player("Player", 1, 100, 1, 1);
        Location location = new FighterLocation("Fighter location", 0, 1, npc);
        FightService fightService = new FightServiceImpl();
        fightService.battle(player, location);
    }
}