package com.g4bor.smartweather.plugin;

import com.g4bor.smartweather.model.DTO.GoogleGeo.GeocoderDTO;
import com.g4bor.smartweather.model.DTO.GoogleGeo.GoogleStatus;
import com.g4bor.smartweather.model.DTO.darksky.DarkSkyForecastDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplatePlugin {

    private static Logger logger = LoggerFactory.getLogger(RestTemplatePlugin.class);
    private RestTemplate restTemplate;

    public RestTemplatePlugin(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    GeocoderDTO getGoogleGeoResource(String resourceUrl) {
        GeocoderDTO resource = null;
        try {
            resource = restTemplate.getForObject(resourceUrl, GeocoderDTO.class);
        }catch (HttpServerErrorException e) {
            logger.error("HttpServerErrorException: {}", e.getMessage());
            throw new HttpServerErrorException(e.getStatusCode());
        } catch (Exception e) {
            logger.error("Unexpected exception has happened: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        if (resource != null && resource.getStatus().equals(GoogleStatus.OK)) {
            logger.warn("Google Geocoding API returned with the issue: {}", resource.getStatus().getDescription());
        }
        return resource;
    }
}
