package com.kiandashopping.kiandashopping.p011ui.splash.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;

/* renamed from: com.kiandashopping.kiandashopping.ui.splash.mvp.SplashContractor */
public interface SplashContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.splash.mvp.SplashContractor$Model */
    public interface Model extends ModelInterface {
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.splash.mvp.SplashContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void startNavigation();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.splash.mvp.SplashContractor$View */
    public interface View extends ViewInterface {
        void showDashBoardActivity();

        void showLoginActivity();
    }
}
