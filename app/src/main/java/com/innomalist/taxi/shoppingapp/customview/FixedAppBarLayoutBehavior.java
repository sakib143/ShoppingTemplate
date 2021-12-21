package com.kiandashopping.kiandashopping.customview;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;

public class FixedAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public FixedAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            public boolean canDrag(AppBarLayout appBarLayout) {
                return false;
            }
        });
    }
}
