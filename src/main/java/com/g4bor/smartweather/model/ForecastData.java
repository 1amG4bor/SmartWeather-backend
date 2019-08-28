package com.g4bor.smartweather.model;

import com.g4bor.smartweather.model.DTO.darksky.model.Alert;
import com.g4bor.smartweather.model.DTO.darksky.model.Flags;
import com.g4bor.smartweather.model.geo.Location;
import com.g4bor.smartweather.model.weather.WeatherData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ForecastData {
    @ApiModelProperty(notes = "The exact coordinate of the required weather-data")
    private Location location;

    @ApiModelProperty(notes = "Summary about the weather")
    private String summary;

    @ApiModelProperty(notes = "Name of the icon that represents the actual weather")
    private String icon;

    /** Could be currently, hourly or daily based on {@Link com.g4bor.smartweather.model.DTO.darksky.DarkSkyForecastDTO} */
    @ApiModelProperty(notes = "Thorough information about the required weather")
    private List<WeatherData> weather;


    @ApiModelProperty(notes = "")
    private List<Alert> alerts;

    @ApiModelProperty(notes = "")
    private Flags flags;

    public static class Builder {
        private Location location;
        private String summary;
        private String icon;
        private List<WeatherData> weather;
        private List<Alert> alerts;
        private Flags flags;

        public Builder() {
        }

        public Builder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Builder withWeather(List<WeatherData> weatherList) {
            this.weather = weatherList;
            return this;
        }

        public Builder withAlerts(List<Alert> alerts) {
            this.alerts = alerts;
            return this;
        }

        public Builder withFlags(Flags flags) {
            this.flags = flags;
            return this;
        }

        public ForecastData build() {
            ForecastData forecast = new ForecastData();
            forecast.setLocation(this.location);
            forecast.setSummary(this.summary);
            forecast.setWeather(this.weather);
            forecast.setIcon(this.icon);
            forecast.setAlerts(this.alerts);
            forecast.setFlags(this.flags);

            return forecast;
        }
    }

    public ForecastData() {
    }
}
