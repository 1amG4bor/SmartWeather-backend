package com.g4bor.smartweather.model.DTO.darksky.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Represents the weather conditions hour-by-hour for the next two days.
 */
@Data
public class WeatherCollection {
    public String summary;
    public String icon;
    public List<Currently> data = null;

    public String getDay(Long time) {
        Date date = new Date(time*1000);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE", Locale.getDefault());
        return formatter.format(date.getTime());
    }

    @Data
    @JsonRootName(value = "daily")
    public class Daily extends WeatherCollection {
    }

    @Data
    @JsonRootName(value = "hourly")
    public class Hourly extends WeatherCollection {
    }
}