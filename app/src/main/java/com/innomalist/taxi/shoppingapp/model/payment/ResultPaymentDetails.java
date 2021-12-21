package com.innomalist.taxi.shoppingapp.model.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultPaymentDetails {
    @SerializedName("cartCount")
    @Expose
    private Integer cartCount;
    @SerializedName("cartCurrencyCode")
    @Expose
    private String cartCurrencyCode;
    @SerializedName("cartCurrencySymbol")
    @Expose
    private String cartCurrencySymbol;
    @SerializedName("cartGrandShipping")
    @Expose
    private String cartGrandShipping;
    @SerializedName("cartGrandTax")
    @Expose
    private String cartGrandTax;
    @SerializedName("cartGrandTotal")
    @Expose
    private String cartGrandTotal;
    @SerializedName("cartGrandTotalShow")
    @Expose
    private String cartGrandTotalShow;
    @SerializedName("cartGrandTotal_USD")
    @Expose
    private String cartGrandTotal_USD;
    @SerializedName("cartSubTotal")
    @Expose
    private String cartSubTotal;
    @SerializedName("paymentgatewayStatus")
    @Expose
    private PaymentgatewayStatus paymentgatewayStatus;

    public String getCartGrandTotalShow() {
        return this.cartGrandTotalShow;
    }

    public void setCartGrandTotalShow(String str) {
        this.cartGrandTotalShow = str;
    }

    public String getCartGrandTotal_USD() {
        return this.cartGrandTotal_USD;
    }

    public void setCartGrandTotal_USD(String str) {
        this.cartGrandTotal_USD = str;
    }

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

    public PaymentgatewayStatus getPaymentgatewayStatus() {
        return this.paymentgatewayStatus;
    }

    public void setPaymentgatewayStatus(PaymentgatewayStatus paymentgatewayStatus2) {
        this.paymentgatewayStatus = paymentgatewayStatus2;
    }
}
