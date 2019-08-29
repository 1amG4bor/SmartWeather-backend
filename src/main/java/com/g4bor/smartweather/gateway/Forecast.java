package com.g4bor.smartweather.gateway;

import com.g4bor.smartweather.model.DTO.darksky.RequestOption;
import com.g4bor.smartweather.model.ForecastData;
import com.g4bor.smartweather.model.geo.Location;

public interface Forecast {
    ForecastData getWeatherForecast(Location location, RequestOption extras);
}
