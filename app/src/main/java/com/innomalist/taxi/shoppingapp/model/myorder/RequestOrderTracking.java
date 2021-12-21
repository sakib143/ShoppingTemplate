package com.innomalist.taxi.shoppingapp.model.myorder;

public class RequestOrderTracking {
    private String cusId;
    private String dhlTrackingId;
    private String lang;
    private String orderId;

    public RequestOrderTracking(String str, String str2, String str3, String str4) {
        this.orderId = str;
        this.dhlTrackingId = str2;
        this.lang = str3;
        this.cusId = str4;
    }

    public String getDhlTrackingId() {
        return this.dhlTrackingId;
    }

    public void setDhlTrackingId(String str) {
        this.dhlTrackingId = str;
    }

    public String getCusId() {
        return this.cusId;
    }

    public void setCusId(String str) {
        this.cusId = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
