package com.g4bor.smartweather.model.DTO.darksky.model.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum UnitType {
    // Imperial units (default)
    @JsonProperty("us")
    US(Unit.IN, Unit.MI, Unit.IPH, Unit.MPH, Unit.FAHRENHEIT, Unit.MBAR),
    // SI units
    @JsonProperty("si")
    SI(Unit.CM, Unit.KM, Unit.MMH, Unit.MS, Unit.CELSIUS, Unit.HPA),

    @JsonProperty("ca")
    CA(Unit.CM, Unit.KM, Unit.MMH, Unit.KMH, Unit.CELSIUS, Unit.HPA),
    @JsonProperty("uk2")
    UK2(Unit.CM, Unit.MI, Unit.MMH, Unit.MPH, Unit.CELSIUS, Unit.HPA);

    private static Map<String, UnitType> unitMap;

    private Unit accumulation;
    private Unit distance;
    private Unit intesity;
    private Unit speed;
    private Unit temperature;
    private Unit pressure;

    UnitType(final Unit accumulation, final Unit distance, final Unit intesity, final Unit speed, final Unit temperature, final Unit pressure) {
        this.accumulation = accumulation;
        this.distance = distance;
        this.intesity = intesity;
        this.speed = speed;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    static {
        unitMap = Arrays.stream(values()).collect(Collectors.toMap(UnitType::getName , n -> n));
    }

    public static UnitType resolve(String unit) {
        return unitMap.getOrDefault(unit, UnitType.US);
    }

    public String getName() {
        return this.toString().toLowerCase();
    }
}
