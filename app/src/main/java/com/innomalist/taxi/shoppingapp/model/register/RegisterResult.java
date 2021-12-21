package com.innomalist.taxi.shoppingapp.model.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RegisterResult {
    @SerializedName("cartCount")
    @Expose
    private Integer cartCount;
    @SerializedName("shippingDetails")
    @Expose
    private List<ShippingDetail> shippingDetails = null;
    @SerializedName("userDetails")
    @Expose
    private List<UserDetail> userDetails = null;

    public List<UserDetail> getUserDetails() {
        return this.userDetails;
    }

    public void setUserDetails(List<UserDetail> list) {
        this.userDetails = list;
    }

    public List<ShippingDetail> getShippingDetails() {
        return this.shippingDetails;
    }

    public void setShippingDetails(List<ShippingDetail> list) {
        this.shippingDetails = list;
    }

    public Integer getCartCount() {
        return this.cartCount;
    }

    public void setCartCount(Integer num) {
        this.cartCount = num;
    }
}
