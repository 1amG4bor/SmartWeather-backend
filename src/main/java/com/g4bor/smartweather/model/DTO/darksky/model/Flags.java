package com.g4bor.smartweather.model.DTO.darksky.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.g4bor.smartweather.model.DTO.darksky.model.constant.UnitType;
import lombok.Data;

/**
 * Represents various metadata information related to the request
 *
 * darkskyUnavailable:  The presence of this property indicates a temporary error (such as a radar station being down for maintenance) has made the data unavailable.
 * nearestStation:      The distance to the nearest weather station that contributed data to this response.
 * units:               Indicates the type of units which were used for the data in this request.
 */
@Data
@JsonRootName(value = "flags")
public class Flags {
    public String darkskyUnavailable;
    public double nearestStation;
    public UnitType units;


}
