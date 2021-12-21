package com.kiandashopping.kiandashopping.p011ui.login.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.login.activity.Login_ViewBinding */
public class Login_ViewBinding implements Unbinder {
    private Login target;
    private View view7f0a006f;
    private View view7f0a007d;
    private View view7f0a0101;
    private View view7f0a01b9;

    public Login_ViewBinding(Login login) {
        this(login, login.getWindow().getDecorView());
    }

    public Login_ViewBinding(final Login login, View view) {
        this.target = login;
        login.etEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", EditText.class);
        login.etPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.etPassword, "field 'etPassword'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.forgotPassword, "field 'tvForgotPassword' and method 'forgotPassword'");
        login.tvForgotPassword = (TextView) Utils.castView(findRequiredView, R.id.forgotPassword, "field 'tvForgotPassword'", TextView.class);
        this.view7f0a0101 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                login.forgotPassword();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnLogin, "field 'btnLogin' and method 'onClickLogin'");
        login.btnLogin = (Button) Utils.castView(findRequiredView2, R.id.btnLogin, "field 'btnLogin'", Button.class);
        this.view7f0a006f = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                login.onClickLogin();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.button_facebook_login, "method 'onClickFb'");
        this.view7f0a007d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                login.onClickFb();
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.registerButton, "method 'register'");
        this.view7f0a01b9 = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                login.register();
            }
        });
    }

    public void unbind() {
        Login login = this.target;
        if (login != null) {
            this.target = null;
            login.etEmail = null;
            login.etPassword = null;
            login.tvForgotPassword = null;
            login.btnLogin = null;
            this.view7f0a0101.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0101 = null;
            this.view7f0a006f.setOnClickListener((View.OnClickListener) null);
            this.view7f0a006f = null;
            this.view7f0a007d.setOnClickListener((View.OnClickListener) null);
            this.view7f0a007d = null;
            this.view7f0a01b9.setOnClickListener((View.OnClickListener) null);
            this.view7f0a01b9 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
