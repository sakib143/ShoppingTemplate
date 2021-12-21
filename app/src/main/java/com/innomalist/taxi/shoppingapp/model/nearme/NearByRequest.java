package com.innomalist.taxi.shoppingapp.model.nearme;

public class NearByRequest {
    private String lang;
    private String storeLatitude;
    private String storeLongitude;

    public NearByRequest(String str, String str2, String str3) {
        this.storeLatitude = str;
        this.storeLongitude = str2;
        this.lang = str3;
    }

    public String getStoreLatitude() {
        return this.storeLatitude;
    }

    public void setStoreLatitude(String str) {
        this.storeLatitude = str;
    }

    public String getStoreLongitude() {
        return this.storeLongitude;
    }

    public void setStoreLongitude(String str) {
        this.storeLongitude = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
