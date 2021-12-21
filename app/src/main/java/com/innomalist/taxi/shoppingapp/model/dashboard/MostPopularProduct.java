package com.innomalist.taxi.shoppingapp.model.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MostPopularProduct {
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("currencySymbol")
    @Expose
    private String currencySymbol;
    @SerializedName("isWishlist")
    @Expose
    private Boolean isWishlist;
    @SerializedName("productDiscountPrice")
    @Expose
    private String productDiscountPrice;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("productPrice")
    @Expose
    private String productPrice;
    @SerializedName("productTitle")
    @Expose
    private String productTitle;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer num) {
        this.productId = num;
    }

    public String getProductTitle() {
        return this.productTitle;
    }

    public void setProductTitle(String str) {
        this.productTitle = str;
    }

    public String getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(String str) {
        this.productPrice = str;
    }

    public String getProductDiscountPrice() {
        return this.productDiscountPrice;
    }

    public void setProductDiscountPrice(String str) {
        this.productDiscountPrice = str;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public Boolean getIsWishlist() {
        return this.isWishlist;
    }

    public void setIsWishlist(Boolean bool) {
        this.isWishlist = bool;
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
}
