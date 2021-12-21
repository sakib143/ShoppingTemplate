package com.innomalist.taxi.shoppingapp.data.rest;

import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.accountdetail.AccountDetailResult;
import com.kiandashopping.kiandashopping.model.accountdetail.ContactUsResult;
import com.kiandashopping.kiandashopping.model.accountdetail.RequestSubmitForm;
import com.kiandashopping.kiandashopping.model.allreviews.AllReviewRequest;
import com.kiandashopping.kiandashopping.model.allreviews.AllReviewResult;
import com.kiandashopping.kiandashopping.model.bycategory.ByCategoryRequest;
import com.kiandashopping.kiandashopping.model.bycategory.ByCategoryResult;
import com.kiandashopping.kiandashopping.model.category.CategoriesList;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.cms.RequestAboutUs;
import com.kiandashopping.kiandashopping.model.cms.ResultAboutUs;
import com.kiandashopping.kiandashopping.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.model.dashboard.ChangePasswordRequest;
import com.kiandashopping.kiandashopping.model.dashboard.DashboardResponse;
import com.kiandashopping.kiandashopping.model.deallist.RequestDealList;
import com.kiandashopping.kiandashopping.model.deallist.ResultDealList;
import com.kiandashopping.kiandashopping.model.forgotpassword.ForgotPasswordRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddDealToCartRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddReviewRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddToCartRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddedCartResult;
import com.kiandashopping.kiandashopping.model.itemdetails.DealDetailsRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult;
import com.kiandashopping.kiandashopping.model.itemdetails.RequestAddWishList;
import com.kiandashopping.kiandashopping.model.login.LoginRequest;
import com.kiandashopping.kiandashopping.model.login.LoginWithFBRequest;
import com.kiandashopping.kiandashopping.model.logout.LogoutRequest;
import com.kiandashopping.kiandashopping.model.mycart.DeleteCartRequest;
import com.kiandashopping.kiandashopping.model.mycart.MyCartResult;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartDealRequest;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartProductRequest;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartRequest;
import com.kiandashopping.kiandashopping.model.myorder.OrderHistoryResult;
import com.kiandashopping.kiandashopping.model.myorder.RequestOrderTracking;
import com.kiandashopping.kiandashopping.model.nearme.NearByRequest;
import com.kiandashopping.kiandashopping.model.nearme.NearByResult;
import com.kiandashopping.kiandashopping.model.payment.PaymentResult;
import com.kiandashopping.kiandashopping.model.payment.ProxyPayResult;
import com.kiandashopping.kiandashopping.model.payment.RequestCOD;
import com.kiandashopping.kiandashopping.model.payment.RequestPayPal;
import com.kiandashopping.kiandashopping.model.payment.RequestProxyPay;
import com.kiandashopping.kiandashopping.model.payment.ResultPaymentDetails;
import com.kiandashopping.kiandashopping.model.register.RegisterResult;
import com.kiandashopping.kiandashopping.model.register.RequestRegister;
import com.kiandashopping.kiandashopping.model.storelist.RequestAddStoreReview;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailRequest;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
import com.kiandashopping.kiandashopping.model.storelist.StoreResult;
import com.kiandashopping.kiandashopping.model.tracking.DHLOrderDetails;
import com.kiandashopping.kiandashopping.model.viewall.AllItemRequest;
import com.kiandashopping.kiandashopping.model.viewall.ProductList;
import com.kiandashopping.kiandashopping.model.wishlist.MyWishListResult;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
//import p013io.reactivex.Single;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface ApiInterface {
    @POST("forgotPassword")
    Single<BaseResponse> forgotPassword(@Body ForgotPasswordRequest forgotPasswordRequest);

    @POST("userLogin")
    Single<BaseResponse<RegisterResult>> login(@Body LoginRequest loginRequest);

    @POST("facebookLogin")
    Single<BaseResponse<RegisterResult>> login(@Body LoginWithFBRequest loginWithFBRequest);

    @POST("registration")
    Single<BaseResponse<RegisterResult>> register(@Body RequestRegister requestRegister);

    @POST("getCmsPageContent")
    Single<BaseResponse<ResultAboutUs>> requestAboutUs(@Body RequestAboutUs requestAboutUs);

    @POST("myAccount")
    Single<BaseResponse<AccountDetailResult>> requestAccountDetails(@Body LangRequest langRequest);

    @POST("productWriteReview")
    Single<BaseResponse> requestAddReview(@Body AddReviewRequest addReviewRequest);

    @POST("storeWriteReview")
    Single<BaseResponse> requestAddStoreReview(@Body RequestAddStoreReview requestAddStoreReview);

    @POST("addToCart")
    Single<BaseResponse<AddedCartResult>> requestAddToCart(@Body AddToCartRequest addToCartRequest);

    @POST("addToWishlist")
    Single<BaseResponse> requestAddWishList(@Body RequestAddWishList requestAddWishList);

    @POST("dealsList")
    Single<BaseResponse<List<ResultDealList>>> requestAllDeals(@Body RequestDealList requestDealList);

    @POST("productSearchByFilter")
    Single<BaseResponse<List<ProductList>>> requestAllItems(@Body AllItemRequest allItemRequest);

    @POST("productListByCategory")
    Single<BaseResponse<ByCategoryResult>> requestByCategory(@Body ByCategoryRequest byCategoryRequest);

    @POST("productCodOrder")
    Single<BaseResponse<PaymentResult>> requestCOD(@Body RequestCOD requestCOD);

    @POST("cartList")
    Single<BaseResponse<MyCartResult>> requestCart(@Body LangRequest langRequest);

    @POST("categoryList")
    Single<BaseResponse<List<CategoriesList>>> requestCategory(@Body LangRequest langRequest);

    @POST("resetPassword")
    Single<BaseResponse> requestChangePassword(@Body ChangePasswordRequest changePasswordRequest);

    @POST("getCheckOutDetails")
    Single<BaseResponse<ResultPaymentDetails>> requestCheckOutDetails(@Body LangRequest langRequest);

    @POST("getContactDetails")
    Single<BaseResponse<ContactUsResult>> requestContactUs(@Body LangRequest langRequest);

    @POST("countryCityList")
    Single<BaseResponse<List<CountryDetail>>> requestCountry(@Body LangRequest langRequest);

    @POST("DHLOrderDetail")
    Single<BaseResponse<DHLOrderDetails>> requestDHLOrderDetail(@Body RequestOrderTracking requestOrderTracking);

    @POST("homePage")
    Single<BaseResponse<DashboardResponse>> requestDashboard(@Body LangRequest langRequest);

    @POST("dealWriteReview")
    Single<BaseResponse> requestDealAddReview(@Body AddReviewRequest addReviewRequest);

    @POST("addToDealcart")
    Single<BaseResponse<AddedCartResult>> requestDealAddToCart(@Body AddDealToCartRequest addDealToCartRequest);

    @POST("allDealReviews")
    Single<BaseResponse<List<AllReviewResult>>> requestDealAllReview(@Body AllReviewRequest allReviewRequest);

    @POST("dealDetail")
    Single<BaseResponse<ProductDetailsResult>> requestDealDetails(@Body DealDetailsRequest dealDetailsRequest);

    @POST("removeProductcart")
    Single<BaseResponse<MyCartResult>> requestDeleteCart(@Body DeleteCartRequest deleteCartRequest);

    @POST("submitContactForm")
    Single<BaseResponse> requestFormSubmit(@Body RequestSubmitForm requestSubmitForm);

    @POST("logout")
    Single<BaseResponse> requestLogout(@Body LogoutRequest logoutRequest);

    @POST("myOrders")
    Single<BaseResponse<OrderHistoryResult>> requestMyOrders(@Body LangRequest langRequest);

    @POST("nearByShopList")
    Single<BaseResponse<List<NearByResult>>> requestNearBy(@Body NearByRequest nearByRequest);

    @POST("orderDetail")
    Single<BaseResponse<OrderHistoryResult>> requestOrderDetail(@Body RequestOrderTracking requestOrderTracking);

    @POST("productPaypalOrder")
    Single<BaseResponse<PaymentResult>> requestPayPal(@Body RequestPayPal requestPayPal);

    @POST("allProductReview")
    Single<BaseResponse<List<AllReviewResult>>> requestProductAllReview(@Body AllReviewRequest allReviewRequest);

    @POST("productDetailPage")
    Single<BaseResponse<ProductDetailsResult>> requestProductDetails(@Body ProductDetailsRequest productDetailsRequest);

    @POST("proxypayOrder")
    Single<BaseResponse<ProxyPayResult>> requestProxyPay(@Body RequestProxyPay requestProxyPay);

    @POST("")
    @Headers({"Accept:application/vnd.proxypay.v2+json", "Authorization:Token dv1r4mrothv2d6uttl3oerqc7odd07b8"})
    Single<Response<ResponseBody>> requestReferenceIds(@Url String str, @Body RequestBody requestBody);

    @PUT("")
    @Headers({"Accept:application/vnd.proxypay.v2+json", "Authorization:Token dv1r4mrothv2d6uttl3oerqc7odd07b8"})
    Single<Response<ResponseBody>> requestReferences(@Url String str, @Body RequestBody requestBody);

    @POST("register_with_otp")
    Single<BaseResponse<RegisterResult>> requestRegisterWithOTP(@Body RequestRegister requestRegister);

    @POST("removeDealcart")
    Single<BaseResponse<MyCartResult>> requestRemoveDealCart(@Body DeleteCartRequest deleteCartRequest);

    @POST("removeProductcart")
    Single<BaseResponse<MyCartResult>> requestRemoveProductCart(@Body DeleteCartRequest deleteCartRequest);

    @POST("shopList")
    Single<BaseResponse<List<StoreResult>>> requestShopList(@Body LangRequest langRequest);

    @POST("allStoreReview")
    Single<BaseResponse<List<AllReviewResult>>> requestStoreAllReview(@Body AllReviewRequest allReviewRequest);

    @POST("shopDetailById")
    Single<BaseResponse<StoreDetailsResult>> requestStoreDetails(@Body StoreDetailRequest storeDetailRequest);

    @POST("updateProductCart")
    Single<BaseResponse<MyCartResult>> requestUpdateCart(@Body UpdateCartRequest updateCartRequest);

    @POST("updateDealCart")
    Single<BaseResponse<MyCartResult>> requestUpdateDealCart(@Body UpdateCartDealRequest updateCartDealRequest);

    @POST("updateProductCart")
    Single<BaseResponse<MyCartResult>> requestUpdateProdtCart(@Body UpdateCartProductRequest updateCartProductRequest);

    @POST("myWishlist")
    Single<BaseResponse<List<MyWishListResult>>> requestWishList(@Body LangRequest langRequest);

    @POST("updateMyAccount")
    @Multipart
    Single<BaseResponse<AccountDetailResult>> updateAccount(@Part("cusId") RequestBody requestBody, @Part("cusName") RequestBody requestBody2, @Part("cusEmail") RequestBody requestBody3, @Part("cusPhone") RequestBody requestBody4, @Part("cusAddress1") RequestBody requestBody5, @Part("cusAddress2") RequestBody requestBody6, @Part("countryId") RequestBody requestBody7, @Part("cityId") RequestBody requestBody8, @Part("shipName") RequestBody requestBody9, @Part("shipEmail") RequestBody requestBody10, @Part("shipPhone") RequestBody requestBody11, @Part("shipAddress1") RequestBody requestBody12, @Part("shipAddress2") RequestBody requestBody13, @Part("shipCountryId") RequestBody requestBody14, @Part("shipCityId") RequestBody requestBody15, @Part("shipState") RequestBody requestBody16, @Part("shipPostalcode") RequestBody requestBody17, @Part("lang") RequestBody requestBody18, @Part MultipartBody.Part part);
}
