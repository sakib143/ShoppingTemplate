package com.kiandashopping.kiandashopping.p011ui.dialog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.model.viewall.ProductSortBy;
import com.kiandashopping.kiandashopping.p011ui.dialog.adapter.DialogSortByAdapter;
import java.util.ArrayList;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogSortByAdapter */
public class DialogSortByAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<ProductSortBy> arrayList;
    /* access modifiers changed from: private */
    public SortByListener sortByListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogSortByAdapter$SortByListener */
    public interface SortByListener {
        void setSort(int i);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogSortByAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.radioButton = (RadioButton) Utils.findRequiredViewAsType(view, R.id.radio, "field 'radioButton'", RadioButton.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.radioButton = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogSortByAdapter(SortByListener sortByListener2, ArrayList<ProductSortBy> arrayList2) {
        this.arrayList = arrayList2;
        this.sortByListener = sortByListener2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sort_by, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.radioButton.setText(this.arrayList.get(i).getSortBy());
        viewHolder.radioButton.setChecked(this.arrayList.get(i).isChecked());
    }

    public int getItemCount() {
        return this.arrayList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.adapter.DialogSortByAdapter$ViewHolder */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362224)
        RadioButton radioButton;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DialogSortByAdapter.ViewHolder.this.lambda$new$0$DialogSortByAdapter$ViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$DialogSortByAdapter$ViewHolder(View view) {
            DialogSortByAdapter.this.sortByListener.setSort(getAdapterPosition());
        }
    }
}
