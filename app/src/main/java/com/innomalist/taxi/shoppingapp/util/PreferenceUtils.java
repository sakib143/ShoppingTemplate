package com.innomalist.taxi.shoppingapp.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {
    private static final int MODE = 0;
    private static final String PREF_NAME = "PEOPLE_PREFERENCES";
    public static final String USER_ID = "userId";

    public static void writeBoolean(Context context, String str, boolean z) {
        getEditor(context).putBoolean(str, z).commit();
    }

    public static boolean readBoolean(Context context, String str, boolean z) {
        return getPreferences(context).getBoolean(str, z);
    }

    public static void writeInteger(Context context, String str, int i) {
        getEditor(context).putInt(str, i).commit();
    }

    public static int readInteger(Context context, String str, int i) {
        return getPreferences(context).getInt(str, i);
    }

    public static void writeString(Context context, String str, String str2) {
        getEditor(context).putString(str, str2).commit();
    }

    public static String readString(Context context, String str, String str2) {
        return getPreferences(context).getString(str, str2);
    }

    public static void writeFloat(Context context, String str, float f) {
        getEditor(context).putFloat(str, f).commit();
    }

    public static float readFloat(Context context, String str, float f) {
        return getPreferences(context).getFloat(str, f);
    }

    public static void writeLong(Context context, String str, long j) {
        getEditor(context).putLong(str, j).commit();
    }

    public static long readLong(Context context, String str, long j) {
        return getPreferences(context).getLong(str, j);
    }

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences("PEOPLE_PREFERENCES", 0);
    }

    public static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }
}
