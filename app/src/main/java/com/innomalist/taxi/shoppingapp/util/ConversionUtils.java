package com.innomalist.taxi.shoppingapp.util;

import android.util.Log;

import com.innomalist.taxi.shoppingapp.base.AppConstants;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import kotlin.UByte;

public class ConversionUtils implements AppConstants {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String FORMAT_CFM_DATA = "%.2f";
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String md5Format(String str) {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = null;
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            stringBuffer = new StringBuffer();
            try {
                for (byte b : digest) {
                    stringBuffer.append(Integer.toHexString((b & UByte.MAX_VALUE) | UByte.MIN_VALUE).substring(1, 3));
                }
            } catch (NoSuchAlgorithmException e) {
                e = e;
                stringBuffer2 = stringBuffer;
                Log.e(AppConstants.EXCEPTION, e.toString());
                stringBuffer = stringBuffer2;
                return stringBuffer.toString();
            }
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            Log.e(AppConstants.EXCEPTION, e.toString());
            stringBuffer = stringBuffer2;
            return stringBuffer.toString();
        }
        return stringBuffer.toString();
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & UByte.MAX_VALUE;
            int i2 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static int parseInt(String str) {
        try {
            if (str.equalsIgnoreCase(AppConstants.NO_LIMIT)) {
                return Integer.MAX_VALUE;
            }
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int parseInt(float f) {
        try {
            return Math.round(f);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int parseInt(long j) {
        try {
            return Math.round((float) j);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static float parseFloat(String str) {
        try {
            return Float.valueOf(str).floatValue();
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static Double parseDouble(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (Exception unused) {
            return Double.valueOf(0.0d);
        }
    }

    public static String parseTimer(long j) {
        try {
            return parseString(Math.round((float) j));
        } catch (Exception unused) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    public static String parseString(double d) {
        try {
            return String.valueOf(new DecimalFormat("##.##").format(d));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String parseFormat(String str) {
        try {
            return parseString(Double.parseDouble(str));
        } catch (Exception unused) {
            return "0.0";
        }
    }

    public static String parseString(int i) {
        try {
            return String.valueOf(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String parseString(float f) {
        try {
            return String.valueOf(f);
        } catch (Exception unused) {
            return "";
        }
    }
}
