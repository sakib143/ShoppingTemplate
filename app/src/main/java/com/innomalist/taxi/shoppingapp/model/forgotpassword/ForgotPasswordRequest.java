package com.innomalist.taxi.shoppingapp.model.forgotpassword;

public class ForgotPasswordRequest {
    private String cusEmail;
    private String lang;

    public ForgotPasswordRequest(String str, String str2) {
        this.cusEmail = str2;
        this.lang = str;
    }
}
