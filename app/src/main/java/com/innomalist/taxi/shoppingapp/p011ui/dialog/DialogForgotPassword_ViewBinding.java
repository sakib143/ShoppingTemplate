package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.view.View;
import android.widget.EditText;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogForgotPassword_ViewBinding */
public class DialogForgotPassword_ViewBinding extends BaseDialogFragment_ViewBinding {
    private DialogForgotPassword target;

    public DialogForgotPassword_ViewBinding(DialogForgotPassword dialogForgotPassword, View view) {
        super(dialogForgotPassword, view);
        this.target = dialogForgotPassword;
        dialogForgotPassword.etEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", EditText.class);
    }

    public void unbind() {
        DialogForgotPassword dialogForgotPassword = this.target;
        if (dialogForgotPassword != null) {
            this.target = null;
            dialogForgotPassword.etEmail = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
