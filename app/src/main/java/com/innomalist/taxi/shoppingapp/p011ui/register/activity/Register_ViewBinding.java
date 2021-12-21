package com.kiandashopping.kiandashopping.p011ui.register.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.register.activity.Register_ViewBinding */
public class Register_ViewBinding implements Unbinder {
    private Register target;
    private View view7f0a0075;
    private View view7f0a01b9;

    public Register_ViewBinding(Register register) {
        this(register, register.getWindow().getDecorView());
    }

    public Register_ViewBinding(final Register register, View view) {
        this.target = register;
        register.etUserName = (EditText) Utils.findRequiredViewAsType(view, R.id.etUserName, "field 'etUserName'", EditText.class);
        register.etEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", EditText.class);
        register.etPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.etPhone, "field 'etPhone'", EditText.class);
        register.etPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.etPassword, "field 'etPassword'", EditText.class);
        register.etConfirmPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.etConfirmPassword, "field 'etConfirmPassword'", EditText.class);
        register.etCountry = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCountry, "field 'etCountry'", AppCompatAutoCompleteTextView.class);
        register.etCity = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCity, "field 'etCity'", AppCompatAutoCompleteTextView.class);
        register.checkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.checkbox, "field 'checkbox'", CheckBox.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.registerButton, "method 'onClickLogin'");
        this.view7f0a01b9 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                register.onClickLogin();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnSignUp, "method 'onClickSignUp'");
        this.view7f0a0075 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                register.onClickSignUp();
            }
        });
    }

    public void unbind() {
        Register register = this.target;
        if (register != null) {
            this.target = null;
            register.etUserName = null;
            register.etEmail = null;
            register.etPhone = null;
            register.etPassword = null;
            register.etConfirmPassword = null;
            register.etCountry = null;
            register.etCity = null;
            register.checkbox = null;
            this.view7f0a01b9.setOnClickListener((View.OnClickListener) null);
            this.view7f0a01b9 = null;
            this.view7f0a0075.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0075 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
