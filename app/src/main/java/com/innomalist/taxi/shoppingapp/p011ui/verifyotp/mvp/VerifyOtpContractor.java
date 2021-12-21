package com.kiandashopping.kiandashopping.p011ui.verifyotp.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.register.RegisterResult;
import com.kiandashopping.kiandashopping.model.register.RequestRegister;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.mvp.VerifyOtpContractor */
public interface VerifyOtpContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.mvp.VerifyOtpContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestRegister(RequestRegister requestRegister);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.mvp.VerifyOtpContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void errorLogin(String str);

        void loginSuccess(RegisterResult registerResult);

        void requestOrp(RequestRegister requestRegister, String str);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.mvp.VerifyOtpContractor$View */
    public interface View extends ViewInterface {
        void showLoginSuccess();
    }
}
