package com.innomalist.taxi.shoppingapp.p011ui.storedetails.fragment.deals.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.model.storelist.DealListByShop;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.GlideUtils;

import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.customview.MyAdapter;
//import com.kiandashopping.kiandashopping.model.storelist.DealListByShop;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.GlideUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.deals.adapter.DealsAdapter */
public class DealsAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<DealListByShop> productLists;

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.deals.adapter.DealsAdapter$Listener */
    public interface Listener {
        void onClickItem(DealListByShop dealListByShop);
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.deals.adapter.DealsAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItem, "field 'tvItem'", TextView.class);
            viewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            viewHolder.tvDiscount = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscount, "field 'tvDiscount'", TextView.class);
            viewHolder.ivNext = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.frameLayout, "field 'ivNext'", FrameLayout.class);
            viewHolder.tvDiscountDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscountDetails, "field 'tvDiscountDetails'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.ivBg = null;
                viewHolder.tvItem = null;
                viewHolder.tvPrice = null;
                viewHolder.tvDiscount = null;
                viewHolder.ivNext = null;
                viewHolder.tvDiscountDetails = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DealsAdapter(List<DealListByShop> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.listener = listener2;
        this.productLists = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.productLists.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.deals.adapter.DealsAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        DealListByShop dealListByShop;
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362050)
        FrameLayout ivNext;
        @BindView(2131362369)
        TextView tvDiscount;
        @BindView(2131362370)
        TextView tvDiscountDetails;
        @BindView(2131362381)
        TextView tvItem;
        @BindView(2131362396)
        TextView tvPrice;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_top_offer);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            this.tvItem.setSelected(true);
            DealListByShop dealListByShop2 = (DealListByShop) DealsAdapter.this.productLists.get(i);
            this.dealListByShop = dealListByShop2;
            this.tvItem.setText(dealListByShop2.getDealTitle());
            this.tvPrice.setText(AppUtils.showPrice(this.dealListByShop.getDealCurrencySymbol(), this.dealListByShop.getDealOriginalPrice()));
            this.tvDiscount.setText(AppUtils.showPrice(this.dealListByShop.getDealCurrencySymbol(), this.dealListByShop.getDealDiscountPrice()));
            this.tvDiscountDetails.setText(AppUtils.append(this.dealListByShop.getDealDiscountPercentage().intValue(), ResourceUtils.getString(R.string.off_text)));
            this.tvDiscountDetails.setVisibility(this.dealListByShop.getDealDiscountPercentage().intValue() == 0 ? 8 : 0);
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.dealListByShop.getDealImage());
        }

        public void onClick(View view) {
            if (this.dealListByShop != null) {
                DealsAdapter.this.listener.onClickItem(this.dealListByShop);
            }
        }
    }
}
