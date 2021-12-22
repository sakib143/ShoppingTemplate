package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.view.View;
import android.widget.EditText;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogEmail_ViewBinding */
public class DialogEmail_ViewBinding extends BaseDialogFragment_ViewBinding {
    private DialogEmail target;

    public DialogEmail_ViewBinding(DialogEmail dialogEmail, View view) {
        super(dialogEmail, view);
        this.target = dialogEmail;
        dialogEmail.etEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", EditText.class);
    }

    public void unbind() {
        DialogEmail dialogEmail = this.target;
        if (dialogEmail != null) {
            this.target = null;
            dialogEmail.etEmail = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
