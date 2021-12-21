package com.kiandashopping.kiandashopping.cardutils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class CreditCardTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private final TextWatcherListener mListener;

    public interface TextWatcherListener {
        void onTextChanged(EditText editText, String str);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CreditCardTextWatcher(EditText editText, TextWatcherListener textWatcherListener) {
        this.mEditText = editText;
        this.mListener = textWatcherListener;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mListener.onTextChanged(this.mEditText, charSequence.toString());
    }
}
