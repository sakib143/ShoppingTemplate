package com.innomalist.taxi.shoppingapp.model.register;

import android.os.Parcel;
import android.os.Parcelable;

public class RequestRegister implements Parcelable {
    public static final Parcelable.Creator<RequestRegister> CREATOR = new Parcelable.Creator<RequestRegister>() {
        public RequestRegister createFromParcel(Parcel parcel) {
            return new RequestRegister(parcel);
        }

        public RequestRegister[] newArray(int i) {
            return new RequestRegister[i];
        }
    };
    private String andrDeviceId;
    private String andrFcmId;
    private String cityId;
    private String countryId;
    private String currentOTP = "";
    private String cusEmail;
    private String cusName;
    private String cusPassword;
    private String cusPhone;
    private String generatedOTP = "";
    private String iosDeviceId = "";
    private String iosFcmId = "";
    private String lang;
    private String type;

    public int describeContents() {
        return 0;
    }

    protected RequestRegister(Parcel parcel) {
        this.cusName = parcel.readString();
        this.cusEmail = parcel.readString();
        this.cusPhone = parcel.readString();
        this.iosFcmId = parcel.readString();
        this.iosDeviceId = parcel.readString();
        this.generatedOTP = parcel.readString();
        this.currentOTP = parcel.readString();
        this.countryId = parcel.readString();
        this.cityId = parcel.readString();
        this.cusPassword = parcel.readString();
        this.lang = parcel.readString();
        this.andrFcmId = parcel.readString();
        this.andrDeviceId = parcel.readString();
        this.type = parcel.readString();
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

    public String getIosFcmId() {
        return this.iosFcmId;
    }

    public void setIosFcmId(String str) {
        this.iosFcmId = str;
    }

    public String getIosDeviceId() {
        return this.iosDeviceId;
    }

    public void setIosDeviceId(String str) {
        this.iosDeviceId = str;
    }

    public String getGeneratedOtp() {
        return this.generatedOTP;
    }

    public void setGeneratedOtp(String str) {
        this.generatedOTP = str;
    }

    public String getCurrentOtp() {
        return this.currentOTP;
    }

    public void setCurrentOtp(String str) {
        this.currentOTP = str;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String str) {
        this.countryId = str;
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String str) {
        this.cityId = str;
    }

    public String getCusPassword() {
        return this.cusPassword;
    }

    public void setCusPassword(String str) {
        this.cusPassword = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public String getAndrFcmId() {
        return this.andrFcmId;
    }

    public void setAndrFcmId(String str) {
        this.andrFcmId = str;
    }

    public String getAndrDeviceId() {
        return this.andrDeviceId;
    }

    public void setAndrDeviceId(String str) {
        this.andrDeviceId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public RequestRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.cusName = str;
        this.cusEmail = str2;
        this.cusPhone = str3;
        this.countryId = str4;
        this.cityId = str5;
        this.cusPassword = str6;
        this.lang = str7;
        this.andrFcmId = str8;
        this.andrDeviceId = str9;
        this.type = str10;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cusName);
        parcel.writeString(this.cusEmail);
        parcel.writeString(this.cusPhone);
        parcel.writeString(this.iosFcmId);
        parcel.writeString(this.iosDeviceId);
        parcel.writeString(this.generatedOTP);
        parcel.writeString(this.currentOTP);
        parcel.writeString(this.countryId);
        parcel.writeString(this.cityId);
        parcel.writeString(this.cusPassword);
        parcel.writeString(this.lang);
        parcel.writeString(this.andrFcmId);
        parcel.writeString(this.andrDeviceId);
        parcel.writeString(this.type);
    }
}
