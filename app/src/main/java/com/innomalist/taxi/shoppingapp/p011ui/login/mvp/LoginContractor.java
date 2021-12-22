package com.innomalist.taxi.shoppingapp.p011ui.login.mvp;

//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.ViewInterface;
//import com.kiandashopping.kiandashopping.model.login.LoginRequest;
//import com.kiandashopping.kiandashopping.model.login.LoginWithFBRequest;
//import com.kiandashopping.kiandashopping.model.register.RegisterResult;
//import p013io.reactivex.disposables.Disposable;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.model.login.LoginRequest;
import com.innomalist.taxi.shoppingapp.model.login.LoginWithFBRequest;
import com.innomalist.taxi.shoppingapp.model.register.RegisterResult;

import io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.login.mvp.LoginContractor */
public interface LoginContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.login.mvp.LoginContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestLogin(LoginRequest loginRequest);

        Disposable requestLogin(LoginWithFBRequest loginWithFBRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.login.mvp.LoginContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void errorLogin(String str);

        void loginSuccess(RegisterResult registerResult);

        void requestLogin(String str, String str2);

        void requestLoginFB(String str, String str2, String str3);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.login.mvp.LoginContractor$View */
    public interface View extends ViewInterface {
        void showLoginSuccess();
    }
}
