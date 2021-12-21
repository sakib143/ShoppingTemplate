package com.kiandashopping.kiandashopping.p011ui.dashboard.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.logout.LogoutRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.mvp.DashboardContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.mvp.DashboardModel */
public class DashboardModel extends BaseModel implements DashboardContractor.Model {
    /* access modifiers changed from: private */
    public DashboardContractor.Presenter presenter;

    DashboardModel(DashboardPresenter dashboardPresenter) {
        this.presenter = dashboardPresenter;
    }

    public Disposable requestLogout(LogoutRequest logoutRequest) {
        return addRequest(this.apiInterface.requestLogout(logoutRequest), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    DashboardModel.this.presenter.onResult(baseResponse);
                } else {
                    DashboardModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                DashboardModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
