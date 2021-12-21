package com.innomalist.taxi.shoppingapp.model.myorder;

public class OrderTracking {
    private String date;
    private boolean orderStatus;
    private String orderTitle;

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public boolean isOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(boolean z) {
        this.orderStatus = z;
    }

    public String getOrderTitle() {
        return this.orderTitle;
    }

    public void setOrderTitle(String str) {
        this.orderTitle = str;
    }

    public OrderTracking(String str, boolean z, String str2) {
        this.date = str;
        this.orderStatus = z;
        this.orderTitle = str2;
    }
}
