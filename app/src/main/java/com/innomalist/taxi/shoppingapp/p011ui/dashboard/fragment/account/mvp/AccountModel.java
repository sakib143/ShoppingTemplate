package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.accountdetail.AccountDetailResult;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.dashboard.ChangePasswordRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.mvp.AccountContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.mvp.AccountModel */
public class AccountModel extends BaseModel implements AccountContractor.Model {
    /* access modifiers changed from: private */
    public AccountContractor.Presenter presenter;

    AccountModel(AccountPresenter accountPresenter) {
        this.presenter = accountPresenter;
    }

    public Disposable requestChangePassword(ChangePasswordRequest changePasswordRequest) {
        return addRequest(this.apiInterface.requestChangePassword(changePasswordRequest), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    AccountModel.this.presenter.changePasswordSuccess(baseResponse.getDescription());
                } else {
                    AccountModel.this.presenter.changePasswordError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                AccountModel.this.presenter.changePasswordError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestAccountDetails(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestAccountDetails(langRequest), new DisposableSingleObserver<BaseResponse<AccountDetailResult>>() {
            public void onSuccess(BaseResponse<AccountDetailResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    AccountModel.this.presenter.onAccountDetails(baseResponse.getData());
                } else {
                    AccountModel.this.presenter.onAccountDetailsError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                AccountModel.this.presenter.onAccountDetailsError(AppUtils.getError(th));
            }
        });
    }
}
