package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.asksira.loopingviewpager.LoopingViewPager;
import com.innomalist.taxi.shoppingapp.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.InfinitePager_ViewBinding */
public class InfinitePager_ViewBinding implements Unbinder {
    private InfinitePager target;

    public InfinitePager_ViewBinding(InfinitePager infinitePager, View view) {
        this.target = infinitePager;
        infinitePager.vpSlide = (LoopingViewPager) Utils.findRequiredViewAsType(view, R.id.vpSlide, "field 'vpSlide'", LoopingViewPager.class);
    }

    public void unbind() {
        InfinitePager infinitePager = this.target;
        if (infinitePager != null) {
            this.target = null;
            infinitePager.vpSlide = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
