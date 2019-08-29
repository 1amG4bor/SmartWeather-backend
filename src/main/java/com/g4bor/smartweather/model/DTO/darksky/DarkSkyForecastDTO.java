package com.g4bor.smartweather.model.DTO.darksky;

import com.g4bor.smartweather.model.DTO.darksky.model.*;
import lombok.Data;

import java.util.List;

/**
 * Represents the current weather conditions to the requested location.
 * currently:   the current weather,
 * hourly:      an hour-by-hour forecast for the next 48 hours,
 * daily:       and a day-by-day forecast for the next week.
 */
@Data
public class DarkSkyForecastDTO {
    private Double latitude;
    private Double longitude;
    private String timezone;

    private Currently currently;
    private WeatherCollection hourly;
    private WeatherCollection daily;
    private List<Alert> alerts;
    private Flags flags;
}
