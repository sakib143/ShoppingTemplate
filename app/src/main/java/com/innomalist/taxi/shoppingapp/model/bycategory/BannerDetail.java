package com.innomalist.taxi.shoppingapp.model.bycategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerDetail {
    @SerializedName("banner_image")
    @Expose
    private String bannerImage;

    public String getBannerImage() {
        return this.bannerImage;
    }

    public void setBannerImage(String str) {
        this.bannerImage = str;
    }
}
