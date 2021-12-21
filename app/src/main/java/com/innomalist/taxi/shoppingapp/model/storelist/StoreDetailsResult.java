package com.innomalist.taxi.shoppingapp.model.storelist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class StoreDetailsResult {
    @SerializedName("branchList")
    @Expose
    private ArrayList<Object> branchList = null;
    @SerializedName("dealListByShop")
    @Expose
    private ArrayList<DealListByShop> dealListByShop = null;
    @SerializedName("moreReviewStatus")
    @Expose
    private boolean moreReviewStatus;
    @SerializedName("productListByShop")
    @Expose
    private ArrayList<ProductListByShop> productListByShop = null;
    @SerializedName("storeDetails")
    @Expose
    private ArrayList<StoreDetail> storeDetails = null;
    @SerializedName("storeReview")
    @Expose
    private ArrayList<StoreReview> storeReview = null;

    public boolean isMoreReviewStatus() {
        return this.moreReviewStatus;
    }

    public void setMoreReviewStatus(boolean z) {
        this.moreReviewStatus = z;
    }

    public ArrayList<StoreDetail> getStoreDetails() {
        return this.storeDetails;
    }

    public void setStoreDetails(ArrayList<StoreDetail> arrayList) {
        this.storeDetails = arrayList;
    }

    public ArrayList<ProductListByShop> getProductListByShop() {
        return this.productListByShop;
    }

    public void setProductListByShop(ArrayList<ProductListByShop> arrayList) {
        this.productListByShop = arrayList;
    }

    public ArrayList<DealListByShop> getDealListByShop() {
        return this.dealListByShop;
    }

    public void setDealListByShop(ArrayList<DealListByShop> arrayList) {
        this.dealListByShop = arrayList;
    }

    public ArrayList<Object> getBranchList() {
        return this.branchList;
    }

    public void setBranchList(ArrayList<Object> arrayList) {
        this.branchList = arrayList;
    }

    public ArrayList<StoreReview> getStoreReview() {
        return this.storeReview;
    }

    public void setStoreReview(ArrayList<StoreReview> arrayList) {
        this.storeReview = arrayList;
    }
}
