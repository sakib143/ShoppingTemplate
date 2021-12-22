package com.innomalist.taxi.shoppingapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.DatePicker;

import com.innomalist.taxi.shoppingapp.base.BaseApplication;

import java.lang.reflect.Field;

public final class ViewUtils {
    private ViewUtils() {
    }

    public static String getDeviceId() {
        return Settings.Secure.getString(BaseApplication.getContext().getContentResolver(), "android_id");
    }

    public static float pxToDp(float f) {
        return f / (((float) Resources.getSystem().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static int dpToPx(float f) {
        return Math.round(f * Resources.getSystem().getDisplayMetrics().density);
    }

    public static void forceRippleAnimation(View... viewArr) {
        for (View background : viewArr) {
            Drawable background2 = background.getBackground();
            if (Build.VERSION.SDK_INT >= 21 && (background2 instanceof RippleDrawable)) {
                final RippleDrawable rippleDrawable = (RippleDrawable) background2;
                rippleDrawable.setState(new int[]{16842919, 16842910});
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        rippleDrawable.setState(new int[0]);
                    }
                }, 200);
            }
        }
    }

    public static void expand(final View view) {
        if (view.getVisibility() == 8) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            final int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : view.getMeasuredHeight();
            Animation r1 = new Animation() {
                public boolean willChangeBounds() {
                    return true;
                }

                /* access modifiers changed from: protected */
                public void applyTransformation(float f, Transformation transformation) {
                    view.getLayoutParams().height = f == 1.0f ? -2 : (int) (((float) intValue) * f);
                    view.requestLayout();
                    if (view.getLayoutParams().height > 5) {
                        view.setVisibility(0);
                    }
                }
            };
            r1.setDuration((long) (((int) (((float) intValue) / view.getContext().getResources().getDisplayMetrics().density)) * 2));
            view.startAnimation(r1);
        }
    }

    public static void collapse(final View view) {
        if (view.getVisibility() == 0) {
            final int measuredHeight = view.getMeasuredHeight();
            view.setTag(Integer.valueOf(measuredHeight));
            Animation r1 = new Animation() {
                public boolean willChangeBounds() {
                    return true;
                }

                /* access modifiers changed from: protected */
                public void applyTransformation(float f, Transformation transformation) {
                    if (f == 1.0f) {
                        view.setVisibility(8);
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    int i = measuredHeight;
                    layoutParams.height = i - ((int) (((float) i) * f));
                    view.requestLayout();
                }
            };
            r1.setDuration((long) (((int) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density)) * 2));
            view.startAnimation(r1);
        }
    }

    public static void hideDay(DatePicker datePicker) {
        Object obj;
        Object obj2;
        View findViewById;
        View findViewById2;
        View findViewById3;
        if (Build.VERSION.SDK_INT >= 21) {
            int identifier = Resources.getSystem().getIdentifier("day", "id", "android");
            if (!(identifier == 0 || (findViewById3 = datePicker.findViewById(identifier)) == null)) {
                findViewById3.setVisibility(8);
            }
            int identifier2 = Resources.getSystem().getIdentifier("month", "id", "android");
            if (!(identifier2 == 0 || (findViewById2 = datePicker.findViewById(identifier2)) == null)) {
                findViewById2.setVisibility(0);
            }
            int identifier3 = Resources.getSystem().getIdentifier("year", "id", "android");
            if (identifier3 != 0 && (findViewById = datePicker.findViewById(identifier3)) != null) {
                findViewById.setVisibility(0);
                return;
            }
            return;
        }
        for (Field field : datePicker.getClass().getDeclaredFields()) {
            Object obj3 = null;
            if (field.getName().equals("mDayPicker") || field.getName().equals("mDaySpinner")) {
                field.setAccessible(true);
                try {
                    obj2 = field.get(datePicker);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    obj2 = null;
                }
                ((View) obj2).setVisibility(8);
            }
            if (field.getName().equals("mMonthPicker") || field.getName().equals("mMonthSpinner")) {
                field.setAccessible(true);
                try {
                    obj = field.get(datePicker);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    obj = null;
                }
                ((View) obj).setVisibility(0);
            }
            if (field.getName().equals("mYearPicker") || field.getName().equals("mYearSpinner")) {
                field.setAccessible(true);
                try {
                    obj3 = field.get(datePicker);
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
                ((View) obj3).setVisibility(0);
            }
        }
    }

    public static int getActionBarSize(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }
}
