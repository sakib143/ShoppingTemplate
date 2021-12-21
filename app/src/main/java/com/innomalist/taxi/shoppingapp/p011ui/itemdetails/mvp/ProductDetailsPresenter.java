package com.kiandashopping.kiandashopping.p011ui.itemdetails.mvp;

import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.itemdetails.AddDealToCartRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddReviewRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddToCartRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.AddedCartResult;
import com.kiandashopping.kiandashopping.model.itemdetails.DealDetailsRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult;
import com.kiandashopping.kiandashopping.model.itemdetails.RequestAddWishList;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.mvp.ProductDetailsContractor;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.mvp.ProductDetailsPresenter */
public class ProductDetailsPresenter extends BasePresenter implements ProductDetailsContractor.Presenter {
    private Disposable disposable;
    private boolean isBuyNow = false;
    private ProductDetailsContractor.View mView;
    private ProductDetailsModel model;

    public ProductDetailsPresenter(ProductDetailsContractor.View view) {
        this.mView = view;
        this.model = new ProductDetailsModel(this);
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void onRequestProductDetails(int i) {
        this.mView.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.requestProductDetails(new ProductDetailsRequest(this.appRepository.getUserId(), i, this.appRepository.getLanguage()));
    }

    public void onRequestDealDetails(int i) {
        this.mView.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.requestDealDetails(new DealDetailsRequest(i, this.appRepository.getLanguage()));
    }

    public void onAddWish(int i) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.mView.showToast(ResourceUtils.getString(R.string.network_error));
            return;
        }
        this.mView.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.requestAddWishList(new RequestAddWishList(this.appRepository.getUserId(), i, this.appRepository.getLanguage()));
    }

    public void onAddReview(int i, float f, String str, String str2, boolean z) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.mView.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (f == 0.0f) {
            this.mView.showToast(ResourceUtils.getString(R.string.choose_rating));
        } else if (str.isEmpty()) {
            this.mView.showToast(ResourceUtils.getString(R.string.error_summary));
        } else if (str2.isEmpty()) {
            this.mView.showToast(ResourceUtils.getString(R.string.error_comments));
        } else {
            this.mView.showLoadingView();
            Disposable disposable2 = this.disposable;
            if (disposable2 != null && !disposable2.isDisposed()) {
                this.disposable.dispose();
            }
            if (z) {
                this.disposable = this.model.requestDealAddReview(new AddReviewRequest(this.appRepository.getUserId(), i, str, str2, ConversionUtils.parseInt(f), this.appRepository.getLanguage(), Boolean.valueOf(z)));
                return;
            }
            this.disposable = this.model.requestAddReview(new AddReviewRequest(this.appRepository.getUserId(), i, str, str2, ConversionUtils.parseInt(f), this.appRepository.getLanguage()));
        }
    }

    public void onAddToCart(int i, ProductDetailsResult productDetailsResult, int i2, boolean z, int i3, boolean z2, int i4, int i5) {
        boolean z3 = true;
        if (i5 != 1) {
            z3 = false;
        }
        this.isBuyNow = z3;
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.mView.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (!productDetailsResult.getProductSoldStatus().booleanValue()) {
            this.mView.showToast(ResourceUtils.getString(R.string.product_sold_out));
        } else if (i2 == 0 && z) {
            this.mView.showToast(ResourceUtils.getString(R.string.error_choose_color));
        } else if (i3 != 0 || !z2) {
            this.mView.showLoadingView();
            Disposable disposable2 = this.disposable;
            if (disposable2 != null && !disposable2.isDisposed()) {
                this.disposable.dispose();
            }
            this.disposable = this.model.requestAddToCart(new AddToCartRequest(i, i2, i3, i4, this.appRepository.getUserId(), this.appRepository.getLanguage(), i5));
        } else {
            this.mView.showToast(ResourceUtils.getString(R.string.error_choose_size));
        }
    }

    public void onAddDealToCart(int i, int i2, int i3) {
        boolean z = true;
        if (i3 != 1) {
            z = false;
        }
        this.isBuyNow = z;
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.mView.showToast(ResourceUtils.getString(R.string.network_error));
            return;
        }
        this.mView.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.requestDealAddToCart(new AddDealToCartRequest(i, i2, this.appRepository.getUserId(), this.appRepository.getLanguage(), i3));
    }

    public void onResult(ProductDetailsResult productDetailsResult) {
        this.mView.hideLoadingView();
        this.mView.showResult(productDetailsResult);
    }

    public void onResultError(String str) {
        this.mView.hideLoadingView();
        this.mView.showResultError(str);
    }

    public void onWishListResult(BaseResponse baseResponse) {
        this.mView.hideLoadingView();
        this.mView.showWishListResult(baseResponse);
    }

    public void onAddCartResult(BaseResponse<AddedCartResult> baseResponse) {
        this.mView.hideLoadingView();
        if (this.isBuyNow) {
            this.mView.showBuyNowResult(baseResponse);
        } else {
            this.mView.showAddCartResult(baseResponse);
        }
    }
}
