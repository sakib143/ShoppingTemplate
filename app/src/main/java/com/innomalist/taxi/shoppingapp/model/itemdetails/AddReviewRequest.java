package com.innomalist.taxi.shoppingapp.model.itemdetails;

public class AddReviewRequest {
    private String comments;
    private String cusId;
    private int dealId;
    private String lang;
    private int productId;
    private int ratings;
    private String title;

    public AddReviewRequest(String str, int i, String str2, String str3, int i2, String str4) {
        this.cusId = str;
        this.productId = i;
        this.title = str2;
        this.comments = str3;
        this.ratings = i2;
        this.lang = str4;
    }

    public AddReviewRequest(String str, int i, String str2, String str3, int i2, String str4, Boolean bool) {
        this.cusId = str;
        this.dealId = i;
        this.title = str2;
        this.comments = str3;
        this.ratings = i2;
        this.lang = str4;
    }

    public int getDealId() {
        return this.dealId;
    }

    public void setDealId(int i) {
        this.dealId = i;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public int getRatings() {
        return this.ratings;
    }

    public void setRatings(int i) {
        this.ratings = i;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
