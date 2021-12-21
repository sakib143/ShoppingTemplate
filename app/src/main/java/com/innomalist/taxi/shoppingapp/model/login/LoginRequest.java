package com.innomalist.taxi.shoppingapp.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("andrDeviceId")
    @Expose
    public String androidDeviceId;
    @SerializedName("andrFcmId")
    @Expose
    public String androidFcmId;
    @SerializedName("cusEmail")
    @Expose
    public String email;
    @SerializedName("iosDeviceId")
    @Expose
    public String iosDeviceId = "";
    @SerializedName("iosFcmId")
    @Expose
    public String iosFcmId = "";
    @SerializedName("lang")
    @Expose
    public String lang;
    @SerializedName("cusPassword")
    @Expose
    public String password;
    @SerializedName("type")
    @Expose
    public String type;

    public LoginRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        this.lang = str;
        this.email = str2;
        this.password = str3;
        this.androidFcmId = str4;
        this.androidDeviceId = str5;
        this.type = str6;
    }
}
