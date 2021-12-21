package com.kiandashopping.kiandashopping.util;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class PermissionUtil {
    public static final int CAMERA_GALLERY_REQUEST = 101;
    public static final String CAMERA_PERMISSION = "android.permission.CAMERA";
    public static final String READ_STORAGE_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String WRITE_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";

    public static boolean checkImagePermission(Context context) {
        return ContextCompat.checkSelfPermission(context, READ_STORAGE_PERMISSION) == 0 && ContextCompat.checkSelfPermission(context, WRITE_STORAGE_PERMISSION) == 0 && ContextCompat.checkSelfPermission(context, CAMERA_PERMISSION) == 0;
    }

    public static boolean isPermissionGranted(int[] iArr) {
        return iArr.length > 0 && iArr[0] == 0;
    }
}
