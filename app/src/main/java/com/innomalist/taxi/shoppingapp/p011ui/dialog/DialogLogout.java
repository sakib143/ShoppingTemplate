package com.kiandashopping.kiandashopping.p011ui.dialog;

import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogLogout */
public class DialogLogout extends BaseDialogFragment {
    LogoutListener retryListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogLogout$LogoutListener */
    public interface LogoutListener {
        void onClickLogout();
    }

    public static DialogLogout newInstance(BaseActivity baseActivity) {
        DialogLogout dialogLogout = new DialogLogout();
        dialogLogout.setActivity(baseActivity);
        return dialogLogout;
    }

    public void show(LogoutListener logoutListener) {
        this.retryListener = logoutListener;
        setTitle(ResourceUtils.getString(R.string.dialog_title_logout));
        setPositive(ResourceUtils.getString(R.string.dialog_btn_logout));
        setNegative(ResourceUtils.getString(R.string.dialog_btn_cancel));
        setMessage(ResourceUtils.getString(R.string.dialog_message_logout));
        show();
    }

    public void onClickPositive() {
        dismiss();
        this.retryListener.onClickLogout();
    }

    public void onClickNegative() {
        dismiss();
    }
}
