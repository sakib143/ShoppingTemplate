package com.innomalist.taxi.shoppingapp.model.tracking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipDetail {
    @SerializedName("Date Time")
    @Expose
    private String dateTime;
    @SerializedName("Status")
    @Expose
    private String status;

    public ShipDetail(String str, String str2) {
        this.dateTime = str;
        this.status = str2;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
