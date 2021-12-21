package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.github.florent37.shapeofview.shapes.CircleView;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.dashboard.CategoryDetail;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.CategoryAdapter */
public class CategoryAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<CategoryDetail> objectList;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.CategoryAdapter$Listener */
    public interface Listener {
        void onAllDeals();

        void onClickCategory(CategoryDetail categoryDetail);
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.CategoryAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvCategory = (TextView) Utils.findRequiredViewAsType(view, R.id.tvCategory, "field 'tvCategory'", TextView.class);
            viewHolder.circleView = (CircleView) Utils.findRequiredViewAsType(view, R.id.circleView, "field 'circleView'", CircleView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.ivBg = null;
                viewHolder.tvCategory = null;
                viewHolder.circleView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    CategoryAdapter(List<CategoryDetail> list, Listener listener2) {
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

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.CategoryAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        CategoryDetail cateogryList;
        @BindView(2131361934)
        CircleView circleView;
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362356)
        TextView tvCategory;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_category);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            CategoryDetail categoryDetail = (CategoryDetail) CategoryAdapter.this.objectList.get(i);
            this.cateogryList = categoryDetail;
            this.tvCategory.setText(categoryDetail.getCategoryName());
            if (this.cateogryList.getCategoryName().equals(ResourceUtils.getString(R.string.deals))) {
                this.ivBg.setImageResource(R.drawable.ic_hand_shake);
                this.ivBg.setBackgroundColor(ResourceUtils.getColor((int) R.color.deals_color));
                this.circleView.setBorderColor(ResourceUtils.getColor((int) R.color.deals_color));
                return;
            }
            this.ivBg.setBackgroundColor(ResourceUtils.getColor((int) R.color.white));
            this.circleView.setBorderColor(ResourceUtils.getColor((int) R.color.white));
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.cateogryList.getCategoryImage());
        }

        public void onClick(View view) {
            CategoryDetail categoryDetail = this.cateogryList;
            if (categoryDetail == null) {
                return;
            }
            if (categoryDetail.getCategoryName().equals(ResourceUtils.getString(R.string.deals))) {
                CategoryAdapter.this.listener.onAllDeals();
            } else {
                CategoryAdapter.this.listener.onClickCategory(this.cateogryList);
            }
        }
    }
}
