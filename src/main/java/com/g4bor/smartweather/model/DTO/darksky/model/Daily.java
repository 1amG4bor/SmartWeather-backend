package com.g4bor.smartweather.model.DTO.darksky.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Represents the weather conditions day-by-day for the next week.
 */
@Data
public class Daily {
    public String summary;
    public String icon;
    public List<Data> data = null;

    @JsonRootName(value = "data")
    public static class Data {
        public Long time;
        public String summary;
        public String icon;
        public Integer sunriseTime;
        public Integer sunsetTime;
        public Double moonPhase;
        public Double precipIntensity;
        public Double precipProbability;
        public String precipType;
        public Double temperatureHigh;
        public Double temperatureLow;
        public Double apparentTemperatureHigh;
        public Double apparentTemperatureLow;
        public Double humidity;
        public Double pressure;
        public Double windSpeed;
        public Integer windBearing;
        public Double cloudCover;
        public Integer uvIndex;
        public Integer visibility;


    }
}
