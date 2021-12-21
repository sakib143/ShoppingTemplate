package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.google.android.material.tabs.TabLayout;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.Indicator_ViewBinding */
public class Indicator_ViewBinding implements Unbinder {
    private Indicator target;

    public Indicator_ViewBinding(Indicator indicator, View view) {
        this.target = indicator;
        indicator.f228tl = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tl, "field 'tl'", TabLayout.class);
    }

    public void unbind() {
        Indicator indicator = this.target;
        if (indicator != null) {
            this.target = null;
            indicator.f228tl = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
