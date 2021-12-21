package com.kiandashopping.kiandashopping.cardutils;

public class StringUtil {
    private static final int INDEX_NOT_FOUND = -1;

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i = 0;
        if (!(charSequence == null || charSequence2 == null)) {
            while (i < charSequence.length() && i < charSequence2.length() && charSequence.charAt(i) == charSequence2.charAt(i)) {
                i++;
            }
            if (i < charSequence2.length() || i < charSequence.length()) {
                return i;
            }
            return -1;
        }
        return i;
    }
}
