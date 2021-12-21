package com.innomalist.taxi.shoppingapp.model.itemdetails;

public class ProductDetailsRequest {
    private String cusId;
    private String lang;
    private int productId;

    public ProductDetailsRequest(String str, int i, String str2) {
        this.cusId = str;
        this.productId = i;
        this.lang = str2;
    }
}
