package com.g4bor.smartweather.model.DTO.darksky.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.g4bor.smartweather.model.weather.WeatherData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Represents the current weather conditions.
 */
@Data
@JsonRootName(value = "currently")
public class Currently extends WeatherData {
    @ApiModelProperty(notes = "The exact time of the actual weather-data")
    private long time;

    @ApiModelProperty(notes = "Summary about the weather")
    private String summary;

    @ApiModelProperty(notes = "The name of the icon that represent the actual weather")
    private String icon;

    /** Temperature, sunshine */
    @ApiModelProperty(notes = "The accurate temperature")
    private double temperature;

    @ApiModelProperty(notes = "The felt air temperature")
    private double apparentTemperature;

    @ApiModelProperty(notes = "The strength of sunburn-producing ultraviolet (UV) radiation")
    private int uvIndex;

    /** Precip, rain */

    @ApiModelProperty(notes = "The type of precipitation occurring at the given time. (rain, snow, sleet, etc.")
    private String precipType;

    @ApiModelProperty(notes = "The intensity (inches per hour) of precipitation occurring at the given time. (assuming it occurs at all)")
    private double precipIntensity;

    @ApiModelProperty(notes = "The probability of precipitation occurring")
    private int precipProbability;

    @ApiModelProperty(notes = "The approximate distance to the nearest storm")
    private double nearestStormDistance;

    @ApiModelProperty(notes = "Humidity, the amount of water vapour present in air")
    private int humidity;

    /** Wind */
    @ApiModelProperty(notes = "Predicted air pressure")
    private double pressure;

    @ApiModelProperty(notes = "Predicted wind speed")
    private double windSpeed;

    @ApiModelProperty(notes = "The wind direction that is expressed in angle('0' means the wind is coming from North)")
    private Integer windBearing;

    @ApiModelProperty(notes = "The wind gust speed in the specified unit")
    private double windGust;

    @ApiModelProperty(notes = "The percentage of sky occluded by clouds")
    private int cloudCover;

    /** Additional */
    @ApiModelProperty(notes = "The time of when the sun will rise during a given day.")
    private double sunriseTime;

    @ApiModelProperty(notes = "The time of when the sun will set during a given day.")
    private double sunsetTime;

    @ApiModelProperty(notes = "The fractional part of the lunation number during the given day")
    private double moonPhase;

    @ApiModelProperty(notes = "The average visibility in the specified unit")
    private double visibility;
}