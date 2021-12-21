package com.innomalist.taxi.shoppingapp.model.bycategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.innomalist.taxi.shoppingapp.model.dashboard.MostPopularProduct;
import com.innomalist.taxi.shoppingapp.model.dashboard.ProductTopOffer;

import java.util.List;

public class ByCategoryResult {
    @SerializedName("adDetails")
    @Expose
    private List<AdDetail> adDetails = null;
    @SerializedName("banner_details")
    @Expose
    private List<BannerDetail> bannerDetails = null;
    @SerializedName("categoriesList")
    @Expose
    private List<CategoriesList> categoriesList = null;
    @SerializedName("mostPopularProduct")
    @Expose
    private List<MostPopularProduct> mostPopularProduct = null;
    @SerializedName("productTopOffer")
    @Expose
    private List<ProductTopOffer> productTopOffer = null;

    public List<BannerDetail> getBannerDetails() {
        return this.bannerDetails;
    }

    public void setBannerDetails(List<BannerDetail> list) {
        this.bannerDetails = list;
    }

    public List<AdDetail> getAdDetails() {
        return this.adDetails;
    }

    public void setAdDetails(List<AdDetail> list) {
        this.adDetails = list;
    }

    public List<CategoriesList> getCategoriesList() {
        return this.categoriesList;
    }

    public void setCategoriesList(List<CategoriesList> list) {
        this.categoriesList = list;
    }

    public List<ProductTopOffer> getProductTopOffer() {
        return this.productTopOffer;
    }

    public void setProductTopOffer(List<ProductTopOffer> list) {
        this.productTopOffer = list;
    }

    public List<MostPopularProduct> getMostPopularProduct() {
        return this.mostPopularProduct;
    }

    public void setMostPopularProduct(List<MostPopularProduct> list) {
        this.mostPopularProduct = list;
    }
}
