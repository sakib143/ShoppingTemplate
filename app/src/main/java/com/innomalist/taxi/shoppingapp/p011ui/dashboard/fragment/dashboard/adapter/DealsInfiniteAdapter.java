package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.apptube.ecommerce.R;
import com.asksira.loopingviewpager.LoopingPagerAdapter;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.model.dashboard.DealsOfDayDetail;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DealsInfiniteAdapter */
public class DealsInfiniteAdapter extends LoopingPagerAdapter<DealsOfDayDetail> {
    private DealsListener dealsListener;
    private List<DealsOfDayDetail> mItemList;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DealsInfiniteAdapter$DealsListener */
    public interface DealsListener {
        void onClick(DealsOfDayDetail dealsOfDayDetail);
    }

    public DealsInfiniteAdapter(Context context, DealsListener dealsListener2, List<DealsOfDayDetail> list, boolean z) {
        super(context, list, z);
        this.dealsListener = dealsListener2;
        this.mItemList = list;
    }

    /* access modifiers changed from: protected */
    public View inflateView(int i, ViewGroup viewGroup, int i2) {
        return LayoutInflater.from(this.context).inflate(R.layout.item_deals_banner_image, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void bindView(View view, int i, int i2) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        GlideUtils.showImage(BaseApplication.getContext(), imageView, (Drawable) AppUtils.getProgressDrawable(), this.mItemList.get(i).getDealImage());
        imageView.setOnClickListener(new View.OnClickListener(i) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                DealsInfiniteAdapter.this.lambda$bindView$0$DealsInfiniteAdapter(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$bindView$0$DealsInfiniteAdapter(int i, View view) {
        this.dealsListener.onClick(this.mItemList.get(i));
    }
}
