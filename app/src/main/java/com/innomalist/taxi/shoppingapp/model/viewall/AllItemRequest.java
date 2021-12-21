package com.innomalist.taxi.shoppingapp.model.viewall;

public class AllItemRequest {
    private String availability;
    private String cusId;
    private String discount;
    private String lang;
    private String mainCategoryId;
    private String pageNo;
    private String priceMax;
    private String priceMin;
    private String secCategoryId;
    private String sortOrderBy;
    private String subCategoryId;
    private String subSecCategoryId;
    private String title;

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String str) {
        this.discount = str;
    }

    public String getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(String str) {
        this.pageNo = str;
    }

    public String getAvailability() {
        return this.availability;
    }

    public void setAvailability(String str) {
        this.availability = str;
    }

    public String getPriceMin() {
        return this.priceMin;
    }

    public void setPriceMin(String str) {
        this.priceMin = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getMainCategoryId() {
        return this.mainCategoryId;
    }

    public void setMainCategoryId(String str) {
        this.mainCategoryId = str;
    }

    public String getSortOrderBy() {
        return this.sortOrderBy;
    }

    public void setSortOrderBy(String str) {
        this.sortOrderBy = str;
    }

    public String getCusId() {
        return this.cusId;
    }

    public void setCusId(String str) {
        this.cusId = str;
    }

    public String getSubCategoryId() {
        return this.subCategoryId;
    }

    public void setSubCategoryId(String str) {
        this.subCategoryId = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public String getPriceMax() {
        return this.priceMax;
    }

    public void setPriceMax(String str) {
        this.priceMax = str;
    }

    public String getSecCategoryId() {
        return this.secCategoryId;
    }

    public AllItemRequest() {
    }

    public void setSecCategoryId(String str) {
        this.secCategoryId = str;
    }

    public String getSubSecCategoryId() {
        return this.subSecCategoryId;
    }

    public void setSubSecCategoryId(String str) {
        this.subSecCategoryId = str;
    }

    public AllItemRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.discount = str;
        this.pageNo = str2;
        this.availability = str3;
        this.priceMin = str4;
        this.title = str5;
        this.mainCategoryId = str6;
        this.sortOrderBy = str7;
        this.cusId = str8;
        this.subCategoryId = str9;
        this.lang = str10;
        this.priceMax = str11;
        this.secCategoryId = str12;
        this.subSecCategoryId = str13;
    }
}
