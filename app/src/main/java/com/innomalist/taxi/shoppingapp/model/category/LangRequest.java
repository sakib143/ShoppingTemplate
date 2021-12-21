package com.innomalist.taxi.shoppingapp.model.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LangRequest {
    @SerializedName("cusId")
    @Expose
    private String cusId;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("pageNo")
    @Expose
    private String pageNo;

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public String getCusId() {
        return this.cusId;
    }

    public void setCusId(String str) {
        this.cusId = str;
    }

    public String getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(String str) {
        this.pageNo = str;
    }

    public LangRequest() {
    }

    public LangRequest(String str, String str2) {
        this.lang = str;
        this.cusId = str2;
    }

    public LangRequest(String str) {
        this.lang = str;
    }
}
