package com.innomalist.taxi.shoppingapp.model.country;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityDetail {
    @SerializedName("cityCountryId")
    @Expose
    private Integer cityCountryId;
    @SerializedName("cityId")
    @Expose
    private Integer cityId;
    @SerializedName("cityName")
    @Expose
    private String cityName;

    public Integer getCityId() {
        return this.cityId;
    }

    public void setCityId(Integer num) {
        this.cityId = num;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public Integer getCityCountryId() {
        return this.cityCountryId;
    }

    public void setCityCountryId(Integer num) {
        this.cityCountryId = num;
    }

    public String toString() {
        return this.cityName;
    }
}
