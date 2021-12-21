package com.kiandashopping.kiandashopping.p011ui.splash.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import com.apptube.ecommerce.R;
import com.google.firebase.FirebaseApp;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.p011ui.login.activity.Login;
import com.kiandashopping.kiandashopping.p011ui.splash.mvp.SplashContractor;
import com.kiandashopping.kiandashopping.p011ui.splash.mvp.SplashPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.splash.activity.Splash */
public class Splash extends BaseActivity implements SplashContractor.View {
    SplashPresenter splashPresenter;

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        checkOreo();
        FirebaseApp.initializeApp(this);
        SplashPresenter splashPresenter2 = new SplashPresenter(this);
        this.splashPresenter = splashPresenter2;
        splashPresenter2.startNavigation();
        AppUtils.getHashKey(this);
    }

    private void checkOreo() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel(getString(R.string.default_notification_channel_id), getString(R.string.default_notification_channel_name), 2));
        }
    }

    public int getLayout() {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        return R.layout.activity_splash;
    }

    public void showLoginActivity() {
        changeActivityClearBackStack(Login.class);
    }

    public void showDashBoardActivity() {
        openDashBoard(1);
    }
}
