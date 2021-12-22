package com.innomalist.taxi.shoppingapp.p011ui.storedetails.activity;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.innomalist.taxi.shoppingapp.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.activity.StoreDetailsActivity_ViewBinding */
public class StoreDetailsActivity_ViewBinding implements Unbinder {
    private StoreDetailsActivity target;

    public StoreDetailsActivity_ViewBinding(StoreDetailsActivity storeDetailsActivity) {
        this(storeDetailsActivity, storeDetailsActivity.getWindow().getDecorView());
    }

    public StoreDetailsActivity_ViewBinding(StoreDetailsActivity storeDetailsActivity, View view) {
        this.target = storeDetailsActivity;
        storeDetailsActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'viewPager'", ViewPager.class);
        storeDetailsActivity.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
    }

    public void unbind() {
        StoreDetailsActivity storeDetailsActivity = this.target;
        if (storeDetailsActivity != null) {
            this.target = null;
            storeDetailsActivity.viewPager = null;
            storeDetailsActivity.tabLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
