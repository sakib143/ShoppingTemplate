package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecValue {
    @SerializedName("specName")
    @Expose
    private String specName;
    @SerializedName("specValue")
    @Expose
    private String specValue;

    public String getSpecName() {
        return this.specName;
    }

    public void setSpecName(String str) {
        this.specName = str;
    }

    public String getSpecValue() {
        return this.specValue;
    }

    public void setSpecValue(String str) {
        this.specValue = str;
    }
}
