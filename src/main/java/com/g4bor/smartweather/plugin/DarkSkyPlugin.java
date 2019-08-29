package com.g4bor.smartweather.plugin;

import com.g4bor.smartweather.gateway.Forecast;
import com.g4bor.smartweather.gateway.WeatherReport;
import com.g4bor.smartweather.model.DTO.darksky.DarkSkyForecastDTO;
import com.g4bor.smartweather.model.DTO.darksky.RequestOption;
import com.g4bor.smartweather.model.DTO.darksky.model.WeatherCollection;
import com.g4bor.smartweather.model.DTO.darksky.model.constant.UnitType;
import com.g4bor.smartweather.model.ForecastData;
import com.g4bor.smartweather.model.ForecastType;
import com.g4bor.smartweather.model.geo.Location;
import com.g4bor.smartweather.model.weather.WeatherData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static com.g4bor.smartweather.config.ApiConfig.darkskyKey;

@Component
public class DarkSkyPlugin implements Forecast, WeatherReport {
    private static final String EXCLUDE_TAG = "exclude=";
    private static final String EXTEND_OPTION = "extend=hourly";
    private static final String LANGUAGE_TAG = "lang=";
    private static final String UNITS_TAG = "units=";
    private static final String AND = "&";
    private static final String DEFAULT_UNIT = "auto";

    private RestTemplatePlugin restTemplatePlugin;
    private String baseURL;

    @Autowired
    public DarkSkyPlugin(RestTemplatePlugin restTemplatePlugin, @Value("${darksky.url}") String baseURL) {
        this.restTemplatePlugin = restTemplatePlugin;
        this.baseURL = baseURL;
    }

    @Override
    public ForecastData getWeatherForecast(Location location, RequestOption extras) {
        String url = buildUrl(location, extras);
        DarkSkyForecastDTO data = restTemplatePlugin.getDarkskyResource(url);
        return parseData(data, location, extras.getForecastType());
    }

    @Override
    public ForecastData getWeatherReport(Location location, Date time, RequestOption extras) {
        String url = buildUrl(location, extras);
        DarkSkyForecastDTO data = restTemplatePlugin.getDarkskyResource(url);
        return parseData(data, location, extras.getForecastType());
    }

    private String buildUrl(Location location, RequestOption extras) {
        String geoCordinates = StringUtils.join("/", location.getLatitude(), ",", location.getLongitude());
        return baseURL + darkskyKey + geoCordinates + getExtraOptions(extras);
    }

    private String getExtraOptions(RequestOption extras) {
        String exclude = String.join(",", extras.getExclude());
        boolean extend = extras.isExtend();
        String language = extras.getLanguage().getCode();
        Optional<UnitType> units = Optional.ofNullable(extras.getUnits());

        StringBuilder sb = new StringBuilder();
        sb.append(EXCLUDE_TAG).append(exclude)
                .append(extend ? AND + EXTEND_OPTION : StringUtils.EMPTY)
                .append(AND + LANGUAGE_TAG + language)
                .append(AND + UNITS_TAG).append(units.isPresent() ? units.get().getName() : DEFAULT_UNIT);

        return sb.insert(0, "?").toString();
    }

    private ForecastData parseData(DarkSkyForecastDTO data, Location location, ForecastType forecastType) {
        ForecastData forecast;
        if (forecastType.equals(ForecastType.FOR_NOW)) {
            forecast = new ForecastData.Builder()
                    .withLocation(location)
                    .withSummary(data.getCurrently().getSummary())
                    .withIcon(data.getCurrently().getIcon())
                    .withWeather(Collections.singletonList((WeatherData) data.getCurrently()))
                    .withAlerts(data.getAlerts())
                    .withFlags(data.getFlags())
                    .build();
        } else {
            WeatherCollection weatherData = collectWeatherData(data, forecastType);
            forecast = new ForecastData.Builder()
                    .withLocation(location)
                    .withSummary(weatherData.getSummary())
                    .withIcon(weatherData.getIcon())
                    .withWeather(new ArrayList<>(weatherData.getData()))
                    .withAlerts(data.getAlerts())
                    .withFlags(data.getFlags())
                    .build();
        }
        return forecast;
    }

    private WeatherCollection collectWeatherData(DarkSkyForecastDTO data, ForecastType forecastType) {
        switch (forecastType) {
            case FOR_TODAY:
            case FOR_3_DAY:
                return data.getHourly();

                case FOR_1_WEEK:
            case FOR_GIVEN_DATA:
                return data.getDaily();

            case FOR_NOW:
            default:
                return null;
        }
    }
}
