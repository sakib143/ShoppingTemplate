package com.kiandashopping.kiandashopping.p011ui.dialog;

import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogWarning */
public class DialogWarning extends BaseDialogFragment {
    boolean isFinish;

    public static DialogWarning newInstance(BaseActivity baseActivity) {
        DialogWarning dialogWarning = new DialogWarning();
        dialogWarning.setActivity(baseActivity);
        return dialogWarning;
    }

    public void show(String str, boolean z) {
        this.isFinish = z;
        setTitle(ResourceUtils.getString(R.string.dialog_title_warning));
        setPositive(ResourceUtils.getString(R.string.dialog_btn_ok));
        setMessage(str);
        show();
    }

    public void show(String str, String str2, boolean z) {
        this.isFinish = z;
        setTitle(str);
        setPositive(ResourceUtils.getString(R.string.dialog_btn_ok));
        setMessage(str2);
        show();
    }

    public void onClickPositive() {
        dismiss();
        if (this.isFinish) {
            this.baseActivity.finish();
        }
    }
}
