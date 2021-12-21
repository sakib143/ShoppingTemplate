package com.innomalist.taxi.shoppingapp.model.mycart;

public class UpdateCartRequest {
    private int cartId;
    private String cusId;
    private String lang;
    private String productColorId;
    private int productId;
    private String productSizeId;
    private int quantity;

    public UpdateCartRequest(int i, int i2, String str, String str2, int i3, String str3, String str4) {
        this.cartId = i;
        this.productId = i2;
        this.productSizeId = str;
        this.productColorId = str2;
        this.quantity = i3;
        this.cusId = str3;
        this.lang = str4;
    }
}
