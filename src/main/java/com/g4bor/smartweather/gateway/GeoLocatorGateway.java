package com.g4bor.smartweather.gateway;

import com.g4bor.smartweather.model.geo.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GeoLocatorGateway implements GeoConverter {

    @Autowired
    @Qualifier("googleGeocoderPlugin")
    private GeoConverter geoConverterPlugin;

    public GeoLocatorGateway(GeoConverter geoConverterPlugin) {
        this.geoConverterPlugin = geoConverterPlugin;
    }

    @Override
    public Location getCoordinate(String destination) {
        return geoConverterPlugin.getCoordinate(destination);
    }
}
