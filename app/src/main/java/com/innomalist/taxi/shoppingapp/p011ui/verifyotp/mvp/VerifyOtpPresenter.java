package com.innomalist.taxi.shoppingapp.p011ui.verifyotp.mvp;

//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.base.BasePresenter;
//import com.kiandashopping.kiandashopping.model.register.RegisterResult;
//import com.kiandashopping.kiandashopping.model.register.RequestRegister;
//import com.kiandashopping.kiandashopping.model.register.UserDetail;
//import com.kiandashopping.kiandashopping.p011ui.verifyotp.mvp.VerifyOtpContractor;
//import com.kiandashopping.kiandashopping.util.ConversionUtils;
//import com.kiandashopping.kiandashopping.util.NetworkUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.register.RegisterResult;
import com.innomalist.taxi.shoppingapp.model.register.RequestRegister;
import com.innomalist.taxi.shoppingapp.model.register.UserDetail;
import com.innomalist.taxi.shoppingapp.util.ConversionUtils;
import com.innomalist.taxi.shoppingapp.util.NetworkUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.mvp.VerifyOtpPresenter */
public class VerifyOtpPresenter extends BasePresenter implements VerifyOtpContractor.Presenter {
    private VerifyOtpContractor.Model model = new VerifyOtpModel(this);
    private VerifyOtpContractor.View view;

    public VerifyOtpPresenter(VerifyOtpContractor.View view2) {
        this.view = view2;
    }

    public void requestOrp(RequestRegister requestRegister, String str) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (str.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.error_otp));
        } else {
            this.view.showLoadingView();
            requestRegister.setGeneratedOtp(str);
            requestRegister.setCurrentOtp(str);
            this.model.requestRegister(requestRegister);
        }
    }

    public void loginSuccess(RegisterResult registerResult) {
        this.view.hideLoadingView();
        this.appRepository.saveIsLoggedIn(true);
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
