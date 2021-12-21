package com.kiandashopping.kiandashopping.p011ui.forgotpassword.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.forgotpassword.ForgotPasswordRequest;
import com.kiandashopping.kiandashopping.p011ui.forgotpassword.mvp.ForgotPasswordContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.mvp.ForgotPasswordModel */
public class ForgotPasswordModel extends BaseModel implements ForgotPasswordContractor.Model {
    /* access modifiers changed from: private */
    public ForgotPasswordPresenter presenter;

    ForgotPasswordModel(ForgotPasswordPresenter forgotPasswordPresenter) {
        this.presenter = forgotPasswordPresenter;
    }

    public void requestForgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        addRequest(this.apiInterface.forgotPassword(forgotPasswordRequest), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    ForgotPasswordModel.this.presenter.forgotPasswordSuccess(baseResponse.getDescription());
                } else {
                    ForgotPasswordModel.this.presenter.forgotPasswordError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ForgotPasswordModel.this.presenter.forgotPasswordError(AppUtils.getError(th));
            }
        });
    }
}
