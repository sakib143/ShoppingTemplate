package com.innomalist.taxi.shoppingapp.p011ui.bycategory.mvp;


import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryRequest;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryResult;
import com.innomalist.taxi.shoppingapp.util.AppUtils;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.mvp.ByCategoryModel */
public class ByCategoryModel extends BaseModel implements ByCategoryContractor.Model {
    /* access modifiers changed from: private */
    public ByCategoryContractor.Presenter presenter;

    ByCategoryModel(ByCategoryPresenter byCategoryPresenter) {
        this.presenter = byCategoryPresenter;
    }

    public Disposable requestByCategory(ByCategoryRequest byCategoryRequest) {
        return addRequest(this.apiInterface.requestByCategory(byCategoryRequest), new DisposableSingleObserver<BaseResponse<ByCategoryResult>>() {
            public void onSuccess(BaseResponse<ByCategoryResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ByCategoryModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    ByCategoryModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ByCategoryModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
