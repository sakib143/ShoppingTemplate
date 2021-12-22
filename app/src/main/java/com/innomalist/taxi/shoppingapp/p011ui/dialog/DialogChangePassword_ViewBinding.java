package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.view.View;
import android.widget.EditText;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.innomalist.taxi.shoppingapp.R;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogChangePassword_ViewBinding */
public class DialogChangePassword_ViewBinding extends BaseSheetFragment_ViewBinding {
    private DialogChangePassword target;

    public DialogChangePassword_ViewBinding(DialogChangePassword dialogChangePassword, View view) {
        super(dialogChangePassword, view);
        this.target = dialogChangePassword;
        dialogChangePassword.etOldPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.etOldPassword, "field 'etOldPassword'", EditText.class);
        dialogChangePassword.etNewPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.etNewPassword, "field 'etNewPassword'", EditText.class);
        dialogChangePassword.etConfirmPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.etConfirmPassword, "field 'etConfirmPassword'", EditText.class);
    }

    public void unbind() {
        DialogChangePassword dialogChangePassword = this.target;
        if (dialogChangePassword != null) {
            this.target = null;
            dialogChangePassword.etOldPassword = null;
            dialogChangePassword.etNewPassword = null;
            dialogChangePassword.etConfirmPassword = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
