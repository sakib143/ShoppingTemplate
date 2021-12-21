package com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.viewholder.BottomTabs_ViewBinding */
public class BottomTabs_ViewBinding implements Unbinder {
    private BottomTabs target;
    private View view7f0a00f7;
    private View view7f0a00fa;
    private View view7f0a00fb;
    private View view7f0a00fc;
    private View view7f0a00fe;

    public BottomTabs_ViewBinding(final BottomTabs bottomTabs, View view) {
        this.target = bottomTabs;
        bottomTabs.avStore = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avStore, "field 'avStore'", LottieAnimationView.class);
        bottomTabs.avMyCart = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avMyCart, "field 'avMyCart'", LottieAnimationView.class);
        bottomTabs.avHome = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avHome, "field 'avHome'", LottieAnimationView.class);
        bottomTabs.avNearMe = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avNearMe, "field 'avNearMe'", LottieAnimationView.class);
        bottomTabs.avAccount = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avAccount, "field 'avAccount'", LottieAnimationView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.flStore, "method 'onStoreClick'");
        this.view7f0a00fe = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                bottomTabs.onStoreClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.flMyCart, "method 'onCartClick'");
        this.view7f0a00fb = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                bottomTabs.onCartClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.flHome, "method 'onHomeClick'");
        this.view7f0a00fa = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                bottomTabs.onHomeClick(view);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.flNearMe, "method 'onNearMeClick'");
        this.view7f0a00fc = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                bottomTabs.onNearMeClick(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.flAccount, "method 'onAccountClick'");
        this.view7f0a00f7 = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                bottomTabs.onAccountClick(view);
            }
        });
    }

    public void unbind() {
        BottomTabs bottomTabs = this.target;
        if (bottomTabs != null) {
            this.target = null;
            bottomTabs.avStore = null;
            bottomTabs.avMyCart = null;
            bottomTabs.avHome = null;
            bottomTabs.avNearMe = null;
            bottomTabs.avAccount = null;
            this.view7f0a00fe.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00fe = null;
            this.view7f0a00fb.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00fb = null;
            this.view7f0a00fa.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00fa = null;
            this.view7f0a00fc.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00fc = null;
            this.view7f0a00f7.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00f7 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
