package com.innomalist.taxi.shoppingapp.model.itemdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailsResult {
    @SerializedName("avgReview")
    @Expose
    private Double avgReview;
    @SerializedName("cancelPolicy")
    @Expose
    private CancelPolicy cancelPolicy;
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("currencySymbol")
    @Expose
    private String currencySymbol;
    @SerializedName("dealEndDate")
    @Expose
    private String dealEndDate;
    @SerializedName("dealStartDate")
    @Expose
    private String dealStartDate;
    @SerializedName("imagePath")
    @Expose
    private String imagePath;
    @SerializedName("isWishlist")
    @Expose
    private Boolean isWishlist;
    @SerializedName("productBlockUnblockStatus")
    @Expose
    private Integer productBlockUnblockStatus;
    @SerializedName("productCategoryId")
    @Expose
    private Integer productCategoryId;
    @SerializedName("productCategoryName")
    @Expose
    private String productCategoryName;
    @SerializedName("productColorDetails")
    @Expose
    private List<ProductColorDetail> productColorDetails = null;
    @SerializedName("productCreatedDate")
    @Expose
    private String productCreatedDate;
    @SerializedName("productCurrencyCode")
    @Expose
    private String productCurrencyCode;
    @SerializedName("productCurrencySymbol")
    @Expose
    private String productCurrencySymbol;
    @SerializedName("productDelivery")
    @Expose
    private Integer productDelivery;
    @SerializedName("productDescription")
    @Expose
    private String productDescription;
    @SerializedName("productDiscountPercentage")
    @Expose
    private Integer productDiscountPercentage;
    @SerializedName("productDiscountPrice")
    @Expose
    private String productDiscountPrice;
    @SerializedName("productFbSharePath")
    @Expose
    private String productFbSharePath;
    @SerializedName("productGooglePlusSharePath")
    @Expose
    private String productGooglePlusSharePath;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("productImage")
    @Expose
    private List<ProductImage> productImage = null;
    @SerializedName("productImageCount")
    @Expose
    private Integer productImageCount;
    @SerializedName("productIncludingTax")
    @Expose
    private String productIncludingTax;
    @SerializedName("productLinkedInSharePath")
    @Expose
    private String productLinkedInSharePath;
    @SerializedName("productMainCategoryId")
    @Expose
    private Integer productMainCategoryId;
    @SerializedName("productMainCategoryName")
    @Expose
    private String productMainCategoryName;
    @SerializedName("productMerchantId")
    @Expose
    private Integer productMerchantId;
    @SerializedName("productMetaDesc")
    @Expose
    private String productMetaDesc;
    @SerializedName("productMetaKeyword")
    @Expose
    private String productMetaKeyword;
    @SerializedName("productOriginalPrice")
    @Expose
    private String productOriginalPrice;
    @SerializedName("productPurchaseQty")
    @Expose
    private Integer productPurchaseQty;
    @SerializedName("productQuantity")
    @Expose
    private Integer productQuantity;
    @SerializedName("productReview")
    @Expose
    private List<ProductReview> productReview = null;
    @SerializedName("productSecondSubCategoryId")
    @Expose
    private Integer productSecondSubCategoryId;
    @SerializedName("productSecondSubCategoryName")
    @Expose
    private String productSecondSubCategoryName;
    @SerializedName("productShipAmt")
    @Expose
    private String productShipAmt;
    @SerializedName("productShopId")
    @Expose
    private Integer productShopId;
    @SerializedName("productShopName")
    @Expose
    private String productShopName;
    @SerializedName("productSizeDetails")
    @Expose
    private List<ProductSizeDetail> productSizeDetails = null;
    @SerializedName("productSoldStatus")
    @Expose
    private Boolean productSoldStatus;
    @SerializedName("productSpecificationDetails")
    @Expose
    private List<ProductSpecificationDetail> productSpecificationDetails = null;
    @SerializedName("productStatus")
    @Expose
    private String productStatus;
    @SerializedName("productSubCategoryId")
    @Expose
    private Integer productSubCategoryId;
    @SerializedName("productSubCategoryName")
    @Expose
    private String productSubCategoryName;
    @SerializedName("productTitle")
    @Expose
    private String productTitle;
    @SerializedName("productTwitterSharePath")
    @Expose
    private String productTwitterSharePath;
    @SerializedName("relatedProducts")
    @Expose
    private List<RelatedProduct> relatedProducts = null;
    @SerializedName("replacePolicy")
    @Expose
    private ReplacePolicy replacePolicy;
    @SerializedName("returnPolicy")
    @Expose
    private ReturnPolicy returnPolicy;
    @SerializedName("storeDetails")
    @Expose
    private List<StoreDetail> storeDetails = null;

    public String getProductShopName() {
        return this.productShopName;
    }

    public void setProductShopName(String str) {
        this.productShopName = str;
    }

    public String getDealStartDate() {
        return this.dealStartDate;
    }

    public void setDealStartDate(String str) {
        this.dealStartDate = str;
    }

    public String getDealEndDate() {
        return this.dealEndDate;
    }

    public void setDealEndDate(String str) {
        this.dealEndDate = str;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer num) {
        this.productId = num;
    }

    public String getProductTitle() {
        return this.productTitle;
    }

    public void setProductTitle(String str) {
        this.productTitle = str;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String str) {
        this.productDescription = str;
    }

    public String getProductDiscountPrice() {
        return this.productDiscountPrice;
    }

    public void setProductDiscountPrice(String str) {
        this.productDiscountPrice = str;
    }

    public Integer getProductDiscountPercentage() {
        return this.productDiscountPercentage;
    }

    public void setProductDiscountPercentage(Integer num) {
        this.productDiscountPercentage = num;
    }

    public String getProductOriginalPrice() {
        return this.productOriginalPrice;
    }

    public void setProductOriginalPrice(String str) {
        this.productOriginalPrice = str;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public Integer getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(Integer num) {
        this.productQuantity = num;
    }

    public Integer getProductPurchaseQty() {
        return this.productPurchaseQty;
    }

    public void setProductPurchaseQty(Integer num) {
        this.productPurchaseQty = num;
    }

    public String getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(String str) {
        this.productStatus = str;
    }

    public String getProductCurrencyCode() {
        return this.productCurrencyCode;
    }

    public void setProductCurrencyCode(String str) {
        this.productCurrencyCode = str;
    }

    public String getProductCurrencySymbol() {
        return this.productCurrencySymbol;
    }

    public void setProductCurrencySymbol(String str) {
        this.productCurrencySymbol = str;
    }

    public Integer getProductMerchantId() {
        return this.productMerchantId;
    }

    public void setProductMerchantId(Integer num) {
        this.productMerchantId = num;
    }

    public Integer getProductShopId() {
        return this.productShopId;
    }

    public void setProductShopId(Integer num) {
        this.productShopId = num;
    }

    public String getProductCategoryName() {
        return this.productCategoryName;
    }

    public void setProductCategoryName(String str) {
        this.productCategoryName = str;
    }

    public Integer getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(Integer num) {
        this.productCategoryId = num;
    }

    public String getProductMainCategoryName() {
        return this.productMainCategoryName;
    }

    public void setProductMainCategoryName(String str) {
        this.productMainCategoryName = str;
    }

    public Integer getProductMainCategoryId() {
        return this.productMainCategoryId;
    }

    public void setProductMainCategoryId(Integer num) {
        this.productMainCategoryId = num;
    }

    public String getProductSubCategoryName() {
        return this.productSubCategoryName;
    }

    public void setProductSubCategoryName(String str) {
        this.productSubCategoryName = str;
    }

    public Integer getProductSubCategoryId() {
        return this.productSubCategoryId;
    }

    public void setProductSubCategoryId(Integer num) {
        this.productSubCategoryId = num;
    }

    public String getProductSecondSubCategoryName() {
        return this.productSecondSubCategoryName;
    }

    public void setProductSecondSubCategoryName(String str) {
        this.productSecondSubCategoryName = str;
    }

    public Integer getProductSecondSubCategoryId() {
        return this.productSecondSubCategoryId;
    }

    public void setProductSecondSubCategoryId(Integer num) {
        this.productSecondSubCategoryId = num;
    }

    public String getProductMetaKeyword() {
        return this.productMetaKeyword;
    }

    public void setProductMetaKeyword(String str) {
        this.productMetaKeyword = str;
    }

    public String getProductMetaDesc() {
        return this.productMetaDesc;
    }

    public void setProductMetaDesc(String str) {
        this.productMetaDesc = str;
    }

    public Integer getProductImageCount() {
        return this.productImageCount;
    }

    public void setProductImageCount(Integer num) {
        this.productImageCount = num;
    }

    public Integer getProductDelivery() {
        return this.productDelivery;
    }

    public void setProductDelivery(Integer num) {
        this.productDelivery = num;
    }

    public Integer getProductBlockUnblockStatus() {
        return this.productBlockUnblockStatus;
    }

    public void setProductBlockUnblockStatus(Integer num) {
        this.productBlockUnblockStatus = num;
    }

    public Boolean getProductSoldStatus() {
        Boolean bool = this.productSoldStatus;
        return Boolean.valueOf(bool == null ? true : bool.booleanValue());
    }

    public void setProductSoldStatus(Boolean bool) {
        this.productSoldStatus = bool;
    }

    public String getProductIncludingTax() {
        return this.productIncludingTax;
    }

    public void setProductIncludingTax(String str) {
        this.productIncludingTax = str;
    }

    public String getProductShipAmt() {
        return this.productShipAmt;
    }

    public void setProductShipAmt(String str) {
        this.productShipAmt = str;
    }

    public String getProductCreatedDate() {
        return this.productCreatedDate;
    }

    public void setProductCreatedDate(String str) {
        this.productCreatedDate = str;
    }

    public Boolean getIsWishlist() {
        return this.isWishlist;
    }

    public void setIsWishlist(Boolean bool) {
        this.isWishlist = bool;
    }

    public List<ProductImage> getProductImage() {
        return this.productImage;
    }

    public void setProductImage(List<ProductImage> list) {
        this.productImage = list;
    }

    public List<ProductSizeDetail> getProductSizeDetails() {
        List<ProductSizeDetail> list = this.productSizeDetails;
        return list == null ? new ArrayList() : list;
    }

    public void setProductSizeDetails(List<ProductSizeDetail> list) {
        this.productSizeDetails = list;
    }

    public List<ProductColorDetail> getProductColorDetails() {
        List<ProductColorDetail> list = this.productColorDetails;
        return list == null ? new ArrayList() : list;
    }

    public void setProductColorDetails(List<ProductColorDetail> list) {
        this.productColorDetails = list;
    }

    public List<ProductSpecificationDetail> getProductSpecificationDetails() {
        List<ProductSpecificationDetail> list = this.productSpecificationDetails;
        return list == null ? new ArrayList() : list;
    }

    public void setProductSpecificationDetails(List<ProductSpecificationDetail> list) {
        this.productSpecificationDetails = list;
    }

    public CancelPolicy getCancelPolicy() {
        CancelPolicy cancelPolicy2 = this.cancelPolicy;
        return cancelPolicy2 == null ? new CancelPolicy() : cancelPolicy2;
    }

    public void setCancelPolicy(CancelPolicy cancelPolicy2) {
        this.cancelPolicy = cancelPolicy2;
    }

    public ReturnPolicy getReturnPolicy() {
        ReturnPolicy returnPolicy2 = this.returnPolicy;
        return returnPolicy2 == null ? new ReturnPolicy() : returnPolicy2;
    }

    public void setReturnPolicy(ReturnPolicy returnPolicy2) {
        this.returnPolicy = returnPolicy2;
    }

    public ReplacePolicy getReplacePolicy() {
        ReplacePolicy replacePolicy2 = this.replacePolicy;
        return replacePolicy2 == null ? new ReplacePolicy() : replacePolicy2;
    }

    public void setReplacePolicy(ReplacePolicy replacePolicy2) {
        this.replacePolicy = replacePolicy2;
    }

    public List<StoreDetail> getStoreDetails() {
        return this.storeDetails;
    }

    public void setStoreDetails(List<StoreDetail> list) {
        this.storeDetails = list;
    }

    public List<ProductReview> getProductReview() {
        return this.productReview;
    }

    public void setProductReview(List<ProductReview> list) {
        this.productReview = list;
    }

    public Double getAvgReview() {
        return this.avgReview;
    }

    public void setAvgReview(Double d) {
        this.avgReview = d;
    }

    public List<RelatedProduct> getRelatedProducts() {
        return this.relatedProducts;
    }

    public void setRelatedProducts(List<RelatedProduct> list) {
        this.relatedProducts = list;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public String getProductFbSharePath() {
        return this.productFbSharePath;
    }

    public void setProductFbSharePath(String str) {
        this.productFbSharePath = str;
    }

    public String getProductTwitterSharePath() {
        return this.productTwitterSharePath;
    }

    public void setProductTwitterSharePath(String str) {
        this.productTwitterSharePath = str;
    }

    public String getProductGooglePlusSharePath() {
        return this.productGooglePlusSharePath;
    }

    public void setProductGooglePlusSharePath(String str) {
        this.productGooglePlusSharePath = str;
    }

    public String getProductLinkedInSharePath() {
        return this.productLinkedInSharePath;
    }

    public void setProductLinkedInSharePath(String str) {
        this.productLinkedInSharePath = str;
    }
}
