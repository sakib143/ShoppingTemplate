package com.innomalist.taxi.shoppingapp.p011ui.itemdetails.adapter;

import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.innomalist.taxi.shoppingapp.model.itemdetails.ProductImage;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
//import com.kiandashopping.kiandashopping.model.itemdetails.ProductImage;
//import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductInfinitePager */
public class ProductInfinitePager {
    private int currentPage = 0;
    @BindView(2131362439)
    ViewPager viewPager;
    @BindView(2131362442)
    WormDotsIndicator wormDotsIndicator;

    public ProductInfinitePager(View view, List<ProductImage> list, FragmentManager fragmentManager) {
        ButterKnife.bind((Object) this, view);
        this.viewPager.setAdapter(new SliderPagerAdapter(fragmentManager, list));
        this.wormDotsIndicator.setViewPager(this.viewPager);
        final Handler handler = new Handler();
        final $$Lambda$ProductInfinitePager$quz_r4obgWb2C5IN8h7CliD4 r9 = new Runnable(list.size()) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ProductInfinitePager.this.lambda$new$0$ProductInfinitePager(this.f$1);
            }
        };
        new Timer().schedule(new TimerTask() {
            public void run() {
                handler.post(r9);
            }
        }, 3000, 3000);
    }

    public /* synthetic */ void lambda$new$0$ProductInfinitePager(int i) {
        if (this.currentPage == i) {
            this.currentPage = 0;
        }
        ViewPager viewPager2 = this.viewPager;
        int i2 = this.currentPage;
        this.currentPage = i2 + 1;
        viewPager2.setCurrentItem(i2, true);
    }
}
