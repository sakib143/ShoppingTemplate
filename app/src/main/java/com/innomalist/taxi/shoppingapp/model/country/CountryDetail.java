package com.innomalist.taxi.shoppingapp.model.country;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CountryDetail {
    @SerializedName("cityDetails")
    @Expose
    private List<CityDetail> cityDetails = null;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("countryName")
    @Expose
    private String countryName;

    public Integer getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Integer num) {
        this.countryId = num;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public List<CityDetail> getCityDetails() {
        return this.cityDetails;
    }

    public void setCityDetails(List<CityDetail> list) {
        this.cityDetails = list;
    }

    public String toString() {
        return this.countryName;
    }
}
