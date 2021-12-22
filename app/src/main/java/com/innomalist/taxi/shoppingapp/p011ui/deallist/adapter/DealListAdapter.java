package com.innomalist.taxi.shoppingapp.p011ui.deallist.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.GlideUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
import com.kiandashopping.kiandashopping.model.deallist.ResultDealList;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.GlideUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.deallist.adapter.DealListAdapter */
public class DealListAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<ResultDealList> resultDealLists;

    /* renamed from: com.kiandashopping.kiandashopping.ui.deallist.adapter.DealListAdapter$Listener */
    public interface Listener extends MyAdapter.Listener {
        void onClickItem(ResultDealList resultDealList);
    }

    public boolean isLoadMoreEnabled() {
        return true;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.deallist.adapter.DealListAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItem, "field 'tvItem'", TextView.class);
            viewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            viewHolder.tvDiscount = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscount, "field 'tvDiscount'", TextView.class);
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
                viewHolder.tvDiscountDetails = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DealListAdapter(List<ResultDealList> list, Listener listener2) {
        super(listener2);
        this.listener = listener2;
        this.resultDealLists = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.resultDealLists.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.deallist.adapter.DealListAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        ResultDealList dealList;
        @BindView(2131362090)
        ImageView ivBg;
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
            ResultDealList resultDealList = (ResultDealList) DealListAdapter.this.resultDealLists.get(i);
            this.dealList = resultDealList;
            this.tvItem.setText(resultDealList.getDealTitle());
            this.tvItem.setSelected(true);
            this.tvPrice.setText(AppUtils.showPrice(this.dealList.getDealCurrencySymbol(), this.dealList.getDealOriginalPrice()));
            this.tvDiscount.setText(AppUtils.showPrice(this.dealList.getDealCurrencySymbol(), this.dealList.getDealDiscountPrice()));
            TextView textView = this.tvDiscount;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            this.tvDiscountDetails.setText(AppUtils.append(this.dealList.getDealDiscountPercentage().intValue(), ResourceUtils.getString(R.string.off_text)));
            this.tvDiscountDetails.setVisibility(this.dealList.getDealDiscountPercentage().intValue() == 0 ? 8 : 0);
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.dealList.getDealImage());
        }

        public void onClick(View view) {
            if (this.dealList != null) {
                DealListAdapter.this.listener.onClickItem(this.dealList);
            }
        }
    }
}
