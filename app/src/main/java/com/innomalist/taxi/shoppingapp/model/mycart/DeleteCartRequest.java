package com.innomalist.taxi.shoppingapp.model.mycart;

public class DeleteCartRequest {
    private int cartId;
    private String lang;

    public DeleteCartRequest(int i, String str) {
        this.cartId = i;
        this.lang = str;
    }
}
