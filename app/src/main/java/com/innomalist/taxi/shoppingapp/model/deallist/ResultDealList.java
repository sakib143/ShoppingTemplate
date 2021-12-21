package com.kiandashopping.kiandashopping.model.deallist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDealList {
    @SerializedName("dealActiveOrExpireStatus")
    @Expose
    private String dealActiveOrExpireStatus;
    @SerializedName("dealCurrencyCode")
    @Expose
    private String dealCurrencyCode;
    @SerializedName("dealCurrencySymbol")
    @Expose
    private String dealCurrencySymbol;
    @SerializedName("dealDiscountPercentage")
    @Expose
    private Integer dealDiscountPercentage;
    @SerializedName("dealDiscountPrice")
    @Expose
    private String dealDiscountPrice;
    @SerializedName("dealEndDate")
    @Expose
    private String dealEndDate;
    @SerializedName("dealExpiryDate")
    @Expose
    private String dealExpiryDate;
    @SerializedName("dealId")
    @Expose
    private Integer dealId;
    @SerializedName("dealImage")
    @Expose
    private String dealImage;
    @SerializedName("dealOriginalPrice")
    @Expose
    private String dealOriginalPrice;
    @SerializedName("dealSavingPrice")
    @Expose
    private String dealSavingPrice;
    @SerializedName("dealShopId")
    @Expose
    private Integer dealShopId;
    @SerializedName("dealStartDate")
    @Expose
    private String dealStartDate;
    @SerializedName("dealStatus")
    @Expose
    private Integer dealStatus;
    @SerializedName("dealTitle")
    @Expose
    private String dealTitle;
    @SerializedName("iosDealEndDate")
    @Expose
    private String iosDealEndDate;
    @SerializedName("iosDealExpiryDate")
    @Expose
    private String iosDealExpiryDate;
    @SerializedName("iosDealStartDate")
    @Expose
    private String iosDealStartDate;

    public Integer getDealId() {
        return this.dealId;
    }

    public void setDealId(Integer num) {
        this.dealId = num;
    }

    public String getDealTitle() {
        return this.dealTitle;
    }

    public void setDealTitle(String str) {
        this.dealTitle = str;
    }

    public String getDealOriginalPrice() {
        return this.dealOriginalPrice;
    }

    public void setDealOriginalPrice(String str) {
        this.dealOriginalPrice = str;
    }

    public String getDealDiscountPrice() {
        return this.dealDiscountPrice;
    }

    public void setDealDiscountPrice(String str) {
        this.dealDiscountPrice = str;
    }

    public Integer getDealDiscountPercentage() {
        return this.dealDiscountPercentage;
    }

    public void setDealDiscountPercentage(Integer num) {
        this.dealDiscountPercentage = num;
    }

    public String getDealSavingPrice() {
        return this.dealSavingPrice;
    }

    public void setDealSavingPrice(String str) {
        this.dealSavingPrice = str;
    }

    public String getDealCurrencyCode() {
        return this.dealCurrencyCode;
    }

    public void setDealCurrencyCode(String str) {
        this.dealCurrencyCode = str;
    }

    public String getDealCurrencySymbol() {
        return this.dealCurrencySymbol;
    }

    public void setDealCurrencySymbol(String str) {
        this.dealCurrencySymbol = str;
    }

    public String getDealStartDate() {
        return this.dealStartDate;
    }

    public void setDealStartDate(String str) {
        this.dealStartDate = str;
    }

    public String getDealEndDate() {
        return this.dealEndDate;
    }

    public void setDealEndDate(String str) {
        this.dealEndDate = str;
    }

    public String getDealExpiryDate() {
        return this.dealExpiryDate;
    }

    public void setDealExpiryDate(String str) {
        this.dealExpiryDate = str;
    }

    public String getIosDealStartDate() {
        return this.iosDealStartDate;
    }

    public void setIosDealStartDate(String str) {
        this.iosDealStartDate = str;
    }

    public String getIosDealEndDate() {
        return this.iosDealEndDate;
    }

    public void setIosDealEndDate(String str) {
        this.iosDealEndDate = str;
    }

    public String getIosDealExpiryDate() {
        return this.iosDealExpiryDate;
    }

    public void setIosDealExpiryDate(String str) {
        this.iosDealExpiryDate = str;
    }

    public Integer getDealShopId() {
        return this.dealShopId;
    }

    public void setDealShopId(Integer num) {
        this.dealShopId = num;
    }

    public String getDealImage() {
        return this.dealImage;
    }

    public void setDealImage(String str) {
        this.dealImage = str;
    }

    public String getDealActiveOrExpireStatus() {
        return this.dealActiveOrExpireStatus;
    }

    public void setDealActiveOrExpireStatus(String str) {
        this.dealActiveOrExpireStatus = str;
    }

    public Integer getDealStatus() {
        return this.dealStatus;
    }

    public void setDealStatus(Integer num) {
        this.dealStatus = num;
    }
}
