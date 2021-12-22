package com.innomalist.taxi.shoppingapp.model.storelist;


import com.innomalist.taxi.shoppingapp.model.category.LangRequest;

public class RequestAddStoreReview extends LangRequest {
    String comments;
    int ratings;
    int storeId;
    String title;

    public int getStoreId() {
        return this.storeId;
    }

    public void setStoreId(int i) {
        this.storeId = i;
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

    public RequestAddStoreReview(int i, String str, String str2, int i2) {
        this.storeId = i;
        this.title = str;
        this.comments = str2;
        this.ratings = i2;
    }

    public RequestAddStoreReview(String str, String str2, int i, String str3, String str4, int i2) {
        super(str, str2);
        this.storeId = i;
        this.title = str3;
        this.comments = str4;
        this.ratings = i2;
    }

    public RequestAddStoreReview(String str, int i, String str2, String str3, int i2) {
        super(str);
        this.storeId = i;
        this.title = str2;
        this.comments = str3;
        this.ratings = i2;
    }
}
