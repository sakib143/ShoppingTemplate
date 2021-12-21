package com.kiandashopping.kiandashopping.p011ui.dialog;

import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogDelete */
public class DialogDelete extends BaseDialogFragment {
    Listener listener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogDelete$Listener */
    public interface Listener {
        void onClickDelete();
    }

    public static DialogDelete newInstance(BaseActivity baseActivity) {
        DialogDelete dialogDelete = new DialogDelete();
        dialogDelete.setActivity(baseActivity);
        dialogDelete.setTitle(ResourceUtils.getString(R.string.dialog_title_delete));
        dialogDelete.setMessage(ResourceUtils.getString(R.string.dialog_message_delete));
        dialogDelete.setPositive(ResourceUtils.getString(R.string.dialog_btn_delete));
        dialogDelete.setCanceledOnTouchOutside(true);
        return dialogDelete;
    }

    public DialogDelete show(Listener listener2) {
        this.listener = listener2;
        super.show();
        return this;
    }

    public void onClickPositive() {
        this.listener.onClickDelete();
    }

    public void onClickNegative() {
        dismiss();
    }
}
