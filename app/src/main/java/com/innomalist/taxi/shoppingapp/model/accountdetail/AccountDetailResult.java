package com.innomalist.taxi.shoppingapp.model.accountdetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class AccountDetailResult {
    @SerializedName("shippingDetails")
    @Expose
    private ArrayList<ShippingDetail> shippingDetails = null;
    @SerializedName("userDetails")
    @Expose
    private ArrayList<UserDetail> userDetails = null;

    public ArrayList<UserDetail> getUserDetails() {
        return this.userDetails;
    }

    public void setUserDetails(ArrayList<UserDetail> arrayList) {
        this.userDetails = arrayList;
    }

    public ArrayList<ShippingDetail> getShippingDetails() {
        return this.shippingDetails;
    }

    public void setShippingDetails(ArrayList<ShippingDetail> arrayList) {
        this.shippingDetails = arrayList;
    }
}
