package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.R;

import butterknife.Unbinder;
import butterknife.internal.Utils;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.MainCategoryFragment_ViewBinding */
public class MainCategoryFragment_ViewBinding implements Unbinder {
    private MainCategoryFragment target;

    public MainCategoryFragment_ViewBinding(MainCategoryFragment mainCategoryFragment, View view) {
        this.target = mainCategoryFragment;
        mainCategoryFragment.f224rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        MainCategoryFragment mainCategoryFragment = this.target;
        if (mainCategoryFragment != null) {
            this.target = null;
            mainCategoryFragment.f224rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
