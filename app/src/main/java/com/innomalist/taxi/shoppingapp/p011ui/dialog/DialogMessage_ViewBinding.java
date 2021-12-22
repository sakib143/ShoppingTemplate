package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.view.View;
import android.widget.EditText;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogMessage_ViewBinding */
public class DialogMessage_ViewBinding extends BaseSheetFragment_ViewBinding {
    private DialogMessage target;

    public DialogMessage_ViewBinding(DialogMessage dialogMessage, View view) {
        super(dialogMessage, view);
        this.target = dialogMessage;
        dialogMessage.etMessage = (EditText) Utils.findRequiredViewAsType(view, R.id.etMessage, "field 'etMessage'", EditText.class);
    }

    public void unbind() {
        DialogMessage dialogMessage = this.target;
        if (dialogMessage != null) {
            this.target = null;
            dialogMessage.etMessage = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
