package com.g4bor.smartweather.model.DTO.darksky;

import com.g4bor.smartweather.model.DTO.darksky.model.constant.Language;
import com.g4bor.smartweather.model.DTO.darksky.model.constant.UnitType;
import com.g4bor.smartweather.model.ForecastType;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RequestOption {
    private ForecastType forecastType;
    private List<String> exclude;
    private boolean extend = false;
    private Language language;
    private UnitType units;

    public static class Builder {
        private ForecastType forecastType;
        private List<String> exclude;
        private boolean extend = false;
        private Language language;
        private UnitType units;

        public Builder withExcludes(ForecastType forecastType){
            this.forecastType = forecastType;
            List<String> excludes = Arrays.asList("currently", "minutely", "hourly", "daily");
            this.exclude = excludes.stream().filter(i -> !i.equals(forecastType.getType())).collect(Collectors.toList());
            return this;
        }

        public Builder withExtend(boolean extend) {
            this.extend = extend;
            return this;
        }

        public Builder withLanguage(Language language) {
            this.language = language;
            return this;
        }

        public Builder withUnit(UnitType unitType) {
            this.units = unitType;
            return this;
        }

        public RequestOption build() {
            RequestOption requestOption = new RequestOption();
            requestOption.forecastType = this.forecastType;
            requestOption.exclude = this.exclude;
            requestOption.extend = this.extend;
            requestOption.language = this.language;

            return requestOption;
        }
    }
}
