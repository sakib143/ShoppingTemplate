package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductImage {
    @SerializedName("images")
    @Expose
    private String images;

    public String getImages() {
        return this.images;
    }

    public void setImages(String str) {
        this.images = str;
    }
}
