package com.innomalist.taxi.shoppingapp.p011ui.confirmshipping.mvp;

import android.util.Patterns;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.accountdetail.UserDetail;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.mvp.ConfirmShippingPresenter */
public class ConfirmShippingPresenter extends BasePresenter implements ConfirmShippingContractor.Presenter {
    private ConfirmShippingContractor.Model model = new ConfirmShippingModel(this);
    private ShippingDetail shippingDetail;
    private ConfirmShippingContractor.View view;

    public ConfirmShippingPresenter(ConfirmShippingContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestAccount() {
        this.view.showLoadingView();
        this.model.requestCountry(new LangRequest(this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void resultError(String str) {
        this.view.hideLoadingView();
        this.view.showError(str);
    }

    public void onAccountDetails(AccountDetailResult accountDetailResult, List<CountryDetail> list) {
        this.view.hideLoadingView();
        this.view.showAccountDetails(accountDetailResult, list);
    }

    public void updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UserDetail userDetail) {
        String str12 = str2;
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (str.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_name));
        } else if (str2.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (str3.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_phone));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str12).matches()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_valid_email));
        } else if (str4.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_build_name));
        } else if (str5.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_locality));
        } else if (str6.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_country));
        } else if (str8.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_select_city));
        } else if (str10.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_state));
        } else if (str11.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_pincode));
        } else {
            this.view.showLoadingView();
            ShippingDetail shippingDetail2 = new ShippingDetail();
            this.shippingDetail = shippingDetail2;
            shippingDetail2.setShipName(str);
            this.shippingDetail.setShipEmail(str12);
            String str13 = str3;
            this.shippingDetail.setShipPhone(str13);
            String str14 = str4;
            this.shippingDetail.setShipAddress1(str14);
            String str15 = str5;
            this.shippingDetail.setShipAddress2(str15);
            String str16 = str6;
            this.shippingDetail.setShipCountryId(str16);
            this.shippingDetail.setShipCountryName(str7);
            String str17 = str8;
            this.shippingDetail.setShipCityId(str17);
            this.shippingDetail.setShipCityName(str9);
            String str18 = str10;
            this.shippingDetail.setShipState(str18);
            String str19 = str11;
            this.shippingDetail.setShipPostalcode(str19);
            this.model.updateShippingAddress(this.appRepository.getUserId(), this.appRepository.getLanguage(), str, str2, str13, str14, str15, str16, str17, str18, str19, userDetail);
        }
    }

    public void updateSuccess(BaseResponse<AccountDetailResult> baseResponse) {
        this.view.hideLoadingView();
        this.view.showShippingDetail(this.shippingDetail);
    }

    public void updateError(String str) {
        this.view.hideLoadingView();
        this.view.showError(str);
    }
}
