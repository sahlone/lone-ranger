package com.sahil.lr.model;

import com.sahil.lr.map.WorldMap;
import com.sahil.lr.map.locations.Location;

import java.io.Serializable;
import java.util.Objects;

/**
 * Contains all main parameters of the current game, such as
 * selected topic, player, player's current location and state of the world
 * User for saving and restoring the game
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class GameContext implements Serializable {

    private String topic;

    private Player player;

    private Location currentLocation;

    private WorldMap worldMap;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "topic='" + topic + '\'' +
                ", player=" + player +
                ", currentLocation=" + currentLocation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameContext that = (GameContext) o;
        return Objects.equals(topic, that.topic) &&
                Objects.equals(player, that.player) &&
                Objects.equals(currentLocation, that.currentLocation) &&
                Objects.equals(worldMap, that.worldMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, player, currentLocation, worldMap);
    }
}
