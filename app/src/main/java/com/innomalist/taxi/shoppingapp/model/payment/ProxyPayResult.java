package com.innomalist.taxi.shoppingapp.model.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProxyPayResult {
    @SerializedName("cartDetails")
    @Expose
    private List<ProxyPayCartDetail> cartDetails = null;
    @SerializedName("shippingDetails")
    @Expose
    private List<ShippingDetail> shippingDetails = null;
    @SerializedName("totalOrderAmt")
    @Expose
    private String totalOrderAmt;

    public String getTotalOrderAmt() {
        return this.totalOrderAmt;
    }

    public void setTotalOrderAmt(String str) {
        this.totalOrderAmt = str;
    }

    public List<ProxyPayCartDetail> getCartDetails() {
        return this.cartDetails;
    }

    public void setCartDetails(List<ProxyPayCartDetail> list) {
        this.cartDetails = list;
    }

    public List<ShippingDetail> getShippingDetails() {
        return this.shippingDetails;
    }

    public void setShippingDetails(List<ShippingDetail> list) {
        this.shippingDetails = list;
    }
}
