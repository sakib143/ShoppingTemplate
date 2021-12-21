package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.model.dashboard.ProductTopOffer;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.OfferAdapter */
public class OfferAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    Listener listener;
    List<ProductTopOffer> offerDetails;

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.OfferAdapter$Listener */
    public interface Listener {
        void onClickItem(ProductTopOffer productTopOffer);
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.OfferAdapter$ViewHolder_ViewBinding */
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

    public OfferAdapter(List<ProductTopOffer> list, Listener listener2) {
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

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.OfferAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362050)
        FrameLayout ivNext;
        ProductTopOffer offerDetail;
        @BindView(2131362369)
        TextView tvDiscount;
        @BindView(2131362370)
        TextView tvDiscountDetails;
        @BindView(2131362381)
        TextView tvItem;
        @BindView(2131362396)
        TextView tvPrice;

        public ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_top_offer);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            this.offerDetail = OfferAdapter.this.offerDetails.get(i);
            this.tvItem.setSelected(true);
            this.tvItem.setText(this.offerDetail.getProductTitle());
            this.tvPrice.setText(AppUtils.showPrice(this.offerDetail.getCurrencySymbol(), this.offerDetail.getProductDiscountPrice()));
            this.tvDiscount.setText(AppUtils.showPrice(this.offerDetail.getCurrencySymbol(), this.offerDetail.getProductPrice()));
            this.tvDiscountDetails.setText(AppUtils.append(this.offerDetail.getProductPercentage().intValue(), ResourceUtils.getString(R.string.off_text)));
            this.tvDiscountDetails.setVisibility(this.offerDetail.getProductPercentage().intValue() == 0 ? 8 : 0);
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.offerDetail.getProductImage());
            TextView textView = this.tvDiscount;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        }

        public void onClick(View view) {
            if (this.offerDetail != null) {
                OfferAdapter.this.listener.onClickItem(this.offerDetail);
            }
        }
    }
}
