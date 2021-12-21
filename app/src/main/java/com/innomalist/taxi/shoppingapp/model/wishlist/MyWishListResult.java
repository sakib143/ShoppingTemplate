package com.innomalist.taxi.shoppingapp.model.wishlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyWishListResult {
    @SerializedName("productCurrencyCode")
    @Expose
    private String productCurrencyCode;
    @SerializedName("productCurrencySymbol")
    @Expose
    private String productCurrencySymbol;
    @SerializedName("productDiscountPercentage")
    @Expose
    private Integer productDiscountPercentage;
    @SerializedName("productDiscountPrice")
    @Expose
    private String productDiscountPrice;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("productOriginalPrice")
    @Expose
    private String productOriginalPrice;
    @SerializedName("productTitle")
    @Expose
    private String productTitle;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

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

    public String getProductDiscountPrice() {
        return this.productDiscountPrice;
    }

    public void setProductDiscountPrice(String str) {
        this.productDiscountPrice = str;
    }

    public Integer getProductDiscountPercentage() {
        return this.productDiscountPercentage;
    }

    public void setProductDiscountPercentage(Integer num) {
        this.productDiscountPercentage = num;
    }

    public String getProductOriginalPrice() {
        return this.productOriginalPrice;
    }

    public void setProductOriginalPrice(String str) {
        this.productOriginalPrice = str;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public String getProductCurrencyCode() {
        return this.productCurrencyCode;
    }

    public void setProductCurrencyCode(String str) {
        this.productCurrencyCode = str;
    }

    public String getProductCurrencySymbol() {
        return this.productCurrencySymbol;
    }

    public void setProductCurrencySymbol(String str) {
        this.productCurrencySymbol = str;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer num) {
        this.userId = num;
    }
}
