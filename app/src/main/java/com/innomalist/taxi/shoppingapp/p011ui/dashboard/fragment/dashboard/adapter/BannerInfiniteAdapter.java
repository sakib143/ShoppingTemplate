package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.dashboard.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
//import com.apptube.ecommerce.R;
//import com.asksira.loopingviewpager.LoopingPagerAdapter;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.model.dashboard.BannerDetail;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.asksira.loopingviewpager.LoopingPagerAdapter;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.model.dashboard.BannerDetail;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.GlideUtils;

import java.util.ArrayList;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.BannerInfiniteAdapter */
public class BannerInfiniteAdapter extends LoopingPagerAdapter<BannerDetail> {
    private String bannerText;
    private ArrayList<BannerDetail> mItemList;

    public BannerInfiniteAdapter(Context context, ArrayList<BannerDetail> arrayList, boolean z, String str) {
        super(context, arrayList, z);
        this.mItemList = arrayList;
        this.bannerText = str;
    }

    /* access modifiers changed from: protected */
    public View inflateView(int i, ViewGroup viewGroup, int i2) {
        return LayoutInflater.from(this.context).inflate(R.layout.item_banner_image, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void bindView(View view, int i, int i2) {
        GlideUtils.showImage(BaseApplication.getContext(), (ImageView) view.findViewById(R.id.image), (Drawable) AppUtils.getProgressDrawable(), this.mItemList.get(i).getBannerImage());
    }
}
