package com.innomalist.taxi.shoppingapp.p011ui.account.activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.OnClick;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.accountdetail.UserDetail;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.customview.AutoSpinner;
import com.kiandashopping.kiandashopping.p011ui.account.mvp.EditProfileContractor;
import com.kiandashopping.kiandashopping.p011ui.account.mvp.EditProfilePresenter;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.account.activity.ShippingDetails */
public class ShippingDetails extends BaseActivity implements EditProfileContractor.View {
    String cityId = "";
    String countryId = "";
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
    EditProfilePresenter presenter;
    ArrayList<ShippingDetail> shippingDetails;
    ArrayList<UserDetail> userDetails;

    public int getLayout() {
        return R.layout.activity_shipping_address;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new EditProfilePresenter(this);
        this.nsv.setVisibility(8);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.shipping_address));
        this.presenter.requestCountry();
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
            this.presenter.updateShippingAddress(trim, trim2, trim3, trim4, trim5, this.countryId, this.cityId, trim6, trim7, this.userDetails.get(0));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }

    public void showUpdateSuccess(String str) {
        showSuccess(ResourceUtils.getString(R.string.dialog_title_success), str, true);
    }

    public void showResult(List<CountryDetail> list, AccountDetailResult accountDetailResult) {
        if (list.size() > 0) {
            this.countryId = ConversionUtils.parseString(list.get(0).getCountryId().intValue());
            this.etCountry.setText(list.get(0).getCountryName());
            if (list.get(0).getCityDetails().size() > 0) {
                this.cityId = ConversionUtils.parseString(list.get(0).getCityDetails().get(0).getCityId().intValue());
                this.etCity.setText(list.get(0).getCityDetails().get(0).getCityName());
            }
        }
        new AutoSpinner(this.etCountry, list).setListener(new AutoSpinner.Listener(list) {
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void onSelectItem(int i) {
                ShippingDetails.this.lambda$showResult$1$ShippingDetails(this.f$1, i);
            }
        });
        this.userDetails = accountDetailResult.getUserDetails();
        this.shippingDetails = accountDetailResult.getShippingDetails();
        setShippingDetails(accountDetailResult.getShippingDetails());
    }

    public /* synthetic */ void lambda$showResult$1$ShippingDetails(List list, int i) {
        this.countryId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCountryId().intValue());
        new AutoSpinner(this.etCity, ((CountryDetail) list.get(i)).getCityDetails()).setListener(new AutoSpinner.Listener(list, i) {
            private final /* synthetic */ List f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onSelectItem(int i) {
                ShippingDetails.this.lambda$null$0$ShippingDetails(this.f$1, this.f$2, i);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$ShippingDetails(List list, int i, int i2) {
        this.cityId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCityDetails().get(i2).getCityId().intValue());
    }

    private void setShippingDetails(ArrayList<ShippingDetail> arrayList) {
        this.nsv.setVisibility(0);
        if (arrayList.size() > 0) {
            this.etUserName.setText(arrayList.get(0).getShipName());
            this.etPhone.setText(arrayList.get(0).getShipPhone());
            this.etEmail.setText(arrayList.get(0).getShipEmail());
            this.etBuildingName.setText(arrayList.get(0).getShipAddress1());
            this.etLocality.setText(arrayList.get(0).getShipAddress2());
            this.etCountry.setText(arrayList.get(0).getShipCountryName());
            this.etCity.setText(arrayList.get(0).getShipCityName());
            this.cityId = arrayList.get(0).getShipCityId();
            this.countryId = arrayList.get(0).getShipCountryId();
            this.etState.setText(arrayList.get(0).getShipState());
            this.etPinCode.setText(arrayList.get(0).getShipPostalcode());
        }
    }
}
