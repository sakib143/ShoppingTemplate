package com.kiandashopping.kiandashopping.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.viewpager.widget.ViewPager;

public class WrappingViewPager extends ViewPager {
    private int mCurrentPagePosition = 0;

    public WrappingViewPager(Context context) {
        super(context);
    }

    public WrappingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View childAt;
        try {
            if ((View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) && (childAt = getChildAt(this.mCurrentPagePosition)) != null) {
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                i2 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), BasicMeasure.EXACTLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onMeasure(i, i2);
    }

    public void reMeasureCurrentPage(int i) {
        this.mCurrentPagePosition = i;
        requestLayout();
    }
}
