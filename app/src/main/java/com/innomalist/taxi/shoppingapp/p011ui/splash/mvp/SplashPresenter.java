package com.kiandashopping.kiandashopping.p011ui.splash.mvp;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.p011ui.splash.mvp.SplashContractor;

/* renamed from: com.kiandashopping.kiandashopping.ui.splash.mvp.SplashPresenter */
public class SplashPresenter extends BasePresenter implements SplashContractor.Presenter {
    private final String TAG = getClass().getName();
    private SplashContractor.View view;

    public ModelInterface getModelInterface() {
        return null;
    }

    public SplashPresenter(SplashContractor.View view2) {
        this.view = view2;
    }

    public void startNavigation() {
        String fCMToken = this.appRepository.getFCMToken();
        Log.i(this.TAG, fCMToken);
        if (fCMToken.equals("")) {
            fireBaseRegister();
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                SplashPresenter.this.lambda$startNavigation$0$SplashPresenter();
            }
        }, (long) 3000);
    }

    public /* synthetic */ void lambda$startNavigation$0$SplashPresenter() {
        if (this.appRepository.isLoggedIn()) {
            this.view.showDashBoardActivity();
        } else {
            this.view.showLoginActivity();
        }
    }

    public void fireBaseRegister() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                SplashPresenter.this.lambda$fireBaseRegister$1$SplashPresenter(task);
            }
        });
    }

    public /* synthetic */ void lambda$fireBaseRegister$1$SplashPresenter(Task task) {
        if (!task.isSuccessful()) {
            Log.w(this.TAG, "getInstanceId failed", task.getException());
            return;
        }
        String token = ((InstanceIdResult) task.getResult()).getToken();
        String str = this.TAG;
        Log.i(str, "fireBaseRegister: " + token);
        this.appRepository.setFCMToken(token);
    }
}
