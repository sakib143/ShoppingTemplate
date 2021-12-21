package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AddedCartResult {
    @SerializedName("cartCount")
    @Expose
    private Integer cartCount;
    @SerializedName("cartDetails")
    @Expose
    private List<CartDetail> cartDetails = null;

    public Integer getCartCount() {
        return this.cartCount;
    }

    public void setCartCount(Integer num) {
        this.cartCount = num;
    }

    public List<CartDetail> getCartDetails() {
        return this.cartDetails;
    }

    public void setCartDetails(List<CartDetail> list) {
        this.cartDetails = list;
    }
}
