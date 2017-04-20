package com.auto1.lr.map;

import com.auto1.lr.map.locations.Location;
import com.auto1.lr.map.locations.LocationType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldMapTest {

    private WorldMap wm;

    @Before
    public void setUp() throws Exception {
        wm = new WorldMap(5, 2);
        wm.init();
    }

    @Test
    public void testIsAllLocationsOpened() throws Exception {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Location location = wm.getLocation(i, j);
                location.setIsOpened(true);
            }
        }
        assertTrue(wm.isAllLocationsOpened());
    }

    @Test
    public void testGetLocation() throws Exception {
        Location location = wm.getLocation(0, 0);
        assertNotNull(location);
        assertEquals(location.getX(), 0);
        assertEquals(location.getY(), 0);
        assertEquals(LocationType.EMPTY, location.getLocationType());
        assertNull(location.getLocationItem());
    }

    @Test
    public void testMoveEast() throws Exception {
        Location location = wm.getLocation(0, 0);
        Location moveLocation = wm.move(location, Direction.EAST);
        assertEquals(0, moveLocation.getX());
        assertEquals(1, moveLocation.getY());
    }

    @Test
    public void testMoveWest() throws Exception {
        Location location = wm.getLocation(1, 0);
        Location moveLocation = wm.move(location, Direction.WEST);
        assertEquals(1, moveLocation.getX());
        assertEquals(0, moveLocation.getY());
    }

    @Test
    public void testMoveNorth() throws Exception {
        Location location = wm.getLocation(3, 3);
        Location moveLocation = wm.move(location, Direction.NORTH);
        assertEquals(2, moveLocation.getX());
        assertEquals(3, moveLocation.getY());
    }

    @Test
    public void testMoveSouth() throws Exception {
        Location location = wm.getLocation(3, 3);
        Location moveLocation = wm.move(location, Direction.SOUTH);
        assertEquals(4, moveLocation.getX());
        assertEquals(3, moveLocation.getY());
    }
}