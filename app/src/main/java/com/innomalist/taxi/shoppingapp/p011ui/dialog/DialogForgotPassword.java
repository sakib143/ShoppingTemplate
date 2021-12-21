package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.widget.EditText;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import com.kiandashopping.kiandashopping.util.ValidationUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogForgotPassword */
public class DialogForgotPassword extends BaseDialogFragment {
    EmailListener emailListener;
    @BindView(2131362010)
    EditText etEmail;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogForgotPassword$EmailListener */
    public interface EmailListener {
        void onSubmitEmail(String str);
    }

    public static DialogForgotPassword newInstance(BaseActivity baseActivity) {
        DialogForgotPassword dialogForgotPassword = new DialogForgotPassword();
        dialogForgotPassword.setCustomLayout(R.layout.dialog_email);
        dialogForgotPassword.setActivity(baseActivity);
        dialogForgotPassword.setTitle(ResourceUtils.getString(R.string.dialog_title_forgot_password));
        dialogForgotPassword.setPositive(ResourceUtils.getString(R.string.dialog_btn_submit));
        return dialogForgotPassword;
    }

    public void show(EmailListener emailListener2) {
        this.emailListener = emailListener2;
        show();
    }

    public void onClickPositive() {
        if (this.etEmail.getText().toString().trim().isEmpty()) {
            showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (!ValidationUtils.isValidEmail(this.etEmail.getText().toString().trim())) {
            showToast(ResourceUtils.getString(R.string.warning_valid_email));
        } else {
            this.emailListener.onSubmitEmail(this.etEmail.getText().toString().trim());
        }
    }
}
