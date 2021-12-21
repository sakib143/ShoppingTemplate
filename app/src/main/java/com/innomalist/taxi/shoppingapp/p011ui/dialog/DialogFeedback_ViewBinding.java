package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.view.View;
import android.widget.EditText;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogFeedback_ViewBinding */
public class DialogFeedback_ViewBinding extends BaseSheetFragment_ViewBinding {
    private DialogFeedback target;

    public DialogFeedback_ViewBinding(DialogFeedback dialogFeedback, View view) {
        super(dialogFeedback, view);
        this.target = dialogFeedback;
        dialogFeedback.etMessage = (EditText) Utils.findRequiredViewAsType(view, R.id.etMessage, "field 'etMessage'", EditText.class);
    }

    public void unbind() {
        DialogFeedback dialogFeedback = this.target;
        if (dialogFeedback != null) {
            this.target = null;
            dialogFeedback.etMessage = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
