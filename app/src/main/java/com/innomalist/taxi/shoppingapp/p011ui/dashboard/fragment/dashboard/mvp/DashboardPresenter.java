package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.dashboard.DashboardResponse;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.mvp.DashboardContractor;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionErrorRetry;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.mvp.DashboardPresenter */
public class DashboardPresenter extends BasePresenter implements DashboardContractor.Presenter {
    private DashboardContractor.Model model = new DashboardModel(this);
    private DashboardContractor.View view;

    public DashboardPresenter(DashboardContractor.View view2) {
        this.view = view2;
    }

    public void requestDashboard() {
        this.view.showLoadingView();
        this.model.requestDashboard(new LangRequest(this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void onDashboardResult(DashboardResponse dashboardResponse) {
        this.view.hideLoadingView();
        this.view.showDashboardResponse(dashboardResponse);
    }

    public void onDashboardResultError(String str) {
        this.view.hideLoadingView();
        this.view.showConnectionErrorRetry(str, new DialogConnectionErrorRetry.RetryListener() {
            public final void onClickRetry() {
                DashboardPresenter.this.requestDashboard();
            }
        });
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
