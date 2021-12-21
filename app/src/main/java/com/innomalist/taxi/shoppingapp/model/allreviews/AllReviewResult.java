package com.innomalist.taxi.shoppingapp.model.allreviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllReviewResult {
    @SerializedName("cusId")
    @Expose
    private Integer cusId;
    @SerializedName("cusImage")
    @Expose
    private String cusImage;
    @SerializedName("cusName")
    @Expose
    private String cusName;
    @SerializedName("ratings")
    @Expose
    private String ratings;
    @SerializedName("reviewComments")
    @Expose
    private String reviewComments;
    @SerializedName("reviewDate")
    @Expose
    private String reviewDate;
    @SerializedName("reviewTitle")
    @Expose
    private String reviewTitle;

    public String getReviewTitle() {
        return this.reviewTitle;
    }

    public void setReviewTitle(String str) {
        this.reviewTitle = str;
    }

    public String getReviewComments() {
        return this.reviewComments;
    }

    public void setReviewComments(String str) {
        this.reviewComments = str;
    }

    public String getRatings() {
        return this.ratings;
    }

    public void setRatings(String str) {
        this.ratings = str;
    }

    public String getReviewDate() {
        return this.reviewDate;
    }

    public void setReviewDate(String str) {
        this.reviewDate = str;
    }

    public Integer getCusId() {
        return this.cusId;
    }

    public void setCusId(Integer num) {
        this.cusId = num;
    }

    public String getCusName() {
        return this.cusName;
    }

    public void setCusName(String str) {
        this.cusName = str;
    }

    public String getCusImage() {
        return this.cusImage;
    }

    public void setCusImage(String str) {
        this.cusImage = str;
    }
}
