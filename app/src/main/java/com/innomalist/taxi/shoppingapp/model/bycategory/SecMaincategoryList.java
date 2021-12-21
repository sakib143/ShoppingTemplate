package com.innomalist.taxi.shoppingapp.model.bycategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class SecMaincategoryList {
    @SerializedName("secCategoryId")
    @Expose
    private String secCategoryId;
    @SerializedName("secCategoryName")
    @Expose
    private String secCategoryName;
    @SerializedName("secCategoryStatus")
    @Expose
    private Integer secCategoryStatus;
    @SerializedName("secMainCategoryId")
    @Expose
    private Integer secMainCategoryId;
    @SerializedName("subCategoryList")
    @Expose
    private ArrayList<SubCategoryList> subCategoryList = null;

    public String getSecCategoryId() {
        return this.secCategoryId;
    }

    public void setSecCategoryId(String str) {
        this.secCategoryId = str;
    }

    public String getSecCategoryName() {
        return this.secCategoryName;
    }

    public void setSecCategoryName(String str) {
        this.secCategoryName = str;
    }

    public Integer getSecMainCategoryId() {
        return this.secMainCategoryId;
    }

    public void setSecMainCategoryId(Integer num) {
        this.secMainCategoryId = num;
    }

    public Integer getSecCategoryStatus() {
        return this.secCategoryStatus;
    }

    public void setSecCategoryStatus(Integer num) {
        this.secCategoryStatus = num;
    }

    public ArrayList<SubCategoryList> getSubCategoryList() {
        return this.subCategoryList;
    }

    public void setSubCategoryList(ArrayList<SubCategoryList> arrayList) {
        this.subCategoryList = arrayList;
    }
}
