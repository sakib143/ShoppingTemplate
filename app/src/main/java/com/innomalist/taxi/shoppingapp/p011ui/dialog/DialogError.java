package com.innomalist.taxi.shoppingapp.p011ui.dialog;

//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
//import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.base.BaseDialogFragment;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogError */
public class DialogError extends BaseDialogFragment {
    boolean isFinish;

    public static DialogError newInstance(BaseActivity baseActivity) {
        DialogError dialogError = new DialogError();
        dialogError.setActivity(baseActivity);
        return dialogError;
    }

    public void show(String str, boolean z) {
        this.isFinish = z;
        setTitle(ResourceUtils.getString(R.string.dialog_title_error));
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
