package com.g4bor.smartweather.gateway;

import com.g4bor.smartweather.model.DTO.darksky.RequestOption;
import com.g4bor.smartweather.model.ForecastData;
import com.g4bor.smartweather.model.ForecastType;
import com.g4bor.smartweather.model.geo.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WeatherGateway implements Forecast, WeatherReport {

    @Autowired
    @Qualifier("darkSkyPlugin")
    private Forecast forecastPlugin;

    public WeatherGateway(Forecast forecastPlugin) {
        this.forecastPlugin = forecastPlugin;
    }

    @Override
    public ForecastData getWeatherForecast(Location location, RequestOption extras) {
        return forecastPlugin.getWeatherForecast(location, extras);
    }

    @Override
    public ForecastData getWeatherReport(Location location, Date time, RequestOption extras) {
        return null;
    }
}
