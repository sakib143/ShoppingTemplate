package com.innomalist.taxi.shoppingapp.p011ui.deallist.mvp;

//import com.kiandashopping.kiandashopping.base.BaseModel;
//import com.kiandashopping.kiandashopping.model.BaseResponse;
//import com.kiandashopping.kiandashopping.model.deallist.RequestDealList;
import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.deallist.RequestDealList;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.kiandashopping.kiandashopping.model.deallist.ResultDealList;
//import com.kiandashopping.kiandashopping.p011ui.deallist.mvp.DealListContractor;
//import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
//import p013io.reactivex.disposables.Disposable;
//import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.deallist.mvp.DealListModel */
public class DealListModel extends BaseModel implements DealListContractor.Model {
    /* access modifiers changed from: private */
    public DealListContractor.Presenter presenter;

    DealListModel(DealListPresenter dealListPresenter) {
        this.presenter = dealListPresenter;
    }

    public Disposable requestAllDeals(RequestDealList requestDealList) {
        return addRequest(this.apiInterface.requestAllDeals(requestDealList), new DisposableSingleObserver<BaseResponse<List<ResultDealList>>>() {
            public void onSuccess(BaseResponse<List<ResultDealList>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    DealListModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    DealListModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                DealListModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
