package com.innomalist.taxi.shoppingapp.p011ui.confirmshipping.activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
//import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
//import androidx.appcompat.widget.SwitchCompat;
//import androidx.core.widget.NestedScrollView;
//import butterknife.BindView;
//import butterknife.OnCheckedChanged;
//import butterknife.OnClick;

import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;
import com.innomalist.taxi.shoppingapp.model.register.UserDetail;
import com.innomalist.taxi.shoppingapp.p011ui.payment.activity.PaymentActivity;
import com.innomalist.taxi.shoppingapp.util.ConversionUtils;
import com.kiandashopping.kiandashopping.customview.AutoSpinner;
import com.kiandashopping.kiandashopping.p011ui.confirmshipping.mvp.ConfirmShippingContractor;
import com.kiandashopping.kiandashopping.p011ui.confirmshipping.mvp.ConfirmShippingPresenter;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.activity.ConfirmShippingDetails */
public class ConfirmShippingDetails extends BaseActivity implements ConfirmShippingContractor.View {
    AccountDetailResult accountDetailResult;
    String cityId = "";
    String cityName = "";
    List<CountryDetail> countryDetails = new ArrayList();
    String countryId = "";
    String countryName = "";
    @BindView(2131362005)
    EditText etBuildingName;
    @BindView(2131362006)
    AppCompatAutoCompleteTextView etCity;
    @BindView(2131362008)
    AppCompatAutoCompleteTextView etCountry;
    @BindView(2131362010)
    EditText etEmail;
    @BindView(2131362011)
    EditText etLocality;
    @BindView(2131362020)
    EditText etPhone;
    @BindView(2131362021)
    EditText etPinCode;
    @BindView(2131362024)
    EditText etState;
    @BindView(2131362026)
    EditText etUserName;
    @BindView(2131362166)
    NestedScrollView nsv;
    ConfirmShippingPresenter presenter;
    @BindView(2131362255)
    SwitchCompat scShipping;
    ArrayList<UserDetail> userDetails;

    public int getLayout() {
        return R.layout.activity_confirm_shipping_address;
    }

    @OnCheckedChanged({2131362255})
    @OnClick({2131362255})
    public void setScShipping() {
        if (this.scShipping.isChecked()) {
            setShippingDetails(this.accountDetailResult.getShippingDetails());
        } else {
            setShippingDetails(new ArrayList());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new ConfirmShippingPresenter(this);
        this.nsv.setVisibility(8);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.shipping_address));
        this.presenter.requestAccount();
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    @OnClick({2131361912})
    public void onClickUpdate() {
        String trim = this.etUserName.getText().toString().trim();
        String trim2 = this.etEmail.getText().toString().trim();
        String trim3 = this.etPhone.getText().toString().trim();
        String trim4 = this.etBuildingName.getText().toString().trim();
        String trim5 = this.etLocality.getText().toString().trim();
        String trim6 = this.etState.getText().toString().trim();
        String trim7 = this.etPinCode.getText().toString().trim();
        if (this.userDetails.size() > 0) {
            this.presenter.updateShippingAddress(trim, trim2, trim3, trim4, trim5, this.countryId, this.countryName, this.cityId, this.cityName, trim6, trim7, this.userDetails.get(0));
        }
    }

    private void setShippingDetails(ArrayList<ShippingDetail> arrayList) {
        this.nsv.setVisibility(0);
        if (arrayList.size() > 0) {
            this.etUserName.setText(arrayList.get(0).getShipName());
            this.etPhone.setText(arrayList.get(0).getShipPhone());
            this.etEmail.setText(arrayList.get(0).getShipEmail());
            this.etBuildingName.setText(arrayList.get(0).getShipAddress1());
            this.etLocality.setText(arrayList.get(0).getShipAddress2());
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = this.etCountry;
            String shipCountryName = arrayList.get(0).getShipCountryName();
            this.countryName = shipCountryName;
            appCompatAutoCompleteTextView.setText(shipCountryName);
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextView2 = this.etCity;
            String shipCityName = arrayList.get(0).getShipCityName();
            this.cityName = shipCityName;
            appCompatAutoCompleteTextView2.setText(shipCityName);
            this.cityId = arrayList.get(0).getShipCityId();
            this.countryId = arrayList.get(0).getShipCountryId();
            this.etState.setText(arrayList.get(0).getShipState());
            this.etPinCode.setText(arrayList.get(0).getShipPostalcode());
            if ((this.countryId.equals("") || this.countryId.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) && this.countryDetails.size() > 0) {
                this.countryId = ConversionUtils.parseString(this.countryDetails.get(0).getCountryId().intValue());
                AppCompatAutoCompleteTextView appCompatAutoCompleteTextView3 = this.etCountry;
                String countryName2 = this.countryDetails.get(0).getCountryName();
                this.countryName = countryName2;
                appCompatAutoCompleteTextView3.setText(countryName2);
                if (this.countryDetails.get(0).getCityDetails().size() > 0) {
                    this.cityId = ConversionUtils.parseString(this.countryDetails.get(0).getCityDetails().get(0).getCityId().intValue());
                    AppCompatAutoCompleteTextView appCompatAutoCompleteTextView4 = this.etCity;
                    String cityName2 = this.countryDetails.get(0).getCityDetails().get(0).getCityName();
                    this.cityName = cityName2;
                    appCompatAutoCompleteTextView4.setText(cityName2);
                    return;
                }
                return;
            }
            return;
        }
        this.etUserName.setText("");
        this.etPhone.setText("");
        this.etEmail.setText("");
        this.etBuildingName.setText("");
        this.etLocality.setText("");
        this.etCountry.setText("");
        this.etCity.setText("");
        this.cityId = "";
        this.countryId = "";
        this.etState.setText("");
        this.etPinCode.setText("");
    }

    public void showAccountDetails(AccountDetailResult accountDetailResult2, List<CountryDetail> list) {
        this.accountDetailResult = accountDetailResult2;
        this.countryDetails = list;
        new AutoSpinner(this.etCountry, list).setListener(new AutoSpinner.Listener(list) {
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void onSelectItem(int i) {
                ConfirmShippingDetails.this.lambda$showAccountDetails$1$ConfirmShippingDetails(this.f$1, i);
            }
        });
        this.userDetails = accountDetailResult2.getUserDetails();
        setShippingDetails(accountDetailResult2.getShippingDetails());
    }

    public /* synthetic */ void lambda$showAccountDetails$1$ConfirmShippingDetails(List list, int i) {
        this.countryId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCountryId().intValue());
        this.countryName = ((CountryDetail) list.get(i)).getCountryName();
        new AutoSpinner(this.etCity, ((CountryDetail) list.get(i)).getCityDetails()).setListener(new AutoSpinner.Listener(list, i) {
            private final /* synthetic */ List f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onSelectItem(int i) {
                ConfirmShippingDetails.this.lambda$null$0$ConfirmShippingDetails(this.f$1, this.f$2, i);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$ConfirmShippingDetails(List list, int i, int i2) {
        this.cityId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCityDetails().get(i2).getCityId().intValue());
        this.cityName = ((CountryDetail) list.get(i)).getCityDetails().get(i2).getCityName();
    }

    public void showShippingDetail(ShippingDetail shippingDetail) {
        changeActivity(PaymentActivity.builtIntent(this, shippingDetail));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }
}
