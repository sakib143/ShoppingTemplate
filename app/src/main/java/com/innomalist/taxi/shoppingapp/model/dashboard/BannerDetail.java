package com.innomalist.taxi.shoppingapp.model.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerDetail {
    @SerializedName("bannerId")
    @Expose
    private Integer bannerId;
    @SerializedName("bannerImage")
    @Expose
    private String bannerImage;
    @SerializedName("bannerRedirectUrl")
    @Expose
    private String bannerRedirectUrl;
    @SerializedName("bannerTitle")
    @Expose
    private String bannerTitle;

    public Integer getBannerId() {
        return this.bannerId;
    }

    public void setBannerId(Integer num) {
        this.bannerId = num;
    }

    public String getBannerTitle() {
        return this.bannerTitle;
    }

    public void setBannerTitle(String str) {
        this.bannerTitle = str;
    }

    public String getBannerRedirectUrl() {
        return this.bannerRedirectUrl;
    }

    public void setBannerRedirectUrl(String str) {
        this.bannerRedirectUrl = str;
    }

    public String getBannerImage() {
        return this.bannerImage;
    }

    public void setBannerImage(String str) {
        this.bannerImage = str;
    }
}
