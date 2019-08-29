package com.g4bor.smartweather.model.DTO.GoogleGeo;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.g4bor.smartweather.model.geo.Location;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Represents geographic coordinates and additional information for
 */
@Data
public class GeocoderDTO {
    public static final int FIRST = 0;

    public List<Result> results = null;
    public GoogleStatus status;

    public Location getGeoLocation(int areaIndex) {
        final Result.Geometry.Location locationDTO = this.getResults().get(areaIndex).getGeometry().location;
        return new Location(locationDTO.lat, locationDTO.lng);
    }

    public String getAddress() {
        return results.isEmpty() ? StringUtils.EMPTY : results.get(FIRST).formatted_address;
    }

    @Data
    @JsonRootName(value = "results")
    public static class Result {
        public List<Address_component> address_components = null;
        public String formatted_address;
        public Geometry geometry;

        @Data
        @JsonRootName(value = "address_components")
        public static class Address_component {
            public String long_name;
            public String short_name;
            public List<String> types = null;
        }

        @Data
        @JsonRootName(value = "geometry")
        public static class Geometry {
            public Location location;

            @Data
            @JsonRootName(value = "location")
            public static class Location {
                public Double lat;
                public Double lng;
            }
        }
    }
}
