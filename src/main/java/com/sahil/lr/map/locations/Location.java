package com.sahil.lr.map.locations;

import com.sahil.lr.map.MapMarker;
import com.sahil.lr.actions.menu.AbstractMenu;

import java.io.Serializable;
import java.util.Objects;

/**
 * All other locations should extend this class
 * @author Sahil Lone
 * @since 1.0
 */
public abstract class Location implements Serializable {

    private String name;
    private String description;
    private LocationItem locationItem;
    private LocationType locationType;
    private int x;
    private int y;
    private MapMarker mapMarker;
    private boolean isOpened;

    public Location(String name, String description, LocationItem locationItem, LocationType locationType,
                    int x, int y, MapMarker mapMarker) {
        this.name = name;
        this.description = description;
        this.locationItem = locationItem;
        this.locationType = locationType;
        this.x = x;
        this.y = y;
        this.mapMarker = mapMarker;
    }

    public abstract void printLocationInfo();

    public abstract AbstractMenu getLocationMenu();

    public abstract void printLocationMenu();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocationItem getLocationItem() {
        return locationItem;
    }

    public void setLocationItem(LocationItem locationItem) {
        this.locationItem = locationItem;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MapMarker getMapMarker() {

        return mapMarker;
    }

    public void setMapMarker(MapMarker mapMarker) {
        this.mapMarker = mapMarker;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setIsOpened(boolean isOpened) {
        this.isOpened = isOpened;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(x, location.x) &&
                Objects.equals(y, location.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
