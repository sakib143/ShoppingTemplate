package com.kiandashopping.kiandashopping.util;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kiandashopping.kiandashopping.base.BaseApplication;

public class ResourceUtils {
    public static int getColor(int i) {
        return BaseApplication.getContext().getResources().getColor(i);
    }

    public static int getColor(String str) {
        return Color.parseColor(str);
    }

    public static String getString(int i) {
        return BaseApplication.getContext().getResources().getString(i);
    }

    public static String getCamelCase(int i) {
        return getFirstLetterCaps(BaseApplication.getContext().getResources().getString(i));
    }

    public static String getFirstLetterCaps(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static Drawable getImage(int i) {
        return BaseApplication.getContext().getResources().getDrawable(i);
    }

    public static String[] getStringArray(int i) {
        return BaseApplication.getContext().getResources().getStringArray(i);
    }

    public static boolean getBoolean(int i) {
        return BaseApplication.getContext().getResources().getBoolean(i);
    }

    public static int getDimension(int i) {
        return BaseApplication.getContext().getResources().getDimensionPixelSize(i);
    }

    public static String getString(int i, Object... objArr) {
        return BaseApplication.getContext().getResources().getString(i, objArr);
    }

    public static int getInt(int i) {
        return BaseApplication.getContext().getResources().getInteger(i);
    }

    public static void setChangeColor(ImageView imageView, int i) {
        imageView.setColorFilter(getColor(i));
    }
}
