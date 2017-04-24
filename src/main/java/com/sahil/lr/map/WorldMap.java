package com.sahil.lr.map;

import com.sahil.lr.logger.ConsoleLogger;
import com.sahil.lr.model.NPC;
import com.sahil.lr.map.locations.DesertLocation;
import com.sahil.lr.map.locations.FighterLocation;
import com.sahil.lr.map.locations.Location;
import com.sahil.lr.utils.RandomUtil;

import java.io.Serializable;

/**
 * Worlds map. Contains logic to generate and store world map,
 * current player locations, printing map player movement
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class WorldMap implements Serializable {

    private static final String MAP_WHITESPACE = "     ";

    private Location[][] map;

    private int mapSize;
    private int countOfFights;


    public WorldMap(int mapSize, int countOfFights) {
        this.mapSize = mapSize;
        this.map = new Location[mapSize][mapSize];
        this.countOfFights = countOfFights;
    }

    /**
     * Print current map state to the console
     *
     * @param currentLocation - current player location
     * @param topic           current game topic
     */
    public void printMap(Location currentLocation, String topic) {
        ConsoleLogger.log("Map of Game world");
        printBorder();
        ConsoleLogger.log("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (currentLocation.getX() == i && currentLocation.getY() == j) {
                    stringBuilder.append(MapMarker.PLAYER.getMarker() + MAP_WHITESPACE);
                } else {
                    stringBuilder.append(map[i][j].getMapMarker().getMarker() + MAP_WHITESPACE);
                }
            }
            stringBuilder.append("\n");
        }
        ConsoleLogger.log(stringBuilder.toString());
        ConsoleLogger.log("");
        printBorder();
        ConsoleLogger.log("");
        printLegend();
    }

    /**
     * Prints border around the map
     */
    private void printBorder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < map.length + ((map.length - 1) * 5); i++) {
            stringBuilder.append("-");
        }
        ConsoleLogger.log(stringBuilder.toString());
    }

    /**
     * Generate world's map. Add empty and fight locations in random order
     */
    public void init() {
        ConsoleLogger.log("Generating the world...");
        int numberOfGeneratedMonsters = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                //skip the first location from random generating loop
                if (i == 0 && j == 0) {
                    map[i][j] = new DesertLocation("large desert.", i, j);
                    continue;
                }
                int magicNumber = RandomUtil.nextIntInRange(0, 100);
                if (magicNumber > 50 && numberOfGeneratedMonsters <= countOfFights) {
                    addFightLocation(i, j);
                    numberOfGeneratedMonsters++;
                } else {
                    map[i][j] = new DesertLocation("desert", i, j);
                }
            }
        }
        //verifiy map
        while (numberOfGeneratedMonsters <= countOfFights) {
            int randX = RandomUtil.nextIntInRange(0, 9);
            int randY = RandomUtil.nextIntInRange(0, 9);
            if (randX != 0 && randY != 0) {
                addFightLocation(randX, randY);
                numberOfGeneratedMonsters++;
            }
        }

        ConsoleLogger.log("");
    }

    /**
     * Generate and set new {@link NPC} fight to the location
     * by given coordinates
     *
     * @param x coordinate of the location on the map
     * @param y coordinate of the location on the map
     */
    private void addFightLocation(int x, int y) {
        NPC fighter = new NPC("Fighter", 90, 100, 10, 10, 50);
        map[x][y] = new FighterLocation("This is fight location", x, y, fighter);
    }

    /**
     * Check if all locations on the map already opened
     *
     * @return true if all location already opened,
     * false if there are some closed locations
     */
    public boolean isAllLocationsOpened() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                Location location = map[i][j];
                if (!location.isOpened()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Location getLocation(int x, int y) {
        return map[x][y];
    }

    public void updateLocation(Location newLocation) {
        map[newLocation.getX()][newLocation.getY()] = newLocation;
    }

    /**
     * Move player around the world's map
     *
     * @param location  - current player location
     * @param direction where player should be moved
     * @return new player's location
     */
    public Location move(Location location, Direction direction) {
        int x = location.getX();
        int y = location.getY();
        if (Direction.EAST.equals(direction)) {
            if (y == mapSize - 1) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                y++;
            }
        } else if (Direction.WEST.equals(direction)) {
            if (y == 0) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                y--;
            }

        } else if (Direction.NORTH.equals(direction)) {
            if (x == 0) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                x--;
            }
        } else if (Direction.SOUTH.equals(direction)) {
            if (x == mapSize - 1) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                x++;
            }
        }
        return map[x][y];
    }

    /**
     * Prints to the console map's legend
     */
    private void printLegend() {
        ConsoleLogger.log("Legend:");
        ConsoleLogger.log("    0 = Explored empty location");
        ConsoleLogger.log("    * = Unexplored location");
        ConsoleLogger.log("    M = Location with fighter");
        ConsoleLogger.log("    P = Current player's location");
        ConsoleLogger.log("");


    }

    /**
     * Prints to the console error message if selected location
     * is not reachable
     */
    private void printError() {
        ConsoleLogger.log(">Looks like you have reached end of the world.");
        ConsoleLogger.log(">Please find another way");
    }
}
