package com.g4bor.smartweather.model.geo;

import lombok.Data;

@Data
public class Location {
    private double latitude;
    private double longitude;
    private String place;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
