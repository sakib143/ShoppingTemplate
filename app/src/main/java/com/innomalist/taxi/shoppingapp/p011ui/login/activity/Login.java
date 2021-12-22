package com.innomalist.taxi.shoppingapp.p011ui.login.activity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.p011ui.forgotpassword.activity.ForgotPassword;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.p011ui.forgotpassword.activity.ForgotPassword;
import com.innomalist.taxi.shoppingapp.p011ui.login.mvp.LoginContractor;
import com.kiandashopping.kiandashopping.p011ui.login.SocialActivity;
//import com.kiandashopping.kiandashopping.p011ui.login.mvp.LoginContractor;
import com.kiandashopping.kiandashopping.p011ui.login.mvp.LoginPresenter;
import com.kiandashopping.kiandashopping.p011ui.register.activity.Register;

/* renamed from: com.kiandashopping.kiandashopping.ui.login.activity.Login */
public class Login extends SocialActivity implements LoginContractor.View {
    @BindView(2131361903)
    Button btnLogin;
    @BindView(2131362010)
    EditText etEmail;
    @BindView(2131362019)
    EditText etPassword;
    LoginPresenter presenter;
    @BindView(2131362049)
    TextView tvForgotPassword;

    public int getLayout() {
        return R.layout.activity_login;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new LoginPresenter(this);
        this.etPassword.setTransformationMethod(new PasswordTransformationMethod());
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    @OnClick({2131361917})
    public void onClickFb() {
        onClickFaceBook();
    }

    public void onSocialLoginSuccess(String str, String str2, String str3, String str4, String str5) {
        Log.i("Social VerifyOtp", "onSocialLoginSuccess: " + str + str2 + str3 + str4 + str5);
        if (str5.equals(SocialActivity.FACEBOOK)) {
            this.presenter.requestLoginFB(str2, str4, str);
        }
    }

    @OnClick({2131361903})
    public void onClickLogin() {
        this.presenter.requestLogin(this.etEmail.getText().toString().trim(), this.etPassword.getText().toString().trim());
    }

    @OnClick({2131362049})
    public void forgotPassword() {
        changeActivity(ForgotPassword.class);
    }

    @OnClick({2131362233})
    public void register() {
        changeActivity(Register.class);
    }

    public void showLoginSuccess() {
        finish();
        openDashBoard(1);
    }
}
