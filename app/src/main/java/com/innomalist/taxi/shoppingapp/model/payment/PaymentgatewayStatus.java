package com.innomalist.taxi.shoppingapp.model.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentgatewayStatus {
    @SerializedName("Proxypay")
    @Expose
    private Boolean Proxypay;
    @SerializedName("COD")
    @Expose
    private Boolean cOD;
    @SerializedName("PayUmoney")
    @Expose
    private Boolean payUmoney;
    @SerializedName("Paypal")
    @Expose
    private Boolean paypal;

    public Boolean getProxypay() {
        return this.Proxypay;
    }

    public void setProxypay(Boolean bool) {
        this.Proxypay = bool;
    }

    public Boolean getCOD() {
        return this.cOD;
    }

    public void setCOD(Boolean bool) {
        this.cOD = bool;
    }

    public Boolean getPaypal() {
        return this.paypal;
    }

    public void setPaypal(Boolean bool) {
        this.paypal = bool;
    }

    public Boolean getPayUmoney() {
        return this.payUmoney;
    }

    public void setPayUmoney(Boolean bool) {
        this.payUmoney = bool;
    }
}
