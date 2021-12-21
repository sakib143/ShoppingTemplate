package com.kiandashopping.kiandashopping.p011ui.forgotpassword.mvp;

import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.forgotpassword.ForgotPasswordRequest;

/* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.mvp.ForgotPasswordContractor */
public interface ForgotPasswordContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.mvp.ForgotPasswordContractor$Model */
    public interface Model {
        void requestForgotPassword(ForgotPasswordRequest forgotPasswordRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.mvp.ForgotPasswordContractor$Presenter */
    public interface Presenter {
        void forgotPasswordClicked(String str);

        void forgotPasswordError(String str);

        void forgotPasswordSuccess(String str);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.mvp.ForgotPasswordContractor$View */
    public interface View extends ViewInterface {
        void showForgotPasswordError(String str);

        void showForgotPasswordSuccess(String str);
    }
}
