package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.nearme.NearByRequest;
import com.kiandashopping.kiandashopping.model.nearme.NearByResult;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.mvp.NearByContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.List;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.mvp.NearByModel */
public class NearByModel extends BaseModel implements NearByContractor.Model {
    /* access modifiers changed from: private */
    public NearByContractor.Presenter presenter;

    NearByModel(NearByPresenter nearByPresenter) {
        this.presenter = nearByPresenter;
    }

    public Disposable requestNearBy(NearByRequest nearByRequest) {
        return addRequest(this.apiInterface.requestNearBy(nearByRequest), new DisposableSingleObserver<BaseResponse<List<NearByResult>>>() {
            public void onSuccess(BaseResponse<List<NearByResult>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    NearByModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    NearByModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                NearByModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
