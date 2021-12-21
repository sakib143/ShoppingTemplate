package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.dashboard.DashboardResponse;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.mvp.DashboardContractor */
public interface DashboardContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.mvp.DashboardContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestDashboard(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.mvp.DashboardContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onDashboardResult(DashboardResponse dashboardResponse);

        void onDashboardResultError(String str);

        void requestDashboard();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.mvp.DashboardContractor$View */
    public interface View extends ViewInterface {
        void showDashboardResponse(DashboardResponse dashboardResponse);
    }
}
