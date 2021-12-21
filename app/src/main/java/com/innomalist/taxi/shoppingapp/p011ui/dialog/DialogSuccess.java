package com.kiandashopping.kiandashopping.p011ui.dialog;

import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogSuccess */
public class DialogSuccess extends BaseDialogFragment {
    Listener listener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogSuccess$Listener */
    public interface Listener {
        void onClickPositive();
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public static DialogSuccess newInstance(BaseActivity baseActivity, String str, String str2) {
        DialogSuccess dialogSuccess = new DialogSuccess();
        dialogSuccess.setActivity(baseActivity);
        dialogSuccess.setTitle(str);
        dialogSuccess.setMessage(str2);
        dialogSuccess.setPositive(ResourceUtils.getString(R.string.dialog_btn_ok));
        return dialogSuccess;
    }

    public void onClickPositive() {
        dismiss();
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onClickPositive();
        }
    }

    public void onClickNegative() {
        dismiss();
    }
}
