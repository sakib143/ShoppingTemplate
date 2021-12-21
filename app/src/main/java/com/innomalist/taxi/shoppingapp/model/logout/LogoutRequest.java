package com.innomalist.taxi.shoppingapp.model.logout;

public class LogoutRequest {
    private String andrDeviceId;
    private String cusId;
    private String iosDeviceId;
    private String lang;
    private String type;

    public LogoutRequest(String str, String str2, String str3, String str4, String str5) {
        this.cusId = str;
        this.andrDeviceId = str2;
        this.iosDeviceId = str3;
        this.type = str4;
        this.lang = str5;
    }

    public String getCusId() {
        return this.cusId;
    }

    public void setCusId(String str) {
        this.cusId = str;
    }

    public String getAndrDeviceId() {
        return this.andrDeviceId;
    }

    public void setAndrDeviceId(String str) {
        this.andrDeviceId = str;
    }

    public String getIosDeviceId() {
        return this.iosDeviceId;
    }

    public void setIosDeviceId(String str) {
        this.iosDeviceId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
