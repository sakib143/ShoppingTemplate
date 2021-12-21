package com.innomalist.taxi.shoppingapp.model.accountdetail;

public class RequestSubmitForm {
    private String contactEmail;
    private String contactMessage;
    private String contactName;
    private String contactPhone;
    private String lang;

    public RequestSubmitForm(String str, String str2, String str3, String str4, String str5) {
        this.lang = str;
        this.contactName = str2;
        this.contactEmail = str3;
        this.contactPhone = str4;
        this.contactMessage = str5;
    }
}
