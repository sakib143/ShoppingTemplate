package com.kiandashopping.kiandashopping.p011ui.dashboard.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.logout.LogoutRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.mvp.DashboardContractor;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.mvp.DashboardPresenter */
public class DashboardPresenter extends BasePresenter implements DashboardContractor.Presenter {
    private DashboardContractor.Model model = new DashboardModel(this);
    private DashboardContractor.View view;

    public DashboardPresenter(DashboardContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestLogout() {
        this.view.showLoadingView();
        this.model.requestLogout(new LogoutRequest(this.appRepository.getUserId(), "", "", "android", this.appRepository.getLanguage()));
    }

    public void onResult(BaseResponse baseResponse) {
        this.view.hideLoadingView();
        this.view.showToast(baseResponse.getDescription());
        this.view.showLogin();
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showToast(str);
    }
}
