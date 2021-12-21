package com.innomalist.taxi.shoppingapp.model.bycategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdDetail {
    @SerializedName("ad_image")
    @Expose
    private String adImage;

    public String getAdImage() {
        return this.adImage;
    }

    public void setAdImage(String str) {
        this.adImage = str;
    }
}
