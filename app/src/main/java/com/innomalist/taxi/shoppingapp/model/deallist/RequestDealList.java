package com.innomalist.taxi.shoppingapp.model.deallist;

public class RequestDealList {
    private String lang;
    private String pageNo;
    private String title;

    public String getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(String str) {
        this.pageNo = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public RequestDealList() {
    }

    public RequestDealList(String str, String str2, String str3) {
        this.pageNo = str;
        this.title = str2;
        this.lang = str3;
    }
}
