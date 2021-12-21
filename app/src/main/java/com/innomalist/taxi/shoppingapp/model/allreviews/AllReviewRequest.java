package com.innomalist.taxi.shoppingapp.model.allreviews;

public class AllReviewRequest {
    private String dealId;
    private String lang;
    private String pageNo;
    private String productId;
    private String storeId;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String str) {
        this.storeId = str;
    }

    public String getDealId() {
        return this.dealId;
    }

    public void setDealId(String str) {
        this.dealId = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public String getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(String str) {
        this.pageNo = str;
    }
}
