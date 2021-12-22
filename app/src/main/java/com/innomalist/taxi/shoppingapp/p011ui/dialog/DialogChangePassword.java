package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
//import com.apptube.ecommerce.R;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogChangePassword */
public class DialogChangePassword extends BaseSheetFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @BindView(2131362007)
    EditText etConfirmPassword;
    @BindView(2131362016)
    EditText etNewPassword;
    @BindView(2131362018)
    EditText etOldPassword;
    MessageListener messageListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogChangePassword$MessageListener */
    public interface MessageListener {
        void onSubmitMessage(String str, String str2);
    }

    public static DialogChangePassword newInstance(Context context, String str, String str2) {
        DialogChangePassword dialogChangePassword = new DialogChangePassword();
        dialogChangePassword.setTitle(str);
        dialogChangePassword.setCustomLayout(R.layout.dialog_change_password);
        dialogChangePassword.setArguments(new Bundle());
        dialogChangePassword.setPositive(str2);
        return dialogChangePassword;
    }

    public void setClickListener(MessageListener messageListener2) {
        this.messageListener = messageListener2;
    }

    public void show(MessageListener messageListener2) {
        this.messageListener = messageListener2;
        show();
    }

    public void onClickPositive() {
        int i = ResourceUtils.getInt(R.integer.passwordLengthMin);
        if (this.etOldPassword.getText().toString().trim().isEmpty()) {
            showToast(ResourceUtils.getString(R.string.warning_empty_old_password));
        } else if (this.etOldPassword.length() < i) {
            showToast(ResourceUtils.getString(R.string.warning_length_password, Integer.valueOf(i)));
        } else if (this.etNewPassword.getText().toString().trim().isEmpty()) {
            showToast(ResourceUtils.getString(R.string.warning_empty_new_password));
        } else if (this.etNewPassword.length() < i) {
            showToast(ResourceUtils.getString(R.string.warning_length_password));
        } else if (this.etConfirmPassword.getText().toString().trim().isEmpty()) {
            showToast(ResourceUtils.getString(R.string.warning_empty_confirm_password));
        } else if (!this.etConfirmPassword.getText().toString().equals(this.etNewPassword.getText().toString())) {
            showToast(ResourceUtils.getString(R.string.warning_password_mismatch));
        } else {
            hideKeyboard();
            this.messageListener.onSubmitMessage(this.etOldPassword.getText().toString().trim(), this.etNewPassword.getText().toString().trim());
            dismiss();
        }
    }

    public void hideKeyboard() {
        View currentFocus = ((FragmentActivity) Objects.requireNonNull(getActivity())).getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
