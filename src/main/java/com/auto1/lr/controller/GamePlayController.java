package com.auto1.lr.controller;

import com.auto1.lr.logger.ConsoleLogger;
import com.auto1.lr.map.locations.LocationType;
import com.auto1.lr.service.FightServiceImpl;
import com.auto1.lr.map.Direction;
import com.auto1.lr.service.FightService;
import com.auto1.lr.map.WorldMap;
import com.auto1.lr.map.locations.Location;
import com.auto1.lr.model.GameContext;
import com.auto1.lr.model.Player;
import com.auto1.lr.data.GameContextRepository;
import com.auto1.lr.actions.Actions;
import com.auto1.lr.actions.ActionsExecutor;
import com.auto1.lr.actions.menu.Menu;
import com.auto1.lr.actions.menu.PlayerMenu;
import com.auto1.lr.actions.menu.TopicMenu;
import com.auto1.lr.utils.RandomUtil;

import java.time.LocalDateTime;

/**
 * Main game play controller  (navigation, fights, etc)
 * It all started here
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class GamePlayController {

    private static final int MAP_SIZE = 12;

    private static final int NUMBER_OF_FIGHTS = 30;
    private static final String DATA_DIR = "data";

    private Menu topicMenu;

    private Menu playerMenu;

    private GameContextRepository gameContextRepository;

    private FightService fightService;

    private WorldMap worldMap;

    private boolean isGameOver;

    public GamePlayController(GameContextRepository gameContextRepository) {
        this.gameContextRepository = gameContextRepository;
        this.topicMenu = new TopicMenu();
        this.playerMenu = new PlayerMenu(gameContextRepository.getGameContext());
        this.fightService = new FightServiceImpl();
    }

    /**
     * Start new game
     */
    public void startGame() {
        gameContextRepository.getGameContext().setTopic(selectTopic());
        gameContextRepository.getGameContext().setPlayer(createPlayer());
        initMap();
        continueGame();
    }

    /**
     * Continue saved game
     */
    public void continueGame() {
        while (!isGameOver) {
            Location currentLocation = gameContextRepository.getGameContext().getCurrentLocation();
            worldMap = gameContextRepository.getGameContext().getWorldMap();
            currentLocation.printLocationInfo();
            currentLocation.printLocationMenu();
            executeCommand(gameContextRepository.getGameContext().getCurrentLocation());
        }
        ConsoleLogger.log("Congratulations! You've made the world a better place now.");
        ActionsExecutor.exit();
    }

    /**
     * Display list of available topics for the game to the user.
     * Handle user input for selection
     *
     * @return selected game topic
     */
    private String selectTopic() {
        topicMenu.showMenu();
        return TopicMenu.DEAFAULT_TOPICS;
    }

    /**
     * Creates player. Get the user's selected character
     * enerate random generated statistics
     *
     * @return create {@link Player}
     */
    private Player createPlayer() {
        playerMenu.showMenu();
        int selectionIndex = playerMenu.getSelectionIndex();
        String playerName = playerMenu.getCommandByIndex(selectionIndex);
        Player player = new Player(playerName, 100, 0, RandomUtil.nextIntInRange(10, 20),
                RandomUtil.nextIntInRange(10, 20));
        ConsoleLogger.log("");
        return player;
    }

    /**
     * Prints  world's map
     */
    private void printMap() {
        GameContext gameContext = gameContextRepository.getGameContext();
        worldMap.printMap(gameContext.getCurrentLocation(), gameContext.getTopic());
    }

    /**
     * Generate the game world and map for it
     */
    private void initMap() {
        if (worldMap == null) {
            worldMap = new WorldMap(MAP_SIZE, NUMBER_OF_FIGHTS);
            worldMap.init();
            Location currentLocation = worldMap.getLocation(0, 0);
            gameContextRepository.getGameContext().setCurrentLocation(currentLocation);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        }
    }

    /**
     * Handle user selected command and execute appropriate command
     *
     * @param location - of the player.
     * @return current location
     */
    private Location executeCommand(Location location) {
        int selectionIndex = location.getLocationMenu().getSelectionIndex();
        String command = location.getLocationMenu().getCommandByIndex(selectionIndex).toUpperCase();
        Actions cmd = Actions.valueOf(command);
        if (Actions.NORTH.equals(cmd)) {
            location = worldMap.move(location, Direction.NORTH);
            gameContextRepository.getGameContext().setCurrentLocation(location);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (Actions.SOUTH.equals(cmd)) {
            location = worldMap.move(location, Direction.SOUTH);
            gameContextRepository.getGameContext().setCurrentLocation(location);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (Actions.WEST.equals(cmd)) {
            location = worldMap.move(location, Direction.WEST);
            gameContextRepository.getGameContext().setCurrentLocation(location);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (Actions.EAST.equals(cmd)) {
            location = worldMap.move(location, Direction.EAST);
            gameContextRepository.getGameContext().setCurrentLocation(location);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (Actions.SAVE.equals(cmd)) {
            ActionsExecutor.save(gameContextRepository.getGameContext(), LocalDateTime.now().toString(), DATA_DIR);
        } else if (Actions.EXIT.equals(cmd)) {
            ActionsExecutor.exit();
        } else if (Actions.MAP.equals(cmd)) {
            printMap();
        } else if (Actions.FIGHT.equals(cmd)) {
            Location fighterLocation = gameContextRepository.getGameContext().getCurrentLocation();
            if (fighterLocation.getLocationType() == LocationType.EMPTY) {
                ConsoleLogger.log("Be Happy, There is no one to fight.");
            } else {
                Player player = gameContextRepository.getGameContext().getPlayer();
                fighterLocation = fightService.battle(player, fighterLocation);
                gameContextRepository.getGameContext().setCurrentLocation(fighterLocation);
                worldMap.updateLocation(fighterLocation);
            }
        } else if (Actions.LOAD.equals(cmd)) {
            ActionsExecutor.load(DATA_DIR);
        } else if (Actions.STATISTICS.equals(cmd)) {
            ConsoleLogger.log(gameContextRepository.getGameContext().getPlayer().toString());
        } else if (Actions.RUN.equals(cmd)) {
            ConsoleLogger.log("You are away from danger now.");
            location = worldMap.move(location, Direction.WEST);
            gameContextRepository.getGameContext().setCurrentLocation(location);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        }
        isGameFinished();
        return location;
    }

    /**
     * Check if game finished (all locations visited and all monsters defeated)
     * and switch of the flag
     */
    private void isGameFinished() {
        isGameOver = worldMap.isAllLocationsOpened();
    }
}
