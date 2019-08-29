package com.g4bor.smartweather.model.DTO.darksky.model.constant;

public enum Unit {
    // Accumulation
    CM("cm", "centimeters"),
    IN("in", "inch"),

    // Distance
    KM("km", "kilometers"),
    MI("mi", "miles"),

    // Intensity
    MMH("mm/h", "millimeters per hour"),
    IPH("in/h", "inches per hour"),

    // Speed
    KMH("km/h", "kilometers per hour"),
    MPH("mph", "miles per hour"),
    MS("m/s", "meter per second"),


    //Temperature
    CELSIUS("°C", "degrees Celsius"),
    FAHRENHEIT("°F", "degrees Fahrenheit"),
    KELVIN("K", "Kelvin"),

    // Pressure
    HPA("hPa", "hectopascals"),
    MBAR("mbar", "millibar"),
    ATM("atm", "atmosphere"),

    // Others
    PERCENT("%", "percent");

    private String symbol;
    private String name;

    Unit(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
}

