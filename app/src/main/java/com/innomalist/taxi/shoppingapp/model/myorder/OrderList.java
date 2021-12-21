package com.innomalist.taxi.shoppingapp.model.myorder;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class OrderList implements Parcelable {
    public static final Parcelable.Creator<OrderList> CREATOR = new Parcelable.Creator<OrderList>() {
        public OrderList createFromParcel(Parcel parcel) {
            return new OrderList(parcel);
        }

        public OrderList[] newArray(int i) {
            return new OrderList[i];
        }
    };
    @SerializedName("deliveryStatus")
    @Expose
    private String deliveryStatus;
    @SerializedName("deliveryStatusKey")
    @Expose
    private Integer deliveryStatusKey;
    @SerializedName("dhl_tracking_id")
    @Expose
    private String dhlTrackingId;
    @SerializedName("orderAmount")
    @Expose
    private String orderAmount;
    @SerializedName("orderDate")
    @Expose
    private String orderDate;
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("orderQty")
    @Expose
    private Integer orderQty;
    @SerializedName("orderShippingAddress")
    @Expose
    private String orderShippingAddress;
    @SerializedName("orderStatus")
    @Expose
    private String orderStatus;
    @SerializedName("orderTax")
    @Expose
    private String orderTax;
    @SerializedName("orderTitle")
    @Expose
    private String orderTitle;
    @SerializedName("orderTransactionId")
    @Expose
    private String orderTransactionId;
    @SerializedName("productCurrencyCode")
    @Expose
    private String productCurrencyCode;
    @SerializedName("productCurrencySymbol")
    @Expose
    private String productCurrencySymbol;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("shipAddress1")
    @Expose
    private String shipAddress1;
    @SerializedName("shipAddress2")
    @Expose
    private String shipAddress2;
    @SerializedName("shipCityName")
    @Expose
    private String shipCityName;
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
    @SerializedName("trackingDetails")
    @Expose
    private ArrayList<TrackingDetails> trackingDetails;

    public int describeContents() {
        return 0;
    }

    public String getDhlTrackingId() {
        return this.dhlTrackingId;
    }

    public void setDhlTrackingId(String str) {
        this.dhlTrackingId = str;
    }

    public int getDeliveryStatusKey() {
        return this.deliveryStatusKey.intValue();
    }

    public void setDeliveryStatusKey(int i) {
        this.deliveryStatusKey = Integer.valueOf(i);
    }

    public ArrayList<TrackingDetails> getTrackingDetails() {
        return this.trackingDetails;
    }

    public void setTrackingDetails(ArrayList<TrackingDetails> arrayList) {
        this.trackingDetails = arrayList;
    }

    protected OrderList(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.orderId = null;
        } else {
            this.orderId = Integer.valueOf(parcel.readInt());
        }
        this.orderTitle = parcel.readString();
        this.productImage = parcel.readString();
        this.orderDate = parcel.readString();
        this.orderStatus = parcel.readString();
        this.deliveryStatus = parcel.readString();
        if (parcel.readByte() == 0) {
            this.orderQty = null;
        } else {
            this.orderQty = Integer.valueOf(parcel.readInt());
        }
        this.orderAmount = parcel.readString();
        this.orderTax = parcel.readString();
        if (parcel.readByte() == 0) {
            this.deliveryStatusKey = null;
        } else {
            this.deliveryStatusKey = Integer.valueOf(parcel.readInt());
        }
        this.productCurrencyCode = parcel.readString();
        this.productCurrencySymbol = parcel.readString();
        this.orderShippingAddress = parcel.readString();
        this.shipName = parcel.readString();
        this.shipEmail = parcel.readString();
        this.shipPhone = parcel.readString();
        this.shipAddress1 = parcel.readString();
        this.shipAddress2 = parcel.readString();
        this.shipCountryName = parcel.readString();
        this.shipCityName = parcel.readString();
        this.shipState = parcel.readString();
        this.shipPostalcode = parcel.readString();
        this.orderTransactionId = parcel.readString();
        this.trackingDetails = parcel.createTypedArrayList(TrackingDetails.CREATOR);
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer num) {
        this.orderId = num;
    }

    public String getOrderTitle() {
        return this.orderTitle;
    }

    public void setOrderTitle(String str) {
        this.orderTitle = str;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String str) {
        this.productImage = str;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String str) {
        this.orderDate = str;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public String getDeliveryStatus() {
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(String str) {
        this.deliveryStatus = str;
    }

    public Integer getOrderQty() {
        return this.orderQty;
    }

    public void setOrderQty(Integer num) {
        this.orderQty = num;
    }

    public String getOrderAmount() {
        return this.orderAmount;
    }

    public void setOrderAmount(String str) {
        this.orderAmount = str;
    }

    public String getOrderTax() {
        return this.orderTax;
    }

    public void setOrderTax(String str) {
        this.orderTax = str;
    }

    public String getProductCurrencyCode() {
        return this.productCurrencyCode;
    }

    public void setProductCurrencyCode(String str) {
        this.productCurrencyCode = str;
    }

    public String getProductCurrencySymbol() {
        return this.productCurrencySymbol;
    }

    public void setProductCurrencySymbol(String str) {
        this.productCurrencySymbol = str;
    }

    public String getOrderShippingAddress() {
        return this.orderShippingAddress;
    }

    public void setOrderShippingAddress(String str) {
        this.orderShippingAddress = str;
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

    public String getShipCountryName() {
        return this.shipCountryName;
    }

    public void setShipCountryName(String str) {
        this.shipCountryName = str;
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

    public String getOrderTransactionId() {
        return this.orderTransactionId;
    }

    public void setOrderTransactionId(String str) {
        this.orderTransactionId = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.orderId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.orderId.intValue());
        }
        parcel.writeString(this.orderTitle);
        parcel.writeString(this.productImage);
        parcel.writeString(this.orderDate);
        parcel.writeString(this.orderStatus);
        parcel.writeString(this.deliveryStatus);
        if (this.orderQty == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.orderQty.intValue());
        }
        parcel.writeString(this.orderAmount);
        parcel.writeString(this.orderTax);
        if (this.deliveryStatusKey == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.deliveryStatusKey.intValue());
        }
        parcel.writeString(this.productCurrencyCode);
        parcel.writeString(this.productCurrencySymbol);
        parcel.writeString(this.orderShippingAddress);
        parcel.writeString(this.shipName);
        parcel.writeString(this.shipEmail);
        parcel.writeString(this.shipPhone);
        parcel.writeString(this.shipAddress1);
        parcel.writeString(this.shipAddress2);
        parcel.writeString(this.shipCountryName);
        parcel.writeString(this.shipCityName);
        parcel.writeString(this.shipState);
        parcel.writeString(this.shipPostalcode);
        parcel.writeString(this.orderTransactionId);
        parcel.writeTypedList(this.trackingDetails);
    }
}
