package com.innomalist.taxi.shoppingapp.model.payment;


public class RequestProxyPay extends ShippingDetail {
    private String cusId;
    private String entityId;
    private String lang;
    private String referenceId;
    private String transactionId;

    public RequestProxyPay(ShippingDetail shippingDetail, String str, String str2) {
        super(shippingDetail.getShipName(), shippingDetail.getShipEmail(), shippingDetail.getShipPhone(), shippingDetail.getShipAddress1(), shippingDetail.getShipAddress2(), shippingDetail.getShipCountryId(), shippingDetail.getShipCountryName(), shippingDetail.getShipCityId(), shippingDetail.getShipCityName(), shippingDetail.getShipState(), shippingDetail.getShipPostalcode());
        this.cusId = str;
        this.lang = str2;
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

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public void setEntityId(String str) {
        this.entityId = str;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String str) {
        this.referenceId = str;
    }
}
