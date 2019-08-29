package com.g4bor.smartweather.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:apikey.properties")
@ConfigurationProperties
@Data
public class ApiConfig {

    public static String darkskyKey;
    public static String googleKey;

    public ApiConfig(@Value("${darksky.key}") String darkskyKey, @Value("${google.key}")String googleKey) {
        ApiConfig.darkskyKey = darkskyKey;
        ApiConfig.googleKey = googleKey;
    }
}
