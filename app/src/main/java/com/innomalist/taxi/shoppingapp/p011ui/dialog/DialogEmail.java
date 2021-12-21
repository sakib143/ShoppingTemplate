package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.util.Patterns;
import android.widget.EditText;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogEmail */
public class DialogEmail extends BaseDialogFragment {
    EmailListener emailListener;
    @BindView(2131362010)
    EditText etEmail;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogEmail$EmailListener */
    public interface EmailListener {
        void onSubmitEmail(String str);
    }

    public static DialogEmail newInstance(BaseActivity baseActivity) {
        DialogEmail dialogEmail = new DialogEmail();
        dialogEmail.setCustomLayout(R.layout.dialog_email);
        dialogEmail.setActivity(baseActivity);
        dialogEmail.setTitle(ResourceUtils.getString(R.string.dialog_title_email));
        dialogEmail.setMessage(ResourceUtils.getString(R.string.dialog_message_email));
        dialogEmail.setPositive(ResourceUtils.getString(R.string.dialog_btn_submit));
        dialogEmail.setNegative(ResourceUtils.getString(R.string.dialog_btn_cancel));
        dialogEmail.setCanceledOnTouchOutside(true);
        return dialogEmail;
    }

    public void show(EmailListener emailListener2) {
        this.emailListener = emailListener2;
        show();
    }

    public void onClickPositive() {
        if (this.etEmail.getText().toString().trim().isEmpty()) {
            showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(this.etEmail.getText().toString().trim()).matches()) {
            showToast(ResourceUtils.getString(R.string.warning_valid_email));
        } else {
            this.emailListener.onSubmitEmail(this.etEmail.getText().toString().trim());
        }
    }

    public void onClickNegative() {
        dismiss();
    }
}
