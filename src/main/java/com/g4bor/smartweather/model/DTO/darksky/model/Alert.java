package com.g4bor.smartweather.model.DTO.darksky.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Alert {
    private String title;
    private String description ;
    private long time;
    private long expires ;
    private List<String> regions ;
    private Severity severity ;
    private String URI;

    public enum  Severity {
        @ApiModelProperty(notes = "Should be aware of potentially severe weather")
        @JsonProperty("advisory")
        ADVISORY("advisory"),

        @ApiModelProperty(notes = "Should prepare for potentially severe weather")
        @JsonProperty("watch")
        WATCH("watch"),

        @ApiModelProperty(notes = "Should take immediate action to protect themselves and others from potentially severe weather")
        @JsonProperty("warning")
        WARNING("warning");

        private String name;

        Severity(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
