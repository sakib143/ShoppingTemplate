package com.innomalist.taxi.shoppingapp.p011ui.allcategory.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.R;

import butterknife.Unbinder;
import butterknife.internal.Utils;

/* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.activity.AllCategoryActivity_ViewBinding */
public class AllCategoryActivity_ViewBinding implements Unbinder {
    private AllCategoryActivity target;

    public AllCategoryActivity_ViewBinding(AllCategoryActivity allCategoryActivity) {
        this(allCategoryActivity, allCategoryActivity.getWindow().getDecorView());
    }

    public AllCategoryActivity_ViewBinding(AllCategoryActivity allCategoryActivity, View view) {
        this.target = allCategoryActivity;
        allCategoryActivity.f222rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        AllCategoryActivity allCategoryActivity = this.target;
        if (allCategoryActivity != null) {
            this.target = null;
            allCategoryActivity.f222rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
