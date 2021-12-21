package com.innomalist.taxi.shoppingapp.model.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProxyPayCartDetail {
    @SerializedName("cartColorDetails")
    @Expose
    private List<Object> cartColorDetails = null;
    @SerializedName("cartCurrencyCode")
    @Expose
    private String cartCurrencyCode;
    @SerializedName("cartCurrencySymbol")
    @Expose
    private String cartCurrencySymbol;
    @SerializedName("cartDelivery")
    @Expose
    private String cartDelivery;
    @SerializedName("cartDescription")
    @Expose
    private String cartDescription;
    @SerializedName("cartEntityId")
    @Expose
    private String cartEntityId;
    @SerializedName("cartId")
    @Expose
    private Integer cartId;
    @SerializedName("cartImage")
    @Expose
    private String cartImage;
    @SerializedName("cartMerchantId")
    @Expose
    private String cartMerchantId;
    @SerializedName("cartOrderDate")
    @Expose
    private String cartOrderDate;
    @SerializedName("cartPaytype")
    @Expose
    private String cartPaytype;
    @SerializedName("cartPrice")
    @Expose
    private String cartPrice;
    @SerializedName("cartProductId")
    @Expose
    private Integer cartProductId;
    @SerializedName("cartQuantity")
    @Expose
    private Integer cartQuantity;
    @SerializedName("cartReferenceId")
    @Expose
    private String cartReferenceId;
    @SerializedName("cartShipping")
    @Expose
    private String cartShipping;
    @SerializedName("cartSizeDetails")
    @Expose
    private List<Object> cartSizeDetails = null;
    @SerializedName("cartTax")
    @Expose
    private String cartTax;
    @SerializedName("cartTitle")
    @Expose
    private String cartTitle;
    @SerializedName("cartTotal")
    @Expose
    private String cartTotal;
    @SerializedName("cartTransactionId")
    @Expose
    private String cartTransactionId;
    @SerializedName("cartUserid")
    @Expose
    private Integer cartUserid;

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

    public String getCartTransactionId() {
        return this.cartTransactionId;
    }

    public void setCartTransactionId(String str) {
        this.cartTransactionId = str;
    }

    public String getCartEntityId() {
        return this.cartEntityId;
    }

    public void setCartEntityId(String str) {
        this.cartEntityId = str;
    }

    public String getCartReferenceId() {
        return this.cartReferenceId;
    }

    public void setCartReferenceId(String str) {
        this.cartReferenceId = str;
    }

    public String getCartTitle() {
        return this.cartTitle;
    }

    public void setCartTitle(String str) {
        this.cartTitle = str;
    }

    public String getCartDescription() {
        return this.cartDescription;
    }

    public void setCartDescription(String str) {
        this.cartDescription = str;
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

    public String getCartTax() {
        return this.cartTax;
    }

    public void setCartTax(String str) {
        this.cartTax = str;
    }

    public String getCartShipping() {
        return this.cartShipping;
    }

    public void setCartShipping(String str) {
        this.cartShipping = str;
    }

    public String getCartDelivery() {
        return this.cartDelivery;
    }

    public void setCartDelivery(String str) {
        this.cartDelivery = str;
    }

    public String getCartMerchantId() {
        return this.cartMerchantId;
    }

    public void setCartMerchantId(String str) {
        this.cartMerchantId = str;
    }

    public String getCartTotal() {
        return this.cartTotal;
    }

    public void setCartTotal(String str) {
        this.cartTotal = str;
    }

    public String getCartOrderDate() {
        return this.cartOrderDate;
    }

    public void setCartOrderDate(String str) {
        this.cartOrderDate = str;
    }

    public String getCartPaytype() {
        return this.cartPaytype;
    }

    public void setCartPaytype(String str) {
        this.cartPaytype = str;
    }

    public Integer getCartUserid() {
        return this.cartUserid;
    }

    public void setCartUserid(Integer num) {
        this.cartUserid = num;
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
