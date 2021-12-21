package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.dashboard.ProductNewArrivals;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.NewArrivalsAdapter */
public class NewArrivalsAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    Listener listener;
    List<ProductNewArrivals> offerDetails;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.NewArrivalsAdapter$Listener */
    public interface Listener {
        void onClickItem(ProductNewArrivals productNewArrivals);
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.NewArrivalsAdapter$ViewHolder_ViewBinding */
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

    NewArrivalsAdapter(List<ProductNewArrivals> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.listener = listener2;
        this.offerDetails = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.offerDetails.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.NewArrivalsAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362050)
        FrameLayout ivNext;
        ProductNewArrivals productNewArrivals;
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
            this.productNewArrivals = NewArrivalsAdapter.this.offerDetails.get(i);
            this.tvItem.setSelected(true);
            this.tvItem.setText(this.productNewArrivals.getProductTitle());
            this.tvPrice.setText(AppUtils.showPrice(this.productNewArrivals.getCurrencySymbol(), this.productNewArrivals.getProductDiscountPrice()));
            this.tvDiscount.setText(AppUtils.showPrice(this.productNewArrivals.getCurrencySymbol(), this.productNewArrivals.getProductPrice()));
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.productNewArrivals.getProductImage());
            TextView textView = this.tvDiscount;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        }

        public void onClick(View view) {
            if (this.productNewArrivals != null) {
                NewArrivalsAdapter.this.listener.onClickItem(this.productNewArrivals);
            }
        }
    }
}
