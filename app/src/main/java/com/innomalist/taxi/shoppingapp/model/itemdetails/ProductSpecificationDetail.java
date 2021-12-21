package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProductSpecificationDetail {
    @SerializedName("specGrpId")
    @Expose
    private Integer specGrpId;
    @SerializedName("specGrpName")
    @Expose
    private String specGrpName;
    @SerializedName("specValue")
    @Expose
    private List<SpecValue> specValue = null;

    public Integer getSpecGrpId() {
        return this.specGrpId;
    }

    public void setSpecGrpId(Integer num) {
        this.specGrpId = num;
    }

    public String getSpecGrpName() {
        return this.specGrpName;
    }

    public void setSpecGrpName(String str) {
        this.specGrpName = str;
    }

    public List<SpecValue> getSpecValue() {
        return this.specValue;
    }

    public void setSpecValue(List<SpecValue> list) {
        this.specValue = list;
    }
}
