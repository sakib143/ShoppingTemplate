package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.itemdetails.RelatedProduct;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.RelatedProductAdapter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.RelatedProductAdapter */
public class RelatedProductAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<RelatedProduct> relatedProducts;

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.RelatedProductAdapter$Listener */
    public interface Listener {
        void onClickItem(RelatedProduct relatedProduct);
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.RelatedProductAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItem, "field 'tvItem'", TextView.class);
            viewHolder.tvDiscountDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscountDetails, "field 'tvDiscountDetails'", TextView.class);
            viewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            viewHolder.tvDiscount = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscount, "field 'tvDiscount'", TextView.class);
            viewHolder.btnAdd = (Button) Utils.findRequiredViewAsType(view, R.id.btnAdd, "field 'btnAdd'", Button.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.ivBg = null;
                viewHolder.tvItem = null;
                viewHolder.tvDiscountDetails = null;
                viewHolder.tvPrice = null;
                viewHolder.tvDiscount = null;
                viewHolder.btnAdd = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public RelatedProductAdapter(List<RelatedProduct> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.listener = listener2;
        this.relatedProducts = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.relatedProducts.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.RelatedProductAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131361897)
        Button btnAdd;
        @BindView(2131362090)
        ImageView ivBg;
        RelatedProduct relatedProduct;
        @BindView(2131362369)
        TextView tvDiscount;
        @BindView(2131362370)
        TextView tvDiscountDetails;
        @BindView(2131362381)
        TextView tvItem;
        @BindView(2131362396)
        TextView tvPrice;

        public ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_top50);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            RelatedProduct relatedProduct2 = (RelatedProduct) RelatedProductAdapter.this.relatedProducts.get(i);
            this.relatedProduct = relatedProduct2;
            this.tvItem.setText(relatedProduct2.getProductTitle());
            this.tvPrice.setText(AppUtils.showPrice(this.relatedProduct.getCurrencySymbol(), this.relatedProduct.getProductDiscountPrice()));
            this.tvDiscount.setText(AppUtils.showPrice(this.relatedProduct.getCurrencySymbol(), this.relatedProduct.getProductPrice()));
            this.tvDiscountDetails.setText(AppUtils.append(this.relatedProduct.getProductPercentage().intValue(), ResourceUtils.getString(R.string.off_text)));
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.relatedProduct.getProductImage());
            TextView textView = this.tvDiscount;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            this.btnAdd.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    RelatedProductAdapter.ViewHolder.this.lambda$update$0$RelatedProductAdapter$ViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$update$0$RelatedProductAdapter$ViewHolder(View view) {
            RelatedProductAdapter.this.listener.onClickItem(this.relatedProduct);
        }

        public void onClick(View view) {
            if (this.relatedProduct != null) {
                RelatedProductAdapter.this.listener.onClickItem(this.relatedProduct);
            }
        }
    }
}
