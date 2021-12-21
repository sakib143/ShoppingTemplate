package com.innomalist.taxi.shoppingapp.model.dashboard;

public class ChangePasswordRequest {
    private String cusId;
    private String lang;
    private String newPassword;
    private String oldPassword;

    public ChangePasswordRequest(String str, String str2, String str3, String str4) {
        this.cusId = str;
        this.oldPassword = str2;
        this.newPassword = str3;
        this.lang = str4;
    }
}
