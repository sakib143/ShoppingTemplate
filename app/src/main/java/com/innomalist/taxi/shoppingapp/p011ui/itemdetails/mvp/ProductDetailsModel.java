package com.kiandashopping.kiandashopping.p011ui.itemdetails.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
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
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.mvp.ProductDetailsModel */
public class ProductDetailsModel extends BaseModel implements ProductDetailsContractor.Model {
    /* access modifiers changed from: private */
    public ProductDetailsPresenter presenter;

    ProductDetailsModel(ProductDetailsPresenter productDetailsPresenter) {
        this.presenter = productDetailsPresenter;
    }

    public Disposable requestProductDetails(ProductDetailsRequest productDetailsRequest) {
        return addRequest(this.apiInterface.requestProductDetails(productDetailsRequest), new DisposableSingleObserver<BaseResponse<ProductDetailsResult>>() {
            public void onSuccess(BaseResponse<ProductDetailsResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ProductDetailsModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    ProductDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ProductDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestDealDetails(DealDetailsRequest dealDetailsRequest) {
        return addRequest(this.apiInterface.requestDealDetails(dealDetailsRequest), new DisposableSingleObserver<BaseResponse<ProductDetailsResult>>() {
            public void onSuccess(BaseResponse<ProductDetailsResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ProductDetailsModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    ProductDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ProductDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestAddWishList(RequestAddWishList requestAddWishList) {
        return addRequest(this.apiInterface.requestAddWishList(requestAddWishList), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    ProductDetailsModel.this.presenter.onWishListResult(baseResponse);
                } else {
                    ProductDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ProductDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestAddReview(final AddReviewRequest addReviewRequest) {
        return addRequest(this.apiInterface.requestAddReview(addReviewRequest), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    ProductDetailsModel.this.requestProductDetails(new ProductDetailsRequest(addReviewRequest.getCusId(), addReviewRequest.getProductId(), addReviewRequest.getLang()));
                } else {
                    ProductDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ProductDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestDealAddReview(final AddReviewRequest addReviewRequest) {
        return addRequest(this.apiInterface.requestDealAddReview(addReviewRequest), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    ProductDetailsModel.this.requestDealDetails(new DealDetailsRequest(addReviewRequest.getDealId(), addReviewRequest.getLang()));
                } else {
                    ProductDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ProductDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestAddToCart(AddToCartRequest addToCartRequest) {
        return addRequest(this.apiInterface.requestAddToCart(addToCartRequest), new DisposableSingleObserver<BaseResponse<AddedCartResult>>() {
            public void onSuccess(BaseResponse<AddedCartResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ProductDetailsModel.this.presenter.onAddCartResult(baseResponse);
                } else {
                    ProductDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ProductDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestDealAddToCart(AddDealToCartRequest addDealToCartRequest) {
        return addRequest(this.apiInterface.requestDealAddToCart(addDealToCartRequest), new DisposableSingleObserver<BaseResponse<AddedCartResult>>() {
            public void onSuccess(BaseResponse<AddedCartResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ProductDetailsModel.this.presenter.onAddCartResult(baseResponse);
                } else {
                    ProductDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ProductDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
