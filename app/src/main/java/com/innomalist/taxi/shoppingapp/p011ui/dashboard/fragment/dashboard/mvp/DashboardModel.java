package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.dashboard.DashboardResponse;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.mvp.DashboardContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.mvp.DashboardModel */
public class DashboardModel extends BaseModel implements DashboardContractor.Model {
    /* access modifiers changed from: private */
    public DashboardContractor.Presenter presenter;

    DashboardModel(DashboardPresenter dashboardPresenter) {
        this.presenter = dashboardPresenter;
    }

    public Disposable requestDashboard(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestDashboard(langRequest), new DisposableSingleObserver<BaseResponse<DashboardResponse>>() {
            public void onSuccess(BaseResponse<DashboardResponse> baseResponse) {
                if (baseResponse.isSuccess()) {
                    DashboardModel.this.presenter.onDashboardResult(baseResponse.getData());
                } else {
                    DashboardModel.this.presenter.onDashboardResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                DashboardModel.this.presenter.onDashboardResultError(AppUtils.getError(th));
            }
        });
    }
}
