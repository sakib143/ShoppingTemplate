package com.kiandashopping.kiandashopping.p011ui.itemdetails.mvp;

import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.itemdetails.AddDealToCartRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddReviewRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddToCartRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddedCartResult;
import com.kiandashopping.kiandashopping.model.itemdetails.DealDetailsRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult;
import com.kiandashopping.kiandashopping.model.itemdetails.RequestAddWishList;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.mvp.ProductDetailsContractor */
public interface ProductDetailsContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.mvp.ProductDetailsContractor$Model */
    public interface Model {
        Disposable requestAddReview(AddReviewRequest addReviewRequest);

        Disposable requestAddToCart(AddToCartRequest addToCartRequest);

        Disposable requestAddWishList(RequestAddWishList requestAddWishList);

        Disposable requestDealAddReview(AddReviewRequest addReviewRequest);

        Disposable requestDealAddToCart(AddDealToCartRequest addDealToCartRequest);

        Disposable requestDealDetails(DealDetailsRequest dealDetailsRequest);

        Disposable requestProductDetails(ProductDetailsRequest productDetailsRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.mvp.ProductDetailsContractor$Presenter */
    public interface Presenter {
        void onAddCartResult(BaseResponse<AddedCartResult> baseResponse);

        void onAddDealToCart(int i, int i2, int i3);

        void onAddReview(int i, float f, String str, String str2, boolean z);

        void onAddToCart(int i, ProductDetailsResult productDetailsResult, int i2, boolean z, int i3, boolean z2, int i4, int i5);

        void onAddWish(int i);

        void onRequestDealDetails(int i);

        void onRequestProductDetails(int i);

        void onResult(ProductDetailsResult productDetailsResult);

        void onResultError(String str);

        void onWishListResult(BaseResponse baseResponse);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.mvp.ProductDetailsContractor$View */
    public interface View extends ViewInterface {
        void showAddCartResult(BaseResponse<AddedCartResult> baseResponse);

        void showBuyNowResult(BaseResponse<AddedCartResult> baseResponse);

        void showResult(ProductDetailsResult productDetailsResult);

        void showResultError(String str);

        void showWishListResult(BaseResponse baseResponse);
    }
}
