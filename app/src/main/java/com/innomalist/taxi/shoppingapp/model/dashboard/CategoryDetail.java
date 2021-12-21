package com.innomalist.taxi.shoppingapp.model.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CategoryDetail {
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("subCategoryList")
    @Expose
    private List<SubCategoryList> subCategoryList = null;

    public CategoryDetail(Integer num, String str, String str2, String str3, List<SubCategoryList> list) {
        this.level = num;
        this.categoryId = str;
        this.categoryName = str2;
        this.categoryImage = str3;
        this.subCategoryList = list;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer num) {
        this.level = num;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
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

    public List<SubCategoryList> getSubCategoryList() {
        return this.subCategoryList;
    }

    public void setSubCategoryList(List<SubCategoryList> list) {
        this.subCategoryList = list;
    }
}
