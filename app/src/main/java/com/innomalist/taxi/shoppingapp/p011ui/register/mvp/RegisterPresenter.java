package com.kiandashopping.kiandashopping.p011ui.register.mvp;

import android.util.Patterns;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.model.register.RegisterResult;
import com.kiandashopping.kiandashopping.model.register.RequestRegister;
import com.kiandashopping.kiandashopping.model.register.UserDetail;
import com.kiandashopping.kiandashopping.p011ui.register.mvp.RegisterContractor;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import com.kiandashopping.kiandashopping.util.ViewUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.register.mvp.RegisterPresenter */
public class RegisterPresenter extends BasePresenter implements RegisterContractor.Presenter {
    private RegisterContractor.Model model = new RegisterModel(this);
    private RegisterContractor.View view;

    public RegisterPresenter(RegisterContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestCountry() {
        this.view.showLoadingView();
        this.model.requestCountry(new LangRequest(this.appRepository.getLanguage()));
    }

    public void resultCountryList(List<CountryDetail> list) {
        this.view.hideLoadingView();
        this.view.showCountryList(list);
    }

    public void resultError(String str) {
        this.view.hideLoadingView();
        this.view.showError(str);
    }

    public void requestRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        int i = ResourceUtils.getInt(R.integer.passwordLengthMin);
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (str.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_name));
        } else if (str2.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (str3.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_phone));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str2).matches()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_valid_email));
        } else if (str6.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_country));
        } else if (str7.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_city));
        } else if (str4.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_password));
        } else if (str4.length() < i) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_length_password, Integer.valueOf(i)));
        } else if (str5.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_password_confirm));
        } else {
            if (!str5.equalsIgnoreCase(str4)) {
                this.view.showToast(ResourceUtils.getString(R.string.warning_password_mismatch));
            } else if (!z) {
                this.view.showToast(ResourceUtils.getString(R.string.warning_terms_policy));
            } else {
                this.view.showLoadingView();
                this.model.requestRegister(new RequestRegister(str, str2, str3, str6, str7, str4, this.appRepository.getLanguage(), this.appRepository.getFCMToken(), ViewUtils.getDeviceId(), "android"));
            }
        }
    }

    public void resultOTP(RequestRegister requestRegister) {
        this.view.hideLoadingView();
        this.view.showResultOtp(requestRegister);
    }

    public void resultSuccess(RegisterResult registerResult) {
        this.view.hideLoadingView();
        this.appRepository.saveIsLoggedIn(true);
        if (registerResult.getUserDetails().size() > 0) {
            UserDetail userDetail = registerResult.getUserDetails().get(0);
            this.appRepository.setUserId(ConversionUtils.parseString(userDetail.getCusId().intValue()));
            this.appRepository.setAvatar(userDetail.getCusImage());
            this.appRepository.setFirstName(userDetail.getCusName());
            this.appRepository.setEmail(userDetail.getCusEmail());
        }
        this.view.showResultSuccess();
    }

    public void registerError(String str) {
        this.view.hideLoadingView();
        this.view.showError(str);
    }
}
