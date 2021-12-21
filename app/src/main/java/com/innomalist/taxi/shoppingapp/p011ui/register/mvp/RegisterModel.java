package com.kiandashopping.kiandashopping.p011ui.register.mvp;

import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.model.register.RegisterResult;
import com.kiandashopping.kiandashopping.model.register.RequestRegister;
import com.kiandashopping.kiandashopping.p011ui.register.mvp.RegisterContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.List;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.register.mvp.RegisterModel */
public class RegisterModel extends BaseModel implements RegisterContractor.Model {
    /* access modifiers changed from: private */
    public RegisterContractor.Presenter presenter;

    RegisterModel(RegisterPresenter registerPresenter) {
        this.presenter = registerPresenter;
    }

    public Disposable requestRegister(final RequestRegister requestRegister) {
        return addRequest(this.apiInterface.register(requestRegister), new DisposableSingleObserver<BaseResponse<RegisterResult>>() {
            public void onSuccess(BaseResponse<RegisterResult> baseResponse) {
                if (!baseResponse.isSuccess()) {
                    RegisterModel.this.presenter.registerError(baseResponse.getDescription());
                } else if (baseResponse.getMessage().equals(AppConstants.API_OTP_SENT_TO_UR_MOBILE)) {
                    RegisterModel.this.presenter.resultOTP(requestRegister);
                } else {
                    RegisterModel.this.presenter.resultSuccess(baseResponse.getData());
                }
            }

            public void onError(Throwable th) {
                RegisterModel.this.presenter.registerError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestCountry(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestCountry(langRequest), new DisposableSingleObserver<BaseResponse<List<CountryDetail>>>() {
            public void onSuccess(BaseResponse<List<CountryDetail>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    RegisterModel.this.presenter.resultCountryList(baseResponse.getData());
                } else {
                    RegisterModel.this.presenter.resultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                RegisterModel.this.presenter.resultError(AppUtils.getError(th));
            }
        });
    }
}
