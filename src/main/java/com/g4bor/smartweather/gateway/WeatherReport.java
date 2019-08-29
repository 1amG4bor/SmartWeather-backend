package com.g4bor.smartweather.gateway;

import com.g4bor.smartweather.model.DTO.darksky.RequestOption;
import com.g4bor.smartweather.model.ForecastData;
import com.g4bor.smartweather.model.geo.Location;
import com.g4bor.smartweather.model.weather.WeatherData;

import java.util.Date;

public interface WeatherReport {
    ForecastData getWeatherReport(Location location, Date time, RequestOption extras);
}
