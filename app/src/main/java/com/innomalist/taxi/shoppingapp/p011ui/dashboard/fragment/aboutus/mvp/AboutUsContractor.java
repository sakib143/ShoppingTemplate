package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.cms.RequestAboutUs;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.mvp.AboutUsContractor */
public interface AboutUsContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.mvp.AboutUsContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestAboutUs(RequestAboutUs requestAboutUs);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.mvp.AboutUsContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(String str);

        void onResultError(String str);

        void requestAboutUs(String str);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.mvp.AboutUsContractor$View */
    public interface View extends ViewInterface {
        void showResult(String str);
    }
}
