package com.innomalist.taxi.shoppingapp.model.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealsOfDayDetail {
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("currencySymbol")
    @Expose
    private String currencySymbol;
    @SerializedName("dealDiscountPrice")
    @Expose
    private String dealDiscountPrice;
    @SerializedName("dealEndTime")
    @Expose
    private String dealEndTime;
    @SerializedName("dealId")
    @Expose
    private Integer dealId;
    @SerializedName("dealImage")
    @Expose
    private String dealImage;
    @SerializedName("dealPercentage")
    @Expose
    private Integer dealPercentage;
    @SerializedName("dealPrice")
    @Expose
    private String dealPrice;

    public Integer getDealId() {
        return this.dealId;
    }

    public void setDealId(Integer num) {
        this.dealId = num;
    }

    public String getDealPrice() {
        return this.dealPrice;
    }

    public void setDealPrice(String str) {
        this.dealPrice = str;
    }

    public String getDealDiscountPrice() {
        return this.dealDiscountPrice;
    }

    public void setDealDiscountPrice(String str) {
        this.dealDiscountPrice = str;
    }

    public Integer getDealPercentage() {
        return this.dealPercentage;
    }

    public void setDealPercentage(Integer num) {
        this.dealPercentage = num;
    }

    public String getDealImage() {
        return this.dealImage;
    }

    public void setDealImage(String str) {
        this.dealImage = str;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public String getDealEndTime() {
        return this.dealEndTime;
    }

    public void setDealEndTime(String str) {
        this.dealEndTime = str;
    }
}
