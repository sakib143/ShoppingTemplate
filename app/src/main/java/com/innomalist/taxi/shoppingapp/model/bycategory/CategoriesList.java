package com.innomalist.taxi.shoppingapp.model.bycategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CategoriesList {
    @SerializedName("mainCategoryId")
    @Expose
    private Integer mainCategoryId;
    @SerializedName("mainCategoryImage")
    @Expose
    private String mainCategoryImage;
    @SerializedName("mainCategoryName")
    @Expose
    private String mainCategoryName;
    @SerializedName("mainCategoryStatus")
    @Expose
    private Integer mainCategoryStatus;
    @SerializedName("secMaincategoryList")
    @Expose
    private List<SecMaincategoryList> secMaincategoryList = null;

    public Integer getMainCategoryId() {
        return this.mainCategoryId;
    }

    public void setMainCategoryId(Integer num) {
        this.mainCategoryId = num;
    }

    public String getMainCategoryName() {
        return this.mainCategoryName;
    }

    public void setMainCategoryName(String str) {
        this.mainCategoryName = str;
    }

    public String getMainCategoryImage() {
        return this.mainCategoryImage;
    }

    public void setMainCategoryImage(String str) {
        this.mainCategoryImage = str;
    }

    public Integer getMainCategoryStatus() {
        return this.mainCategoryStatus;
    }

    public void setMainCategoryStatus(Integer num) {
        this.mainCategoryStatus = num;
    }

    public List<SecMaincategoryList> getSecMaincategoryList() {
        return this.secMaincategoryList;
    }

    public void setSecMaincategoryList(List<SecMaincategoryList> list) {
        this.secMaincategoryList = list;
    }
}
