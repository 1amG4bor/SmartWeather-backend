package com.g4bor.smartweather.plugin;

import com.g4bor.smartweather.gateway.GeoConverter;
import com.g4bor.smartweather.model.DTO.GoogleGeo.GeocoderDTO;
import com.g4bor.smartweather.model.geo.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.g4bor.smartweather.config.ApiConfig.googleKey;

@Component
public class GoogleGeocoderPlugin implements GeoConverter {

    private static final String RESULT_TYPE = "json";
    private static final String ADDRESS_TAG = "?address=";
    private static final String APIKEY_TAG = "&key=";;

    private RestTemplatePlugin restTemplatePlugin;
    private String baseURL;

    public GoogleGeocoderPlugin(RestTemplatePlugin restTemplatePlugin, @Value("${google.url}") String baseURL) {
        this.restTemplatePlugin = restTemplatePlugin;
        this.baseURL = baseURL;
    }

    @Override
    public Location getCoordinate(String destination) {
        String url = buildUrl(destination);
        GeocoderDTO resource = restTemplatePlugin.getGoogleGeoResource(url);
        return parseData(resource);
    }

    private String buildUrl(String destination) {
        StringBuilder builder = new StringBuilder(baseURL);
        builder.append(RESULT_TYPE)
                .append(ADDRESS_TAG).append(destination)
                .append(APIKEY_TAG).append(googleKey);
        return builder.toString();
    }

    private Location parseData(GeocoderDTO resource) {
        Location location = resource.getGeoLocation(0);
        location.setPlace(resource.getAddress());
        return location;
    }
}
