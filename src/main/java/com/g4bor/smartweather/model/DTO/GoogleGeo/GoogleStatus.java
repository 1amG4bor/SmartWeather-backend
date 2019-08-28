package com.g4bor.smartweather.model.DTO.GoogleGeo;

public enum  GoogleStatus {
    OK("Indicates that no errors occurred. The address was successfully parsed and at least one geocode was returned."),

    ZERO_RESULTS("Indicates that the geocode was successful but returned no results. This may occur if the geocoder was passed a non-existent address."),

    OVER_DAILY_LIMIT("Indicates any of the following: " +
        "(1) missing or invalid API key " +
        "(2) billing has not been enabled on your account " +
        "(3) self-imposed usage cap has been exceeded " +
        "(4) your payment is no longer valid (eg.: a credit card has expired)."),

    OVER_QUERY_LIMIT("Indicates that you are over your quota."),

    REQUEST_DENIED("Indicates that your request was denied."),

    INVALID_REQUEST("Indicates that the query is missing any of the following: address, components or latitude+longitude."),

    UNKNOWN_ERROR("Indicates that the request could not be processed due to a server error. The request may succeed if you try again.\n");

    private String description;

    GoogleStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
