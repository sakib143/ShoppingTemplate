package com.kiandashopping.kiandashopping.p011ui.verifyotp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.model.register.RequestRegister;
import com.kiandashopping.kiandashopping.p011ui.verifyotp.mvp.VerifyOtpContractor;
import com.kiandashopping.kiandashopping.p011ui.verifyotp.mvp.VerifyOtpPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.activity.VerifyOtp */
public class VerifyOtp extends BaseActivity implements VerifyOtpContractor.View {
    private static final String ARG_REGISTER_DETAILS = "registerDetails";
    @BindView(2131362017)
    EditText etOTP;
    VerifyOtpPresenter presenter;
    RequestRegister requestRegister;

    public int getLayout() {
        return R.layout.activity_otp;
    }

    public static Intent builtIntent(Activity activity, RequestRegister requestRegister2) {
        Intent intent = new Intent(activity, VerifyOtp.class);
        intent.putExtra(ARG_REGISTER_DETAILS, requestRegister2);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new VerifyOtpPresenter(this);
        this.requestRegister = AppUtils.getRegisterDetails(getIntent(), ARG_REGISTER_DETAILS);
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    @OnClick({2131361914})
    public void onClickVerify() {
        this.presenter.requestOrp(this.requestRegister, this.etOTP.getText().toString().trim());
    }

    public void showLoginSuccess() {
        finish();
        openDashBoard(1);
    }
}
