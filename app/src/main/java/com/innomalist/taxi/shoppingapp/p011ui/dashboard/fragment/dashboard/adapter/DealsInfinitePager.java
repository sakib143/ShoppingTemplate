package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.asksira.loopingviewpager.LoopingViewPager;
import com.kiandashopping.kiandashopping.model.dashboard.DealsOfDayDetail;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.DealsInfiniteAdapter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DealsInfinitePager */
public class DealsInfinitePager {
    private DealsInfiniteAdapter adapter;
    private List<DealsOfDayDetail> data;
    DealsInfiniteAdapter.DealsListener dealsListener;
    /* access modifiers changed from: private */
    public Indicator indicator;
    private boolean isCollapsed = false;
    private boolean isMinimised = false;
    @BindView(2131362439)
    LoopingViewPager vpSlide;

    public DealsInfinitePager(View view, DealsInfiniteAdapter.DealsListener dealsListener2) {
        ButterKnife.bind((Object) this, view);
        this.data = new ArrayList();
        this.dealsListener = dealsListener2;
        DealsInfiniteAdapter dealsInfiniteAdapter = new DealsInfiniteAdapter(this.vpSlide.getContext(), dealsListener2, this.data, true);
        this.adapter = dealsInfiniteAdapter;
        this.vpSlide.setAdapter(dealsInfiniteAdapter);
        this.indicator = new Indicator(view);
        this.vpSlide.setIndicatorPageChangeListener(new LoopingViewPager.IndicatorPageChangeListener() {
            public void onIndicatorProgress(int i, float f) {
            }

            public void onIndicatorPageChange(int i) {
                DealsInfinitePager.this.indicator.setSelectedPosition(i);
            }
        });
    }

    public void setData(List<DealsOfDayDetail> list) {
        this.data.clear();
        this.data.addAll(list);
        this.adapter.setItemList(this.data);
        this.vpSlide.reset();
        this.indicator.setDatas(list);
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
