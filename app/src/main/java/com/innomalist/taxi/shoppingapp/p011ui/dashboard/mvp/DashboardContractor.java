package com.kiandashopping.kiandashopping.p011ui.dashboard.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.logout.LogoutRequest;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.mvp.DashboardContractor */
public interface DashboardContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.mvp.DashboardContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestLogout(LogoutRequest logoutRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.mvp.DashboardContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(BaseResponse baseResponse);

        void onResultError(String str);

        void requestLogout();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.mvp.DashboardContractor$View */
    public interface View extends ViewInterface {
        void showLogin();
    }
}
