package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.devs.vectorchildfinder.VectorChildFinder;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductSizeDetail;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SizeAdapter */
public class SizeAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<ProductSizeDetail> objectList;
    /* access modifiers changed from: private */
    public int selectedPosition = -1;

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SizeAdapter$Listener */
    public interface Listener {
        void onClickSize(int i, int i2);
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SizeAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tvCategory = (TextView) Utils.findRequiredViewAsType(view, R.id.tvCategory, "field 'tvCategory'", TextView.class);
            viewHolder.ivCategory = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivCategory, "field 'ivCategory'", ImageView.class);
            viewHolder.ivShadow = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivShadow, "field 'ivShadow'", ImageView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tvCategory = null;
                viewHolder.ivCategory = null;
                viewHolder.ivShadow = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setPosition(int i) {
        this.selectedPosition = i;
    }

    SizeAdapter(List<ProductSizeDetail> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.listener = listener2;
        this.objectList = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.objectList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SizeAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131362091)
        ImageView ivCategory;
        @BindView(2131362105)
        ImageView ivShadow;
        ProductSizeDetail sizeDetails;
        @BindView(2131362356)
        TextView tvCategory;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_size);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            ProductSizeDetail productSizeDetail = (ProductSizeDetail) SizeAdapter.this.objectList.get(i);
            this.sizeDetails = productSizeDetail;
            this.tvCategory.setText(productSizeDetail.getSizeName());
            if (SizeAdapter.this.selectedPosition == i) {
                this.ivCategory.setImageResource(R.drawable.ic_active_color);
                new VectorChildFinder(BaseApplication.getContext(), R.drawable.ic_active_color, this.ivCategory).findPathByName("path2").setFillColor(ResourceUtils.getColor((int) R.color.colorAccent));
                this.ivShadow.setVisibility(0);
                return;
            }
            this.ivCategory.setImageResource(R.drawable.ic_size_inactive);
            this.ivShadow.setVisibility(8);
        }

        public void onClick(View view) {
            if (this.sizeDetails != null) {
                SizeAdapter.this.listener.onClickSize(this.sizeDetails.getProductSizeId().intValue(), getAdapterPosition());
            }
        }
    }
}
