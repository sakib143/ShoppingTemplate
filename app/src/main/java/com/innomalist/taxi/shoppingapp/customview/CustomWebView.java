package com.kiandashopping.kiandashopping.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class CustomWebView extends WebView {
    public boolean onCheckIsTextEditor() {
        return true;
    }

    public CustomWebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if ((action == 0 || action == 1) && !hasFocus()) {
            requestFocus();
        }
        return super.onTouchEvent(motionEvent);
    }
}
