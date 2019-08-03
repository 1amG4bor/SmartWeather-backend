package com.g4bor.smartweather.service;

import com.g4bor.smartweather.model.weather.WeatherData;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherServiceTest {
    WeatherService service = new WeatherService();

    @Test
    public void shouldGetWeatherForToday() {
        String SUMMARY = "Today is a sunny day";
        WeatherData weather = new WeatherData();
        weather.setSummary(SUMMARY);

        WeatherData response = service.getWeatherForToday();
        assertEquals(weather, response);
    }
}