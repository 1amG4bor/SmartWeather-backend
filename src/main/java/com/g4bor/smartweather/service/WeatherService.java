package com.g4bor.smartweather.service;

import com.g4bor.smartweather.model.weather.WeatherData;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public WeatherData getWeatherForToday() {
        WeatherData result = new WeatherData();
        result.setSummary("Today is a sunny day");
        return result;
    }
}
