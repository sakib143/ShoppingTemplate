package com.innomalist.taxi.shoppingapp.model.tracking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DHLOrderDetails {
    @SerializedName("orderDetails")
    @Expose
    private OrderDetails orderDetails;

    public OrderDetails getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails2) {
        this.orderDetails = orderDetails2;
    }
}
