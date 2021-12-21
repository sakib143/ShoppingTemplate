package com.innomalist.taxi.shoppingapp.model.itemdetails;

public class AddDealToCartRequest {
    private int clearCart;
    private String cusId;
    private int dealId;
    private String lang;
    private int quantity;

    public AddDealToCartRequest(int i, int i2, String str, String str2, int i3) {
        this.dealId = i;
        this.quantity = i2;
        this.cusId = str;
        this.lang = str2;
        this.clearCart = i3;
    }

    public int getDealId() {
        return this.dealId;
    }

    public void setDealId(int i) {
        this.dealId = i;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public String getCusId() {
        return this.cusId;
    }

    public void setCusId(String str) {
        this.cusId = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public int getClearCart() {
        return this.clearCart;
    }

    public void setClearCart(int i) {
        this.clearCart = i;
    }
}
