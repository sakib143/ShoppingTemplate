package com.kiandashopping.kiandashopping.p011ui.login.mvp;

import android.util.Patterns;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.login.LoginRequest;
import com.kiandashopping.kiandashopping.model.login.LoginWithFBRequest;
import com.kiandashopping.kiandashopping.model.register.RegisterResult;
import com.kiandashopping.kiandashopping.model.register.UserDetail;
import com.kiandashopping.kiandashopping.p011ui.login.mvp.LoginContractor;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import com.kiandashopping.kiandashopping.util.ViewUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.login.mvp.LoginPresenter */
public class LoginPresenter extends BasePresenter implements LoginContractor.Presenter {
    private LoginContractor.Model model = new LoginModel(this);
    private LoginContractor.View view;

    public LoginPresenter(LoginContractor.View view2) {
        this.view = view2;
    }

    public void requestLoginFB(String str, String str2, String str3) {
        this.view.showLoadingView();
        this.model.requestLogin(new LoginWithFBRequest(this.appRepository.getLanguage(), str2, str, str3, this.appRepository.getFCMToken(), ViewUtils.getDeviceId(), "android"));
    }

    public void requestLogin(String str, String str2) {
        int i = ResourceUtils.getInt(R.integer.passwordLengthMin);
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (str.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_valid_email));
        } else if (str2.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_password));
        } else if (str2.length() < i) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_length_password, Integer.valueOf(i)));
        } else {
            this.view.showLoadingView();
            this.model.requestLogin(new LoginRequest(this.appRepository.getLanguage(), str, str2, this.appRepository.getFCMToken(), ViewUtils.getDeviceId(), "android"));
        }
    }

    public void loginSuccess(RegisterResult registerResult) {
        this.view.hideLoadingView();
        this.appRepository.saveIsLoggedIn(true);
        this.appRepository.setCartCount(registerResult.getCartCount().intValue());
        if (registerResult.getUserDetails().size() > 0) {
            UserDetail userDetail = registerResult.getUserDetails().get(0);
            this.appRepository.setUserId(ConversionUtils.parseString(userDetail.getCusId().intValue()));
            this.appRepository.setAvatar(userDetail.getCusImage());
            this.appRepository.setFirstName(userDetail.getCusName());
            this.appRepository.setEmail(userDetail.getCusEmail());
        }
        this.view.showLoginSuccess();
    }

    public void errorLogin(String str) {
        this.view.hideLoadingView();
        this.view.showError(str);
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
