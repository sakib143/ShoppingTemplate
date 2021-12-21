package com.innomalist.taxi.shoppingapp.model.accountdetail;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingDetail implements Parcelable {
    public static final Parcelable.Creator<ShippingDetail> CREATOR = new Parcelable.Creator<ShippingDetail>() {
        public ShippingDetail createFromParcel(Parcel parcel) {
            return new ShippingDetail(parcel);
        }

        public ShippingDetail[] newArray(int i) {
            return new ShippingDetail[i];
        }
    };
    @SerializedName("shipAddress1")
    @Expose
    private String shipAddress1;
    @SerializedName("shipAddress2")
    @Expose
    private String shipAddress2;
    @SerializedName("shipCityId")
    @Expose
    private String shipCityId;
    @SerializedName("shipCityName")
    @Expose
    private String shipCityName;
    @SerializedName("shipCountryId")
    @Expose
    private String shipCountryId;
    @SerializedName("shipCountryName")
    @Expose
    private String shipCountryName;
    @SerializedName("shipEmail")
    @Expose
    private String shipEmail;
    @SerializedName("shipName")
    @Expose
    private String shipName;
    @SerializedName("shipPhone")
    @Expose
    private String shipPhone;
    @SerializedName("shipPostalcode")
    @Expose
    private String shipPostalcode;
    @SerializedName("shipState")
    @Expose
    private String shipState;

    public int describeContents() {
        return 0;
    }

    public ShippingDetail() {
    }

    public ShippingDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.shipName = str;
        this.shipEmail = str2;
        this.shipPhone = str3;
        this.shipAddress1 = str4;
        this.shipAddress2 = str5;
        this.shipCountryId = str6;
        this.shipCountryName = str7;
        this.shipCityId = str8;
        this.shipCityName = str9;
        this.shipState = str10;
        this.shipPostalcode = str11;
    }

    protected ShippingDetail(Parcel parcel) {
        this.shipName = parcel.readString();
        this.shipEmail = parcel.readString();
        this.shipPhone = parcel.readString();
        this.shipAddress1 = parcel.readString();
        this.shipAddress2 = parcel.readString();
        this.shipCountryId = parcel.readString();
        this.shipCountryName = parcel.readString();
        this.shipCityId = parcel.readString();
        this.shipCityName = parcel.readString();
        this.shipState = parcel.readString();
        this.shipPostalcode = parcel.readString();
    }

    public String getShipName() {
        return this.shipName;
    }

    public void setShipName(String str) {
        this.shipName = str;
    }

    public String getShipEmail() {
        return this.shipEmail;
    }

    public void setShipEmail(String str) {
        this.shipEmail = str;
    }

    public String getShipPhone() {
        return this.shipPhone;
    }

    public void setShipPhone(String str) {
        this.shipPhone = str;
    }

    public String getShipAddress1() {
        return this.shipAddress1;
    }

    public void setShipAddress1(String str) {
        this.shipAddress1 = str;
    }

    public String getShipAddress2() {
        return this.shipAddress2;
    }

    public void setShipAddress2(String str) {
        this.shipAddress2 = str;
    }

    public String getShipCountryId() {
        return this.shipCountryId;
    }

    public void setShipCountryId(String str) {
        this.shipCountryId = str;
    }

    public String getShipCountryName() {
        return this.shipCountryName;
    }

    public void setShipCountryName(String str) {
        this.shipCountryName = str;
    }

    public String getShipCityId() {
        return this.shipCityId;
    }

    public void setShipCityId(String str) {
        this.shipCityId = str;
    }

    public String getShipCityName() {
        return this.shipCityName;
    }

    public void setShipCityName(String str) {
        this.shipCityName = str;
    }

    public String getShipState() {
        return this.shipState;
    }

    public void setShipState(String str) {
        this.shipState = str;
    }

    public String getShipPostalcode() {
        return this.shipPostalcode;
    }

    public void setShipPostalcode(String str) {
        this.shipPostalcode = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.shipName);
        parcel.writeString(this.shipEmail);
        parcel.writeString(this.shipPhone);
        parcel.writeString(this.shipAddress1);
        parcel.writeString(this.shipAddress2);
        parcel.writeString(this.shipCountryId);
        parcel.writeString(this.shipCountryName);
        parcel.writeString(this.shipCityId);
        parcel.writeString(this.shipCityName);
        parcel.writeString(this.shipState);
        parcel.writeString(this.shipPostalcode);
    }
}
