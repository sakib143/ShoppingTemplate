package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogFeedback */
public class DialogFeedback extends BaseSheetFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String HINT = "hint";
    @BindView(2131362013)
    EditText etMessage;
    MessageListener messageListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogFeedback$MessageListener */
    public interface MessageListener {
        void onSubmitMessage(String str);
    }

    public static DialogFeedback newInstance(Context context, String str, String str2, String str3) {
        DialogFeedback dialogFeedback = new DialogFeedback();
        dialogFeedback.setTitle(str);
        dialogFeedback.setActivity((BaseActivity) context);
        dialogFeedback.setCustomLayout(R.layout.dialog_message);
        Bundle bundle = new Bundle();
        bundle.putString(HINT, str3);
        dialogFeedback.setArguments(bundle);
        dialogFeedback.setPositive(str2);
        return dialogFeedback;
    }

    public void setClickListener(MessageListener messageListener2) {
        this.messageListener = messageListener2;
    }

    public DialogFeedback show(MessageListener messageListener2) {
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
    }

    public void hideKeyboard() {
        View currentFocus = ((FragmentActivity) Objects.requireNonNull(getActivity())).getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
