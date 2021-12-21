package com.innomalist.taxi.shoppingapp.model.storelist;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreDetail implements Parcelable {
    public static final Parcelable.Creator<StoreDetail> CREATOR = new Parcelable.Creator<StoreDetail>() {
        public StoreDetail createFromParcel(Parcel parcel) {
            return new StoreDetail(parcel);
        }

        public StoreDetail[] newArray(int i) {
            return new StoreDetail[i];
        }
    };
    @SerializedName("storeAddress1")
    @Expose
    private String storeAddress1;
    @SerializedName("storeAddress2")
    @Expose
    private String storeAddress2;
    @SerializedName("storeCityId")
    @Expose
    private Integer storeCityId;
    @SerializedName("storeCityName")
    @Expose
    private String storeCityName;
    @SerializedName("storeCountryId")
    @Expose
    private Integer storeCountryId;
    @SerializedName("storeCountryName")
    @Expose
    private String storeCountryName;
    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("storeImg")
    @Expose
    private String storeImg;
    @SerializedName("storeLatitude")
    @Expose
    private String storeLatitude;
    @SerializedName("storeLongitude")
    @Expose
    private String storeLongitude;
    @SerializedName("storeMerchantId")
    @Expose
    private Integer storeMerchantId;
    @SerializedName("storeMerchantName")
    @Expose
    private String storeMerchantName;
    @SerializedName("storeMetadesc")
    @Expose
    private String storeMetadesc;
    @SerializedName("storeMetakeywords")
    @Expose
    private String storeMetakeywords;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("storePhone")
    @Expose
    private String storePhone;
    @SerializedName("storeStatus")
    @Expose
    private Integer storeStatus;
    @SerializedName("storeWebsite")
    @Expose
    private String storeWebsite;
    @SerializedName("storeZipcode")
    @Expose
    private String storeZipcode;

    public int describeContents() {
        return 0;
    }

    protected StoreDetail(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.storeId = null;
        } else {
            this.storeId = Integer.valueOf(parcel.readInt());
        }
        this.storeName = parcel.readString();
        this.storePhone = parcel.readString();
        this.storeAddress1 = parcel.readString();
        this.storeAddress2 = parcel.readString();
        this.storeZipcode = parcel.readString();
        this.storeWebsite = parcel.readString();
        this.storeLatitude = parcel.readString();
        this.storeLongitude = parcel.readString();
        this.storeMetakeywords = parcel.readString();
        this.storeMetadesc = parcel.readString();
        if (parcel.readByte() == 0) {
            this.storeCountryId = null;
        } else {
            this.storeCountryId = Integer.valueOf(parcel.readInt());
        }
        this.storeCountryName = parcel.readString();
        if (parcel.readByte() == 0) {
            this.storeCityId = null;
        } else {
            this.storeCityId = Integer.valueOf(parcel.readInt());
        }
        this.storeCityName = parcel.readString();
        if (parcel.readByte() == 0) {
            this.storeMerchantId = null;
        } else {
            this.storeMerchantId = Integer.valueOf(parcel.readInt());
        }
        this.storeMerchantName = parcel.readString();
        this.storeImg = parcel.readString();
        if (parcel.readByte() == 0) {
            this.storeStatus = null;
        } else {
            this.storeStatus = Integer.valueOf(parcel.readInt());
        }
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer num) {
        this.storeId = num;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String str) {
        this.storeName = str;
    }

    public String getStorePhone() {
        return this.storePhone;
    }

    public void setStorePhone(String str) {
        this.storePhone = str;
    }

    public String getStoreAddress1() {
        return this.storeAddress1;
    }

    public void setStoreAddress1(String str) {
        this.storeAddress1 = str;
    }

    public String getStoreAddress2() {
        return this.storeAddress2;
    }

    public void setStoreAddress2(String str) {
        this.storeAddress2 = str;
    }

    public String getStoreZipcode() {
        return this.storeZipcode;
    }

    public void setStoreZipcode(String str) {
        this.storeZipcode = str;
    }

    public String getStoreWebsite() {
        return this.storeWebsite;
    }

    public void setStoreWebsite(String str) {
        this.storeWebsite = str;
    }

    public String getStoreLatitude() {
        return this.storeLatitude;
    }

    public void setStoreLatitude(String str) {
        this.storeLatitude = str;
    }

    public String getStoreLongitude() {
        return this.storeLongitude;
    }

    public void setStoreLongitude(String str) {
        this.storeLongitude = str;
    }

    public String getStoreMetakeywords() {
        return this.storeMetakeywords;
    }

    public void setStoreMetakeywords(String str) {
        this.storeMetakeywords = str;
    }

    public String getStoreMetadesc() {
        return this.storeMetadesc;
    }

    public void setStoreMetadesc(String str) {
        this.storeMetadesc = str;
    }

    public Integer getStoreCountryId() {
        return this.storeCountryId;
    }

    public void setStoreCountryId(Integer num) {
        this.storeCountryId = num;
    }

    public String getStoreCountryName() {
        return this.storeCountryName;
    }

    public void setStoreCountryName(String str) {
        this.storeCountryName = str;
    }

    public Integer getStoreCityId() {
        return this.storeCityId;
    }

    public void setStoreCityId(Integer num) {
        this.storeCityId = num;
    }

    public String getStoreCityName() {
        return this.storeCityName;
    }

    public void setStoreCityName(String str) {
        this.storeCityName = str;
    }

    public Integer getStoreMerchantId() {
        return this.storeMerchantId;
    }

    public void setStoreMerchantId(Integer num) {
        this.storeMerchantId = num;
    }

    public String getStoreMerchantName() {
        return this.storeMerchantName;
    }

    public void setStoreMerchantName(String str) {
        this.storeMerchantName = str;
    }

    public String getStoreImg() {
        return this.storeImg;
    }

    public void setStoreImg(String str) {
        this.storeImg = str;
    }

    public Integer getStoreStatus() {
        return this.storeStatus;
    }

    public void setStoreStatus(Integer num) {
        this.storeStatus = num;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.storeId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.storeId.intValue());
        }
        parcel.writeString(this.storeName);
        parcel.writeString(this.storePhone);
        parcel.writeString(this.storeAddress1);
        parcel.writeString(this.storeAddress2);
        parcel.writeString(this.storeZipcode);
        parcel.writeString(this.storeWebsite);
        parcel.writeString(this.storeLatitude);
        parcel.writeString(this.storeLongitude);
        parcel.writeString(this.storeMetakeywords);
        parcel.writeString(this.storeMetadesc);
        if (this.storeCountryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.storeCountryId.intValue());
        }
        parcel.writeString(this.storeCountryName);
        if (this.storeCityId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.storeCityId.intValue());
        }
        parcel.writeString(this.storeCityName);
        if (this.storeMerchantId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.storeMerchantId.intValue());
        }
        parcel.writeString(this.storeMerchantName);
        parcel.writeString(this.storeImg);
        if (this.storeStatus == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.storeStatus.intValue());
    }
}
