package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter;

import android.view.View;

import com.innomalist.taxi.shoppingapp.model.bycategory.BannerDetail;

import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.InfinitePager */
public class InfinitePager {
    private DemoInfiniteAdapter adapter;
    String bannerText;
    private ArrayList<BannerDetail> data;
    /* access modifiers changed from: private */
    public Indicator indicator;
    private boolean isCollapsed = false;
    private boolean isMinimised = false;
    @BindView(2131362439)
    LoopingViewPager vpSlide;

    public InfinitePager(View view, String str) {
        ButterKnife.bind((Object) this, view);
        this.bannerText = str;
        this.data = new ArrayList<>();
        DemoInfiniteAdapter demoInfiniteAdapter = new DemoInfiniteAdapter(this.vpSlide.getContext(), this.data, true, str);
        this.adapter = demoInfiniteAdapter;
        this.vpSlide.setAdapter(demoInfiniteAdapter);
        this.indicator = new Indicator(view);
        this.vpSlide.setIndicatorPageChangeListener(new LoopingViewPager.IndicatorPageChangeListener() {
            public void onIndicatorProgress(int i, float f) {
            }

            public void onIndicatorPageChange(int i) {
                InfinitePager.this.indicator.setSelectedPosition(i);
            }
        });
    }

    public void setData(List<BannerDetail> list) {
        this.data.clear();
        this.data.addAll(list);
        this.adapter.setItemList(this.data);
        this.vpSlide.reset();
        this.indicator.setData(list);
    }

    public void onPause() {
        this.isMinimised = true;
        updateAutoScroll();
    }

    public void onResume() {
        this.isMinimised = false;
        updateAutoScroll();
    }

    public void onCollapsed() {
        this.isCollapsed = true;
        updateAutoScroll();
    }

    public void onExpand() {
        this.isCollapsed = false;
        updateAutoScroll();
    }

    private void updateAutoScroll() {
        if (this.isMinimised || this.isCollapsed) {
            this.vpSlide.pauseAutoScroll();
        } else {
            this.vpSlide.resumeAutoScroll();
        }
    }
}
