package com.kiandashopping.kiandashopping.p011ui.storedetails.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.storelist.RequestAddStoreReview;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailRequest;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.mvp.StoreDetailsModel */
public class StoreDetailsModel extends BaseModel implements StoreDetailsContractor.Model {
    /* access modifiers changed from: private */
    public StoreDetailsContractor.Presenter presenter;

    StoreDetailsModel(StoreDetailsPresenter storeDetailsPresenter) {
        this.presenter = storeDetailsPresenter;
    }

    public Disposable requestStoreDetails(StoreDetailRequest storeDetailRequest) {
        return addRequest(this.apiInterface.requestStoreDetails(storeDetailRequest), new DisposableSingleObserver<BaseResponse<StoreDetailsResult>>() {
            public void onSuccess(BaseResponse<StoreDetailsResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    StoreDetailsModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    StoreDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                StoreDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestAddReview(final RequestAddStoreReview requestAddStoreReview) {
        return addRequest(this.apiInterface.requestAddStoreReview(requestAddStoreReview), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    StoreDetailsModel.this.requestStoreDetails(new StoreDetailRequest(requestAddStoreReview.getLang(), requestAddStoreReview.getCusId(), requestAddStoreReview.getStoreId()));
                } else {
                    StoreDetailsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                StoreDetailsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
