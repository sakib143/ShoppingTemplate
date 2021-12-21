package com.kiandashopping.kiandashopping.p011ui.login.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.login.LoginRequest;
import com.kiandashopping.kiandashopping.model.login.LoginWithFBRequest;
import com.kiandashopping.kiandashopping.model.register.RegisterResult;
import com.kiandashopping.kiandashopping.p011ui.login.mvp.LoginContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.login.mvp.LoginModel */
public class LoginModel extends BaseModel implements LoginContractor.Model {
    /* access modifiers changed from: private */
    public LoginContractor.Presenter presenter;

    LoginModel(LoginPresenter loginPresenter) {
        this.presenter = loginPresenter;
    }

    public Disposable requestLogin(LoginRequest loginRequest) {
        return addRequest(this.apiInterface.login(loginRequest), new DisposableSingleObserver<BaseResponse<RegisterResult>>() {
            public void onSuccess(BaseResponse<RegisterResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    LoginModel.this.presenter.loginSuccess(baseResponse.getData());
                } else {
                    LoginModel.this.presenter.errorLogin(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                LoginModel.this.presenter.errorLogin(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestLogin(LoginWithFBRequest loginWithFBRequest) {
        return addRequest(this.apiInterface.login(loginWithFBRequest), new DisposableSingleObserver<BaseResponse<RegisterResult>>() {
            public void onSuccess(BaseResponse<RegisterResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    LoginModel.this.presenter.loginSuccess(baseResponse.getData());
                } else {
                    LoginModel.this.presenter.errorLogin(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                LoginModel.this.presenter.errorLogin(AppUtils.getError(th));
            }
        });
    }
}
