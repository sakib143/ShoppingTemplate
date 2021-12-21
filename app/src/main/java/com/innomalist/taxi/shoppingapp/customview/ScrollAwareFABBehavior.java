package com.kiandashopping.kiandashopping.customview;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, int i, int i2, int i3, int i4, int i5) {
        super.onNestedScroll(coordinatorLayout, floatingActionButton, view, i, i2, i3, i4, i5);
        if (i2 > 0 && floatingActionButton.getVisibility() == 0) {
            floatingActionButton.hide();
        } else if (i2 < 0 && floatingActionButton.getVisibility() != 0) {
            floatingActionButton.show();
        }
    }
}
