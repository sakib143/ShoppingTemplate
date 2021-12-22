package com.innomalist.taxi.shoppingapp.p011ui.forgotpassword.activity;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;

import com.innomalist.taxi.shoppingapp.R;

import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.forgotpassword.activity.ForgotPassword_ViewBinding */
public class ForgotPassword_ViewBinding implements Unbinder {
    private ForgotPassword target;
    private View view7f0a0076;

    public ForgotPassword_ViewBinding(ForgotPassword forgotPassword) {
        this(forgotPassword, forgotPassword.getWindow().getDecorView());
    }

    public ForgotPassword_ViewBinding(final ForgotPassword forgotPassword, View view) {
        this.target = forgotPassword;
        forgotPassword.etEmail = (AppCompatEditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", AppCompatEditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnSubmit, "method 'setBtnSend'");
        this.view7f0a0076 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                forgotPassword.setBtnSend();
            }
        });
    }

    public void unbind() {
        ForgotPassword forgotPassword = this.target;
        if (forgotPassword != null) {
            this.target = null;
            forgotPassword.etEmail = null;
            this.view7f0a0076.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0076 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
