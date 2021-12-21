package com.innomalist.taxi.shoppingapp.model.mycart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartSizeDetails {
    @SerializedName("productSizeId")
    @Expose
    private Integer productSizeId;
    @SerializedName("sizeId")
    @Expose
    private Integer sizeId;
    @SerializedName("sizeName")
    @Expose
    private String sizeName;

    public Integer getSizeId() {
        return this.sizeId;
    }

    public void setSizeId(Integer num) {
        this.sizeId = num;
    }

    public String getSizeName() {
        return this.sizeName;
    }

    public void setSizeName(String str) {
        this.sizeName = str;
    }

    public Integer getProductSizeId() {
        return this.productSizeId;
    }

    public void setProductSizeId(Integer num) {
        this.productSizeId = num;
    }
}
