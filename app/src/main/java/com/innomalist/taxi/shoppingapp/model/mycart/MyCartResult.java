package com.innomalist.taxi.shoppingapp.model.mycart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MyCartResult {
    @SerializedName("cartCount")
    @Expose
    private Integer cartCount;
    @SerializedName("cartCurrencyCode")
    @Expose
    private String cartCurrencyCode;
    @SerializedName("cartCurrencySymbol")
    @Expose
    private String cartCurrencySymbol;
    @SerializedName("cartDetails")
    @Expose
    private List<CartDetail> cartDetails = null;
    @SerializedName("cartGrandShipping")
    @Expose
    private String cartGrandShipping;
    @SerializedName("cartGrandTax")
    @Expose
    private String cartGrandTax;
    @SerializedName("cartGrandTotal")
    @Expose
    private String cartGrandTotal;
    @SerializedName("cartSubTotal")
    @Expose
    private String cartSubTotal;

    public Integer getCartCount() {
        return this.cartCount;
    }

    public void setCartCount(Integer num) {
        this.cartCount = num;
    }

    public String getCartSubTotal() {
        return this.cartSubTotal;
    }

    public void setCartSubTotal(String str) {
        this.cartSubTotal = str;
    }

    public String getCartGrandShipping() {
        return this.cartGrandShipping;
    }

    public void setCartGrandShipping(String str) {
        this.cartGrandShipping = str;
    }

    public String getCartGrandTax() {
        return this.cartGrandTax;
    }

    public void setCartGrandTax(String str) {
        this.cartGrandTax = str;
    }

    public String getCartGrandTotal() {
        return this.cartGrandTotal;
    }

    public void setCartGrandTotal(String str) {
        this.cartGrandTotal = str;
    }

    public String getCartCurrencyCode() {
        return this.cartCurrencyCode;
    }

    public void setCartCurrencyCode(String str) {
        this.cartCurrencyCode = str;
    }

    public String getCartCurrencySymbol() {
        return this.cartCurrencySymbol;
    }

    public void setCartCurrencySymbol(String str) {
        this.cartCurrencySymbol = str;
    }

    public List<CartDetail> getCartDetails() {
        return this.cartDetails;
    }

    public void setCartDetails(List<CartDetail> list) {
        this.cartDetails = list;
    }
}
