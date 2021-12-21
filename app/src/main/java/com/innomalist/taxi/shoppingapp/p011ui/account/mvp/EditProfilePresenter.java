package com.innomalist.taxi.shoppingapp.p011ui.account.mvp;

import android.util.Patterns;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.io.File;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.account.mvp.EditProfilePresenter */
public class EditProfilePresenter extends BasePresenter implements EditProfileContractor.Presenter {
    private EditProfileContractor.Model model = new EditProfileModel(this);
    private EditProfileContractor.View view;

    public EditProfilePresenter(EditProfileContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestCountry() {
        this.view.showLoadingView();
        this.model.requestCountry(new LangRequest(this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void result(List<CountryDetail> list, AccountDetailResult accountDetailResult) {
        this.view.hideLoadingView();
        this.view.showResult(list, accountDetailResult);
    }

    public void resultError(String str) {
        this.view.hideLoadingView();
        this.view.showError(str);
    }

    public void updateProfile(File file, String str, String str2, String str3, String str4, String str5, ShippingDetail shippingDetail) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (str.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_name));
        } else if (str2.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (str3.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_phone));
        } else {
            String str6 = str2;
            if (!Patterns.EMAIL_ADDRESS.matcher(str2).matches()) {
                this.view.showToast(ResourceUtils.getString(R.string.warning_valid_email));
            } else if (str4.isEmpty()) {
                this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_country));
            } else if (str5.isEmpty()) {
                this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_city));
            } else {
                this.view.showLoadingView();
                this.model.updateProfile(file, this.appRepository.getUserId(), this.appRepository.getLanguage(), str, str2, str3, str4, str5, shippingDetail);
            }
        }
    }

    public void updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, UserDetail userDetail) {
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
        } else if (str4.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_build_name));
        } else if (str5.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_locality));
        } else if (str6.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_country));
        } else if (str7.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_city));
        } else if (str8.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_state));
        } else if (str9.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_pincode));
        } else {
            this.view.showLoadingView();
            this.model.updateShippingAddress(this.appRepository.getUserId(), this.appRepository.getLanguage(), str, str2, str3, str4, str5, str6, str7, str8, str9, userDetail);
        }
    }

    public void updateSuccess(BaseResponse<AccountDetailResult> baseResponse) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        this.view.hideLoadingView();
        this.appRepository.saveIsLoggedIn(true);
        AccountDetailResult data = baseResponse.getData();
        if (data.getUserDetails().size() > 0) {
            this.appRepository.setAvatar(data.getUserDetails().get(0).getCusImage());
            this.appRepository.setFirstName(data.getUserDetails().get(0).getCusName());
            this.appRepository.setEmail(data.getUserDetails().get(0).getCusEmail());
            if (data.getShippingDetails().size() > 0) {
                ShippingDetail shippingDetail = data.getShippingDetails().get(0);
                StringBuilder sb = new StringBuilder();
                String str6 = "";
                if (shippingDetail.getShipAddress1().length() > 0) {
                    str = shippingDetail.getShipAddress1() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str = str6;
                }
                sb.append(str);
                if (shippingDetail.getShipAddress2().length() > 0) {
                    str2 = shippingDetail.getShipAddress2() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str2 = str6;
                }
                sb.append(str2);
                if (shippingDetail.getShipCityName().length() > 0) {
                    str3 = shippingDetail.getShipCityName() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str3 = str6;
                }
                sb.append(str3);
                if (shippingDetail.getShipState().length() > 0) {
                    str4 = shippingDetail.getShipState() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str4 = str6;
                }
                sb.append(str4);
                if (shippingDetail.getShipCountryName().length() > 0) {
                    str5 = shippingDetail.getShipCountryName() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str5 = str6;
                }
                sb.append(str5);
                if (shippingDetail.getShipPostalcode().length() > 0) {
                    str6 = shippingDetail.getShipPostalcode();
                }
                sb.append(str6);
                this.appRepository.setShippingAddress(sb.toString());
            }
        }
        this.view.showUpdateSuccess(baseResponse.getDescription());
    }

    public void updateError(String str) {
        this.view.hideLoadingView();
        this.view.showError(str);
    }
}
