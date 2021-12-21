package com.kiandashopping.kiandashopping.p011ui.forgotpassword.mvp;

import android.util.Patterns;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.forgotpassword.ForgotPasswordRequest;
import com.kiandashopping.kiandashopping.p011ui.forgotpassword.mvp.ForgotPasswordContractor;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.mvp.ForgotPasswordPresenter */
public class ForgotPasswordPresenter extends BasePresenter implements ForgotPasswordContractor.Presenter {
    private ForgotPasswordContractor.View mView;
    private ForgotPasswordModel model = new ForgotPasswordModel(this);

    public ForgotPasswordPresenter(ForgotPasswordContractor.View view) {
        this.mView = view;
    }

    public void forgotPasswordClicked(String str) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.mView.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (str.isEmpty()) {
            this.mView.showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            this.mView.showToast(ResourceUtils.getString(R.string.warning_valid_email));
        } else {
            this.mView.showLoadingView();
            this.model.requestForgotPassword(new ForgotPasswordRequest(this.appRepository.getLanguage(), str));
        }
    }

    public void forgotPasswordSuccess(String str) {
        this.mView.hideLoadingView();
        this.mView.showForgotPasswordSuccess(str);
    }

    public void forgotPasswordError(String str) {
        this.mView.hideLoadingView();
        this.mView.showForgotPasswordError(str);
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
