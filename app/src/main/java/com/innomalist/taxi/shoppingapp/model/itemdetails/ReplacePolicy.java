package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReplacePolicy {
    @SerializedName("noOfDays")
    @Expose
    private String noOfDays;
    @SerializedName("policyDesc")
    @Expose
    private String policyDesc;

    public String getNoOfDays() {
        return this.noOfDays;
    }

    public void setNoOfDays(String str) {
        this.noOfDays = str;
    }

    public String getPolicyDesc() {
        return this.policyDesc;
    }

    public void setPolicyDesc(String str) {
        this.policyDesc = str;
    }
}
