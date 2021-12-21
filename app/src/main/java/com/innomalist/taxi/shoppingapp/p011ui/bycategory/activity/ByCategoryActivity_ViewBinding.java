package com.innomalist.taxi.shoppingapp.p011ui.bycategory.activity;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.innomalist.taxi.shoppingapp.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.activity.ByCategoryActivity_ViewBinding */
public class ByCategoryActivity_ViewBinding implements Unbinder {
    private ByCategoryActivity target;

    public ByCategoryActivity_ViewBinding(ByCategoryActivity byCategoryActivity) {
        this(byCategoryActivity, byCategoryActivity.getWindow().getDecorView());
    }

    public ByCategoryActivity_ViewBinding(ByCategoryActivity byCategoryActivity, View view) {
        this.target = byCategoryActivity;
        byCategoryActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'viewPager'", ViewPager.class);
        byCategoryActivity.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
    }

    public void unbind() {
        ByCategoryActivity byCategoryActivity = this.target;
        if (byCategoryActivity != null) {
            this.target = null;
            byCategoryActivity.viewPager = null;
            byCategoryActivity.tabLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
