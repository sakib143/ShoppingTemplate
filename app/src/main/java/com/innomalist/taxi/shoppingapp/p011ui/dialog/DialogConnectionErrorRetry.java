package com.innomalist.taxi.shoppingapp.p011ui.dialog;

//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
//import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.base.BaseDialogFragment;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogConnectionErrorRetry */
public class DialogConnectionErrorRetry extends BaseDialogFragment {
    RetryListener retryListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogConnectionErrorRetry$RetryListener */
    public interface RetryListener {
        void onClickRetry();
    }

    public static DialogConnectionErrorRetry newInstance(BaseActivity baseActivity) {
        DialogConnectionErrorRetry dialogConnectionErrorRetry = new DialogConnectionErrorRetry();
        dialogConnectionErrorRetry.setActivity(baseActivity);
        dialogConnectionErrorRetry.setCancelable(false);
        return dialogConnectionErrorRetry;
    }

    public void show(String str, RetryListener retryListener2) {
        this.retryListener = retryListener2;
        setTitle(ResourceUtils.getString(R.string.dialog_title_connection_error));
        setPositive(ResourceUtils.getString(R.string.dialog_btn_retry));
        setNegative(ResourceUtils.getString(R.string.dialog_btn_exit));
        setMessage(str);
        show();
    }

    public void onClickPositive() {
        dismiss();
        this.retryListener.onClickRetry();
    }

    public void onClickNegative() {
        this.baseActivity.finish();
    }
}
