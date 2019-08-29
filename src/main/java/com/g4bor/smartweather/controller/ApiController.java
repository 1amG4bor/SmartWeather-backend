package com.g4bor.smartweather.controller;

import com.g4bor.smartweather.model.DTO.darksky.model.constant.Language;
import com.g4bor.smartweather.model.DTO.darksky.model.constant.UnitType;
import com.g4bor.smartweather.model.ForecastData;
import com.g4bor.smartweather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ForecastData> forecastForToday(@RequestParam String destination,
                                                         @RequestParam(required = false) String lang,
                                                         @RequestParam(required = false) String unit) {
        Language language = Language.resolve(lang.toLowerCase());
        UnitType unitType = UnitType.resolve(unit.toLowerCase());
        ForecastData weather = weatherService.getWeatherForToday(destination, language, unitType);
        return weather == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(weather);
    }


}
