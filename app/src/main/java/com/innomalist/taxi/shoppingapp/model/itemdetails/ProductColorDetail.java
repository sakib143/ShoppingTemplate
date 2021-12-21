package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductColorDetail {
    @SerializedName("colorCode")
    @Expose
    private String colorCode;
    @SerializedName("colorId")
    @Expose
    private Integer colorId;
    @SerializedName("colorName")
    @Expose
    private String colorName;
    @SerializedName("productColorId")
    @Expose
    private Integer productColorId;

    public Integer getColorId() {
        return this.colorId;
    }

    public void setColorId(Integer num) {
        this.colorId = num;
    }

    public String getColorName() {
        return this.colorName;
    }

    public void setColorName(String str) {
        this.colorName = str;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String str) {
        this.colorCode = str;
    }

    public Integer getProductColorId() {
        return this.productColorId;
    }

    public void setProductColorId(Integer num) {
        this.productColorId = num;
    }
}
