package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.mvp;

import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.accountdetail.AccountDetailResult;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.dashboard.ChangePasswordRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.mvp.AccountContractor;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionErrorRetry;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.mvp.AccountPresenter */
public class AccountPresenter extends BasePresenter implements AccountContractor.Presenter {
    private AccountContractor.Model model = new AccountModel(this);
    private AccountContractor.View view;

    public AccountPresenter(AccountContractor.View view2) {
        this.view = view2;
    }

    public void requestAccountDetails() {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
            return;
        }
        this.view.showLoadingView();
        this.model.requestAccountDetails(new LangRequest(this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void onAccountDetails(AccountDetailResult accountDetailResult) {
        this.view.hideLoadingView();
        this.view.showAccountDetails(accountDetailResult);
    }

    public void onAccountDetailsError(String str) {
        this.view.hideLoadingView();
        this.view.showConnectionErrorRetry(str, new DialogConnectionErrorRetry.RetryListener() {
            public final void onClickRetry() {
                AccountPresenter.this.requestAccountDetails();
            }
        });
    }

    public void changePassword(String str, String str2) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
            return;
        }
        this.view.showLoadingView();
        this.model.requestChangePassword(new ChangePasswordRequest(this.appRepository.getUserId(), str, str2, this.appRepository.getLanguage()));
    }

    public void changePasswordSuccess(String str) {
        this.view.hideLoadingView();
        this.view.showToast(str);
    }

    public void changePasswordError(String str) {
        this.view.hideLoadingView();
        this.view.showToast(str);
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
