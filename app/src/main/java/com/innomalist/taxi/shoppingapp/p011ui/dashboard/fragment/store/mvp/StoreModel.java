package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store.mvp;

//import com.kiandashopping.kiandashopping.base.BaseModel;
//import com.kiandashopping.kiandashopping.model.BaseResponse;
//import com.kiandashopping.kiandashopping.model.category.LangRequest;
//import com.kiandashopping.kiandashopping.model.storelist.StoreResult;
import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreResult;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store.mvp.StoreContractor;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import java.util.List;
//import p013io.reactivex.disposables.Disposable;
//import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.mvp.StoreModel */
public class StoreModel extends BaseModel implements StoreContractor.Model {
    /* access modifiers changed from: private */
    public StoreContractor.Presenter presenter;

    StoreModel(StorePresenter storePresenter) {
        this.presenter = storePresenter;
    }

    public Disposable requestStore(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestShopList(langRequest), new DisposableSingleObserver<BaseResponse<List<StoreResult>>>() {
            public void onSuccess(BaseResponse<List<StoreResult>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    StoreModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    StoreModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                StoreModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
