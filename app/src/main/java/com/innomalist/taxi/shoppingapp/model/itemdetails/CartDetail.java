package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CartDetail {
    @SerializedName("cartColorDetails")
    @Expose
    private List<Object> cartColorDetails = null;
    @SerializedName("cartCurrencyCode")
    @Expose
    private String cartCurrencyCode;
    @SerializedName("cartCurrencySymbol")
    @Expose
    private String cartCurrencySymbol;
    @SerializedName("cartId")
    @Expose
    private Integer cartId;
    @SerializedName("cartImage")
    @Expose
    private String cartImage;
    @SerializedName("cartPrice")
    @Expose
    private String cartPrice;
    @SerializedName("cartProductId")
    @Expose
    private Integer cartProductId;
    @SerializedName("cartQuantity")
    @Expose
    private Integer cartQuantity;
    @SerializedName("cartShippingPrice")
    @Expose
    private String cartShippingPrice;
    @SerializedName("cartSizeDetails")
    @Expose
    private List<Object> cartSizeDetails = null;
    @SerializedName("cartTaxPrice")
    @Expose
    private String cartTaxPrice;
    @SerializedName("cartTitle")
    @Expose
    private String cartTitle;
    @SerializedName("cartTotal")
    @Expose
    private String cartTotal;
    @SerializedName("cartUserId")
    @Expose
    private Integer cartUserId;
    @SerializedName("productAvailableQty")
    @Expose
    private Integer productAvailableQty;
    @SerializedName("productPurchaseQty")
    @Expose
    private Integer productPurchaseQty;
    @SerializedName("productQuantity")
    @Expose
    private Integer productQuantity;

    public Integer getCartId() {
        return this.cartId;
    }

    public void setCartId(Integer num) {
        this.cartId = num;
    }

    public Integer getCartProductId() {
        return this.cartProductId;
    }

    public void setCartProductId(Integer num) {
        this.cartProductId = num;
    }

    public Integer getCartUserId() {
        return this.cartUserId;
    }

    public void setCartUserId(Integer num) {
        this.cartUserId = num;
    }

    public String getCartTitle() {
        return this.cartTitle;
    }

    public void setCartTitle(String str) {
        this.cartTitle = str;
    }

    public Integer getCartQuantity() {
        return this.cartQuantity;
    }

    public void setCartQuantity(Integer num) {
        this.cartQuantity = num;
    }

    public String getCartImage() {
        return this.cartImage;
    }

    public void setCartImage(String str) {
        this.cartImage = str;
    }

    public Integer getProductPurchaseQty() {
        return this.productPurchaseQty;
    }

    public void setProductPurchaseQty(Integer num) {
        this.productPurchaseQty = num;
    }

    public Integer getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(Integer num) {
        this.productQuantity = num;
    }

    public Integer getProductAvailableQty() {
        return this.productAvailableQty;
    }

    public void setProductAvailableQty(Integer num) {
        this.productAvailableQty = num;
    }

    public String getCartCurrencyCode() {
        return this.cartCurrencyCode;
    }

    public void setCartCurrencyCode(String str) {
        this.cartCurrencyCode = str;
    }

    public String getCartCurrencySymbol() {
        return this.cartCurrencySymbol;
    }

    public void setCartCurrencySymbol(String str) {
        this.cartCurrencySymbol = str;
    }

    public String getCartPrice() {
        return this.cartPrice;
    }

    public void setCartPrice(String str) {
        this.cartPrice = str;
    }

    public String getCartShippingPrice() {
        return this.cartShippingPrice;
    }

    public void setCartShippingPrice(String str) {
        this.cartShippingPrice = str;
    }

    public String getCartTaxPrice() {
        return this.cartTaxPrice;
    }

    public void setCartTaxPrice(String str) {
        this.cartTaxPrice = str;
    }

    public String getCartTotal() {
        return this.cartTotal;
    }

    public void setCartTotal(String str) {
        this.cartTotal = str;
    }

    public List<Object> getCartSizeDetails() {
        return this.cartSizeDetails;
    }

    public void setCartSizeDetails(List<Object> list) {
        this.cartSizeDetails = list;
    }

    public List<Object> getCartColorDetails() {
        return this.cartColorDetails;
    }

    public void setCartColorDetails(List<Object> list) {
        this.cartColorDetails = list;
    }
}
