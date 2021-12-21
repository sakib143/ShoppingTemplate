package com.innomalist.taxi.shoppingapp.model.payment;


public class RequestPayPal extends ShippingDetail {
    private String cusId;
    private String lang;
    private String payerEmail = "";
    private String payerId = "";
    private String payerName = "";
    private String tokenId = "";
    private String transactionId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestPayPal(ShippingDetail shippingDetail, String str, String str2, String str3) {
        super(shippingDetail.getShipName(), shippingDetail.getShipEmail(), shippingDetail.getShipPhone(), shippingDetail.getShipAddress1(), shippingDetail.getShipAddress2(), shippingDetail.getShipCountryId(), shippingDetail.getShipCountryName(), shippingDetail.getShipCityId(), shippingDetail.getShipCityName(), shippingDetail.getShipState(), shippingDetail.getShipPostalcode());
        this.cusId = str;
        this.lang = str2;
        this.transactionId = str3;
    }
}
