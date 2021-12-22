package com.innomalist.taxi.shoppingapp.p011ui.forgotpassword.activity;

import android.os.Bundle;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.OnClick;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.p011ui.forgotpassword.mvp.ForgotPasswordContractor;
import com.innomalist.taxi.shoppingapp.p011ui.forgotpassword.mvp.ForgotPasswordPresenter;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
//import com.kiandashopping.kiandashopping.p011ui.forgotpassword.mvp.ForgotPasswordContractor;
//import com.kiandashopping.kiandashopping.p011ui.forgotpassword.mvp.ForgotPasswordPresenter;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.activity.ForgotPassword */
public class ForgotPassword extends BaseActivity implements ForgotPasswordContractor.View {
    @BindView(2131362010)
    AppCompatEditText etEmail;
    ForgotPasswordPresenter forgotPasswordPresenter;

    public int getLayout() {
        return R.layout.activity_forgot_password;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.forgotPasswordPresenter = new ForgotPasswordPresenter(this);
    }

    @OnClick({2131361910})
    public void setBtnSend() {
        hideKeyboard();
        this.forgotPasswordPresenter.forgotPasswordClicked(this.etEmail.getText().toString().trim());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.forgotPasswordPresenter.close();
    }

    public void showForgotPasswordSuccess(String str) {
        showSuccess(ResourceUtils.getString(R.string.for_ur_information), str, true);
    }

    public void showForgotPasswordError(String str) {
        this.etEmail.setText("");
        showToast(str);
    }

    public void showError(String str) {
        this.etEmail.setText("");
        showToast(str);
    }

    public PresenterInterface getPresenterInterface() {
        return this.forgotPasswordPresenter;
    }
}
