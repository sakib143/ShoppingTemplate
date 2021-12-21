package com.kiandashopping.kiandashopping.p011ui.verifyotp.activity;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.verifyotp.activity.VerifyOtp_ViewBinding */
public class VerifyOtp_ViewBinding implements Unbinder {
    private VerifyOtp target;
    private View view7f0a007a;

    public VerifyOtp_ViewBinding(VerifyOtp verifyOtp) {
        this(verifyOtp, verifyOtp.getWindow().getDecorView());
    }

    public VerifyOtp_ViewBinding(final VerifyOtp verifyOtp, View view) {
        this.target = verifyOtp;
        verifyOtp.etOTP = (EditText) Utils.findRequiredViewAsType(view, R.id.etOTP, "field 'etOTP'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnVerify, "method 'onClickVerify'");
        this.view7f0a007a = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                verifyOtp.onClickVerify();
            }
        });
    }

    public void unbind() {
        VerifyOtp verifyOtp = this.target;
        if (verifyOtp != null) {
            this.target = null;
            verifyOtp.etOTP = null;
            this.view7f0a007a.setOnClickListener((View.OnClickListener) null);
            this.view7f0a007a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
