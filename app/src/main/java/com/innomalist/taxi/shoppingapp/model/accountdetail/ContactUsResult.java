package com.innomalist.taxi.shoppingapp.model.accountdetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactUsResult {
    @SerializedName("contactMail")
    @Expose
    private String contactMail;
    @SerializedName("phone1")
    @Expose
    private String phone1;
    @SerializedName("phone2")
    @Expose
    private String phone2;
    @SerializedName("skypeMail")
    @Expose
    private String skypeMail;

    public String getContactMail() {
        return this.contactMail;
    }

    public void setContactMail(String str) {
        this.contactMail = str;
    }

    public String getSkypeMail() {
        return this.skypeMail;
    }

    public void setSkypeMail(String str) {
        this.skypeMail = str;
    }

    public String getPhone1() {
        return this.phone1;
    }

    public void setPhone1(String str) {
        this.phone1 = str;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String str) {
        this.phone2 = str;
    }
}
