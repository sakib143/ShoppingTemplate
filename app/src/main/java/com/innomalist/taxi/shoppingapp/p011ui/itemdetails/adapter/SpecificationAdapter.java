package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductSpecificationDetail;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecificationAdapter */
public class SpecificationAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public List<ProductSpecificationDetail> productReviewList;

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecificationAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tvGroup = (TextView) Utils.findRequiredViewAsType(view, R.id.tvGroup, "field 'tvGroup'", TextView.class);
            viewHolder.f251rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tvGroup = null;
                viewHolder.f251rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SpecificationAdapter(List<ProductSpecificationDetail> list) {
        super((MyAdapter.Listener) null);
        this.productReviewList = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.productReviewList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecificationAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f251rv;
        SpecAdapter specAdapter;
        ProductSpecificationDetail specification;
        @BindView(2131362375)
        TextView tvGroup;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_spec_group);
        }

        public void update(int i) {
            super.update(i);
            ProductSpecificationDetail productSpecificationDetail = (ProductSpecificationDetail) SpecificationAdapter.this.productReviewList.get(i);
            this.specification = productSpecificationDetail;
            this.tvGroup.setText(productSpecificationDetail.getSpecGrpName());
            SpecAdapter specAdapter2 = this.specAdapter;
            if (specAdapter2 == null) {
                SpecAdapter specAdapter3 = new SpecAdapter(this.specification.getSpecValue());
                this.specAdapter = specAdapter3;
                this.f251rv.setAdapter(specAdapter3);
                return;
            }
            specAdapter2.notifyDataSetChanged();
        }
    }
}
