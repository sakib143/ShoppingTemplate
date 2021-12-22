package com.innomalist.taxi.shoppingapp.p011ui.verifyotp.mvp;

//import com.kiandashopping.kiandashopping.base.BaseModel;
//import com.kiandashopping.kiandashopping.model.BaseResponse;
//import com.kiandashopping.kiandashopping.model.register.RegisterResult;
//import com.kiandashopping.kiandashopping.model.register.RequestRegister;
//import com.kiandashopping.kiandashopping.p011ui.verifyotp.mvp.VerifyOtpContractor;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import p013io.reactivex.disposables.Disposable;
//import p013io.reactivex.observers.DisposableSingleObserver;

import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.register.RegisterResult;
import com.innomalist.taxi.shoppingapp.model.register.RequestRegister;
import com.innomalist.taxi.shoppingapp.util.AppUtils;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.mvp.VerifyOtpModel */
public class VerifyOtpModel extends BaseModel implements VerifyOtpContractor.Model {
    /* access modifiers changed from: private */
    public VerifyOtpContractor.Presenter presenter;

    VerifyOtpModel(VerifyOtpPresenter verifyOtpPresenter) {
        this.presenter = verifyOtpPresenter;
    }

    public Disposable requestRegister(RequestRegister requestRegister) {
        return addRequest(this.apiInterface.requestRegisterWithOTP(requestRegister), new DisposableSingleObserver<BaseResponse<RegisterResult>>() {
            public void onSuccess(BaseResponse<RegisterResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    VerifyOtpModel.this.presenter.loginSuccess(baseResponse.getData());
                } else {
                    VerifyOtpModel.this.presenter.errorLogin(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                VerifyOtpModel.this.presenter.errorLogin(AppUtils.getError(th));
            }
        });
    }
}
