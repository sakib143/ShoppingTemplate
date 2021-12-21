package com.innomalist.taxi.shoppingapp.model.accountdetail;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetail implements Parcelable {
    public static final Parcelable.Creator<UserDetail> CREATOR = new Parcelable.Creator<UserDetail>() {
        public UserDetail createFromParcel(Parcel parcel) {
            return new UserDetail(parcel);
        }

        public UserDetail[] newArray(int i) {
            return new UserDetail[i];
        }
    };
    @SerializedName("cityId")
    @Expose
    private String cityId;
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("cusAddress1")
    @Expose
    private String cusAddress1;
    @SerializedName("cusAddress2")
    @Expose
    private String cusAddress2;
    @SerializedName("cusCityName")
    @Expose
    private String cusCityName;
    @SerializedName("cusCountryName")
    @Expose
    private String cusCountryName;
    @SerializedName("cusEmail")
    @Expose
    private String cusEmail;
    @SerializedName("cusId")
    @Expose
    private Integer cusId;
    @SerializedName("cusImage")
    @Expose
    private String cusImage;
    @SerializedName("cusName")
    @Expose
    private String cusName;
    @SerializedName("cusPhone")
    @Expose
    private String cusPhone;
    @SerializedName("userJoindate")
    @Expose
    private String userJoindate;

    public int describeContents() {
        return 0;
    }

    protected UserDetail(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.cusId = null;
        } else {
            this.cusId = Integer.valueOf(parcel.readInt());
        }
        this.cusName = parcel.readString();
        this.cusEmail = parcel.readString();
        this.cusPhone = parcel.readString();
        this.cusAddress1 = parcel.readString();
        this.cusAddress2 = parcel.readString();
        this.countryId = parcel.readString();
        this.cusCountryName = parcel.readString();
        this.cityId = parcel.readString();
        this.cusCityName = parcel.readString();
        this.userJoindate = parcel.readString();
        this.cusImage = parcel.readString();
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

    public String getCusEmail() {
        return this.cusEmail;
    }

    public void setCusEmail(String str) {
        this.cusEmail = str;
    }

    public String getCusPhone() {
        return this.cusPhone;
    }

    public void setCusPhone(String str) {
        this.cusPhone = str;
    }

    public String getCusAddress1() {
        return this.cusAddress1;
    }

    public void setCusAddress1(String str) {
        this.cusAddress1 = str;
    }

    public String getCusAddress2() {
        return this.cusAddress2;
    }

    public void setCusAddress2(String str) {
        this.cusAddress2 = str;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String str) {
        this.countryId = str;
    }

    public String getCusCountryName() {
        return this.cusCountryName;
    }

    public void setCusCountryName(String str) {
        this.cusCountryName = str;
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String str) {
        this.cityId = str;
    }

    public String getCusCityName() {
        return this.cusCityName;
    }

    public void setCusCityName(String str) {
        this.cusCityName = str;
    }

    public String getUserJoindate() {
        return this.userJoindate;
    }

    public void setUserJoindate(String str) {
        this.userJoindate = str;
    }

    public String getCusImage() {
        return this.cusImage;
    }

    public void setCusImage(String str) {
        this.cusImage = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.cusId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.cusId.intValue());
        }
        parcel.writeString(this.cusName);
        parcel.writeString(this.cusEmail);
        parcel.writeString(this.cusPhone);
        parcel.writeString(this.cusAddress1);
        parcel.writeString(this.cusAddress2);
        parcel.writeString(this.countryId);
        parcel.writeString(this.cusCountryName);
        parcel.writeString(this.cityId);
        parcel.writeString(this.cusCityName);
        parcel.writeString(this.userJoindate);
        parcel.writeString(this.cusImage);
    }
}
