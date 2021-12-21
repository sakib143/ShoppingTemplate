package com.innomalist.taxi.shoppingapp.model.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DashboardResponse {
    @SerializedName("bannerDetails")
    @Expose
    private List<BannerDetail> bannerDetails = null;
    @SerializedName("categoryDetails")
    @Expose
    private List<CategoryDetail> categoryDetails = null;
    @SerializedName("dealsOfDayDetails")
    @Expose
    private List<DealsOfDayDetail> dealsOfDayDetails = null;
    @SerializedName("mostPopularProduct")
    @Expose
    private List<MostPopularProduct> mostPopularProduct = null;
    @SerializedName("productFiftyPercent")
    @Expose
    private List<ProductFiftyPercent> productFiftyPercent = null;
    @SerializedName("newArrivals")
    @Expose
    private List<ProductNewArrivals> productNewArrivals = null;
    @SerializedName("productTopOffer")
    @Expose
    private List<ProductTopOffer> productTopOffer = null;
    @SerializedName("TotalDealEndTime")
    @Expose
    private String totalDealEndTime;

    public List<CategoryDetail> getCategoryDetails() {
        return this.categoryDetails;
    }

    public void setCategoryDetails(List<CategoryDetail> list) {
        this.categoryDetails = list;
    }

    public List<BannerDetail> getBannerDetails() {
        return this.bannerDetails;
    }

    public void setBannerDetails(List<BannerDetail> list) {
        this.bannerDetails = list;
    }

    public List<DealsOfDayDetail> getDealsOfDayDetails() {
        return this.dealsOfDayDetails;
    }

    public void setDealsOfDayDetails(List<DealsOfDayDetail> list) {
        this.dealsOfDayDetails = list;
    }

    public String getTotalDealEndTime() {
        return this.totalDealEndTime;
    }

    public void setTotalDealEndTime(String str) {
        this.totalDealEndTime = str;
    }

    public List<ProductTopOffer> getProductTopOffer() {
        return this.productTopOffer;
    }

    public void setProductTopOffer(List<ProductTopOffer> list) {
        this.productTopOffer = list;
    }

    public List<ProductFiftyPercent> getProductFiftyPercent() {
        return this.productFiftyPercent;
    }

    public void setProductFiftyPercent(List<ProductFiftyPercent> list) {
        this.productFiftyPercent = list;
    }

    public List<MostPopularProduct> getMostPopularProduct() {
        return this.mostPopularProduct;
    }

    public void setMostPopularProduct(List<MostPopularProduct> list) {
        this.mostPopularProduct = list;
    }

    public List<ProductNewArrivals> getProductNewArrivals() {
        return this.productNewArrivals;
    }
}
