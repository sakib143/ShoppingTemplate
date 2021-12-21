package com.innomalist.taxi.shoppingapp.base;

import android.content.Context;
import android.content.res.Configuration;
import androidx.multidex.MultiDexApplication;

import com.innomalist.taxi.shoppingapp.data.rest.ApiClient;
import com.innomalist.taxi.shoppingapp.data.rest.ApiInterface;
import com.innomalist.taxi.shoppingapp.data.source.AppRepository;
import com.innomalist.taxi.shoppingapp.data.source.sharedpreference.AppPreferenceDataSource;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.Locale;

public class BaseApplication extends MultiDexApplication {
    private static ApiInterface apiInterface;
    protected static AppRepository appRepository;
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public void onCreate() {
        super.onCreate();
        context = this;
        appRepository = new AppRepository(new AppPreferenceDataSource(this));
        apiInterface = ApiClient.getApiInterface();
        AppUtils.getHashKey(this);
        setLanguage();
    }

    public static AppRepository getAppRepository() {
        return appRepository;
    }

    public static void factoryReset() {
        appRepository = new AppRepository(new AppPreferenceDataSource(context));
        setLanguage();
    }

    private static void setLanguage() {
        Locale locale = new Locale(appRepository.getLanguage());
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
    }

    public static ApiInterface getApiInterface() {
        return apiInterface;
    }
}
