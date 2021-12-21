package com.kiandashopping.kiandashopping.customview;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    private int currentPage = 0;
    private boolean loading = true;
    RecyclerView.LayoutManager mLayoutManager;
    private int previousTotalItemCount = 0;
    private int startingPageIndex = 0;
    private int visibleThreshold = 5;

    public abstract void onLoadMore(int i, int i2);

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void reset() {
        this.visibleThreshold = 5;
        this.currentPage = 0;
        this.previousTotalItemCount = 0;
        this.loading = true;
        this.startingPageIndex = 0;
    }

    public int getPreviousTotalItemCount() {
        return this.previousTotalItemCount;
    }

    public EndlessRecyclerViewScrollListener(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public EndlessRecyclerViewScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public EndlessRecyclerViewScrollListener(GridLayoutManager gridLayoutManager) {
        this.mLayoutManager = gridLayoutManager;
        this.visibleThreshold = 5 * gridLayoutManager.getSpanCount();
    }

    public EndlessRecyclerViewScrollListener(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.mLayoutManager = staggeredGridLayoutManager;
        this.visibleThreshold = 5 * staggeredGridLayoutManager.getSpanCount();
    }

    public int getLastVisibleItem(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 == 0) {
                i = iArr[i2];
            } else if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        check();
    }

    /* access modifiers changed from: package-private */
    public void check() {
        int i;
        int itemCount = this.mLayoutManager.getItemCount();
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            i = getLastVisibleItem(((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions((int[]) null));
        } else if (layoutManager instanceof LinearLayoutManager) {
            i = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else {
            i = layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).findLastVisibleItemPosition() : 0;
        }
        if (itemCount < this.previousTotalItemCount) {
            this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = itemCount;
            if (itemCount == 0) {
                this.loading = true;
            }
        }
        if (!this.loading && i + this.visibleThreshold > itemCount) {
            int i2 = this.currentPage + 1;
            this.currentPage = i2;
            if (itemCount != 0) {
                onLoadMore(i2, itemCount);
            }
            this.loading = true;
        }
    }

    public void loadingFinished(int i) {
        if (getPreviousTotalItemCount() < i && i >= 10) {
            this.loading = false;
            this.previousTotalItemCount = i;
        }
        check();
    }
}
