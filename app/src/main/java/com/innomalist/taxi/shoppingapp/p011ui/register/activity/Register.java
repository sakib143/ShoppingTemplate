package com.kiandashopping.kiandashopping.p011ui.register.activity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.customview.AutoSpinner;
import com.kiandashopping.kiandashopping.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.model.register.RequestRegister;
import com.kiandashopping.kiandashopping.p011ui.register.mvp.RegisterContractor;
import com.kiandashopping.kiandashopping.p011ui.register.mvp.RegisterPresenter;
import com.kiandashopping.kiandashopping.p011ui.verifyotp.activity.VerifyOtp;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.register.activity.Register */
public class Register extends BaseActivity implements RegisterContractor.View {
    @BindView(2131361931)
    CheckBox checkbox;
    String cityId = "";
    String countryId = "";
    @BindView(2131362006)
    AppCompatAutoCompleteTextView etCity;
    @BindView(2131362007)
    EditText etConfirmPassword;
    @BindView(2131362008)
    AppCompatAutoCompleteTextView etCountry;
    @BindView(2131362010)
    EditText etEmail;
    @BindView(2131362019)
    EditText etPassword;
    @BindView(2131362020)
    EditText etPhone;
    @BindView(2131362026)
    EditText etUserName;
    RegisterPresenter presenter;

    public int getLayout() {
        return R.layout.activity_register;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new RegisterPresenter(this);
        this.etConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());
        this.etPassword.setTransformationMethod(new PasswordTransformationMethod());
        this.presenter.requestCountry();
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    @OnClick({2131362233})
    public void onClickLogin() {
        finish();
    }

    @OnClick({2131361909})
    public void onClickSignUp() {
        this.presenter.requestRegister(this.etUserName.getText().toString().trim(), this.etEmail.getText().toString().trim(), this.etPhone.getText().toString().trim(), this.etPassword.getText().toString().trim(), this.etConfirmPassword.getText().toString().trim(), this.countryId, this.cityId, this.checkbox.isChecked());
    }

    public void showResultOtp(RequestRegister requestRegister) {
        finish();
        changeActivity(VerifyOtp.builtIntent(this, requestRegister));
    }

    public void showResultSuccess() {
        finish();
        openDashBoard(1);
    }

    public void showCountryList(List<CountryDetail> list) {
        new AutoSpinner(this.etCountry, list).setListener(new AutoSpinner.Listener(list) {
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void onSelectItem(int i) {
                Register.this.lambda$showCountryList$1$Register(this.f$1, i);
            }
        });
    }

    public /* synthetic */ void lambda$showCountryList$1$Register(List list, int i) {
        this.countryId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCountryId().intValue());
        new AutoSpinner(this.etCity, ((CountryDetail) list.get(i)).getCityDetails()).setListener(new AutoSpinner.Listener(list, i) {
            private final /* synthetic */ List f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onSelectItem(int i) {
                Register.this.lambda$null$0$Register(this.f$1, this.f$2, i);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$Register(List list, int i, int i2) {
        this.cityId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCityDetails().get(i2).getCityId().intValue());
    }
}
