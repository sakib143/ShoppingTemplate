package com.innomalist.taxi.shoppingapp.model.bycategory;

public class ByCategoryRequest {
    private String cusId;
    private String lang;
    private String mainCategoryId;
    private String secCategoryId;

    public ByCategoryRequest(String str, String str2, String str3, String str4) {
        this.mainCategoryId = str;
        this.secCategoryId = str2;
        this.cusId = str3;
        this.lang = str4;
    }
}
