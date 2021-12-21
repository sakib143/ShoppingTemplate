package com.innomalist.taxi.shoppingapp.model.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentResult {
    @SerializedName("totalOrderAmt")
    @Expose
    private String totalOrderAmt;

    public String getTotalOrderAmt() {
        return this.totalOrderAmt;
    }

    public void setTotalOrderAmt(String str) {
        this.totalOrderAmt = str;
    }
}
