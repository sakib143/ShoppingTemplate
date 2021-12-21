package com.innomalist.taxi.shoppingapp.model.viewall;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductList {
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("currencySymbol")
    @Expose
    private String currencySymbol;
    @SerializedName("isWishlist")
    @Expose
    private Boolean isWishlist;
    @SerializedName("proNoOfPurchase")
    @Expose
    private String proNoOfPurchase;
    @SerializedName("proQty")
    @Expose
    private Integer proQty;
    @SerializedName("productDiscountPrice")
    @Expose
    private String productDiscountPrice;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("productPercentage")
    @Expose
    private String productPercentage;
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

    public String getProductPercentage() {
        return this.productPercentage;
    }

    public void setProductPercentage(String str) {
        this.productPercentage = str;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public String getProNoOfPurchase() {
        return this.proNoOfPurchase;
    }

    public void setProNoOfPurchase(String str) {
        this.proNoOfPurchase = str;
    }

    public Integer getProQty() {
        return this.proQty;
    }

    public void setProQty(Integer num) {
        this.proQty = num;
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
