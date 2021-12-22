package com.innomalist.taxi.shoppingapp.util;

import android.util.Patterns;

import com.innomalist.taxi.shoppingapp.R;

import java.util.regex.Pattern;

public final class ValidationUtils {
    public static final boolean isValidEmail(String str) {
        if (str == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    public static final boolean isValidPhoneNumber(String str) {
        return str.length() >= ResourceUtils.getInt(R.integer.mobileMin) && str.length() <= ResourceUtils.getInt(R.integer.mobileMax) && Patterns.PHONE.matcher(str).matches();
    }

    public static boolean isValidPassword(String str) {
        return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$").matcher(str).matches();
    }

    public static final boolean isValidCommission(String str) {
        return Double.parseDouble(str) < 100.0d;
    }
}
