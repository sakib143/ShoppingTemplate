package com.kiandashopping.kiandashopping.customview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Field;

public class DragMarginDrawerLayout extends DrawerLayout {
    private Context mContext;

    public DragMarginDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        disablePeekOnEdgeTouch();
    }

    private void disablePeekOnEdgeTouch() {
        try {
            Field declaredField = getDeclaredField("mLeftCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = obj.getClass().getDeclaredField("mPeekRunnable");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, (Object) null);
            Field declaredField3 = getDeclaredField("mRightCallback");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(this);
            Field declaredField4 = obj2.getClass().getDeclaredField("mPeekRunnable");
            declaredField4.setAccessible(true);
            declaredField4.set(obj2, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDrawerEdgeSize(int i, boolean z) {
        try {
            Field declaredField = getDeclaredField(z ? "mLeftDragger" : "mRightDragger");
            declaredField.setAccessible(true);
            ViewDragHelper viewDragHelper = (ViewDragHelper) declaredField.get(this);
            Field declaredField2 = viewDragHelper.getClass().getDeclaredField("mEdgeSize");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(viewDragHelper);
            int i3 = Resources.getSystem().getDisplayMetrics().widthPixels;
            declaredField2.setInt(viewDragHelper, Math.max(i2, i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDrawerLeftEdgeSize(int i) {
        setDrawerEdgeSize(i, true);
    }

    public void setDrawerRightEdgeSize(int i) {
        setDrawerEdgeSize(i, false);
    }

    public Field getDeclaredField(String str) {
        Class cls = getClass();
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }
}
