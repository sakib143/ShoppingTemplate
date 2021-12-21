package com.innomalist.taxi.shoppingapp.model.itemdetails;

public class RequestAddWishList {
    private String cusId;
    private String lang;
    private int productId;

    public RequestAddWishList(String str, int i, String str2) {
        this.cusId = str;
        this.productId = i;
        this.lang = str2;
    }

    public String getCusId() {
        return this.cusId;
    }

    public void setCusId(String str) {
        this.cusId = str;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i) {
        this.productId = i;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
