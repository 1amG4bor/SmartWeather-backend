package com.g4bor.smartweather.gateway;

import com.g4bor.smartweather.model.geo.Location;

public interface GeoConverter {
    Location getCoordinate(String destination);
}
