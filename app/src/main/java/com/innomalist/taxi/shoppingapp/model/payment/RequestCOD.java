package com.innomalist.taxi.shoppingapp.model.payment;


public class RequestCOD extends ShippingDetail {
    private String cusId;
    private String lang;

    public RequestCOD(ShippingDetail shippingDetail, String str, String str2) {
        super(shippingDetail.getShipName(), shippingDetail.getShipEmail(), shippingDetail.getShipPhone(), shippingDetail.getShipAddress1(), shippingDetail.getShipAddress2(), shippingDetail.getShipCountryId(), shippingDetail.getShipCountryName(), shippingDetail.getShipCityId(), shippingDetail.getShipCityName(), shippingDetail.getShipState(), shippingDetail.getShipPostalcode());
        this.cusId = str;
        this.lang = str2;
    }
}
