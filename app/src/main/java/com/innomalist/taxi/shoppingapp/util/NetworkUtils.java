package com.innomalist.taxi.shoppingapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class NetworkUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DESCRIPTION = "description";

    public static boolean isNetworkConnected(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static String getErrorMessage(ResponseBody responseBody) {
        try {
            return new JSONObject(responseBody.string()).getString("description");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
