package com.kiandashopping.kiandashopping.p011ui.dashboard.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.activity.DashboardActivity_ViewBinding */
public class DashboardActivity_ViewBinding implements Unbinder {
    private DashboardActivity target;

    public DashboardActivity_ViewBinding(DashboardActivity dashboardActivity) {
        this(dashboardActivity, dashboardActivity.getWindow().getDecorView());
    }

    public DashboardActivity_ViewBinding(DashboardActivity dashboardActivity, View view) {
        this.target = dashboardActivity;
        dashboardActivity.f229rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        dashboardActivity.llTab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llTab, "field 'llTab'", LinearLayout.class);
        dashboardActivity.flHome = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flHome, "field 'flHome'", FrameLayout.class);
        dashboardActivity.flMyCart = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flMyCart, "field 'flMyCart'", FrameLayout.class);
        dashboardActivity.avMyCart = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avMyCart, "field 'avMyCart'", LottieAnimationView.class);
        dashboardActivity.avHome = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avHome, "field 'avHome'", LottieAnimationView.class);
        dashboardActivity.appBar = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.appBar, "field 'appBar'", AppBarLayout.class);
        dashboardActivity.drawerLayout = (DrawerLayout) Utils.findRequiredViewAsType(view, R.id.drawerLayout, "field 'drawerLayout'", DrawerLayout.class);
    }

    public void unbind() {
        DashboardActivity dashboardActivity = this.target;
        if (dashboardActivity != null) {
            this.target = null;
            dashboardActivity.f229rv = null;
            dashboardActivity.llTab = null;
            dashboardActivity.flHome = null;
            dashboardActivity.flMyCart = null;
            dashboardActivity.avMyCart = null;
            dashboardActivity.avHome = null;
            dashboardActivity.appBar = null;
            dashboardActivity.drawerLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
