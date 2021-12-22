package com.innomalist.taxi.shoppingapp.p011ui.storedetails.fragment.deals;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.R;

import butterknife.Unbinder;
import butterknife.internal.Utils;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.deals.DealsFragment_ViewBinding */
public class DealsFragment_ViewBinding implements Unbinder {
    private DealsFragment target;

    public DealsFragment_ViewBinding(DealsFragment dealsFragment, View view) {
        this.target = dealsFragment;
        dealsFragment.f257rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        DealsFragment dealsFragment = this.target;
        if (dealsFragment != null) {
            this.target = null;
            dealsFragment.f257rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
