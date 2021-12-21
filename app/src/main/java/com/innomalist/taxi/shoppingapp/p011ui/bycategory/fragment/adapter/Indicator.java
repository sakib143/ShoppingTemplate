package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.innomalist.taxi.shoppingapp.model.bycategory.BannerDetail;

import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.Indicator */
public class Indicator {
    @BindView(2131362335)

    /* renamed from: tl */
    TabLayout f228tl;

    public Indicator(View view) {
        ButterKnife.bind((Object) this, view);
    }

    public void setSelectedPosition(int i) {
        this.f228tl.setScrollPosition(i, 0.0f, true);
    }

    public void setData(List<BannerDetail> list) {
        this.f228tl.removeAllTabs();
        for (BannerDetail next : list) {
            TabLayout tabLayout = this.f228tl;
            tabLayout.addTab(tabLayout.newTab());
        }
    }
}
