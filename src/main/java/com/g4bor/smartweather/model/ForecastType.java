package com.g4bor.smartweather.model;

import java.util.*;
import java.util.stream.Collectors;

public enum ForecastType {
    FOR_NOW("FOR_NOW", "currently"),
    FOR_TODAY("FOR_TODAY", "hourly"),
    FOR_3_DAY("FOR_3_DAY", "hourly"),
    FOR_1_WEEK("FOR_1_WEEK", "daily"),
    FOR_GIVEN_DATA("FOR_GIVEN_DATA", "daily");

    private static Map<String, ForecastType> typeMap;
    private final String name;
    private final String type;

    ForecastType(String forecastType, String type) {
        this.name = forecastType;
        this.type = type;
    }

    public static ForecastType resolve(String nameOfType) {
        return typeMap.getOrDefault(nameOfType, FOR_NOW);
    }

    static {
        typeMap = Arrays.stream(values())
                .collect(Collectors.toMap(ForecastType::toString, t -> t));
    }

    private String getName() {
        return this.name;
    }

    public String getType() {
        return type;
    }
}
