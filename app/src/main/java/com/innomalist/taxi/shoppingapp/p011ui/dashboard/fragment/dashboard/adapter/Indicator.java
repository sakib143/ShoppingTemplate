package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.dashboard.adapter;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.innomalist.taxi.shoppingapp.model.dashboard.BannerDetail;
import com.innomalist.taxi.shoppingapp.model.dashboard.DealsOfDayDetail;
//import com.kiandashopping.kiandashopping.model.dashboard.BannerDetail;
//import com.kiandashopping.kiandashopping.model.dashboard.DealsOfDayDetail;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.Indicator */
public class Indicator {
    @BindView(2131362335)

    /* renamed from: tl */
    TabLayout f238tl;

    public Indicator(View view) {
        ButterKnife.bind((Object) this, view);
    }

    public void setSelectedPosition(int i) {
        this.f238tl.setScrollPosition(i, 0.0f, true);
    }

    public void setData(List<BannerDetail> list) {
        this.f238tl.removeAllTabs();
        for (BannerDetail next : list) {
            TabLayout tabLayout = this.f238tl;
            tabLayout.addTab(tabLayout.newTab());
        }
    }

    public void setDatas(List<DealsOfDayDetail> list) {
        this.f238tl.removeAllTabs();
        for (DealsOfDayDetail next : list) {
            TabLayout tabLayout = this.f238tl;
            tabLayout.addTab(tabLayout.newTab());
        }
    }
}
