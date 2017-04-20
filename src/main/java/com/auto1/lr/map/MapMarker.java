package com.auto1.lr.map;

import com.auto1.lr.map.locations.Location;

/**
 * Makes buitiful world map
 *
 * @author Sahil Lone
 * @since 1.0
 */
public enum MapMarker {

    PLAYER("P"), EMPTY("0") , CLOSED("*");

    private final String marker;

    MapMarker(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }
}
