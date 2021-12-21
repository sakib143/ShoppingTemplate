package com.innomalist.taxi.shoppingapp.model.tracking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OrderDetails {
    @SerializedName("AWB Number")
    @Expose
    private String aWBNumber;
    @SerializedName("shipDetails")
    @Expose
    private List<ShipDetail> shipDetails = null;
    @SerializedName("Shipment staus")
    @Expose
    private String shipmentStaus;

    public String getAWBNumber() {
        return this.aWBNumber;
    }

    public void setAWBNumber(String str) {
        this.aWBNumber = str;
    }

    public String getShipmentStaus() {
        return this.shipmentStaus;
    }

    public void setShipmentStaus(String str) {
        this.shipmentStaus = str;
    }

    public List<ShipDetail> getShipDetails() {
        return this.shipDetails;
    }

    public void setShipDetails(List<ShipDetail> list) {
        this.shipDetails = list;
    }
}
