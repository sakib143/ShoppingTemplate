package com.innomalist.taxi.shoppingapp.model.myorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OrderHistoryResult {
    @SerializedName("orderList")
    @Expose
    private List<OrderList> orderList = null;

    public List<OrderList> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<OrderList> list) {
        this.orderList = list;
    }
}
