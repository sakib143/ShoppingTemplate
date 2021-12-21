package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.asksira.loopingviewpager.LoopingViewPager;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DealsInfinitePager_ViewBinding */
public class DealsInfinitePager_ViewBinding implements Unbinder {
    private DealsInfinitePager target;

    public DealsInfinitePager_ViewBinding(DealsInfinitePager dealsInfinitePager, View view) {
        this.target = dealsInfinitePager;
        dealsInfinitePager.vpSlide = (LoopingViewPager) Utils.findRequiredViewAsType(view, R.id.vpSlide, "field 'vpSlide'", LoopingViewPager.class);
    }

    public void unbind() {
        DealsInfinitePager dealsInfinitePager = this.target;
        if (dealsInfinitePager != null) {
            this.target = null;
            dealsInfinitePager.vpSlide = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
