package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.asksira.loopingviewpager.LoopingViewPager;
import com.kiandashopping.kiandashopping.model.dashboard.BannerDetail;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.BannerInfinitePager */
public class BannerInfinitePager {
    private BannerInfiniteAdapter adapter;
    String bannerText;
    private ArrayList<BannerDetail> data;
    /* access modifiers changed from: private */
    public Indicator indicator;
    private boolean isCollapsed = false;
    private boolean isMinimised = false;
    @BindView(2131362439)
    LoopingViewPager vpSlide;

    public BannerInfinitePager(View view, String str) {
        ButterKnife.bind((Object) this, view);
        this.bannerText = str;
        this.data = new ArrayList<>();
        BannerInfiniteAdapter bannerInfiniteAdapter = new BannerInfiniteAdapter(this.vpSlide.getContext(), this.data, true, str);
        this.adapter = bannerInfiniteAdapter;
        this.vpSlide.setAdapter(bannerInfiniteAdapter);
        this.indicator = new Indicator(view);
        this.vpSlide.setIndicatorPageChangeListener(new LoopingViewPager.IndicatorPageChangeListener() {
            public void onIndicatorProgress(int i, float f) {
            }

            public void onIndicatorPageChange(int i) {
                BannerInfinitePager.this.indicator.setSelectedPosition(i);
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
