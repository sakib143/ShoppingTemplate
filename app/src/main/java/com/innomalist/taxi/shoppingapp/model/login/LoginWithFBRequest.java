package com.innomalist.taxi.shoppingapp.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginWithFBRequest {
    @SerializedName("andrDeviceId")
    @Expose
    public String androidDeviceId;
    @SerializedName("andrFcmId")
    @Expose
    public String androidFcmId;
    @SerializedName("cusEmail")
    @Expose
    public String cusEmail;
    @SerializedName("cusName")
    @Expose
    public String cusName;
    @SerializedName("facebookId")
    @Expose
    public String facebookId;
    @SerializedName("iosDeviceId")
    @Expose
    public String iosDeviceId = "";
    @SerializedName("iosFcmId")
    @Expose
    public String iosFcmId = "";
    @SerializedName("lang")
    @Expose
    public String lang;
    @SerializedName("type")
    @Expose
    public String type;

    public LoginWithFBRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.lang = str;
        this.cusEmail = str2;
        this.cusName = str3;
        this.facebookId = str4;
        this.androidFcmId = str5;
        this.androidDeviceId = str6;
        this.iosFcmId = "";
        this.iosDeviceId = "";
        this.type = str7;
    }
}
