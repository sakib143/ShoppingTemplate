package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.itemdetails.SpecValue;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecAdapter */
public class SpecAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    private MyAdapter.Listener listener;
    /* access modifiers changed from: private */
    public List<SpecValue> objectList;

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tvSpec = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSpec, "field 'tvSpec'", TextView.class);
            viewHolder.tvSpecValue = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSpecValue, "field 'tvSpecValue'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tvSpec = null;
                viewHolder.tvSpecValue = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    SpecAdapter(List<SpecValue> list) {
        super((MyAdapter.Listener) null);
        this.objectList = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.objectList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        SpecValue specValue;
        @BindView(2131362412)
        TextView tvSpec;
        @BindView(2131362413)
        TextView tvSpecValue;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_spec_item);
        }

        public void update(int i) {
            super.update(i);
            SpecValue specValue2 = (SpecValue) SpecAdapter.this.objectList.get(i);
            this.specValue = specValue2;
            this.tvSpecValue.setText(specValue2.getSpecValue());
            TextView textView = this.tvSpec;
            textView.setText(this.specValue.getSpecName() + " : ");
        }
    }
}
