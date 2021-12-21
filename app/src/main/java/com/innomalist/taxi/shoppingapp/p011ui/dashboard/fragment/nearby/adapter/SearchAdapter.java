package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.model.nearme.NearByResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.adapter.SearchAdapter */
public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    private Listener listener;
    /* access modifiers changed from: private */
    public List<NearByResult> nearByResultFiltered;
    /* access modifiers changed from: private */
    public List<NearByResult> nearByResults;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.adapter.SearchAdapter$Listener */
    public interface Listener {
        void onClick(NearByResult nearByResult);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.adapter.SearchAdapter$ItemVH_ViewBinding */
    public class ItemVH_ViewBinding implements Unbinder {
        private ItemVH target;

        public ItemVH_ViewBinding(ItemVH itemVH, View view) {
            this.target = itemVH;
            itemVH.tvStoreName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvStoreName, "field 'tvStoreName'", TextView.class);
        }

        public void unbind() {
            ItemVH itemVH = this.target;
            if (itemVH != null) {
                this.target = null;
                itemVH.tvStoreName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SearchAdapter(List<NearByResult> list, Listener listener2) {
        this.nearByResults = list;
        this.nearByResultFiltered = list;
        this.listener = listener2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return getViewHolder(viewGroup, LayoutInflater.from(viewGroup.getContext()));
    }

    private RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        return new ItemVH(layoutInflater.inflate(R.layout.item_store_search, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        NearByResult nearByResult = this.nearByResultFiltered.get(i);
        ((ItemVH) viewHolder).tvStoreName.setText(nearByResult.getStoreName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(nearByResult) {
            private final /* synthetic */ NearByResult f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                SearchAdapter.this.lambda$onBindViewHolder$0$SearchAdapter(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$SearchAdapter(NearByResult nearByResult, View view) {
        this.listener.onClick(nearByResult);
    }

    public int getItemCount() {
        List<NearByResult> list = this.nearByResultFiltered;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    SearchAdapter searchAdapter = SearchAdapter.this;
                    List unused = searchAdapter.nearByResultFiltered = searchAdapter.nearByResults;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (NearByResult nearByResult : SearchAdapter.this.nearByResults) {
                        if (nearByResult.getStoreName() != null && nearByResult.getStoreName().toLowerCase().contains(charSequence2.toLowerCase())) {
                            arrayList.add(nearByResult);
                        }
                    }
                    List unused2 = SearchAdapter.this.nearByResultFiltered = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = SearchAdapter.this.nearByResultFiltered;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = SearchAdapter.this.nearByResultFiltered = (ArrayList) filterResults.values;
                SearchAdapter.this.notifyDataSetChanged();
            }
        };
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.adapter.SearchAdapter$ItemVH */
    class ItemVH extends RecyclerView.ViewHolder {
        @BindView(2131362416)
        TextView tvStoreName;

        ItemVH(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }
}
