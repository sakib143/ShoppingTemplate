package com.innomalist.taxi.shoppingapp.data.source.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.innomalist.taxi.shoppingapp.data.source.AppDataSource;

public class AppPreferenceDataSource implements AppDataSource, PreferenceKeys {
    private SharedPreferences sharedPreferences;

    public void delete() {
        String language = getLanguage();
        boolean isShowIntro = isShowIntro();
        String fCMToken = getFCMToken();
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.clear();
        edit.apply();
        edit.commit();
        setLanguage(language);
        setFCMToken(fCMToken);
        saveIsShowIntro(isShowIntro);
    }

    public void save(String str, boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
        edit.commit();
    }

    public void save(String str, String str2) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
        edit.commit();
    }

    public void save(String str, int i) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
        edit.commit();
    }

    public void save(String str, Object obj) {
        save(str, new Gson().toJson(obj));
    }

    public Object get(String str, Class cls) {
        return new Gson().fromJson(this.sharedPreferences.getString(str, (String) null), cls);
    }

    private Object get(String str, TypeToken typeToken) {
        return new Gson().fromJson(this.sharedPreferences.getString(str, (String) null), typeToken.getType());
    }

    public AppPreferenceDataSource(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PreferenceKeys.PREF_NAME, 0);
    }

    public void saveIsLoggedIn(boolean z) {
        this.sharedPreferences.edit().putBoolean(PreferenceKeys.IS_LOGGED_IN, z).apply();
    }

    public boolean isLoggedIn() {
        return this.sharedPreferences.getBoolean(PreferenceKeys.IS_LOGGED_IN, false);
    }

    public void setUserId(String str) {
        this.sharedPreferences.edit().putString("userId", str).apply();
    }

    public String getUserId() {
        return this.sharedPreferences.getString("userId", AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public void setOAuthKey(String str) {
        this.sharedPreferences.edit().putString(PreferenceKeys.OAUTH_KEY, str).apply();
    }

    public String getOAuthKey() {
        return this.sharedPreferences.getString(PreferenceKeys.OAUTH_KEY, "");
    }

    public void saveIsShowIntro(boolean z) {
        this.sharedPreferences.edit().putBoolean(PreferenceKeys.IS_SHOW_INTRO, z).apply();
    }

    public boolean isShowIntro() {
        return this.sharedPreferences.getBoolean(PreferenceKeys.IS_SHOW_INTRO, false);
    }

    public void setFCMToken(String str) {
        this.sharedPreferences.edit().putString(PreferenceKeys.FCM_TOKEN, str).apply();
    }

    public String getFCMToken() {
        return this.sharedPreferences.getString(PreferenceKeys.FCM_TOKEN, "");
    }

    public String getFirstName() {
        return this.sharedPreferences.getString(PreferenceKeys.FIRST_NAME, "");
    }

    public String getLastName() {
        return this.sharedPreferences.getString(PreferenceKeys.LAST_NAME, "");
    }

    public String getEmail() {
        return this.sharedPreferences.getString("email", "");
    }

    public Integer getCartCount() {
        return Integer.valueOf(this.sharedPreferences.getInt(PreferenceKeys.CART_COUNT, 0));
    }

    public String getShippingAddress() {
        return this.sharedPreferences.getString(PreferenceKeys.SHIPPING_ADDRESS, "");
    }

    public void setCartCount(int i) {
        save(PreferenceKeys.CART_COUNT, i);
    }

    public void setFirstName(String str) {
        save(PreferenceKeys.FIRST_NAME, str);
    }

    public void setLastName(String str) {
        save(PreferenceKeys.LAST_NAME, str);
    }

    public void setEmail(String str) {
        save("email", str);
    }

    public void setLanguage(String str) {
        save(PreferenceKeys.LANGUAGE, str);
    }

    public void setAvatar(String str) {
        save(PreferenceKeys.AVATAR, str);
    }

    public String getAvatar() {
        return this.sharedPreferences.getString(PreferenceKeys.AVATAR, "");
    }

    public String getLanguage() {
        return this.sharedPreferences.getString(PreferenceKeys.LANGUAGE, "en");
    }

    public void setCurrencyCode(String str) {
        this.sharedPreferences.edit().putString(PreferenceKeys.CURRENCY_CODE, str).apply();
    }

    public void setShippingAddress(String str) {
        this.sharedPreferences.edit().putString(PreferenceKeys.SHIPPING_ADDRESS, str).apply();
    }

    public String getCurrencyCode() {
        return this.sharedPreferences.getString(PreferenceKeys.CURRENCY_CODE, "USD");
    }
}
