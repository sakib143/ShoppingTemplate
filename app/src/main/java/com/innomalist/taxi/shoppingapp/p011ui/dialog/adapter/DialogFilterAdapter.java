package com.innomalist.taxi.shoppingapp.p011ui.dialog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.model.viewall.ProductFilter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.model.viewall.ProductFilter;
//import com.kiandashopping.kiandashopping.p011ui.dialog.adapter.DialogFilterAdapter;
import java.util.ArrayList;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogFilterAdapter */
public class DialogFilterAdapter extends RecyclerView.Adapter<DialogFilterAdapter.ViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<ProductFilter> arrayList;
    /* access modifiers changed from: private */
    public FilterByListener filterByListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogFilterAdapter$FilterByListener */
    public interface FilterByListener {
        void setFilter(int i, ProductFilter.FilterType filterType);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogFilterAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.radioButton = (RadioButton) Utils.findRequiredViewAsType(view, R.id.radio, "field 'radioButton'", RadioButton.class);
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.radioButton = null;
                viewHolder.tvTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogFilterAdapter(FilterByListener filterByListener2, ArrayList<ProductFilter> arrayList2) {
        this.arrayList = arrayList2;
        this.filterByListener = filterByListener2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_filter, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.radioButton.setText(this.arrayList.get(i).getSortBy());
        viewHolder.tvTitle.setText(this.arrayList.get(i).getSortBy());
        viewHolder.radioButton.setChecked(this.arrayList.get(i).isChecked());
        int i2 = 0;
        viewHolder.tvTitle.setVisibility(this.arrayList.get(i).getFilterType() == ProductFilter.FilterType.HEADER ? 0 : 8);
        RadioButton radioButton = viewHolder.radioButton;
        if (this.arrayList.get(i).getFilterType() == ProductFilter.FilterType.HEADER) {
            i2 = 8;
        }
        radioButton.setVisibility(i2);
    }

    public int getItemCount() {
        return this.arrayList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogFilterAdapter$ViewHolder */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362224)
        RadioButton radioButton;
        @BindView(2131362420)
        TextView tvTitle;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DialogFilterAdapter.ViewHolder.this.lambda$new$0$DialogFilterAdapter$ViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$DialogFilterAdapter$ViewHolder(View view) {
            DialogFilterAdapter.this.filterByListener.setFilter(getAdapterPosition(), ((ProductFilter) DialogFilterAdapter.this.arrayList.get(getAdapterPosition())).getFilterType());
        }
    }
}
