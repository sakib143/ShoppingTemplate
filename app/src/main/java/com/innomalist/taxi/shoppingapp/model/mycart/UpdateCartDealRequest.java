package com.innomalist.taxi.shoppingapp.model.mycart;

public class UpdateCartDealRequest {
    private int cartId;
    private String cusId;
    private int dealId;
    private String lang;
    private int quantity;

    public UpdateCartDealRequest(int i, int i2, int i3, String str, String str2) {
        this.cartId = i;
        this.dealId = i2;
        this.quantity = i3;
        this.cusId = str;
        this.lang = str2;
    }
}
