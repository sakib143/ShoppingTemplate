package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.model.bycategory.SubCategoryList;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.CategoryAdapter */
public class CategoryAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<SubCategoryList> objectList;

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.CategoryAdapter$Listener */
    public interface Listener {
        void onClickCategory(SubCategoryList subCategoryList);
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.CategoryAdapter$ViewHolder_ViewBinding */
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

    CategoryAdapter(List<SubCategoryList> list, Listener listener2) {
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

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.CategoryAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131361934)
        CircleView circleView;
        @BindView(2131362090)
        ImageView ivBg;
        SubCategoryList subCategoryList;
        @BindView(2131362356)
        TextView tvCategory;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_category);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            SubCategoryList subCategoryList2 = (SubCategoryList) CategoryAdapter.this.objectList.get(i);
            this.subCategoryList = subCategoryList2;
            this.tvCategory.setText(subCategoryList2.getSubCategoryName());
            this.circleView.setBackgroundColor(ResourceUtils.getColor((int) R.color.white));
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.subCategoryList.getSubCategoryImage());
        }

        public void onClick(View view) {
            if (this.subCategoryList != null) {
                CategoryAdapter.this.listener.onClickCategory(this.subCategoryList);
            }
        }
    }
}
