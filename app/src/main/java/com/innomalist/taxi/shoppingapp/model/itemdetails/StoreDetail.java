package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreDetail {
    @SerializedName("storeAddress1")
    @Expose
    private String storeAddress1;
    @SerializedName("storeAddress2")
    @Expose
    private String storeAddress2;
    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("storeImg")
    @Expose
    private String storeImg;
    @SerializedName("storeLatitude")
    @Expose
    private String storeLatitude;
    @SerializedName("storeLongitude")
    @Expose
    private String storeLongitude;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("storePhone")
    @Expose
    private String storePhone;
    @SerializedName("storeStatus")
    @Expose
    private Integer storeStatus;
    @SerializedName("storeWebsite")
    @Expose
    private String storeWebsite;
    @SerializedName("storeZipcode")
    @Expose
    private String storeZipcode;

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer num) {
        this.storeId = num;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String str) {
        this.storeName = str;
    }

    public String getStorePhone() {
        return this.storePhone;
    }

    public void setStorePhone(String str) {
        this.storePhone = str;
    }

    public String getStoreAddress1() {
        return this.storeAddress1;
    }

    public void setStoreAddress1(String str) {
        this.storeAddress1 = str;
    }

    public String getStoreAddress2() {
        return this.storeAddress2;
    }

    public void setStoreAddress2(String str) {
        this.storeAddress2 = str;
    }

    public String getStoreZipcode() {
        return this.storeZipcode;
    }

    public void setStoreZipcode(String str) {
        this.storeZipcode = str;
    }

    public String getStoreWebsite() {
        return this.storeWebsite;
    }

    public void setStoreWebsite(String str) {
        this.storeWebsite = str;
    }

    public String getStoreLatitude() {
        return this.storeLatitude;
    }

    public void setStoreLatitude(String str) {
        this.storeLatitude = str;
    }

    public String getStoreLongitude() {
        return this.storeLongitude;
    }

    public void setStoreLongitude(String str) {
        this.storeLongitude = str;
    }

    public String getStoreImg() {
        return this.storeImg;
    }

    public void setStoreImg(String str) {
        this.storeImg = str;
    }

    public Integer getStoreStatus() {
        return this.storeStatus;
    }

    public void setStoreStatus(Integer num) {
        this.storeStatus = num;
    }
}
