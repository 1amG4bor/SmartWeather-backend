package com.g4bor.smartweather.service;

import com.g4bor.smartweather.gateway.GeoLocatorGateway;
import com.g4bor.smartweather.gateway.WeatherGateway;
import com.g4bor.smartweather.model.DTO.darksky.RequestOption;
import com.g4bor.smartweather.model.DTO.darksky.model.constant.Language;
import com.g4bor.smartweather.model.DTO.darksky.model.constant.UnitType;
import com.g4bor.smartweather.model.ForecastData;
import com.g4bor.smartweather.model.ForecastType;
import com.g4bor.smartweather.model.geo.Location;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private WeatherGateway weatherGateway;
    private GeoLocatorGateway geoGateway;

    public WeatherService(WeatherGateway weatherGateway, GeoLocatorGateway geoGateway) {
        this.weatherGateway = weatherGateway;
        this.geoGateway = geoGateway;
    }

    public ForecastData getWeatherForToday(String destination, Language language, UnitType unitType) {
        Location location = getCoordinates(destination);
        RequestOption extras = new RequestOption.Builder()
                .withExcludes(ForecastType.FOR_TODAY)
                .withExtend(false)
                .withLanguage(language)
                .withUnit(unitType)
                .build();

        ForecastData forecast = weatherGateway.getWeatherForecast(location, extras);
        return forecast;
    }

    private Location getCoordinates(String destination) {
        Location location = geoGateway.getCoordinate(destination);
        return location;
    }
}
