package com.innomalist.taxi.shoppingapp.model.cms;

public class RequestAboutUs {
    private String lang;
    private String pageTitle;

    public RequestAboutUs(String str, String str2) {
        this.pageTitle = str;
        this.lang = str2;
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public void setPageTitle(String str) {
        this.pageTitle = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
