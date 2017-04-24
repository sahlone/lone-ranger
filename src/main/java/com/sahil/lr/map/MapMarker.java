package com.sahil.lr.map;

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
