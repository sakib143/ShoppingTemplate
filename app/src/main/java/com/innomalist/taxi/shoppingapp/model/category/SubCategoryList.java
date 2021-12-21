package com.innomalist.taxi.shoppingapp.model.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryList {
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("categoryStatus")
    @Expose
    private Integer categoryStatus;
    boolean isExpanded = false;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("subCategoryList")
    @Expose
    private List<SubCategoryList> subCategoryList = null;

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer num) {
        this.level = num;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer num) {
        this.categoryId = num;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String getCategoryImage() {
        return this.categoryImage;
    }

    public void setCategoryImage(String str) {
        this.categoryImage = str;
    }

    public Integer getCategoryStatus() {
        return this.categoryStatus;
    }

    public void setCategoryStatus(Integer num) {
        this.categoryStatus = num;
    }

    public List<SubCategoryList> getSubCategoryList() {
        List<SubCategoryList> list = this.subCategoryList;
        return list == null ? new ArrayList() : list;
    }

    public void setSubCategoryList(List<SubCategoryList> list) {
        this.subCategoryList = list;
    }
}
