package com.innomalist.taxi.shoppingapp.model.mycart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UpcateCartResult {
    @SerializedName("cart_count")
    @Expose
    private Integer cartCount;
    @SerializedName("cart_details")
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
