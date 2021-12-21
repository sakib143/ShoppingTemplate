package com.innomalist.taxi.shoppingapp.model.itemdetails;

public class AddToCartRequest {
    private int clearCart;
    private String cusId;
    private String lang;
    private int productColorId;
    private int productId;
    private int productSizeId;
    private int quantity;

    public int getClearCart() {
        return this.clearCart;
    }

    public void setClearCart(int i) {
        this.clearCart = i;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i) {
        this.productId = i;
    }

    public int getProductSizeId() {
        return this.productSizeId;
    }

    public void setProductSizeId(int i) {
        this.productSizeId = i;
    }

    public int getProductColorId() {
        return this.productColorId;
    }

    public void setProductColorId(int i) {
        this.productColorId = i;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public AddToCartRequest(int i, int i2, int i3, int i4, String str, String str2, int i5) {
        this.productId = i;
        this.productSizeId = i3;
        this.productColorId = i2;
        this.quantity = i4;
        this.cusId = str;
        this.lang = str2;
        this.clearCart = i5;
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
}
