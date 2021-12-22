package com.innomalist.taxi.shoppingapp.p011ui.dialog;

//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
//import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.base.BaseDialogFragment;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogExit */
public class DialogExit extends BaseDialogFragment {
    public static DialogExit newInstance(BaseActivity baseActivity) {
        DialogExit dialogExit = new DialogExit();
        dialogExit.setActivity(baseActivity);
        return dialogExit;
    }

    public void show() {
        setTitle(ResourceUtils.getString(R.string.dialog_title_exit));
        setMessage(ResourceUtils.getString(R.string.dialog_message_exit));
        setPositive(ResourceUtils.getString(R.string.dialog_btn_exit));
        setNegative(ResourceUtils.getString(R.string.dialog_btn_cancel));
        super.show();
    }

    public void onClickPositive() {
        dismiss();
        this.baseActivity.finish();
    }

    public void onClickNegative() {
        dismiss();
    }
}
