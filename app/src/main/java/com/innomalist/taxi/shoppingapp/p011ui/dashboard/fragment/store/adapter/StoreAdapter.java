package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreResult;
import com.innomalist.taxi.shoppingapp.util.GlideUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.customview.MyAdapter;
//import com.kiandashopping.kiandashopping.model.storelist.StoreResult;
//import com.kiandashopping.kiandashopping.util.GlideUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.adapter.StoreAdapter */
public class StoreAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<StoreResult> productLists;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.adapter.StoreAdapter$Listener */
    public interface Listener extends MyAdapter.Listener {
        void onClickItem(StoreResult storeResult);
    }

    public boolean isLoadMoreEnabled() {
        return true;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.adapter.StoreAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a0102;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItem, "field 'tvItem'", TextView.class);
            viewHolder.tvProducts = (TextView) Utils.findRequiredViewAsType(view, R.id.tvProducts, "field 'tvProducts'", TextView.class);
            viewHolder.tvDeals = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDeals, "field 'tvDeals'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.frameLayout, "method 'setOnClick'");
            this.view7f0a0102 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.setOnClick();
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.ivBg = null;
                viewHolder.tvItem = null;
                viewHolder.tvProducts = null;
                viewHolder.tvDeals = null;
                this.view7f0a0102.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0102 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public StoreAdapter(List<StoreResult> list, Listener listener2) {
        super(listener2);
        this.listener = listener2;
        this.productLists = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.productLists.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.adapter.StoreAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362090)
        ImageView ivBg;
        StoreResult storeResult;
        @BindView(2131362362)
        TextView tvDeals;
        @BindView(2131362381)
        TextView tvItem;
        @BindView(2131362398)
        TextView tvProducts;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_store);
        }

        public void update(int i) {
            String str;
            String str2;
            super.update(i);
            StoreResult storeResult2 = (StoreResult) StoreAdapter.this.productLists.get(i);
            this.storeResult = storeResult2;
            this.tvItem.setText(storeResult2.getStoreName());
            TextView textView = this.tvProducts;
            if (this.storeResult.getProductCount().intValue() == 0) {
                str = ResourceUtils.getString(R.string.not_applicable);
            } else {
                str = "" + this.storeResult.getProductCount();
            }
            textView.setText(str);
            TextView textView2 = this.tvDeals;
            if (this.storeResult.getDealCount().intValue() == 0) {
                str2 = ResourceUtils.getString(R.string.not_applicable);
            } else {
                str2 = "" + this.storeResult.getDealCount();
            }
            textView2.setText(str2);
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (int) R.color.white, this.storeResult.getStoreImg());
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362050})
        public void setOnClick() {
            StoreAdapter.this.listener.onClickItem(this.storeResult);
        }
    }
}
