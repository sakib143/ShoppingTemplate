package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.dashboard.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.asksira.loopingviewpager.LoopingViewPager;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.BannerInfinitePager_ViewBinding */
public class BannerInfinitePager_ViewBinding implements Unbinder {
    private BannerInfinitePager target;

    public BannerInfinitePager_ViewBinding(BannerInfinitePager bannerInfinitePager, View view) {
        this.target = bannerInfinitePager;
        bannerInfinitePager.vpSlide = (LoopingViewPager) Utils.findRequiredViewAsType(view, R.id.vpSlide, "field 'vpSlide'", LoopingViewPager.class);
    }

    public void unbind() {
        BannerInfinitePager bannerInfinitePager = this.target;
        if (bannerInfinitePager != null) {
            this.target = null;
            bannerInfinitePager.vpSlide = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
