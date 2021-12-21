package com.innomalist.taxi.shoppingapp.model.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingDetail {
    @SerializedName("shipAddress1")
    @Expose
    private String shipAddress1;
    @SerializedName("shipAddress2")
    @Expose
    private String shipAddress2;
    @SerializedName("shipCityId")
    @Expose
    private Integer shipCityId;
    @SerializedName("shipCityName")
    @Expose
    private String shipCityName;
    @SerializedName("shipCountryId")
    @Expose
    private Integer shipCountryId;
    @SerializedName("shipCountryName")
    @Expose
    private String shipCountryName;
    @SerializedName("shipEmail")
    @Expose
    private String shipEmail;
    @SerializedName("shipName")
    @Expose
    private String shipName;
    @SerializedName("shipPhone")
    @Expose
    private String shipPhone;
    @SerializedName("shipPostalcode")
    @Expose
    private String shipPostalcode;
    @SerializedName("shipState")
    @Expose
    private String shipState;

    public String getShipName() {
        return this.shipName;
    }

    public void setShipName(String str) {
        this.shipName = str;
    }

    public String getShipEmail() {
        return this.shipEmail;
    }

    public void setShipEmail(String str) {
        this.shipEmail = str;
    }

    public String getShipPhone() {
        return this.shipPhone;
    }

    public void setShipPhone(String str) {
        this.shipPhone = str;
    }

    public String getShipAddress1() {
        return this.shipAddress1;
    }

    public void setShipAddress1(String str) {
        this.shipAddress1 = str;
    }

    public String getShipAddress2() {
        return this.shipAddress2;
    }

    public void setShipAddress2(String str) {
        this.shipAddress2 = str;
    }

    public Integer getShipCountryId() {
        return this.shipCountryId;
    }

    public void setShipCountryId(Integer num) {
        this.shipCountryId = num;
    }

    public String getShipCountryName() {
        return this.shipCountryName;
    }

    public void setShipCountryName(String str) {
        this.shipCountryName = str;
    }

    public Integer getShipCityId() {
        return this.shipCityId;
    }

    public void setShipCityId(Integer num) {
        this.shipCityId = num;
    }

    public String getShipCityName() {
        return this.shipCityName;
    }

    public void setShipCityName(String str) {
        this.shipCityName = str;
    }

    public String getShipState() {
        return this.shipState;
    }

    public void setShipState(String str) {
        this.shipState = str;
    }

    public String getShipPostalcode() {
        return this.shipPostalcode;
    }

    public void setShipPostalcode(String str) {
        this.shipPostalcode = str;
    }
}
