package com.innomalist.taxi.shoppingapp.model.storelist;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealListByShop implements Parcelable {
    public static final Parcelable.Creator<DealListByShop> CREATOR = new Parcelable.Creator<DealListByShop>() {
        public DealListByShop createFromParcel(Parcel parcel) {
            return new DealListByShop(parcel);
        }

        public DealListByShop[] newArray(int i) {
            return new DealListByShop[i];
        }
    };
    @SerializedName("dealActiveorexpireStatus")
    @Expose
    private String dealActiveorexpireStatus;
    @SerializedName("dealCurrencyCode")
    @Expose
    private String dealCurrencyCode;
    @SerializedName("dealCurrencySymbol")
    @Expose
    private String dealCurrencySymbol;
    @SerializedName("dealDiscountPercentage")
    @Expose
    private Integer dealDiscountPercentage;
    @SerializedName("dealDiscountPrice")
    @Expose
    private String dealDiscountPrice;
    @SerializedName("dealEndDate")
    @Expose
    private String dealEndDate;
    @SerializedName("dealExpiryDate")
    @Expose
    private String dealExpiryDate;
    @SerializedName("dealId")
    @Expose
    private Integer dealId;
    @SerializedName("dealImage")
    @Expose
    private String dealImage;
    @SerializedName("dealOriginalPrice")
    @Expose
    private String dealOriginalPrice;
    @SerializedName("dealSavingPrice")
    @Expose
    private String dealSavingPrice;
    @SerializedName("dealShopId")
    @Expose
    private Integer dealShopId;
    @SerializedName("dealStartDate")
    @Expose
    private String dealStartDate;
    @SerializedName("dealStatus")
    @Expose
    private Integer dealStatus;
    @SerializedName("dealTitle")
    @Expose
    private String dealTitle;
    @SerializedName("iosDealEndDate")
    @Expose
    private String iosDealEndDate;
    @SerializedName("iosDealExpiryDate")
    @Expose
    private String iosDealExpiryDate;
    @SerializedName("iosDealStartDate")
    @Expose
    private String iosDealStartDate;

    public int describeContents() {
        return 0;
    }

    protected DealListByShop(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.dealId = null;
        } else {
            this.dealId = Integer.valueOf(parcel.readInt());
        }
        this.dealTitle = parcel.readString();
        this.dealOriginalPrice = parcel.readString();
        this.dealDiscountPrice = parcel.readString();
        if (parcel.readByte() == 0) {
            this.dealDiscountPercentage = null;
        } else {
            this.dealDiscountPercentage = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readByte() == 0) {
            this.dealSavingPrice = null;
        } else {
            this.dealSavingPrice = parcel.readString();
        }
        this.dealCurrencyCode = parcel.readString();
        this.dealCurrencySymbol = parcel.readString();
        this.dealStartDate = parcel.readString();
        this.dealEndDate = parcel.readString();
        this.dealExpiryDate = parcel.readString();
        this.iosDealStartDate = parcel.readString();
        this.iosDealEndDate = parcel.readString();
        this.iosDealExpiryDate = parcel.readString();
        if (parcel.readByte() == 0) {
            this.dealShopId = null;
        } else {
            this.dealShopId = Integer.valueOf(parcel.readInt());
        }
        this.dealImage = parcel.readString();
        this.dealActiveorexpireStatus = parcel.readString();
        if (parcel.readByte() == 0) {
            this.dealStatus = null;
        } else {
            this.dealStatus = Integer.valueOf(parcel.readInt());
        }
    }

    public Integer getDealId() {
        return this.dealId;
    }

    public void setDealId(Integer num) {
        this.dealId = num;
    }

    public String getDealTitle() {
        return this.dealTitle;
    }

    public void setDealTitle(String str) {
        this.dealTitle = str;
    }

    public String getDealOriginalPrice() {
        return this.dealOriginalPrice;
    }

    public void setDealOriginalPrice(String str) {
        this.dealOriginalPrice = str;
    }

    public String getDealDiscountPrice() {
        return this.dealDiscountPrice;
    }

    public void setDealDiscountPrice(String str) {
        this.dealDiscountPrice = str;
    }

    public Integer getDealDiscountPercentage() {
        return this.dealDiscountPercentage;
    }

    public void setDealDiscountPercentage(Integer num) {
        this.dealDiscountPercentage = num;
    }

    public String getDealSavingPrice() {
        return this.dealSavingPrice;
    }

    public void setDealSavingPrice(String str) {
        this.dealSavingPrice = str;
    }

    public String getDealCurrencyCode() {
        return this.dealCurrencyCode;
    }

    public void setDealCurrencyCode(String str) {
        this.dealCurrencyCode = str;
    }

    public String getDealCurrencySymbol() {
        return this.dealCurrencySymbol;
    }

    public void setDealCurrencySymbol(String str) {
        this.dealCurrencySymbol = str;
    }

    public String getDealStartDate() {
        return this.dealStartDate;
    }

    public void setDealStartDate(String str) {
        this.dealStartDate = str;
    }

    public String getDealEndDate() {
        return this.dealEndDate;
    }

    public void setDealEndDate(String str) {
        this.dealEndDate = str;
    }

    public String getDealExpiryDate() {
        return this.dealExpiryDate;
    }

    public void setDealExpiryDate(String str) {
        this.dealExpiryDate = str;
    }

    public String getIosDealStartDate() {
        return this.iosDealStartDate;
    }

    public void setIosDealStartDate(String str) {
        this.iosDealStartDate = str;
    }

    public String getIosDealEndDate() {
        return this.iosDealEndDate;
    }

    public void setIosDealEndDate(String str) {
        this.iosDealEndDate = str;
    }

    public String getIosDealExpiryDate() {
        return this.iosDealExpiryDate;
    }

    public void setIosDealExpiryDate(String str) {
        this.iosDealExpiryDate = str;
    }

    public Integer getDealShopId() {
        return this.dealShopId;
    }

    public void setDealShopId(Integer num) {
        this.dealShopId = num;
    }

    public String getDealImage() {
        return this.dealImage;
    }

    public void setDealImage(String str) {
        this.dealImage = str;
    }

    public String getDealActiveorexpireStatus() {
        return this.dealActiveorexpireStatus;
    }

    public void setDealActiveorexpireStatus(String str) {
        this.dealActiveorexpireStatus = str;
    }

    public Integer getDealStatus() {
        return this.dealStatus;
    }

    public void setDealStatus(Integer num) {
        this.dealStatus = num;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.dealId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.dealId.intValue());
        }
        parcel.writeString(this.dealTitle);
        parcel.writeString(this.dealOriginalPrice);
        parcel.writeString(this.dealDiscountPrice);
        if (this.dealDiscountPercentage == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.dealDiscountPercentage.intValue());
        }
        parcel.writeString(this.dealSavingPrice);
        parcel.writeString(this.dealCurrencyCode);
        parcel.writeString(this.dealCurrencySymbol);
        parcel.writeString(this.dealStartDate);
        parcel.writeString(this.dealEndDate);
        parcel.writeString(this.dealExpiryDate);
        parcel.writeString(this.iosDealStartDate);
        parcel.writeString(this.iosDealEndDate);
        parcel.writeString(this.iosDealExpiryDate);
        if (this.dealShopId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.dealShopId.intValue());
        }
        parcel.writeString(this.dealImage);
        parcel.writeString(this.dealActiveorexpireStatus);
        if (this.dealStatus == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.dealStatus.intValue());
    }
}
