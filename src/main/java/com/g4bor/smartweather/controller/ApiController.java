package com.g4bor.smartweather.controller;

import com.g4bor.smartweather.model.weather.WeatherData;
import com.g4bor.smartweather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Api endpoints", description = "Description of the requests, responses, models and the particular endpoints.")
public class ApiController {
    private final WeatherService weatherService;

    @Autowired
    public ApiController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/today")
    @ApiOperation(value = "Weather forecast for today")
    public ResponseEntity<WeatherData> forecastForToday() {
        WeatherData weather = weatherService.getWeatherForToday();
        return weather == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(weather);
    }


}
