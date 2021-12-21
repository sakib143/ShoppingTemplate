package com.innomalist.taxi.shoppingapp.model.storelist;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreReview implements Parcelable {
    public static final Parcelable.Creator<StoreReview> CREATOR = new Parcelable.Creator<StoreReview>() {
        public StoreReview createFromParcel(Parcel parcel) {
            return new StoreReview(parcel);
        }

        public StoreReview[] newArray(int i) {
            return new StoreReview[i];
        }
    };
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

    public int describeContents() {
        return 0;
    }

    protected StoreReview(Parcel parcel) {
        this.reviewTitle = parcel.readString();
        this.reviewComments = parcel.readString();
        this.ratings = parcel.readString();
        this.reviewDate = parcel.readString();
        if (parcel.readByte() == 0) {
            this.cusId = null;
        } else {
            this.cusId = Integer.valueOf(parcel.readInt());
        }
        this.cusName = parcel.readString();
        this.cusImage = parcel.readString();
    }

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

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.reviewTitle);
        parcel.writeString(this.reviewComments);
        parcel.writeString(this.ratings);
        parcel.writeString(this.reviewDate);
        if (this.cusId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.cusId.intValue());
        }
        parcel.writeString(this.cusName);
        parcel.writeString(this.cusImage);
    }
}
