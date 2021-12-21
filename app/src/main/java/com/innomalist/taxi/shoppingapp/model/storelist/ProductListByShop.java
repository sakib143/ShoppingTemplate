package com.innomalist.taxi.shoppingapp.model.storelist;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductListByShop implements Parcelable {
    public static final Parcelable.Creator<ProductListByShop> CREATOR = new Parcelable.Creator<ProductListByShop>() {
        public ProductListByShop createFromParcel(Parcel parcel) {
            return new ProductListByShop(parcel);
        }

        public ProductListByShop[] newArray(int i) {
            return new ProductListByShop[i];
        }
    };
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("currencySymbol")
    @Expose
    private String currencySymbol;
    @SerializedName("isWishlist")
    @Expose
    private Boolean isWishlist;
    @SerializedName("proNoOfPurchase")
    @Expose
    private Integer proNoOfPurchase;
    @SerializedName("proQty")
    @Expose
    private Integer proQty;
    @SerializedName("productDiscountPrice")
    @Expose
    private String productDiscountPrice;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("productPercentage")
    @Expose
    private Integer productPercentage;
    @SerializedName("productPrice")
    @Expose
    private String productPrice;
    @SerializedName("productTitle")
    @Expose
    private String productTitle;

    public int describeContents() {
        return 0;
    }

    protected ProductListByShop(Parcel parcel) {
        Boolean bool = null;
        if (parcel.readByte() == 0) {
            this.productId = null;
        } else {
            this.productId = Integer.valueOf(parcel.readInt());
        }
        this.productTitle = parcel.readString();
        this.productPrice = parcel.readString();
        this.productDiscountPrice = parcel.readString();
        if (parcel.readByte() == 0) {
            this.productPercentage = null;
        } else {
            this.productPercentage = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readByte() == 0) {
            this.proNoOfPurchase = null;
        } else {
            this.proNoOfPurchase = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readByte() == 0) {
            this.proQty = null;
        } else {
            this.proQty = Integer.valueOf(parcel.readInt());
        }
        this.productImage = parcel.readString();
        byte readByte = parcel.readByte();
        if (readByte != 0) {
            bool = Boolean.valueOf(readByte != 1 ? false : true);
        }
        this.isWishlist = bool;
        this.currencySymbol = parcel.readString();
        this.currencyCode = parcel.readString();
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer num) {
        this.productId = num;
    }

    public String getProductTitle() {
        return this.productTitle;
    }

    public void setProductTitle(String str) {
        this.productTitle = str;
    }

    public String getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(String str) {
        this.productPrice = str;
    }

    public String getProductDiscountPrice() {
        return this.productDiscountPrice;
    }

    public void setProductDiscountPrice(String str) {
        this.productDiscountPrice = str;
    }

    public Integer getProductPercentage() {
        return this.productPercentage;
    }

    public void setProductPercentage(Integer num) {
        this.productPercentage = num;
    }

    public Integer getProNoOfPurchase() {
        return this.proNoOfPurchase;
    }

    public void setProNoOfPurchase(Integer num) {
        this.proNoOfPurchase = num;
    }

    public Integer getProQty() {
        return this.proQty;
    }

    public void setProQty(Integer num) {
        this.proQty = num;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public Boolean getIsWishlist() {
        return this.isWishlist;
    }

    public void setIsWishlist(Boolean bool) {
        this.isWishlist = bool;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        if (this.productId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.productId.intValue());
        }
        parcel.writeString(this.productTitle);
        parcel.writeString(this.productPrice);
        parcel.writeString(this.productDiscountPrice);
        if (this.productPercentage == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.productPercentage.intValue());
        }
        if (this.proNoOfPurchase == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.proNoOfPurchase.intValue());
        }
        if (this.proQty == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.proQty.intValue());
        }
        parcel.writeString(this.productImage);
        Boolean bool = this.isWishlist;
        if (bool != null) {
            i2 = bool.booleanValue() ? 1 : 2;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.currencySymbol);
        parcel.writeString(this.currencyCode);
    }
}
