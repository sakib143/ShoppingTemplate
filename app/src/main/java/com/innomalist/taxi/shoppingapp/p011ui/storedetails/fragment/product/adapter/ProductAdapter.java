package com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.product.adapter;

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
import com.kiandashopping.kiandashopping.model.storelist.ProductListByShop;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.product.adapter.ProductAdapter */
public class ProductAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<ProductListByShop> productLists;

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.product.adapter.ProductAdapter$Listener */
    public interface Listener {
        void onClickItem(ProductListByShop productListByShop);
    }

    public boolean isLoadMoreEnabled() {
        return true;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.product.adapter.ProductAdapter$ViewHolder_ViewBinding */
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

    public ProductAdapter(List<ProductListByShop> list, Listener listener2) {
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

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.product.adapter.ProductAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362050)
        FrameLayout ivNext;
        ProductListByShop productListByShop;
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
            this.productListByShop = (ProductListByShop) ProductAdapter.this.productLists.get(i);
            this.tvItem.setSelected(true);
            this.tvItem.setText(this.productListByShop.getProductTitle());
            this.tvPrice.setText(AppUtils.showPrice(this.productListByShop.getCurrencySymbol(), this.productListByShop.getProductDiscountPrice()));
            this.tvDiscount.setText(AppUtils.showPrice(this.productListByShop.getCurrencySymbol(), this.productListByShop.getProductPrice()));
            this.tvDiscountDetails.setText(AppUtils.append(this.productListByShop.getProductPercentage().intValue(), ResourceUtils.getString(R.string.off_text)));
            this.tvDiscountDetails.setVisibility(this.productListByShop.getProductPercentage().intValue() == 0 ? 8 : 0);
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.productListByShop.getProductImage());
            TextView textView = this.tvDiscount;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        }

        public void onClick(View view) {
            if (this.productListByShop != null) {
                ProductAdapter.this.listener.onClickItem(this.productListByShop);
            }
        }
    }
}
