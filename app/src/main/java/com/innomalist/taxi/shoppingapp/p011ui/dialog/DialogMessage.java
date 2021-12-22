package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogMessage */
public class DialogMessage extends BaseSheetFragment {
    private static final String HINT = "hint";
    @BindView(2131362013)
    EditText etMessage;
    MessageListener messageListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogMessage$MessageListener */
    public interface MessageListener {
        void onSubmitMessage(String str);
    }

    public static DialogMessage newInstance(Context context, String str, String str2, String str3) {
        DialogMessage dialogMessage = new DialogMessage();
        dialogMessage.setTitle(str);
        dialogMessage.setActivity((BaseActivity) context);
        dialogMessage.setCustomLayout(R.layout.dialog_message);
        Bundle bundle = new Bundle();
        bundle.putString(HINT, str3);
        dialogMessage.setArguments(bundle);
        dialogMessage.setPositive(str2);
        return dialogMessage;
    }

    public void setClickListener(MessageListener messageListener2) {
        this.messageListener = messageListener2;
    }

    public DialogMessage show(MessageListener messageListener2) {
        this.messageListener = messageListener2;
        show();
        return this;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null) {
            this.etMessage.setHint(getArguments().getString(HINT));
        }
    }

    public void onClickPositive() {
        if (this.etMessage.getText().toString().trim().isEmpty()) {
            showToast(ResourceUtils.getString(R.string.warning_empty_message));
            return;
        }
        hideKeyboard();
        this.messageListener.onSubmitMessage(this.etMessage.getText().toString().trim());
        dismiss();
    }
}
