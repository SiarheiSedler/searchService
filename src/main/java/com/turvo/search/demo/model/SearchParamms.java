package com.turvo.search.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * DTO to provide seach parameters
 */
public class SearchParamms {

    @NotNull
    private String cityName;

    @NotNull
    @Min(1)
    private Integer duration;

    public SearchParamms() {
    }

    public SearchParamms(String cityName, Integer duration) {
        this.cityName = cityName;
        this.duration = duration;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
