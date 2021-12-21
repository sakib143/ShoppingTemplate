package com.kiandashopping.kiandashopping.p011ui.dialog;

import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogConnectionError */
public class DialogConnectionError extends BaseDialogFragment {
    boolean isFinish;

    public static DialogConnectionError newInstance(BaseActivity baseActivity) {
        DialogConnectionError dialogConnectionError = new DialogConnectionError();
        dialogConnectionError.setActivity(baseActivity);
        dialogConnectionError.setCancelable(false);
        return dialogConnectionError;
    }

    public void show(String str, boolean z) {
        this.isFinish = z;
        setTitle(ResourceUtils.getString(R.string.dialog_title_connection_error));
        setPositive(ResourceUtils.getString(R.string.dialog_btn_ok));
        setMessage(str);
        show();
    }

    public void onClickPositive() {
        dismiss();
        if (this.isFinish) {
            this.baseActivity.finish();
        }
    }
}
