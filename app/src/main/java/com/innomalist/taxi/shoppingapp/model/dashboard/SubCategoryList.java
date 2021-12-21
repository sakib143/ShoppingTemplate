package com.innomalist.taxi.shoppingapp.model.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategoryList {
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
}
