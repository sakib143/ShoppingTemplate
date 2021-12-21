package com.innomalist.taxi.shoppingapp.model.nearme;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearByResult {
    @SerializedName("dealCount")
    @Expose
    private Integer dealCount;
    @SerializedName("productCount")
    @Expose
    private Integer productCount;
    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("storeImg")
    @Expose
    private String storeImg;
    @SerializedName("storeLatitude")
    @Expose
    private Double storeLatitude;
    @SerializedName("storeLongitude")
    @Expose
    private Double storeLongitude;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("storeStatus")
    @Expose
    private Integer storeStatus;

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

    public Double getStoreLatitude() {
        return this.storeLatitude;
    }

    public void setStoreLatitude(Double d) {
        this.storeLatitude = d;
    }

    public Double getStoreLongitude() {
        return this.storeLongitude;
    }

    public void setStoreLongitude(Double d) {
        this.storeLongitude = d;
    }

    public Integer getProductCount() {
        return this.productCount;
    }

    public void setProductCount(Integer num) {
        this.productCount = num;
    }

    public Integer getDealCount() {
        return this.dealCount;
    }

    public void setDealCount(Integer num) {
        this.dealCount = num;
    }
}
