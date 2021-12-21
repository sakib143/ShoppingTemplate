package com.innomalist.taxi.shoppingapp.p011ui.allreviews.mvp;

import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewRequest;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewResult;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.mvp.AllReviewModel */
public class AllReviewModel extends BaseModel implements AllReviewContractor.Model {
    /* access modifiers changed from: private */
    public AllReviewContractor.Presenter presenter;

    AllReviewModel(AllReviewPresenter allReviewPresenter) {
        this.presenter = allReviewPresenter;
    }

    public Disposable requestAllProductReview(AllReviewRequest allReviewRequest) {
        return addRequest(this.apiInterface.requestProductAllReview(allReviewRequest), new DisposableSingleObserver<BaseResponse<List<AllReviewResult>>>() {
            public void onSuccess(BaseResponse<List<AllReviewResult>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    AllReviewModel.this.presenter.onProductReviewResult(baseResponse.getData());
                } else {
                    AllReviewModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                AllReviewModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestDealAllReview(AllReviewRequest allReviewRequest) {
        return addRequest(this.apiInterface.requestDealAllReview(allReviewRequest), new DisposableSingleObserver<BaseResponse<List<AllReviewResult>>>() {
            public void onSuccess(BaseResponse<List<AllReviewResult>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    AllReviewModel.this.presenter.onProductReviewResult(baseResponse.getData());
                } else {
                    AllReviewModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                AllReviewModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestStoreAllReview(AllReviewRequest allReviewRequest) {
        return addRequest(this.apiInterface.requestStoreAllReview(allReviewRequest), new DisposableSingleObserver<BaseResponse<List<AllReviewResult>>>() {
            public void onSuccess(BaseResponse<List<AllReviewResult>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    AllReviewModel.this.presenter.onProductReviewResult(baseResponse.getData());
                } else {
                    AllReviewModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                AllReviewModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
